<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import= "com.javaex.vo.GuestVo" %>    

<%
	int no = (int)request.getAttribute("no");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="/gb2/gbc" method="post"> 
		비밀번호: <input type= "password" name="password">
		<input type = "hidden" name = "no" value = <%= no %>>
		<input type = "hidden" name = "action" value = "delete">
		<button type="submit">확인</button>
		</form>
		<p><a href ="/gb2/gbc?action=main" >메인으로 돌아가기</a></p>
</body>
</html>