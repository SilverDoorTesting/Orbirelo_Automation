package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class MyProfilePage extends TestBase{
	
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
		Select usrTitle = new Select(userTitle);
		usrTitle.selectByValue(title);
	}
	
	public void inputFirstName(String name) {
		sendInput(firstname,name);
	}
	
	public void inputLastName(String name) {
		sendInput(lastName,name);
	}
	
	public void inputJobTitle(String designation) {
		sendInput(jobTitle,designation);
	}  
	
	public void selectAddressSearch() {
		addressSearchBtn.click();
	}	
	
	public void inputAddress(String place) {
		sendInput(address,place);
	}
	
	public void inputCity(String userCity) {
		sendInput(city,userCity);
	}
	
	public void selectCountry(String userCountry) {
		Select countryDropdown = new Select(country);
		countryDropdown.selectByValue(userCountry);
	}
	
	public void inputPostCode(String postal) {
		sendInput(postCode,postal);
	}
	
	public void addressSearch(String pincode) {
		addressSearchBtn.click();
		sendInput(postalCodeSearch,pincode);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(addressList));
		addressList.click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//ul[@class= 'c2a_results']/li/div/span[2]")).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inputEmailId(String email) {
		sendInput(emailId,email);
	}
	
	public void inputcallingcode(String code) {
		sendInput(countryCallingCode,code);
	}
	
	public void inputPhoneNumber(String number) {
		sendInput(phoneNumber,number);
	}
	
	public void inputNotificationEmail(String mail) {
		sendInput(notificationEmail,mail);
	}
	
	public void inputOffice(String officelocation) {
		sendInput(office,officelocation);
	}
	
	public void selectDepartment(String name) {
		Select departmentDropdown = new Select(department);
		departmentDropdown.selectByVisibleText(name);
	}

	public void selectSecurityRadioButton(String radioValue) {
		for( int index =0; index<securityRadioOptions.size();index++) {
			WebElement radioBtn = securityRadioOptions.get(index);
			if((radioBtn.getAttribute("value")).equalsIgnoreCase(radioValue)) {
				radioBtn.click();
				break;
			}
		}
	}

	public void selectMarketingCheckBox() {
		if(!marketingCheckbox.isSelected()) {
			marketingCheckbox.click();
		}
	}

	public void unSelectMarketingCheckBox() {
		if(marketingCheckbox.isSelected()) {
			marketingCheckbox.click();
		}
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
		sendInput(oldPassword,prop.getProperty("password"));
	}
	
	public void inputNewPassword(String pwd) {
		sendInput(newPassword, pwd);
	}
	
	public void inputConfirmPassword(String pwd) {
		sendInput(confirmNewPassword, pwd);
	}
	
	public void sendInput(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
}