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
String cars[] = request.getParameterValues("cars2");

String str="";

	for (int i = 0; i < cars.length; i++){
		str += cars[i] + "&nbsp;&nbsp;&nbsp;";
	}
%>

<p>선택한 차량들은 <%=str %> 입니다. </p>

</body>
</html>