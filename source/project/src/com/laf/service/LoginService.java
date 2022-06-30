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
		} else {
			request.setAttribute("loginMsg", "아이디 또는 비밀번호를 잘못 입력했습니다.입력하신 내용을 다시 확인해주세요.");
		}
	}

}
