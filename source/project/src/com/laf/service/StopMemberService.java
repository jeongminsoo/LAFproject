package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.MemberDao;

public class StopMemberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String[] mIds = request.getParameterValues("memberCheck");
		
		MemberDao dao = MemberDao.getInstance();
		int cnt = 0;
		
		for (int i = 0; i < mIds.length; i++) {
			int result = dao.stopMember(mIds[i], "MST10");
			cnt += result;
		}
		request.setAttribute("resultCnt", cnt);
	}

}
