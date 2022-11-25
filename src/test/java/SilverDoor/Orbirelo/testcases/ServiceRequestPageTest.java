package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.IssueResolutionCentrePage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationsPage;
import SilverDoor.Orbirelo.qa.pageobjects.ServiceRequestPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.MyEnquiryAndQuotesPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class ServiceRequestPageTest extends TestBase{
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public ReservationsPage reservationsPage;
	public MyEnquiryAndQuotesPage myEnquiryAndQuotesPage;
	public ServiceRequestPage serviceRequestPage;
	public IssueResolutionCentrePage issueResolutionCentrePage;

	public ServiceRequestPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}


	@Test(priority = 0, dataProvider = "reservationNumber")
	public void getServiceRequestPage(String number) {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		reservationsPage.inputReservationNumber(number);
		reservationsPage.clickSearchBtn();
		serviceRequestPage = reservationsPage.clickRaiseServiceRequestBtn();
		String pageTitle = serviceRequestPage.getServiceRequestPageTitle();
		try {
			Assert.assertEquals(pageTitle, "Service Request | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1, dataProvider = "reservationNumber")
	public void validateBackToServiceRequests(String number) {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		reservationsPage.inputReservationNumber(number);
		reservationsPage.clickSearchBtn();
		serviceRequestPage = reservationsPage.clickRaiseServiceRequestBtn();
		issueResolutionCentrePage = serviceRequestPage.clickBackToServiceRequestBtn();
		String pageTitle = issueResolutionCentrePage.getIssueResolutionCentrePageTitle();
		try {
			Assert.assertEquals(pageTitle, "Issue Resolution Centre | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2, dataProvider = "reservationNumber")
	public void submitServiceRequestUsingReservationID(String number) {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		reservationsPage.inputReservationNumber(number);
		reservationsPage.clickSearchBtn();
		serviceRequestPage = reservationsPage.clickRaiseServiceRequestBtn();
		serviceRequestPage.inputSubject("Testing");
		serviceRequestPage.inputDescription("Testing with Reservation Number");
		serviceRequestPage.selectRequestClassification("Booking");
		serviceRequestPage.selectServiceRequestReason("Check-in/out");
		serviceRequestPage.selectServiceRequestReason("Low");
		issueResolutionCentrePage = serviceRequestPage.clickSendRequestBtn();
		String successMsg = issueResolutionCentrePage.getSuccessMsg();
		try {
			Assert.assertEquals(successMsg, "Service request successfully created.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2, dataProvider = "enquiyID")
	public void submitServiceRequestUsingEnquiryID(String number) {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		dashboardPage.clickEnquiryAndQuotes();
		myEnquiryAndQuotesPage = dashboardPage.clickMyQuotesAndEnquiry();
		serviceRequestPage = myEnquiryAndQuotesPage.clickRaiseServiceRequestBtn(number);
		serviceRequestPage.inputSubject("Testing");
		serviceRequestPage.inputDescription("Testing with Reservation Number");
		serviceRequestPage.selectRequestClassification("Booking");
		serviceRequestPage.selectServiceRequestReason("Check-in/out");
		serviceRequestPage.selectServiceRequestReason("Low");
		issueResolutionCentrePage = serviceRequestPage.clickSendRequestBtn();
		String successMsg = issueResolutionCentrePage.getSuccessMsg();
		try {
			Assert.assertEquals(successMsg, "Service request successfully created.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "reservationNumber")
	public Object[][] reservationNumber(){
		return new Object[][] {
			{"RES-220004411"}
		};
	}
	
	@DataProvider(name = "enquiyID")
	public Object[][] enquiyID(){
		return new Object[][] {
			{"E-189369"}
		};
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
