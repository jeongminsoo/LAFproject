package com.laf.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		if (result == MemberDao.SUCCESS) {
			request.setAttribute("joinResult", "회원가입을 축하합니다. 로그인 페이지로 이동합니다.");
		} else {
			request.setAttribute("joinResult", "회원가입에 실패하였습니다. 입력하신 정보를 다시 확인해 주시기 바랍니다.");
		}
	}

}
