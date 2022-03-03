package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/ListPage.do")
public class ListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트 요청시 전송데이터 가져오기 : page
		int page = Integer.parseInt(request.getParameter("page"));
		
		// 2. service 객체 얻어오기
		BoardServiceimpl service = BoardServiceimpl.getInstance();
		
		// 3. service 메서드 호출하기 : 결과값 얻기
		Map<String, Object> map = service.pageInfo(page);
		
		List<BoardVO> list = service.selectBoard2(map);
		
		// 4. 결과값으로 json데이터 생성
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		JsonObject obj = new JsonObject();
		
		obj.addProperty("totalPage", (Integer)map.get("totalPage"));
		obj.addProperty("endPage", (Integer)map.get("endPage"));
		obj.addProperty("startPage", (Integer)map.get("startPage"));
		
		Gson gson = new Gson();
		JsonElement ele = gson.toJsonTree(list);
		obj.add("datas", ele);
		
		out.print(obj);
		
		
		
		// jsp로 위임해서 처리하는 방법
/*		// 4. 결과값으로 json데이터 생성하기
		// request에 결과값 저장
		request.setAttribute("map", map);	//start, end, startPage, endPage, totalPage
		request.setAttribute("list", list);
		
		
		// 5. jsp로 forward
		request.getRequestDispatcher("board2/pagelist.jsp").forward(request, response);*/
		
		
		
		
		
		
	}

}
