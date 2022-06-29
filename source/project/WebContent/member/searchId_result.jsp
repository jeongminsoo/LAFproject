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
	<c:if test="${searchIdResult != null }">
		<script>
			alert('${searchIdResult}');
			history.back();
		</script>
	</c:if>
	<h2>검색결과</h2>
	<span>${mId }</span>
	<div>
		<button onclick="location.href='${conPath}/searchPw_view.laf'">비밀번호 찾기</button>
		<button onclick="window.close()">닫기</button>
	</div>
</body>
</html>