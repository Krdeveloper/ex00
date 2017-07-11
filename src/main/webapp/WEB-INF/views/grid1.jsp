<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.row{
		margin-bottom:4px;
		margin-top:4px;
	}
	#row1 div{
		border:1px solid black;
		padding:10px;
	}
	#row2 div{
		border:1px solid red;
		padding:10px
	}
	#row3 div{
		border:1px solid green;
		padding:10px
	}
	#row4 div{
		border:1px solid blue;
		padding:10px
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row" id="row1">
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
			<div class="col-md-1">.col-md-1</div>
		</div>
		<div class="row" id="row2">
			<div class="col-md-8">.col-md-8</div>
			<div class="col-md-4">.col-md-4</div>
		</div>
		<div class="row" id="row3">
			<div class="col-md-4">.col-md-4</div>
			<div class="col-md-4">.col-md-4</div>
			<div class="col-md-4">.col-md-4</div>
		</div>
		<div class="row" id="row4">
			<div class="col-md-6">.col-md-6</div>
			<div class="col-md-6">.col-md-6</div>
			
		</div>
	</div>
</body>
</html>