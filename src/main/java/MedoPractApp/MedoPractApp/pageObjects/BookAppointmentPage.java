package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookAppointmentPage {

	WebDriver driver;

	public BookAppointmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Book Appt\"]/android.widget.ImageView")
	WebElement ClickBookAppointment;

	@FindBy(id = "com.clinic.myclinic.debug:id/etFullName")
	WebElement FullNameField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPhoneNo")
	WebElement PhoneNoField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etVisitReason")
	WebElement ClickVisitReasonField;

	@FindBy(id = "com.clinic.myclinic.debug:id/tvDate")
	WebElement ClickCalender;

	@FindBy(id = "android:id/button1")
	WebElement ClickOKButton;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnConfirmAppointment")
	WebElement ClickConfirmAppointment;
	
	@FindBy(id="com.clinic.myclinic.debug:id/tvAppBookSuccess")
	WebElement AppointmentBookMessage;
	
	@FindBy(id="com.clinic.myclinic.debug:id/btnOKAY")
	WebElement AppointmentBookOkMessage;

	public WebElement getClickBookAppointment() {
		return ClickBookAppointment;
	}

	public WebElement getFullNameField() {
		return FullNameField;
	}

	public WebElement getPhoneNoField() {
		return PhoneNoField;
	}

	public WebElement getClickVisitReasonField() {
		return ClickVisitReasonField;
	}

	public WebElement getClickCalender() {
		return ClickCalender;
	}

	public WebElement getClickOKButton() {
		return ClickOKButton;
	}

	public WebElement getClickConfirmAppointment() {
		return ClickConfirmAppointment;
	}

	public WebElement getAppointmentBookMessage() {
		return AppointmentBookMessage;
	}

	public WebElement getAppointmentBookOkMessage() {
		return AppointmentBookOkMessage;
	}
	
	

}
