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
import com.laf.service.GetFindService;
import com.laf.service.GetLostService;
import com.laf.service.GetNoticeService;
import com.laf.service.GetQnaService;
import com.laf.service.IdChkService;
import com.laf.service.JoinService;
import com.laf.service.LoginService;
import com.laf.service.LostCancelService;
import com.laf.service.LostContentService;
import com.laf.service.LostDeleteService;
import com.laf.service.LostListService;
import com.laf.service.LostUpdateService;
import com.laf.service.LostWriteService;
import com.laf.service.MemberListService;
import com.laf.service.ModifyService;
import com.laf.service.MyFindListService;
import com.laf.service.MyLostListService;
import com.laf.service.NoticeContentService;
import com.laf.service.NoticeDeleteService;
import com.laf.service.NoticeListService;
import com.laf.service.NoticeUpdateService;
import com.laf.service.NoticeWriteService;
import com.laf.service.PwChangeService;
import com.laf.service.QnaContentService;
import com.laf.service.QnaDeleteService;
import com.laf.service.QnaListService;
import com.laf.service.QnaReplyService;
import com.laf.service.QnaUpdateService;
import com.laf.service.QnaWriteService;
import com.laf.service.QuizChkService;
import com.laf.service.SearchIdService;
import com.laf.service.SearchPwService;
import com.laf.service.Service;
import com.laf.service.AddService;
import com.laf.service.AdminListService;
import com.laf.service.DetailSearchService;


