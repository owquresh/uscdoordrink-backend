package models;

import java.util.ArrayList;

public class Customer extends Client{
	public Customer(String username, String name, String password, String address, int id) {
		super(username, name, password, address, id);
		
	}
	private ArrayList<Order> orderHistory;
	private ArrayList<Item> cart;	
}
