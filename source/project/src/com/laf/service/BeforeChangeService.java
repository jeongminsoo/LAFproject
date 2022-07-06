package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BeforeChangeService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String[] mIds = request.getParameterValues("memberCheck");
		session.setAttribute("memberCheck", mIds);
		
		String mId = request.getParameter("mId");
		String mName = request.getParameter("mName");
		String mAddress = request.getParameter("mAddress");
		String mstCode = request.getParameter("mstCode");
		String bfpwCode = request.getParameter("bfpwCode");
		String tempDate1 = request.getParameter("tempDate1");
		String tempDate2 = request.getParameter("tempDate2");
		
		request.setAttribute("mId", mId);
		request.setAttribute("mName", mName);
		request.setAttribute("mAddress", mAddress);
		request.setAttribute("mstCode", mstCode);
		request.setAttribute("bfpwCode", bfpwCode);
		request.setAttribute("mRdate1", tempDate1);
		request.setAttribute("mRdate2", tempDate2);
	}

}
