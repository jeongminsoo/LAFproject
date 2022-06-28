package com.laf.dto;

import java.sql.Date;

public class MemberDto {

	private String 	mId;
	private String 	mPw;
	private String 	mName;
	private String 	mEmailId;
	private String  mEmailDomain;
	private String	mAddress;
	private String 	mTel1;
	private String 	mTel2;
	private String 	mTel3;
	private Date 	mBirth;
	private String 	mQuiz;
	private String 	mAnswer;
	private Date 	mRdate;
	private String 	pwCode;
	private String  pcc;
	private String 	mstCode;
	private String	mcc;
	
	public MemberDto() {
		
	}

	public MemberDto(String mId, String mPw, String mName, String mEmailId, String mEmailDomain, String mAddress,
			String mTel1, String mTel2, String mTel3, Date mBirth, String mQuiz, String mAnswer, Date mRdate,
			String pwCode, String pcc, String mstCode, String mcc) {
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mEmailId = mEmailId;
		this.mEmailDomain = mEmailDomain;
		this.mAddress = mAddress;
		this.mTel1 = mTel1;
		this.mTel2 = mTel2;
		this.mTel3 = mTel3;
		this.mBirth = mBirth;
		this.mQuiz = mQuiz;
		this.mAnswer = mAnswer;
		this.mRdate = mRdate;
		this.pwCode = pwCode;
		this.pcc = pcc;
		this.mstCode = mstCode;
		this.mcc = mcc;
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

	public String getmEmailId() {
		return mEmailId;
	}

	public void setmEmailId(String mEmailId) {
		this.mEmailId = mEmailId;
	}

	public String getmEmailDomain() {
		return mEmailDomain;
	}

	public void setmEmailDomain(String mEmailDomain) {
		this.mEmailDomain = mEmailDomain;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getmTel1() {
		return mTel1;
	}

	public void setmTel1(String mTel1) {
		this.mTel1 = mTel1;
	}

	public String getmTel2() {
		return mTel2;
	}

	public void setmTel2(String mTel2) {
		this.mTel2 = mTel2;
	}

	public String getmTel3() {
		return mTel3;
	}

	public void setmTel3(String mTel3) {
		this.mTel3 = mTel3;
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

	public String getPwCode() {
		return pwCode;
	}

	public void setPwCode(String pwCode) {
		this.pwCode = pwCode;
	}

	public String getPcc() {
		return pcc;
	}

	public void setPcc(String pcc) {
		this.pcc = pcc;
	}

	public String getMstCode() {
		return mstCode;
	}

	public void setMstCode(String mstCode) {
		this.mstCode = mstCode;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	
}
