package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.QnaDao;

public class QnaDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		QnaDao dao = QnaDao.getInstance();
		int result = dao.deleteLost(qNo);
		request.setAttribute("qnaDeleteResult", result);


	}

}
