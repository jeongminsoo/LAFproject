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
		<div>
			<ul>
				<li><a href="${conPath }/login_view.laf">로그인</a></li>
				<li><a href="">로그아웃</a></li>
			</ul>
		</div>
		<div><h1>LOGO</h1></div>
		<div>
			<ul>
				<li><a href="${conPath }/findList.laf?pageNum=1">습득물</a></li>
				<li><a href="${conPath }/lostList.laf">분실물</a></li>
				<li><a href="${conPath }/my_info.laf">마이페이지</a></li>
				<li><a href="${conPath }/qnaList.laf">고객센터</a></li>
			</ul>
		</div>
	</div>
</body>
</html>