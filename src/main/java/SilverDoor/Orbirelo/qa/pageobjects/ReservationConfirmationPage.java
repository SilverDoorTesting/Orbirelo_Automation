package SilverDoor.Orbirelo.qa.pageobjects;

import java.io.File;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class ReservationConfirmationPage extends CustomizedDriverMethods {
	
	@FindBy(xpath = "//ul[contains(@class, 'uk-alert-success')]")
	WebElement successMsg;	
	
	@FindBy(xpath = "//h3[@class = 'uk-text-uppercase']")
	WebElement reservationHeader;
	
	@FindBy(xpath = "//a[@href='/app/reservations']")
	WebElement backToReservationsBtn;
	
	@FindBy(xpath = "//a[contains(@href,'/app/reservations/summary')]")
	WebElement downloadConfirmationBtn;

	
	public ReservationConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSuccessMsg() {
		return successMsg.getText();
	}
	
	public ReservationsPage clickBackToReservationsBtn() {
		backToReservationsBtn.click();
		return new ReservationsPage();
	}
	
	public void clickDownloadConfirmationBtn() {
		downloadConfirmationBtn.click();
	}
	
	public String getReservationNumber() {
		String reservationNumber = reservationHeader.getText();
		return reservationNumber.substring(23,reservationNumber.length());
	}
	
	public boolean fileDownloaded() {
		String resNumber = getReservationNumber();
		sleepAndWait(1000);
		File dowloadedFile = new File(CURRENT_DIR+"\\file_downloads\\Booking_Confirmation_"+resNumber+".pdf");
		boolean downloadedFileExists = dowloadedFile.exists();
		return downloadedFileExists;
	}
	
}
