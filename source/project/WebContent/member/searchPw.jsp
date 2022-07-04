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
	<link href="${conPath}/css/searchIdPw.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="search">
		<form action="${conPath }/searchPw.laf" method="post">
			<table>
				<caption>비밀번호 찾기</caption>
				<col style="width : 200px;">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="mId" class="mId"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="mName" class="mName">
					</td>
				</tr>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="비밀번호 찾기" class="btn">
				<input type="button" value="취소" class="btn" onclick="window.close()">
			</div>
		</form>
	</div>
</body>
</html>