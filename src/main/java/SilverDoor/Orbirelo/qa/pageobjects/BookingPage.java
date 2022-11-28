package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes.EnquiryPage;
import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class BookingPage extends CustomizedDriverMethods{

	@FindBy(xpath = "//h2[contains(@class, 'orbi-property-name')]")
	List<WebElement> propertyNameList;

	@FindBy(xpath = "//i[contains(@class, 'fa-heart')]")
	List<WebElement> shortListBtn;

	@FindBy(xpath = "//button[@class = 'uk-width-1-1 uk-button uk-button-default uk-button-small cla-switcher-button uk-light uk-background-primary']")
	WebElement allPropertiesTab;

	@FindBy(xpath = "//button[contains(text(),  'Instant book')][contains(@class, 'cla-switcher-button')]")
	WebElement instantBookTab;

	@FindBy(xpath = "//button[contains(text(), 'Enquire now')]")
	WebElement enquireNowTab;

	@FindBy(xpath = "//a[contains(text() , 'Preview')]")
	WebElement preview;

	@FindBy(name = "ratePlan")
	WebElement orbiRate;

	@FindBy(xpath = "//input[@name = 'ratePlan'][@type ='radio']")
	List<WebElement> ratePlanList;

	@FindBy(xpath ="//label[contains(@for, 'rate')]")
	List<WebElement> planNameList;

	@FindBy(xpath = "//button[@class= 'uk-button uk-button-default']")
	WebElement moreOptionsBtn;

	@FindBy(xpath = "//button[contains(@id, 'js-orbi-select')]")
	List<WebElement> addToProposalBtnList;

	@FindBy(xpath = "//input[@name= 'rateId']")
	List<WebElement> rateIdOptions;

	@FindBy(xpath = "//a[contains(@id, 'js-orbi-select')]")
	List<WebElement> selectBtnList;

	@FindBy(xpath = "//a[contains(@href, '/app/enquiry/')]")
	List<WebElement> enquiryNowBtnList;

	@FindBy(xpath = "//div[contains(@class, 'uk-notification-message-success')]/div")
	WebElement addToProposalSuccessMsg;

	@FindBy(xpath = "//button[contains(text(),  'Instant book')][contains(@class, 'uk-button-primary')]")
	List<WebElement> instantBookBtnList;

	@FindBy(id = "//div[@id= 'orbi-search-view-all-top']/a")
	WebElement viewAllApartmentsbtn;

	public BookingPage() {
		PageFactory.initElements(driver, this);
	}

	public String getBookingPageTitle() {
		return driver.getTitle();
	}

	public void clickAllPropertiesTab() {
		allPropertiesTab.click();
	}

	public void clickInstantBookTab() {
		instantBookTab.click();
	}

	public void selectRatePlan(String option) {
		for(int index = 0 ; index < ratePlanList.size();index++) {
			if(planNameList.get(index).getText().contains(option)) {
				ratePlanList.get(index).click();
				break;
			} 
		}
	}

	public ReservationFormPage clickInstantBookBtn(String name) {
		for(int index = 0;index<propertyNameList.size();index++) {
			if(propertyNameList.get(index).getText().contains(name)) {
				instantBookBtnList.get(index).click();
				break;
			}
		}
		return new ReservationFormPage();
	}

	public void clickShortListBtn(String name) {
		for(int index = 0;index<propertyNameList.size();index++) {
			if(propertyNameList.get(index).getText().trim().equals(name)) {
				if(!getPropertyShortListStatus(name)) {
				shortListBtn.get(index).click();
				}
				break;
			}
		}
		sleepAndWait(500);
		
	}

	public Boolean getPropertyShortListStatus(String name) {
		String iconColor = "";
		Boolean shortListed = false;
		for(int index = 0;index<propertyNameList.size();index++) {
			if(propertyNameList.get(index).getText().trim().equals(name)) {
				iconColor = shortListBtn.get(index).getAttribute("class");
				break;
			}
		}
		
		if(iconColor.contains("uk-text-danger")) {
			shortListed = true;
		}
		return shortListed;
	}

	public void clickEnquireNowTab() {
		enquireNowTab.click();
	}

	public EnquiryPage clickEnquiryNowBtn(String name) {
		for(int index = 0;index<propertyNameList.size();index++) {
			if(propertyNameList.get(index).getText().contains(name)) {
				enquiryNowBtnList.get(index).click();
				break;
			}
		}
		return new EnquiryPage();
	}

	public void clickPreview() {
		preview.click();
	}

	public void clickMoreOptions() {
		moreOptionsBtn.click();
	}

	public String clickAddToProposalBtn(String name) {
		for(int index = 0;index<propertyNameList.size();index++) {
			if(propertyNameList.get(index).getText().contains(name)) {
				addToProposalBtnList.get(index).click();
				break;
			}
		}
		return addToProposalSuccessMsg.getText();
	}

	public void clickAddToProposalBtnForMultiplePropType(String name) {
		for(int index = 0;index<propertyNameList.size();index++) {
			if(propertyNameList.get(index).getText().contains(name)) {
				addToProposalBtnList.get(index).click();
				break;
			}
		}
	}

	public void clickRateIdOptions(String type) {
		selectRadioButton(rateIdOptions,type);
	}

	public String clickSelectBtn() {
		selectBtnList.get(propertyNameList.size()-1).click();
		return addToProposalSuccessMsg.getText();
	}

	public void clickViewAllapartments() {
		viewAllApartmentsbtn.click();
	}	
}