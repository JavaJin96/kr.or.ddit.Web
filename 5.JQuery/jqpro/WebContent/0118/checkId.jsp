<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 서블릿에서 저장된 id값을 꺼내온다.
	String res = (String)request.getAttribute("id");
	if(res != null){
%>		
	{
		"sw" : "사용불가능 id"
	}
		
		
<%}else{%>
	
	{
		"sw" : "사용가능 id"
	}
	
	
<%		
	}
%>