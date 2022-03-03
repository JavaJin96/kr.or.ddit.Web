<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<% 

	// 서블릿에서 공유한 데이터 가져오기
	int renum = (int)request.getAttribute("renum");
	if(renum > 0){
%>
	{
		"sw" : "저장성공"
	}
	
		
	<%}else{%>
		
	{
		"sw" : "저장실패"
	}	
		
		
<%
	}
%>