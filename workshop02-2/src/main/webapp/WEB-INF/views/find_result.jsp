<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>

</style>
</head>
<body>
<div class="container">
	<h1>Prodcut List</h1>
	<c:choose>
		<c:when test="${ not empty products}">
			<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>상품명</th>
					<th>제조사</th>
					<th>가격</th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tbody>
					<tr>
						<td>${product.name}</td>
						<td>${product.maker}</td>
						<td>${product.price}</td>
					</tr>
				</tbody>
			</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h2>조회한 결과가 없습니다. 다시 조회하세요</h2>
		</c:otherwise>
	</c:choose>
	<a href="myProduct.html">뒤로가기</a>
</div>
</body>
</html>