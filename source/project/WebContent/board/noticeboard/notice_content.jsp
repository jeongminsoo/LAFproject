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
	<link href="${conPath}/css/notice_content.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
			});
	</script>
</head>
<body>
	<jsp:include page="/main/header.jsp"/>
	<div id="content_wrap">
		<div class="snb">
			<ul>
				<li>고객센터</li>
				<li><a href="${conPath }/qnaList.laf?pageNum=1">Q&amp;A 목록</a></li>
				<li><a href="${conPath }/qnaWrite_view.laf">문의하기</a></li>
				<li><a href="${conPath }/noticeList.laf?pageNum=1">공지사항</a></li>
				<c:if test="${member.pwCode eq \"PW01\" || member.pwCode eq \"PW10\" }">
					<li><a href="${conPath }/noticeWrite_view.laf?pageNum=${param.pageNum}">공지사항 등록</a></li>
				</c:if>
			</ul>
		</div>
		<div class="content_title">
			<h1>공지사항</h1>
		</div>
		<hr color="#2e8fe3">
		<div class="content">
			<table>
				<col style="width : 200px;">
				<col style="width : 600px;">
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
					<td style="height : 200px;"><pre>${notice.nContent }</pre></td>
				</tr>
			</table>
			<div class="btn_wrap">
				<button onclick="location.href='${conPath}/noticeUpdate_view.laf?nNo=${param.nNo }&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location.href='${conPath}/noticeDelete.laf?nNo=${param.nNo }&pageNum=${param.pageNum}'">삭제</button>
				<button onclick="location.href='${conPath}/noticeList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>
	</div>
</body>
</html>