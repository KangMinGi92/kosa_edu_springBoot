<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrapper{
		display:flex;
		flex-flow: row wrap;
		justify-content: center;
		align-items:center;
	}
</style>
</head>
<body>
<h1 align="center">상품 상세 화면</h1>
<div class="wrapper">
	<c:if test="${not empty item }">
		<img src="${item.url}" width="400" height="400">
		<div>
			<table>
				<tbody>
					<tr>
						<td>상품명<td>
						<td>${item.name}</td>
					</tr>
					<tr>
						<td>가격<td>
						<td>${item.price}</td>
					</tr>
					<tr>
						<td>비고<td>
						<td>${item.description}</td>
					</tr>
					<tr>
						<td colspan="2"><a href="itemList"> ■목록으로 돌아가기</a><td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>
</div>
</body>
</html>