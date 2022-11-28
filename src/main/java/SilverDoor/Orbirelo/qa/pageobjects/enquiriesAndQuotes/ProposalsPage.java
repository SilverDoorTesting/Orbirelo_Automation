package SilverDoor.Orbirelo.qa.pageobjects.enquiriesAndQuotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class ProposalsPage extends CustomizedDriverMethods {

	@FindBy(name = "leadGuestName")
	WebElement leadGuestName;

	@FindBy(name = "checkIn")
	WebElement checkInDate;

	@FindBy(name = "checkOut")
	WebElement checkOutDate;

	@FindBy(name = "submitButton")
	WebElement searchBtn;

	@FindBy(xpath = "//ul[@class = 'uk-list']/li[1]/span[1]")
	List<WebElement> proposalIdList;

	@FindBy(xpath = "//span[text() = 'Lead Guest Name:']//following::span[1]")
	List<WebElement> displayLeadGuestNameList;

	@FindBy(xpath = "//*[text() = 'Apartment Choice']//following::span[1]")
	List<WebElement> displayApartmentChoiceList;

	@FindBy(xpath = "//*[text() = 'Check-in Date: ']//following::span[1]")
	WebElement displayCheckInDate;

	@FindBy(xpath = "//*[text() = 'Check-in Date: ']//following::span[1]")
	List<WebElement> displayCheckInDateList;

	@FindBy(xpath = "//*[text() = 'Check-out Date: ']//following::span[1]")
	WebElement displayCheckOutDate;

	@FindBy(xpath = "//*[text() = 'Check-out Date: ']//following::span[1]")
	List<WebElement> displayCheckOutDateList;

	@FindBy(xpath = "//*[text() = 'Created On: ']//following::span[1]")
	WebElement displayCreatedOn;

	@FindBy(xpath = "//*[text() = 'Status: ']//following::span[1]")
	WebElement displayStatus;

	@FindBy(xpath = "//*[contains(@href, '/app/proposal/view/')]")
	List<WebElement> viewBtnList;

	@FindBy(xpath = "//h3[@class = 'uk-margin-remove-bottom']")
	List<WebElement> viewApartmentNameList;

	@FindBy(xpath = "//ul[contains(@class,'orbi-check-in')]/li/a")
	WebElement viewCheckInDate;

	@FindBy(xpath = "//ul[contains(@class,'orbi-check-in')]/li[2]/a")
	WebElement viewCheckOutDate;

	@FindBy(xpath = "//*[contains(@href, '/app/enquiry/')]")
	WebElement enquiryNowBtn;

	@FindBy(xpath = "//a[contains(@data-uk-toggle, 'orbi-delete-proposal')]")
	WebElement deleteBtn;	

	public ProposalsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getProposalsPageTitle() {
		return driver.getTitle();
	}

	public List<String> getProposalIDList() {
		List<String> idList = new ArrayList<String>();
		for(int index = 0; index< proposalIdList.size();index++) {
			idList.add(getSubString(proposalIdList.get(index),13));
		}
		return idList;
	}

	public String getProposalID() {
		List<String> idList = getProposalIDList();
		Random random = new Random();
		int index =  random.nextInt(idList.size());
		return idList.get(index);
	}

	public void inputLeadGuestName(String guestName) {
		inputTextFields(leadGuestName,guestName);
	}

	public void inputCheckInDate(String date) {		
		inputCheckInDate(checkInDate,date);
	}

	public void inputCheckOutDate(String date) {
		inputCheckOutDate(checkOutDate,date);
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

	public String getDisplayLeadGuestName() {
		return displayLeadGuestNameList.get(getProposalIdIndex()).getText();
	}

	public Boolean getDisplayLeadGuestNameList(String name) {
		return getAvailability(displayLeadGuestNameList,name);
	}

	public String getDisplayApartmentChoice() {		
		return displayApartmentChoiceList.get(getProposalIdIndex()).getText();
	}

	public String getDisplayCheckInDate(String name) {
		int value = getIndexFromMatchedName(displayApartmentChoiceList,name);
		String checkIn = displayCheckInDateList.get(value).getText().replaceAll("(?<=\\d)(st|nd|rd|th)", "");
		return convertDateFormat(checkIn,"EEEE d MMMM yyyy","dd/MM/yyyy");
	}

	public Boolean getDisplayCheckInDateList(String date) {
		return getDateStatus(displayCheckInDateList,date);
	}

	public Boolean getDisplayCheckOutDateList(String date) {
		return getDateStatus(displayCheckOutDateList,date);
	}

	public String getDisplayCheckOutDate(String name) {
		int value = getIndexFromMatchedName(displayApartmentChoiceList,name);
		String checkOut = displayCheckOutDateList.get(value).getText().replaceAll("(?<=\\d)(st|nd|rd|th)", "");
		return convertDateFormat(checkOut,"EEEE d MMMM yyyy","dd/MM/yyyy");
	}

	public String getDisplayCreatedOn() {
		return displayCreatedOn.getText();
	}

	public String getDisplayStatus() {
		return displayStatus.getText();
	}

	public void clickViewBtn(String name) {
		ClickBtnWithIndex(displayApartmentChoiceList,viewBtnList,name);
	}

	public Boolean getViewApartmentName(String name) {
		return getAvailability(viewApartmentNameList,name);
	}

	public String getViewCheckInDate() {
		String checkInDate = getSubString(viewCheckInDate,10).toLowerCase();
		String checkIn = checkInDate.replaceAll("(?<=\\d)(st|nd|rd|th)", "");
		return convertDateFormat(checkIn,"EEEE d MMMM yyyy","dd/MM/yyyy");		
	}

	public String getViewCheckOutDate() {
		String checkOutDate = getSubString(viewCheckOutDate,11).toLowerCase();
		String checkOut = checkOutDate.replaceAll("(?<=\\d)(st|nd|rd|th)", "");
		return convertDateFormat(checkOut,"EEEE d MMMM yyyy","dd/MM/yyyy");		
	}

	public EnquiryPage clickEnquiryNowBtn() {
		enquiryNowBtn.click();
		return new EnquiryPage();
	}

	public void clickDeleteBtn() {
		deleteBtn.click();	
	}

	public Boolean getDateStatus(List<WebElement> elementList, String date) {
		Boolean Status = false;
		String replacedDate;
		String convertedDate;
		for(int index=0;index<elementList.size();index++) {
			replacedDate = elementList.get(index).getText().replaceAll("(?<=\\d)(st|nd|rd|th)", "");
			convertedDate = convertDateFormat(replacedDate,"EEEE d MMMM yyyy","dd/MM/yyyy");
			if(convertedDate.equals(date)) {
				Status = true;
			} else {
				Status = false;
				break;
			}
		}
		return Status;
	}

	public Integer getIndexFromMatchedName(List<WebElement> element, String name) {
		int value = -1;
		for(int index = 0; index<displayApartmentChoiceList.size();index++) {
			if((displayApartmentChoiceList.get(index).getText()).equals(name)) {
				value = index;
				break;
			}
		}
		return value;
	}

	public Integer getProposalIdIndex() {
		List<String> idList = getProposalIDList();
		String proposalID = getProposalID();
		int value = -1;
		for(int index = 0; index<idList.size();index++) {
			if((idList.get(index)).equals(proposalID)) {
				value = index;
				break;
			}
		}
		return value;
	}
}
