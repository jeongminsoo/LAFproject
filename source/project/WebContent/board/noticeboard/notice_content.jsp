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
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
			});
	</script>
</head>
<body>
	<div>
		<div>
			<table>
				<caption>공지사항</caption>
				<tr>
					<th>제목</th>
					<td>${notice.nTitle }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${notice.nDate }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><pre>${notice.nContent }</pre></td>
				</tr>
			</table>
			<div>
				<button onclick="location.href='${conPath}/noticeUpdate_view.laf?nNo=${param.nNo }&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location.href='${conPath}/noticeDelete.laf?nNo=${param.nNo }&pageNum=${param.pageNum}'">삭제</button>
				<button onclick="location.href='${conPath}/noticeList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>
	</div>
</body>
</html>