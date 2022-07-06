<%@page import="com.laf.dto.MemberDto"%>
<%@page import="com.laf.dao.MemberDao"%>
<%@page import="java.sql.Date"%>
<%@page import="com.laf.dto.FindDto"%>
<%@page import="com.laf.dao.FindDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		MemberDao dao = MemberDao.getInstance();

	for (int i = 1; i <= 150; i++) {
		String mId = "aaa" + i;
		String mPw = ""+ i + "";
		
		int result = dao.changemPw(mId, mPw);
	}
	%>
</body>
</html>