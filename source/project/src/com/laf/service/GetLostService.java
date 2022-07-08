package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.LostDao;
import com.laf.dto.LostDto;

public class GetLostService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String lNo = request.getParameter("lNo");
		String msg = request.getParameter("msg");
		LostDao dao = LostDao.getInstance();
		LostDto lost = dao.getLost(lNo);
		
		request.setAttribute("msg", msg);
		request.setAttribute("lost", lost);

	}

}
