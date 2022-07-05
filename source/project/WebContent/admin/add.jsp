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
	<link href="${conPath}/css/join.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
			});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="join_wrap">
		<div class="join_title">
			<h1>관리자 추가</h1>
			<p>
				(<span>＊</span>) 표시는 필수입력 항목입니다.
			</p>
		</div>
		<div id="sub_wrap">
			<form action="${conPath }/add.laf" method="post">
				<table id="up_table">
					<col style="width : 160px;">
					<col style="width : 400px;">
					<tr>
						<th><label for="mId"><span>＊</span>아이디</label></th>
						<td><input type="text" name="mId" id="mId" class="mId">
							<input type="button" value="중복확인" class="id_btn"
							onclick="${conPath}/idChk.laf"></td>
					</tr>
					<tr>
						<th><label for="mPw"><span>＊</span>비밀번호</label></th>
						<td><input type="password" name="mPw" class="mPw" id="mPw"></td>
					</tr>
					<tr>
						<th><label for="mPwChk">비밀번호확인</label></th>
						<td><input type="password" name="mPwChk" class="mPwChk"
							id="mPwChk"></td>
					</tr>
					<tr>
						<th><label for="mName"><span>＊</span>이름</label></th>
						<td><input type="text" name="mName" class="mName" id="mName"></td>
					</tr>
					<tr>
						<th><span>＊</span>생년월일</th>
						<td><input type="text" name="tempBirth" class="tempBirth"
							id="datepicker"></td>
					</tr>
					<tr>
						<th><span>＊</span>연락처</th>
						<td><select name="mTel1" class="mTel1" id="mTel1">
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
						</select> - <input type="text" name="mTel2" class="mTel2" maxlength="4">
							- <input type="text" name="mTel3" class="mTel3" maxlength="4">
						</td>
					</tr>
					<tr>
						<th><span>＊</span>거주지</th>
						<td><select name="mAddress" class="mAddress" size="1">
								<option selected="selected">서울특별시</option>
						</select></td>
					</tr>
					<tr>
						<th><span>＊</span>이메일</th>
						<td><input type="text" name="mEmailId" class="mEmailId"
							id="mEmailId"> @ <input type="text" name="mEmailDomain"
							class="mEmailDomain" id="mEmailDomain" disabled="disabled">
							<select name="domainVal" class="domainVal" id="domainVal">
								<option value="">선택</option>
								<option>naver.com</option>
								<option>daum.net</option>
								<option>hanmail.net</option>
								<option>nate.com</option>
								<option>gmail.com</option>
								<option>hotmail.com</option>
								<option>직접입력</option>
						</select></td>
					</tr>
				</table>
				<table id="down_table">
					<caption>비밀번호 찾기 질문/답변</caption>
					<col style="width : 160px;">
					<col style="width : 400px;">
					<tr>
						<th><span>＊</span>질문</th>
						<td><input type="text" name="mQuiz" class="mQuiz" list="quiz" value="괸리자입니다" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th><span>＊</span>답변</th>
						<td><input type="text" name="mAnswer" class="mAnswer" value="괸리자입니다" readonly="readonly"></td>
					</tr>
				</table>
				<div class="btn_wrap">
					<input type="submit" value="등록" class="btn"> <input
						type="button" value="취소" class="btn"
						onclick="history.back()">
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp" />
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