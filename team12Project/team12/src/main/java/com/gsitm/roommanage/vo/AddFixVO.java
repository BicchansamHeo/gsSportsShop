package com.gsitm.roommanage.vo;

public class AddFixVO {
	
	private String fixNo;
	private String roomNo;
	private int quantity;
	public String getFixNo() {
		return fixNo;
	}
	public void setFixNo(String fixNo) {
		this.fixNo = fixNo;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "addFixVO [fixNo=" + fixNo + ", roomNo=" + roomNo + ", quantity=" + quantity + "]";
	}

}
