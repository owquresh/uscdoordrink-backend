package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditAddressDAO {
	
	public static final String updateUserCustomers = "UPDATE customers SET address=?, state=?, postal=?, lat=?, lng=?, city=? WHERE email=?";
	public static final String updateUserShops = "UPDATE shops SET address=?, state=?, postal=?, lat=?, lng=?, city=? WHERE email=?";
	
	public boolean update(String email, String type, String address, String state, String lat, String lng, String city, String postal ) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.initializeConnection();
		
		if(address==null || city==null || state==null
				|| postal == null || type == null || lat==null || lng == null) {
			//System.out.println("Here1");
			return false;
		}
		try {
			PreparedStatement prep = null;
			if(type.equals("customers")) {
				 prep = conn.prepareStatement(updateUserCustomers);
			}else {
				prep = conn.prepareStatement(updateUserShops);
			}
			prep.setString(1, address );
			prep.setString(2, state );
			prep.setString(3, postal );
			prep.setString(4, lat );
			prep.setString(5, lng );
			prep.setString(6, city );
			prep.setString(7, email );	
		
			prep.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionFactory.closeConnection();
			//System.out.println("Here2");
			return false;
		}
		
	}

}
