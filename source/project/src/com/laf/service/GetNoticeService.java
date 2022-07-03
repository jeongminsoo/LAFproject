package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.NoticeDao;
import com.laf.dto.NoticeDto;

public class GetNoticeService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		NoticeDao dao = NoticeDao.getInstance();
		
		NoticeDto notice = dao.getNotice(nNo);
		request.setAttribute("notice", notice);

	}

}
