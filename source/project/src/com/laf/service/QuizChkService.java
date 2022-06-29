package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;

public class QuizChkService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String mAnswer = request.getParameter("mAnswer");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.quizChk(mAnswer);
		
		if (result == MemberDao.SUCCESS) {
			request.setAttribute("mPw", dao.getMember((String)session.getAttribute("mId")).getmPw());
		} else {
			request.setAttribute("quizChkResult", "입력한 정보가 일치하지 않습니다. 다시 시도해주세요.");
		}
	}

}
