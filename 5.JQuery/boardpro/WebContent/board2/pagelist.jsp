<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


Map<String, Object> datamap = (Map<String, Object>)request.getAttribute("map");
List<BoardVO> datalist = (List<BoardVO>)request.getAttribute("list");

%>

{
	"totalPage" : "<%= datamap.get("totalPage") %>",
	"startPage" : "<%= datamap.get("startPage") %>",
	"endPage" : "<%= datamap.get("endPage") %>",
	"datas" : [
	
	<% 
		for(int i = 0; i < datalist.size(); i++){
			BoardVO vo = datalist.get(i);
			if(i > 0) out.print(",");
	%>
			{
				"num" : "<%= vo.getNum() %>",
				"writer" : "<%= vo.getWriter() %>",
				"subject" : "<%= vo.getSubject() %>",
				"mail" : "<%= vo.getMail() %>",
				"hit" : "<%= vo.getHit() %>",
				"wdate" : "<%= vo.getWdate() %>",
				"content" : "<%= vo.getContent() %>"
			
			}
			
	<% 
		}// for문 끝
	%>
	
			]
			
}








