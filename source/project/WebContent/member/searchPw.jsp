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
	<div>
		<form action="${conPath }/searchPw.laf" method="post">
			<table>
				<caption>비밀번호 찾기</caption>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mId" class="mId"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="mName" class="mName">
					</td>
				</tr>
			</table>
			<div>
				<input type="submit" value="비밀번호 찾기" class="btn">
				<input type="button" value="취소" class="btn" onclick="window.close()">
			</div>
		</form>
	</div>
</body>
</html>