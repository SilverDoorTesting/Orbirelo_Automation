package SilverDoor.Orbirelo.qa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SilverDoor.Orbirelo.qa.util.CustomizedDriverMethods;

public class ServiceRequestPage extends CustomizedDriverMethods {
	
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
		inputTextFields(subject,test);
		
	}
		
	public void inputDescription(String describe) {
		inputTextFields(description,describe);

	}
	
	public void selectRequestClassification(String classification) {
		selectComboByValue(requestClassification,classification);
	}
	
	public void selectServiceRequestReason(String reason) {
		selectDropdownWithMatchedValue(serviceRequestReason, reason);
	}
	
	public void selectPriority(String status) {
		selectComboByValue(priority,status);
	}
	
	public void selectServiceRequestType(String type) {	
		selectDropdownWithMatchedValue(serviceRequestType,type);
	}
	
	public void inputReservationId(String number) {
		inputTextFields(reservationId,number);	
	}
	
	public IssueResolutionCentrePage clickSendRequestBtn() {
		sendRequestBtn.click();
		return new IssueResolutionCentrePage();
	}
	
	public IssueResolutionCentrePage clickBackToServiceRequestBtn() {
		backToServiceRequestBtn.click();
		return new IssueResolutionCentrePage();
	}
	
}
