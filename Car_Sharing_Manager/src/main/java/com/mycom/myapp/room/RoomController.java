package com.mycom.myapp.room;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.myapp.board.BoardVO;
import com.mycom.myapp.myuser.UserDAO;
import com.mycom.myapp.myuser.UserService;
import com.mycom.myapp.myuser.UserVO;

@Controller
public class RoomController {
	@Autowired
	RoomService roomService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/room/list", method = RequestMethod.GET)
	public String roomlist(Model model) {
		model.addAttribute("list", roomService.getRoomList());
		return "homepage";
	}
	
	// 방 만들기 버튼 처리
	@RequestMapping(value = "/room/makeRoom/{id}", method = RequestMethod.GET)
	public String roomMake(@PathVariable("id") int id, Model model) {
		UserVO userVO = userService.getUser(id);
		
		if (userVO.getRoom_num() == -1)
		{
			System.out.println("방만들기 요청 처리!");
			model.addAttribute("id", id);		
			return "makeroom";
		}
		
		else // 이미 만든 방이 있다면,
		{
			System.out.println("이미 소속된 방이 있습니다.");
			return "redirect:/room/list";			
		}
		
	}
	
	@RequestMapping(value = "/room/makeok", method = RequestMethod.POST)
	public String roomMakeOK(RoomVO rvo) {
		int i = roomService.insertRoom(rvo);
		RoomVO r = roomService.getRoomFromMaster(rvo.getRoom_master());
		
		if (i==0)
			System.out.println("방 만들기 실패");
		else
		{
			System.out.println("방 만들기 성공!!");
			UserVO uservo = userService.getUser(r.getRoom_master());
			uservo.setRoom_num(r.getRoom_num());
			userService.updateRoomNum(uservo);
			uservo.setPayment(0);
			userService.updatePayment(uservo);
		}
		
		return "redirect:/room/list";
	}
	
	// 방 complete 버튼.
	@RequestMapping(value = "/room/roomok/{id}", method = RequestMethod.GET)
	public String roomOK(@PathVariable("id") int id) {
		UserVO uvo = userService.getUser(id);
		RoomVO rvo = roomService.getRoom(uvo.getRoom_num()); // 현재 방 정보
		
		if (rvo.getRoom_master() == uvo.getUid()) // 방장이라면
		{
			List<UserVO> uvo_list = userService.getRoomUserList(rvo.getRoom_num());
			for (int i=0; i< uvo_list.size(); i++)
			{
				System.out.println("uid="+uvo_list.get(i).getUid());
				resetUserInfo(uvo_list.get(i).getUid());
			}
			System.out.println("유저 정보 초기화 완료.");
			
			// 방 정보 삭제
			roomService.deleteRoom(rvo.getRoom_num());
			System.out.println("방 정보 삭제 완료.");
			
			return "redirect:/room/list";			
		}
		else // 방장이 아니라면,
		{
			System.out.println("권한 없음");
			return "redirect:/room/enter/"+rvo.getRoom_num()+"/"+id;
		}
	}
	
	// user 정보 초기화.
	public void resetUserInfo(int uid) {
		UserVO uvo = userService.getUser(uid);
		
		// room 정보 초기화
		uvo.setRoom_num(-1);
		userService.updateRoomNum(uvo);
		
		// black을 더해줌. (입금 안했으면 getPayment값이 1이기 때문에 1 증가함.)
		uvo.setBlack(uvo.getPayment() + uvo.getBlack());
		userService.updateBlack(uvo);
		
		// 입금여부 초기화.
		uvo.setPayment(1);
		userService.updatePayment(uvo);
	}
	
