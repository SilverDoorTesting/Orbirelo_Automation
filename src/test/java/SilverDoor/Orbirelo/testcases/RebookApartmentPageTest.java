package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.RebookApartmentPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationConfirmationPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationFormPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationsPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.ProposalsPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class RebookApartmentPageTest extends TestBase{

	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public EnquiryPage enquiryPage;
	public ProposalsPage proposalsPage;
	public ReservationsPage reservationsPage;
	public RebookApartmentPage rebookApartmentPage;
	public ReservationFormPage reservationFormPage;
	public ReservationConfirmationPage reservationConfirmationPage;
	
	public RebookApartmentPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void clickBackToSearchResults() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		dashboardPage = rebookApartmentPage.clickBackToSearchResults();
		String pageTitle = dashboardPage.getDashboardTitle();
		try {
			Assert.assertEquals(pageTitle,"Dashboard | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void clickMakeAnEnquiryBtn() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		enquiryPage = rebookApartmentPage.clickMakeAnEnquiry();
		String pageTitle = enquiryPage.getEnquiryPageTitle();
		try {
			Assert.assertEquals(pageTitle,"Enquiry | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void clickGenerateProposal() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		proposalsPage = rebookApartmentPage.clickGenerateProposal();
		String pageTitle = proposalsPage.getProposalsPageTitle();
		try {
			Assert.assertEquals(pageTitle,"Create Proposals | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void clickMakeAnEnquiryAfterUpdateResults() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		rebookApartmentPage.inputCheckInDate("18");
		rebookApartmentPage.inputCheckOutDate("20");
		rebookApartmentPage.selectGuestCount("2");
		rebookApartmentPage.clickUpdateResultsBtn();
		enquiryPage = rebookApartmentPage.clickMakeAnEnquiry();
		String pageTitle = enquiryPage.getEnquiryPageTitle();
		try {
			Assert.assertEquals(pageTitle,"Enquiry | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ClickAddedToProposal() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		rebookApartmentPage.inputCheckInDate("18");
		rebookApartmentPage.inputCheckOutDate("20");
		rebookApartmentPage.selectGuestCount("2");
		rebookApartmentPage.clickUpdateResultsBtn();
		String addProposalMsg = rebookApartmentPage.clickAddToProposalBtn();
		try {
			Assert.assertEquals(addProposalMsg,"The property has been added to your proposal.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ClickInstantBookBtn() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		rebookApartmentPage.inputCheckInDate("18");
		rebookApartmentPage.inputCheckOutDate("20");
		rebookApartmentPage.selectGuestCount("2");
		rebookApartmentPage.clickUpdateResultsBtn();
		rebookApartmentPage.selectPlan("Orbi Rate");
		reservationFormPage = rebookApartmentPage.clickInstantBookBtn();
		String pageHeader = reservationFormPage.getPageHeader();
		try {
			Assert.assertEquals(pageHeader,"RESERVATION FORM");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Test
	public void rebookApartmentWithBillBack() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		rebookApartmentPage.inputCheckInDate("18");
		rebookApartmentPage.inputCheckOutDate("20");
		rebookApartmentPage.selectGuestCount("2");
		rebookApartmentPage.clickUpdateResultsBtn();
		rebookApartmentPage.selectPlan("Orbi Rate");
		reservationFormPage = rebookApartmentPage.clickInstantBookBtn();
		reservationFormPage.clickBookingTermsAgreementCheckBox();
		reservationFormPage.clickBookNowWithBillBackBtn();
		reservationConfirmationPage = reservationFormPage.clickBillBookConfirmBtn();
		String succesMsg = reservationConfirmationPage.getSuccessMsg();
		try {
			Assert.assertEquals(succesMsg,"Reservation created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void navigateToReservationPageAfterRebookApartment() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		rebookApartmentPage.inputCheckInDate("18");
		rebookApartmentPage.inputCheckOutDate("20");
		rebookApartmentPage.selectGuestCount("2");
		rebookApartmentPage.clickUpdateResultsBtn();
		rebookApartmentPage.selectPlan("Orbi Rate");
		reservationFormPage = rebookApartmentPage.clickInstantBookBtn();
		reservationFormPage.clickBookingTermsAgreementCheckBox();
		reservationFormPage.clickBookNowWithBillBackBtn();
		reservationConfirmationPage = reservationFormPage.clickBillBookConfirmBtn();
		reservationsPage = reservationConfirmationPage.clickBackToReservationsBtn();
		String pageTitle = reservationsPage.getReservationsPageTitle();
		try {
			Assert.assertEquals(pageTitle,"Reservations | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void downloadConfirmationAfterReBookingApartment() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		rebookApartmentPage.inputCheckInDate("18");
		rebookApartmentPage.inputCheckOutDate("20");
		rebookApartmentPage.selectGuestCount("2");
		rebookApartmentPage.clickUpdateResultsBtn();
		rebookApartmentPage.selectPlan("Orbi Rate");
		reservationFormPage = rebookApartmentPage.clickInstantBookBtn();
		reservationFormPage.clickBookingTermsAgreementCheckBox();
		reservationFormPage.clickBookNowWithBillBackBtn();
		reservationConfirmationPage = reservationFormPage.clickBillBookConfirmBtn();
		reservationConfirmationPage.clickDownloadConfirmationBtn();
		Boolean fileDownloaded = reservationConfirmationPage.fileDownloaded();
		try {
			Assert.assertTrue(fileDownloaded);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
