package models;

import java.util.UUID;

import com.google.maps.model.LatLng;

public abstract class Client {
	protected String username;
	protected String name;
	protected String password;
	protected  String address;
	protected LatLng location;
	protected int id;
	
	
	
	
	public Client(String username, String name, String password, String address, int id) {
	
		this.username = username;
		this.name = name;
		this.password = password;
		this.address = address;
		this.id = id;
	}
	public String getPassword() {
		return password;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}

	
}
