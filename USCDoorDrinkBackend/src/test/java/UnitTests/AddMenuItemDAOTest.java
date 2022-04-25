package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dbcontrol.AddMenuItemDAO;

public class AddMenuItemDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(1, dao.findShopID("shop1@gmail.com"));
	}
	
	@Test
	public void test2() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(2, dao.findShopID("shop2@gmail.com"));
	}
	
	@Test
	public void test3() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(3, dao.findShopID("shop3@gmail.com"));
	}
	
	@Test
	public void test4() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(4, dao.findShopID("shop4@gmail.com"));
	}
	
	@Test
	public void test5() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(0, dao.findShopID("shop5@gmail.com"));
	}

	@Test
	public void test6() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(true, dao.insertHelper("shop1@gmail.com", "Hot Chocolate", null, "5", "3.99", null));
	}
	
	@Test
	public void test7() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(true, dao.insertHelper("shop2@gmail.com", "Green Tea", null, "30", "5.99", "4.99"));
	}
	
	@Test
	public void test8() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(true, dao.insertHelper("shop3@gmail.com", "New Special Tea", "Best thing you will ever have", "30", "5.99", "4.99"));
	}
	
	@Test
	public void test9() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(false, dao.insertHelper("shop7@gmail.com", "New Special Tea", "Best thing you will ever have", "30", "5.99", "4.99"));
	}
	
	@Test
	public void test10() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(false, dao.insertHelper(null, "New Special Tea", "Best thing you will ever have", "30", "5.99", "4.99"));
	}
	
	@Test
	public void test11() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(false, dao.insertHelper("shop3@gmail.com", "New Special Tea", "Best thing you will ever have", null, "5.99", "4.99"));
	}
	
	@Test
	public void test12() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(false, dao.insertHelper("shop3@gmail.com", "New Special Tea", "Best thing you will ever have", "30", null, "4.99"));
	}
	
	@Test
	public void test13() {
		AddMenuItemDAO dao = new AddMenuItemDAO();
		assertEquals(false, dao.insertHelper("shop3@gmail.com", null, "Best thing you will ever have", "30", "5.99", "4.99"));
	}
}

