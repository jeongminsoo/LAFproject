package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;

public class ChangePowerService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String[] mIds = (String[]) session.getAttribute("memberCheck");
		String pwCode = request.getParameter("pwCode");

		System.out.println(mIds);
		MemberDao dao = MemberDao.getInstance();
		
		int total = 0;
		
		for (int i = 0; i < mIds.length; i++) {
			int result = dao.powerChange(mIds[i], pwCode);
			total += result;
		}
		
		String mId = request.getParameter("mId");
		String mName = request.getParameter("mName");
		String mAddress = request.getParameter("mAddress");
		String bfpwCode = request.getParameter("bfpwCode");
		String mstCode = request.getParameter("mstCode");
		String tempDate1 = request.getParameter("tempDate1");
		String tempDate2 = request.getParameter("tempDate2");

		request.setAttribute("changeResult", total);
		request.setAttribute("mId", mId);
		request.setAttribute("mName", mName);
		request.setAttribute("mAddress", mAddress);
		request.setAttribute("mstCode", mstCode);
		request.setAttribute("bfpwCode", bfpwCode);
		request.setAttribute("mRdate1", tempDate1);
		request.setAttribute("mRdate2", tempDate2);

		session.removeAttribute("memberCheck");

	}

}
