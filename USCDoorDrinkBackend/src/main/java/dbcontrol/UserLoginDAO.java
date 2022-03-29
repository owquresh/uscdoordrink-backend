package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDAO implements UserDAO {


	//SELECT email, password FROM uscdoordrink.shops WHERE email="shop1@gmail"
	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean find(String email, String password, String type) {
		ResultSet rs;
		Connection conn = ConnectionFactory.initializeConnection();
		try {
			PreparedStatement prep = null;
			if(type.equals("customers")) {
				 prep = conn.prepareStatement("SELECT email, password FROM customers WHERE email=?");
				 prep.setString(1,email);
				 rs = prep.executeQuery();
			}else {
				prep = conn.prepareStatement("SELECT email, password FROM shops WHERE email=?");
				prep.setString(1,email);
				rs = prep.executeQuery();
			}
			while(rs.next()) {
				System.out.println(rs.getString("email")+rs.getString("password"));
				if(rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
					return true;
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
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
	public boolean insert(String type, String email, String name, String password, String addresss, String state,
			String lat, String lng, String city, String postal) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
