package com.mycom.myapp.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomDAO roomDAO;
	
	@Override
	public int insertRoom(RoomVO vo) {
		return roomDAO.insertRoom(vo);
	}
	
	@Override
	public RoomVO getRoom(int seq) {
		return roomDAO.getRoom(seq);
	}
	
	@Override
	public RoomVO getRoomFromMaster(int room_master) {
		return roomDAO.getRoomFromMaster(room_master);
	}
	
	@Override
	public List<RoomVO> getRoomList(){
		return roomDAO.getRoomList();
	}

	@Override
	public int deleteRoom(int id) {
		return roomDAO.deleteRoom(id);
	}

	@Override
	public int updateRoom(RoomVO vo) {
		return roomDAO.updateRoom(vo);
	}
	
	@Override
	public int updateRoomCount(RoomVO rvo) {
		return roomDAO.updateRoomCount(rvo);
	}
}
