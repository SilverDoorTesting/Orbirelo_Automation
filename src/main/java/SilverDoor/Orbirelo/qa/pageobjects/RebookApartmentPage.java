package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.ProposalsPage;
import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class RebookApartmentPage extends CustomizedDriverMethods {

	@FindBy(xpath = "//h2[@itemprop='name']")
	WebElement propertyName;
	
	@FindBy(xpath = "//a[@href = '/app/search']")
	WebElement backToSearchResults;

	@FindBy(xpath = "//a[@href = '/app/enquiry']")
	WebElement makeAnEnquiry;

	@FindBy(xpath = "//a[@href = '/app/proposal/create']")
	WebElement generateProposal;

	@FindBy(name = "checkIn")
	WebElement checkInDate;

	@FindBy(name = "checkOut")
	WebElement checkOutDate;
	
	@FindBy(xpath = "//div[@class = 'vdp-datepicker__calendar']/div/span")
	List<WebElement> dateValues;
	
	@FindBy(xpath = "//div[@class= 'vdp-datepicker__calendar']/header/span[3]")
	WebElement nextMonthButton;

	@FindBy(name = "occupancy")
	WebElement noOfGuests;

	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement updateResults;
	
	@FindBy(xpath = "//input[@type= 'radio']/parent::div/following-sibling::div/div")
	List<WebElement> planOptions;
	
	@FindBy(id = "js-orbi-select-22383")
	WebElement addToProposalBtn;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement instantBookBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'uk-notification-message')]/div")
	WebElement notificationMsg;


	public RebookApartmentPage() {
		PageFactory.initElements(driver, this);
	}

	public String getRebookApartmentPageTitle() {
		return driver.getTitle();
	}

	public DashboardPage clickBackToSearchResults() {
		backToSearchResults.click();
		return new DashboardPage();
	}

	public EnquiryPage clickMakeAnEnquiry() {
		makeAnEnquiry.click();
		return new EnquiryPage();
	}

	public ProposalsPage clickGenerateProposal() {
		generateProposal.click();
		return new ProposalsPage();
	}
	
	public String getPropertyName() {
		return propertyName.getText();
	}

	public void inputCheckInDate(String date) {
		checkInDate.click();
		selectDate(dateValues,nextMonthButton,date);
	}

	public void inputCheckOutDate(String date) {
		checkOutDate.click();
		checkOutDate.click();
		selectDate(dateValues,nextMonthButton,date);
	}

	public void selectGuestCount(String count) {
		selectComboByValue(noOfGuests,count);
	}
	
	public void clickUpdateResultsBtn() {
		updateResults.click();
	}
	
	public void selectPlan(String option) {
		selectDropdown(planOptions,option);
	}
	
	public String clickAddToProposalBtn() {
		addToProposalBtn.click();
		return notificationMsg.getText();
	}
	
	public ReservationFormPage clickInstantBookBtn() {
		instantBookBtn.click();
		return new ReservationFormPage();
	}

}
