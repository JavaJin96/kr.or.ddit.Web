package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.server.ServiceDefinitionImpl;

import kr.or.ddit.board.service.BoardServiceimpl;


@WebServlet("/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 클라이언트 요청시 전송값 - renum
		request.setCharacterEncoding("utf-8");
		int renum = Integer.parseInt(request.getParameter("renum"));
		
		// 2. service 객체 얻기
		BoardServiceimpl service = BoardServiceimpl.getInstance();
		
		// 3. service 메서드 호출하기 - 결과 값
		int result = service.deleteReply(renum);
		
		// 4. 결과값으로 json데이터 생성하기
		request.setAttribute("resnum", result);
		request.getRequestDispatcher("boardsearch/replydelete.jsp").forward(request, response);
		
	}

}
