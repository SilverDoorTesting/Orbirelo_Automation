package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class ReservationFormPage extends TestBase{

	@FindBy(xpath = "//div[@id= 'vue-booking']/div/h1']")
	WebElement pageHeader;

	@FindBy(id = "bookingTermsAgreement")
	WebElement bookingTermsAgreementCheckBox;

	@FindBy(xpath = "//button[@type= 'submit']")
	WebElement payNowBn;

	public ReservationFormPage() {
		PageFactory.initElements(driver, this);
	}

	public String getPageHeader() {
		return pageHeader.getText();
	}

}
