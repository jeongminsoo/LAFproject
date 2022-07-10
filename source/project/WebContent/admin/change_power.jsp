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
<script	 src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
	$('form').submit(function(){
		var answer = confirm("변경하시겠습니까?");
		
		if(answer == false) {
			return false;
			history.back();
		}
	});
});
</script>
</head>
<body>
	<form action="${conPath }/changePower.laf" method="post">
		<input type="hidden" name="mId" value="${mId }">
		<input type="hidden" name="mName" value="${mName }">
		<input type="hidden" name="mAddress" value="${mAddress }">
		<input type="hidden" name="mstCode" value="${mstCode }">
		<input type="hidden" name="bfpwCode" value="${bfpwCode }">
		<input type="hidden" name="tempDate1" value="${mRdate1 }">
		<input type="hidden" name="tempDate2" value="${mRdate2 }">
		<table>
			<tr>
				<th>권한</th>
				<td><select name="pwCode" size="1">
						<option value="PW00">사용자</option>
						<option value="PW01">관리자</option>
						<option value="PW10">최고관리자</option>
				</select> <input type="submit" value="변경" class="btn"></td>
			</tr>
		</table>
	</form>
</body>
</html>