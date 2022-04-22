package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class caffineChecker {
	
	public static boolean overCaffineLimit(String email) {
		int todayCaffine = findTotalCaffine(email);
		int limit = 400;
		
		if(todayCaffine > limit) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int findTotalCaffine(String email) {
		int sum = 0;
		int customerID = findCustomerID(email);
		
		ResultSet rs;
		Connection conn = ConnectionFactory.initializeConnection();
		try {
			PreparedStatement prep = null;
			prep = conn.prepareStatement("SELECT total_caffeiene FROM orders WHERE customerID=? AND orderTime >= now() - INTERVAL 1 DAY;");
			prep.setInt(1,customerID);
			rs = prep.executeQuery();
			while(rs.next()) {
				sum += rs.getInt("total_caffeiene");
			}
			return sum;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public static int findCustomerID(String email) {
		ResultSet rs;
		Connection conn = ConnectionFactory.initializeConnection();
		try {
			PreparedStatement prep = null;
			prep = conn.prepareStatement("SELECT id FROM customers WHERE email=?");
			prep.setString(1,email);
			rs = prep.executeQuery();
			if(rs.next()) {
				return rs.getInt("id");
			} else {
				return 0;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
