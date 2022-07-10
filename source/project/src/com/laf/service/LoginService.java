package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class LoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		
		MemberDao dao = MemberDao.getInstance();
		
		MemberDto dto = dao.getMember(mId);
		
		
		String msg = null;
		if (dto != null && dto.getMstCode().equals("MST10")) {
			msg = "해당 아이디는 사용이 중단된 아이디입니다.";
			request.setAttribute("loginResult", msg);
		} else {
			int result = dao.loginChk(mId, mPw);
			
			if (result == MemberDao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("member", dto);
			} else {
				request.setAttribute("loginResult", "아이디 또는 비밀번호를 잘못 입력했습니다.입력하신 내용을 다시 확인해주세요.");
			}
		}
	}

}
