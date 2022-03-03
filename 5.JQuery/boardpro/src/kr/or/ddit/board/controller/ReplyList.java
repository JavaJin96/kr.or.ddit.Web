package kr.or.ddit.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.board.service.BoardServiceimpl;
import kr.or.ddit.board.vo.ReplyVO;


@WebServlet("/ReplyList.do")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청시 전송 데이터 - bonum
		request.setCharacterEncoding("utf-8");
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		
		// 2. service 객체 얻기
		BoardServiceimpl service = BoardServiceimpl.getInstance();
		
		// 3. service 메서드 호출 - 결과값 얻기
		List<ReplyVO> list = service.listReply(bonum);
		
		// 4. 결과값으로 json데이터 생성하기
		Gson gson = new Gson();
		String result = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		
		//request.setAttribute("list", list);
		//request.getRequestDispatcher("boardsearch/replylist.jsp").forward(request, response);
		
		
		
	}

}
