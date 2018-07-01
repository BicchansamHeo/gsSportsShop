package com.gsitm.roommanage.vo;

public class PagingSiteVO {
	
	private int index;
	private int defaultNum;
	private String siteNo;
	private String siteName;
	private String siteAddr;
	
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
	public String getSiteNo() {
		return siteNo;
	}
	public void setSiteNo(String siteNo) {
		this.siteNo = siteNo;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public String getSiteAddr() {
		return siteAddr;
	}
	public void setSiteAddr(String siteAddr) {
		this.siteAddr = siteAddr;
	}
	@Override
	public String toString() {
		return "PagingSiteVO [index=" + index + ", defaultNum=" + defaultNum + ", siteNo=" + siteNo + ", siteName="
				+ siteName + ", siteAddr=" + siteAddr + "]";
	}


	
	
	
	
	
	

}
