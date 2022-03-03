<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 

	// 요청시 전송데이터 : id, name, addr
	String userid = request.getParameter("id");
	String username = request.getParameter("name");
	String useraddr = request.getParameter("addr");
	
	// DB연결 CRUD처리 : DB에 저장한다.
	
	// 결과를 가지고 응답데이터를 생성한다.

%>

{
	"msg" : "<%= username %> 님 행복한 하루 되세요"
}