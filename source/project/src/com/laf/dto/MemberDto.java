package com.laf.dto;

import java.sql.Date;

public class MemberDto {

	private String 	mId;
	private String 	mPw;
	private String 	mName;
	private String 	mEmail;
	private String	mAddress;
	private String 	mTel;
	private Date 	mBirth;
	private String 	mQuiz;
	private String 	mAnswer;
	private Date 	mRdate;
	private String 	pcCode;
	private int 	scCode;
	
	public MemberDto() {
		
	}

	public MemberDto(String mId, String mPw, String mName, String mEmail, String mAddress, String mTel, Date mBirth,
			String mQuiz, String mAnswer, Date mRdate, String pcCode, int scCode) {
		super();
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mEmail = mEmail;
		this.mAddress = mAddress;
		this.mTel = mTel;
		this.mBirth = mBirth;
		this.mQuiz = mQuiz;
		this.mAnswer = mAnswer;
		this.mRdate = mRdate;
		this.pcCode = pcCode;
		this.scCode = scCode;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public Date getmBirth() {
		return mBirth;
	}

	public void setmBirth(Date mBirth) {
		this.mBirth = mBirth;
	}

	public String getmQuiz() {
		return mQuiz;
	}

	public void setmQuiz(String mQuiz) {
		this.mQuiz = mQuiz;
	}

	public String getmAnswer() {
		return mAnswer;
	}

	public void setmAnswer(String mAnswer) {
		this.mAnswer = mAnswer;
	}

	public Date getmRdate() {
		return mRdate;
	}

	public void setmRdate(Date mRdate) {
		this.mRdate = mRdate;
	}

	public String getPcCode() {
		return pcCode;
	}

	public void setPcCode(String pcCode) {
		this.pcCode = pcCode;
	}

	public int getScCode() {
		return scCode;
	}

	public void setScCode(int scCode) {
		this.scCode = scCode;
	}


}
