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
	
	
	
	
	<!-- 비밀번호 유효성 검증 확인할것  -->
	
	
	
	
	<script>
		$(document).ready(function(){
			$('form').submit(function(){
				var oldPw = $('#oldPw').val().trim();
				var newmPw = $('#mPw').val().trim();
				var newmPwChk = $('#mPwChk').val().trim();
				var mPw = '${mPw}';
				
				if (mPw != oldPw) {
					alert('현재 비밀번호가 다릅니다. 다시 시도해주세요.');
					$('#oldPw').focus();
					return false;
				} else if (newmPw != newmPwChk) {
					alert('새비밀번호와 새비밀번호 확인이 다릅니다. 다시 시도해주세요.');
					$('#mPw').val('');
					$('#mPwChk').val('');
					$('#mPw').focus();
					return false;
				} 
			});
		});
	</script>
</head>
<body>
	<c:if test="${quizChkResult != null }">
		<script>
			alert('${quizChkResult}');
			history.back();
		</script>
	</c:if>
	<c:if test="${pwChangeSuccess != null }">
		<script>
			alert('${pwChangeSuccess}');
			close();
		</script>
	</c:if>
	<c:if test="${pwChangeFail != null }">
		<script>
			alert('${pwChangeFail}');
		</script>
	</c:if>
	<div id="search">
		<form action="${conPath }/pw_change.laf" method="post">
			<table>
				<caption>비밀번호 변경</caption>
				<col style="width : 200px;">
				<tr>
					<th>현재비밀번호</th>
					<td><input type="password" name="oldPw" id="oldPw"></td>
				</tr>
				<tr>
					<th>새비밀번호</th>
					<td><input type="password" name="mPw" id="mPw"></td>
				</tr>
				<tr>
					<th>새비밀번호확인</th>
					<td><input type="password" name="mPwChk" id="mPwChk"></td>
				</tr>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="비밀번호 변경" class="btn">
			</div>
		</form>
	</div>
</body>
</html>