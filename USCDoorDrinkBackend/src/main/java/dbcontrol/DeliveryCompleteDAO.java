package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliveryCompleteDAO {
	
	public static final String markDelivery = "UPDATE orders SET deliveredTime=CURRENT_TIMESTAMP WHERE orderID=?";
	
	public boolean deliveryComplete(int orderID) {
		Connection conn = ConnectionFactory.initializeConnection();
		
		try {
			PreparedStatement prep = null;
			prep = conn.prepareStatement(markDelivery);
			prep.setInt(1, orderID);	
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
