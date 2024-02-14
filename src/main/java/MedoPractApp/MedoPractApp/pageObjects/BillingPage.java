package MedoPractApp.MedoPractApp.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MedoPractApp.MedoPractApp.Resources.Base;

public class BillingPage {

	public WebDriver driver;
	Base base;

	public BillingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		base = new Base();
	}

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
	WebElement clickMenu;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[4]/android.widget.CheckedTextView")
	WebElement BillingClick;

	@FindBy(id = "com.clinic.myclinic.debug:id/actvbillingPatientName")
	WebElement patientsNameField;
		
	@FindBy(id="com.clinic.myclinic.debug:id/etBedNumber")
	WebElement BedNumber;
	
	@FindBy(id="com.clinic.myclinic.debug:id/admissionDate")
	WebElement AdmissionDate;
	
	@FindBy(id="com.clinic.myclinic.debug:id/dischargeDate")
	WebElement DischargeDate;
	
	@FindBy(id="com.clinic.myclinic.debug:id/etDescription")
	WebElement Description;
	
	@FindBy(id="com.clinic.myclinic.debug:id/etQuantity")
	WebElement Quantity ;
	
	@FindBy(id="com.clinic.myclinic.debug:id/etRate")
	WebElement Rate;
	
	@FindBy(id="com.clinic.myclinic.debug:id/tvBillPlus")
	WebElement PlusSign;
	
	@FindBy(id="com.clinic.myclinic.debug:id/btnGenerateBill")
	WebElement GenerateBillButton;
	
	@FindBy(id="android:id/button1")
	WebElement OKButton;
	
	@FindBy(id="android:id/button2")
	WebElement CancelButton;
	
	

	public WebElement getClickMenu() {
		return clickMenu;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getBillingClick() {
		return BillingClick;
	}

	public WebElement getPatientsNameField() {
		return patientsNameField;
	}

	public WebElement getBedNumber() {
		return BedNumber;
	}

	public WebElement getAdmissionDate() {
		return AdmissionDate;
	}

	public WebElement getDischargeDate() {
		return DischargeDate;
	}

	public WebElement getDescription() {
		return Description;
	}

	public WebElement getQuantity() {
		return Quantity;
	}

	public WebElement getRate() {
		return Rate;
	}

	public WebElement getGenerateBillButton() {
		return GenerateBillButton;
	}

	public WebElement getOKButton() {
		return OKButton;
	}

	public WebElement getPlusSign() {
		return PlusSign;
	}

	public WebElement getCancelButton() {
		return CancelButton;
	}

	
	
	
	
}
