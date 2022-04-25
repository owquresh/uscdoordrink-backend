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

public class CustomerMapDAO {

	
	

	
	
	private String insertion = "INSERT INTO customers(?,?,?,?,?,?)";
	private String searchMap = "SELECT id,name,email,address,state,city,postal,lat,lng, (3959 *acos(cos(radians(?))*cos(radians(lat))*cos(radians(lng)-radians(?))+sin(radians(?))*sin(radians(lat )))) AS distance FROM shops HAVING distance < 5 ORDER BY distance LIMIT 0, 20";
	private String findShop = "SELECT lat,lng FROM ? WHERE email=?";
	
	
	public boolean insert() {
		return false;
		// TODO Auto-generated method stub
		
	}

	

	
	public ArrayList<Shop> search(double lat, double lng) {
		// TODO Auto-generated method stub
		ArrayList<Shop> idList = new ArrayList<Shop>();
		LatLng coord = new LatLng(lat,lng);
		Connection conn = ConnectionFactory.initializeConnection();
		try {
			PreparedStatement prep = conn.prepareStatement(searchMap);
			prep.setString(1, String.valueOf(coord.lat));
			prep.setString(2, String.valueOf(coord.lng));
			prep.setString(3, String.valueOf(coord.lat));
			ResultSet res = prep.executeQuery();
			while(res.next()) {
				
				String name = res.getString("name");
				String address = res.getString("address");
				String email = res.getString("email");
				String postal = res.getString("postal");
				String state = res.getString("state");
				String city = res.getString("city");
				int _id = res.getInt("id");
				double _lat = res.getDouble("lat");
				double _lng = res.getDouble("lng");
				
				Shop shop = new Shop(name, email, address, state, city, postal, _lat, _lng,_id);
				idList.add(shop);
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

	public Shop find(String email, String type) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.initializeConnection();
		ArrayList<Shop> lsit = new ArrayList<Shop>();
		try {
			PreparedStatement prep = conn.prepareStatement(findShop);
			prep.setString(1, type);
			prep.setString(2, email);
			ResultSet res = prep.executeQuery();
			if(res.next()) {
				String name = res.getString("name");
				String address = res.getString("address");
				String email1 = res.getString("email");
				String postal = res.getString("postal");
				String state = res.getString("state");
				String city = res.getString("city");
				int _id = res.getInt("id");
				double lat = res.getDouble("lat");
				double lng = res.getDouble("lng");
				System.out.println(name);
				Shop shop = new Shop(name, email1, address, state, city, postal, lat, lng,_id);
				return shop;
			}else {
				return null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}




	




	

	

}
