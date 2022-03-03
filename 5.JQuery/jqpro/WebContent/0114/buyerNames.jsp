<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.config.SqlMapClientFactory"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 

// 1. 클라이언트 요청시 전송데이타를 받는다. 

// DB연결 CRUD처리 : DB에 저장한다. - ibatis이용

// 결과를 가지고 응답데이터를 생성한다.


// 2. SqlMapClient 객체를 얻어온다.
SqlMapClient client = SqlMapClientFactory.getSqlMapClient();

// 3. 실행
List<BuyerVO> list = client.queryForList("buyer.getAllBuyer");

%>

[

<%
	for(int i = 0; i < list.size(); i++){
		BuyerVO vo = list.get(i);
		if(i > 0 ) out.print(",");
%>
	{
		"id" : "<%= vo.getBuyer_id() %>",
		"name" : "<%= vo.getBuyer_name() %>"
	}

		
<%		
	}
%>
]