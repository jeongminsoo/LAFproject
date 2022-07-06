<%@page import="java.sql.Date"%>
<%@page import="com.laf.dto.LostDto"%>
<%@page import="com.laf.dao.LostDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
</head>
<body>
	<%
		LostDao dao = LostDao.getInstance();
	
		for (int i = 1; i <= 150; i++) {
			
			String 	lTitle = "지갑";
			String 	lContent = "찾아줘" + i;
			String 	mId = "aaa"+i;
			String 	lOb = null;
			if (i % 11 == 0) {
				lOb = "지갑";
			} else if (i % 11 == 1) {
				lOb = "서류";
			} else if (i % 11 == 2) {
				lOb = "가방";
			} else if (i % 11 == 3) {
				lOb = "핸드폰";
			} else if (i % 11 == 4) {
				lOb = "옷";
			} else if (i % 11 == 5) {
				lOb = "귀금속";
			} else if (i % 11 == 6) {
				lOb = "쇼핑백";
			} else if (i % 11 == 7) {
				lOb = "전자기기";
			} else if (i % 11 == 8) {
				lOb = "카드";
			} else if (i % 11 == 9) {
				lOb = "기타";
			} else if (i % 11 == 10) {
				lOb = "책";
			}
			
			String 	lLocal = null;
			if (i % 17 == 0) {
				lLocal = "서울특별시";
			} else if (i % 17 == 1) {
				lLocal = "경기도";
			} else if (i % 17 == 2) {
				lLocal = "인천광역시";
			} else if (i % 17 == 3) {
				lLocal = "강원도";
			} else if (i % 17 == 4) {
				lLocal = "충청북도";
			} else if (i % 17 == 5) {
				lLocal = "충청남도";
			} else if (i % 17 == 6) {
				lLocal = "대전광역시";
			} else if (i % 17 == 7) {
				lLocal = "세종특별자치시";
			} else if (i % 17 == 8) {
				lLocal = "전라남도";
			} else if (i % 17 == 9) {
				lLocal = "전라북도";
			} else if (i % 17 == 10) {
				lLocal = "광주광역시";
			} else if (i % 17 == 11) {
				lLocal = "경상북도";
			} else if (i % 17 == 12) {
				lLocal = "경상남도";
			} else if (i % 17 == 13) {
				lLocal = "대구광역시";
			} else if (i % 17 == 14) {
				lLocal = "울산광역시";
			} else if (i % 17 == 15) {
				lLocal = "부산광역시";
			} else if (i % 17 == 16) {
				lLocal = "제주특별자치도";
			}
			
			String 	lLocation = "술집"+i;
			String tempDate = "2022-06-01";
			
			if (i / 10 == 1) {
				tempDate = "2022-06-02";
			} else if (i / 10 == 2) {
				tempDate = "2022-06-03";
			} else if (i / 10 == 3) {
				tempDate = "2022-06-04";
			} else if (i / 10 == 4) {
				tempDate = "2022-06-05";
			} else if (i / 10 == 5) {
				tempDate = "2022-06-06";
			} else if (i / 10 == 6) {
				tempDate = "2022-06-07";
			} else if (i / 10 == 7) {
				tempDate = "2022-06-08";
			} else if (i / 10 == 8) {
				tempDate = "2022-06-09";
			} else if (i / 10 == 9) {
				tempDate = "2022-06-10";
			} else if (i / 10 == 10) {
				tempDate = "2022-06-11";
			} else if (i / 10 == 11) {
				tempDate = "2022-06-12";
			} else if (i / 10 == 12) {
				tempDate = "2022-06-13";
			} else if (i / 10 == 13) {
				tempDate = "2022-06-14";
			} else if (i / 10 == 14) {
				tempDate = "2022-06-15";
			} else if (i / 10 == 15) {
				tempDate = "2022-06-16";
			}
			Date 	lDate = Date.valueOf(tempDate);
			
			int 	fHit = 0;
			String 	lTel = "010-0000-0000";
			String 	lIp = "127.0.0."+i;
			String 	mName = "홍길동"+i;
			
			LostDto dto = new LostDto(null, lTitle, lContent, mId, null, lOb, lLocal, lLocation, lDate, "noimg.gif", 0, lTel, lIp, null, null, null);
			
			int result = dao.writeLost(dto);
			
			System.out.println(result +"/" +i);
		}
	%>
</body>
</html>