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
			<table>
				<caption>분실물 정보</caption>
				<tr>
					<td rowspan="7"><img src='board/imgcopy/${lost.lPhoto eq null ? "noimg.gif" : lost.lPhoto}'></td>
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
				<tr>
					<td>내용</td>
					<td colspan="2"><pre>${lost.lContent }</pre></td>
				</tr>
			</table>
			<div>
				<button onclick="location.href='${conPath}/lostUpdate_view.laf?lNo=${param.lNo }&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location.href='${conPath}/lostCancel.laf?lNo=${param.lNo }&pageNum=${param.pageNum}'">등록취소</button>
				<button onclick="location.href='${conPath}/lostList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>
	</div>
</body>
</html>