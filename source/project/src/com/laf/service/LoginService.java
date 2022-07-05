package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;

public class LoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.loginChk(mId, mPw);
		
		if (result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("member", dao.getMember(mId));
		}
		
		request.setAttribute("loginResult", result);
	}

}
