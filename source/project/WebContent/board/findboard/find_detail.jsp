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
	<jsp:include page="/main/header.jsp" />
	<div id="list_wrap">
		<div class="snb">
			<ul>
				<li>습득물</li>
				<li><a href="${conPath }/findList.laf?pageNum=1">습득물 목록</a></li>
				<li><a href="${conPath }/findWrite_view.laf">습득물 등록</a></li>
			</ul>
		</div>
		<div class="search">
			<form action="${conPath }/detailSearch.laf" method="post">
				<table>
					<caption>상세검색</caption>
					<tr>
							<th>물품구분</th>
							<td><select name="fOb" class="fOb" size="1">
									<option value="">분류</option>
									<option>지갑</option>
									<option>서류</option>
									<option>가방</option>
									<option>핸드폰</option>
									<option>옷</option>
									<option>책</option>
									<option>귀금속</option>
									<option>쇼핑백</option>
									<option>전자기기</option>
									<option>카드</option>
									<option>기타</option>
							</select></td>
						</tr>
						<tr>
							<th><span>＊</span>지역구분</th>
							<td><select name="fLocal" class="fLocal" size="1">
									<option
										${member.mAddress == "서울특별시" ? "selected=\"selected\"" : ""}>서울특별시</option>
									<option
										${member.mAddress == "경기도" ? "selected=\"selected\"" : ""}>경기도</option>
									<option
										${member.mAddress == "인천광역시" ? "selected=\"selected\"" : ""}>인천광역시</option>
									<option
										${member.mAddress == "강원도" ? "selected=\"selected\"" : ""}>강원도</option>
									<option
										${member.mAddress == "충청북도" ? "selected=\"selected\"" : ""}>충청북도</option>
									<option
										${member.mAddress == "충청남도" ? "selected=\"selected\"" : ""}>충청남도</option>
									<option
										${member.mAddress == "대전광역시" ? "selected=\"selected\"" : ""}>대전광역시</option>
									<option
										${member.mAddress == "세종특별자치시" ? "selected=\"selected\"" : ""}>세종특별자치시</option>
									<option
										${member.mAddress == "전라북도" ? "selected=\"selected\"" : ""}>전라북도</option>
									<option
										${member.mAddress == "전라남도" ? "selected=\"selected\"" : ""}>전라남도</option>
									<option
										${member.mAddress == "광주광역시" ? "selected=\"selected\"" : ""}>광주광역시</option>
									<option
										${member.mAddress == "경상북도" ? "selected=\"selected\"" : ""}>경상북도</option>
									<option
										${member.mAddress == "경산남도" ? "selected=\"selected\"" : ""}>경산남도</option>
									<option
										${member.mAddress == "울산광역시" ? "selected=\"selected\"" : ""}>울산광역시</option>
									<option
										${member.mAddress == "대구광역시" ? "selected=\"selected\"" : ""}>대구광역시</option>
									<option
										${member.mAddress == "부산광역시" ? "selected=\"selected\"" : ""}>부산광역시</option>
									<option
										${member.mAddress == "제주특별자치도" ? "selected=\"selected\"" : ""}>제주특별자치도</option>
							</select></td>
						</tr>
						<tr>
							<th><span>＊</span>습득일</th>
							<td><input type="text" name="tempDate1" class="tempDate1"
								id="datepicker"></td>
						</tr>
						<tr>
							<th><span>＊</span>연락처</th>
							<td><input type="tel" name="fTel" class="fTel"
								value="${member.mTel1 }-${member.mTel2 }-${member.mTel3 }"></td>
						</tr>
						<tr>
							<th><span>＊</span>습득물명</th>
							<td><input type="text" name="fTitle" class="fTitle"></td>
						</tr>
				</table>
			</form>
		</div>
		<div id="sub_wrap">
			<div class="content">
				<table>
					<col style="width: 160px;">
					<col style="width: 100px;">
					<col style="width: 100px;">
					<col style="width: 200px;">
					<col style="width: 150px;">
					<col style="width: 80px;">
					<col style="width: 120px;">
					<col style="width: 90px;">
					<col style="width: 50px;">
					<tr>
						<th>관리번호</th>
						<th>지역구분</th>
						<th>물품구분</th>
						<th>습득물명</th>
						<th>습득장소(보관장소)</th>
						<th>작성자</th>
						<th>연락처</th>
						<th>습득일</th>
						<th>조회수</th>
					</tr>
					<c:if test="${finds.size() eq 0 }">
						<tr>
							<td colspan="9">검색 결과가 없습니다</td>
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
								<td>
									<fmt:formatNumber value="${f.fHit }" pattern="#,###"/>							
								</td>
							</tr>
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