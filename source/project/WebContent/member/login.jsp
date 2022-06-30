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
		function searchId() {
			var searchId = open('${conPath}/searchId_view.laf', '', 'width=600, height=500, left=800, top=300');
			if (!searchId) {
				alert('팝업차단 설정이 되어있습니다. 차단 해제 이후 다시 시도하세요.');
			} 
		}
		function searchPw() {
			var searchPw = open('${conPath}/searchPw_view.laf', '', 'width=600, height=500, left=800, top=300');
			if (!searchPw) {
				alert('팝업차단 설정이 되어있습니다. 차단 해제 이후 다시 시도하세요.');
			} 
		}
	</script>
</head>
<body>
<c:if test="${joinResult eq 0 }">
	<script>
		alert('회원가입에 실패하였습니다. 입력하신 정보를 다시 확인해 주시기 바랍니다.');
		history.back();
	</script>
</c:if>
<c:if test="${joinResult eq 1 }">
	<script>
		alert('회원가입을 축하합니다. 로그인 페이지로 이동합니다.');
	</script>
</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div>
		<form action="${conPath }/login.laf" method="post">
			<div>
				<ul>
					<li>
						<input type="text" name="mId" placeholder="아이디">
					</li>
					<li>
						<input type="password" name="mPw" placeholder="비밀번호">
					</li>
					<li>
						<input type="submit" value="로그인" class="btn">
					</li>
				</ul>
			</div>
			<div>
				<ul>
					<li>
						<a href="#" onclick="searchId()">아이디 찾기</a>
					</li>
					<li>
						<a href="#" onclick="searchPw()">비밀번호 찾기</a>
					</li>
					<li>
						<a href="#" onclick="location.href='${conPath}/join_view.laf'">회원가입</a>
					</li>
				</ul>
			</div>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>