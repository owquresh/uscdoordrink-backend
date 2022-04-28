package models;

public class Shop {

	private String name;
	private String email;
	private String pass;
	private int id;
	private String address;
	private String state;
	private String postal;
	private String city;
	private double lat;
	private double lng;
	public Shop(String name, String email, String pass, String address, String state, String city, String postal) {
		super();
		this.name = name;
		this.pass = pass;
		this.city = city;
		this.email = email;
		this.id = id;
		this.address = address;
		this.state = state;
		this.postal = postal;
		this.lat = lat;
		this.lng = lng;
	}
	
	public Shop(String name, String email, String address, String state, String city, String postal, 
			double lat, double lng, int id
			) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.state = state;
		this.city = city;
		this.postal = postal;
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		
	}
	
	public Shop(String name2, String email2, String password, String address2, String state2, String city2,
			String postal2, double lat2, double lng2, int id2) {
		// TODO Auto-generated constructor stub
		this.name = name2;
		this.email = email2;
		this.pass = password;
		this.address = address2;
		this.state = state2;
		this.city = city2;
		this.postal = postal2;
		this.lat = lat2;
		this.lng = lng2;
		this.id = id2;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {return name;}
	public String getPass() {return pass;}
	public String getCity() {return city;}
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
