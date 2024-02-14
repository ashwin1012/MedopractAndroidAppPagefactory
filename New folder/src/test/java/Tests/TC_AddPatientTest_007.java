package Tests;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.AddPatientPage;
import pageObjects.AppointmentCalenderPage;
import pageObjects.LoginPage;

public class TC_AddPatientTest_007 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException {
		log = LogManager.getLogger(TC_AddPatientTest_007.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");
		 base = new Base(); 


	}

	@Test(priority = 1)
	public void AddPatientWithMandatoryField() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);

		AddPatientPage app = new AddPatientPage(driver);

		DateFormat formatdate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date systemDate = new Date(0);
		String dateofSystem = formatdate.format(systemDate);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		app.getPatientNameField().sendKeys(testData.get("AddPatient_Name"));
		log.debug("Entered Name");
		//Thread.sleep(3000);
	
		app.getPhoneNoField().sendKeys(testData.get("AddPatient_MobileNumber"));
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);
		app.getBirthdateClick().click();
		log.debug("Clicked on Birthdate Calender");
		//Thread.sleep(3000);
		app.getDay().sendKeys("15");
		log.debug("Clicked on Birthdate Calender Date");
		//Thread.sleep(3000);
		app.getMonth().sendKeys("09");
		log.debug("Clicked on Birthdate Calender month");
		//Thread.sleep(3000);
		app.getYear().sendKeys("2022");
		log.debug("Clicked on Birthdate Calender year");
		//Thread.sleep(3000);
		log.debug("Clicked on Gender");

		Select select = new Select(app.getGender());

		select.selectByVisibleText("Male");

		log.debug("Clicked on bloodgroup");
		//Thread.sleep(3000);

		Select select1 = new Select(app.getBloodgroup());
		select1.selectByVisibleText("A+");

		app.getOccupationField().sendKeys(testData.get("occupation"));
		log.debug("Entered Occupation");
		//Thread.sleep(3000);
		app.getEmergencyField().sendKeys(testData.get("EmergencyNumber"));
		log.debug("Entered emergencyNumber");
		//Thread.sleep(3000);
		app.getAllergiesField().sendKeys(testData.get("Allergies"));
		log.debug("Entered Acidity");
		//Thread.sleep(3000);
		app.getRemarksField().sendKeys(testData.get("Remarks"));
		log.debug("Entered Remark value");
		//Thread.sleep(3000);
		app.getHistoryField().sendKeys(testData.get("History"));
		log.debug("Entered History value");
		//Thread.sleep(3000);
		app.getHabitsField().sendKeys(testData.get("Habits1"));
		log.debug("Entered Habits value");
		//Thread.sleep(3000);
		app.getClickingPlusSign().click();
		log.debug("Clicked on Plus Sign");
		//Thread.sleep(3000);
		app.getHabitsField().sendKeys(testData.get("Habits2"));
		log.debug("Entered Habits value");
		//Thread.sleep(3000);
		WebElement chooseFile = driver.findElement(By.xpath("//*[@id='fileButton']"));
		chooseFile.sendKeys(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Issue_While Running Browser.png");
		
			
		app.getSaveButton().click();
		log.debug("Clicked on Save Button");
		//Thread.sleep(3000);
		
		base.waitForElementVisibility(app.getAddPatientMessage(), Duration.ofSeconds(150), "AddPatient", driver);
        Thread.sleep(1000);
		String actualDisplayMessage = driver
				.findElement(By.xpath("//div[text()='Patient Record created successfully!']")).getText();

		String expectedDisplayMessage = "Patient Record created successfully!";
		Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);

		app.getPatientsClick().click();

	}

	@Test(priority = 2)
	public void ResetButtonWithData() throws Exception {
		driver.navigate().refresh();

		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		app.getPatientNameField().clear();
		app.getPatientNameField().sendKeys(testData.get("AddPatient_Name"));
		log.debug("Entered Name");
		//Thread.sleep(3000);
		app.getPhoneNoField().clear();
		app.getPhoneNoField().sendKeys(testData.get("AddPatient_MobileNumber"));
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);
		
		app.getOccupationField().clear();
		app.getOccupationField().sendKeys(testData.get("occupation"));
		log.debug("Entered Occupation");
		//Thread.sleep(3000);
		app.getEmergencyField().clear();
		app.getEmergencyField().sendKeys(testData.get("EmergencyNumber"));
		log.debug("Entered emergencyNumber");
		//Thread.sleep(3000);
		app.getAllergiesField().clear();
		app.getAllergiesField().sendKeys(testData.get("Allergies"));
		log.debug("Entered Acidity");
		//Thread.sleep(3000);
		app.getRemarksField().clear();
		app.getRemarksField().sendKeys(testData.get("Remarks"));
		log.debug("Entered Remark value");
		//Thread.sleep(3000);
		app.getHabitsField().clear();
		app.getHabitsField().sendKeys(testData.get("Habits1"));
		log.debug("Entered Habits value");
		//Thread.sleep(3000);
		app.getResetButton().click();
		log.debug("Clicked on reset Button");
		//Thread.sleep(3000);

		app.getPatientsClick().click();

	}

	@Test(priority = 3)
	public void ResetButtonWithoutData() throws Exception {
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		app.getPatientNameField().sendKeys("");
		log.debug("Entered Name");
		//Thread.sleep(3000);
		app.getPhoneNoField().sendKeys("");
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);
		app.getOccupationField().sendKeys("");
		log.debug("Entered Occupation");
		//Thread.sleep(3000);
		app.getEmergencyField().sendKeys("");
		log.debug("Entered emergencyNumber");
		//Thread.sleep(3000);
		app.getAllergiesField().sendKeys("");
		log.debug("Entered Acidity");
		//Thread.sleep(3000);
		app.getRemarksField().sendKeys("");
		log.debug("Entered Remark value");
		//Thread.sleep(3000);
		app.getHabitsField().sendKeys("");
		log.debug("Entered Habits value");
		//Thread.sleep(3000);
		app.getResetButton().click();
		log.debug("Clicked on reset Button");
		//Thread.sleep(3000);

		app.getPatientsClick().click();
	}

	@Test(priority = 4)
	public void InValidDetails() throws Exception {
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		app.getPatientNameField().sendKeys(testData.get("AddPatient_NameInvalidDetails"));
		log.debug("Entered Name");
		//Thread.sleep(3000);
		app.getPhoneNoField().sendKeys(testData.get("AddPatient_MobileNumberInValidDetails"));
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);

		app.getPatientsClick().click();
	}

	@Test(priority = 5)
	public void PhoneFieldWithSpace() throws Exception {
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		app.getPatientNameField().clear();
		app.getPatientNameField().sendKeys(testData.get("AddPatient_Name"));
		log.debug("Entered Name");
		//Thread.sleep(3000);
		app.getPhoneNoField().sendKeys("");
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);

		app.getPatientsClick().click();
	}

	@Test(priority = 6)
	public void PhoneFieldEntering0() throws Exception {
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		app.getPatientNameField().clear();
		app.getPatientNameField().sendKeys(testData.get("AddPatient_Name"));
		log.debug("Entered Name");
		//Thread.sleep(3000);
		app.getPhoneNoField().sendKeys("0");
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);

		app.getPatientsClick().click();
	}

	@Test(priority = 7)
	public void PhoneNumberwithout10digits() throws Exception {
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		app.getPatientNameField().clear();
		app.getPatientNameField().sendKeys(testData.get("AddPatient_Name"));
		log.debug("Entered Name");
		//Thread.sleep(3000);
		
		app.getPhoneNoField().sendKeys("808736661");
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);

		app.getPatientsClick().click();

	}

	@Test(priority = 8)
	public void AddPatientWithoutMandatoryField() throws Exception {
		driver.navigate().refresh();
		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getPatientsClick().click();
		log.debug("Clicked on patients link");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientClick(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getAddPatientClick().click();
		log.debug("Clicked on AddpatientTab");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text( )='Reset']")).click();
		app.getPatientNameField().clear();
		app.getPatientNameField().sendKeys(testData.get("AddPatient_Name"));
		log.debug("Entered Name");
		//Thread.sleep(3000);
		
		app.getPhoneNoField().sendKeys("");
		log.debug("Entered PhoneNo");
		//Thread.sleep(3000);
		app.getOccupationField().sendKeys("");
		log.debug("Entered Occupation");
		//Thread.sleep(3000);
		app.getEmergencyField().clear();
		app.getEmergencyField().sendKeys(testData.get("EmergencyNumber"));
		log.debug("Entered emergencyNumber");
		//Thread.sleep(3000);
		app.getAllergiesField().clear();
		app.getAllergiesField().sendKeys(testData.get("Allergies"));
		log.debug("Entered Acidity");
		//Thread.sleep(3000);
		app.getRemarksField().clear();
		app.getRemarksField().sendKeys(testData.get("Remarks"));
		log.debug("Entered Remark value");
		//Thread.sleep(3000);
		app.getHabitsField().clear();
		app.getHabitsField().sendKeys(testData.get("Habits1"));
		log.debug("Entered Habits value");
		//Thread.sleep(3000);
		app.getSaveButton().click();
		log.debug("Clicked on Save Button");
		//Thread.sleep(3000);
		base.waitForElementVisibility(app.getAddPatientreqdinputmessage(), Duration.ofSeconds(150), "AddPatient", driver);
        
		String actualDisplayMessage = driver
				.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"))
				.getText();

		String expectedDisplayMessage = "Please provide required inputs";
		Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);

		app.getPatientsClick().click();
	}

	@Test(priority = 9)
	public void WithoutData() throws Exception {

		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getResetButton(), Duration.ofSeconds(150), "AddPatient", driver);
		app.getResetButton().click();

		//Thread.sleep(3000);
		app.getSaveButton().click();
		log.debug("Clicked on Save Button");
		//Thread.sleep(5000);

		base.waitForElementVisibility(app.getReqdinputmessage2(), Duration.ofSeconds(150), "AddPatient", driver);
		Thread.sleep(1000);
		String actualDisplayMessage1 = driver
				.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"))
				.getText();

		String expectedDisplayMessage1 = "Please provide required inputs";
		Assert.assertEquals(actualDisplayMessage1, expectedDisplayMessage1);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
