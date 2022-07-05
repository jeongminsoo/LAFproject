package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.MemberDao;

public class IdChkService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		
		MemberDao dao = MemberDao.getInstance();
		
		int result = dao.idChk(mId);
		
		if (result == MemberDao.ID_NONEXISTENT) {
			request.setAttribute("idChkResult", "사용가능한 아이디입니다");
		} else {
			request.setAttribute("idChkResult", "중복된 아이디입니다");
		}
		request.setAttribute("mId", mId);
	}

}
