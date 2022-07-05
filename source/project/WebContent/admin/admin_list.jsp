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
	<link href="${conPath}/css/member_list.css" rel="stylesheet">
	<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
			$(document).ready(function(){
			});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="list_wrap">
		<div class="snb">
			<ul>
				<li>관리자</li>
				<li><a href="${conPath }/myInfo.laf">회원정보</a></li>
				<li><a href="${conPath }/memberList.laf">회원관리</a></li>
				<li><a href="${conPath }/adminList.laf">관리자관리</a></li>
				<c:if
					test="${member.pwCode eq \"PW01\" || member.pwCode eq \"PW10\" }">
					<li><a href="${conPath }/add_view.laf">관리자추가</a></li>
				</c:if>
			</ul>
		</div>
		<div class="content_title">
			<h1>관리자 목록</h1>
		</div>
		<hr color="#2e8fe3">
		<div class="content">
			<form action="">
				<table>
					<col style="width: 30px;">
					<col style="width: 80px;">
					<col style="width: 80px;">
					<col style="width: 100px;">
					<col style="width: 120px;">
					<col style="width: 150px;">
					<col style="width: 120px;">
					<col style="width: 80px;">
					<col style="width: 100px;">
					<col style="width: 100px;">
					<tr>
						<th><input type="checkbox" name="checkAll"></th>
						<th>아이디</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>연락처</th>
						<th>이메일</th>
						<th>거주지</th>
						<th>권한</th>
						<th>상태</th>
						<th>가입일</th>
					</tr>
					<c:if test="${admins.size() eq 0 }">
						<tr>
							<td colspan="9">등록된 관리자가 없습니다</td>
						</tr>
					</c:if>
					<c:if test="${adminrs.size() != 0 }">
						<c:forEach items="${admins}" var="a">
							<tr>
								<td><input type="checkbox" name="memberCheck"></td>
								<td>${a.mId }</td>
								<td>${a.mName }</td>
								<td>${a.mBirth }</td>
								<td>${a.mTel1 }-${a.mTel2 }-${a.mTel3 }</td>
								<td>${a.mEmailId }@${a.mEmailDomain }</td>
								<td>${a.mAddress }</td>
								<td>${a.pcc }</td>
								<td>${a.mcc }</td>
								<td>${a.mRdate }</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="/main/footer.jsp" />
</body>
</html>