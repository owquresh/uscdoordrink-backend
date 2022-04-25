package routes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.maps.model.LatLng;

import dbcontrol.EditAddressDAO;
import util.MapGlobal;

/**
 * Servlet implementation class EditAddress
 */

@WebServlet(name = "EditAddress", urlPatterns = "/EditAddress")
public class EditAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAddress() {
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
		System.out.println("Here");
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postal = request.getParameter("postal");
		
		
		if( email==null || address==null || city==null || state==null || postal == null || type == null) {
			response.setStatus(500);
			response.sendError(500);
			return;
		}
		
		LatLng location = MapGlobal.getInstance().geoCode(address + "," +  " " + state + " " + postal);
		String lat = String.valueOf(location.lat);
		String lng = String.valueOf(location.lng);
		
		
		EditAddressDAO dao = new EditAddressDAO();
		
		boolean res = dao.update(email, type, address, state, lat, lng, city, postal);
		if(res == false) {
			response.setStatus(500);
		}else {
			response.setStatus(200);
		}
	}

}
