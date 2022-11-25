package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.ProposalsPage;

public class RebookApartmentPage extends TestBase {

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
	
	@FindBy(xpath = "//input[@type= 'radio']")
	List<WebElement> planOptions;
	
	@FindBy(id = "js-orbi-select-22383")
	WebElement addToProposalBtn;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	WebElement instantBookBtn;

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
		selectDate(date);
	}

	public void inputCheckOutDate(String date) {
		checkOutDate.click();
		checkOutDate.click();
		selectDate(date);
	}

	public void selectGuestCount(String count) {
		Select guests = new Select(noOfGuests);
		guests.selectByVisibleText(count);	
	}
	
	public void clickUpdateResultsBtn() {
		updateResults.click();
	}
	
	public void clickAddToProposalBtn() {
		addToProposalBtn.click();
	}
	
	public ReservationFormPage clickInstantBookBtn() {
		instantBookBtn.click();
		return new ReservationFormPage();
	}

	public void sendInput(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
		
	public void selectDate(String date) {
		if(dateValues.get(dateIndex(date)).getAttribute("class").contains("disabled")){
			nextMonthButton.click();
		}	
		dateValues.get(dateIndex(date)).click();
	}

	public int dateIndex(String date) {
		int value = 0;
		for(int index =0; index <dateValues.size();index++) {
			if(dateValues.get(index).getText().equals(date)) {
				value = index;
				break;
			}
		}
		return value;
	}

}
