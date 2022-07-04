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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	var member = '${member}';

	if (member == "") {
		alert('로그인이 필요한 페이지입니다. 로그인페이지로 이동합니다.');
		location.href = '${conPath}/login_view.laf?msg=lost';
	}
</script>
</head>
<jsp:include page="/main/header.jsp"/>
<div id="write_wrap">
	<div class="snb">
		<ul>
			<li>분실물</li>
			<li><a href="${conPath }/lostList.laf?pageNum=1">분실물 목록</a></li>
			<li><a href="${conPath }/lostWrite_view.laf">분실물 등록</a></li>
		</ul>
	</div>
	<div class="content_title">
		<h1>분실물 등록</h1>
		<p>
			(<span>＊</span>) 표시는 필수입력 항목입니다.
		</p>
	</div>
	<div id="sub_wrap">
		<form action="${conPath }/lostWrite.laf" method="post"
			enctype="multipart/form-data">
			<div class="write">
				<table>
					<col style="width : 200px;">
					<col style="width : 500px;">
					<tr>
						<th><span>＊</span>물품구분</th>
						<td><select name="lOb" class="lOb" size="1">
								<option>분류</option>
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
						<td><select name="lLocal" class="lLocal" size="1">
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
						<th><span>＊</span>분실일</th>
						<td><input type="text" name="tempDate" class="tempDate"
							id="datepicker"></td>
					</tr>
					<tr>
						<th><span>＊</span>분실장소</th>
						<td><input type="text" name="lLocation" class="lLocation"
							placeholder="ex) 강남 강남역1번출구, 서초 ○○식당"></td>
					</tr>
					<tr>
						<th><span>＊</span>작성자</th>
						<td><input type="text" name="mName" class="mName"
							value="${member.mName }" readonly="readonly"></td>
					</tr>
					<tr>
						<th><span>＊</span>연락처</th>
						<td><input type="Tel" name="lTel" class="lTel"
							value="${member.mTel1 }-${member.mTel2 }-${member.mTel3 }"></td>
					</tr>
					<tr>
						<th><span>＊</span>제목</th>
						<td><input type="text" name="lTitle" class="lTitle"></td>
					</tr>
					<tr>
						<th class="t_a"><span>＊</span>내용</th>
						<td><textarea name="lContent" class="lContent" rows="5" cols="10"></textarea></td>
					</tr>
					<tr>
						<th>이미치 첨부</th>
						<td><input type="file" name="lPhoto" class="lPhoto"></td>
					</tr>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="submit" value="등록" class="btn"> <input
					type="reset" value="초기화" class="btn"> <input type="button"
					value="목록" class="btn"
					onclick="location.href='${conPath}/lostList.laf?pageNum=1'">
			</div>
		</form>
	</div>
</div>
<jsp:include page="/main/footer.jsp"/>
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