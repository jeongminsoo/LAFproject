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
<link href="${conPath}/css/pw_change.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>




<!-- 비밀번호 유효성 검증 확인할것  -->




<script>
	$(document).ready(function() {
		$('form').submit(function() {
			var oldPw = $('#oldPw').val().trim();
			var newmPw = $('#mPw').val().trim();
			var newmPwChk = $('#mPwChk').val().trim();
			var mPw = '${member.mPw}';

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
	<c:if test="${pwChangeSuccess != null }">
		<script>
			alert('${pwChangeSuccess}');
			location.href = '${conPath}/login_view.laf';
		</script>
	</c:if>
	<c:if test="${pwChangeFail != null }">
		<script>
			alert('${pwChangeFail}');
		</script>
	</c:if>
	<c:if test="${member == null }">
		<script>
			alert('로그인이 필요한 페이지입니다. 로그인페이지로 이동합니다.');
			location.href = '${conPath}/login_view.laf?msg=find';
		</script>
	</c:if>
	
	<jsp:include page="../main/header.jsp" />
	<div id="change_wrap">
		<div class="snb">
			<ul>
				<c:if test="${member.pwCode eq \"PW00\" }">
					<li>마이페이지</li>
					<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
					<li><a href="${conPath }/myFindList.laf">습득물 관리</a></li>
					<li><a href="${conPath }/myLostList.laf">분실물 관리</a></li>
					<li><a href="${conPath }/pw_change_view.laf">비밀번호 변경</a></li>
				</c:if>
				<c:if test="${member.pwCode eq \"PW01\" || member.pwCode eq \"PW10\"}">
					<li>관리자</li>
					<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
					<c:if test="${member.pwCode eq \"PW10\" }">
						<li><a href="${conPath }/memberList.laf">회원관리</a></li>
						<li><a href="${conPath }/add_view.laf">관리자추가</a></li>
					</c:if>
					<li><a href="${conPath }/pw_change_view.laf">비밀번호 변경</a></li>
				</c:if>
				
			</ul>
		</div>
		<div class="content_title">
			<h1>비밀번호 변경</h1>
		</div>
		<hr color="#2e8fe3">
		<form action="${conPath }/pw_change.laf" method="post">
			<div class="change">
				<table>
					<col style="width: 200px;">
					<col style="width: 400px;">
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
				<div class="btn_wrap2">
					<input type="submit" value="비밀번호 변경" class="btn">
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>