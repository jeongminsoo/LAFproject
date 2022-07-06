package com.laf.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.dao.LostDao;
import com.laf.dto.LostDto;

public class LostDetailSearchService implements Service {

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

		String lOb = request.getParameter("lOb");
		String lTitle = request.getParameter("lTitle");
		String tempDate1 = request.getParameter("tempDate1");
		String tempDate2 = request.getParameter("tempDate2");
		Date lDate1 = null;
		Date lDate2 = null;
		if (tempDate1.equals("")) {
			lDate1 = new Date(System.currentTimeMillis() - (1000*60*60*24));
		} else {
			lDate1 = Date.valueOf(tempDate1);
		}
		if (tempDate2.equals("")) {
			lDate2 = new Date(System.currentTimeMillis());
		} else {
			lDate2 = Date.valueOf(tempDate2);
		}
		
		String lLocal = request.getParameter("lLocal");
		
		LostDao dao = LostDao.getInstance();
		
		ArrayList<LostDto> losts = dao.detailSearch(lOb, lTitle, lDate1, lDate2, lLocal, start, end);
		
		int total = dao.countLost();
		int pageCnt = (int)Math.ceil((double)total / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE)*BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("lOb", lOb);
		request.setAttribute("lTitle", lTitle);
		request.setAttribute("tempDate1", tempDate1);
		request.setAttribute("tempDate2", tempDate2);
		request.setAttribute("lLocal", lLocal);
		request.setAttribute("losts", losts);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);

	}

}
