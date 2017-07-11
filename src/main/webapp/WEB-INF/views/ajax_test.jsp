<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#modDiv{
		width:300px;
		height:100px;
		background-color: gray;
		position:absolute;
		top:50%;
		left:50%;
		margin-top:-50px;
		margin-left:-150px;
		padding:10px;
		z-index:1000;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

	function getAllList(){
		$.ajax({
			url:"replies/all/502",  			//서버 주소
			type:"get",			//method
			dataType:"json",		//받아올 data 타입
			success:function(data){
				console.log(data);
				var str = "";					
				//$("#result").html(data);
				$(data).each(function(i,obj){
					str += "<li data-rno='"+obj.rno + "'  data-text='"+obj.replytext+"' class='replyLi'>" 
					+obj.rno+" : "+ obj.replyer + " : " + obj.replytext + 
					"<button class='modify'>수정</button></li>";						
				})
				$("#result").html(str);
			}			
		});
	}
	
	function getListPage(page){
		///{bno}/{page}
		$.ajax({
			url:"replies/502/"+page,
			type:"get",
			dataType: "json",
			success: function(data){
				console.log(data);
				var str="";
				$(data.list).each(function(i,obj){
					str += "<li data-rno='"+obj.rno + "'  data-text='"+obj.replytext+"' class='replyLi'>" 
					+obj.rno+" : "+ obj.replyer + " : " + obj.replytext + 
					"<button class='modify'>수정</button></li>";
				});
				var str2 = "";
				$("#result").html(str);
				for(var i=data.pageMaker.startPage; i<=data.pageMaker.endPage; i++){
					str2 += "<a href='"+i+"'>" + i + "</a>";
				}
				$("#page").html(str2);
			}
		});
	}
	$(function(){
		$(document).on("click","#page a", function(event){
			event.preventDefault();//a태그 전송안되게 함
			
			var page = $(this).attr("href");
			getListPage(page);
		});
		
		$("#btnList").click(function(){
			//getAllList();
			getListPage(1);
		});//btnList
		
		$("#btnAdd").click(function(){
			var replyer_data = $("input[name='replyer']").val();
			var bno_data = $("input[name='bno']").val();
			var replytext_data = $("input[name='replytext']").val();
			var sendData = {bno:bno_data,replyer:replyer_data, replytext:replytext_data};
			
			$.ajax({
				url:"replies",
				type:"post",
				dataType:"text",
				data:JSON.stringify(sendData),
				headers:{"Content-Type":"application/json"},
				success:function(data){
					if(data=="SUCCESS"){
						alert("추가되었습니다.");
						console.log(data);
						getAllList();
					}
					
				}
			});
		})
		$("#result").on("click", ".replyLi button", function(){
			var reply = $(this).parent();
								
			var rno = reply.attr("data-rno");
			var replytext = reply.attr("data-text");
			
			$(".modal-title").html(rno);
			$("#replytext").val(replytext);
			$("#modDiv").show("slow");
		});
		$("#replyDelBtn").on("click",function(){
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type:'delete',
				url:'replies/' + rno,
				headers : {
					"Content-Type" : "application/json"					
				},
				dataType : 'text',
				success : function(result){
					console.log("result: " + result);
					if(result=='SUCCESS'){
						alert("삭제됨");
						$("#modDiv").hide("slow");
						getAllList();
					}
				}
			});
		});
		$("#replyModBtn").on("click", function(){
			var rno=$(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type : 'put',
				url : 'replies/' + rno,
				headers : {
					"Content-Type" : "application/json"					
				},
				data : JSON.stringify({replytext:replytext}),
				dataType : 'text',
				success : function(result){
					console.log("result: " + result);
					if(result=='SUCCESS'){
						alert("수정되었습니다.");
						$("#modDiv").hide("slow");
						getAllList();
					}
				}
			});
		})
	}); 
	
	
</script>
</head>
<body>
	<h1>ajax TEST page</h1>
	<div>
		게시물 번호 : <input type="text" name="bno" placeholder="bno"><br>
		댓글 작성자 : <input type="text" name="replyer" placeholder="replyer"><br>
		댓글 내용 :  <input type="text" name="replytext" placeholder="replytext"><br>
		<button id="btnAdd">댓글 추가</button>
	</div>
	
	<button id="btnList">Get List</button>
	<div id='modDiv' style="display: none;">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">delete</button>
			<button type="button" id="closeBtn">close</button>
		</div>
	</div>
	<div id="result">
		
	</div>
	<div id="page"></div>
	
</body>
</html>