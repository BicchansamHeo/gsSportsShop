package com.gsitm.roommanage.vo;

public class SiteVO {
	
	private String siteNo;
	private String siteName;
	private String siteAddr;
	private String siteComm;
	private String longitude;
	private String latitude;
	
	
	public String getSiteNo() {
		return siteNo;
	}
	public void setSiteNo(String siteNo) {
		this.siteNo = siteNo;
	}
	public String getSiteComm() {
		return siteComm;
	}
	public void setSiteComm(String siteComm) {
		this.siteComm = siteComm;
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
	@Override
	public String toString() {
		return "SiteVO [siteNo=" + siteNo + ", siteName=" + siteName + ", siteAddr=" + siteAddr + ", siteComm="
				+ siteComm + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}


	
	
	




}
