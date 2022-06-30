package com.laf.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class JoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId 			= request.getParameter("mId");
		String mPw 			= request.getParameter("mPw");
		String mName 		= request.getParameter("mName");
		String mEmailId 	= request.getParameter("mEmailId");
		String mEmailDomain = request.getParameter("mEmailDomain");
		String mAddress 	= request.getParameter("mAddress");
		String mTel1		= request.getParameter("mTel1");
		String mTel2		= request.getParameter("mTel2");
		String mTel3		= request.getParameter("mTel3");
		String tempBirth	= request.getParameter("tempBirth");
		Date   mBirth		= null;
		if (!tempBirth.equals("")) {
			mBirth = Date.valueOf(tempBirth);
		}
		String mQuiz		= request.getParameter("mQuiz");
		String mAnswer		= request.getParameter("mAnswer");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.joinMember(new MemberDto(mId, mPw, mName, mEmailId, mEmailDomain, mAddress, mTel1, mTel2, mTel3, mBirth, mQuiz, mAnswer, null, null, null, null, null));
		
		request.setAttribute("joinResult", result);
	}

}
