package dbcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.maps.model.LatLng;

public class CustomerMapDAO implements UserDAO{

	
	
	public static final String URL = "jdbc:mysql://localhost:3306/uscdoordrink";
	public static final String USER = "sammy";
	public static final String PASS = "root";
	
	
	private String insertion = "INSERT INTO customers(?,?,?,?,?,?)";
	private String searchMap = "SELECT id, (3959 *acos(cos(radians(37))*cos(radians(lat))*cos(radians(lng)-radians(?))+sin(radians(?))*sin(radians(lat )))) AS distance FROM shops HAVING distance < 15 ORDER BY distance LIMIT 0, 20";
	privaate String findShop = SELECT 
	
	
	public boolean insert() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update() {
		return false;
		// TODO Auto-generated method stub
		
	}

	
	public List<Integer> search(LatLng coord) {
		// TODO Auto-generated method stub
		List<Integer> idList = new ArrayList<Integer>();
		Connection conn = ConnectionFactory.initializeConnection();
		try {
			PreparedStatement prep = conn.prepareStatement(searchMap);
			prep.setString(1, String.valueOf(coord.lng));
			prep.setString(2, String.valueOf(coord.lat));
			ResultSet resObj = prep.executeQuery();
			while(resObj.next()) {
				
				idList.add(Integer.parseInt(resObj.getString("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return idList;
	}

	@Override
	public boolean find() {
		// TODO Auto-generated method stub
		
		
		return false;
	}

}
