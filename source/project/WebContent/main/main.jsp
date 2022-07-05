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
	<link href="${conPath}/css/main.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			var result = '${loginResult}';
			var msg = '${param.msg}';
			if (msg == 'find') {
				location.href='${conPath}/findWrite_view.laf';
			} else if (msg == "lost") {
				location.href='${conPath}/lostWrite_view.laf';
			} else if (msg == 'info') {
				location.href='${conPath}/myInfo.laf';
			} else if(msg == 'qna') {
				location.href='${conPath}/qnaWrite_view.laf';
			} else if(msg == '' && result == '0') {
				alert("아이디 또는 비밀번호를 잘못 입력했습니다.입력하신 내용을 다시 확인해주세요.");
				location.href='${conPath}/login_view.laf';
			}
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="main_wrap">
		<h2>하이</h2>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>