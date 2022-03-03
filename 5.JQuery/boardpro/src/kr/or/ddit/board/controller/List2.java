package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.board.service.BoardServiceimpl;
import kr.or.ddit.board.vo.BoardVO;


@WebServlet("/List2.do")
public class List2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청시 전송데이터 받기
		
		// 2. service객체 얻기
		BoardServiceimpl service = BoardServiceimpl.getInstance();
				
		// 3. service메소드 호출 - 결과값 받기
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) service.selectBoard();
		
		// 4. GSON 라이브러리를 이용하여 Json데이터 만들기
		Gson gson = new Gson();
		String result = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(result);
		
		
	}

}
