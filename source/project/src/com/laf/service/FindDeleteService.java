package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.FindDao;

public class FindDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String fNo = request.getParameter("fNo");
		FindDao dao = FindDao.getInstance();
		int result = dao.deleteLost(fNo);
		request.setAttribute("findDeleteResult", result);
	}

}
