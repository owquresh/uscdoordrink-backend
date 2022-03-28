package dbcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static final String URL = "jdbc:mysql://localhost:3306/uscdoordrink";
	public static final String USER = "root";
	public static final String PASS = "mypass";
	
	public static Connection initializeConnection() {
		Connection conn = null;
		try {

        	Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
		
	}
	
}
