package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPrescriptionPage {

	public WebDriver driver;

	public ViewPrescriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"VIEW PRESCRIPTION\"]/android.widget.TextView")
	WebElement viewPrescriptionTab;

	@FindBy(xpath = "//input[@name='patientname']")
	WebElement patientNameField;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getViewPrescriptionTab() {
		return viewPrescriptionTab;
	}

	public WebElement getPatientNameField() {
		return patientNameField;
	}

}
