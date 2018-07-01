package com.gsitm.roommanage.vo;

public class ImgVO {
	
	private String roomName;
	private String imgPath;
	private String imgName;
	private String roomNo;
	
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Override
	public String toString() {
		return "ImgVO [roomName=" + roomName + ", imgPath=" + imgPath + ", imgName=" + imgName + ", roomNo=" + roomNo
				+ "]";
	}
	
	
	
	
	
	




}
