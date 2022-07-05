package com.laf.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class AdminListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = MemberDao.getInstance();
		
		ArrayList<MemberDto> admins = dao.adminList();

		request.setAttribute("admins", admins);

	}

}
