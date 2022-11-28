package SilverDoor.Orbirelo.qa.pageobjects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class ReservationsPage extends CustomizedDriverMethods {

	String CURRENT_DIR = System.getProperty("user.dir");
	
	@FindBy(xpath="//a[@class = 'uk-button uk-button-secondary']")
	WebElement viewPendingReservations;

	@FindBy(name="name")
	WebElement reservationNumber;

	@FindBy(name="leadGuestName")
	WebElement guestName;

	@FindBy(name = "checkIn")
	WebElement checkInDate;

	@FindBy(name = "checkOut")
	WebElement checkOutDate;

	@FindBy(xpath="//input[@name = 'location'][@type='search']")
	WebElement location;

	@FindBy(name="clientName")
	WebElement reservationMadeBy;

	@FindBy(name="submitButton")
	WebElement searchBtn;

	@FindBy(xpath="//button[@name = 'submitButton']//following::button")
	WebElement clearBtn;

	@FindBy(xpath = "//div[text()= 'Reservations']")
	WebElement resevationsFilterBtn;

	@FindBy(xpath="//input[@type= 'checkbox']")
	WebElement reservationsFilterMenu;

	@FindBy(xpath = "//input[@type= 'submit']")
	WebElement reservationsFilterDoneBtn;

	@FindBy(xpath = "//h3[@class='uk-margin-remove']")
	WebElement apartmentName;

	@FindBy(xpath = "//div[contains(@class, 'uk-padding-remove-vertical uk-first-column')]")
	WebElement tableReservationNumber;

	@FindBy(xpath = "//table[contains(@class, 'orbi-reservation-table')]/tbody/tr/td[1]")
	WebElement tableLeadGuestName;
	
	@FindBy(xpath = "//table[contains(@class, 'orbi-reservation-table')]/tbody/tr/td[2]")
	WebElement apartmentType;
	
	@FindBy(xpath = "//table[contains(@class, 'orbi-reservation-table')]/tbody/tr/td[3]")
	WebElement tableCheckInDate;
	
	@FindBy(xpath = "//table[contains(@class, 'orbi-reservation-table')]/tbody/tr/td[4]")
	WebElement tableCheckOutDate;

	@FindBy(xpath = "//table[contains(@class, 'orbi-reservation-table')]/tbody/tr/td[1]")
	List<WebElement> tableLeadGuestNameList;
	
	@FindBy(xpath = "//table[contains(@class, 'orbi-reservation-table')]/tbody/tr/td[3]")
	List<WebElement> tableCheckInDateList;
	
	@FindBy(xpath = "//table[contains(@class, 'orbi-reservation-table')]/tbody/tr/td[4]")
	List<WebElement> tableCheckOutDateList;

	@FindBy(xpath = "//div[contains(@class, 'orbi-reservation-meta')]/div[3]")
	List<WebElement> tableReservationMadeByList;

	@FindBy(xpath = "//ul[contains(@class, 'pagination ')]/li")
	List<WebElement> navigationCountList;

	@FindBy(xpath = "//span[contains(@class, 'uk-active')]")
	WebElement activePage;

	@FindBy(className="uk-button-primary uk-button uk-width-1-1 uk-width-auto@m")
	WebElement makeAmendment;

	@FindBy(className="uk-button-default uk-button uk-width-1-1 uk-width-auto@m")
	WebElement amendmentHistory;
	
	@FindBy(xpath = "//a[contains(@class,'orbi-re-book-btn')]")
	WebElement rebookApartmentBtn;
	
	@FindBy(xpath = "//a[contains(text(),'View Reservation')]")
	WebElement viewReservationBtn;

	@FindBy(xpath = "//a[contains(text(),'Download Confirmation')]")
	WebElement downloadConfirmationBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Raise Service Request')]")
	WebElement raiseServiceRequestBtn;
	
	@FindBy(xpath = "//button[contains(@data-uk-toggle , 'orbi-cancel')]")
	WebElement reservationCancelBtn;
	
	@FindBy(xpath = "//div[@class = 'uk-grid uk-grid-small']/div[1]/a")
	WebElement reservationCancelYesBtn;
	
	@FindBy(xpath = "//div[@class = 'uk-grid uk-grid-small']/div[2]/button")
	WebElement reservationCancelNoBtn;
	
	@FindBy(xpath = "//div[@class = 'uk-container']/ul/li")
	WebElement cancelSuccessMsg;
	
	public ReservationsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getReservationsPageTitle() {
		return driver.getTitle();
	}

	public void inputReservationNumber(String number) {
		inputTextFields(reservationNumber,number);
	}

	public void inputGuestName(String name) {
		inputTextFields(guestName,name);
	}

	public void inputCheckInDate(String date) {	
		inputCheckInDate(checkInDate,date);
	}

	public void inputCheckOutDate(String date) {
		inputCheckOutDate(checkOutDate,date);
	}

	public void inputLocation(String place) {
		inputTextFields(location,place);
	}

	public void inputReservationMadeBy(String place) {
		inputTextFields(reservationMadeBy,place);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public void clickClearBtn() {
		clearBtn.click();
	}

	public String getLeadGuestName() {
		return tableLeadGuestName.getText();
	}
	
	public String getApartmentName() {
		return apartmentName.getText();
	}
	
	public String getApartmentType() {
		return getSubString(apartmentType,4);
	}
	
	public String getCheckInDate() {
		return tableCheckInDate.getText();
	}
	
	public String getCheckOutDate() {
		return tableCheckOutDate.getText();
	}

	public String getReservationNumber() {
		return getSubString(tableReservationNumber,23);
	}

	public List<String> getLeadGuestNameList() {
		return getReservationDataList(tableLeadGuestNameList);
	}

	public List<String> getCheckInDateList() {
		return getReservationDataList(tableCheckInDateList);
	}
	
	public List<String> getCheckOutDateList() {
		return getReservationDataList(tableCheckOutDateList);
	}

	public List<String> getReservationMadeByNameList() {
		List<String> userList = new ArrayList<String>();
		List<String> nameList = getReservationDataList(tableReservationMadeByList);
		for(int index = 0;index<nameList.size();index++) {
			String name = nameList.get(index);
			userList.add(name.substring(20,name .length()));
		}
		return userList;
	}
	
	public RebookApartmentPage clickRebookApartmentBtn() {
		rebookApartmentBtn.click();
		return new RebookApartmentPage();
	}
	
	public ReservationDetailPage clickViewReservationBtn() {
		viewReservationBtn.click();
		return new ReservationDetailPage();
	}
	
	public void clickDownloadConfirmationBtn() {
		downloadConfirmationBtn.click();
		sleepAndWait(1000);
	}
	
	public boolean fileDownloaded(String resNumber) {
		File dowloadedFile = new File(CURRENT_DIR+"\\file_downloads\\Booking_Confirmation_"+resNumber+".pdf");
		boolean downloadedFileExists = dowloadedFile.exists();
		return downloadedFileExists;
	}
	
	public ServiceRequestPage clickRaiseServiceRequestBtn() {
		raiseServiceRequestBtn.click();
		return new ServiceRequestPage();
	}
	
	public void clickReservationCancelBtn() {
		reservationCancelBtn.click();
	}
	
	public void clickReservationCancelYesBtn() {
		reservationCancelYesBtn.click();
	}
	
	public void clickReservationCancelNoBtn() {
		reservationCancelNoBtn.click();
	}
	
	public String getCancelSuccessMsg() {
		return cancelSuccessMsg.getText();
	}

	public List<String> getReservationDataList(List<WebElement> tableNameList) {
		List<String> dataList = new ArrayList<>();
		if(navigationCountList.size()>0) {
			for(int page = 0;page<navigationCountList.size()-1;page++) {
				for(int index =0;index<tableNameList.size();index++) {
					String gridText = tableNameList.get(index).getText();
					dataList.add(gridText);	
				}
				int activePageNumber = Integer.parseInt(activePage.getText());
				if(page<navigationCountList.size()-2) {
					if(activePageNumber>1) {
						navigationCountList.get(page+2).click();
					} else {
						navigationCountList.get(page+1).click();
					}
				}
			}
		}else {
			for(int index =0;index<tableNameList.size();index++) {
				String gridText = tableNameList.get(index).getText();
				dataList.add(gridText);	
			}
		}
		return dataList;
	}

}
