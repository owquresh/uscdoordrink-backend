package UnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Customer;

public class userCustomerTest {

	@Test
	public void test1() {
		Customer cust = new Customer("Omar", "omar@omar.com", "123", "925 W 30th Street", "CA", "Los Angeles","90007",30,100);
		assertEquals("925 W 30th Street Los Angeles, CA 90007", cust.getFormattedAddress());
	}

	@Test
	public void test2() {
		Customer cust = new Customer("Omar", "omar@omar.com", "123", "925 W 30th Street", "CA", "Los Angeles","90007",30,100);
		cust.setEmail("omar@123");
		assertEquals("omar@123", cust.getEmail());
	}
	
	@Test
	public void test3() {
		Customer cust = new Customer("Omar", "omar@omar.com", "123", "925 W 30th Street", "CA", "Los Angeles","90007",30,100);
		cust.setPass("pass");
		assertEquals("pass",cust.getPass());
	}
	@Test
	public void test4() {
		Customer cust = new Customer("Omar", "omar@omar.com", "123", "925 W 30th Street", "CA", "Los Angeles","90007",30,100);
		assertEquals("123",cust.getPass());
	}
	
	@Test
	public void test5() {
		Customer cust = new Customer(1,"Omar", "omar@omar.com", "123", "925 W 30th Street", "CA", "Los Angeles","90007",30,100);
		assertEquals(1,cust.getId());
	}
}
