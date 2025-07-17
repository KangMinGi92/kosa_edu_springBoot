<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>목 록</b><p>
<table border="1" width="650" cellpadding="2">
	<tr>
		<th width="10%">번 호</th>
		<th width="50%">제 목</th>
		<th width="15%">작성자</th>
		<th width="15%">작성일</th>
		<th width="10%">조회수</th>
	</tr>
	<c:forEach items="${list}" var="bvo">
	<tr>
		<td>${bvo.no}</td>
		<td><a href="showContent?no=${bvo.no}">${bvo.title}</a></td>
		<td>${bvo.member.name}</td>
		<td>${bvo.writeDate}</td>
		<td>${bvo.count}</td>
	</tr>	
	</c:forEach>
</table><p>

<a href="${pageContext.request.contextPath}/index.jsp">홈으로</a>

<c:if test="${not empty mvo}">
<a href="board/write.jsp"><img alt="게시판 글쓰기" src="img/write_btn.jpg" border="0"></a>
</c:if>
</body>
</html>



