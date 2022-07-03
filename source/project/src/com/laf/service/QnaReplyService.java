package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.QnaDao;
import com.laf.dto.MemberDto;
import com.laf.dto.QnaDto;

public class QnaReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		MemberDto dto = (MemberDto) session.getAttribute("member");
		
		String mId = dto.getmId();
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qContent");
		int qGroup = Integer.parseInt(request.getParameter("qGroup"));
		int qStep = Integer.parseInt(request.getParameter("qStep"));
		int qIndent = Integer.parseInt(request.getParameter("qIndent"));
		String qIp = request.getRemoteAddr();
		
		QnaDao dao = QnaDao.getInstance();
		
		int result = dao.replyQna(qTitle, qContent, mId, qGroup, qStep, qIndent, qIp);
		request.setAttribute("qnaReplyResult", result);

	}

}
