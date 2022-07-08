package com.laf.dto;

import java.sql.Date;

public class FindDto {

	private String 	fNo;
	private String 	fTitle;
	private String 	fContent;
	private String 	mId;
	private Date 	fRdate;
	private String 	fOb;
	private String 	fLocal;
	private String 	fLocation;
	private Date 	fDate;
	private String	fStorage;
	private String 	fPhoto;
	private int 	fHit;
	private String 	fTel;
	private String 	fIp;
	private String 	mName;
	private String 	pwCode;
	private String	fstCode;
	private String	fcc;
	
	public FindDto() {
		
	}

	public FindDto(String fNo, String fTitle, String fContent, String mId, Date fRdate, String fOb, String fLocal,
			String fLocation, Date fDate, String fStorage, String fPhoto, int fHit, String fTel, String fIp,
			String mName, String pwCode, String fstCode, String fcc) {
		this.fNo = fNo;
		this.fTitle = fTitle;
		this.fContent = fContent;
		this.mId = mId;
		this.fRdate = fRdate;
		this.fOb = fOb;
		this.fLocal = fLocal;
		this.fLocation = fLocation;
		this.fDate = fDate;
		this.fStorage = fStorage;
		this.fPhoto = fPhoto;
		this.fHit = fHit;
		this.fTel = fTel;
		this.fIp = fIp;
		this.mName = mName;
		this.pwCode = pwCode;
		this.fstCode = fstCode;
		this.fcc = fcc;
	}

	public String getfNo() {
		return fNo;
	}

	public void setfNo(String fNo) {
		this.fNo = fNo;
	}

	public String getfTitle() {
		return fTitle;
	}

	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}

	public String getfContent() {
		return fContent;
	}

	public void setfContent(String fContent) {
		this.fContent = fContent;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public Date getfRdate() {
		return fRdate;
	}

	public void setfRdate(Date fRdate) {
		this.fRdate = fRdate;
	}

	public String getfOb() {
		return fOb;
	}

	public void setfOb(String fOb) {
		this.fOb = fOb;
	}

	public String getfLocal() {
		return fLocal;
	}

	public void setfLocal(String fLocal) {
		this.fLocal = fLocal;
	}

	public String getfLocation() {
		return fLocation;
	}

	public void setfLocation(String fLocation) {
		this.fLocation = fLocation;
	}

	public Date getfDate() {
		return fDate;
	}

	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}

	public String getfStorage() {
		return fStorage;
	}

	public void setfStorage(String fStorage) {
		this.fStorage = fStorage;
	}

	public String getfPhoto() {
		return fPhoto;
	}

	public void setfPhoto(String fPhoto) {
		this.fPhoto = fPhoto;
	}

	public int getfHit() {
		return fHit;
	}

	public void setfHit(int fHit) {
		this.fHit = fHit;
	}

	public String getfTel() {
		return fTel;
	}

	public void setfTel(String fTel) {
		this.fTel = fTel;
	}

	public String getfIp() {
		return fIp;
	}

	public void setfIp(String fIp) {
		this.fIp = fIp;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getFstCode() {
		return fstCode;
	}

	public void setFstCode(String fstCode) {
		this.fstCode = fstCode;
	}

	public String getFcc() {
		return fcc;
	}

	public void setFcc(String fcc) {
		this.fcc = fcc;
	}

	public String getPwCode() {
		return pwCode;
	}

	public void setPwCode(String pwCode) {
		this.pwCode = pwCode;
	}
	
	
}
