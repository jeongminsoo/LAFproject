package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.QnaDao;
import com.laf.dto.MemberDto;
import com.laf.dto.QnaDto;

public class QnaWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		MemberDto dto = (MemberDto) session.getAttribute("member");
		
		String mId = dto.getmId();
		String mName = request.getParameter("mName");
		String qTitle = request.getParameter("qTitle");
		String qContent = request.getParameter("qContent");
		String qIp = request.getRemoteAddr();
		
		QnaDao dao = QnaDao.getInstance();
		QnaDto qna = new QnaDto(0, qTitle, qContent, mId, null, 0, 0, 0, 0, qIp, mName, null);
		
		int result = dao.writeQna(qna);
		request.setAttribute("qnaWriteResult", result);

	}

}
