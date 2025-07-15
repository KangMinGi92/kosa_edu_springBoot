<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
 <!-- jquery cdn ::  cloudflare, google, ms, jquery -->
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
form{
	width: 300px;
	margin: 0 auto;
}
</style>
<script>
$(function(){
	$('#id').on('keyup',function(){
		let userId=$(this).val();
		if(userId.length>=4 && userId.length<=8){
			//비동기 처리로 해당 아이디를 사용할 수 있는지 여부를 요청
			$.ajax({
				//요청
				type:'post',
				url:'idExist',
				data:{'id':userId},
				
				//응답
				success:function(result){
					console.log(result);
					if(result == userId){
						$('#resultView').html('<h4><font color=crimson>중복된 아이디 입니다.</font></h4>');
					}else{
						$('#resultView').html('<h4><font color=lightblue>사용가능한 아이디 입니다.</font></h4>');
					}
				}
			})//ajax
		}else{
			$('#resultView').html('<h4><font color=crimson>ID길이가 적합하지 않습니다.</font></h4>');
		}
	})//keyup
})//ready
</script>
</head>
<body>
<div class="container">
	<div class="jumbotron" align="center">
		<h2>REGISTER MEMBER FORM</h2>
	</div>
</div>
<hr>
<div class="container">	
	 <form action="register" method="post">	
    <div class="form-group">
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter Id" name="id">
      <span id="resultView"></span>     
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    </div>
        <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
        <div class="form-group">
      <label for="address">Address:</label>
      <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
    </div>
 
    <button type="submit" class="btn btn-primary" id="submit_btn">Submit</button>
  </form>

</div>

</body>
</html>