package kr.or.ddit.join.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceimpl;
import kr.or.ddit.join.vo.ZipVO;

/**
 * Servlet implementation class ZipDong
 */
@WebServlet("/ZipDong")
public class ZipDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userDong = request.getParameter("dong");
		
		IMemberService service = MemberServiceimpl.getInstance();
		
		
		List<ZipVO> dong = service.selectByDong(userDong);
		
		request.setAttribute("dong", dong);
		
		request.getRequestDispatcher("0118/zipsearch.jsp").forward(request, response);
		
		
	}

}
