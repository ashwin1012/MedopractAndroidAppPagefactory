package MedoPractApp.MedoPractApp.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MedoPractApp.MedoPractApp.Resources.Base;



public class LoginPage {

	public WebDriver driver;
	Base base;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		base = new Base();
	}

	@FindBy(id = "com.clinic.myclinic.debug:id/etUsername")
	private WebElement usernamefield;

	@FindBy(id = "com.clinic.myclinic.debug:id/etPassword")
	private WebElement passwordfield;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnSubmit")
	WebElement SubmitButton;
	
	@FindBy(id="com.clinic.myclinic.debug:id/textinput_placeholder")
	WebElement WithoutDataSymbol;

	//@FindBy(css = "input[type='submit'],[class='authCommon_button__1kwT_ authCommon_btnText__32n4S']")
	//WebElement SubmitWithoutDataButtonClick;
	
	

	public WebElement getUsernamefield() {
		return usernamefield;
	}

	public WebElement getPasswordfield() {
		return passwordfield;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	

	/*public WebElement getSubmitWithoutDataButtonClick() {
		return SubmitWithoutDataButtonClick;
	}*/
	
	

	public WebElement getWithoutDataSymbol() {
		return WithoutDataSymbol;
	}

	public void login(String username, String password) throws Exception {
		//base.waitForElementVisibility(usernamefield,Duration.ofSeconds(60), "user name", driver);
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		//Thread.sleep(1000);
		//base.waitForElementVisibility(gotItButton,Duration.ofSeconds(60), "user name", driver);
	
		//Thread.sleep(1000);
		//base.waitForElementVisibility(SubmitButton,Duration.ofSeconds(60), "user name", driver);
		SubmitButton.click();
	}
	
	
	
	/*public void login1(String username, String password) throws Exception {
		 base.waitForElementVisibility(usernamefield,Duration.ofSeconds(60), "user name", driver);
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		//Thread.sleep(1000);
		
		//Thread.sleep(1000);
		 base.waitForElementVisibility(SubmitButton,Duration.ofSeconds(60), "user name", driver);
		SubmitButton.click();
	}*/
}


