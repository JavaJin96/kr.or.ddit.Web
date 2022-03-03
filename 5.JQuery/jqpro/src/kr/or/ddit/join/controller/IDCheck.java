package kr.or.ddit.join.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.join.service.IMemberService;
import kr.or.ddit.join.service.MemberServiceimpl;

/**
 * Servlet implementation class IDCheck
 */
@WebServlet("/IDCheck")
public class IDCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IDCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청시 전송데이터를 받는다 : 입력받은 ID를 중복체크하기 위함
		String	userId = request.getParameter("id"); 
		
		System.out.println("----------------" + userId);
		
		
		// service객체를 호출한다.
		IMemberService service = MemberServiceimpl.getInstance();
		
		
		
		// service객체에서 메서드를 호출하여 처리한다. : 결과값을 받는다.
		
		String id = service.selectById(userId);
		System.out.println("----------------" + id);

		
		// 결과값을 가지고 응답데이터를 만들어 출력한다. : json데이터를 생성한다.
		
		// html로 출력하거나 json데이터로 생성 : jsp로 위임
		// 결과값을(id) request객체에 저장(jsp와 서블릿 사에의 정보를 교환하기 위해서)
		
		request.setAttribute("id", id);
		
		// jsp로 보내는 방법 (forword : 서블릿의 request와 jsp를 공유한다. , redirect : 둘간의 공유는 없다.)
		request.getRequestDispatcher("0118/checkId.jsp").forward(request, response);
		
/*		
 * 		out.print 를 통해서 HTML이나 json데이터로 출력이 가능하다.
 * 		PrintWriter out = response.getWriter();
		
		if(id != null) {
			out.print("{");
			out.print("   \"sw\" : \"사용불가능 아이디입니다.\"    ");	
			out.print("}");
		}else {
			out.print("{");
			out.print("  \"sw\" : \"사용가능 ID입니다.\"         ");	
			out.print("}");
		}*/
		

	}

}
