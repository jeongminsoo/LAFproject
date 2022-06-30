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
			// 이메일 도메인 선택 이벤트
			$('#domainVal').on('click', function() {
				var domain = $('#domainVal').val();
				if (domain == '직접입력') {
					$('#mEmailDomain').val('');
					$('#mEmailDomain').attr('disabled', false);
				} else {
					$('#mEmailDomain').val(domain);
				}
			});
			$('form').submit(function(){
				$('#mEmailDomain').attr('disabled', false);
			});
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	
	<div>
		<form action="${conPath }/modify.laf" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td>${member.mId != null ? member.mId : ""}</td>
				</tr>
				<tr>
					<td><label for="mName">이름</label></td>
					<td><input type="text" name="mName" class="mName" id="mName" value='${member.mName != null ? member.mName : "" }'></td>
				</tr>
				
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="tempBirth" class="tempBirth" id="datepicker" value='${member.mBirth != null ? member.mBirth : ""}'></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<select name="mTel1" class="mTel1" id="mTel1">
							<option ${member.mTel1 eq 010 ? "selected=\"selected\"" : "" }>010</option>
							<option ${member.mTel1 eq 02 ? "selected=\"selected\"" : "" }>02</option>
							<option ${member.mTel1 eq 031 ? "selected=\"selected\"" : "" }>031</option>
							<option ${member.mTel1 eq 032 ? "selected=\"selected\"" : "" }>032</option>
							<option ${member.mTel1 eq 033 ? "selected=\"selected\"" : "" }>033</option>
							<option ${member.mTel1 eq 041 ? "selected=\"selected\"" : "" }>041</option>
							<option ${member.mTel1 eq 042 ? "selected=\"selected\"" : "" }>042</option>
							<option ${member.mTel1 eq 043 ? "selected=\"selected\"" : "" }>043</option>
							<option ${member.mTel1 eq 044 ? "selected=\"selected\"" : "" }>044</option>
							<option ${member.mTel1 eq 051 ? "selected=\"selected\"" : "" }>051</option>
							<option ${member.mTel1 eq 052 ? "selected=\"selected\"" : "" }>052</option>
							<option ${member.mTel1 eq 053 ? "selected=\"selected\"" : "" }>053</option>
							<option ${member.mTel1 eq 054 ? "selected=\"selected\"" : "" }>054</option>
							<option ${member.mTel1 eq 055 ? "selected=\"selected\"" : "" }>055</option>
							<option ${member.mTel1 eq 061 ? "selected=\"selected\"" : "" }>061</option>
							<option ${member.mTel1 eq 062 ? "selected=\"selected\"" : "" }>062</option>
							<option ${member.mTel1 eq 063 ? "selected=\"selected\"" : "" }>063</option>
							<option ${member.mTel1 eq 064 ? "selected=\"selected\"" : "" }>064</option>
						</select>
						-
						<input type="text" name="mTel2" class="mTel2" maxlength="4" value='${member.mTel2 != null ? member.mTel2 : ""}'>
						-
						<input type="text" name="mTel3" class="mTel3" maxlength="4" value='${member.mTel3 != null ? member.mTel3 : ""}'>
					</td>
				</tr>
				<tr>
					<td>거주지</td>
					<td>
						<select name="mAddress" class="mAddress" size="1">
							<option ${member.mAddress == "서울특별시" ? "selected=\"selected\"" : ""}>서울특별시</option>
							<option ${member.mAddress == "경기도" ? "selected=\"selected\"" : ""}>경기도</option>
							<option ${member.mAddress == "인천광역시" ? "selected=\"selected\"" : ""}>인천광역시</option>
							<option ${member.mAddress == "강원도" ? "selected=\"selected\"" : ""}>강원도</option>
							<option ${member.mAddress == "충청북도" ? "selected=\"selected\"" : ""}>충청북도</option>
							<option ${member.mAddress == "충청남도" ? "selected=\"selected\"" : ""}>충청남도</option>
							<option ${member.mAddress == "대전광역시" ? "selected=\"selected\"" : ""}>대전광역시</option>
							<option ${member.mAddress == "세종특별자치시" ? "selected=\"selected\"" : ""}>세종특별자치시</option>
							<option ${member.mAddress == "전라북도" ? "selected=\"selected\"" : ""}>전라북도</option>
							<option ${member.mAddress == "전라남도" ? "selected=\"selected\"" : ""}>전라남도</option>
							<option ${member.mAddress == "광주광역시" ? "selected=\"selected\"" : ""}>광주광역시</option>
							<option ${member.mAddress == "경상북도" ? "selected=\"selected\"" : ""}>경상북도</option>
							<option ${member.mAddress == "경산남도" ? "selected=\"selected\"" : ""}>경산남도</option>
							<option ${member.mAddress == "울산광역시" ? "selected=\"selected\"" : ""}>울산광역시</option>
							<option ${member.mAddress == "대구광역시" ? "selected=\"selected\"" : ""}>대구광역시</option>
							<option ${member.mAddress == "부산광역시" ? "selected=\"selected\"" : ""}>부산광역시</option>
							<option ${member.mAddress == "제주특별자치도" ? "selected=\"selected\"" : ""}>제주특별자치도</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="mEmailId" class="mEmailId" id="mEmailId" value='${member.mEmailId != null ? member.mEmailId : ""}'>
						@
						<input type="text" name="mEmailDomain" class="mEmailDomain" id="mEmailDomain" disabled="disabled" value='${member.mEmailDomain != null ? member.mEmailDomain : ""}'>
						<select name="domainVal" class="domainVal" id="domainVal">
							<option value="">선택</option>
							<option ${member.mEmailDomain == "naver.com" ? "selected=\"selected\"" : "" }>naver.com</option>
							<option ${member.mEmailDomain == "daum.net" ? "selected=\"selected\"" : "" }>daum.net</option>
							<option ${member.mEmailDomain == "hanmail.net" ? "selected=\"selected\"" : "" }>hanmail.net</option>
							<option ${member.mEmailDomain == "nate.com" ? "selected=\"selected\"" : "" }>nate.com</option>
							<option ${member.mEmailDomain == "gmail.com" ? "selected=\"selected\"" : "" }>gmail.com</option>
							<option ${member.mEmailDomain == "hotmail.com" ? "selected=\"selected\"" : "" }>hotmail.com</option>
							<option>직접입력</option>
						</select>
					</td>
				</tr>
			</table>
			<table>
				<caption>비밀번호 찾기 질문/답변</caption>
				<tr>
					<td>질문</td>
					<td>
						<input type="text" name="mQuiz" class="mQuiz" list="quiz" placeholder="직접 입력 가능" value="${member.mQuiz }">
						<datalist id="quiz">
							<option>나의 어머니의 성함은?</option>
							<option>가장 좋아하는 음식은?</option>
							<option>가장 좋아하는 색깔은?</option>
							<option>내가 다녔던 고등학교의 이름은?</option>
						</datalist>
					</td>
				</tr>
				<tr>
					<td>답변</td>
					<td><input type="text" name="mAnswer" class="mAnswer" value="${member.mAnswer }"></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="정보수정" class="btn">
				<input type="button" value="취소" class="btn" onclick="history.back()">
			</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
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