package com.laf.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class ModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");
		String mId = member.getmId();
		String mName = request.getParameter("mName");
		String tempBirth = request.getParameter("tempBirth");
		Date mBirth = null;
		if (!tempBirth.equals("")) {
			mBirth = Date.valueOf(tempBirth);
		}
		String mTel1 = request.getParameter("mTel1");
		String mTel2 = request.getParameter("mTel2");
		String mTel3 = request.getParameter("mTel3");
		String mAddress = request.getParameter("mAddress");
		String mEmailId = request.getParameter("mEmailId");
		String mEmailDomain = request.getParameter("mEmailDomain");
		String mQuiz = request.getParameter("mQuiz");
		String mAnswer = request.getParameter("mAnswer");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.modifyMember(new MemberDto(mId, null, mName, mEmailId, mEmailDomain, mAddress, mTel1, mTel2, mTel3, mBirth, mQuiz, mAnswer, null, null, null, null, null));
		if (result == MemberDao.SUCCESS) {
			session.removeAttribute("member");
			session.setAttribute("member", dao.getMember(mId));
		}
		request.setAttribute("modifyResult", result);
	}

}
