package models;

public class Shop {

	private String email;
	private String password;
	private int id;
	private String address;
	private String state;
	private String postal;
	private double lat;
	private double lng;
	public Shop(String email, String password, int id, String address, String state, String postal, double lat,
			double lng) {
		super();
		this.email = email;
		this.password = password;
		this.id = id;
		this.address = address;
		this.state = state;
		this.postal = postal;
		this.lat = lat;
		this.lng = lng;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
	
	
}
