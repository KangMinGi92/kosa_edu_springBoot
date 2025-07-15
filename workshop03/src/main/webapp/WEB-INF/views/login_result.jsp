<%@page import="com.service.spring.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login Information</h2>
ID ${vo.id}<br>
NAME ${vo.name}<br>
ADDRESS ${vo.address}<br>
<p></p><hr><p></p>
<a href="logout">LOG OUT</a>
<a href="index.jsp">INDEX</a>
</body>
</html>


















