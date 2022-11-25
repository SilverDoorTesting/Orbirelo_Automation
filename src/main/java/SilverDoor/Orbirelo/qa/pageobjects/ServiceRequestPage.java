package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import SilverDoor.Orbirelo.qa.base.TestBase;

public class ServiceRequestPage extends TestBase {
	
	@FindBy(xpath = "//a[@href = '/app/service-request']")
	WebElement backToServiceRequestBtn;
	
	@FindBy(name = "subject")
	WebElement subject;
	
	@FindBy(name = "description")
	WebElement description;
	
	@FindBy(name = "reasonClassification")
	WebElement requestClassification;

	@FindBy(xpath = "//i[@class='fa fa-plus-circle']//parent::a")
	List<WebElement> serviceRequestReason;
	
	@FindBy(name = "priority")
	WebElement priority;

	@FindBy(xpath = "//*[@type= 'radio']")
	List<WebElement> serviceRequestType;
	
	@FindBy(name = "reservation")
	WebElement reservationId;
	
	@FindBy(name = "submit")
	WebElement sendRequestBtn;
	
	public ServiceRequestPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getServiceRequestPageTitle() {
		return driver.getTitle();
	}
	
	public void inputSubject(String test) {
		sendInput(subject,test);
		
	}
		
	public void inputDescription(String describe) {
		sendInput(description,describe);

	}
	
	public void selectRequestClassification(String classification) {
		Select reasonclassification = new Select(requestClassification);
		reasonclassification.selectByValue(classification);
	}
	
	public void selectServiceRequestReason(String reason) {
		for(int index = 0 ; index < serviceRequestReason.size();index++) {
			if(serviceRequestReason.get(index).getText().equals(reason)) {
				serviceRequestReason.get(index).click();
				break;
			} 
		}
	}
	
	public void selectPriority(String status) {
		Select requestPriority = new Select(priority);
		requestPriority.selectByValue(status);
	}
	
	public void selectServiceRequestType(String type) {		
		for(int index = 0 ; index < serviceRequestType.size();index++) {
			if(serviceRequestType.get(index).getText().equals(type)) {
				serviceRequestType.get(index).click();
				break;
			} 
		}
	}
	
	public void inputReservationId(String number) {
		sendInput(reservationId,number);	
	}
	
	public IssueResolutionCentrePage clickSendRequestBtn() {
		sendRequestBtn.click();
		return new IssueResolutionCentrePage();
	}
	
	public IssueResolutionCentrePage clickBackToServiceRequestBtn() {
		backToServiceRequestBtn.click();
		return new IssueResolutionCentrePage();
	}
	
	public void sendInput(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}	

}
