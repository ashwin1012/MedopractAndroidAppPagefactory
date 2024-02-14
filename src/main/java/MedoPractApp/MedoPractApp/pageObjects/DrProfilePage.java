package MedoPractApp.MedoPractApp.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MedoPractApp.MedoPractApp.Resources.Base;

public class DrProfilePage {

	public WebDriver driver;
	Base base;

	public DrProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		base = new Base();

	}

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
	WebElement clickMenu;

	@FindBy(id = "com.clinic.myclinic.debug:id/txtDrName")
	WebElement ProfileClick;

	@FindBy(id = "com.clinic.myclinic.debug:id/txtUpdateDrProfile")
	WebElement UpdateProfile;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrFirstName")
	WebElement FirstName;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrLastName")
	WebElement LastName;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.Spinner/android.widget.TextView")
	WebElement GenderDropdown;
	
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView")
    WebElement MaleDropdown;
	
	@FindBy(id = "com.clinic.myclinic.debug:id/etDrEmailId")
	WebElement EmailId;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrId")
	WebElement DoctorId;
	
	@FindBy(id = "com.clinic.myclinic.debug:id/etDrStudies")
	WebElement Studies;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrDOB")
	WebElement DateCalender;
	
	@FindBy(id = "android:id/button1")
	WebElement OKButton;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrMobile")
	WebElement Mobile;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrPhone")
	WebElement Phone;

	@FindBy(id = "com.clinic.myclinic.debug:id/ettDrFax")
	WebElement Fax;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrHospitalName")
	WebElement HospitalName;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrAddressLine1")
	WebElement AddressLine1;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrAddressLine2")
	WebElement AddressLine2;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrCountry")
	WebElement Country;

	@FindBy(id = "com.clinic.myclinic.debug:id/etCity")
	WebElement City;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDrState")
	WebElement State;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPostalCode")
	WebElement PostalCode;
	
	@FindBy(id = "com.clinic.myclinic.debug:id/btnDrProfileUpdate")
	WebElement UpdateButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickMenu() {
		return clickMenu;
	}

	public WebElement getProfileClick() {
		return ProfileClick;
	}

	public WebElement getUpdateProfile() {
		return UpdateProfile;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getEmailId() {
		return EmailId;
	}

	public WebElement getDoctorId() {
		return DoctorId;
	}

	public WebElement getStudies() {
		return Studies;
	}

	public WebElement getDateCalender() {
		return DateCalender;
	}

	public WebElement getMobile() {
		return Mobile;
	}

	public WebElement getPhone() {
		return Phone;
	}

	public WebElement getFax() {
		return Fax;
	}

	public WebElement getHospitalName() {
		return HospitalName;
	}

	public WebElement getAddressLine1() {
		return AddressLine1;
	}

	public WebElement getAddressLine2() {
		return AddressLine2;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getState() {
		return State;
	}

	public WebElement getPostalCode() {
		return PostalCode;
	}

	public WebElement getUpdateButton() {
		return UpdateButton;
	}

	public WebElement getOKButton() {
		return OKButton;
	}

	public WebElement getGenderDropdown() {
		return GenderDropdown;
	}

	public WebElement getMaleDropdown() {
		return MaleDropdown;
	}

	
	
}