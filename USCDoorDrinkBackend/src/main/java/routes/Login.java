package routes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcontrol.UserDAO;
import dbcontrol.UserLoginDAO;
import dbcontrol.UserRegisterDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		String newType = (type.equals("Customer")) ? (newType = "customers") :  (newType = "shops");
		
		//System.out.println(email+password+newType);
		
		UserDAO dao = new UserLoginDAO();
		boolean result = dao.find(email,password,type);
		
		//System.out.println(result);
		if(result==true) {
			response.setStatus(200);
		}else {
			response.sendError(500);
		}
	}

}
