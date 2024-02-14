package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MedoPractApp.MedoPractApp.Resources.Base;

public class AddPatientPage extends Base {

	WebDriver driver;

	public AddPatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
	WebElement clickMenu;

	@FindBy(id = "com.clinic.myclinic.debug:id/largeLabel")
	WebElement patientsClick;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPatientName")
	WebElement patientNameField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPatientPhone")
	WebElement phoneNoField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etOccupation")
	WebElement OccupationField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etEmergencyContact")
	WebElement emergencyField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etAddress")
	WebElement addressField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etAllergies")
	WebElement allergiesField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etRemarks")
	WebElement remarksField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etHistory")
	WebElement historyField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etHabits")
	WebElement habitsField;

	// @FindBy(xpath = " //a[@class='CreatePatient_addinvestigationtests__18P-9']")
	// WebElement clickingPlusSign;

	// a[@class='CreatePatient_addinvestigationtests__18P-9']

	@FindBy(id = "com.clinic.myclinic.debug:id/btnPatientSave")
	WebElement saveButton;

	@FindBy(id = "com.clinic.myclinic.debug:id/radiobtnM")
	WebElement radioButton;

	@FindBy(id = "com.clinic.myclinic.debug:id/tvPatAddSuccess")
	WebElement AddPatientMessage;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnOKAYaddpatient")
	WebElement AddPatientOKMessage;

	// @FindBy(xpath = "//div[@class='react-date-picker__inputGroup']")
	// WebElement birthdateClick;

	// @FindBy(name = "month")
	// WebElement month;

	// @FindBy(name = "day")
	// WebElement day;

	// @FindBy(name = "year")
	// WebElement year;

	// @FindBy(xpath = "//select[@class='CreatePatient_genderinput__WaZFp']")
	// WebElement gender;

	// @FindBy(xpath = "//select[@class='CreatePatient_bloodgroupinput__8Lw8r']")
	// WebElement Bloodgroup;

	// @FindBy(xpath = "//div[text()='Patient Record created successfully!']")
	// ebElement AddPatientMessage;

	// @FindBy(xpath = "//div[@class='react-toast-notifications__toast__content
	// css-1ad3zal']")
	// WebElement AddPatientreqdinputmessage;

	// @FindBy(xpath = "//div[@class='react-toast-notifications__toast__content
	// css-1ad3zal']")
	// WebElement reqdinputmessage2;

	// @FindBy(xpath =
	// "//input[@class='CreatePatientSidebar_fileChooseInput__3Ifuc']")
	// WebElement Photoupload;

	public WebElement getPatientsClick() {
		return patientsClick;
	}

	/*
	 * public WebElement getBloodgroup() { return Bloodgroup; }
	 * 
	 * public WebElement getMonth() { return month; }
	 * 
	 * public WebElement getDay() { return day; }
	 * 
	 * public WebElement getYear() { return year; }
	 */

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getAddPatientMessage() {
		return AddPatientMessage;
	}

	public WebElement getAddPatientOKMessage() {
		return AddPatientOKMessage;
	}

	public WebElement getPatientNameField() {
		return patientNameField;
	}

	public WebElement getPhoneNoField() {
		return phoneNoField;
	}

	public WebElement getOccupationField() {
		return OccupationField;
	}

	public WebElement getEmergencyField() {
		return emergencyField;
	}

	public WebElement getAllergiesField() {
		return allergiesField;
	}

	public WebElement getRemarksField() {
		return remarksField;
	}

	public WebElement getHistoryField() {
		return historyField;
	}

	public WebElement getHabitsField() {
		return habitsField;
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	/*
	 * public WebElement getClickingPlusSign() { return clickingPlusSign; }
	 * 
	 * public WebElement getSaveButton() { return saveButton; }
	 * 
	 * public WebElement getResetButton() { return resetButton; }
	 */

	/*
	 * public WebElement getBirthdateClick() { return birthdateClick; }
	 * 
	 * public WebElement getGender() { return gender; }
	 */

	/*
	 * public WebElement getAddPatientMessage() { return AddPatientMessage; }
	 * 
	 * public WebElement getAddPatientreqdinputmessage() { return
	 * AddPatientreqdinputmessage; }
	 * 
	 * public WebElement getReqdinputmessage2() { return reqdinputmessage2; }
	 */

	// public WebElement getPhotoupload() {
	// return Photoupload;
}
