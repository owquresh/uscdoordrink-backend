package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dbcontrol.caffineChecker;

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
		assertEquals(1, caffineChecker.findCustomerID("c1@gmail.com"));
	}
	
	@Test
	public void testCorrectCustomerID2_returnsTrue() {
		assertEquals(2, caffineChecker.findCustomerID("c2@gmail.com"));
	}
	
	@Test
	public void testCorrectCustomerID3_returnsTrue() {
		assertEquals(3, caffineChecker.findCustomerID("c3@gmail.com"));
	}
	
	@Test
	public void testCorrectCaffine1_returnsTrue() {
		assertEquals(400, caffineChecker.findTotalCaffine("c1@gmail.com"));
	}
	
	@Test
	public void testCorrectCaffine2_returnsTrue() {
		assertEquals(200, caffineChecker.findTotalCaffine("c2@gmail.com"));
	}
	
	@Test
	public void testCorrectCaffine3_returnsTrue() {
		assertEquals(500, caffineChecker.findTotalCaffine("c3@gmail.com"));
	}
	
	@Test
	public void testCorrectOverCaffine1_returnsTrue() {
		assertEquals(false, caffineChecker.overCaffineLimit("c1@gmail.com"));
	}
	
	@Test
	public void testCorrectOverCaffine2_returnsTrue() {
		assertEquals(false, caffineChecker.overCaffineLimit("c2@gmail.com"));
	}
	
	@Test
	public void testCorrectOverCaffine3_returnsTrue() {
		assertEquals(true, caffineChecker.overCaffineLimit("c3@gmail.com"));
	}


}
