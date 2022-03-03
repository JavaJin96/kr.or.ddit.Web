<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		p{
			font-size : 2.0em;
		}
		h1{
			color : red;
		}
	</style>
	</head>
	<body>
		<h1>JSP : Java Server Page</h1>
		서버프로그램 : 서버내에서 실행되는 프로그램<br>
		html를 기본으로 하여 java언어를 사용할 수 있다.<br>

		&lt;% %> 기호 사이에 java코드를 기술한다.<br>
		&lt;%= %> java변수를 출력할 때 사용<br>

		클라이언트가 전송시 입력데이터를 가져온다.<br>
		request 라는 객체를 이용하여 전달받는다.
 
	<%
	
	request.setCharacterEncoding("UTF-8");
	
	String userId = request.getParameter("id");
	String userName = request.getParameter("name");
	int num = Integer.parseInt(request.getParameter("num"));
	%>
	
	<P> 아이디 <%=userId %> </P>
	<P> 이름 <%=userName %> </P>
	<P> 번호 <%=num %> </P>

</body>
</html>