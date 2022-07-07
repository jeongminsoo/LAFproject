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
					<li><a href="${conPath }/myInfo.laf">내정보</a></li>
				</c:if>
			</ul>
		</div>
		<div id="logo">
			<h1><a href="${conPath }/main.laf"><img src="${conPath }/img/logo.jpg"></a></h1>
		</div>
		<div id="laf_lnb">
			<ul>
				<li>
					<input type="checkbox" id="all_menu">
					<label for="all_menu" class="all_list" onclick="">&ensp; &ensp; &ensp; </label>
					<div class="all">
						<ul>
							<li><a href="${conPath }/findList.laf">습득물 목록</a></li>
							<li><a href="${conPath }/findWrite_view.laf">습득물 등록</a></li>
						</ul>
						<ul>
							<li><a href="${conPath }/lostList.laf">분실물 목록</a></li>
							<li><a href="${conPath }/lostWrite_view.laf">분실물 등록</a></li>
						</ul>
						<ul>
							<c:if test="${member == null }">
								<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
								<li><a href="${conPath }/myFindList.laf">습득물관리</a></li>
								<li><a href="${conPath }/myLostList.laf">분실물관리</a></li>
								<li><a href="${conPath }/changePw_view.laf">비밀번호 변경</a></li>
							</c:if>
							<c:if test="${member != null && member.pwCode eq \"PW00\" }">
								<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
								<li><a href="${conPath }/myFindList.laf">습득물관리</a></li>
								<li><a href="${conPath }/myLostList.laf">분실물관리</a></li>
								<li><a href="${conPath }/changePw_view.laf">비밀번호 변경</a></li>
							</c:if>
							<c:if test="${member != null && ((member.pwCode eq \"PW01\") || (member.pwCode eq \"PW10\")) }">
								<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
								<c:if test="${member.pwCode eq \"PW10\" }">
									<li><a href="${conPath }/memberList.laf">회원관리</a></li>
									<li><a href="${conPath }/add_view.laf">관리자추가</a></li>
								</c:if>
								<li><a href="${conPath }/pw_change_view.laf">비밀번호 변경</a></li>
							</c:if>
						</ul>
						<ul>
							<li><a href="${conPath }/qnaList.laf">Q&amp;A 목록</a></li>
							<c:if test="${member == null || (member != null && member.pwCode eq \"PW00\")}">
								<li><a href="${conPath }/qnaWrite_view.laf">문의하기</a></li>
							</c:if>
							<li><a href="${conPath }/noticeList.laf">공지사항</a></li>
							<c:if test="${member != null && member.pwCode eq \"PW10\" }">
								<li><a href="${conPath }/noticeWrite_view.laf">공지사항 등록</a></li>
							</c:if>
						</ul>
					</div>
				</li>
				<c:if test="${member.pwCode eq \"PW00\" }">
					<li><a href="${conPath }/findList.laf?pageNum=1">습득물</a></li>
					<li><a href="${conPath }/lostList.laf?pageNum=1">분실물</a></li>
					<li><a href="${conPath }/myInfo.laf">마이페이지</a></li>
					<li><a href="${conPath }/qnaList.laf">고객센터</a></li>
				</c:if>
				<c:if test="${member.pwCode eq \"PW01\" || member.pwCode eq \"PW10\" }">
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