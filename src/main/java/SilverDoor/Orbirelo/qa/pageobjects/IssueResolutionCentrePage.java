package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class IssueResolutionCentrePage extends TestBase{

	@FindBy(xpath = "//ul[contains(@class,'alert-success')]")
	WebElement successMsg;

	public IssueResolutionCentrePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getIssueResolutionCentrePageTitle() {
		return driver.getTitle();
	}
	
	public String getSuccessMsg() {
		String message = successMsg.getText();
		return message.substring(0, message.indexOf(".")+1);
	}
}
