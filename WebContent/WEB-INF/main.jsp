<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import= "java.util.List" %>
<%@ page import= "com.javaex.vo.GuestVo" %>    

<%
	List<GuestVo> gList = (List<GuestVo>)request.getAttribute("guestlist");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/gb2/gbc" method="post">
		<table border="1">
		<colgroup>
	  		<col style = "width : 50px">
	  		<col style = "width : 150px">
	  		<col style = "width : 100px">
	  		<col style = "width : 150px">
		</colgroup>
			<tr>
				<td>이름</td>
				<td><input type= "text" name="name"></td>
				<td>비밀번호</td>
				<td><input type= "password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea style = "width:98%;" rows="5" name = "content">방명록 적어주세요!</textarea></td>
			</tr>
			<tr>
				<td colspan="4">
					<input type = "hidden" name="action" value="insert">
					<button type= "submit">확인</button>
				</td>
			</tr>
		</table>
	</form>
	<br>
	
	<%for(GuestVo vo : gList){%>
		<table border= "1">
		<colgroup>
	  		<col style = "width : 50px">
	  		<col style = "width : 100px">
	  		<col style = "width : 260px">
	  		<col style = "width : 100px">
		</colgroup>
			<tr>
				<td><%= vo.getNo() %></td>
				<td><%= vo.getName() %></td>
				<td><%= vo.getDate() %></td>
				<td>
					<a href= "/gb2/gbc?no=<%=vo.getNo()%>&action=dform">삭제</a>
				</td>
			</tr>
			<tr>
				<td colspan="4"><%= vo.getContent() %></td>
			</tr>
		</table>
		<br>
	<%}%>	
	

	
</body>
</html>