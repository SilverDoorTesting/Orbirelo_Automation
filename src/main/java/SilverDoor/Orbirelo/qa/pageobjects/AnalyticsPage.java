package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class AnalyticsPage extends TestBase{
	
	@FindBy(xpath ="uk-button uk-margin-small-rightorbi-purple-button")
	WebElement overview;
	
	@FindBy(xpath = "uk-button-default")
	WebElement breakdown;
	
	@FindBy(name="rangeDate")
	WebElement all;
	
	@FindBy(name="year")
	WebElement year;
	
	@FindBy(name="region")
	WebElement allRegions;
	
	@FindBy(name="currencyCode")
	WebElement poundsFilter;
	
	@FindBy(name="currencyCode")
	WebElement poundsfilter;
	
	@FindBy(name="childAccount")
	WebElement allAccounts;
	
	@FindBy(xpath ="uk-button uk-button-primary")
	WebElement updateBtn;
	
	@FindBy(xpath ="uk-button uk-button-primary uk-align-right")
	WebElement exportcsvBtn1;
	
	@FindBy(xpath ="uk-button uk-button-primary uk-align-right")
	WebElement exportcsvBtn;
	
	public AnalyticsPage() {
		WebDriver driver;
		PageFactory.initElements(driver, this);
	}

	public String getAnalyticsPageTitle() {
		WebDriver driver;
		return driver.getTitle();
	}
	
	public void selectUserTitle(String title) {
		WebElement userTitle;
		Select usrTitle = new Select(userTitle);
		usrTitle.selectByValue(title);
	}
	
	
	
	
	
	
	
	
	
	
	
}   
  


