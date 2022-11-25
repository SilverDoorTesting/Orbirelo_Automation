package SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.base.TestBase;
import SilverDoor.Orbirelo.qa.pageobjects.ServiceRequestPage;

public class MyEnquiryAndQuotesPage extends TestBase{

	@FindBy(xpath = "//dt[text()='Destination']//following::dd")
	WebElement destination;

	@FindBy(xpath = "//dt[text()='Check-in Date']//following::dd")
	WebElement checkInDate;

	@FindBy(xpath = "//dt[text()='Check-out Date']//following::dd")
	WebElement checkOutDate;

	@FindBy(xpath = "//dt[text()='Apartment Type']//following::dd")
	WebElement apartmentType;

	@FindBy(xpath = "//dt[text()='Nightly Budget']//following::dd")
	WebElement nightlyBudget;

	@FindBy(xpath = "//dt[text()='Lead Guest Name']//following::dd")
	WebElement leadGuestName;

	@FindBy(xpath = "//dt[text()='Enquiry ID']//following::dd")
	WebElement enquiryID;

	@FindBy(xpath = "//*[contains(@class, 'uk-grid')]/div[3]/dl/dd[2]")
	List<WebElement> enquiryIDList;

	@FindBy(xpath = "//a[contains(@class, 'uk-button-secondary')]")
	List<WebElement> serviceRequestBtnList;

	public MyEnquiryAndQuotesPage() {
		PageFactory.initElements(driver, this);
	}

	public String getMyEnquiryAndQuotesPageTitle() {
		return driver.getTitle();
	}

	public String getDestination() {
		return destination.getText();
	}

	public String getCheckInDate() {
		return checkInDate.getText();
	}

	public String getCheckOutDate() {
		return checkOutDate.getText();
	}

	public String getApartmenttype() {
		return apartmentType.getText();
	}

	public String getNightlyBudget() {
		return nightlyBudget.getText();
	}

	public String getLeadGuestName() {
		return leadGuestName.getText();
	}

	public String getEnquiryId() {
		return enquiryID.getText();
	}

	public ServiceRequestPage clickRaiseServiceRequestBtn(String enquiryID) {
		for(int index =0; index<enquiryIDList.size(); index++) {
			if((enquiryIDList.get(index).getText()).equals(enquiryID)){
				serviceRequestBtnList.get(index).click();
				break;
			}
		}
		return new ServiceRequestPage();
	}
}
