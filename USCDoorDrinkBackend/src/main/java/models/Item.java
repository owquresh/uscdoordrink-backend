package models;

public class Item {
	private int itemID;
	private String itemName;
	private int type;
	public Item(int itemID, String itemName, int type, double caffiene, double cost, double discount) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.type = type;
		this.caffiene = caffiene;
		this.cost = cost;
		this.discount = discount;
	}
	private double caffiene;
	private double cost;
	private double discount;
	
	
}
