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
<link href="${conPath}/css/member_list.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#checkAll').click(function() {
			if ($(this).is(':checked')) {
				$('.memberCheck').prop('checked', true);
			} else {
				$('.memberCheck').prop('checked', false);
			}
		});
	});
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="list_wrap">
		<div class="snb">
			<ul>
				<li>관리자</li>
				<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
				<c:if test="${member.pwCode eq \"PW10\" }">
					<li><a href="${conPath }/memberList.laf">회원관리</a></li>
					<li><a href="${conPath }/add_view.laf">관리자추가</a></li>
				</c:if>
				<li><a href="${conPath }/pw_change_view.laf">비밀번호 변경</a></li>
			</ul>
		</div>
		<div class="content_title">
			<h1>회원 목록</h1>
		</div>
		<hr color="#2e8fe3">
		<form action="${conPath }/memberDetailSearch.laf" method="post">
			<div class="search">
				<table>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="mId" class="mId"></td>
						<th>이름</th>
						<td><input type="text" name="mName" class="mName"></td>
					</tr>
					<tr>
						<th>거주지</th>
						<td><select name="mAddress" class="mAddress" size="1">
								<option value="">전체</option>
								<option>서울특별시</option>
								<option>경기도</option>
								<option>인천광역시</option>
								<option>강원도</option>
								<option>충청북도</option>
								<option>충청남도</option>
								<option>대전광역시</option>
								<option>세종특별자치시</option>
								<option>전라북도</option>
								<option>전라남도</option>
								<option>광주광역시</option>
								<option>경상북도</option>
								<option>경산남도</option>
								<option>울산광역시</option>
								<option>대구광역시</option>
								<option>부산광역시</option>
								<option>제주특별자치도</option>
						</select></td>
						<th>상태</th>
						<td><select name="mstCode" class="mstCode" size="1">
								<option value="">전체</option>
								<option value="MST00">사용중</option>
								<option value="MST10">사용중단</option>
						</select></td>
					</tr>
					<tr>
						<th>권한</th>
						<td><select name="pwCode" class="pwCode" size="1">
								<option value="">전체</option>
								<option value="PW00">사용자</option>
								<option value="PW01">관리자</option>
								<option value="PW10">최고관리자</option>
						</select></td>
						<th>가입일</th>
						<td><input type="text" name="tempDate1" class="tempDate1"
							id="datepicker" value="${yesterday }"> ~ <input
							type="text" name="tempDate2" class="tempDate2" id="datepicker2"
							value="${today }"></td>
					</tr>
					<tr>
						<td colspan="4"><input type="submit" value="검색" class="btn"></td>
					</tr>
				</table>
			</div>
		</form>

		<div class="content">
			<table>
				<col style="width: 30px;">
				<col style="width: 80px;">
				<col style="width: 80px;">
				<col style="width: 100px;">
				<col style="width: 120px;">
				<col style="width: 150px;">
				<col style="width: 120px;">
				<col style="width: 80px;">
				<col style="width: 100px;">
				<col style="width: 100px;">
				<tr>
					<th><input type="checkbox" name="checkAll" id="checkAll"></th>
					<th>아이디</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>거주지</th>
					<th>권한</th>
					<th>상태</th>
					<th>가입일</th>
				</tr>
			</table>
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