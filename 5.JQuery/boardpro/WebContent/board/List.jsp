<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%
  //서블릿에서 저장된 list를 꺼내기
  
  List<BoardVO> list =
  			(List<BoardVO>)request.getAttribute("list");
  
  
  %>
  
  [
  
  <% 
  	for(int i=0; i < list.size(); i++){
  		BoardVO vo = list.get(i);
  		if(i > 0) out.print(",");
 	%>		
  	
  	{
  	
  	"num" : "<%=vo.getNum() %>",
  	"Writer" : "<%=vo.getWriter() %>",
  	"Subject" : "<%=vo.getSubject() %>",
  	"Mail" : "<%=vo.getMail() %>",
  	"Hit" : "<%=vo.getHit() %>",
  	"Wdate" : "<%=vo.getWdate() %>",
  	"Content" : "<%=vo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>") %>"
  	
  	
 
  	
  	}
  
  
  <%
  	}
  
  %>
  
  
  
  
  
  ]
  