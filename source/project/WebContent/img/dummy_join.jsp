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
		String mPw = "+i+";
		String mName = "홍길동"+i;
		String mEmailId = "hong" + i;
		String mEmailDomain = "naver.com";
		String mAddress = null;
		if (i % 17 == 0) {
			mAddress = "서울특별시";
		} else if (i % 17 == 1) {
			mAddress = "경기도";
		} else if (i % 17 == 2) {
			mAddress = "인천광역시";
		} else if (i % 17 == 3) {
			mAddress = "강원도";
		} else if (i % 17 == 4) {
			mAddress = "충청북도";
		} else if (i % 17 == 5) {
			mAddress = "충청남도";
		} else if (i % 17 == 6) {
			mAddress = "대전광역시";
		} else if (i % 17 == 7) {
			mAddress = "세종특별자치시";
		} else if (i % 17 == 8) {
			mAddress = "전라남도";
		} else if (i % 17 == 9) {
			mAddress = "전라북도";
		} else if (i % 17 == 10) {
			mAddress = "광주광역시";
		} else if (i % 17 == 11) {
			mAddress = "경상북도";
		} else if (i % 17 == 12) {
			mAddress = "경상남도";
		} else if (i % 17 == 13) {
			mAddress = "대구광역시";
		} else if (i % 17 == 14) {
			mAddress = "울산광역시";
		} else if (i % 17 == 15) {
			mAddress = "부산광역시";
		} else if (i % 17 == 16) {
			mAddress = "제주특별자치도";
		}
		String mTel1 = "010";
		String mTel2 = "0000";
		String mTel3 = "0000";
		String tempBirth = "2000-01-01";
		Date mBirth = Date.valueOf(tempBirth);
		String mQuiz = "으";
		String mAnswer = "악";
		int result = dao.joinMember(new MemberDto(mId, mPw, mName, mEmailId, mEmailDomain, mAddress, mTel1, mTel2, mTel3,
		mBirth, mQuiz, mAnswer, null, null, null, null, null));
		
		System.out.println(result + i);
	}
	%>
</body>
</html>