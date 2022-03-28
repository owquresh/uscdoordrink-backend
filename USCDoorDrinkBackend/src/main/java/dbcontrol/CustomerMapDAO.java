package dbcontrol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.maps.model.LatLng;

import models.Shop;

public class CustomerMapDAO implements UserDAO{

	
	
	public static final String URL = "jdbc:mysql://localhost:3306/uscdoordrink";
	public static final String USER = "sammy";
	public static final String PASS = "root";
	
	
	private String insertion = "INSERT INTO customers(?,?,?,?,?,?)";
	private String searchMap = "SELECT id, (3959 *acos(cos(radians(?))*cos(radians(lat))*cos(radians(lng)-radians(?))+sin(radians(?))*sin(radians(lat )))) AS distance FROM shops HAVING distance < 15 ORDER BY distance LIMIT 0, 20";
	private String findShop = "SELECT * FROM shops WHERE id = ?";
	
	
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

	
	public ArrayList<Integer> search(LatLng coord) {
		// TODO Auto-generated method stub
		ArrayList<Integer> idList = new ArrayList<Integer>();
		Connection conn = ConnectionFactory.initializeConnection();
		try {
			PreparedStatement prep = conn.prepareStatement(searchMap);
			prep.setString(1, String.valueOf(coord.lat));
			prep.setString(2, String.valueOf(coord.lng));
			prep.setString(3, String.valueOf(coord.lat));
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

	public ArrayList<Shop> find(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.initializeConnection();
		ArrayList<Shop> lsit = new ArrayList<Shop>();
		try {
			PreparedStatement prep = conn.prepareStatement(findShop);
			prep.setString(1, id.toString());
			ResultSet res = prep.executeQuery();
			while(res.next()) {
				String address = res.getString("addresss");
				String email = res.getString("email");
				String postal = res.getString("postal;");
				String state = res.getString("state");
				int _id = res.getInt("id");
				double lat = res.getDouble("lat");
				double lng = res.getDouble("lng");
				
				Shop shop = new Shop(email, _id, address, state, postal, lat, lng);
				lsit.add(shop);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return lsit;
	}

	@Override
	public <T> boolean find(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
