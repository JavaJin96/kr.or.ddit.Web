<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
//클라이언트 요청시 전송데이터를 받는다 - json, text, 배열
/* {"id" : "a001" , "pass" : "1235678"} // json데이터

id=a001&pass=12345678	//text데이터
*/

//DB와 연결하여 CRUD처리한다.

//결과값으로 응답 데이터를 생성한다. - text, json, 배열, xml, html
%>


<%-- res[i].id  	res[i].name		res[i].tel --%>

[
{	"id" : "a001",
	"name" : "홍길동",
	"addr" : "대전시 동구 오류동",
	"tel" : "010-1234-5678"
	},
	
{	"id" : "b001",
	"name" : "개나리",
	"addr" : "대전시 서구 탄방동",
	"tel" : "010-1224-5534"
	},
	
{	"id" : "c001",
	"name" : "진달래",
	"addr" : "대전시 동구 홍도동",
	"tel" : "010-2344-5643"
	},
	
{	"id" : "d001",
	"name" : "무궁화",
	"addr" : "대전시 대덕구 송촌동",
	"tel" : "010-1876-4555"
	},
	
{	"id" : "e001",
	"name" : "삼천리",
	"addr" : "대전시 유성구 구암동",
	"tel" : "010-3463-8778"
	}


]
