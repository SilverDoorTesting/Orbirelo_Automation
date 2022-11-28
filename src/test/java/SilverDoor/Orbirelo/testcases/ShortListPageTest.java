package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.BookingPage;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.ShortListPage;

public class ShortListPageTest extends TestBase{
	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;
	public static BookingPage bookingPage;
	public static ShortListPage shortListPage;
	public static EnquiryPage enquiryPage;

	public ShortListPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyShortListPageTitle() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		shortListPage = dashboardPage.clickShortList();
		String pageTitle = shortListPage.getShortListPageTitle();
		try {
			Assert.assertEquals(pageTitle,"Shortlist | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyReservationShortList() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		String propertyName = "Winckley Road House";
		bookingPage.clickShortListBtn(propertyName);
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		shortListPage = dashboardPage.clickShortList();
		String shortListAvailable = shortListPage.getPageHeader();
		boolean propertyShortListed = shortListPage.getPropertyShortListStatus(propertyName);	
		try {
			Assert.assertEquals(shortListAvailable, "You have 1 property in your shortlist");
			Assert.assertTrue(propertyShortListed,"Property not shortListed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createEnquiryForShortLists() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		String propertyName = "Winckley Road House";
		bookingPage.clickShortListBtn(propertyName);
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		shortListPage = dashboardPage.clickShortList();
		enquiryPage = shortListPage.clickEnquiryNowBtn(propertyName);
		enquiryPage.inputRmcReferenceNumber("54535");
		enquiryPage.selectApartmentType("2 Bedroom");
		enquiryPage.inputGuestNames("AutomationTesting");
		enquiryPage.selectTotalApartments("3");
		enquiryPage.inputBudget("100");
		enquiryPage.clickSubmitButton();
		String successMsg = enquiryPage.getThankYouMsg();
		try {
			Assert.assertEquals(successMsg, "THANK YOU FOR YOUR ENQUIRY");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createEnquiryforAllShortLists() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		String propertyName = "Winckley Road House";
		bookingPage.clickShortListBtn(propertyName);
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		shortListPage = dashboardPage.clickShortList();
		enquiryPage = shortListPage.clickSubmitEnquiryForAllPropertiesBtn();
		enquiryPage.inputRmcReferenceNumber("54535");
		enquiryPage.selectApartmentType("2 Bedroom");
		enquiryPage.inputGuestNames("AutomationTesting");
		enquiryPage.selectTotalApartments("3");
		enquiryPage.inputBudget("100");
		enquiryPage.clickSubmitButton();
		String successMsg = enquiryPage.getThankYouMsg();
		try {
			Assert.assertEquals(successMsg, "THANK YOU FOR YOUR ENQUIRY");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validateShortListRemoval() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		String propertyName = "Winckley Road House";
		bookingPage.clickShortListBtn(propertyName);
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		shortListPage = dashboardPage.clickShortList();
		shortListPage.clickRemoveShortListBtn();
		boolean propertyShortListed = shortListPage.getPropertyShortListStatus(propertyName);
		try {
			Assert.assertFalse(propertyShortListed,"Property not removed from shortlist page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
