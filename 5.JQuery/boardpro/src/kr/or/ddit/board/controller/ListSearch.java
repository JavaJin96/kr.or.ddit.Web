package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.ddit.board.service.BoardServiceimpl;
import kr.or.ddit.board.vo.BoardVO;


@WebServlet("/ListSearch.do")
public class ListSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트 요청시 값 가져오기. page, type, word
		request.setCharacterEncoding("utf-8");
		int cpage = Integer.parseInt(request.getParameter("page"));
		String stype = request.getParameter("type");
		String sword = request.getParameter("word");
		
		Map<String, Object> map = new HashMap<>();
		map.put("stype", stype);
		map.put("sword", sword);
		map.put("cpage", cpage);
		
		
		// service객체 얻기
		BoardServiceimpl service = BoardServiceimpl.getInstance();
		
		// 서비스 메서드 호출하기
		Map<String, Object> rmap = service.pageInfo(map);
		rmap.put("stype", stype);
		rmap.put("sword", sword);
		
		
		List<BoardVO> list = service.selectBoard3(rmap);
		
		// 결과값으로 JSON데이터 생성하기
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("totalPage", (Integer)rmap.get("totalPage"));
		obj.addProperty("endPage", (Integer)rmap.get("endPage"));
		obj.addProperty("startPage", (Integer)rmap.get("startPage"));
		
		Gson gson = new Gson();
		JsonElement ele = gson.toJsonTree(list);
		obj.add("datas", ele);
		
		out.print(obj);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
