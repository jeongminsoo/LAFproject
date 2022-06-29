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
</head>
<body>
	<c:if test="${searchPwResult != null }">
		<script>
			alert('${searchPwResult}');
			history.back();
		</script>
	</c:if>
	<div>
		<form action="${conPath }/quizChk.laf" method="post">
			<table>
				<caption>비밀번호 찾기 질문/답변</caption>
				<tr>
					<td>질문</td>
					<td>${quiz }</td>
				</tr>
				<tr>
					<td>답변</td>
					<td><input type="text" name="mAnswer" class="mAnswer"></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="확인">
			</div>
		</form>
	</div>
</body>
</html>