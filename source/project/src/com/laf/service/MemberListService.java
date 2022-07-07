package com.laf.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class MemberListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = MemberDao.getInstance();
		
		ArrayList<MemberDto> members = dao.memberList();

		long current = System.currentTimeMillis();
		Date today = new Date(current);
		Date yesterday = new Date(current - (1000*60*60*24));
		request.setAttribute("members", members);
		request.setAttribute("today", today);
		request.setAttribute("yesterday", yesterday);
	}

}
