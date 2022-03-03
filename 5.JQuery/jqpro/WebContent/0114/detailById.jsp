<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

// 클라이언트 요청시 전송데이타(id)를 받는다 - json(중괄호 : {} 방식 ), text(텍스트 방식)

String buyerId = request.getParameter("id");

// db와 연결하여 CRUD처리한다.
// sqlMapClient객체 얻어오기.

SqlMapClient client = SqlMapClientFactory.getSqlMapClient();

// Sql문 수행
BuyerVO vo = (BuyerVO)client.queryForObject("buyer.getBuyerId", buyerId);

// 결과값으로 응답데이터를 생성한다 - text, json, 배열, xml


%>

{
	"id" : "<%= vo.getBuyer_id() %>",
	"name" : "<%= vo.getBuyer_name() %>",
	"add1" : "<%= vo.getBuyer_add1() %>",
	"add2" : "<%= vo.getBuyer_add2() %>",
	"bank" : "<%= vo.getBuyer_bank() %>",
	"bankname" : "<%= vo.getBuyer_bankname() %>",
	"bankno" : "<%= vo.getBuyer_bankno() %>",
	"lgu" : "<%= vo.getBuyer_lgu() %>",
	"mail" : "<%= vo.getBuyer_mail() %>",
	"zip" : "<%= vo.getBuyer_zip() %>"

}