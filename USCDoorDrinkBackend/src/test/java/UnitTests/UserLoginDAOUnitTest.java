package UnitTests;

import static org.junit.Assert.*;

import dbcontrol.UserLoginDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dbcontrol.UserRegisterDAO;

public class UserLoginDAOUnitTest {
    private UserLoginDAO userLoginDAO = new UserLoginDAO();


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
        assertTrue(UserLoginDAO.validEmail("name@email.com"));
    }

    @Test
    public void emailValid_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(UserLoginDAO.validEmail("name@email.co.uk"));
    }
    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(UserLoginDAO.validEmail("name@email"));
    }
    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(UserLoginDAO.validEmail("name@email..com"));
    }
    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(UserLoginDAO.validEmail("@email.com"));
    }
    @Test
    public void emailInDatabaseShops_ValidAll_ReturnsTrue(){
        assertEquals(true, userLoginDAO.find("shop1@gmail.com", "123", "shops"));
    }

    @Test
    public void emailInDatabaseShops_InvalidEmail_ReturnsFalse(){
        assertEquals(false, userLoginDAO.find("shop1", "123", "shops"));
    }

    @Test
    public void emailInDatabaseShops_InvalidPassword_ReturnsFalse(){
        assertEquals(false, userLoginDAO.find("shop1@gmail.com", "1", "shops"));
    }

    @Test
    public void emailInDatabaseShops_InvalidType_ReturnsFalse(){
        assertEquals(false, userLoginDAO.find("shop1@gmail.com", "1", "customers"));
    }

    @Test
    public void emailInDatabaseCustomers_ValidAll_ReturnsTrue(){
        assertEquals(true, userLoginDAO.find("c1@gmail.com", "123", "customers"));
    }

    @Test
    public void emailInDatabaseCustomers_InvalidEmail_ReturnsFalse(){
        assertEquals(false, userLoginDAO.find("c1", "123", "customers"));
    }

    @Test
    public void emailInDatabaseCustomers_InvalidPassword_ReturnsFalse(){
        assertEquals(false, userLoginDAO.find("c1@gmail.com", "1", "customers"));
    }

    @Test
    public void emailInDatabaseCustomers_InvalidType_ReturnsFalse(){
        assertEquals(false, userLoginDAO.find("c1@gmail.com", "123", "shops"));
    }
}
