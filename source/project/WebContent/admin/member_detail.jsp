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
		
		$('.act_fmt').submit(function(){
			if ($('.act_fmt').attr('action') != "${conPath}/beforeChange.laf") {
				if ($('.memberCheck').is(':checked')) {
					var answer = confirm('정말 사용중단하시겠습니까?');
					if (answer != true) {
						return false;
					}
				} else {
					alert('선택한 회원이 없습니다');
					return false;
				}
			} else {
				if ($('.memberCheck').is(':checked')) {
					
				} else {
					alert('선택한 회원이 없습니다');
					return false;
				}
			}
			
		});
		
		
	});

	function actSub() {
		$('.act_fmt').attr("action", "${conPath}/beforeChange.laf");
		$('.act_fmt').submit();
	}
</script>
</head>
<body>
	<c:if test="${resultCnt != null }">
		alert('${resultCnt }명 사용 중지 처리가 완료되었습니다.');
	</c:if>
	<c:if test="${changeResult != null }">
		alert('${changeResult }명 권한 변경이 완료되었습니다.');
	</c:if>
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

		<form action="${conPath }/memberDetailSearch.laf" method="post" class="search_fmt">
			<div class="search">
				<table>

					<tr>
						<th>아이디</th>
						<td><input type="text" name="mId" class="mName" value="${mId }"></td>
						<th>이름</th>
						<td><input type="text" name="mName" class="mName" value="${mName }"></td>
					</tr>
					<tr>
						<th>거주지</th>
						<td><select name="mAddress" class="mAddress" size="1">
								<option value="" ${mAddress eq "" ? "selected=\"selected\"" : "" }>전체</option>
								<option ${mAddress eq "서울특별시" ? "selected=\"selected\"" : "" }>서울특별시</option>
								<option ${mAddress eq "경기도" ? "selected=\"selected\"" : "" }>경기도</option>
								<option ${mAddress eq "인천광역시" ? "selected=\"selected\"" : "" }>인천광역시</option>
								<option ${mAddress eq "강원도" ? "selected=\"selected\"" : "" }>강원도</option>
								<option ${mAddress eq "충청북도" ? "selected=\"selected\"" : "" }>충청북도</option>
								<option ${mAddress eq "충청남도" ? "selected=\"selected\"" : "" }>충청남도</option>
								<option ${mAddress eq "대전광역시" ? "selected=\"selected\"" : "" }>대전광역시</option>
								<option ${mAddress eq "세종특별자치시" ? "selected=\"selected\"" : "" }>세종특별자치시</option>
								<option ${mAddress eq "전라북도" ? "selected=\"selected\"" : "" }>전라북도</option>
								<option ${mAddress eq "전라남도" ? "selected=\"selected\"" : "" }>전라남도</option>
								<option ${mAddress eq "광주광역시" ? "selected=\"selected\"" : "" }>광주광역시</option>
								<option ${mAddress eq "경상북도" ? "selected=\"selected\"" : "" }>경상북도</option>
								<option ${mAddress eq "경산남도" ? "selected=\"selected\"" : "" }>경산남도</option>
								<option ${mAddress eq "울산광역시" ? "selected=\"selected\"" : "" }>울산광역시</option>
								<option ${mAddress eq "대구광역시" ? "selected=\"selected\"" : "" }>대구광역시</option>
								<option ${mAddress eq "부산광역시" ? "selected=\"selected\"" : "" }>부산광역시</option>
								<option ${mAddress eq "제주특별자치도" ? "selected=\"selected\"" : "" }>제주특별자치도</option>
						</select></td>
						<th>상태</th>
						<td><select name="mstCode" class="mstCode" size="1">
								<option value="" ${mstCode eq "" ? "selected=\"selected\"" : "" }>전체</option>
								<option value="MST00" ${mstCode eq "MST00" ? "selected=\"selected\"" : "" }>사용중</option>
								<option value="MST10" ${mstCode eq "MST10" ? "selected=\"selected\"" : "" }>사용중단</option>
						</select></td>
					</tr>
					<tr>
						<th>권한</th>
						<td><select name="pwCode" class="pwCode" size="1">
								<option value="" ${bfpwCode eq "" ? "selected=\"selected\"" : "" }>전체</option>
								<option value="PW00" ${bfpwCode eq "PW00" ? "selected=\"selected\"" : "" }>사용자</option>
								<option value="PW01" ${bfpwCode eq "PW01" ? "selected=\"selected\"" : "" }>관리자</option>
								<option value="PW10" ${bfpwCode eq "PW10" ? "selected=\"selected\"" : "" }>최고관리자</option>
						</select></td>
						<th>가입일</th>
						<td><input type="text" name="tempDate1" class="tempDate1"
							id="datepicker" value="${mRdate1 }"> ~ <input type="text" name="tempDate2"
							class="tempDate2" id="datepicker2" value="${mRdate2 }"></td>
					</tr>
					<tr>
						<td colspan="4"><input type="submit" value="검색" class="btn"></td>
					</tr>
				</table>
			</div>
		</form>
		<form action="${conPath}/stopMember.laf" method="post" class="act_fmt">
			<input type="hidden" name="mId" value='${mId eq null ? "" : mId }'>
			<input type="hidden" name="mName" value='${mName eq null ? "" : mName }'>
			<input type="hidden" name="mAddress" value='${mAddress eq null ? "" : mAddress }'>
			<input type="hidden" name="mstCode" value='${mstCode eq null ? "" : mstCode }'>
			<input type="hidden" name="bfpwCode" value='${bfpwCode eq null ? "" : bfpwCode }'>
			<input type="hidden" name="tempDate1" value='${mRdate1 eq null ? "" : mRdate1 }'>
			<input type="hidden" name="tempDate2" value='${mRdate2 eq null ? "" : mRdate2 }'>
		<div class="content">
			
			<table>
				<caption>
					<input type="submit" value="사용중지" id="stop" class="btn">
					<input type="button" value="권한변경" id="change" class="btn" onclick="actSub()">
				</caption>
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
				<c:if test="${members.size() eq 0 }">
					<tr>
						<td colspan="9">등록된 회원이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${members.size() != 0 }">
					<c:forEach items="${members}" var="m">
						<tr>
							<td><input type="checkbox" name="memberCheck"
								class="memberCheck" value="${m.mId }"></td>
							<td>${m.mId }</td>
							<td>${m.mName }</td>
							<td>${m.mBirth }</td>
							<td>${m.mTel1 }-${m.mTel2 }-${m.mTel3 }</td>
							<td>${m.mEmailId }@${m.mEmailDomain }</td>
							<td>${m.mAddress }</td>
							<td>${m.pcc }</td>
							<td>${m.mcc }</td>
							<td>${m.mRdate }</td>

						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		</form>
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