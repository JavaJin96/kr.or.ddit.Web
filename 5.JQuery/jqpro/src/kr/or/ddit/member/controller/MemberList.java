package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceimpl;
import kr.or.ddit.join.vo.MemberVO;


@WebServlet("/MemberList.do")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service 객체 얻기
		IMemberService service = MemberServiceimpl.getInstance();
		
		// service 메서드 호출하기 : 결과값 가져오기 
		List<MemberVO> list = service.selectAll();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("동기html/member.jsp").forward(request, response);
		
		
/*		// 결과값을 출력하기 
		out.println("<html><body><table>");
		out.println("<tr><td>아이디</td>");
		out.println("<td>이름</td>");
		out.println("<td>메일</td>");
		out.println("<td>전화번호</td></tr>");
		
		for(int i =0; i < list.size(); i++	) {
			MemberVO vo = list.get(i);
			out.println("<tr><td>" + vo.getMem_id() + "</td>");
			out.println("<td>" + vo.getMem_name() + "</td>");
			out.println("<td>" + vo.getMem_mail() + "</td>");
			out.println("<td>" + vo.getMem_hp() + "</td></tr>");
		}
		out.println("</table>");
		out.println("</body></html>");*/
		
		
	}



}
