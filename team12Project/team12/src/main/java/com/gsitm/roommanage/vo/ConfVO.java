package com.gsitm.roommanage.vo;

public class ConfVO {
	
	private String siteNo;
	private String roomNo;
	private String confName;
	private String confAddr;
	private String roomComm;
	private String roomKind;
	private int roomPrice;
	private String roomSize;
	private int maxPeople;
	private String network;
	private String roomState;
	private String longitude;
	private String latitude;
	private String mainImgPath;
	
	



	public String getMainImgPath() {
		return mainImgPath;
	}


	public void setMainImgPath(String mainImgPath) {
		this.mainImgPath = mainImgPath;
	}


	public String getSiteNo() {
		return siteNo;
	}


	public void setSiteNo(String siteNo) {
		this.siteNo = siteNo;
	}


	public String getRoomNo() {
		return roomNo;
	}


	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getConfName() {
		return confName;
	}


	public void setConfName(String confName) {
		this.confName = confName;
	}
	

	public String getConfAddr() {
		return confAddr;
	}


	public void setConfAddr(String confAddr) {
		this.confAddr = confAddr;
	}


	public String getRoomComm() {
		return roomComm;
	}


	public void setRoomComm(String roomComm) {
		this.roomComm = roomComm;
	}


	public String getRoomKind() {
		return roomKind;
	}


	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}


	public String getRoomSize() {
		return roomSize;
	}


	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}


	public int getRoomPrice() {
		return roomPrice;
	}


	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}



	public int getMaxPeople() {
		return maxPeople;
	}


	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}


	public String getNetwork() {
		return network;
	}


	public void setNetwork(String network) {
		this.network = network;
	}


	public String getRoomState() {
		return roomState;
	}


	public void setRoomState(String roomState) {
		this.roomState = roomState;
	}


	@Override
	public String toString() {
		return "ConfVO [siteNo=" + siteNo + ", roomNo=" + roomNo + ", confName=" + confName + ", confAddr=" + confAddr
				+ ", roomComm=" + roomComm + ", roomKind=" + roomKind + ", roomPrice=" + roomPrice + ", roomSize="
				+ roomSize + ", maxPeople=" + maxPeople + ", network=" + network + ", roomState=" + roomState
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", mainImgPath=" + mainImgPath + "]";
	}








}
