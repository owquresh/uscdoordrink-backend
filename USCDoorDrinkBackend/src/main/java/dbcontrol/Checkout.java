package dbcontrol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checkout implements UserDAO{
    public boolean find(String itemName, Double price, String type) {
        ResultSet rs = null;
        Connection conn = ConnectionFactory.initializeConnection();
        try {
            PreparedStatement prep = null;
            if(type.equals("customers")) {
                prep = conn.prepareStatement("SELECT itemName, password FROM customers");
                prep.setString(1,itemName);
                rs = prep.executeQuery();
            }
            while(rs.next()) {
                System.out.println(rs.getString("itemName")+rs.getString("password"));
//                if(rs.getString("email").equals(email) && rs.getString("password").equals(password)) {
//                    return true;
//                }
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
    public boolean delete() {
        return false;
    }

    @Override
    public <T> boolean find(T t) {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean insert(String type, String email, String name, String password, String addresss, String state, String lat, String lng, String city, String postal) {
        return false;
    }

    @Override
    public boolean find(String email, String password, String type) {
        return false;
    }
}
