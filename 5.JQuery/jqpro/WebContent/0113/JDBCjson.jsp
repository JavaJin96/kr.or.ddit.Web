<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

[
<% 
	int i = 0;
	while(rs.next()){
		if(i > 0) out.print(",");
			
		
%>
	{
		"id" : "<%= rs.getString("mem_id") %>",
		"name" : "<%= rs.getString("mem_name") %>"	
	}
		
<%		
		i++;
	}
%>

]











