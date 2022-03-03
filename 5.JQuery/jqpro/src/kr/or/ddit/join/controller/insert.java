package kr.or.ddit.join.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceimpl;
import kr.or.ddit.join.vo.MemberVO;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert.do")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("mem_id");
		String name = request.getParameter("mem_name");
		String pass = request.getParameter("mem_pass");
		String mail = request.getParameter("mem_mail");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		String hp = request.getParameter("mem_hp");
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(id);
		vo.setMem_name(name);
		vo.setMem_pass(pass);
		vo.setMem_mail(mail);
		vo.setMem_zip(zip);
		vo.setMem_add1(add1);
		vo.setMem_add2(add2);
		vo.setMem_hp(hp);
		
		IMemberService service = MemberServiceimpl.getInstance();
		
		String sid = service.insertMember(vo);
		
		request.setAttribute("bob", sid);
		
		request.getRequestDispatcher("0118/insert.jsp").forward(request, response);
		
	}

}
