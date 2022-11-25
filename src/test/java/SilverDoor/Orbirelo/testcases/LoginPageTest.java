package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class LoginPageTest extends TestBase {
	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;

	public static String LOGIN_PAGE_TITLE = "Log In | Orbi";
	public static String DASHBOARD_PAGE_TTILE = "Dashboard | Orbi";
	public static String EMPTY_PWD_VALIDATION_MSG = "Value is required and can't be empty";
	public static String INVALID_CRED_VALIDATION_MSG = "Wrong credentials";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}


	@Test (priority = 1, enabled = true)
	public void loginPageTitleTest() {
		String loginPageTitle=loginPage.getLoginPageTitle();
		try {
			Assert.assertEquals(loginPageTitle, LOGIN_PAGE_TITLE);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

	@Test (priority = 2, enabled = false)
	public void emptyCredValidationTest() {
		loginPage.inputUserName("");
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();
		String validMsg = loginPage.getEmptyCredValidationMsg();
		try {
			Assert.assertEquals(validMsg, EMPTY_PWD_VALIDATION_MSG);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test (priority = 3, enabled = true)
	public void emptyPwdValidationTest() {
		loginPage.inputUserName(prop.getProperty("username"));
		loginPage.inputPassword("");
		loginPage.clickLoginBtn();
		String validMsg = loginPage.getEmptyPwdValidationMsg();
		try {
			Assert.assertEquals(validMsg, EMPTY_PWD_VALIDATION_MSG);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test (priority = 4, enabled = true)
	public void invalidEmailValidationTest() {
		loginPage.inputUserName("invalid@silverdoor.com");
		loginPage.inputPassword(prop.getProperty("password"));
		loginPage.clickLoginBtn();
		String validMsg = loginPage.getInvalidEmailValidationMsg();
		try {
			Assert.assertEquals(validMsg, INVALID_CRED_VALIDATION_MSG);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Test (priority = 5, enabled = true)
	public void invalidPwdValidationTest() {
		loginPage.inputUserName(prop.getProperty("username"));
		loginPage.inputPassword("invalidPassword");
		loginPage.clickLoginBtn();
		String validMsg = loginPage.getInvalidPwdValidationMsg();
		try {
			Assert.assertEquals(validMsg, INVALID_CRED_VALIDATION_MSG);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test (priority = 6, enabled = true)
	public void userLoginTest() {
		dashboardPage=loginPage.getDashboardPage(); 
		String pagetitle = dashboardPage.getDashboardTitle();
		try {
			Assert.assertEquals(pagetitle, DASHBOARD_PAGE_TTILE);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
