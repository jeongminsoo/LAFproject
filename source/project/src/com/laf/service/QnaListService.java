package com.laf.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.QnaDao;
import com.laf.dto.QnaDto;

public class QnaListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1)*PAGESIZE + 1;
		int end = start + PAGESIZE - 1;

		QnaDao dao = QnaDao.getInstance();
		ArrayList<QnaDto> qnas = dao.qnaList(start, end);
		
		int total = dao.countQna();
		int pageCnt = (int)Math.ceil((double)total / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE)*BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		request.setAttribute("qnas", qnas);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);

	}

}
