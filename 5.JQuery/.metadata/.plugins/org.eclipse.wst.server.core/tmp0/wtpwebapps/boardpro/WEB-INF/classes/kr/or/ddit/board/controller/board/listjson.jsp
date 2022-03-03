<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");

	
	// json 데이터 자동 생성, VO에 일치하는 항목만 : (vo의 속성과 일치하는 속성들만을 대상으로 한다.)
	Gson gson = new Gson();
	String result = gson.toJson(list);
	
	out.print(result);
	

%>