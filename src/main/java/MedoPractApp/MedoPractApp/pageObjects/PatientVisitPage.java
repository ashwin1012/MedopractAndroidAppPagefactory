package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PatientVisitPage {

	WebDriver driver;

	public PatientVisitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.clinic.myclinic.debug:id/etDateandTime")
	WebElement PatientvisitDateTimeField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPrimaryComplain")
	WebElement PrimaryComplaint;

	@FindBy(id = "com.clinic.myclinic.debug:id/etSymptomIndication")
	WebElement AddSymptoms;

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
	
	@FindBy(id="com.clinic.myclinic.debug:id/btnSavePatientVisit")
	WebElement OKButtonPatientVisit;
	
	
	@FindBy(id="com.clinic.myclinic.debug:id/follow_up")
	WebElement FollowupClick;
	
	@FindBy(id="com.clinic.myclinic.debug:id/etVisitReason")
	WebElement FollowupVisitReason;
	
	@FindBy(id="com.clinic.myclinic.debug:id/btnConfirmAppointment")
	WebElement ConfirmAppointmentPatientVisit;
			
	

	public WebElement getPatientvisitDateTimeField() {
		return PatientvisitDateTimeField;
	}

	public WebElement getClickPrimaryComplaint() {
		return PrimaryComplaint;
	}

	public WebElement getAddSymptoms() {
		return AddSymptoms;
	}

	public WebElement getAddClinicalObservation() {
		return AddClinicalObservation;
	}

	public WebElement getAddBloodPressure() {
		return AddBloodPressure;
	}

	public WebElement getAddDiagnosisRemarks() {
		return AddDiagnosisRemarks;
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

	public WebElement getOKButtonPatientVisit() {
		return OKButtonPatientVisit;
	}

	public WebElement getFollowupClick() {
		return FollowupClick;
	}

	public WebElement getFollowupVisitReason() {
		return FollowupVisitReason;
	}

	public WebElement getConfirmAppointmentPatientVisit() {
		return ConfirmAppointmentPatientVisit;
	}

	
	

}
