package SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class EnquiryPage extends TestBase{

	@FindBy(name = "title")
	WebElement userTitle;

	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "lastName")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement emailId;

	@FindBy(name = "telephone")
	WebElement mobileNumber;

	@FindBy(name = "rmcReferenceNumber")
	WebElement rmcNumber;

	@FindBy(name = "apartmentType")
	WebElement apartmentType;

	@FindBy(id = "js-enquiry-destination")
	WebElement destination;

	@FindBy(name = "totalAdults")
	WebElement numberOfGuests;

	@FindBy(name = "guestNames")
	WebElement guestNames;

	@FindBy(xpath = "//div[@class = 'vdp-datepicker__calendar']/div/span")
	List<WebElement> dateValues;

	@FindBy(id = "js-enquiry-dateFrom")
	WebElement checkInDate;

	@FindBy(id = "js-enquiry-dateTo")
	WebElement checkOutDate;

	@FindBy(xpath = "//div[@class= 'vdp-datepicker__calendar']/header/span[3]")
	WebElement nextMonthButton;

	@FindBy(name = "totalApartments")
	WebElement totalApartments;

	@FindBy(name ="budget")
	WebElement nightBudget;

	@FindBy(name ="currency")
	WebElement budgetCurrency;

	@FindBy(id ="js-enquiry-flexible")
	WebElement flexibleDateCheckBox;

	@FindBy(name ="questions")
	WebElement specialRequirements;

	@FindBy(name="submitButton")
	WebElement submitBtn;

	@FindBy(xpath="//h1[@class='uk-text-xlarge']")
	WebElement thankYouMsg;

	public EnquiryPage() {
		PageFactory.initElements(driver, this);
	}

	public String getEnquiryPageTitle() {
		return driver.getTitle();
	}

	public void selectUserTitle(String value) {
		Select title = new Select(userTitle);
		title.selectByValue(value);
	}

	public void inputFirstName(String name) {
		sendInput(firstName,name);
	}

	public void inputLastName(String name) {
		sendInput(lastName,name);
	}

	public void inputEmailId(String email) {
		sendInput(emailId,email);
	}

	public void inputMobileNumber(String phone) {
		sendInput(mobileNumber,phone);
	}

	public void inputRmcReferenceNumber(String number) {
		sendInput(rmcNumber,number);
	}

	public void selectApartmentType(String type) {
		Select apartment = new Select(apartmentType);
		apartment.selectByVisibleText(type);
	}

	public void inputDestination(String place) {
		sendInput( destination,place);
	}

	public void selectNumberOfGuests(String guests) {
		Select guest = new Select(numberOfGuests);
		guest.selectByValue(guests);
	}

	public void inputGuestNames(String names) {
		sendInput(guestNames,names);
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

	public void selectTotalApartments(String apartments) {
		Select apartment = new Select(totalApartments);
		apartment.selectByValue(apartments);
	}

	public void inputBudget(String budget) {
		sendInput(nightBudget,budget);
	}

	public void selectBudgetCurrency(String currency) {
		Select budget = new Select(budgetCurrency);
		budget.selectByValue(currency);
	}

	public void selectFlexibleDateCheckBox() {
		if(!flexibleDateCheckBox.isSelected()) {
			flexibleDateCheckBox.click();
		}
	}

	public void unSelectFlexibleDateCheckBox() {
		if(flexibleDateCheckBox.isSelected()) {
			flexibleDateCheckBox.click();
		}
	}

	public void inputQuestions(String question)	{
		sendInput(specialRequirements,question);
	}

	public void clickSubmitButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",submitBtn);
		submitBtn.click();
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

	public String getThankYouMsg() {
		return thankYouMsg.getText();
	}
}
