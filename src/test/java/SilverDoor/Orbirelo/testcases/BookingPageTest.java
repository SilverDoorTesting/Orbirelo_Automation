package SilverDoor.Orbirelo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.BookingPage;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationConfirmationPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationFormPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class BookingPageTest extends TestBase{
	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;
	public static BookingPage bookingPage;
	public static ReservationFormPage reservationFormPage;
	public static ReservationConfirmationPage reservationConfirmationPage;
	public static EnquiryPage enquiryPage;

	public BookingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyBookingPageTitle() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		String pageTitle = bookingPage.getBookingPageTitle();
		try {
			Assert.assertEquals(pageTitle, "Search | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyAddToProposal() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		bookingPage.clickInstantBookTab();
		String successMsg = bookingPage.clickAddToProposalBtn("City Centre Preston");
		try {
			Assert.assertEquals(successMsg, "The property has been added to your proposal.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyAddToProposalForPropertyType() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		bookingPage.clickEnquireNowTab();
		bookingPage.clickAddToProposalBtnForMultiplePropType("Bairstow Apartment");
		bookingPage.clickRateIdOptions("2BedroomApartment");
		String successMsg = bookingPage.clickSelectBtn();
		try {
			Assert.assertEquals(successMsg, "The property has been added to your proposal.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyInstantbookOneBedRoomOrbiRate() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		bookingPage.clickInstantBookTab();
		bookingPage.selectRatePlan("Orbi Rate");
		reservationFormPage=bookingPage.clickInstantBookBtn("City Centre Preston");

		String pageTitle = reservationFormPage.getPageHeader();
		try {
			Assert.assertEquals(pageTitle, "RESERVATION FORM");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void verifyInstantbookOneBedRoomAdvancePurchaseRate() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		bookingPage.clickInstantBookTab();
		bookingPage.selectRatePlan("Advance Purchase Rate");
		reservationFormPage=bookingPage.clickInstantBookBtn("City Centre Preston");

		String pageTitle = reservationFormPage.getPageHeader();
		try {
			Assert.assertEquals(pageTitle, "RESERVATION FORM");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void reservationBooking() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");		 
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		bookingPage.clickInstantBookTab();
		bookingPage.selectRatePlan("Advance Purchase Rate");
		reservationFormPage=bookingPage.clickInstantBookBtn("City Centre Preston");
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
	public void enquireReservation() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		bookingPage.clickEnquireNowTab();
		enquiryPage = bookingPage.clickEnquiryNowBtn("Winckley Square Apartment");
		String pageTitle = enquiryPage.getEnquiryPageTitle();
		try {
			Assert.assertEquals(pageTitle,"Enquiry | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createEnquiryForReservation() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		bookingPage.clickEnquireNowTab();
		enquiryPage = bookingPage.clickEnquiryNowBtn("Winckley Square Apartment");
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
	public void createEnquiryForReservationFromAllProperties() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		enquiryPage = bookingPage.clickEnquiryNowBtn("Winckley 33 Apartment");
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
	public void verifyReservationShortList() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.inputDestination("Preston","Preston, United Kingdom");
		dashboardPage.inputCheckInDate();
		dashboardPage.inputCheckOutDate(3);
		dashboardPage.selectOccupancy("1");
		bookingPage = dashboardPage.clickSearchBtn();
		String propertyName = "Winckley Road House";
		bookingPage.clickShortListBtn(propertyName);
		Boolean status = bookingPage.getPropertyShortListStatus(propertyName);
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
