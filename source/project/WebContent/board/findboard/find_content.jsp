<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/find_content.css" rel="stylesheet">
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function() {
		});
	</script>
</head>
<body>
	<jsp:include page="/main/header.jsp" />
	<div id="content_wrap">
		<div class="snb">
			<ul>
				<li>습득물</li>
				<li><a href="${conPath }/findList.laf?pageNum=1">습득물 목록</a></li>
				<li><a href="${conPath }/findWrite_view.laf">습득물 등록</a></li>
			</ul>
		</div>
		<div class="content_title">
			<h1>습득물 상세보기</h1>
		</div>
		<hr color="#2e8fe3">
		<div class="content">
			<div class="img">
				<img
					src='board/imgcopy/${find.fPhoto eq null ? "noimg.gif" : find.fPhoto}'
					width="400" height="390">
			</div>
			<table id="up_table">
				<col style="width: 150px;">
				<col style="width: 200px;">
				<tr>
					<th>습득물명</th>
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
			<div id="s_table">
				<table id="down_table">
					<col style="width: 800px;">
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td><pre>${find.fContent }</pre></td>
					</tr>
				</table>
			</div>
			<div class="btn_wrap">
				<c:if test="${member != null && member.mId eq find.mId }">
					<button
					onclick="location.href='${conPath}/findUpdate_view.laf?fNo=${param.fNo }&pageNum=${param.pageNum}'">수정</button>
				<button
					onclick="location.href='${conPath}/findCancel.laf?fNo=${param.fNo }&pageNum=${param.pageNum}'">등록취소</button>
				</c:if>
				<button
					onclick="location.href='${conPath}/findList.laf?pageNum=${param.pageNum}'">목록</button>
			</div>
		</div>

	</div>
	<jsp:include page="/main/footer.jsp" />
</body>
</html>