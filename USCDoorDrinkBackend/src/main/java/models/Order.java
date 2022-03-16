package models;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Order {
	private int orderNumber;
	private String customerName;
	private int customerId;
	private String shopName;
	private int shopdId;
	private ArrayList<Item> itemList;
	
	
	//Variables related to delivery time
	private boolean completed;
	private DateTime estDelivery;
	private DateTime orderTime;
	private DateTime completedTime;
	private Interval interval;
}
