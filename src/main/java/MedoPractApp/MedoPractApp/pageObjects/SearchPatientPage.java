package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPatientPage {

	WebDriver driver;

	public SearchPatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
	WebElement ClickMenu;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[1]/android.widget.CheckedTextView")
	public WebElement PatientsClick;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText")
	public WebElement SearchName;

	@FindBy(id = "com.clinic.myclinic.debug:id/tvPatientName")
	WebElement ResultValueClick;

	@FindBy(id = "com.clinic.myclinic.debug:id/arrowdown_aboutpatient")
	WebElement AboutPatientClick;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnPatientVisitAtDetail")
	WebElement PatientVisitButton;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPrimaryComplain")
	WebElement PrimaryComplaint;

	@FindBy(id = "com.clinic.myclinic.debug:id/etSymptomIndication")
	WebElement AddSymptoms;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDateandTime")
	WebElement PatientvisitDateTimeField;

	@FindBy(xpath = "//android.view.View[@content-desc=\"21 December 2022\"]")
	WebElement CalenderDate;

	@FindBy(id = "android:id/button1")
	WebElement OkButton;

	@FindBy(id = "com.clinic.myclinic.debug:id/etClinicalObservation")
	WebElement AddClinicalObservation;

	@FindBy(id = "com.clinic.myclinic.debug:id/etDiagnosisRemarks")
	WebElement AddDiagnosisRemarks;

	@FindBy(id = "com.clinic.myclinic.debug:id/etBloodPressure")
	WebElement AddBloodPressure;

	@FindBy(id = "com.clinic.myclinic.debug:id/etSugarLevel")
	WebElement AddSugarLevel;

	@FindBy(id = "com.clinic.myclinic.debug:id/etHeartRate")
	WebElement AddHeartRate;

	@FindBy(id = "com.clinic.myclinic.debug:id/etInvestigations")
	WebElement AddInvestigations;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnPatientVisitSave")
	WebElement ClickSaveButton;
	

	@FindBy(id = "android:id/button1")
	WebElement ClickTimeOkButtonPV;
	
	@FindBy(id="com.clinic.myclinic.debug:id/btnSavePatientVisit")
	WebElement OKButtonPatientVisit;
	
	@FindBy(id="com.clinic.myclinic.debug:id/tvPatAddvisitSuccess")
	WebElement PatientVisitMessageValidation;
	
	@FindBy(id="com.clinic.myclinic.debug:id/etVisitReason")
	WebElement FollowupVisitReason;
	
	@FindBy(id="com.clinic.myclinic.debug:id/btnConfirmAppointment")
	WebElement ConfirmAppointmentPatientVisit;
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickMenu() {
		return ClickMenu;
	}

	public WebElement getPatientsClick() {
		return PatientsClick;
	}

	public WebElement getSearchName() {
		return SearchName;
	}

	public WebElement getResultValueClick() {
		return ResultValueClick;
	}

	public WebElement getAboutPatientClick() {
		return AboutPatientClick;
	}

	public WebElement getPatientVisitButton() {
		return PatientVisitButton;
	}

	public WebElement getClickPrimaryComplaint() {
		return PrimaryComplaint;
	}

	public WebElement getAddSymptoms() {
		return AddSymptoms;
	}

	public WebElement getPatientvisitDateTimeField() {
		return PatientvisitDateTimeField;
	}

	public WebElement getOkButton() {
		return OkButton;
	}

	public WebElement getAddClinicalObservation() {
		return AddClinicalObservation;
	}

	public WebElement getAddDiagnosisRemarks() {
		return AddDiagnosisRemarks;
	}

	public WebElement getAddBloodPressure() {
		return AddBloodPressure;
	}

	public WebElement getAddSugarLevel() {
		return AddSugarLevel;
	}

	public WebElement getAddHeartRate() {
		return AddHeartRate;
	}

	public WebElement getAddInvestigations() {
		return AddInvestigations;
	}

	public WebElement getClickSaveButton() {
		return ClickSaveButton;
	}
	
	public WebElement getClickTimeOkButtonPV() {
		return ClickTimeOkButtonPV;
	}
	
	public WebElement getOKButtonPatientVisit() {
		return OKButtonPatientVisit;
	}

	public WebElement getPatientVisitMessageValidation() {
		return PatientVisitMessageValidation;
	}

	public WebElement getFollowupVisitReason() {
		return FollowupVisitReason;
	}

	public WebElement getConfirmAppointmentPatientVisit() {
		return ConfirmAppointmentPatientVisit;
	}

}
