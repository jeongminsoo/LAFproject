package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.QnaDao;
import com.laf.dto.QnaDto;

public class GetQnaService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		QnaDao dao = QnaDao.getInstance();
		QnaDto qna = dao.getQna(qNo);
		
		request.setAttribute("qna", qna);

	}

}
