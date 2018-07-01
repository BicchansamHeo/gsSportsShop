package com.gsitm.roommanage.vo;

public class FixVO {
	
	private String fixNo;
	private String fixName;
	private int price;
	public String getFixNo() {
		return fixNo;
	}
	public void setFixNo(String fixNo) {
		this.fixNo = fixNo;
	}
	public String getFixName() {
		return fixName;
	}
	public void setFixName(String fixName) {
		this.fixName = fixName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "FixVO [fixNo=" + fixNo + ", fixName=" + fixName + ", price=" + price + "]";
	}
	
	

	
	
	




}
