package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.NoticeDao;

public class NoticeDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		NoticeDao dao = NoticeDao.getInstance();
		int result = dao.deleteNotice(nNo);
		
		request.setAttribute("noticeDeleteResult", result);

	}

}
