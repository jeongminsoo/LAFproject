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
<link href="${conPath}/css/info.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	var member = '${member}';

	if (member == "") {
		alert('로그인이 필요한 페이지입니다. 로그인페이지로 이동합니다.');
		location.href = '${conPath}/login_view.laf?msg=info';
	}
</script>
</head>
<body>
	<c:if test="${modifyResult eq 0 }">
		<script>
			alert('정보수정에 실패하였습니다. 입력한 정보를 확인 후 다시 시도해주세요.');
			history.back();
		</script>
	</c:if>
	<c:if test="${modifyResult eq 1 }">
		<script>
			alert('정보수정이 완료되었습니다.');
		</script>
	</c:if>
	<jsp:include page="../main/header.jsp" />
	<div id="info_wrap">
		<div class="snb">
			<ul>
				<c:if test="${member.pwCode eq \"PW00\" }">
					<li>마이페이지</li>
					<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
					<li><a href="${conPath }/myFindList.laf">습득물 관리</a></li>
					<li><a href="${conPath }/myLostList.laf">분실물 관리</a></li>
					<li><a href="${conPath }/pw_change_view.laf">비밀번호 변경</a></li>
				</c:if>
				<c:if test="${member.pwCode eq \"PW01\" || member.pwCode eq \"PW10\" }">
					<li>관리자</li>
					<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
					<li><a href="${conPath }/memberList.laf">회원관리</a></li>
					<li><a href="${conPath }/adminList.laf">관리자관리</a></li>
					<c:if test="${member.pwCode eq \"PW10\" }">
						<li><a href="${conPath }/add_view.laf">관리자추가</a></li>
					</c:if>
					<li><a href="${conPath }/pw_change_view.laf">비밀번호 변경</a></li>
				</c:if>
			</ul>
		</div>
		<div class="content_title">
			<h1>회원정보</h1>
		</div>
		<div class="info">
		<table>
			<col style="width: 200px;">
			<col style="width: 400px;">
			<tr>
				<th>아이디</th>
				<td>${member.mId }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${member.mName }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.mEmailId }@${member.mEmailDomain }</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${member.mTel1 }-${member.mTel2 }-${member.mTel3 }</td>
			</tr>
			<tr>
				<th>거주지</th>
				<td>${member.mAddress }</td>
			</tr>
		</table>
		</div>
		<div class="btn_wrap">
			<button onclick="location.href='${conPath}/modify_view.laf'">정보수정</button>
			<button onclick="location.href='${conPath}/leaveMember_view.laf'">회원탈퇴</button>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>