<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% 

String lgu = request.getParameter("lgu");

SqlMapClient client = SqlMapClientFactory.getSqlMapClient();
List<ProdVO> list = client.queryForList("prod.selectProd", lgu);


if(list != null && list.size() > 0 ){
%>
   
   {
      "sw" : "ok",
      "datas" : [
         
        <%
         for(int i=0; i < list.size(); i++){
         ProdVO vo = list.get(i);
         if(i > 0)out.print(",");
        %>
         
         {
            "id" : "<%= vo.getProd_id() %>",
            "nm" : "<%= vo.getProd_name() %>"
         }
      <%
      }
      %>
      
      ]
      
   }


<%}else{%>
   
   
   {
   
      "sw" : "no"
   
   }


<%    
}
%>

