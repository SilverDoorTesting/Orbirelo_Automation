package SilverDoor.Orbirelo.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.DashboardPage;
import SilverDoor.Orbirelo.qa.pageobjects.LoginPage;
import SilverDoor.Orbirelo.qa.pageobjects.RebookApartmentPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationDetailPage;
import SilverDoor.Orbirelo.qa.pageobjects.ReservationsPage;
import SilverDoor.Orbirelo.qa.pageobjects.ServiceRequestPage;
import SilverDoor.Orbirelo.qa.util.ListenerTest;

@Listeners(ListenerTest.class)
public class ReservationsPageTest extends TestBase{

	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public ReservationsPage reservationsPage;
	public RebookApartmentPage rebookApartmentPage;
	public ReservationDetailPage reservationDetailPage;
	public ServiceRequestPage serviceRequestPage;

	public ReservationsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}


	@Test (priority =0)
	public void validateReservationsPageTitle_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		String pageTitle = reservationsPage.getReservationsPageTitle();
		try {
			Assert.assertEquals(pageTitle, "Reservations | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test (priority =1)
	public void getDetailsWithReservationNumber_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		String number = "RES-220004216";
		reservationsPage.inputReservationNumber(number);
		reservationsPage.clickSearchBtn();
		String reservationNumber = reservationsPage.getReservationNumber();
		try {
			Assert.assertEquals(reservationNumber, number);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =2)
	public void getDetailsWithLeadGuestName_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		String name = "firstName jobTitle";
		reservationsPage.inputGuestName(name);
		reservationsPage.clickSearchBtn();
		List<String> guestNameList = reservationsPage.getLeadGuestNameList();
		Boolean status = false;
		for(int index = 0; index<guestNameList.size();index++) {
			if((guestNameList.get(index)).equals(name)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =3)
	public void getDetailsWithDates_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		String checkInDate = "01/06/2022";
		String checkOutDate = "08/06/2022";
		reservationsPage.inputCheckInDate(checkInDate);
		reservationsPage.inputCheckOutDate(checkOutDate);
		reservationsPage.clickSearchBtn();
		List<String> checkInDateList = reservationsPage.getCheckInDateList();
		List<String> checkOutDateList = reservationsPage.getCheckOutDateList();
		Boolean checkInDateValidation = false;
		Boolean checkOutDateValidation = false;
		for(int index = 0; index<checkInDateList.size();index++) {
			if((checkInDateList.get(index)).equals(checkInDate)) {
				checkInDateValidation = true;
			} else {
				checkInDateValidation = false;
			}
		}	
		for(int index = 0; index<checkOutDateList.size();index++) {
			if((checkOutDateList.get(index)).equals(checkOutDate)) {
				checkOutDateValidation = true;
			} else {
				checkOutDateValidation = false;
			}
		}	
		try {
			Assert.assertTrue(checkInDateValidation);
			Assert.assertTrue(checkOutDateValidation);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	@Test (priority =4,enabled = true)
	public void getDetailsWithCheckInDate_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		String date = "01/06/2022";
		reservationsPage.inputCheckInDate(date);
		reservationsPage.clickSearchBtn();
		List<String> dateList = reservationsPage.getCheckInDateList();
		Boolean status = false;
		for(int index = 0; index<dateList.size();index++) {
			if((dateList.get(index)).equals(date)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	@Test (priority =5,enabled = true)
	public void getDetailsWithCheckOutDate_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		String date = "07/05/2022";
		reservationsPage.inputCheckOutDate(date);
		reservationsPage.clickSearchBtn();
		List<String> dateList = reservationsPage.getCheckOutDateList();
		Boolean status = false;
		for(int index = 0; index<dateList.size();index++) {
			if((dateList.get(index)).equals(date)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =6)
	public void getDetailsWithLocation_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		reservationsPage.inputLocation("United Kingdom - Preston - Centre");
		reservationsPage.clickSearchBtn();
		String apartmentName = reservationsPage.getApartmentName();
		try {
			Assert.assertEquals(apartmentName, "City Centre Preston");
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =7)
	public void getDetailsWithReservationMadeByName_sideMenu() {
		dashboardPage = loginPage.getDashboardPage();
		dashboardPage.clickSideMenu();
		reservationsPage = dashboardPage.clickReservations();
		String name = "Allen & Overy LLP c/o Reed & Mackay";
		reservationsPage.inputReservationMadeBy(name);
		reservationsPage.clickSearchBtn();
		List<String> reservationMadeUserList = reservationsPage.getReservationMadeByNameList();
		Boolean status = false;
		for(int index = 0; index<reservationMadeUserList.size();index++) {
			if((reservationMadeUserList.get(index)).equals(name)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	

	@Test (priority =8)
	public void validateReservationsPageTitle_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String pageTitle = reservationsPage.getReservationsPageTitle();
		try {
			Assert.assertEquals(pageTitle, "Reservations | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test (priority =9)
	public void getDetailsWithReservationNumber_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String number = "RES-220004216";
		reservationsPage.inputReservationNumber(number);
		reservationsPage.clickSearchBtn();
		String reservationNumber = reservationsPage.getReservationNumber();
		try {
			Assert.assertEquals(reservationNumber, number);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =10)
	public void getDetailsWithLeadGuestName_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String name = "firstName jobTitle";
		reservationsPage.inputGuestName(name);
		reservationsPage.clickSearchBtn();
		List<String> guestNameList = reservationsPage.getLeadGuestNameList();
		Boolean status = false;
		for(int index = 0; index<guestNameList.size();index++) {
			if((guestNameList.get(index)).equals(name)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =11)
	public void getDetailsWithDates_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String checkInDate = "01/06/2022";
		String checkOutDate = "08/06/2022";
		reservationsPage.inputCheckInDate(checkInDate);
		reservationsPage.inputCheckOutDate(checkOutDate);
		reservationsPage.clickSearchBtn();
		List<String> checkInDateList = reservationsPage.getCheckInDateList();
		List<String> checkOutDateList = reservationsPage.getCheckOutDateList();
		Boolean checkInDateValidation = false;
		Boolean checkOutDateValidation = false;
		for(int index = 0; index<checkInDateList.size();index++) {
			if((checkInDateList.get(index)).equals(checkInDate)) {
				checkInDateValidation = true;
			} else {
				checkInDateValidation = false;
			}
		}	
		for(int index = 0; index<checkOutDateList.size();index++) {
			if((checkOutDateList.get(index)).equals(checkOutDate)) {
				checkOutDateValidation = true;
			} else {
				checkOutDateValidation = false;
			}
		}	
		try {
			Assert.assertTrue(checkInDateValidation);
			Assert.assertTrue(checkOutDateValidation);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	@Test (priority =12,enabled = true)
	public void getDetailsWithCheckInDate_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String date = "01/06/2022";
		reservationsPage.inputCheckInDate(date);
		reservationsPage.clickSearchBtn();
		List<String> dateList = reservationsPage.getCheckInDateList();
		Boolean status = false;
		for(int index = 0; index<dateList.size();index++) {
			if((dateList.get(index)).equals(date)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	@Test (priority =13,enabled = true)
	public void getDetailsWithCheckOutDate_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String date = "07/05/2022";
		reservationsPage.inputCheckOutDate(date);
		reservationsPage.clickSearchBtn();
		List<String> dateList = reservationsPage.getCheckOutDateList();
		Boolean status = false;
		for(int index = 0; index<dateList.size();index++) {
			if((dateList.get(index)).equals(date)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =14)
	public void getDetailsWithLocation_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		reservationsPage.inputLocation("United Kingdom - Preston - Centre");
		reservationsPage.clickSearchBtn();
		String apartmentName = reservationsPage.getApartmentName();
		try {
			Assert.assertEquals(apartmentName, "City Centre Preston");
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	@Test (priority =15)
	public void getDetailsWithReservationMadeByName_dashboard() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String name = "Allen & Overy LLP c/o Reed & Mackay";
		reservationsPage.inputReservationMadeBy(name);
		reservationsPage.clickSearchBtn();
		List<String> reservationMadeUserList = reservationsPage.getReservationMadeByNameList();
		Boolean status = false;
		for(int index = 0; index<reservationMadeUserList.size();index++) {
			if((reservationMadeUserList.get(index)).equals(name)) {
				status = true;
			} else {
				status = false;
			}
		}	
		try {
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	@Test(priority = 16)
	public void getRebookApartmentPage() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		String apartmentName = reservationsPage.getApartmentName();
		rebookApartmentPage = reservationsPage.clickRebookApartmentBtn();
		String propertyName = rebookApartmentPage.getPropertyName();
		try {
			Assert.assertTrue(apartmentName.equalsIgnoreCase(propertyName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 17, dataProvider = "reservationNumber")
	public void viewReservationData(String number) {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		reservationsPage.inputReservationNumber(number);
		reservationsPage.clickSearchBtn();
		String guestName = reservationsPage.getLeadGuestName();
		String apartmentName = reservationsPage.getApartmentName();
		String apartmentType = reservationsPage.getApartmentType();
		String checkInDate = reservationsPage.getCheckInDate();
		String checkOutDate = reservationsPage.getCheckOutDate();
		
		reservationDetailPage = reservationsPage.clickViewReservationBtn();
		String detailPageReservationNumber = reservationDetailPage.getReservationNumber();
		String detailPageGuestName = reservationDetailPage.getLeadGuestName();
		String detailPageApartmentName = reservationDetailPage.getApartmentName();
		String detailPageApartmentType = reservationDetailPage.getApartmentType();
		String detailPageCheckInDate = reservationDetailPage.getCheckInDate();
		String detailPageCheckOutDate = reservationDetailPage.getCheckOutDate();
		
		try {
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(detailPageReservationNumber, number);
			softassert.assertEquals(detailPageGuestName, guestName);
			softassert.assertEquals(detailPageApartmentName, apartmentName);
			softassert.assertEquals(detailPageApartmentType, apartmentType);
			softassert.assertEquals(detailPageCheckInDate, checkInDate);
			softassert.assertEquals(detailPageCheckOutDate, checkOutDate);
			softassert.assertAll();
			} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}
	
	@Test(priority = 18, dataProvider = "reservationNumber")
	public void downloadConfirmation(String number) {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		reservationsPage.inputReservationNumber(number);
		reservationsPage.clickSearchBtn();
		reservationsPage.clickDownloadConfirmationBtn();
		Boolean fileDownloaded = reservationsPage.fileDownloaded(number);
		try {
			Assert.assertTrue(fileDownloaded);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	
	@Test(priority = 19)
	public void getServiceRequestPage() {
		reservationsPage = loginPage.getDashboardPage().viewReservations();
		String resNumber = "RES-220004411";
		reservationsPage.inputReservationNumber(resNumber);
		reservationsPage.clickSearchBtn();
		serviceRequestPage = reservationsPage.clickRaiseServiceRequestBtn();
		String pageTitle = serviceRequestPage.getServiceRequestPageTitle();
		try {
			Assert.assertEquals(pageTitle, "Service Request | Orbi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "reservationNumber")
	public Object[][] reservationNumber(){
		return new Object[][] {
			{"RES-220004216"},
			{"RES-220004442"},
			{"RES-220004148"},
			{"RES-220004125"},
			{"RES-220004124"},
			{"RES-220004120"},
			{"RES-220003934"}
		};
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
