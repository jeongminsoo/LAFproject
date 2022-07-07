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
<link href="${conPath}/css/style.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
	});
</script>
</head>
<body>
	<c:if test="${msg != null }">
		<script>
			alert('${msg}');
			history.back();
		</script>
	</c:if>
	<form action="${conPath }/changePower.laf" method="post">
		<input type="hidden" name="mId" value='${param.mId}'>
			<input type="hidden" name="mName" value='${param.mName}'>
			<input type="hidden" name="mAddress" value='${param.mAddress}'>
			<input type="hidden" name="mstCode" value='${param.mstCode}'>
			<input type="hidden" name="bfpwCode" value='${param.bfpwCode}'>
			<input type="hidden" name="tempDate1" value='${param.mRdate1}'>
			<input type="hidden" name="tempDate2" value='${param.mRdate2}'>
			<input type="hidden" name="memberCheck" value='${param.memberCheck}'>
		<table>
			<tr>
				<th>권한</th>
				<td><select name="pwCode" class="pwCode" size="1">
						<option value="PW00">사용자</option>
						<option value="PW01">관리자</option>
						<option value="PW10">최고관리자</option>
				</select></td>
				<td>
					<input type="submit" value="변경" class="btn">
					<input type="button" value="취소" class="btn" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>