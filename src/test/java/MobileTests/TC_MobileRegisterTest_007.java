package MobileTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MedoPractApp.MedoPractApp.Resources.Base;
import MedoPractApp.MedoPractApp.pageObjects.RegistrationPage;

//import pageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class TC_MobileRegisterTest_007 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileRegisterTest_007.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();

	}

	@Test(priority = 1)
	public void RegisterTest() throws Exception {

		RegistrationPage rp = new RegistrationPage(driver);
		Thread.sleep(10000);
		rp.getClickRegister().click();
		Thread.sleep(2000);
		rp.getFirstNameField().sendKeys(testData.get("FirstName"));
		Thread.sleep(2000);
		rp.getLastNameField().sendKeys(testData.get("LastName"));
		Thread.sleep(2000);
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		Thread.sleep(2000);
		rp.getPhoneNofield().sendKeys(testData.get("Mobilenumber"));
		Thread.sleep(2000);
		String Username = testData.get("username") + Base.randomNumber();
		rp.getUsernamefield().sendKeys(Username);
		Thread.sleep(2000);
		rp.getConfirmusernamefield().sendKeys(Username);
		Thread.sleep(2000);
		rp.getAgreetermcheckbox().click();
		Thread.sleep(2000);
		rp.getClickregisterbutton().click();
		Thread.sleep(8000);

		String RegistrationMessage = rp.getRegisterMesssage().getText();
		Assert.assertEquals(RegistrationMessage, "Registration Successful!");

		rp.getOKRegistermmessage().click();

	}

	@Test(priority = 2)
	public void NotConfirmUsernameField() throws Exception {
		RegistrationPage rp = new RegistrationPage(driver);
		Thread.sleep(5000);
		rp.getClickRegister().click();
		Thread.sleep(2000);
		log.debug("Clicked RegisterNow Button");
		// base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60),
		// "namefield", driver);

		rp.getFirstNameField().sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		Thread.sleep(2000);
		rp.getLastNameField().sendKeys(testData.get("LastName"));
		Thread.sleep(2000);

		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		Thread.sleep(2000);

		rp.getPhoneNofield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		// Thread.sleep(2000);

		rp.getUsernamefield().sendKeys(testData.get("username"));
		log.debug("Entered UserName");

		// Thread.sleep(2000);
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");
		// Thread.sleep(3000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		// base.waitForElementVisibility2(By.xpath("//div[@class='react-toast-notifications__toast__content
		// css-1ad3zal']"),Duration.ofSeconds(60), "namefield", driver);
		// String actualNotConfirmuserMessage =
		// driver.findElement(By.xpath("")).getText();

		// String expectedMessage = "Required Field";
		// Assert.assertEquals(actualNotConfirmuserMessage, expectedMessage);
		Thread.sleep(500);

	}

	@Test(priority = 3)
	public void IncorrectConfirmUsernameField() throws Exception {
		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		// base.waitForElementVisibility(rp.NameField, Duration.ofSeconds(60),
		// "namefield", driver);
		rp.getFirstNameField().clear();
		rp.getFirstNameField().sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		Thread.sleep(2000);
		rp.getLastNameField().clear();
		rp.getLastNameField().sendKeys(testData.get("LastName"));
		Thread.sleep(2000);
		rp.getEmailfield().clear();
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		Thread.sleep(2000);
		rp.getPhoneNofield().clear();
		rp.getPhoneNofield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		// Thread.sleep(2000);
		rp.getUsernamefield().clear();
		String Username = testData.get("username") + Base.randomNumber();
		rp.getUsernamefield().sendKeys(Username);
		log.debug("Entered UserName");
		// rp.NameField.sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		String ConfirmUsername = testData.get("username") + Base.randomNumber();
		rp.getConfirmusernamefield().sendKeys(ConfirmUsername);
		// Thread.sleep(2000);

		// Thread.sleep(3000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		// Thread.sleep(3000);
		// base.waitForElementVisibility(rp.getConfirmmessgae(), Duration.ofSeconds(60),
		// "confirmmessage", driver);
		// String actualNotConfirmuserMessage =
		// driver.findElement(By.xpath("")).getText();

		// String expectedMessage = "Username not matching!";
		// Assert.assertEquals(actualNotConfirmuserMessage, expectedMessage);
		Thread.sleep(500);
		// rp.getCloseicon().click();
	}

	@Test(priority = 4)
	public void WithoutSelectingCheckBoxRegistration() throws Exception {

		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		// base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60),
		// "namefield", driver);
		rp.getFirstNameField().clear();
		rp.getFirstNameField().sendKeys(testData.get("FirstName"));
		log.debug("Entered Name");
		// Thread.sleep(2000);

		rp.getEmailfield().clear();
		rp.getEmailfield().sendKeys(testData.get("Email_Id"));
		log.debug("Entered Email Address");
		// Thread.sleep(2000);
		rp.getPhoneNofield().clear();
		rp.getPhoneNofield().sendKeys(testData.get("Mobilenumber"));
		log.debug("Entered Phone Number");
		// Thread.sleep(2000);
		rp.getUsernamefield().clear();
		String Username = testData.get("username") + Base.randomNumber();
		rp.getUsernamefield().sendKeys(Username);
		log.debug("Entered UserName");
		// Thread.sleep(2000);
		rp.getConfirmusernamefield().clear();
		rp.getConfirmusernamefield().sendKeys(testData.get("username"));
		log.debug("Entered ConfirmUserName");
		// Thread.sleep(3000);
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		// Thread.sleep(3000);
		// base.waitForElementVisibility(rp.getCheckboxmessage(),Duration.ofSeconds(60),
		// "checkboxmessage", driver);

		// String actualCheckboxMessage = driver
		// .findElement(By.xpath("")).getText();

		// String expectedMessage = "Please check this box if you want to Proceed!";
		// Assert.assertEquals(actualCheckboxMessage, expectedMessage);

	}

	@Test(priority = 5)
	public void WithoutDataRegistration() throws Exception {

		RegistrationPage rp = new RegistrationPage(driver);

		log.debug("Clicked RegisterNow Button");
		// base.waitForElementVisibility(rp.NameField,Duration.ofSeconds(60),
		// "namefield", driver);
		rp.getFirstNameField().clear();
		log.debug("Cleared Name");
		rp.getLastNameField().clear();
		log.debug("Cleared Last Name");
		rp.getEmailfield().clear();
		log.debug("Cleared Email Address");

		rp.getPhoneNofield().clear();
		log.debug("Cleared Phone Number");

		rp.getUsernamefield().clear();

		log.debug("Entered UserName");
		rp.getConfirmusernamefield().clear();

		log.debug("Entered ConfirmUserName");
		rp.getAgreetermcheckbox().click();
		log.debug("Clicked Checkbox");

		// Thread.sleep(3000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		// Thread.sleep(5000);

	}
	
	@Test(priority = 6)
	public void ClickHelp() throws InterruptedException {

		RegistrationPage rp = new RegistrationPage(driver);

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.moveToElement(rp.getMobileClickHelp()).perform();

		//String actualClickhelpMessage = driver.findElement(By.xpath("//div[@class='TooltipAuth_tooltip__2E_rf']"))
				//.getText();

		//String expectedClickhelpMessage = "Click to send us an email info@aanksolutions.in";
		//Assert.assertEquals(actualClickhelpMessage, expectedClickhelpMessage);

	}

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

}
