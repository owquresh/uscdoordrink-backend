package routes;

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
import models.Shop;
import util.GsonGlobal;
import util.MapGlobal;



/**
 * Servlet implementation class Data
 */

@WebServlet(name = "Menu", urlPatterns = "/Menu")
public class Menu extends HttpServlet {


    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
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


                int shopIDNumber = Integer.parseInt(request.getParameter("shopID"));
                System.out.println("Shop ID is: " + shopIDNumber);
                String query = "SELECT itemID, shopID, item, description, caffine, price FROM shopitems WHERE shopID=\""+shopIDNumber+"\"";

                // create the java statement
                PreparedStatement st = conn.prepareStatement(query);
                //st.setString(1, request.getParameter("shopID"));
                // execute the query, and get a java resultset
                ResultSet rs = st.executeQuery(query);
                ArrayList<Item> items  = new ArrayList<Item>();
                // iterate through the java resultset
                while (rs.next())
                {
                    int itemId = rs.getInt("itemID");
                    int shopId = rs.getInt("shopID");
                    String item = rs.getString("item");
                    String description = rs.getString("description");
                    double caffineAmount = rs.getDouble("caffine");
                    double price = rs.getDouble("price");

                    Item curr = new Item(shopId, item, description, caffineAmount, price, 0);
                    items.add(curr);

                    //print the results
                    System.out.println(shopId + " " + item + " "+ description + " " + caffineAmount + " " + price);
                    System.out.println("");

                }
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter pw = response.getWriter();
                pw.print(GsonGlobal.getInstance().toJson(items));
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
