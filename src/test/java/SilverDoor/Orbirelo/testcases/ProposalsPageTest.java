package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.ProposalsPage;

public class ProposalsPageTest extends TestBase {

	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public EnquiryPage enquiryPage;
	public ProposalsPage proposalsPage;

	public ProposalsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 0)
	public void ValidatePageTitle() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		proposalsPage = dashboardPage.clickProposal();
		String pageTitle = proposalsPage.getProposalsPageTitle();
		try {
			Assert.assertEquals(pageTitle,"Proposals | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 	
	
	@Test(priority = 1)
	public void searchProposalsByLeadGuestName() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		proposalsPage = dashboardPage.clickProposal();
		String guestName = proposalsPage.getDisplayLeadGuestName();
		proposalsPage.inputLeadGuestName(guestName);
		proposalsPage.clickSearchBtn();
		Boolean searchResult = proposalsPage.getDisplayLeadGuestNameList(guestName);
		try {
			Assert.assertTrue(searchResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void searchProposalsByDates() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		proposalsPage = dashboardPage.clickProposal();
		String apartmentChoice = proposalsPage.getDisplayApartmentChoice();
		String checkInDate = proposalsPage.getDisplayCheckInDate(apartmentChoice);
		String checkOutDate = proposalsPage.getDisplayCheckOutDate(apartmentChoice);
		proposalsPage.inputCheckInDate(checkInDate);
		proposalsPage.inputCheckOutDate(checkOutDate);
		proposalsPage.clickSearchBtn();
		Boolean checkInDateSearchResult = proposalsPage.getDisplayCheckInDateList(checkInDate);
		Boolean checkOutDateSearchResult = proposalsPage.getDisplayCheckOutDateList(checkOutDate);
		try {
			Assert.assertTrue(checkInDateSearchResult);
			Assert.assertTrue(checkOutDateSearchResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
	public void searchProposalsByCheckInDate() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		proposalsPage = dashboardPage.clickProposal();
		String apartmentChoice = proposalsPage.getDisplayApartmentChoice();
		String checkInDate = proposalsPage.getDisplayCheckInDate(apartmentChoice);
		proposalsPage.inputCheckInDate(checkInDate);
		proposalsPage.clickSearchBtn();
		Boolean checkInDateSearchResult = proposalsPage.getDisplayCheckInDateList(checkInDate);
		try {
			Assert.assertTrue(checkInDateSearchResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4)
	public void searchProposalsByCheckOutDate() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		proposalsPage = dashboardPage.clickProposal();
		String apartmentChoice = proposalsPage.getDisplayApartmentChoice();
		String checkOutDate = proposalsPage.getDisplayCheckOutDate(apartmentChoice);
		proposalsPage.inputCheckOutDate(checkOutDate);
		proposalsPage.clickSearchBtn();
		Boolean checkOutDateSearchResult = proposalsPage.getDisplayCheckOutDateList(checkOutDate);
		try {
			Assert.assertTrue(checkOutDateSearchResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5)
	public void clickViewBtn() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		proposalsPage = dashboardPage.clickProposal();
		String apartmentChoice = proposalsPage.getDisplayApartmentChoice();
		String checkIn = proposalsPage.getDisplayCheckInDate(apartmentChoice);
		String checkOut = proposalsPage.getDisplayCheckOutDate(apartmentChoice);
		proposalsPage.clickViewBtn(apartmentChoice);
		Boolean viewApartmentName = proposalsPage.getViewApartmentName(apartmentChoice);
		String viewCheckIn = proposalsPage.getViewCheckInDate();
		String viewCheckOut = proposalsPage.getViewCheckOutDate();
		try {
			Assert.assertTrue(viewApartmentName);
			Assert.assertEquals(checkIn, viewCheckIn);
			Assert.assertEquals(checkOut, viewCheckOut);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6)
	public void enquireProposalProperty() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		proposalsPage = dashboardPage.clickProposal();
		enquiryPage = proposalsPage.clickEnquiryNowBtn();
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
	
	@AfterMethod
	public void afterMethod() {
		driver.close();;
	}
}
