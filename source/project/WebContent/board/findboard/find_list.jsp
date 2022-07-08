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
<link href="${conPath}/css/find_list.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
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
	<c:if test="${msg eq \"mfu\" }">
		location.href="${conPath }/myFindList.laf?pageNum=${pageNum }";
	</c:if>
	<c:if test="${msg eq \"mfc\" }">
		location.href="${conPath }/myFindList.laf?pageNum=${pageNum }";
	</c:if>
	<jsp:include page="/main/header.jsp" />
	<div id="list_wrap">
		<div class="snb">
			<ul>
				<li>습득물</li>
				<li><a href="${conPath }/findList.laf?pageNum=1">습득물 목록</a></li>
				<li><a href="${conPath }/findWrite_view.laf">습득물 등록</a></li>
			</ul>
		</div>
		<div class="content_title">
			<h1>습득물 목록</h1>
		</div>
		<hr color="#2e8fe3">
		<div class="search">
			<form action="${conPath }/findDetailSearch.laf" method="post">
				<table>
					<caption>습득물 상세검색</caption>
					<tr>
						<th>지역구분</th>
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
						<th>습득물명</th>
						<td><input type="text" name="fTitle" class="fTitle"></td>
					</tr>
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
						<th>습득일</th>
						<td><input type="text" name="tempDate1" class="tempDate1"
							id="datepicker"> ~ <input type="text" name="tempDate2"
							class="tempDate2" id="datepicker2"></td>
					</tr>
					<tr>
						<td colspan="4"><input type="submit" value="검색" class="btn"></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="sub_wrap">
			<div class="content">
				<table>
					<col style="width: 160px;">
					<col style="width: 110px;">
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
								<td>
									<c:if test="${f.pwCode eq \"PW10\" || f.pwCode eq \"PW01\" }">
										관리자
									</c:if>
									<c:if test="${f.pwCode != \"PW10\" && f.pwCode != \"PW01\" }">
										<c:if test="${f.mName.length() eq 3 }">
											${f.mName.replace(f.mName.substring(1,2), "*") }
										</c:if>
										<c:if test="${f.mName.length() eq 4 }">
											${f.mName.replace(f.mName.substring(1,3), "*") }
										</c:if>
									</c:if>
								</td>
								<td>${f.fTel }</td>
								<td>${f.fDate }</td>
								<td><fmt:formatNumber value="${f.fHit }" pattern="#,###" />
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>

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
	</div>
	<jsp:include page="/main/footer.jsp" />
</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					changeMonth : true,
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					showMonthAfterYear : true,
					yearSuffix : '년',
					showOtherMonths : true,
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					changeYear : true,
					minDate : '-100y',
					yearRange : 'c-100:c+',
				});
		$("#datepicker2").datepicker(
				{
					dateFormat : 'yy-mm-dd',
					changeMonth : true,
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					showMonthAfterYear : true,
					yearSuffix : '년',
					showOtherMonths : true,
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					changeYear : true,
					minDate : '-100y',
					yearRange : 'c-100:c+',
				});
	});
</script>
</html>