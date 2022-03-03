
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClientBuilder"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String dlgu = request.getParameter("dlgu");

SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();

ProdVO vo = (ProdVO)smc.queryForObject("prod.selectDetail", dlgu);

%>


{

	"id" : "<%=vo.getProd_id() %>",
	"name" : "<%=vo.getProd_name() %>",
	"lgu" : "<%=vo.getProd_lgu() %>",
	"buyer" : "<%=vo.getProd_buyer() %>",
	"cost" : "<%=vo.getProd_cost() %>",
	"price" : "<%=vo.getProd_price() %>",
	"sale" : "<%=vo.getProd_sale() %>",
	"outline" : "<%=vo.getProd_outline() %>",
	"detail" : "<%=vo.getProd_detail() %>"

}