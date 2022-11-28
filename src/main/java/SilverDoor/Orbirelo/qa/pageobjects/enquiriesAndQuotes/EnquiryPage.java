package SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class EnquiryPage extends CustomizedDriverMethods{

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
		selectComboByValue(userTitle,value);
	}

	public void inputFirstName(String name) {
		inputTextFields(firstName,name);
	}

	public void inputLastName(String name) {
		inputTextFields(lastName,name);
	}

	public void inputEmailId(String email) {
		inputTextFields(emailId,email);
	}

	public void inputMobileNumber(String phone) {
		inputTextFields(mobileNumber,phone);
	}

	public void inputRmcReferenceNumber(String number) {
		inputTextFields(rmcNumber,number);
	}

	public void selectApartmentType(String type) {
		selectComboByVisibleText(apartmentType,type);
	}

	public void inputDestination(String place) {
		inputTextFields( destination,place);
	}

	public void selectNumberOfGuests(String guests) {
		selectComboByValue(numberOfGuests,guests);
	}

	public void inputGuestNames(String names) {
		inputTextFields(guestNames,names);
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

	public void selectTotalApartments(String apartments) {
		selectComboByValue(totalApartments,apartments);
	}

	public void inputBudget(String budget) {
		inputTextFields(nightBudget,budget);
	}

	public void selectBudgetCurrency(String currency) {
		selectComboByValue(budgetCurrency,currency);
	}

	public void selectFlexibleDateCheckBox() {
		selectCheckBox(flexibleDateCheckBox);
	}

	public void unSelectFlexibleDateCheckBox() {
		unSelectCheckBox(flexibleDateCheckBox);
	}

	public void inputQuestions(String question)	{
		inputTextFields(specialRequirements,question);
	}

	public void clickSubmitButton() {
		ScrollAndClickButton(submitBtn);
	}

	public String getThankYouMsg() {
		return thankYouMsg.getText();
	}
}
