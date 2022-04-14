package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dbcontrol.UserRegisterDAO;

public class UserRegisterDAOUnitTest {

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
	public void emailValid_CorrectEmail_ReturnsTrue() {
	    assertTrue(UserRegisterDAO.validEmail("name@email.com"));
	}
	
	@Test
	public void emailValid_CorrectEmailSubDomain_ReturnsTrue() {
	    assertTrue(UserRegisterDAO.validEmail("name@email.co.uk"));
	}
	@Test
	public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
	    assertFalse(UserRegisterDAO.validEmail("name@email"));
	}
	@Test
	public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
	    assertFalse(UserRegisterDAO.validEmail("name@email..com"));
	}
	@Test
	public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
	    assertFalse(UserRegisterDAO.validEmail("@email.com"));
	}

}
