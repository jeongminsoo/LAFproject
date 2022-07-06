package com.laf.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.FindDao;
import com.laf.dto.FindDto;

public class FindDetailSearchService implements Service {

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

		String fOb = request.getParameter("fOb");
		String fTitle = request.getParameter("fTitle");
		String tempDate1 = request.getParameter("tempDate1");
		String tempDate2 = request.getParameter("tempDate2");
		Date fDate1 = null;
		Date fDate2 = null;
		if (tempDate1.equals("")) {
			fDate1 = new Date(System.currentTimeMillis() - (1000*60*60*24));
		} else {
			fDate1 = Date.valueOf(tempDate1);
		}
		if (tempDate2.equals("")) {
			fDate2 = new Date(System.currentTimeMillis());
		} else {
			fDate2 = Date.valueOf(tempDate2);
		}
		
		String fLocal = request.getParameter("fLocal");
		
		FindDao dao = FindDao.getInstance();
		
		ArrayList<FindDto> finds = dao.detailSearch(fOb, fTitle, fDate1, fDate2, fLocal, start, end);
		
		int total = dao.countDetailSearch(fOb, fTitle, fDate1, fDate2, fLocal);
		int pageCnt = (int)Math.ceil((double)total / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE)*BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("fOb", fOb);
		request.setAttribute("fTitle", fTitle);
		request.setAttribute("tempDate1", tempDate1);
		request.setAttribute("tempDate2", tempDate2);
		request.setAttribute("fLocal", fLocal);
		request.setAttribute("finds", finds);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
	}

}
