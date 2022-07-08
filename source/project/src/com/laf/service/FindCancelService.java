package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.FindDao;

public class FindCancelService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String fNo = request.getParameter("fNo");
		String msg = request. getParameter("msg");
		String pageNum = request.getParameter("pageNum");
		
		FindDao dao = FindDao.getInstance();
		int result = dao.cancelFind(fNo);
		request.setAttribute("findCancelResult", result);
		request.setAttribute("msg", msg);
		request.setAttribute("pageNum", pageNum);
	}

}
