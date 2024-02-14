package Tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.RegistrationPage;
import pageObjects.VerifyregisterPage;

public class TC_RegistrationTest_003 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException {
		log = LogManager.getLogger(TC_RegistrationTest_003.class.getName());
		//etest = extent.createTest("Registration test execution started");
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");
		 base = new Base(); 
	}

	@Test(priority = 1)
	public void Registration() throws Exception {
		//etest = extent.createTest("Register Now execution started");
		RegistrationPage rp = new RegistrationPage(driver);
		Thread.sleep(2000);
		//base.waitForElementVisibility(rp.getGotItButton(),Duration.ofSeconds(60), "namefield", driver);
		rp.getGotItButton().click();
		//Thread.sleep(2000);
		base.waitForElementVisibility(rp.getClickRegisterNow(),Duration.ofSeconds(60), "namefield", driver);
		rp.getClickRegisterNow().click();
		log.debug("Clicked RegisterNow Button");
		//etest.info("Clicked RegisterNow Button");
		base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60), "namefield", driver);
		rp.NameField.sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		//etest.info("Entered Name");
		
		//Thread.sleep(1000);
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		//etest.info("Entered Email Address");
		//Thread.sleep(1000);
		rp.getMobilefield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		//etest.info("Entered Phone Number");
		//Thread.sleep(1000);
		 String Username= testData.get("username")+Base.randomNumber(); 
		 rp.getUsernamefield().sendKeys(Username);
		log.debug("Entered UserName");
		//etest.info("Entered UserName");
		//Thread.sleep(1000);
		rp.getConfirmusernamefield().sendKeys(Username);
		log.debug("Entered ConfirmUserName");
		//etest.info("Entered ConfirmUserName");
		//Thread.sleep(1000);
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");
		//etest.info("Clicked Checkbox");
		//Thread.sleep(2000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");
		//etest.info("Clicked Register Button");

		//Thread.sleep(2000);
		 base.waitForElementVisibility(rp.resgistrationmessage,Duration.ofSeconds(60), "resgistrationmessage", driver);
		String actualRegistrationMessage =rp.resgistrationmessage
				.getText();

		String expectedRegistrationMessage = "Registration Successful!";
		Assert.assertEquals(actualRegistrationMessage, expectedRegistrationMessage);

		rp.getOkButton().click();
		//Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void NotConfirmUsernameField() throws Exception {
		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60), "namefield", driver);
		rp.NameField.clear();
		rp.NameField.sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		//Thread.sleep(2000);
		rp.getEmailfield().clear();
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		//Thread.sleep(2000);
		for (int i = 1; i <= 10; i++) {
			rp.getMobilefield().sendKeys(Keys.BACK_SPACE);
		}

		rp.getMobilefield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		//Thread.sleep(2000);
		rp.getUsernamefield().clear();
		rp.getUsernamefield().sendKeys(testData.get("username"));
		log.debug("Entered UserName");
		rp.getConfirmusernamefield().clear();
		//Thread.sleep(2000);
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");
		//Thread.sleep(3000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		
		
		base.waitForElementVisibility2(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"),Duration.ofSeconds(60), "namefield", driver);
		String actualNotConfirmuserMessage =driver
				.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']")).getText();

		String expectedMessage = "Username and ConfirmUserName does not match!";
		Assert.assertEquals(actualNotConfirmuserMessage, expectedMessage);
		Thread.sleep(500);
       // rp.getCloseicon().click();
	}

	@Test(priority = 3)
	public void IncorrectConfirmUsernameField() throws Exception {
		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60), "namefield", driver);
		rp.NameField.clear();
		rp.NameField.sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
	
		//Thread.sleep(2000);
		rp.getEmailfield().clear();
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		//Thread.sleep(2000);
		for (int i = 1; i <= 10; i++) {
			rp.getMobilefield().sendKeys(Keys.BACK_SPACE);
		}
		rp.getMobilefield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		//Thread.sleep(2000);
		rp.getUsernamefield().clear();
		rp.getUsernamefield().sendKeys(testData.get("username"));
		log.debug("Entered UserName");
		//Thread.sleep(2000);
		rp.getConfirmusernamefield().clear();
		rp.getConfirmusernamefield().sendKeys("Saayyu2907");
		log.debug("Entered ConfirmUserName");
		//Thread.sleep(2000);
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");
		//Thread.sleep(3000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		//Thread.sleep(3000);
		 base.waitForElementVisibility(rp.getConfirmmessgae(),Duration.ofSeconds(60), "confirmmessage", driver);
		String actualNotConfirmuserMessage = driver
				.findElement(By.xpath("//div[text( )='Username and ConfirmUserName does not match!']")).getText();

		String expectedMessage = "Username and ConfirmUserName does not match!";
		Assert.assertEquals(actualNotConfirmuserMessage, expectedMessage);
		Thread.sleep(500);
       // rp.getCloseicon().click();
	}                                       

	@Test(priority = 4)
	public void WithoutSelectingCheckBoxRegistration() throws Exception {

		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60), "namefield", driver);
		rp.NameField.clear();
		rp.NameField.sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		//Thread.sleep(2000);
	
		rp.getEmailfield().clear();
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		//Thread.sleep(2000);
		for (int i = 1; i <= 10; i++) {
			rp.getMobilefield().sendKeys(Keys.BACK_SPACE);
		}
		rp.getMobilefield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		//Thread.sleep(2000);
		rp.getUsernamefield().clear();
		rp.getUsernamefield().sendKeys(testData.get("username"));
		log.debug("Entered UserName");
		//Thread.sleep(2000);
		rp.getConfirmusernamefield().clear();
		rp.getConfirmusernamefield().sendKeys(testData.get("username"));
		log.debug("Entered ConfirmUserName");
		//Thread.sleep(3000);
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		//Thread.sleep(3000);
		 base.waitForElementVisibility(rp.getCheckboxmessage(),Duration.ofSeconds(60), "checkboxmessage", driver);

		String actualCheckboxMessage = driver
				.findElement(By.xpath("//p[text( )='Please check this box if you want to Proceed!']")).getText();

		String expectedMessage = "Please check this box if you want to Proceed!";
		Assert.assertEquals(actualCheckboxMessage, expectedMessage);

	}

	@Test(priority = 5)
	public void WithoutDataRegistration() throws Exception {

		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60), "namefield", driver);
		rp.NameField.clear();
	
		log.debug("Entered Name");
		rp.getEmailfield().clear();
				log.debug("Entered Email Address");
		for (int i = 1; i <= 10; i++) {
			rp.getMobilefield().sendKeys(Keys.BACK_SPACE);
		}
		
	
		log.debug("Cleared Phone Number");
		rp.getUsernamefield().clear();
		
		log.debug("Entered UserName");
		rp.getConfirmusernamefield().clear();
	
		log.debug("Entered ConfirmUserName");
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");

		//Thread.sleep(3000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		//Thread.sleep(5000);

	}

	@Test(priority = 6)
	public void ClickHelp() throws InterruptedException {

		RegistrationPage rp = new RegistrationPage(driver);

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(rp.getClickHelp()).perform();

		String actualClickhelpMessage = driver.findElement(By.xpath("//div[@class='TooltipAuth_tooltip__2E_rf']"))
				.getText();

		String expectedClickhelpMessage = "Click to send us an email info@aanksolutions.in";
		Assert.assertEquals(actualClickhelpMessage, expectedClickhelpMessage);

	}

	@Test(priority = 7)
	public void RegistrationwithImUser() throws Exception {

		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		 base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60), "Name field", driver);
		rp.NameField.clear();
		rp.NameField.sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		//Thread.sleep(1000);
		
		rp.getEmailfield().clear();
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		//Thread.sleep(1000);
		for (int i = 1; i <= 10; i++) {
			rp.getMobilefield().sendKeys(Keys.BACK_SPACE);
		}
		rp.getMobilefield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		//Thread.sleep(1000);
		rp.getUsernamefield().clear();
		rp.getUsernamefield().sendKeys(testData.get("username"));
		log.debug("Entered UserName");
		//Thread.sleep(1000);
		rp.getConfirmusernamefield().clear();
		rp.getConfirmusernamefield().sendKeys(testData.get("username"));
		log.debug("Entered ConfirmUserName");
		//Thread.sleep(1000);
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");
		//Thread.sleep(2000);

		rp.getClickImAlreadyUSer().click();

		VerifyregisterPage vp = new VerifyregisterPage(driver);

		String actual = null;
		try {
			if (vp.getVerifypageofIamAlreadyuser().isDisplayed()) {
				log.debug("user go to the login Page");
				actual = "successful";
			} else {
				log.debug("User didn't go to login page");
				actual = "failure";
			}
		} catch (Exception e) {
			log.debug("User didn't go to login page");
			actual = "failure";
		}
		Assert.assertTrue(actual.equals("successful"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
