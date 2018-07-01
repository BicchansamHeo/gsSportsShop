package com.gsitm.roommanage.vo;

public class UdConfVO {
	
	private String roomNo;
	private String confName;
	private String roomComm;
	private int roomPrice;
	private String network;
	private String mainImgPath;
	
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getConfName() {
		return confName;
	}
	public void setConfName(String confName) {
		this.confName = confName;
	}
	public String getRoomComm() {
		return roomComm;
	}
	public void setRoomComm(String roomComm) {
		this.roomComm = roomComm;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getMainImgPath() {
		return mainImgPath;
	}
	public void setMainImgPath(String mainImgPath) {
		this.mainImgPath = mainImgPath;
	}
	@Override
	public String toString() {
		return "UdConfVO [roomNo=" + roomNo + ", confName=" + confName + ", roomComm=" + roomComm + ", roomPrice="
				+ roomPrice + ", network=" + network + ", mainImgPath=" + mainImgPath + "]";
	}


	



	






}
