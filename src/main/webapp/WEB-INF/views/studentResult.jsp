<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>학생 정보</p>
	
	이름:${studentInfo.name }	<br>
	학년:${studentInfo.grade }	<br>
    수학:${studentInfo.math }	<br>   
    	영어 :  ${studentInfo.eng }<br>      
    국어:${studentInfo.kor }<br>
    등급 : ${studentInfo.info }
	
</body>
</html>