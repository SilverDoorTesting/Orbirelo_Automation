package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.MyEnquiryAndQuotesPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.ProposalsPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.ShortListPage;
import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class DashboardPage extends CustomizedDriverMethods{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//input[@placeholder =  'Destination or Office']")
	WebElement destination;
	
	@FindBy(xpath = "//div[@class = 'search-bar-item']")
	List<WebElement> destinationList;

	@FindBy(id = "js-search-postcode")
	WebElement postcode;

	@FindBy(name = "checkIn")
	WebElement checkInDate;

	@FindBy(name = "checkOut")
	WebElement checkOutDate;

	@FindBy(name = "occupancy")
	WebElement guest;

	@FindBy(xpath = "//input[@type =  'submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//h3[text()= 'My Profile']")
	WebElement myProfile;

	@FindBy(xpath = "//h3[text()= 'Reservations']")
	WebElement viewReservations;

	@FindBy(xpath = "//i[contains(@class, 'orbi-nav-icon')]")
	WebElement sideMenu;

	@FindBy(xpath = "//li[@class = 'uk-parent ']//following::a[contains(@href, '/app/enquiry')]")
	WebElement enquiresAndQuotes;

	@FindBy(xpath = "//li[@class = 'uk-parent ']//following::ul/li/a[contains(@href, '/app/enquiry')]")
	WebElement makeAnEnquiry;

	@FindBy(xpath = "//li[@class = 'uk-parent ']//following::a[contains(@href, '/app/quote')]") 
	WebElement myEnquiryAndQuotes;
	
	@FindBy(xpath = "//li[@class = 'uk-parent ']//following::a[contains(@href, '/app/proposal')]")
	WebElement proposals;
	
	@FindBy(xpath = "//li[@class = 'uk-parent ']//following::a[contains(@href, '/app/shortlist')]")
	WebElement shortList;

	@FindBy(xpath = "//li[@class = 'uk-parent ']//following::a[contains(@href, '/app/reservations')]")
	WebElement reservations;

	@FindBy(partialLinkText = "SUBMIT ENQUIRY")
	WebElement submitEnquiry;

	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public String getDashboardTitle() {
		return driver.getTitle();
	}

	public MyProfilePage clickMyProfile() {
		myProfile.click();
		return new MyProfilePage();
	}

	public ReservationsPage viewReservations() {
		viewReservations.click();
		return new ReservationsPage();
	}

	public EnquiryPage submitEnquiry() {
		js.executeScript("arguments[0].scrollIntoView();",submitEnquiry);
		submitEnquiry.click();	
		return new EnquiryPage();
	}

	public void clickSideMenu() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		sideMenu.click();
	}

	public void clickEnquiryAndQuotes() {
		enquiresAndQuotes.click();
	}

	public EnquiryPage clickCreateEnquiry() {
		makeAnEnquiry.click();
		return new EnquiryPage();
	}

	public MyEnquiryAndQuotesPage clickMyQuotesAndEnquiry() {
		myEnquiryAndQuotes.click();
		return new MyEnquiryAndQuotesPage();
	}
	
	public ProposalsPage clickProposal() {
		proposals.click();
		return new ProposalsPage();
	}
	
	public ShortListPage clickShortList() {
		shortList.click();
		return new ShortListPage();
	}

	public ReservationsPage clickReservations() {
		reservations.click();
		return new ReservationsPage();
	}

	public void inputDestination(String searchname,String fullName) {
		inputTextFields(destination,searchname);
		selectDropdown(destinationList,fullName);
	}

	public void inputPostCode(String code) {
		inputTextFields(postcode,code);
	}

	public void inputCheckInDate() {		
		inputCheckInDate(checkInDate,getCurrentDate());
	}

	public void inputCheckOutDate(int days) {
		inputCheckOutDate(checkOutDate,getFutureDate(days));
	}
	
	public void selectOccupancy(String count) {
		selectComboByValue(guest,count);
	}
	
	public BookingPage clickSearchBtn() {
		searchBtn.click();
		return new BookingPage();
	}

}
