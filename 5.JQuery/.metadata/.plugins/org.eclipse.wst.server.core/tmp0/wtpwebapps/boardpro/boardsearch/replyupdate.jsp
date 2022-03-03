<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int res = (int)request.getAttribute("res");
	if(res > 0){
%>
	{
		"sw" : "수정이 완료되었습니다."
	}
	
<% }else{ %>

	{
		"sw" : "수정에 실패하였습니다."
	}


<%
	}
%>