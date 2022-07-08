package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class LeaveMemberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		MemberDto dto = (MemberDto) session.getAttribute("member");
		
		String mId = dto.getmId();
		String mPw = dto.getmPw();
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.leaveMember(mId, mPw);
		
		if (result == MemberDao.SUCCESS) {
			session.removeAttribute("member");
		}
		
		request.setAttribute("leaveResult", result);
	}

}
