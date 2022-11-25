package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class ReservationDetailPage extends TestBase{
	
	@FindBy(xpath = "//h3[@class = 'uk-text-uppercase']")
	WebElement reservationNumber;
	
	@FindBy(xpath = "//div[@class = 'uk-grid']/div[1]/h4")
	WebElement leadGuestName;
	
	@FindBy(xpath = "//div[@class = 'uk-grid']/div[2]/div[1]")
	WebElement apartmentName;
	
	@FindBy(xpath = "//div[@class = 'uk-grid']/div[2]/div[2]")
	WebElement apartmentType;
	
	@FindBy(xpath = "//div[@class = 'uk-grid']/div[3]/div[1]")
	WebElement checkInDate;
	
	@FindBy(xpath = "//div[@class = 'uk-grid']/div[3]/div[2]")
	WebElement checkOutDate;
	
	@FindBy(xpath = "//a[@href = '/app/reservations']")
	WebElement backToReservationBtn;
	
	public ReservationDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getReservationNumber() {
		String resnumber = reservationNumber.getText();
		return resnumber.substring(23,resnumber.length());
	}
	
	public String getLeadGuestName() {
		String guestName = leadGuestName.getText();
		return guestName.substring(12,guestName.length());
	}
	
	public String getApartmentName() {
		String aptName = apartmentName.getText();
		return aptName.substring(16,aptName.length());
	}
	
	public String getApartmentType() {
		String aptType = apartmentType.getText();
		return aptType.substring(16,aptType.length());
	}
	
	public String getCheckInDate() {
		String inDate = checkInDate.getText();
		return inDate.substring(15,inDate.length());
	}
	
	public String getCheckOutDate() {
		String outDate = checkOutDate.getText();
		return outDate.substring(16,outDate.length());
	}

}
