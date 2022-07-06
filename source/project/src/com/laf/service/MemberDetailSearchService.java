package com.laf.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class MemberDetailSearchService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = MemberDao.getInstance();
		
		String mId = request.getParameter("mId");
		if (mId == null) {
			mId = "";
		}
		String mName = request.getParameter("mName");
		if (mName == null) {
			mName = "";
		}
		String mAddress = request.getParameter("mAddress");
		if (mAddress == null) {
			mAddress = "";
		}
		String mstCode = request.getParameter("mstCode");
		if (mstCode == null) {
			mstCode = "";
		}
		String pwCode = request.getParameter("pwCode");
		if (pwCode == null) {
			pwCode = "";
		}
		String tempDate1 = request.getParameter("tempDate1");
		String tempDate2 = request.getParameter("tempDate2");
		Date mRdate1 = null;
		Date mRdate2 = null;
		
		System.out.println(mId + "/" + mName + "/" + mAddress + "/" + mstCode + "/" + pwCode + "/" + mRdate1 + "/" + mRdate2);
		
		if (tempDate1.equals("")) {
			mRdate1 = new Date(System.currentTimeMillis() - (1000*60*60*24));
		} else {
			mRdate1 = Date.valueOf(tempDate1);
		}
		
		if (tempDate2.equals("")) {
			mRdate2 = new Date(System.currentTimeMillis() + (1000*60*60*12));
		} else {
			mRdate2 = Date.valueOf(tempDate2);
		}
		ArrayList<MemberDto> members = dao.memberDetailSearch(mId, mName, mAddress, mstCode, pwCode, mRdate1, mRdate2);

		request.setAttribute("members", members);
		request.setAttribute("mId", mId);
		request.setAttribute("mName", mName);
		request.setAttribute("mAddress", mAddress);
		request.setAttribute("mstCode", mstCode);
		request.setAttribute("pwCode", pwCode);
		request.setAttribute("mRdate1", tempDate1);
		request.setAttribute("mRdate2", tempDate2);

	}

}
