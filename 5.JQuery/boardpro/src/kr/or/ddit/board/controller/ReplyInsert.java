package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceimpl;
import kr.or.ddit.board.vo.ReplyVO;


@WebServlet("/ReplyInsert.do")
public class ReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청시 값을 가져온다. - bonum, name, cont
		request.setCharacterEncoding("utf-8");
		
		int bonum = Integer.parseInt(request.getParameter("bonum"));
		String name = request.getParameter("name");
		String cont = request.getParameter("cont");
		
		ReplyVO vo = new ReplyVO();
		vo.setBonum(bonum);
		vo.setName(name);
		vo.setCont(cont);
		
		// 2. 서비스객체 가져오기
		BoardServiceimpl service = BoardServiceimpl.getInstance();
		
		// 3. service 메서드 호출 (결과값 받기)
		int renum = service.insertReply(vo);
		
		// 4. 결과값으로 json데이터 생성하기 : jsp로 위임
		request.setAttribute("renum", renum);
		request.getRequestDispatcher("boardsearch/replyInsert.jsp").forward(request, response);
		
		
	}

}
