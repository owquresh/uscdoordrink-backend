package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMenuItemDAO {
	
	public static final String qFindShopID = "SELECT id FROM shops WHERE email=?";
	public static final String addItem1 = "INSERT INTO shopitems (shopID, item, description, caffine, price, discountPrice) VALUES(?,?,?,?,?,?)";
	public static final String addItem2 = "INSERT INTO shopitems (shopID, item, caffine, price, discountPrice) VALUES(?,?,?,?,?)";
	public static final String addItem3 = "INSERT INTO shopitems (shopID, item, description, caffine, price) VALUES(?,?,?,?,?)";
	public static final String addItem4 = "INSERT INTO shopitems (shopID, item, caffine, price) VALUES(?,?,?,?)";
	
	public boolean insertHelper(String email, String itemName, String description, String caffine, String price, String discountprice) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.initializeConnection();
		
		if(email == null|| itemName==null|| caffine==null || price==null) {
			//System.out.println("Here1");
			return false;
		}
		
		int shopID = findShopID(email);
		
		if(shopID == 0) {
			return false;
		}
		
		int caf = Integer.parseInt(caffine);
		double p = Double.parseDouble(price);
		
		try {
			PreparedStatement prep = null;
			
			if(discountprice == "" && description == "") {
				prep = conn.prepareStatement(addItem4);
				prep.setInt(1, shopID);
				prep.setString(2,itemName);
				prep.setInt(3, caf);
				prep.setDouble(4, p);
			} else if (discountprice == "") {
				prep = conn.prepareStatement(addItem3);
				prep.setInt(1, shopID);
				prep.setString(2,itemName);
				prep.setString(3, description);
				prep.setInt(4, caf);
				prep.setDouble(5, p);
				
			} else if (description == "") {
				prep = conn.prepareStatement(addItem2);
				double discountp = Double.parseDouble(discountprice);
				prep.setInt(1, shopID);
				prep.setString(2,itemName);
				prep.setInt(3, caf);
				prep.setDouble(4, p);
				prep.setDouble(5, discountp);
				
			}else {
				prep = conn.prepareStatement(addItem1);
				double discountp = Double.parseDouble(discountprice);
				prep.setInt(1, shopID);
				prep.setString(2,itemName);
				prep.setString(3, description);
				prep.setInt(4, caf);
				prep.setDouble(5, p);
				prep.setDouble(6, discountp);
			}
			
			prep.executeUpdate();
			return true;

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionFactory.closeConnection();
			return false;
			
		}
		
	}
	
	public int findShopID(String email) {
		ResultSet rs;
		Connection conn = ConnectionFactory.initializeConnection();
		
		try {
			PreparedStatement prep = null;
			prep = conn.prepareStatement(qFindShopID);
			
			prep.setString(1, email);

			rs = prep.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ConnectionFactory.closeConnection();
			//System.out.println("Here2");
			
		}
		return 0;
		
	}
	

}
