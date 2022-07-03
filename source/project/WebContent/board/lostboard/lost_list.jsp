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
<c:if test="${lostWriteResult eq 0 }">
	<script>
		alert('분실물 등록에 실패하였습니다. 입력한 정보를 확인 후 다시 시도하세요.');
		history.back();
	</script>
</c:if>
<c:if test="${lostWriteResult eq 1 }">
	<script>
		alert('등록되었습니다.');
	</script>
</c:if>
<c:if test="${lostUpdateResult eq 0 }">
	<script>
		alert('내용수정에 실패하였습니다. 입력한 정보를 확인 후 다시 시도하세요.');
		history.back();
	</script>
</c:if>
<c:if test="${lostUpdateResult eq 1 }">
	<script>
		alert('수정되었습니다.');
	</script>
</c:if>
<c:if test="${lostCancelResult eq 0 }">
	<script>
		alert('등록취소에 실패하였습니다.해당 글이 이미 삭제 또는 등록취소되었거나 잘못된 경로입니다.');
		history.back();
	</script>
</c:if>
<c:if test="${lostCancelResult eq 1 }">
	<script>
		alert('등록이 취소되었습니다.');
	</script>
</c:if>
	<div>
		<div>
			<ul>
				<li><a href="${conPath }/lostList.laf?pageNum=1">분실물 목록</a></li>
				<li><a href="${conPath }/lostWrite_view.laf">분실물 등록</a></li>
			</ul>
		</div>
		<div>
			<table>
				<tr>
					<th>관리번호</th>
					<th>지역구분</th>
					<th>물품구분</th>
					<th>제목</th>
					<th>분실장소</th>
					<th>작성자</th>
					<th>연락처</th>
					<th>분실일</th>
					<th>조회수</th>
				</tr>
				<c:if test="${losts.size() eq 0 }">
					<tr>
						<td colspan="9">등록된 습득물이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${losts.size() != 0 }">
					<c:forEach items="${losts}" var="l">
						<tr>
							<td>${l.lNo }</td>
							<td>${l.lLocal }</td>
							<td>${l.lOb }</td>
							<td><a
								href="${conPath }/lostContent.laf?lNo=${l.lNo}&pageNum=${currentPage}">${l.lTitle }</a>
								<c:if test="${l.lPhoto != null && l.lPhoto != \"noimg.gif\" }">
									<img
										src="https://t1.daumcdn.net/cafe_image/cf_img4/skin/W01/16_add_photo.svg">
								</c:if></td>
							<td>${l.lLocation }</td>
							<td>${l.mName }</td>
							<td>${l.lTel }</td>
							<td>${l.lDate }</td>
							<td>${l.lHit }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>