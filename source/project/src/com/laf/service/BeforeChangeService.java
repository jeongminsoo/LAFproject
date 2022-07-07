package com.laf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laf.dao.MemberDao;
import com.laf.dto.MemberDto;

public class BeforeChangeService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String[] mIds = request.getParameterValues("memberCheck");
		
		MemberDao dao = MemberDao.getInstance();
		int cnt = 0;
		String msg = null;
		
		for (int i = 0; i < mIds.length; i++) {
			MemberDto dto = dao.getMember(mIds[i]);
			if (dto.getMstCode() == "MST10") {
				cnt++;
				break;
			}
		}
		
		if (cnt != 0) {
			msg = "사용중단된 회원이 있습니다. 사용중단된 회원은 권한을 바꿀수 없습니다";
			request.setAttribute("msg", msg);
		} else if(cnt == 0) {
			HttpSession session = request.getSession();
			session.setAttribute("memberCheck", mIds);
		}
		
		
		String mId = request.getParameter("mId");
		String mName = request.getParameter("mName");
		String mAddress = request.getParameter("mAddress");
		String mstCode = request.getParameter("mstCode");
		String bfpwCode = request.getParameter("bfpwCode");
		String tempDate1 = request.getParameter("tempDate1");
		String tempDate2 = request.getParameter("tempDate2");
		
		request.setAttribute("mId", mId);
		request.setAttribute("mName", mName);
		request.setAttribute("mAddress", mAddress);
		request.setAttribute("mstCode", mstCode);
		request.setAttribute("bfpwCode", bfpwCode);
		request.setAttribute("mRdate1", tempDate1);
		request.setAttribute("mRdate2", tempDate2);
	}

}
