package dbcontrol;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.maps.model.LatLng;

import dbcontrol.ConnectionFactory;
import dbcontrol.UserDAO;
import dbcontrol.UserRegisterDAO;
import models.Customer;
import models.Item;
import models.OrderData;
import models.Shop;
import util.GsonGlobal;
import util.MapGlobal;



/**
 * Servlet implementation class Data
 */

@WebServlet(name = "OrderDataDAO", urlPatterns = "/OrderDataDAO")
public class OrderDataDAO extends HttpServlet {


    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDataDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-gprintln("Request sent through")

        try
        {

            Connection conn = ConnectionFactory.initializeConnection();


            int customerID = Integer.parseInt(request.getParameter("customerID"));
            System.out.println("Shop ID is: " + customerID);
            String query = "SELECT orderID, shopID, total_caffine, orderitem FROM orders WHERE customerID=\""+customerID+"\"";
            System.out.println("HERE");

            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            //st.setString(1, request.getParameter("shopID"));
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            ArrayList<OrderData> orderDataList  = new ArrayList<OrderData>();
            // iterate through the java resultset
            while (rs.next())
            {
                int orderID = rs.getInt("orderID");
                int shopId = rs.getInt("shopID");
                double total_caffine = rs.getDouble("total_caffine");
                String orderitem = rs.getString("orderitem");


                OrderData curr = new OrderData(orderID, shopId, total_caffine, orderitem);
                orderDataList.add(curr);
                //print the results
                System.out.println("orderID"+ orderID + " " + "shopId" +shopId+ " "+ "total_caffine" +total_caffine+ " " + "orderitem" + " " + orderitem);
                System.out.println("");

            }
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print(GsonGlobal.getInstance().toJson(orderDataList));
            pw.flush();

            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        response.setStatus(200);

    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub






    }

}
