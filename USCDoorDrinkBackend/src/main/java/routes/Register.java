package routes;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MapGlobal;



/**
 * Servlet implementation class Register
 */

@WebServlet(name = "Register", urlPatterns = "/Register")
public class Register extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(MapGlobal.getInstance().geoCode("1600 Amphitheatre Parkway Mountain View, CA 94043").toString());
		System.out.println("Request sent through");
		String password = request.getParameter("password");
		System.out.println();
		String address = request.getParameter("address").toString();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		System.out.println("Request sent through");
		String password = request.getParameter("password");
		System.out.println(password);
	}

}
