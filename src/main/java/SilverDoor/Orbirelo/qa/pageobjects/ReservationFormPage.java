package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class ReservationFormPage extends CustomizedDriverMethods{

	@FindBy(xpath = "//div[@id= 'vue-booking']/div/h1")
	WebElement pageHeader;

	@FindBy(id = "bookingTermsAgreement")
	WebElement bookingTermsAgreementCheckBox;
	
	@FindBy(xpath = "//button[contains(@data-uk-toggle , 'billback-confirmation')]")
	WebElement bookNowWithBillBackBtn; 
	
	@FindBy(xpath = "//div[@id='orbi-booking-billback-confirmation']//following::button[@type = 'submit']")
	WebElement billBookConfirmBtn;
	
	@FindBy(xpath = "//div[@id='orbi-booking-billback-confirmation']//following::button[@type = 'button']")
	WebElement billBookCancelBtn;
	
	@FindBy(xpath = "//button[@name = 'payByCard']")
	WebElement payNowByCardBtn;
	
	@FindBy(name = "title")
	WebElement Title;
	
	@FindBy(name = "firstname")
	WebElement FirstName;
	
	@FindBy(name = "lastname")
	WebElement LastName;
	
	@FindBy(name = "telephone")
	WebElement PhoneNumber;
	
	@FindBy(name = "alternativeTelephone")
	WebElement AlternativeNumber;
	
	@FindBy(name = "email")
	WebElement Email;
	
	@FindBy(name = "costCenter")
	WebElement CostCenters;
	
	@FindBy(name = "clientReferenceNumber")
	WebElement UniqueClientReferenceNumber;
	
	@FindBy(name = "address")
	WebElement Address;
	
	@FindBy(name = "city")
	WebElement Town;
	
	@FindBy(name = "county")
	WebElement County;
	
	@FindBy(name = "countryId")
	WebElement Country;
	
	@FindBy(name = "postcode")
	WebElement Postcode;
	
	@FindBy(name = "numberOfGuests")
	WebElement NoOfGuests;
	
	@FindBy(name = "leadGuestFirstname")
	WebElement LeadGuestFirstName;
	
	@FindBy(name = "leadGuestLastname")
	WebElement LeadGuestLastName;
	
	@FindBy(name = "specialRequirements")
	WebElement SpecialRequirements;
	
	
	public ReservationFormPage() {
		PageFactory.initElements(driver, this);
	}

	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickBookingTermsAgreementCheckBox() {
		bookingTermsAgreementCheckBox.click();
	}
	
	public void clickBookNowWithBillBackBtn() {
		bookNowWithBillBackBtn.click();
	}

	public ReservationConfirmationPage clickBillBookConfirmBtn() {
		billBookConfirmBtn.click();
		return new ReservationConfirmationPage();
	}
	
	public void clickBillBookCancelBtn() {
		billBookCancelBtn.click();
	}
	
	public void clickPayNowByCardBtn() {
		payNowByCardBtn.click();
	}
	
	public void inputTitle(String title) {
		inputTextFields(Title,title);
	}
    
}
