package com.laf.dto;

import java.sql.Date;

public class LostDto {

	private String 	lNo;
	private String 	lTitle;
	private String 	lContent;
	private String 	mId;
	private Date 	lRdate;
	private String 	lOb;
	private String 	lLocal;
	private String 	lLocation;
	private Date 	lDate;
	private String 	lPhoto;
	private int 	lHit;
	private String 	lTel;
	private String 	lIp;
	private String 	mName;
	private String 	lstCode;
	private String 	lcc;
	
	
	public LostDto() {
		
	}


	public LostDto(String lNo, String lTitle, String lContent, String mId, Date lRdate, String lOb, String lLocal,
			String lLocation, Date lDate, String lPhoto, int lHit, String lTel, String lIp, String mName,
			String lstCode, String lcc) {
		this.lNo = lNo;
		this.lTitle = lTitle;
		this.lContent = lContent;
		this.mId = mId;
		this.lRdate = lRdate;
		this.lOb = lOb;
		this.lLocal = lLocal;
		this.lLocation = lLocation;
		this.lDate = lDate;
		this.lPhoto = lPhoto;
		this.lHit = lHit;
		this.lTel = lTel;
		this.lIp = lIp;
		this.mName = mName;
		this.lstCode = lstCode;
		this.lcc = lcc;
	}


	public String getlNo() {
		return lNo;
	}


	public void setlNo(String lNo) {
		this.lNo = lNo;
	}


	public String getlTitle() {
		return lTitle;
	}


	public void setlTitle(String lTitle) {
		this.lTitle = lTitle;
	}


	public String getlContent() {
		return lContent;
	}


	public void setlContent(String lContent) {
		this.lContent = lContent;
	}


	public String getmId() {
		return mId;
	}


	public void setmId(String mId) {
		this.mId = mId;
	}


	public Date getlRdate() {
		return lRdate;
	}


	public void setlRdate(Date lRdate) {
		this.lRdate = lRdate;
	}


	public String getlOb() {
		return lOb;
	}


	public void setlOb(String lOb) {
		this.lOb = lOb;
	}


	public String getlLocal() {
		return lLocal;
	}


	public void setlLocal(String lLocal) {
		this.lLocal = lLocal;
	}


	public String getlLocation() {
		return lLocation;
	}


	public void setlLocation(String lLocation) {
		this.lLocation = lLocation;
	}


	public Date getlDate() {
		return lDate;
	}


	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}


	public String getlPhoto() {
		return lPhoto;
	}


	public void setlPhoto(String lPhoto) {
		this.lPhoto = lPhoto;
	}


	public int getlHit() {
		return lHit;
	}


	public void setlHit(int lHit) {
		this.lHit = lHit;
	}


	public String getlTel() {
		return lTel;
	}


	public void setlTel(String lTel) {
		this.lTel = lTel;
	}


	public String getlIp() {
		return lIp;
	}


	public void setlIp(String lIp) {
		this.lIp = lIp;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getLstCode() {
		return lstCode;
	}


	public void setLstCode(String lstCode) {
		this.lstCode = lstCode;
	}


	public String getLcc() {
		return lcc;
	}


	public void setLcc(String lcc) {
		this.lcc = lcc;
	}
	
	
}
