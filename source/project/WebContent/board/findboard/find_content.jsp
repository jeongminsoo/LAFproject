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
				<caption>습득물 정보</caption>
				<tr>
					<td rowspan="8"><img src='board/imgcopy/${find.fPhoto eq null ? "noimg.gif" : find.fPhoto}'></td>
					<th>제목</th>
					<td>${find.fTitle }</td>
				</tr>
				<tr>
					<th>관리번호</th>
					<td>${find.fNo }</td>
				</tr>
				<tr>
					<th>습득일</th>
					<td>${find.fDate }</td>
				</tr>
				<tr>
					<th>습득장소</th>
					<td>${find.fLocation }</td>
				</tr>
				<tr>
					<th>물품구분</th>
					<td>${find.fOb }</td>
				</tr>
				<tr>
					<th>보관장소</th>
					<td>${find.fStorage }</td>
				</tr>
				<tr>
					<th>처리상태</th>
					<td>${find.fcc }</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${find.fTel }</td>
				</tr>
			</table>
			<div>
				<button onclick="location.href='${conPath}/findUpdate_view.laf?fNo=${param.fNo }&pageNum=${param.pageNum}'">수정</button>
				<button onclick="location.href='${conPath}/findCancel.laf?fNo=${param.fNo }&pageNum=${param.pageNum}'">삭제</button>
				<button onclick="location.href='${conPath}/findList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>
	</div>
</body>
</html>