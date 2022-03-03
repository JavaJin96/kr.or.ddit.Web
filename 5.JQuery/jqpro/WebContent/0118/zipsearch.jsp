<%@page import="kr.or.ddit.join.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<ZipVO> res = (List<ZipVO>)request.getAttribute("dong");
	if(res != null){
%>
[

<% 
	
	for(int i = 0; i < res.size(); i++){
		ZipVO vo = res.get(i);
		if(i > 0)out.print(","); 
%> 
	{	
		"addr" : "<%= vo.getSido() %><%= vo.getGugun() %><%=vo.getDong() %>",
		"bunji" : "<%= vo.getBunji() %>",
		"zipcode" : "<%= vo.getZipcode() %>"	
	}
<% 

		}
	}
%>

]