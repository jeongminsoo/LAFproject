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
<link href="${conPath}/css/result.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<c:if test="${searchIdResult != null }">
		<script>
			alert('${searchIdResult}');
			history.back();
		</script>
	</c:if>
	<div id="search_id">
			<table>
				<caption>검색 결과는 아래와 같습니다.</caption>
				<col style="width : 200px;">
				<col style="width : 200px;">
				<tr>
					<th colspan="2">검색결과</th>
				</tr>
				<tr>
					<td class="two_first">아이디</td>
					<td>${mId }</td>
				</tr>
			</table>
		<div class="btn_wrap">
			<button onclick="location.href='${conPath}/searchPw_view.laf'">비밀번호
				찾기</button>
			<button onclick="window.close()">닫기</button>
		</div>
	</div>
</body>
</html>