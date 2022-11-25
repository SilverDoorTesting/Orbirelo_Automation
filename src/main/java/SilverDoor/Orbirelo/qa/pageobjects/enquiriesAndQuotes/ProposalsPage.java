package SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes;

import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class ProposalsPage extends TestBase {
	
	public ProposalsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProposalsPageTitle() {
		return driver.getTitle();
	}
}
