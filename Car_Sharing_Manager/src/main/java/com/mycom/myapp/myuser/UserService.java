package com.mycom.myapp.myuser;

import java.util.List;

public interface UserService {
	public int insertUser(UserVO vo);
	public int deleteUser(int id);
	public int updateUser(UserVO vo);
	public UserVO getUser(int seq);
	public UserVO getUserLoginInfo(UserVO vo);
	public List<UserVO> getUserList();
	public List<UserVO> getRoomUserList(int num);
	public int updateRoomNum(UserVO vo);
	public int updatePayment(UserVO vo);
	public int updateBlack(UserVO vo);
}
