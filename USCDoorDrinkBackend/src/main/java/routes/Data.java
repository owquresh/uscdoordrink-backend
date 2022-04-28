package routes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcontrol.ConnectionFactory;
import models.Customer;
import models.Shop;
import util.GsonGlobal;



/**
 * Servlet implementation class Data
 */

@WebServlet(name = "Data", urlPatterns = "/Data")
public class Data extends HttpServlet {


    private static final long serialVersionUID = 1L;
    public static final String query1 = "SELECT name, email, password, address, state, postal, city,id, lat, lng FROM shops WHERE email=?";
    public static final String query2 = "SELECT name, email, password, address, state, postal, city, id, lat, lng FROM customers WHERE email=?";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Data() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-gprintln("Request sent through");

    	//System.out.println(request.getParameter("type"));

        try
        {
            // create our mysql database connection
            request.getParameter("type");
            String emailParam = request.getParameter("email");
            Connection conn = ConnectionFactory.initializeConnection();

           if(request.getParameter("type").equals("shop")){
               // our SQL SELECT query.
               // if you only need a few columns, specify them by name instead of using "*"


               

               // create the java statement
               PreparedStatement st = conn.prepareStatement(query1);
               //System.out.println(request.getParameter("email"));
               st.setString(1, emailParam);


               // execute the query, and get a java resultset
               ResultSet rs = st.executeQuery();
               ArrayList<Shop> shops  = new ArrayList<Shop>();
               // iterate through the java resultset
               while (rs.next())
               {
                   String name = rs.getString("name");
                   String email = rs.getString("email");
                   String password = rs.getString("password");
                   String address = rs.getString("address");
                   String state = rs.getString("state");
                   String postal = rs.getString("postal");
                   String city = rs.getString("city");
                   int id = Integer.parseInt(rs.getString("id"));
                   double lat = Double.valueOf(rs.getString("lat"));
                   double lng = Double.valueOf(rs.getString("lng"));
                   Shop curr = new Shop(name, email, password, address, state, city, postal,lat,lng,id);
                   shops.add(curr);


                   //System.out.println(name + " " + email+ " "+ password + " " + address + " " + state + " " + postal + " " + city);
                   //System.out.println("");
                   // print the results
                   //System.out.println(curr.getName() + curr.getEmail() + curr.getPass() + curr.getAddress() + curr.getState() + curr.getCity() + curr.getPostal());
               }
               response.setContentType("application/json");
               response.setCharacterEncoding("UTF-8");
               PrintWriter pw = response.getWriter();
               pw.print(GsonGlobal.getInstance().toJson(shops));
               pw.flush();
               conn.close();
               st.close();
           }
           else{
               

               // create the java statement
               PreparedStatement st = conn.prepareStatement(query2);
               //System.out.println(request.getParameter("email"));
               st.setString(1, emailParam);


               // execute the query, and get a java resultset
               ResultSet rs = st.executeQuery();
               ArrayList<Customer> customers  = new ArrayList<Customer>();
               // iterate through the java resultset
               while (rs.next())
               {
                   String name = rs.getString("name");
                   String email = rs.getString("email");
                   String password = rs.getString("password");
                   String address = rs.getString("address");
                   String state = rs.getString("state");
                   String postal = rs.getString("postal");
                   String city = rs.getString("city");
                   int id = Integer.parseInt(rs.getString("id"));
                   double lat = Double.valueOf(rs.getString("lat"));
                   double lng = Double.valueOf(rs.getString("lng"));
                   
                   Customer curr = new Customer(id, name, email, password, address, state, city, postal, lat, lng);
                   customers.add(curr);


                   //System.out.println(name + " " + email+ " "+ password + " " + address + " " + state + " " + postal + " " + city);
                   //System.out.println("");
                   // print the results
                   //System.out.println(curr.getName() + curr.getEmail() + curr.getPass() + curr.getAddress() + curr.getState() + curr.getCity() + curr.getPostal());
               }
               response.setContentType("application/json");
               response.setCharacterEncoding("UTF-8");
               PrintWriter pw = response.getWriter();
               pw.print(GsonGlobal.getInstance().toJson(customers));
               pw.flush();
               conn.close();
               st.close();

           }
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
