package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class LoginPage extends CustomizedDriverMethods {
	
	@FindBy(name = "email")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//*[contains(@class , 'uk-button')]")
	WebElement loginButton;

	@FindBy(xpath = "//*[contains(@class, 'uk-text-danger')]")
	WebElement validationMsg;
	
	@FindBy(xpath = "//*[contains(@class, 'uk-alert-danger')]/li[1]")
	WebElement invalidCredAlertMsg;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();	
	}

	public void inputUserName(String email) {
		inputTextFields(userName,email);
	}

	public void inputPassword(String userPwd) {
		inputTextFields(password,userPwd);
	}

	public void clickLoginBtn() {
		loginButton.click();
	}

	public DashboardPage getDashboardPage() {
		inputUserName(prop.getProperty("username"));
		inputPassword(prop.getProperty("password"));
		clickLoginBtn();
		return new DashboardPage();		
	}
	
	public String getEmptyCredValidationMsg() {
		return validationMsg.getText();
	}

	public String getEmptyPwdValidationMsg() {
		return validationMsg.getText();
	}

	public String getInvalidPwdValidationMsg() {
		return invalidCredAlertMsg.getText();
	}
	
	public String getInvalidEmailValidationMsg() {
		return invalidCredAlertMsg.getText();
	}

}
