package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MedoPractApp.MedoPractApp.Resources.Base;

public class ViewBillPage extends Base {

	WebDriver driver;

	public ViewBillPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open']")
	WebElement clickMenu;
	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/androidx.appcompat.widget.LinearLayoutCompat[4]/android.widget.CheckedTextView")
	WebElement BillingClick;
	
	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"VIEW BILL\"]/android.widget.TextView")
	WebElement ViewBillclick;
	
	@FindBy(id = "com.clinic.myclinic.debug:id/actvPatientNameBill")
	WebElement PatientNameField;
	
	@FindBy(id="com.clinic.myclinic.debug:id/tvBillDate")
	WebElement ClickNamelist;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickMenu() {
		return clickMenu;
	}

	public WebElement getBillingClick() {
		return BillingClick;
	}

	public WebElement getViewBillclick() {
		return ViewBillclick;
	}

	public WebElement getPatientNameField() {
		return PatientNameField;
	}

	public WebElement getClickNamelist() {
		return ClickNamelist;
	}
	
	
	


}
