package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegisterDAO implements UserDAO{

	
	public static final String URL = "jdbc:mysql://localhost:8082/uscdoordrink";
	public static final String USER = "root";
	public static final String PASS = "root";
	public static final String addUserCustomers = "INSERT INTO customers (email,name,password,address,state,lat,lng,city,postal) VALUES(?,?,?,?,?,?,?,?,?)";
	public static final String addUserShops = "INSERT INTO shops(email,name,password,address,state,lat,lng,city,postal) VALUES(?,?,?,?,?,?,?,?,?)";

	
	@Override
	public boolean insert(String type, String email, String name, String password, String address, String state, String lat, String lng, String city, String postal ) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.initializeConnection();
		try {
			PreparedStatement prep = null;
			if(type.equals("customers")) {
				 prep = conn.prepareStatement(addUserCustomers);
			}else {
				prep = conn.prepareStatement(addUserShops);
			}
			
			
			prep.setString(1, email );
			prep.setString(2,  name);
			prep.setString(3, password );
			prep.setString(4, address );
			prep.setString(5, state );
			prep.setString(6, lat );
			prep.setString(7, lng );
			prep.setString(8, city );
			prep.setString(9, postal );
		
			prep.executeUpdate();
			return true;
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
		
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> boolean find(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	


}
