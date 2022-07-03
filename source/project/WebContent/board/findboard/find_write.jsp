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
	var member = '${member}';
		
	if (member == "") {
		<% session.setAttribute("writeFind", 1); %>
		alert('로그인이 필요한 페이지입니다. 로그인페이지로 이동합니다.');
		location.href='${conPath}/login_view.laf';
	}
</script>
</head>
<body>
	<div>
		<form action="${conPath }/findWrite.laf" method="post" enctype="multipart/form-data">
			<div>

				<table>
					<caption>습득물 등록</caption>
					<tr>
						<td>물품구분</td>
						<td><select name="fOb" class="fOb" size="1">
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
						<td>지역구분</td>
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
						<td>습득일</td>
						<td>
							<input type="text" name="tempDate" class="tempDate" id="datepicker">
						</td>
					</tr>
					<tr>
						<td>발견장소</td>
						<td><input type="text" name="fLocation" class="fLocation"
							placeholder="ex) 강남 강남역1번출구, 서초 ○○식당"></td>
					</tr>
					<tr>
						<td>보관장소</td>
						<td><input type="text" name="fStorage" class="fStorage"
							placeholder="ex) 강남경찰서, 서초파출소"></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td><input type="text" name="mName" class="mName"
							value="${member.mName }" readonly="readonly"></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="tel" name="fTel" class="fTel" value="${member.mTel1 }-${member.mTel2 }-${member.mTel3 }"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="fTitle" class="fTitle"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="fContent" class="fContent"></textarea></td>
					</tr>
					<tr>
						<td>이미치 첨부</td>
						<td><input type="file" name="fPhoto" class="fPhoto"></td>
					</tr>
				</table>
			</div>
			<div>
				<input type="submit" value="등록" class="btn">
				<input type="reset" value="초기화" class="btn">
				<input type="button" value="목록" class="btn" onclick="location.href='${conPath}/findList.laf?pageNum=1'">
			</div>
		</form>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
 		 $( function() {
   			 $( "#datepicker" ).datepicker({
   				dateFormat : 'yy-mm-dd',
   	    		changeMonth : true,
   	    		monthNamesShort : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
   	    		showMonthAfterYear : true,
   	        	yearSuffix : '년',
   	        	showOtherMonths : true,
   	        	dayNamesMin:['일','월','화','수','목','금','토'],
   				changeYear : true,
   				minDate : '-100y',
   				yearRange : 'c-100:c+',
   			 });
  		});
</script>
</html>