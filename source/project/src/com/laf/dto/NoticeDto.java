package com.laf.dto;

import java.sql.Date;

public class NoticeDto {

	private int 	nNo;
	private String 	nTitle;
	private String 	nContent;
	private String 	nFilename;
	private int 	nHit;
	private Date	nDate;
	
	public NoticeDto() {
		
	}
	
	public NoticeDto(int nNo, String nTitle, String nContent, String nFilename, int nHit, Date nDate) {
		this.nNo = nNo;
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nFilename = nFilename;
		this.nHit = nHit;
		this.nDate = nDate;
	}

	public int getnNo() {
		return nNo;
	}

	public void setnNo(int nNo) {
		this.nNo = nNo;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public String getnFilename() {
		return nFilename;
	}

	public void setnFilename(String nFilename) {
		this.nFilename = nFilename;
	}

	public int getnHit() {
		return nHit;
	}

	public void setnHit(int nHit) {
		this.nHit = nHit;
	}

	public Date getnDate() {
		return nDate;
	}

	public void setnDate(Date nDate) {
		this.nDate = nDate;
	}
	
	
}
