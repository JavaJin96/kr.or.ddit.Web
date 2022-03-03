<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 클라이언트 요청시 전송데이터를 받는다 - json, text, 배열
/* {"id" : "a001" , "pass" : "1235678"} // json데이터

id=a001&pass=12345678	//text데이터
 */
 
 // DB와 연결하여 CRUD처리한다.
 
 // 결과값으로 응답 데이터를 생성한다. - text, json, 배열, xml, html
 
%>

	<%--res.id		res.name	res.addr	res.tel   --%>
{
	"id" : "a001",
	"name" : "홍길동",
	"addr" : "대전시 동구",
	"tel" : "010-1234-5678"

}
