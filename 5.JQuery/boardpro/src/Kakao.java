

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Kakao.do")
public class Kakao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String partner_order_id = request.getParameter("partner_order_id");
		String partner_user_id = request.getParameter("partner_user_id");
		String item_name = request.getParameter("item_name");
		String quantity = request.getParameter("quantity");
		String total_amount = request.getParameter("total_amount");
		String tax_free_amount = request.getParameter("tax_free_amount");
		String cancel_url = request.getParameter("cancel_url");
		String fail_url = request.getParameter("fail_url");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
