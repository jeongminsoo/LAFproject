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
	<link href="${conPath}/css/searchIdPw.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
				$('#domainVal').on('click', function() {
					var domain = $('#domainVal').val();
					if (domain == '직접입력') {
						$('#mEmailDomain').val('');
						$('#mEmailDomain').attr('disabled', false);
						$('#mEmailDomain').focus();
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
	<div id="search">
		<form action="${conPath }/searchId.laf" method="post">
			<table>
				<caption>아이디 찾기</caption>
				<col style="width : 200px;">
				<tr>
					<th>이름</th>
					<td><input type="text" name="mName" class="mName"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="mEmailId" class="mEmailId" id="mEmailId">
							@
							<input type="text" name="mEmailDomain" class="mEmailDomain" id="mEmailDomain" disabled="disabled">
							<select name="domainVal" class="domainVal" id="domainVal">
								<option value="">선택</option>
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hotmail.com">hotmail.com</option>
								<option>직접입력</option>
							</select>
					</td>
				</tr>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="아이디 찾기" class="btn">
				<input type="button" value="취소" class="btn" onclick="window.close()">
			</div>
		</form>
	</div>
</body>
</html>