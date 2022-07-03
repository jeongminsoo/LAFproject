package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.LostDao;

public class LostCancelService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String lNo = request.getParameter("lNo");
		LostDao dao = LostDao.getInstance();
		int result = dao.cancelLost(lNo);
		request.setAttribute("lostCancelResult", result);

	}

}
