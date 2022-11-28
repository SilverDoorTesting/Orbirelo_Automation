package SilverDoor.Orbirelo.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class ReservationDetailPage extends CustomizedDriverMethods{
	
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
		return getSubString(reservationNumber,23);
	}
	
	public String getLeadGuestName() {
		return getSubString(leadGuestName,12);
	}
	
	public String getApartmentName() {
		return getSubString(apartmentName,16);
	}
	
	public String getApartmentType() {
		return getSubString(apartmentType,16);
	}
	
	public String getCheckInDate() {
		return getSubString(checkInDate,15);
	}
	
	public String getCheckOutDate() {
		return getSubString(checkOutDate,16);
	}

}
