package routes;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.maps.model.LatLng;

import dbcontrol.UserDAO;
import dbcontrol.UserRegisterDAO;
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
		// TODO Auto-gprintln("Request sent through");
		
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
	
		String postal = request.getParameter("postal");
		//int type = Integer.parseInt(request.getParameter("type"));
		String type = request.getParameter("type");
		
		String newType = (type.equals("Customer")) ? (newType = "customers") :  (newType = "shops");
		
		if( name == null|| email==null || password==null|| address==null || city==null || state==null
				|| postal == null || type == null) {
			response.setStatus(500);
			response.sendError(500);
			return;
		}
		
		LatLng location = MapGlobal.getInstance().geoCode(address + "," +  " " + state + " " + postal);
		String lat = String.valueOf(location.lat);
		String lng = String.valueOf(location.lng);
		
		System.out.println("Name: "+name+"\n"+
				"Email: "+email+"\n"+
				"Password: "+password+"\n"+
				"Address: "+address+"\n"+
				"City"+city+"\n"+
				"State: "+state+"\n"+
				"Postal: "+postal+"\n" +
				"Location:" +location+"\n"
				);
		
		
		UserDAO dao = new UserRegisterDAO();
		
		boolean res = dao.insert(newType, email, name, password, address, state, lat, lng,city, postal);
		if(res == false) {
			response.setStatus(500);
		}else {
			response.setStatus(200);
		}
		
		
		
	}

}
