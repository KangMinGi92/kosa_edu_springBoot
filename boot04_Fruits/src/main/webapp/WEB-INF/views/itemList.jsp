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
		display: flex;
		flex-flow: row wrap;
		justify-content: space-between;
	}
	img { 
		border: 10px solid skyblue;
		border-radius: 10px;	
	}
	.itemlist{
		cursor: pointer;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	$('.itemlist').on('click',function(){
		let itemId=$(this).find('#itemId').val();
		window.location.href="itemView?itemId="+itemId;
	});
/* 	$('.itemlist').on('click',function(){
		let itemId=$('#itemId').val();
		$.ajax({
			type : 'get',
			url : 'itemView',
			data : itemId,
			
			success : function(result){
				console.log("성공");
			},
		});
	}); */
});
</script>
</head>
<body>
<h1 align="center" style="color : blue;">Fruit Total List 1.</h1>
<div class="wrapper">
	<c:choose>
		<c:when test="${not empty itemList}">
			<c:forEach items="${itemList}" var="item">
				<div class="itemlist">
					<input type="hidden" id="itemId" name="itemId" value="${item.itemNumber}">
					<img src="${item.url}" width="250" height="250">
					<h2>상품명 : ${item.name}</h2>
					<h2>가격 : ${item.price}</h2>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h2><a href="index.jsp">출력할 결과물이 없습니다. 다시 조회하세요</a></h2>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>