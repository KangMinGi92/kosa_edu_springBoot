<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<table>
		<thead>
			<tr>
				<th>모델번호</th>
				<th>모델이름</th>
				<th>가격</th>
				<th>제조사명</th>
				<th>삭제</th>
			</tr>
		</thead>
		<!-- tbody부분 작성 -->
		<c:forEach items="${phones}" var="phone">
		<tbody>
			<tr>
				<td><a href="detail?num=${phone.num}">${phone.num}</a></td>
				<td>${phone.model}</td>
				<td>${phone.price}</td>
				<td>${phone.company.vendor}</td>
				<td><input type="checkbox" data-num="${phone.num}"></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
	<a href="regPhone">추가 등록</a> <a href="#" id="selectDel">선택항목 삭제</a>
</body>
<script>
	let param = "";
	$('#selectDel').on('click',function(){
		$('[type=checkbox]:checked').each(function(index,item){
			param = param+"&num="+$(item).attr('data-num');
		});//each
		$.ajax({
			type:'post',
			url:'deleteAjax',
			data:param,
			
			success : function(result){
				location.reload();
			}//callback
		})//ajax
	});//on
</script>
</html>











