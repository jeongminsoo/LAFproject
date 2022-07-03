package com.laf.dto;

import java.sql.Date;

public class QnaDto {

	private int 	qNo;
	private String	qTitle;
	private String	qContent;
	private String	mId;
	private	Date	qRdate;
	private int		qHit;
	private int 	qGroup;
	private int		qStep;
	private	int		qIndent;
	private	String	qIp;
	private String  mName;
	
	public QnaDto() {
		
	}

	public QnaDto(int qNo, String qTitle, String qContent, String mId, Date qRdate, int qHit,
			int qGroup, int qStep, int qIndent, String qIp, String mName) {
		this.qNo = qNo;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.mId = mId;
		this.qRdate = qRdate;
		this.qHit = qHit;
		this.qGroup = qGroup;
		this.qStep = qStep;
		this.qIndent = qIndent;
		this.qIp = qIp;
		this.mName = mName;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public Date getqRdate() {
		return qRdate;
	}

	public void setqRdate(Date qRdate) {
		this.qRdate = qRdate;
	}

	public int getqHit() {
		return qHit;
	}

	public void setqHit(int qHit) {
		this.qHit = qHit;
	}

	public int getqGroup() {
		return qGroup;
	}

	public void setqGroup(int qGroup) {
		this.qGroup = qGroup;
	}

	public int getqStep() {
		return qStep;
	}

	public void setqStep(int qStep) {
		this.qStep = qStep;
	}

	public int getqIndent() {
		return qIndent;
	}

	public void setqIndent(int qIndent) {
		this.qIndent = qIndent;
	}

	public String getqIp() {
		return qIp;
	}

	public void setqIp(String qIp) {
		this.qIp = qIp;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}
	
	
	
}
