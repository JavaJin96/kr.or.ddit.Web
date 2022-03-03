<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String tel = request.getParameter("tel");

%>

이름 : <%= name %> <br>
아이디 : <%= id %> <br>
비밀번호 : <%= pass %> <br>
전화번호 : <%= tel %> <br>



</body>
</html>