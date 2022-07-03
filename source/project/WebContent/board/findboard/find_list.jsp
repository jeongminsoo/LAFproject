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
<link href="${conPath}/css/style.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
	});
</script>
</head>
<body>
<c:if test="${findWriteResult eq 0 }">
	<script>
		alert('습득물 등록에 실패하였습니다. 입력한 정보를 확인 후 다시 시도하세요.');
		history.back();
	</script>
</c:if>
<c:if test="${findWriteResult eq 1 }">
	<script>
		alert('등록되었습니다.');
	</script>
</c:if>
<c:if test="${findUpdateResult eq 0 }">
	<script>
		alert('내용수정에 실패하였습니다. 입력한 정보를 확인 후 다시 시도하세요.');
		history.back();
	</script>
</c:if>
<c:if test="${findUpdateResult eq 1 }">
	<script>
		alert('수정되었습니다.');
	</script>
</c:if>
<c:if test="${findCancelResult eq 0 }">
	<script>
		alert('등록취소에 실패하였습니다.해당 글이 이미 삭제 또는 등록취소되었거나 잘못된 경로입니다.');
		history.back();
	</script>
</c:if>
<c:if test="${findCancelResult eq 1 }">
	<script>
		alert('등록이 취소되었습니다.');
	</script>
</c:if>
	<jsp:include page="/main/header.jsp"/>
	<div id="content_wrap">
		<div class="snb">
			<ul>
				<li>습득물</li>
				<li><a href="${conPath }/findList.laf?pageNum=1">습득물 목록</a></li>
				<li><a href="${conPath }/findWrite_view.laf">습득물 등록</a></li>
			</ul>
		</div>
		<div class="search">
			
		</div>
		<div class="content">
			<table>
				<col style="width : 140px;">
				<col style="width : 80px;">
				<col style="width : 80px;">
				<col style="width : 160px;">
				<col style="width : 120px;">
				<col style="width : 80px;">
				<col style="width : 100px;">
				<col style="width : 120px;">
				<col style="width : 80px;">
				<tr class="first">
					<th>관리번호</th>
					<th>지역구분</th>
					<th>물품구분</th>
					<th>제목</th>
					<th>습득장소(보관장소)</th>
					<th>작성자</th>
					<th>연락처</th>
					<th>습득일</th>
					<th>조회수</th>
				</tr>
				<c:if test="${finds.size() eq 0 }">
					<tr>
						<td colspan="9">등록된 습득물이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${finds.size() != 0 }">
					<c:forEach items="${finds}" var="f">
						<tr>
							<td>${f.fNo }</td>
							<td>${f.fLocal }</td>
							<td>${f.fOb }</td>
							<td class="title"><a
								href="${conPath }/findContent.laf?fNo=${f.fNo}&pageNum=${currentPage}">${f.fTitle }</a>
								<c:if test="${f.fPhoto != null && f.fPhoto != \"noimg.gif\" }">
									<img
										src="https://t1.daumcdn.net/cafe_image/cf_img4/skin/W01/16_add_photo.svg">
								</c:if></td>
							<td>${f.fLocation }(${f.fStorage })</td>
							<td>${f.mName }</td>
							<td>${f.fTel }</td>
							<td>${f.fDate }</td>
							<td>${f.fHit }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<div class="paging">
			<a href="${conPath }/findList.laf?pageNum=${startPage - 1 eq 0 ? 1 : startPage-1}"><img src="${conPath }/img/btn01.gif"></a>
			<c:forEach var="j" begin="${startPage }" end="${endPage }">
				<c:if test="${j eq currentPage }">
					<b> ${j } </b>
				</c:if>
				<c:if test="${j != currentPage }">
					<a href="${conPath }/findList.laf?pageNum=${j}"> ${j } </a>
				</c:if>
			</c:forEach>
			<a href="${conPath }/findList.laf?pageNum=${endPage == pageCnt ? endPage : endPage + 1 }"><img src="${conPath }/img/btn0010.gif"></a>
		</div>
	</div>
	<jsp:include page="/main/footer.jsp"/>
</body>
</html>