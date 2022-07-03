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

<c:if test="${noticeWriteResult eq 0 }">
	<script>
		alert('공지사항 등록에 실패하였습니다. 입력한 정보를 확인 후 다시 시도하세요.');
		history.back();
	</script>
</c:if>
<c:if test="${noticeWriteResult eq 1 }">
	<script>
		alert('등록되었습니다.');
	</script>
</c:if>

<c:if test="${noticeUpdateResult eq 0 }">
	<script>
		alert('공지사항 수정에 실패하였습니다. 입력한 정보를 확인 후 다시 시도하세요.');
		history.back();
	</script>
</c:if>
<c:if test="${noticeUpdateResult eq 1 }">
	<script>
		alert('수정되었습니다.');
	</script>
</c:if>

<c:if test="${noticeDeleteResult eq 0 }">
	<script>
		alert('공지사항 삭제에 실패하였습니다. 이미 삭제되었거나 잘못된 경로입니다.');
		history.back();
	</script>
</c:if>
<c:if test="${noticeDeleteResult eq 1 }">
	<script>
		alert('삭제되었습니다.');
	</script>
</c:if>

	<div>
		<div>
			<ul>
				<li><a href="${conPath }/qnaList.laf?pageNum=1">Q&amp;A 목록</a></li>
				<li><a href="${conPath }/qnaWrite_view.laf">문의하기</a></li>
				<li><a href="${conPath }/noticeList.laf">공지사항</a></li>
				<li><a href="${conPath }/noticeWrite_view.laf?pageNum=${param.pageNum}">공지사항 등록</a></li>
			</ul>
		</div>
		<div>
			<table>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:if test="${notices.size() eq 0 }">
					<tr>
						<td colspan="4">등록된 습득물이 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${notices.size() != 0 }">
					<c:forEach items="${notices}" var="n">
						<tr>
							<td>${n.nNo }</td>
							<td><a
								href="${conPath }/noticeContent.laf?nNo=${n.nNo}&pageNum=${currentPage}">${n.nTitle }</a>
							</td>
							<td>${n.nDate }</td>
							<td>${n.nHit }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>