package com.laf.service;

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

		request.setAttribute("members", members);
	}

}
