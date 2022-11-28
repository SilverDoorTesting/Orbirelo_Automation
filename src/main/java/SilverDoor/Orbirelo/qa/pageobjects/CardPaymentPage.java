package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class CardPaymentPage extends CustomizedDriverMethods {
	
	@FindBy(name = "card_number_local")
	WebElement cardNumber;
	
	@FindBy(name = "card_cvn")
	WebElement cardSecurityCode;
	
	@FindBy(name = "card_type_local")
	WebElement cardType;
	
	@FindBy(name = "card_expiry_month")
	WebElement cardExpiryMonth;
	
	@FindBy(name = "card_expiry_year")
	WebElement cardExpiryYear;
	
	@FindBy(name = "submit_button")
	WebElement payNowBtn;

	public CardPaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public String getPageHeader() {
		return driver.getTitle();
	}
	
	public void inputCardNumber(String number) {
		inputTextFields(cardNumber,number);
	}
	
	public void inputCardSecurityCode(String code) {
		inputTextFields(cardSecurityCode,code);
	}
	
	public void selectCardType(String type) {
		selectComboByVisibleText(cardType,type);
	}
	
	public void selectCardExpiryMonth(String month) {
		selectComboByVisibleText(cardExpiryMonth,month);
	}
	
	public void selectCardExpiryYear(String year) {
		selectComboByVisibleText(cardExpiryYear,year);
	}
	
	public void clickPayNowBtn() {
		payNowBtn.click();
	}
	
}
