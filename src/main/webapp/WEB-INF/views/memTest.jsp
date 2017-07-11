<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

	function getMem(){
		$.ajax({
			url:"replies/mem/testid",  			//서버 주소
			type:"get",			//method
			dataType:"json",		//받아올 data 타입
			success:function(data){
				console.log(data);
				var str = "";		
				$(data).each(function(i,obj){
					str = 
					obj.userid+"  "+ obj.userpw + "  " + obj.username;
										
				})
				$("#result").html(str);
			}			
		});
	}
	$(function(){
		$("#btnMem").click(function(){
			getMem();
		});
	});
</script>
</head>
<body>
	<h1>Mem test</h1>
	<div>
		
		
	</div>
	
	<button id="btnMem">Get Mem</button>
	
	<div id="result">
	
	</div>
	
</body>
</html>