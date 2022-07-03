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
	<link href="${conPath}/css/footer.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
			});
	</script>
</head>
<body>
	<footer>
		<div id="wrap">
			<div id="logo">
				<h2>L·A·F</h2>
			</div>
			<div id="laf_copyright">
				<ul>
					<li>
						(주)L.A.F.시스템
					</li>
					<li>
						서울특별시 강남구 강남대로 333, 럭키빌딩 | 전화번호 : 02-1234-1234 
					</li>
					<li>
						<b>Copyright ⓒ L.A.F.System All Rights Reserved</b>
					</li>
				</ul>
			</div>
		</div>
	</footer>
</body>
</html>