package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserRegisterDAO implements UserDAO{

	
	
	public static final String addUserCustomers = "INSERT INTO customers (email,name,password,address,state,lat,lng,city,postal) VALUES(?,?,?,?,?,?,?,?,?)";
	public static final String addUserShops = "INSERT INTO shops(email,name,password,address,state,lat,lng,city,postal) VALUES(?,?,?,?,?,?,?,?,?)";

	
	public boolean insert(String type, String email, String name, String password, String address, String state, String lat, String lng, String city, String postal ) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionFactory.initializeConnection();
		
		if(name == null|| !validEmail(email) || password==null|| address==null || city==null || state==null
				|| postal == null || type == null || lat==null || lng == null) {
			//System.out.println("Here1");
			return false;
		}
	
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
			ConnectionFactory.closeConnection();
			//System.out.println("Here2");
			return false;
			
		}
	
		
		
		
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

	@Override
	public boolean find(String email, String password, String type) {
		return false;
		// TODO Auto-generated method stub
		
	}
	
	public static boolean validEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		if (email == null) return false;
		return pattern.matcher(email).matches();
	}

}
