<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
table{
	border-collapse: collapse;
	border : 1px solid green;
}
td{
	width : 200px;
	height : 50px;
	text-align: center;
}
</style> 
   
<%	

	String driver = "oracle.jdbc.driver.OracleDriver";
	String user = "PSJ96";
	String pass = "java";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Class.forName(driver);
	System.out.println("드라이버 로딩");
	
	// Connection 
	Connection con = DriverManager.getConnection(url, user, pass);
	// Statement
	Statement stmt = con.createStatement();
	
	String sql = "select MEM_ID, MEM_NAME FROM MEMBER";
	// resultSet
	
	ResultSet rs = stmt.executeQuery(sql);
%>	
	
	
	<table border="1">
	
<%
	while(rs.next()){
%>	
		<tr>
			<td>아이디</td>
			<td><%=	rs.getString("MEM_ID") %></td>
			
			<td>이름</td>
			<td><%=	rs.getString("MEM_NAME") %></td>
		</tr>	
<%
	}
%>
	</table>

