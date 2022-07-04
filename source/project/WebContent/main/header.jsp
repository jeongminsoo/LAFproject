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
	<link href="${conPath}/css/header.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
			});
	</script>
</head>
<body>
	<header>
		<div id="laf_gnb">
			<ul>
				<c:if test="${member eq null }">
					<li><a href="${conPath }/join_view.laf">회원가입</a></li>
					<li><a href="${conPath }/login_view.laf">로그인</a></li>
				</c:if>
				<c:if test="${member != null }">
					<li><a href="${conPath }/logout.laf">로그아웃</a></li>
					<li><a href="${conPath }/my_info.laf">내정보</a></li>
				</c:if>
			</ul>
		</div>
		<div id="logo">
			<h1><a href="${conPath }/main.laf"><img src="${conPath }/img/logo.jpg"></a></h1>
		</div>
		<div id="laf_lnb">
			<ul>
				<c:if test="${member.pwCode eq \"PW00\" }">
					<li><a href="${conPath }/findList.laf?pageNum=1">습득물</a></li>
					<li><a href="${conPath }/lostList.laf?pageNum=1">분실물</a></li>
					<li><a href="${conPath }/myInfo.laf">마이페이지</a></li>
					<li><a href="${conPath }/qnaList.laf">고객센터</a></li>
				</c:if>
				<c:if test="${member.pwCode eq \"PW01\" }">
					<li><a href="${conPath }/findList.laf?pageNum=1">습득물</a></li>
					<li><a href="${conPath }/lostList.laf?pageNum=1">분실물</a></li>
					<li><a href="${conPath }/myInfo.laf">관리자</a></li>
					<li><a href="${conPath }/qnaList.laf">고객센터</a></li>
				</c:if>
				<c:if test="${member == null }">
					<li><a href="${conPath }/findList.laf?pageNum=1">습득물</a></li>
					<li><a href="${conPath }/lostList.laf?pageNum=1">분실물</a></li>
					<li><a href="${conPath }/myInfo.laf">마이페이지</a></li>
					<li><a href="${conPath }/qnaList.laf">고객센터</a></li>
				</c:if>
				
			</ul>
		</div>
	</header>
</body>
</html>