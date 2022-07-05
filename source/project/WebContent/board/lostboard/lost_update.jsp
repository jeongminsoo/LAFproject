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
<link href="${conPath}/css/find_write.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
	});
</script>
</head>
<body>
	<jsp:include page="/main/header.jsp" />
	<div id="write_wrap">
		<div class="snb">
			<ul>
				<li>분실물</li>
				<li><a href="${conPath }/lostList.laf?pageNum=${param.pageNum}">분실물
						목록</a></li>
				<li><a href="${conPath }/lostWrite_view.laf">분실물 등록</a></li>
			</ul>
		</div>
		<div class="content_title">
			<h1>분실물 수정</h1>
		</div>
		<hr color="#2e8fe3">
		<div id="sub_wrap">
			<form action="${conPath }/lostUpdate.laf" method="post"
				enctype="multipart/form-data">
				<div class="write">
					<input type="hidden" name="pageNum" value="${param.pageNum }">
					<input type="hidden" name="lNo" value="${lost.lNo }">
					<table>
						<tr>
							<th>물품구분</th>
							<td><select name="lOb" class="lOb" size="1">
									<option>분류</option>
									<option ${lost.lOb == "지갑" ? "selected=\"selected\"" : ""}>지갑</option>
									<option ${lost.lOb == "서류" ? "selected=\"selected\"" : ""}>서류</option>
									<option ${lost.lOb == "가방" ? "selected=\"selected\"" : ""}>가방</option>
									<option ${lost.lOb == "핸드폰" ? "selected=\"selected\"" : ""}>핸드폰</option>
									<option ${lost.lOb == "옷" ? "selected=\"selected\"" : ""}>옷</option>
									<option ${lost.lOb == "책" ? "selected=\"selected\"" : ""}>책</option>
									<option ${lost.lOb == "귀금속" ? "selected=\"selected\"" : ""}>귀금속</option>
									<option ${lost.lOb == "귀금속" ? "selected=\"selected\"" : ""}>쇼핑백</option>
									<option ${lost.lOb == "전자기기" ? "selected=\"selected\"" : ""}>전자기기</option>
									<option ${lost.lOb == "카드" ? "selected=\"selected\"" : ""}>카드</option>
									<option ${lost.lOb == "기타" ? "selected=\"selected\"" : ""}>기타</option>
							</select></td>
						</tr>
						<tr>
							<th>지역구분</th>
							<td><select name="lLocal" class="lLocal" size="1">
									<option
										${lost.lLocal == "서울특별시" ? "selected=\"selected\"" : ""}>서울특별시</option>
									<option ${lost.lLocal == "경기도" ? "selected=\"selected\"" : ""}>경기도</option>
									<option
										${lost.lLocal == "인천광역시" ? "selected=\"selected\"" : ""}>인천광역시</option>
									<option ${lost.lLocal == "강원도" ? "selected=\"selected\"" : ""}>강원도</option>
									<option ${lost.lLocal == "충청북도" ? "selected=\"selected\"" : ""}>충청북도</option>
									<option ${lost.lLocal == "충청남도" ? "selected=\"selected\"" : ""}>충청남도</option>
									<option
										${lost.lLocal == "대전광역시" ? "selected=\"selected\"" : ""}>대전광역시</option>
									<option
										${lost.lLocal == "세종특별자치시" ? "selected=\"selected\"" : ""}>세종특별자치시</option>
									<option ${lost.lLocal == "전라북도" ? "selected=\"selected\"" : ""}>전라북도</option>
									<option ${lost.lLocal == "전라남도" ? "selected=\"selected\"" : ""}>전라남도</option>
									<option
										${lost.lLocal == "광주광역시" ? "selected=\"selected\"" : ""}>광주광역시</option>
									<option ${lost.lLocal == "경상북도" ? "selected=\"selected\"" : ""}>경상북도</option>
									<option ${lost.lLocal == "경산남도" ? "selected=\"selected\"" : ""}>경산남도</option>
									<option
										${lost.lLocal == "울산광역시" ? "selected=\"selected\"" : ""}>울산광역시</option>
									<option
										${lost.lLocal == "대구광역시" ? "selected=\"selected\"" : ""}>대구광역시</option>
									<option
										${lost.lLocal == "부산광역시" ? "selected=\"selected\"" : ""}>부산광역시</option>
									<option
										${lost.lLocal == "제주특별자치도" ? "selected=\"selected\"" : ""}>제주특별자치도</option>
							</select></td>
						</tr>
						<tr>
							<th>분실일</th>
							<td><input type="text" name="tempDate" class="tempDate"
								id="datepicker" value="${lost.lDate }"></td>
						</tr>
						<tr>
							<th>분실장소</th>
							<td><input type="text" name="lLocation" class="lLocation"
								placeholder="ex) 강남 강남역1번출구, 서초 ○○식당" value="${lost.lLocation }"></td>
						</tr>
						<tr>
							<th>작성자</th>
							<td><input type="text" name="mName" class="mName"
								value="${lost.mName }" readonly="readonly"></td>
						</tr>
						<tr>
							<th>연락처</th>
							<td><input type="tel" name="lTel" class="lTel"
								value="${lost.lTel }"></td>
						</tr>
						<tr>
							<th>분실물명</th>
							<td><input type="text" name="lTitle" class="lTitle"
								value="${lost.lTitle }"></td>
						</tr>
						<tr>
							<th class="t_a">내용</th>
							<td><textarea name="lContent" class="lContent" rows="10" cols="10">${lost.lContent }</textarea></td>
						</tr>
						<tr>
							<th>이미치 첨부</th>
							<td><input type="file" name="lPhoto" class="lPhoto"></td>
						</tr>
					</table>
				</div>
				<div class="btn_wrap">
					<input type="submit" value="수정" class="btn"> <input
						type="button" value="취소" class="btn"
						onclick="location.href='${conPath}/lostList.laf?pageNum=${param.pageNum }'">
				</div>
			</form>
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
	});
</script>
</html>