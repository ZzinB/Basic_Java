package com.mycom.myapp.room;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.myapp.board.BoardVO;

@Repository
public class RoomDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	// make room
	public int insertRoom(RoomVO vo) {
		int result = sqlSession.insert("Room.insertRoom", vo);
		return result;
	}

	// update room info ex) room_count
	public int updateRoom(RoomVO vo) {
		int result = sqlSession.insert("Room.updateRoom", vo);
		return result;
	}

	public int deleteRoom(int id) {
		int result = sqlSession.insert("Room.deleteRoom", id);
		return result;
	}

	public RoomVO getRoom(int seq) {
		RoomVO one = sqlSession.selectOne("Room.getRoom", seq);
		return one;
	}

	// in detail page, get one room
	public RoomVO getRoomFromMaster(int room_master) {
		RoomVO one = sqlSession.selectOne("Room.getRoomFromMaster", room_master);
		return one;
	}
	
	// in main page
	public List<RoomVO> getRoomList() {
		List<RoomVO> list = sqlSession.selectList("Room.getRoomList");
		return list;
	}
	
	public int updateRoomCount(RoomVO rvo) {
		int result = sqlSession.insert("Room.updateRoomCount", rvo);
		return result;
	}
	
	
}
