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
	<link href="${conPath}/css/find_list.css" rel="stylesheet">
</head>
<body>
	<c:if test="${member == null }">
		<script>
			alert('로그인이 필요한 페이지입니다. 로그인페이지로 이동합니다.');
			location.href = '${conPath}/login_view.laf?msg=find';
		</script>
	</c:if>
	<jsp:include page="/main/header.jsp" />
	<div id="list_wrap">
		<div class="snb">
			<ul>
				<li>마이페이지</li>
				<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
				<li><a href="${conPath }/myFindList.laf">습득물 관리</a></li>
				<li><a href="${conPath }/myLostList.laf">분실물 관리</a></li>
				<li><a href="${conPath }/pw_change_view.laf">비밀번호 변경</a></li>
			</ul>
		</div>
		<div class="content_title">
			<h1>등록한 습득물 목록</h1>
		</div>
		<hr color="#2e8fe3">
		<div id="sub_wrap">
			<div class="content">
				<table>
					<col style="width: 130px;">
					<col style="width: 100px;">
					<col style="width: 100px;">
					<col style="width: 200px;">
					<col style="width: 150px;">
					<col style="width: 120px;">
					<col style="width: 90px;">
					<col style="width: 80px;">
					<col style="width: 50px;">
					<tr>
						<th>관리번호</th>
						<th>지역구분</th>
						<th>물품구분</th>
						<th>습득물명</th>
						<th>습득장소(보관장소)</th>
						<th>연락처</th>
						<th>습득일</th>
						<th>처리상태</th>
						<th>조회수</th>
					</tr>
					<c:if test="${finds.size() eq 0 }">
						<tr>
							<td colspan="9">등록된 습득물이 없습니다</td>
						</tr>
					</c:if>
					<c:if test="${finds.size() != 0 }">
						<c:forEach items="${finds}" var="f">
							<c:if test="${f.fstCode eq \"FST01\" }">
								<tr style="color : blue;">
									<td>${f.fNo }</td>
									<td>${f.fLocal }</td>
									<td>${f.fOb }</td>
									<td class="title"><a
										href="${conPath }/myFindContent.laf?fNo=${f.fNo}&pageNum=${currentPage}" style="color : blue;">${f.fTitle }</a>
										<c:if test="${f.fPhoto != null && f.fPhoto != \"noimg.gif\" }">
											<img
												src="https://t1.daumcdn.net/cafe_image/cf_img4/skin/W01/16_add_photo.svg">
										</c:if></td>
									<td>${f.fLocation }(${f.fStorage })</td>
									<td>${f.fTel }</td>
									<td>${f.fDate }</td>
									<td>${f.fcc }</td>
									<td>
										<fmt:formatNumber value="${f.fHit }" pattern="#,###"/>							
									</td>
								</tr>
							</c:if>
							<c:if test="${f.fstCode eq \"FST02\" }">
								<tr style="color : red;">
									<td>${f.fNo }</td>
									<td>${f.fLocal }</td>
									<td>${f.fOb }</td>
									<td class="title"><a
										href="${conPath }/myFindContent.laf?fNo=${f.fNo}&pageNum=${currentPage}" style="color : red">${f.fTitle }</a>
										<c:if test="${f.fPhoto != null && f.fPhoto != \"noimg.gif\" }">
											<img
												src="https://t1.daumcdn.net/cafe_image/cf_img4/skin/W01/16_add_photo.svg">
										</c:if></td>
									<td>${f.fLocation }(${f.fStorage })</td>
									<td>${f.fTel }</td>
									<td>${f.fDate }</td>
									<td>${f.fcc }</td>
									<td>
										<fmt:formatNumber value="${f.fHit }" pattern="#,###"/>							
									</td>
								</tr>
							</c:if>
							<c:if test="${f.fstCode eq \"FST00\" }">
								<tr>
									<td>${f.fNo }</td>
									<td>${f.fLocal }</td>
									<td>${f.fOb }</td>
									<td class="title"><a
										href="${conPath }/myFindContent.laf?fNo=${f.fNo}&pageNum=${currentPage}">${f.fTitle }</a>
										<c:if test="${f.fPhoto != null && f.fPhoto != \"noimg.gif\" }">
											<img
												src="https://t1.daumcdn.net/cafe_image/cf_img4/skin/W01/16_add_photo.svg">
										</c:if></td>
									<td>${f.fLocation }(${f.fStorage })</td>
									<td>${f.fTel }</td>
									<td>${f.fDate }</td>
									<td>${f.fcc }</td>
									<td>
										<fmt:formatNumber value="${f.fHit }" pattern="#,###"/>							
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</c:if>
				</table>
			</div>
			<div class="paging">
				<a
					href="${conPath }/findList.laf?pageNum=${startPage - 1 eq 0 ? 1 : startPage-1}"><img
					src="${conPath }/img/btn01.gif"></a>
				<c:forEach var="j" begin="${startPage }" end="${endPage }">
					<c:if test="${j eq currentPage }">
						<b> ${j } </b>
					</c:if>
					<c:if test="${j != currentPage }">
						<a href="${conPath }/findList.laf?pageNum=${j}"> ${j } </a>
					</c:if>
				</c:forEach>
				<a
					href="${conPath }/findList.laf?pageNum=${endPage == pageCnt ? endPage : endPage + 1 }"><img
					src="${conPath }/img/btn0010.gif"></a>
			</div>
		</div>
	</div>
	<jsp:include page="/main/footer.jsp" />
</body>
</html>