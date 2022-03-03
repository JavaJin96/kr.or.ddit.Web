package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceimpl;
import kr.or.ddit.board.vo.ReplyVO;


@WebServlet("/ReplyUpdate.do")
public class ReplyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int renum = Integer.parseInt(request.getParameter("renum"));
		String cont = request.getParameter("cont");
		
		BoardServiceimpl service = BoardServiceimpl.getInstance();
		
		ReplyVO vo = new ReplyVO();
		vo.setRenum(renum);
		vo.setCont(cont);
		
		int result = service.updateReply(vo);
		
		request.setAttribute("res", result);
		
		request.getRequestDispatcher("boardsearch/replyupdate.jsp").forward(request, response);
		
		
		
	}

}
