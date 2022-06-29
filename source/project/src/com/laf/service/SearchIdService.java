package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.MemberDao;

public class SearchIdService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mName = request.getParameter("mName");
		String mEmailId = request.getParameter("mEmailId");
		String mEmailDomain = request.getParameter("mEmailDomain");

		MemberDao dao = MemberDao.getInstance();
		
		String mId = dao.searchId(mName, mEmailId, mEmailDomain);
		if (mId == null) {
			request.setAttribute("searchIdResult", "입력한 정보와 일치한 아이디가 없습니다. 다시 시도해주세요");
		} else {
			request.setAttribute("mId", mId);
		}
	}

}