@WebServlet("*.laf")
public class LAFController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private boolean view = false;

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
			view = true;
			
		// 회원가입 laf
		} else if (com.equals("/join.laf")) {
			if (view) {
				service = new JoinService();
				service.execute(request, response);
				view = false;
			}
			viewPage = "/login_view.laf";
		// 아이디 중복체크 laf
		} else if (com.equals("/idChk.laf")) {
			service = new IdChkService();
			service.execute(request, response);
			viewPage = "member/idChk.jsp";
		
		// 아이디 찾기 view
		} else if (com.equals("/searchId_view.laf")) {
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
			viewPage="/pw_change_view2.laf";
			
		// 팝업창 비밀번호 변경
		} else if (com.equals("/pw_change_view2.laf")) {
			viewPage="member/pw_change2.jsp";
			
		// 비밀번호 변경 view
		} else if (com.equals("/pw_change_view.laf")) {
			viewPage = "member/pw_change.jsp";
			
		// 비밀번호 변경 laf
		} else if (com.equals("/pw_change.laf")) {
			service = new PwChangeService();
			service.execute(request, response);
			viewPage="/pw_change_view.laf";
			
		// 마이페이지(회원정보)
		} else if (com.equals("/myInfo.laf")) {
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
			view = true;
			
		// 습득물 등록 laf
		} else if (com.equals("/findWrite.laf")) {
			if (view) {
				service = new FindWriteService();
				service.execute(request, response);
				view = false;
			}
			viewPage = "/findList.laf";
			
		// 습득물 수정 view
		} else if (com.equals("/findUpdate_view.laf")) {
			service = new GetFindService();
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
		} else if (com.equals("/lostList.laf")) {
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
			view = true;
			
		// 분실물 등록 laf
		} else if (com.equals("/lostWrite.laf")) {
			if (view) {
				service = new LostWriteService();
				service.execute(request, response);
			}
			viewPage = "/lostList.laf";
			
		// 분실물 수정 view
		} else if (com.equals("/lostUpdate_view.laf")) {
			service = new GetLostService();
			service.execute(request, response);
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
			
		// 분실물 등록 취소
		} else if (com.equals("/lostCancel.laf")) {
			service = new LostCancelService();
			service.execute(request, response);
			viewPage = "/lostList.laf";
			
		// Q&A 리스트
		} else if (com.equals("/qnaList.laf")) {
			service = new QnaListService();
			service.execute(request, response);
			viewPage = "board/qnaboard/qna_list.jsp";
		
		// Q&A 작성 view
		} else if (com.equals("/qnaWrite_view.laf")) {
			viewPage = "board/qnaboard/qna_write.jsp";
			view = true;
			
		// Q&A 작성 laf	
		} else if (com.equals("/qnaWrite.laf")) {
			if (view) {
				service = new QnaWriteService();
				service.execute(request, response);
			}
			viewPage = "/qnaList.laf";
			
		// Q&A 상세보기
		} else if (com.equals("/qnaContent.laf")) {
			service = new QnaContentService();
			service.execute(request, response);
			viewPage = "board/qnaboard/qna_content.jsp";
			
		// Q&A 수정 view
		} else if (com.equals("/qnaUpdate_view.laf")) {
			service = new GetQnaService();
			service.execute(request, response);
			viewPage = "board/qnaboard/qna_update.jsp";
			
		// Q&A 수정 laf
		} else if (com.equals("/qnaUpdate.laf")) {
			service = new QnaUpdateService();
			service.execute(request, response);
			viewPage = "/qnaList.laf";
			
		// Q&A 삭제
		} else if (com.equals("/qnaDelete.laf")) {
			service = new QnaDeleteService();
			service.execute(request, response);
			viewPage = "/qnaList.laf";
			
		//Q&A 답변 view
		} else if (com.equals("/qnaReply_view.laf")) {
			service = new GetQnaService();
			service.execute(request, response);
			viewPage = "board/qnaboard/qna_reply.jsp";
			view = true;
		// Q&A 답변 laf
		} else if (com.equals("/qnaReply.laf")) {
			if (view) {
				service = new QnaReplyService();
				service.execute(request, response);
				view = false;
			}
			viewPage = "/qnaList.laf";
		
		// 공지사항 리스트
		} else if (com.equals("/noticeList.laf")) {
			service = new NoticeListService();
			service.execute(request, response);
			viewPage = "board/noticeboard/notice_list.jsp";
			
		// 공지사항 상세보기
		} else if (com.equals("/noticeContent.laf")) {
			service = new NoticeContentService();
			service.execute(request, response);
			viewPage = "board/noticeboard/notice_content.jsp";
	
		// 공지사항 작성 view
		} else if (com.equals("/noticeWrite_view.laf")) {
			viewPage = "board/noticeboard/notice_write.jsp";
			view = true;
			
		// 공지사항 작성 laf
		} else if (com.equals("/noticeWrite.laf")) {
			if (view) {
				service = new NoticeWriteService();
				service.execute(request, response);
			}
			viewPage = "/noticeList.laf";
			
		// 공지사항 수정	view
		} else if (com.equals("/noticeUpdate_view.laf")) {
			service = new GetNoticeService();
			service.execute(request, response);
			viewPage = "board/noticeboard/notice_update.jsp";
			
		// 공지사항 수정 laf	
		} else if (com.equals("/noticeUpdate.laf")) {
			service = new NoticeUpdateService();
			service.execute(request, response);
			viewPage = "/noticeList.laf";
			
		// 공지사항 삭제
		} else if (com.equals("/noticeDelete.laf")) {
			service = new NoticeDeleteService();
			service.execute(request, response);
			viewPage = "/noticeList.laf";
			
		// 로그아웃
		} else if (com.equals("/logout.laf")) {
			viewPage = "member/logout.jsp";
			
		// 습득물 관리
		} else if (com.equals("/myFindList.laf")) {
			service = new MyFindListService();
			service.execute(request, response);
			viewPage = "board/findboard/my_find_list.jsp";
			
		// 분실물 관리
		} else if (com.equals("/myLostList.laf")) {
			service = new MyLostListService();
			service.execute(request, response);
			viewPage = "board/lostboard/my_lost_list.jsp";
			
		// 회원리스트
		} else if (com.equals("/memberList.laf")) {
			service = new MemberListService();
			service.execute(request, response);
			viewPage = "admin/member_list.jsp";
			
		// 관리자리스트
		} else if (com.equals("/adminList.laf")) {
			service = new AdminListService();
			service.execute(request, response);
			viewPage = "admin/admin_list.jsp";
			
		// 관리자 추가 view
		} else if (com.equals("/add_view.laf")) {
			viewPage = "admin/add.jsp";
			view = true;
		} else if (com.equals("/add.laf")) {
			if (view) {
				service = new AddService();
				service.execute(request, response);
				view = false;
			}
			viewPage = "/adminList.laf";
		} else if (com.equals("/detailSearch.laf")) {
			service = new DetailSearchService();
			service.execute(request, response);
			viewPage = "board/findboard/find_detail.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
