package SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class ShortListPage extends CustomizedDriverMethods {

	@FindBy(xpath = "//h2[contains(@class, 'orbi-property-name')]")
	List<WebElement> propertyNameList;

	@FindBy(xpath = "//a[contains(@href,'/app/enquiry/')]")
	List<WebElement> enquiryBtnList;
	
	@FindBy(xpath = "//a[@href='/app/enquiry'][contains(@class,'uk-button')]")
	WebElement submitEnquiryForAllPropertiesBtn;

	@FindBy(xpath = "//div[@id = 'vue-shortlist']/div[2]/div[2]/div[2]/a")
	WebElement removeShortListBtn;
	
	@FindBy(xpath = "//span[@class = 'orbi-quote']")
	WebElement pageHeader;

	public ShortListPage() {
		PageFactory.initElements(driver, this);
	}

	public String getShortListPageTitle() {
		return driver.getTitle();
	}

	public boolean getPropertyShortListStatus(String name) {
		return getAvailability(propertyNameList,name);
	}

	public EnquiryPage clickEnquiryNowBtn(String name) {
		ClickBtnWithIndex(propertyNameList,enquiryBtnList,name);
		return new EnquiryPage();
	}

	public void clickRemoveShortListBtn() {
		removeShortListBtn.click();
		sleepAndWait(500);
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public EnquiryPage clickSubmitEnquiryForAllPropertiesBtn() {
		submitEnquiryForAllPropertiesBtn.click();
		return new EnquiryPage();
	}
	
}
