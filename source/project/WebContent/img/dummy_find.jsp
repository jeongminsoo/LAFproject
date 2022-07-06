<%@page import="java.sql.Date"%>
<%@page import="com.laf.dto.FindDto"%>
<%@page import="com.laf.dao.FindDao"%>
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
		FindDao dao = FindDao.getInstance();
	
		for (int i = 1; i <= 150; i++) {
			
			String 	fTitle = "지갑";
			String 	fContent = "가져가" + i;
			String 	mId = "aaa"+i;
			String 	fOb = null;
			if (i % 11 == 0) {
				fOb = "지갑";
			} else if (i % 11 == 1) {
				fOb = "서류";
			} else if (i % 11 == 2) {
				fOb = "가방";
			} else if (i % 11 == 3) {
				fOb = "핸드폰";
			} else if (i % 11 == 4) {
				fOb = "옷";
			} else if (i % 11 == 5) {
				fOb = "귀금속";
			} else if (i % 11 == 6) {
				fOb = "쇼핑백";
			} else if (i % 11 == 7) {
				fOb = "전자기기";
			} else if (i % 11 == 8) {
				fOb = "카드";
			} else if (i % 11 == 9) {
				fOb = "기타";
			} else if (i % 11 == 10) {
				fOb = "책";
			}
			
			String 	fLocal = null;
			if (i % 17 == 0) {
				fLocal = "서울특별시";
			} else if (i % 17 == 1) {
				fLocal = "경기도";
			} else if (i % 17 == 2) {
				fLocal = "인천광역시";
			} else if (i % 17 == 3) {
				fLocal = "강원도";
			} else if (i % 17 == 4) {
				fLocal = "충청북도";
			} else if (i % 17 == 5) {
				fLocal = "충청남도";
			} else if (i % 17 == 6) {
				fLocal = "대전광역시";
			} else if (i % 17 == 7) {
				fLocal = "세종특별자치시";
			} else if (i % 17 == 8) {
				fLocal = "전라남도";
			} else if (i % 17 == 9) {
				fLocal = "전라북도";
			} else if (i % 17 == 10) {
				fLocal = "광주광역시";
			} else if (i % 17 == 11) {
				fLocal = "경상북도";
			} else if (i % 17 == 12) {
				fLocal = "경상남도";
			} else if (i % 17 == 13) {
				fLocal = "대구광역시";
			} else if (i % 17 == 14) {
				fLocal = "울산광역시";
			} else if (i % 17 == 15) {
				fLocal = "부산광역시";
			} else if (i % 17 == 16) {
				fLocal = "제주특별자치도";
			}
			
			String 	fLocation = "버스정류장";
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
			Date 	fDate = Date.valueOf(tempDate);
			
			String	fStorage = "경찰서";
			int 	fHit = 0;
			String 	fTel = "010-0000-0000";
			String 	fIp = "127.0.0."+i;
			String 	mName = "홍길동"+i;
			
			FindDto dto = new FindDto(null, fTitle, fContent, mId, null, fOb, fLocal, fLocation, fDate, fStorage, "noimg.gif", 0, fTel, fIp, null, null, null);
			
			int result = dao.writeFind(dto);
			
			System.out.println(result +"/" +i);
		}
	%>
</body>
</html>