package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class EnquiryPageTest extends TestBase{

	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;
	public static EnquiryPage enquiryPage;

	public EnquiryPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test 
	public void validateEnquiryPageTitle() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		enquiryPage = dashboardPage.clickCreateEnquiry();
		String pageTitle = enquiryPage.getEnquiryPageTitle();
		try {
			Assert.assertEquals(pageTitle, "Enquiry | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "EnquiryData")
	public void submitNewEnquiryFromEnquiryPage(String user, String firstName, String lastName, String emailId, String phoneNumber, String refNumber, String apartmentType, String destination, String guestNumber,
			String guest1, String apartmentCount, String budget, String currency) {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		enquiryPage = dashboardPage.clickCreateEnquiry();
		enquiryPage.selectUserTitle(user);
		enquiryPage.inputFirstName(firstName);
		enquiryPage.inputLastName(lastName);
		enquiryPage.inputEmailId(emailId);
		enquiryPage.inputMobileNumber(phoneNumber);
		enquiryPage.inputRmcReferenceNumber(refNumber);
		enquiryPage.selectApartmentType(apartmentType);
		enquiryPage.inputDestination(destination);
		enquiryPage.selectNumberOfGuests(guestNumber);
		enquiryPage.inputGuestNames(guest1);
		enquiryPage.inputCheckInDate("18");
		enquiryPage.inputCheckOutDate("20");
		enquiryPage.selectTotalApartments(apartmentCount);
		enquiryPage.inputBudget(budget);
		enquiryPage.selectBudgetCurrency(currency);
		enquiryPage.selectFlexibleDateCheckBox();
		enquiryPage.clickSubmitButton();
		String successMsg = enquiryPage.getThankYouMsg();
		try {
			Assert.assertEquals(successMsg, "THANK YOU FOR YOUR ENQUIRY");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(dataProvider = "EnquiryData")
	public void submitNewEnquiryFromdashboardPage(String user, String firstName, String lastName, String emailId, String phoneNumber, String refNumber, String apartmentType, String destination, String guestNumber,
			String guestOne, String apartmentCount, String budget, String currency) {
		dashboardPage = loginPage.getDashboardPage();
		enquiryPage = dashboardPage.submitEnquiry();
		enquiryPage.selectUserTitle(user);
		enquiryPage.inputFirstName(firstName);
		enquiryPage.inputLastName(lastName);
		enquiryPage.inputEmailId(emailId);
		enquiryPage.inputMobileNumber(phoneNumber);
		enquiryPage.inputRmcReferenceNumber(refNumber);
		enquiryPage.selectApartmentType(apartmentType);
		enquiryPage.inputDestination(destination);
		enquiryPage.selectNumberOfGuests(guestNumber);
		enquiryPage.inputGuestNames(guestOne);
		enquiryPage.inputCheckInDate("6");
		enquiryPage.inputCheckOutDate("7");
		enquiryPage.selectTotalApartments(apartmentCount);
		enquiryPage.inputBudget(budget);
		enquiryPage.selectBudgetCurrency(currency);
		enquiryPage.selectFlexibleDateCheckBox();
		enquiryPage.clickSubmitButton();
		String successMsg = enquiryPage.getThankYouMsg();
		try {
			Assert.assertEquals(successMsg, "THANK YOU FOR YOUR ENQUIRY");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@DataProvider(name = "EnquiryData")
	public Object[][] enquiryData(){
		return new Object[][] {
			{"Mrs","Test","Test", "Apple_Test123@silverdoor.com", "9951145525", "4342", "2 Bedroom","United Kingdom - London","4", "test","2","12", "AUD Australia Dollars"},
			{"Mr","Eshu","Test","Apple_Test123@silverdoor.com", "9951145525","54535","1 Bedroom","United States - Florida","2","test","1","12","AUD Australia Dollars"}
		};
	}


	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}



    
     
