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
			var loginMsg = '${loginMag}';
			var msg = '${param.msg}';
			
			
			if (loginMsg != "") {
				alert('${loginMsg}');
				history.back();
			} else if (msg == "find") {
				location.href='${conPath}/findWrite_view.laf';
			} else if (msg == "lost") {
				location.href='${conPath}/lostWrite_view.laf';
			} else if (msg == "info") {
				location.href='${conPath}/myInfo.laf';
			}
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