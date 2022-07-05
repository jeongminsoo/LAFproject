<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<c:if test="${idChkResult eq \"중복된 아이디입니다\"}">
		<span style="color : red;"><b>${idChkResult }</b></span>
	</c:if>
	<c:if test="${idChkResult eq \"사용가능한 아이디입니다\"}">
		<span style="color : blue;"><b>${idChkResult }</b></span>
	</c:if>
	
</body>
</html>