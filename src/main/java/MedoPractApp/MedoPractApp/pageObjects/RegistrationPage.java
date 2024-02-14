package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.clinic.myclinic.debug:id/tvRegister")
	WebElement ClickRegister;

	@FindBy(id = "com.clinic.myclinic.debug:id/etFirstName")
	public WebElement FirstNameField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etLastName")
	WebElement LastNameField;

	@FindBy(id = "com.clinic.myclinic.debug:id/etEmailId")
	WebElement emailfield;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPhoneNo")
	WebElement PhoneNofield;

	@FindBy(id = "com.clinic.myclinic.debug:id/etNewUsername")
	WebElement usernamefield;

	@FindBy(id = "com.clinic.myclinic.debug:id/etConfirmUsername")
	WebElement confirmusernamefield;

	@FindBy(id = "com.clinic.myclinic.debug:id/cbCheckBox")
	WebElement agreetermcheckbox;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnRegister")
	WebElement clickregisterbutton;

	@FindBy(id = "com.clinic.myclinic.debug:id/tvRegistrationSuccess")
	WebElement RegisterMesssage;
	
	@FindBy(id="com.clinic.myclinic.debug:id/actionHelp")
	WebElement MobileClickHelp;

	/*
	 * @FindBy(xpath =
	 * "//span[text( )='Please check your email for login instructions']")
	 * WebElement SuccessMsg;
	 * 
	 * @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div/div[2]/div[9]/div/a")
	 * WebElement ClickImAlreadyUSer;
	 * 
	 * @FindBy(xpath = "//a[@class='TooltipAuth_helpTag__DvHOH']") WebElement
	 * clickHelp;
	 */

	/*
	 * @FindBy(xpath = "//span[contains(@class,'register_modalText')]") public
	 * WebElement resgistrationmessage;
	 */

	@FindBy(id = "com.clinic.myclinic.debug:id/btnOK")
	public WebElement OKRegistermmessage;

	@FindBy(xpath = "//p[text( )='Please check this box if you want to Proceed!']")
	public WebElement checkboxmessage;

	@FindBy(xpath = "//svg[@class=' react-toast-notifications__toast__dismiss-icon']")

	public WebElement closeicon;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickRegister() {
		return ClickRegister;
	}

	public WebElement getFirstNameField() {
		return FirstNameField;
	}

	public WebElement getOKRegistermmessage() {
		return OKRegistermmessage;
	}

	public WebElement getRegisterMesssage() {
		return RegisterMesssage;
	}

	public WebElement getLastNameField() {
		return LastNameField;
	}

	public WebElement getEmailfield() {
		return emailfield;
	}

	public WebElement getPhoneNofield() {
		return PhoneNofield;
	}

	public WebElement getUsernamefield() {
		return usernamefield;
	}

	public WebElement getConfirmusernamefield() {
		return confirmusernamefield;
	}

	public WebElement getAgreetermcheckbox() {
		return agreetermcheckbox;
	}

	public WebElement getClickregisterbutton() {
		return clickregisterbutton;
	}
	
	

	/*
	 * public WebElement getSuccessMsg() { return SuccessMsg; }
	 * 
	 * public WebElement getClickImAlreadyUSer() { return ClickImAlreadyUSer; }
	 * 
	 * public WebElement getClickHelp() { return clickHelp; }
	 * 
	 * 
	 * 
	 * 
	 * public WebElement getOkButton() { return OkButton; }
	 * 
	 * 
	 * 
	 * public WebElement getConfirmmessgae() { return confirmmessage; }
	 */

	public WebElement getMobileClickHelp() {
		return MobileClickHelp;
	}

	public WebElement getCheckboxmessage() {
		return checkboxmessage;
	}

	public WebElement getCloseicon() {
		return closeicon;
	}

	public void VerifyRegistrationMessage() {

		String actualRegistrationMessage = driver.findElement(By.xpath("//span[contains(@class,'register_modalText')]"))
				.getText();

		String expectedRegistrationMessage = "Registration Successful";
		Assert.assertEquals(actualRegistrationMessage, expectedRegistrationMessage);
	}
}
