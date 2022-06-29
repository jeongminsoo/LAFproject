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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#domainVal').on('click', function() {
				var domain = $('#domainVal')[0].value;
				if (domain == '직접입력') {
					$('#mEmailDomain').val('');
					$('#mEmailDomain').attr('disabled', false);
					$('#mEmailDomain').focus();
				} else {
					$('#mEmailDomain').val(domain);
				}
			});
		});
	</script>
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div>
		<form action="${coonPath }/login.laf" method="post">
			<table>
				<tr>
					<td><label for="mId">아이디</label></td>
					<td>
						<input type="text" name="mId" id="mId" class="mId">
						<input type="button" value="중복확인" class="btn" onclick="${conPath}/idChk.laf">
					</td>
				</tr>
				<tr>
					<td><label for="mPw">비밀번호</label></td>
					<td><input type="password" name="mPw" class="mPw" id="mPw"></td>
				</tr>
				<tr>
					<td><label for="mPwChk">비밀번호확인</label></td>
					<td><input type="password" name="mPwChk" class="mPwChk" id="mPwChk"></td>
				</tr>
				<tr>
					<td><label for="mName">이름</label></td>
					<td><input type="text" name="mName" class="mName" id="mName"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="tempBirth" class="tempBirth" id="datepicker"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<select name="mTel1" class="mTel1" id="mTel1">
							<option>010</option>
							<option>02</option>
							<option>031</option>
							<option>032</option>
							<option>033</option>
							<option>041</option>
							<option>042</option>
							<option>043</option>
							<option>044</option>
							<option>051</option>
							<option>052</option>
							<option>053</option>
							<option>054</option>
							<option>055</option>
							<option>061</option>
							<option>062</option>
							<option>063</option>
							<option>064</option>
						</select>
						-
						<input type="text" name="mTel2" class="mTel2" maxlength="4">
						-
						<input type="text" name="mTel3" class="mTel3" maxlength="4">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="mEmailId" class="mEmailId" id="mEmailId">
						@
						<input type="text" name="mEmailDomain" class="mEmailDomain" id="mEmailDomain" disabled="disabled">
						<select name="domainVal" class="domainVal" id="domainVal">
							<option value="">선택</option>
							<option>naver.com</option>
							<option>daum.net</option>
							<option>hanmail.net</option>
							<option>nate.com</option>
							<option>gmail.com</option>
							<option>hotmail.com</option>
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
						<input type="text" name="mQuiz" class="mQuiz" list="quiz" placeholder="직접 입력 가능">
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
					<td><input type="text" name="mAnswer" class="mAnswer"></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="회원가입" class="btn">
				<input type="button" value="취소" class="btn" onclick="location.href='${conPath}/main.laf'">
			</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
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
</body>
</html>