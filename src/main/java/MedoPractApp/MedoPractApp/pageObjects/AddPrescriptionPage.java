package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPrescriptionPage {

	public WebDriver driver;

	public AddPrescriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
	WebElement clickMenu;

	@FindBy(id = "com.clinic.myclinic.debug:id/actvPatientName")
	WebElement patientNameField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPatientEmail")
	WebElement emailField;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[3]/android.widget.CheckedTextView")
	WebElement clickingAddPrescriptionTab;
	
	


	@FindBy(id = "com.clinic.myclinic.debug:id/etMedicineName")
	WebElement medicineNameField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etNoofDays")
	WebElement totalNumberDays;

	@FindBy(id = "com.clinic.myclinic.debug:id/etInstructions")
	WebElement timingsInput;

	@FindBy(id = "com.clinic.myclinic.debug:id/etMedAmount")
	WebElement amountInput;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnSavePrint")
	WebElement saveAndPrintButton;

	@FindBy(xpath = "//a[@class='AddPrescription_buttonscom__3_zBx']")
	WebElement backButton;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement YesButton;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView")
	WebElement PlusSign;

	// AddPrescription_addinvestigationtests__BMTsR

	// public WebDriver getDriver() {
	// return driver;
	// }

	public WebElement getPatientNameField() {
		return patientNameField;
	}

	public WebElement getClickMenu() {
		return clickMenu;
	}

	public WebElement getEmailField() {
		return emailField;
	}


	public WebElement getClickingAddPrescriptionTab() {
		return clickingAddPrescriptionTab;
	}

	public WebElement getMedicineNameField() {
		return medicineNameField;
	}

	public WebElement getTotalNumberDays() {
		return totalNumberDays;
	}

	public WebElement getTimingsInput() {
		return timingsInput;
	}

	public WebElement getAmountInput() {
		return amountInput;
	}

	public WebElement getSaveAndPrintButton() {
		return saveAndPrintButton;
	}

	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getSaveButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement getYesButton() {
		return YesButton;
	}

	public WebElement getPlusSign() {
		return PlusSign;
	}

	public WebElement getViewPrescriptionlink() {

		return getViewPrescriptionlink();
	}

}
