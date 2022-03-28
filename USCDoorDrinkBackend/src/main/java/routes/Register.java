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
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postal = request.getParameter("postal");
		
		
		//System.out.println(MapGlobal.getInstance().geoCode("1600 Amphitheatre Parkway Mountain View, CA 94043").toString());
		//System.out.println("Request sent through");
		System.out.println("Name: "+name+"/n"+
				"Username: "+username+"/n"+
				"Email: "+email+"/n"+
				"Password: "+password+"/n"+
				"Address: "+address+"/n"+
				"City"+city+"/n"+
				"State: "+state+"/n"+
				"Postal: "+postal+"/n");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("Request sent through");
		
	}

}
