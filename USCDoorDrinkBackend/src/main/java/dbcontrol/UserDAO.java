package dbcontrol;

public interface UserDAO {
	
	public boolean insert();
	public boolean delete();
	public <T> boolean find(T t);
	public boolean update();

}
