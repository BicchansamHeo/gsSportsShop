package com.gsitm.roommanage.vo;

public class PagingVO {
	
	private int index;
	private int defaultNum;
	private String confName;
	private String roomComm;
	private String mainImgPath;
	private String roomKind;
	private String roomNo;
	
	
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomKind() {
		return roomKind;
	}
	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getDefaultNum() {
		return defaultNum;
	}
	public void setDefaultNum(int defaultNum) {
		this.defaultNum = defaultNum;
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
	public String getMainImgPath() {
		return mainImgPath;
	}
	public void setMainImgPath(String mainImgPath) {
		this.mainImgPath = mainImgPath;
	}
	@Override
	public String toString() {
		return "PagingVO [index=" + index + ", defaultNum=" + defaultNum + ", confName=" + confName + ", roomComm="
				+ roomComm + ", mainImgPath=" + mainImgPath + ", roomKind=" + roomKind + "]";
	}
	
	
	
	
	
	

}
