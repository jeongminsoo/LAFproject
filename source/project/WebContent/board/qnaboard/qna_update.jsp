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
		<form action="${conPath }/qnaUpdate.laf" method="post">
			<input type="hidden" name="pageNum" value="${param.pageNum }">
			<input type="hidden" name="qNo" value="${qna.qNo }">
			<div>
				<table>
					<caption>Q&amp;A</caption>
					<tr>
						<td>제목</td>
						<td><input type="text" name="qTitle" class="qTitle" value="${qna.qTitle }"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="mName" class="mName"
							value="${member.mName }" readonly="readonly"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="qContent" class="qContent">${qna.qContent }</textarea></td>
					</tr>
				</table>
			</div>
			<div>
				<input type="submit" value="수정" class="btn">
				<input type="reset" value="초기화" class="btn">
				<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/qnaList.laf?pageNum=${param.pageNum }'">
			</div>
		</form>
	</div>
</body>
</html>