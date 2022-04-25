package models;

public class Item {
	private int shopID;
	private String itemName;
	private String description;
	public Item(int shopID, String itemName, String description, double caffiene, double cost, double discount) {
		this.shopID = shopID;
		this.itemName = itemName;
		this.description = description;
		this.caffiene = caffiene;
		this.cost = cost;
		this.discount = discount;
	}
	private double caffiene;
	private double cost;
	private double discount;

	public double getCaffiene() {
		return caffiene;
	}

	public double getDiscount() {
		return discount;
	}

	public int getShopID() {
		return shopID;
	}

}
