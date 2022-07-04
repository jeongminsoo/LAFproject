package com.laf.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.LostDao;
import com.laf.dto.LostDto;
import com.laf.dto.MemberDto;

public class MyLostListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		MemberDto member = (MemberDto) session.getAttribute("member");
		
		String mId = member.getmId();
		
		final int PAGESIZE = 10;
		final int BLOCKSIZE = 10;
		
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int start = (currentPage - 1)*PAGESIZE + 1;
		int end = start + PAGESIZE - 1;

		LostDao dao = LostDao.getInstance();
		ArrayList<LostDto> losts = dao.myLostList(mId, start, end);
		
		int total = dao.countLost();
		int pageCnt = (int)Math.ceil((double)total / PAGESIZE);
		int startPage = ((currentPage - 1) / BLOCKSIZE)*BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		request.setAttribute("losts", losts);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
	}

}
