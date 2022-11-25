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
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.MyEnquiryAndQuotesPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class EnquiryAndQuotesPageTest extends TestBase {
	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;
	public static EnquiryPage enquiryPage;
	public static MyEnquiryAndQuotesPage myEnquiryAndQuotesPage;

	public EnquiryAndQuotesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test 
	public void validateEnquiryAndQuotesPageTitle() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		myEnquiryAndQuotesPage = dashboardPage.clickMyQuotesAndEnquiry();
		String pageTitle = myEnquiryAndQuotesPage.getMyEnquiryAndQuotesPageTitle();
		try {
			Assert.assertEquals(pageTitle, "Enquiries and Quotes | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "EnquiryData",enabled = false)
	public void submitNewEnquiryFromDashboard(String user, String firstName, String lastName, String emailId, String phoneNumber, String refNumber, String apartmentType, String destination, String guestNumber,
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
		enquiryPage.inputCheckInDate("10");
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

	@Test (dependsOnMethods = { "submitNewEnquiryFromDashboard" },enabled = false)
	public void validateSubmittedQuotes(String user, String firstName, String lastName, String emailId, String phoneNumber, String refNumber, String apartmentType, String destination, String guestNumber,
			String guestOne, String apartmentCount, String budget, String currency) {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		myEnquiryAndQuotesPage = dashboardPage.clickMyQuotesAndEnquiry();

		String destinationPlace = myEnquiryAndQuotesPage.getDestination();
		String checkInDate = myEnquiryAndQuotesPage.getCheckInDate();
		String checkOutDate = myEnquiryAndQuotesPage.getCheckOutDate();
		String apartmentTypes = myEnquiryAndQuotesPage.getApartmenttype();
		String nightlyBudget = myEnquiryAndQuotesPage.getNightlyBudget();
		String leadGuestName = myEnquiryAndQuotesPage.getLeadGuestName();

		try {
			Assert.assertEquals(destinationPlace, destination);
			Assert.assertEquals(checkInDate, "");
			Assert.assertEquals(checkOutDate, "");
			Assert.assertEquals(apartmentTypes, apartmentType);
			Assert.assertEquals(nightlyBudget, "");
			Assert.assertEquals(leadGuestName, "");		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "EnquiryData")
	public Object[][] enquiryData(){
		return new Object[][] {
			{"Mrs","Test","Test", "Apple_Test123@silverdoor.com", "9951145525", "5789", "2 Bedroom","United Kingdom - London","4", "test","2","12", "AUD Australia Dollars"}
		};
	}


	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
