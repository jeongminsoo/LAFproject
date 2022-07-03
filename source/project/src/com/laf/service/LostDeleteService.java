package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.LostDao;

public class LostDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String lNo = request.getParameter("lNo");
		LostDao dao = LostDao.getInstance();
		int result = dao.deleteLost(lNo);
		request.setAttribute("lostDeleteResult", result);

	}

}
