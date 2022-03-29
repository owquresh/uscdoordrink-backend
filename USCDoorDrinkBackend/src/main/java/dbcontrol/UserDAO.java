package dbcontrol;

public interface UserDAO {
	
	
	public boolean delete();
	public <T> boolean find(T t);
	public boolean update();
	boolean insert(String type, String email, String name, String password, String addresss, String state, String lat,
			String lng, String city, String postal);
	public boolean find(String email, String password, String type);
	

}
