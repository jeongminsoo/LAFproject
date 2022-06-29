package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;

public class PwChangeService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String mId = (String) session.getAttribute("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.changemPw(mId, mPw);
		if (result == MemberDao.SUCCESS) {
			request.setAttribute("pwChangeSuccess", "비밀번호 변경이 완료되었습니다. 변경된 비밀번호로 로그인 하시기 바랍니다.");
		} else {
			request.setAttribute("pwChangeFail", "비밀번호 변경에 실패하였습니다. 입력한 정보를 확인 후 다시 시도해주세요.");
		}
	}

}
