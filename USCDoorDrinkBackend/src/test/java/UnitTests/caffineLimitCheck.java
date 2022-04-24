package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dbcontrol.CaffineCheckerDAO;

public class caffineLimitCheck {

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
	public void testCorrectCustomerID1_returnsTrue() {
		assertEquals(1, CaffineCheckerDAO.findCustomerID("c1@gmail.com"));
	}
	
	@Test
	public void testCorrectCustomerID2_returnsTrue() {
		assertEquals(2, CaffineCheckerDAO.findCustomerID("c2@gmail.com"));
	}
	
	@Test
	public void testCorrectCustomerID3_returnsTrue() {
		assertEquals(3, CaffineCheckerDAO.findCustomerID("c3@gmail.com"));
	}
	
	@Test
	public void testCorrectCaffine1_returnsTrue() {
		assertEquals(400, CaffineCheckerDAO.findTotalCaffine("c1@gmail.com"));
	}
	
	@Test
	public void testCorrectCaffine2_returnsTrue() {
		assertEquals(200, CaffineCheckerDAO.findTotalCaffine("c2@gmail.com"));
	}
	
	@Test
	public void testCorrectCaffine3_returnsTrue() {
		assertEquals(500, CaffineCheckerDAO.findTotalCaffine("c3@gmail.com"));
	}
	
	@Test
	public void testCorrectOverCaffine1_returnsTrue() {
		assertEquals(false, CaffineCheckerDAO.overCaffineLimit("c1@gmail.com"));
	}
	
	@Test
	public void testCorrectOverCaffine2_returnsTrue() {
		assertEquals(false, CaffineCheckerDAO.overCaffineLimit("c2@gmail.com"));
	}
	
	@Test
	public void testCorrectOverCaffine3_returnsTrue() {
		assertEquals(true, CaffineCheckerDAO.overCaffineLimit("c3@gmail.com"));
	}


}
