<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%

// 서블릿에서 공유 데이터 꺼내기
int renum = (int)request.getAttribute("resnum");

if(renum > 0 ){
%>
	{
		"sw" : "삭제성공"
	}
<% }else{ %>
	{
		"sw" : "삭제실패"
	}
<%
}
%>