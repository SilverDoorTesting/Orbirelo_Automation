package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.MyProfilePage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class MyProfilePageTest extends TestBase {

	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public MyProfilePage profilePage;

	public static String PAGE_TITLE = "Edit Profile | Orbi";
	public static String SUCCESS_MSG = "User edited successfully";

	public MyProfilePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void ValidatePageTitle() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		String pageTitle = profilePage.getProfilePageTitle();
		try {
			Assert.assertEquals(pageTitle, PAGE_TITLE);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test
	public void editPersonalDetails() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.selectUserTitle("Mrs");
		profilePage.inputFirstName("firstName");
		profilePage.inputLastName("lastName");
		profilePage.inputLastName("jobTitle");
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void editAddressDetails() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.inputAddress("hyd");
		profilePage.inputCity("hyd");
		profilePage.selectCountry("India");
		profilePage.inputPostCode("123456");
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void editAddressDetailsUsingAddressSearch() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.addressSearch("522006");
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(enabled = false)
	public void updateUserPassword() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.clickCreateNewPassword();
		profilePage.inputOldPassword();
		String usrpassword = "EshuMeka@007";
		profilePage.inputNewPassword(usrpassword);
		profilePage.inputConfirmPassword(usrpassword);
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
			propConfig.setProperty("password", usrpassword );
			propConfig.save();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void editContactMethodDetails() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.inputPhoneNumber("9951145525");
		profilePage.inputNotificationEmail("Apple_Test123@silverdoor.com");
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void editSettingDetails() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.inputOffice("office");	
		profilePage.selectDepartment("None");
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void editSecurity() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.selectSecurityRadioButton("phoneCall");
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void editMarketingDetails() {
		profilePage = loginPage.getDashboardPage().clickMyProfile();
		profilePage.selectMarketingCheckBox();
		profilePage.clickSaveProfileBtn();
		String successMsg = profilePage.getValidationMsg();
		try {
			Assert.assertEquals(successMsg, SUCCESS_MSG);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();;
	}
}
