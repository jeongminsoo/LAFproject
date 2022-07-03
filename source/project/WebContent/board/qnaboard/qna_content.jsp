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
				<caption>Q&amp;A</caption>
				<tr>
					<th>제목</th>
					<td>${qna.qTitle }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><pre>${qna.qContent }</pre></td>
				</tr>
			</table>
			<div>
				<button onclick="location.href='${conPath}/qnaUpdate_view.laf?qNo=${param.qNo }&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location.href='${conPath}/qnaReply_view.laf?qNo=${param.qNo }&pageNum=${param.pageNum}'">답글작성</button>
				<button onclick="location.href='${conPath}/qnaDelete.laf?qNo=${param.qNo }&pageNum=${param.pageNum}'">삭제</button>
				<button onclick="location.href='${conPath}/qnaList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>
	</div>
</body>
</html>