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
		<form action="${conPath }/noticeUpdate.laf" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="nNo" value="${notice.nNo }">
			<div>
				<table>
					<caption>공지사항</caption>
					<tr>
						<td>제목</td>
						<td><input type="text" name="nTitle" class="nTitle" value="${notice.nTitle }"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="nContent" class="nContent">${notice.nContent }</textarea></td>
					</tr>
					<tr>
						<td>파일첨부</td>
						<td><input type="file" name="nFilename" class="nFilename"></td>
					</tr>
				</table>
			</div>
			<div>
				<input type="submit" value="수정" class="btn">
				<input type="reset" value="초기화" class="btn">
				<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/noticeList.laf?pageNum=${param.pageNum }'">
			</div>
		</form>
	</div>
</body>
</html>