package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class MyProfilePage extends CustomizedDriverMethods{
	
	@FindBy(name="avatar")
	WebElement uploadImage;

	@FindBy(name="title")
	WebElement userTitle;

	@FindBy(name="firstName")
	WebElement firstname;

	@FindBy(name="lastName")
	WebElement lastName;

	@FindBy(name="jobTitle")
	WebElement jobTitle;

	@FindBy(xpath="//button[contains(@class,'uk-button-secondary')]")
	WebElement addressSearchBtn;
	
	@FindBy(name = "search")
	WebElement postalCodeSearch;
	
	@FindBy(xpath = "//ul[@class= 'c2a_results']/li")
	WebElement addressList;

	@FindBy(name="street")
	WebElement address;

	@FindBy(name="city")
	WebElement city;

	@FindBy(name="country")
	WebElement country;

	@FindBy(name="postcode")
	WebElement postCode;

	@FindBy(name="email")
	WebElement emailId;

	@FindBy(xpath="//input[@class ='vs__search']")
	WebElement countryCallingCode;

	@FindBy(name="phone")
	WebElement phoneNumber;

	@FindBy(name="notificationEmail")
	WebElement notificationEmail;

	@FindBy(xpath="//input[contains(@class,'uk-input')][@type = 'search']")
	WebElement office;

	@FindBy(name="department")
	WebElement department;

	@FindBy(name = "secondFactorVia")
	List<WebElement> securityRadioOptions;

	@FindBy(id="hasAgreedMarketing")
	WebElement marketingCheckbox;

	@FindBy(xpath= "//button[contains(@class,'uk-button-primary')]//following::button[contains(@class,'uk-button-secondary')]")
	WebElement createNewPasswordBtn;
	
	@FindBy(id = "oldPassword")
	WebElement oldPassword;
	
	@FindBy(id = "newPassword")
	WebElement newPassword;
	
	@FindBy(id = "newPasswordRepeat")
	WebElement confirmNewPassword;
	
	@FindBy(xpath="//button[contains(@class,'uk-button-primary')]")
	WebElement saveProfileBtn;
	
	@FindBy(xpath = "//ul[contains(@class , 'alert-success')]")
	WebElement validationMsg;

	public MyProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public String getProfilePageTitle() {
		return driver.getTitle();
	}
	
	public void selectUserTitle(String title) {
		selectComboByValue(userTitle,title);
	}
	
	public void inputFirstName(String name) {
		inputTextFields(firstname,name);
	}
	
	public void inputLastName(String name) {
		inputTextFields(lastName,name);
	}
	
	public void inputJobTitle(String designation) {
		inputTextFields(jobTitle,designation);
	}  
	
	public void selectAddressSearch() {
		addressSearchBtn.click();
	}	
	
	public void inputAddress(String place) {
		inputTextFields(address,place);
	}
	
	public void inputCity(String userCity) {
		inputTextFields(city,userCity);
	}
	
	public void selectCountry(String userCountry) {
		selectComboByValue(country,userCountry);
	}
	
	public void inputPostCode(String postal) {
		inputTextFields(postCode,postal);
	}
	
	public void addressSearch(String pincode) {
		addressSearchBtn.click();
		inputTextFields(postalCodeSearch,pincode);		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(addressList));
		addressList.click();
		sleepAndWait(6000);
		driver.findElement(By.xpath("//ul[@class= 'c2a_results']/li/div/span[2]")).click();
		sleepAndWait(6000);
		
	}
	
	public void inputEmailId(String email) {
		inputTextFields(emailId,email);
	}
	
	public void inputcallingcode(String code) {
		inputTextFields(countryCallingCode,code);
	}
	
	public void inputPhoneNumber(String number) {
		inputTextFields(phoneNumber,number);
	}
	
	public void inputNotificationEmail(String mail) {
		inputTextFields(notificationEmail,mail);
	}
	
	public void inputOffice(String officelocation) {
		inputTextFields(office,officelocation);
	}
	
	public void selectDepartment(String name) {
		selectComboByVisibleText(department,name);
	}

	public void selectSecurityRadioButton(String radioValue) {
		selectRadioButton(securityRadioOptions,radioValue);
	}

	public void selectMarketingCheckBox() {
		selectCheckBox(marketingCheckbox);
	}

	public void unSelectMarketingCheckBox() {
		unSelectCheckBox(marketingCheckbox);
	}

	public void clickSaveProfileBtn() {
		saveProfileBtn.click();
	}
	
	public String getValidationMsg() {
		return validationMsg.getText();
	}
	
	public void clickCreateNewPassword() {
		createNewPasswordBtn.click();
	}
	
	public void inputOldPassword() {
		inputTextFields(oldPassword,prop.getProperty("password"));
	}
	
	public void inputNewPassword(String pwd) {
		inputTextFields(newPassword, pwd);
	}
	
	public void inputConfirmPassword(String pwd) {
		inputTextFields(confirmNewPassword, pwd);
	}
}