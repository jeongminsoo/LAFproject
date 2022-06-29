package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;

public class SearchPwService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mName = request.getParameter("mName");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.searchPw(mId, mName);
		
		if (result == MemberDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("mId", mId);
			request.setAttribute("quiz", dao.getMember(mId).getmQuiz());
		} else {
			request.setAttribute("searchPwResult", "입력한 정보와 일치한 아이디 또는 이름이 없습니다. 확인 후 다시 시도해주세요.");
		}
	}

}
