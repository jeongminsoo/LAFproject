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
<link href="${conPath}/css/main.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
		var msg = '${param.msg}';
		
		if (msg == 'find') {
			location.href = '${conPath}/findWrite_view.laf';
		} else if (msg == "lost") {
			location.href = '${conPath}/lostWrite_view.laf';
		} else if (msg == 'info') {
			location.href = '${conPath}/myInfo.laf';
		} else if (msg == 'qna') {
			location.href = '${conPath}/qnaWrite_view.laf';
		}
</script>
</head>
<body>
	<c:if test="${leaveResult != null }">
		<script>
			alert("${leaveResult}");
		</script>
	</c:if>
	<c:if test="${loginResult eq \"해당 아이디는 사용이 중단된 아이디입니다.\" }">
		<script>
			alert("${loginResult}");
			location.href = '${conPath}/login_view.laf';
		</script>
	</c:if>
	<c:if test="${loginResult eq \"아이디 또는 비밀번호를 잘못 입력했습니다.입력하신 내용을 다시 확인해주세요.\" }">
		<script>
			alert("${loginResult}");
			location.href = '${conPath}/login_view.laf';
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="main_wrap">
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
	</div>
	<jsp:include page="../main/footer.jsp" />
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