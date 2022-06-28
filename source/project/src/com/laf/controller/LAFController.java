package com.laf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laf.service.IdChkService;
import com.laf.service.JoinService;
import com.laf.service.LoginService;
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
		
		// 로그인 view
		if (com.equals("/login_view.laf")) {
			viewPage = "member/login.jsp";
		
		// 로그인 laf
		} else if (com.equals("/login.laf")) {
			service = new LoginService();
			service.execute(request, response);
			viewPage = "";
		
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
			viewPage = "main/main.jsp";
			
		// 아이디 중복체크 laf
		} else if (com.equals("/idChk.laf")) {
			service = new IdChkService();
			service.execute(request, response);
			viewPage = "";
		} else if (com.equals("/idChk.laf")) {
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
