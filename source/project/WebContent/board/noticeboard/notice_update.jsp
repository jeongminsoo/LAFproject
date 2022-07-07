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
<link href="${conPath}/css/notice_write.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
	});
</script>
</head>
<body>
	<jsp:include page="/main/header.jsp" />
	<div id="write_wrap">


		<div class="snb">
			<ul>
				<li>고객센터</li>
				<li><a href="${conPath }/qnaList.laf?pageNum=1">Q&amp;A 목록</a></li>
				<c:if test="${member.pwCode eq \"PW00\" }">
					<li><a href="${conPath }/qnaWrite_view.laf">문의하기</a></li>
				</c:if>
				<li><a href="${conPath }/noticeList.laf?pageNum=1">공지사항</a></li>
				<c:if
					test="${member.pwCode eq \"PW01\" || member.pwCode eq \"PW10\" }">
					<li><a
						href="${conPath }/noticeWrite_view.laf?pageNum=${param.pageNum}">공지사항
							등록</a></li>
				</c:if>
			</ul>
		</div>
		<div class="content_title">
			<h1>공지사항 등록</h1>
		</div>
		<hr color="#2e8fe3">
		<form action="${conPath }/noticeUpdate.laf" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="nNo" value="${notice.nNo }">
			<div class="write">
				<table>
					<col style="width: 200px;">
					<col style="width: 600px;">
					<tr>
						<td>제목</td>
						<td><input type="text" name="nTitle" class="nTitle"
							value="${notice.nTitle }"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td style="height: 200px; padding: 10px;"><textarea
								name="nContent" class="nContent" rows="15" cols="10">${notice.nContent }</textarea></td>
					</tr>
					<tr>
						<td>파일첨부</td>
						<td><input type="file" name="nFilename" class="nFilename"></td>
					</tr>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="submit" value="수정" class="btn"> <input
					type="reset" value="초기화" class="btn"> <input type="button"
					value="목록" class="btn"
					onclick="location.href='${conPath}/noticeList.laf?pageNum=${param.pageNum }'">
			</div>
		</form>
	</div>
	<jsp:include page="/main/footer.jsp" />
</body>
</html>