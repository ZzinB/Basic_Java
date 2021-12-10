package com.mycom.myapp.room;

import java.util.List;

public interface RoomService {
	public int insertRoom(RoomVO vo);
	public int deleteRoom(int id);
	public int updateRoom(RoomVO vo);
	public RoomVO getRoom(int seq);
	public List<RoomVO> getRoomList();
}
