package routes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcontrol.DeliveryCompleteDAO;

/**
 * Servlet implementation class DeliveryComplete
 */
public class DeliveryComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String orderID = request.getParameter("orderID");
		
		System.out.println("In Delivery Complete");
		if(orderID == null || orderID =="") {
			response.setStatus(500);
			response.sendError(500);
			return;
		}
		char temp = orderID.charAt(orderID.length()-1);
		int oID = Character.getNumericValue(temp);
		
		DeliveryCompleteDAO dao = new DeliveryCompleteDAO();
		boolean res = dao.deliveryComplete(oID);
		if(res == false) {
			response.setStatus(500);
		}else {
			response.setStatus(200);
		}
		
		
		
	}

}
