<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#dropBox{
		width:400px;
		height:300px;
		border:1px solid gray;
		overflow:auto;
	}
	
	#dropBox img{
		width:100px;
		height:130px;
	}
	
	#result{
		width:400px;
		height:300px;
		border:1px solid red;
	}
	div.item{
		width:100px;
		margin:3px;
		float:left;
		position:relative;
	}
	button.del{
		position:absolute;
		top:10px;
		right:10px;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<form id="f1" action="dragUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="writer">
		<input type="submit">		
		
	</form>
	
	<div id="dropBox"></div>
	<div id="result"></div>
	
	<script type="text/javascript">
		var formData = new FormData();
		
		$("#dropBox").on("dragenter dragover", function(event){
			event.preventDefault();//브라우저에서 파일을 끌어다 놓아도 아무런 동작을 하지 않게 처리함.
		})
		$("#dropBox").on("drop", function(event){
			event.preventDefault();
			
			var files= event.originalEvent.dataTransfer.files;
			var file = files[0];
			console.log(file);
			
			var reader = new FileReader();
			//load 이벤트가 발생이 되면 FileReader 객체가 실행되면서, 파일안의 데이터를 읽어서 반환한다.
			reader.addEventListener("load", function(e) {
				var imgObj = $("<img>");
				imgObj.attr("src",reader.result);
				$("#dropBox").append(imgObj);
			}, false);
			
			if(file){
				reader.readAsDataURL(file);//reader의 load이벤트를 발생시킴
			}
			
			if(formData == null)
				formData = new FormData();
			
			
			formData.append("files", file);
		})
		
		$("#f1").submit(function(event){
			event.preventDefault();
			
			var writer = $("input[name='writer']").val();
			
			formData.append("writer", writer); //key, value
			
			$.ajax({
				url:"dragUpload",
				type:"post",
				processData :false,
				contentType:false,
				data:formData,
				success:function(data){
					console.log(data);
					$(data).each(function(i, obj) {
						var itemDivObj = $("<div>").addClass("item");
						var imgObj = $("<img>");
						console.log(obj);
						imgObj.attr("src","displayFile?filename="+obj);
						var buttonObj = $("<button>").addClass("del").text("X");
						buttonObj.attr("data-src", obj);//filename을 삭제시, 쉽게 뽑기위해 처리
						
						itemDivObj.append(imgObj).append(buttonObj);
						
						$("#result").append(itemDivObj);
					})
				}
			})
		})
		
		$(document).on("click","button.del", function(){
			var filename = $(this).attr("data-src");
			console.log(filename);
			
			$.ajax({
				url:"deleteFile",
				type:"post",
				data:{filename:filename},
				dataType:"text",
				success:function(data){
					alert(data);
				}
			});
		})
		
	</script>
</body>
</html>






