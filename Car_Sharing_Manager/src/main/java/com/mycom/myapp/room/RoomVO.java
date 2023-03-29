package com.mycom.myapp.room;

public class RoomVO {
	private int room_num;
	private boolean room_complete;
	private int room_count;
	private String room_contents;
	private int room_master;
	
	public int getRoom_master() {
		return room_master;
	}
	public void setRoom_master(int room_master) {
		this.room_master = room_master;
	}
	public String getRoom_contents() {
		return room_contents;
	}
	public void setRoom_contents(String room_contents) {
		this.room_contents = room_contents;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int room_num) {
		this.room_num = room_num;
	}
	public boolean isRoom_complete() {
		return room_complete;
	}
	public void setRoom_complete(boolean room_complete) {
		this.room_complete = room_complete;
	}
	public int getRoom_count() {
		return room_count;
	}
	public void setRoom_count(int room_count) {
		this.room_count = room_count;
	}
}
