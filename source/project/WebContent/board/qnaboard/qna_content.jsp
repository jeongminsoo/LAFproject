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
	<link href="${conPath}/css/qna_content.css" rel="stylesheet">
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
			<h1>Q&amp;A</h1>
		</div>
		<hr color="#2e8fe3">
		<div class="content">
			<table>
				<col style="width : 200px;">
				<col style="width : 600px;">
				<tr>
					<th>제목</th>
					<td>${qna.qTitle }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td style="height : 200px;"><pre>${qna.qContent }</pre></td>
				</tr>
			</table>
			<div class="btn_wrap">
				<c:if test="${member != null && member.mId eq qna.mId }">
					<button onclick="location.href='${conPath}/qnaUpdate_view.laf?qNo=${param.qNo }&pageNum=${param.pageNum}'">수정</button>
					<button onclick="location.href='${conPath}/qnaDelete.laf?qNo=${param.qNo }&pageNum=${param.pageNum}'">삭제</button>
				</c:if>
				<c:if test="${member.pwCode eq \"PW01\" || member.pwCode eq \"PW10\" }">
					<button onclick="location.href='${conPath}/qnaReply_view.laf?qNo=${param.qNo }&pageNum=${param.pageNum}'">답글작성</button>
				</c:if>
				<button onclick="location.href='${conPath}/qnaList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>
	</div>
	<jsp:include page="/main/footer.jsp"/>
</body>
</html>