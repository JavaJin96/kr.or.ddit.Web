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
	request.getParameter("name");
	request.getParameter("email");
	request.getParameter("contents");

	
	%>
	
	<p>처리되었습니다.</p>
	
	
</body>
</html>