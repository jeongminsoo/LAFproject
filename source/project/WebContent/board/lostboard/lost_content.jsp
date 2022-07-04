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
	<link href="${conPath}/css/find_content.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
			});
	</script>
</head>
<body>
	<jsp:include page="/main/header.jsp"/>
	<div id="content_wrap">
		<div class="snb">
			<ul>
				<li>분실물</li>
				<li><a href="${conPath }/lostList.laf?pageNum=1">분실물 목록</a></li>
				<li><a href="${conPath }/lostWrite_view.laf">분실물 등록</a></li>
			</ul>
		</div>
		<div class="content_title">
			<h1>습득물 상세보기</h1>
		</div>
		<hr color="#2e8fe3">
		<div class="content">
			<div class="img">
				<img
					src='board/imgcopy/${lost.lPhoto eq null ? "noimg.gif" : lost.lPhoto}'
					width="400" height="410">
			</div>
			<table id="up_table">
				<col style="width: 150px;">
				<col style="width: 200px;">
				<tr>
					<th>제목</th>
					<td>${lost.lTitle }</td>
				</tr>
				<tr>
					<th>관리번호</th>
					<td>${lost.lNo }</td>
				</tr>
				<tr>
					<th>분실일</th>
					<td>${lost.lDate }</td>
				</tr>
				<tr>
					<th>분실장소</th>
					<td>${lost.lLocation }</td>
				</tr>
				<tr>
					<th>물품구분</th>
					<td>${lost.lOb }</td>
				</tr>
				<tr>
					<th>처리상태</th>
					<td>${lost.lcc }</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${lost.lTel }</td>
				</tr>
			</table>
			<div id="s_table">
				<table id="down_table">
					<col style="width: 800px;">
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td><pre>${lost.lContent }</pre></td>
					</tr>
				</table>
			</div>
			<div class="btn_wrap">
				<button onclick="location.href='${conPath}/lostUpdate_view.laf?lNo=${param.lNo }&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location.href='${conPath}/lostCancel.laf?lNo=${param.lNo }&pageNum=${param.pageNum}'">등록취소</button>
				<button onclick="location.href='${conPath}/lostList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>
	</div>
	<jsp:include page="/main/footer.jsp"/>
</body>
</html>