	// 추방 로직
	@RequestMapping(value = "/room/deleteok/{s_id}/{r_id}", method = RequestMethod.GET)
	public String roomDeleteOK(@PathVariable("s_id") int send_id, @PathVariable("r_id") int recv_id) {
		System.out.println("send:"+send_id+"recv:"+recv_id);
		UserVO send_uvo = userService.getUser(send_id); // 본인
		UserVO recv_uvo = userService.getUser(recv_id); // 현재 지목된 사람
		RoomVO rvo = roomService.getRoom(recv_uvo.getRoom_num()); // 현재 방 정보
		
		if (rvo.getRoom_master() == recv_uvo.getUid()) // 내가 방장이었다면 (방장이 방장 추방선택)
			System.out.println("추방할 수 없는 상대입니다.(방장 추방 불가)");
		
		else if (send_uvo.getUid() == recv_uvo.getUid())
			System.out.println("추방할 수 없는 상대입니다.(본인 추방 불가)");

		else if ((rvo.getRoom_master() == send_uvo.getUid()) && (send_uvo.getUid() != recv_uvo.getUid())) // 내가 방장인데, sender, recv 다르면
		{
			recv_uvo.setRoom_num(-1);
			userService.updateRoomNum(recv_uvo);
			rvo.setRoom_count(rvo.getRoom_count()-1);
			roomService.updateRoomCount(rvo);
			recv_uvo.setPayment(1);
			userService.updatePayment(recv_uvo);
			System.out.println(recv_uvo.getUname()+"님 추방 완료!");
		}
		else
			System.out.println("잘못된 접근입니다.");
		
		return "redirect:/room/enter/"+rvo.getRoom_num()+"/"+send_uvo.getUid();
	}
	
	// 입금 처리
	@RequestMapping(value = "/room/payok/{s_id}/{r_id}", method = RequestMethod.GET)
	public String roomPayOK(@PathVariable("s_id") int send_id, @PathVariable("r_id") int recv_id) {
		UserVO send_uvo = userService.getUser(send_id); // 본인
		UserVO recv_uvo = userService.getUser(recv_id); // 현재 지목된 사람
		RoomVO rvo = roomService.getRoom(recv_uvo.getRoom_num()); // 현재 방 정보, sender든 receiver든 상관없음. 어차피 서로 같은 방
		
		if (rvo.getRoom_master() == send_uvo.getUid()) // 내가 방장이면,
		{	
			recv_uvo.setPayment(0);
			userService.updatePayment(recv_uvo);	
			System.out.println("입금 처리 완료!");
		}
		else
			System.out.println("권한이 없습니다.");
		return "redirect:/room/enter/"+rvo.getRoom_num()+"/"+send_id;
	}
	
	// 회원정보 수정 
	@RequestMapping(value = "/room/editUser/{id}", method = RequestMethod.GET)
	public String roomEditUser(@PathVariable("id") int id, Model model) {
		System.out.println("Edit user 안");
		
		UserVO userVO = userService.getUser(id);
		model.addAttribute("userVO", userVO);
		
		return "edituser";
	}
	
	@RequestMapping(value = "/room/editok", method = RequestMethod.POST)
	public String editPostOK(UserVO vo) {
		int i = userService.updateUser(vo);
		if (i==0)
			System.out.println("데이터 수정 실패");
		else
			System.out.println("데이터 수정 성공!!");
		return "redirect:../login/login";
	}
	
	// detail page
	@RequestMapping(value = "/room/enter/{num}/{id}", method = RequestMethod.GET)
	public String roomEnter(@PathVariable("num") int num, @PathVariable("id") int id, Model model) {
		RoomVO rvo = roomService.getRoom(num);
		UserVO uvo = userService.getUser(id);

		if ((rvo.getRoom_master() == uvo.getUid()) || (rvo.getRoom_num() == uvo.getRoom_num()))
		{
			// count하지않음. 방장은 바로 입장 혹은 이미 방에 입장권한이 있는 사람은 패스
			System.out.println("이미 권한 있음");
			model.addAttribute("ulist", userService.getRoomUserList(num));
			return "detail";
		}
		else if (uvo.getRoom_num() == -1 && rvo.getRoom_count() < 4)
		{
			// 방 정보가 없고 (방은 1개만 들어갈 수 있음. 무조건 없어야 함) 방 인원이 4명보다 작을 경우.
			System.out.println("권한 ok");
			// uvo에 room_num update하고 user Update
			uvo.setRoom_num(num);
			userService.updateRoomNum(uvo);
			// rvo에 room_count++하고 update
			rvo.setRoom_count(rvo.getRoom_count()+1);
			roomService.updateRoomCount(rvo);
			model.addAttribute("ulist", userService.getRoomUserList(num));
			
			return "detail";
		}
		else
		{
			// 방 입장 금지 메시지
			System.out.println("방 입장 금지!");
			return "redirect:/room/list";
		}
	}
	
}
