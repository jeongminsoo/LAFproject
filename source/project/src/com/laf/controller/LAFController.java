package com.laf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.service.FindCancelService;
import com.laf.service.FindContentService;
import com.laf.service.FindListService;
import com.laf.service.FindUpdateService;
import com.laf.service.FindWriteService;
import com.laf.service.IdChkService;
import com.laf.service.JoinService;
import com.laf.service.LoginService;
import com.laf.service.ModifyService;
import com.laf.service.PwChangeService;
import com.laf.service.QuizChkService;
import com.laf.service.SearchIdService;
import com.laf.service.SearchPwService;
import com.laf.service.Service;


@WebServlet("*.laf")
public class LAFController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private boolean join_view = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String com = uri.substring(path.length());
		String viewPage = null;
		Service service = null;
		
		// 메인 페이지
		if (com.equals("/main.laf")) {
			viewPage="main/main.jsp";
			
		// 로그인 view
		}else if (com.equals("/login_view.laf")) {
			viewPage = "member/login.jsp";
		
		// 로그인 laf
		} else if (com.equals("/login.laf")) {
			service = new LoginService();
			service.execute(request, response);
			viewPage = "/main.laf";
		
		// 회원가입 view
		} else if (com.equals("/join_view.laf")) {
			viewPage = "member/join.jsp";
			join_view = true;
			
		// 회원가입 laf
		} else if (com.equals("/join.laf")) {
			if (join_view) {
				service = new JoinService();
				service.execute(request, response);
				join_view = false;
			}
			viewPage = "/login_view.laf";
			
		// 아이디 중복체크 laf
		} /*
		 * else if (com.equals("/idChk.laf")) { service = new IdChkService();
		 * service.execute(request, response); viewPage = "";
		 * 
		 * // 아이디 찾기 view }
		 */else if (com.equals("/searchId_view.laf")) {
			viewPage="member/searchId.jsp";
			
		// 아이디 찾기 laf
		} else if (com.equals("/searchId.laf")) {
			service = new SearchIdService();
			service.execute(request, response);
			viewPage = "member/searchId_result.jsp";
			
		// 비밀번호 찾기 view
		} else if (com.equals("/searchPw_view.laf")) {
			viewPage="member/searchPw.jsp";
			
		// 비밀번호 찾기 laf
		} else if (com.equals("/searchPw.laf")) {
			service = new SearchPwService();
			service.execute(request, response);
			viewPage="/quiz_view.laf";
			
		// 비밀번호 찾기 질문/답변 view
		} else if (com.equals("/quiz_view.laf")) {
			viewPage = "member/quiz.jsp";
			
		// 비밀번호 찾기 질문/답변 laf	
		} else if (com.equals("/quizChk.laf")) {
			service = new QuizChkService();
			service.execute(request, response);
			viewPage="/pw_change_view.laf";
			
		// 비밀번호 변경 view
		} else if (com.equals("/pw_change_view.laf")) {
			viewPage = "member/pw_change.jsp";
			
		// 비밀번호 변경 laf
		} else if (com.equals("/pw_change.laf")) {
			service = new PwChangeService();
			service.execute(request, response);
			viewPage="/pw_change_view.laf";
			
		// 마이페이지(회원정보)
		} else if (com.equals("/my_info.laf")) {
			viewPage = "member/info.jsp";
			
		// 정보수정 view
		} else if (com.equals("/modify_view.laf")) {
			viewPage = "member/modify.jsp";
			
		// 정보수정 laf
		} else if (com.equals("/modify.laf")) {
			service = new ModifyService();
			service.execute(request, response);
			viewPage = "/my_info.laf";
			
		// 습득물 리스트
		} else if (com.equals("/findList.laf")) {
			service = new FindListService();
			service.execute(request, response);
			viewPage = "board/findboard/find_list.jsp";
			
		// 습득물 상세보기
		} else if (com.equals("/findContent.laf")) {
			service = new FindContentService();
			service.execute(request, response);
			viewPage = "board/findboard/find_content.jsp";
			
		// 습득물 등록 view
		} else if (com.equals("/findWrite_view.laf")) {
			viewPage = "board/findboard/find_write.jsp";
			
		// 습득물 등록 laf
		} else if (com.equals("/findWrite.laf")) {
			service = new FindWriteService();
			service.execute(request, response);
			viewPage = "/findList.laf";
			
		// 습득물 수정 view
		} else if (com.equals("/findUpdate_view.laf")) {
			service = new FindContentService();
			service.execute(request, response);
			viewPage = "board/findboard/find_update.jsp";
			
		// 습득물 수정 laf
		} else if (com.equals("/findUpdate.laf")) {
			service = new FindUpdateService();
			service.execute(request, response);
			viewPage = "/findList.laf";
			
		// 습득물 등록 취소
		} else if (com.equals("/findCancel.laf")) {
			service = new FindCancelService();
			service.execute(request, response);
			viewPage = "/findList.laf";
			
		// 분실물 리스트
		}/* else if (com.equals("/lostList.laf")) {
			service = new LostListService();
			service.execute(request, response);
			viewPage = "board/lostboard/lost_list.jsp";
			
		// 분실물 상세보기
		} else if (com.equals("/lostContent.laf")) {
			service = new LostContentService();
			service.execute(request, response);
			viewPage = "board/lostboard/lost_content.jsp";
			
		// 분실물 등록 view	
		} else if (com.equals("/lostWrite_view.laf")) {
			viewPage = "board/lostboard/lost_write.jsp";
		
		// 분실물 등록 laf
		} else if (com.equals("/lostWrite.laf")) {
			service = new LostWriteService();
			service.execute(request, response);
			viewPage = "/lostList.laf";
			
		// 분실물 수정 view
		} else if (com.equals("/lostUpdate_view.laf")) {
			viewPage = "board/lostboard/lost_update.jsp";
			
		// 분실물 수정 laf
		} else if (com.equals("/lostUpdate.laf")) {
			service = new LostUpdateService();
			service.execute(request, response);
			viewPage = "/lostList.laf";
		// 분실물 삭제
		} else if (com.equals("/lostDelete.laf")) {
			service = new LostDeleteService();
			service.execute(request, response);
			viewPage = "/lostList.laf";
		}*/
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
