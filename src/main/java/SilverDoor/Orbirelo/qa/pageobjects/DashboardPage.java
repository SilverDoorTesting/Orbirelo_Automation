package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.MyEnquiryAndQuotesPage;

public class DashboardPage extends TestBase{

	@FindBy(xpath = "//h3[text()= 'My Profile']")
	WebElement myProfile;
	
	@FindBy(xpath = "//h3[text()= 'Reservations']")
	WebElement viewReservations;

	@FindBy(xpath = "//i[contains(@class, 'orbi-nav-icon')]")
	WebElement sideMenu;

	@FindBy(xpath = "//li[@class = 'uk-parent ']//following::a[contains(@href, '/app/enquiry')]")
	WebElement enquiresAndQuotes;

	@FindBy(xpath = "//li[@class = 'uk-parent uk-open']/ul/li[2]/a")
	WebElement makeAnEnquiry;
	
	@FindBy(xpath = "//li[@class = 'uk-parent uk-open']/ul/li[3]/a")
	WebElement myEnquiryAndQuotes;

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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",submitEnquiry);
		submitEnquiry.click();	
		return new EnquiryPage();
	}

	public void clickSideMenu() {
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
	
	public ReservationsPage clickReservations() {
		reservations.click();
		return new ReservationsPage();
	}

}
