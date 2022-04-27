package routes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcontrol.ConnectionFactory;
import models.Order;
import models.Shop;
import util.GsonGlobal;

/**
 * Servlet implementation class CurrOrder
 */
@WebServlet(name = "CurrOrder", urlPatterns = "/CurrOrder")
public class CurrOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String findShopID = "SELECT id FROM shops WHERE email =?";
	public static final String getShopOrders = "SELECT * FROM orders WHERE shopID=?";
	public static final String findItemName = "SELECT item FROM shopItems WHERE itemID=?";
	public static final String findCustomerAddress = "SELECT address FROM customers WHERE id=?";

	ArrayList<Order> orders  = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CurrOrder() {
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
		int shopID;
		ResultSet rs;
		ResultSet rs2;
		PreparedStatement prep = null;
		PreparedStatement prep2 = null;
		Connection conn = ConnectionFactory.initializeConnection();

		try {
			// get the shopID
			String email = request.getParameter("email");
			prep = conn.prepareStatement(findShopID);
			prep.setString(1, email);
			rs = prep.executeQuery();
			if(rs.next()) {
				shopID = rs.getInt("id");
			}
			else {
				response.sendError(500);
				return;
			}

			// get the shops Orders
			prep = null;
			prep = conn.prepareStatement(getShopOrders);
			prep.setInt(1, shopID);
			rs = prep.executeQuery();

			// read each order
			while(rs.next()) {
				String orderItemName;
				String address;
				int orderID = rs.getInt("orderID");
				int customerID = rs.getInt("customerID");
				int total_caffine =rs.getInt("total_caffine");
				int orderItem = rs.getInt("orderItem");
				Timestamp orderTime = rs.getTimestamp("orderTime");
				Timestamp deliveredTime = rs.getTimestamp("deliveredTime");
				
				// if the order is not delivered yet then only send to front end
				if(deliveredTime == null) {

					//find the item name
					prep2 = conn.prepareStatement(findItemName);
					prep2.setInt(1, orderItem);
					rs2 = prep2.executeQuery();
					if(rs2.next()) {
						orderItemName = rs2.getString("item");
					}else {
						response.sendError(500);
						return;
					}
					
					// find the customer address
					prep2 = null;
					prep2 = conn.prepareStatement(findCustomerAddress);
					prep2.setInt(1, customerID);
					rs2 = prep2.executeQuery();
					if(rs2.next()) {
						address = rs2.getString("address");
					}else {
						response.sendError(500);
						return;
					}

					// add order to the list
					System.out.println("OrderId: "+orderID);
					Order curr = new Order(orderID, customerID, address,total_caffine, orderTime.toString(), orderItemName);
					orders.add(curr);
				}
			}
			response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print(GsonGlobal.getInstance().toJson(orders));
            pw.flush();
            conn.close();
            prep.close();
            prep2.close();
			//String query = "SELECT (customerID,  FROM shops WHERE email=\""+emailParam+"\""
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ConnectionFactory.closeConnection();
		}

	}


}
