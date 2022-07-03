package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.FindDao;
import com.laf.dto.FindDto;

public class GetFindService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String fNo = request.getParameter("fNo");
		FindDao dao = FindDao.getInstance();
		FindDto find = dao.getFind(fNo);
		
		request.setAttribute("find", find);
	}

}
