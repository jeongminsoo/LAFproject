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
				
		});
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
	<jsp:include page="../main/header.jsp"/>
	<div>
		<table>
			<caption>회원정보</caption>
			<tr>
				<td>아이디</td>
				<td>${member.mId }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.mName }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${member.mEmailId }@${member.mEmailDomain }</td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>${member.mTel1 }-${member.mTel2 }-${member.mTel3 }</td>
			</tr>
			<tr>
				<td>거주지</td>
				<td>${member.mAddress }</td>
			</tr>
		</table>
		<div>
			<button onclick="location.href='${conPath}/modify_view.laf'">정보수정</button>
		</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>