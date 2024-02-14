package Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Report;

import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.ReportPage;

public class TC_ReportsTest_012 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws Exception {
		log = LogManager.getLogger(TC_ReportsTest_012.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");
		 base = new Base(); 

	}

	@Test(priority = 1)
	public void Reports() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		ReportPage rp = new ReportPage(driver);

		DateFormat formatdate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date systemDate = new Date(0);
		String dateofSystem = formatdate.format(systemDate);

		//Thread.sleep(2000);
		
		waitForElementVisibility(rp.getClickReports(), Duration.ofSeconds(60), "AddPatient", driver);
		rp.getClickReports().click();
		log.debug("Clicked on Reports");
		// Thread.sleep(3000);
		waitForElementVisibility(rp.getClickAddPatient(), Duration.ofSeconds(60), "AddPatient", driver);
		rp.getClickAddPatient().click();
		log.debug("Clicked on Add Patient");
	
		// Thread.sleep(3000);
		rp.getPatientNameField().sendKeys(testData.get("Reports_Name"));
		log.debug("Entering Name");
		//Thread.sleep(3000);
		rp.getPhonenumberField().sendKeys(testData.get("Reports_MobileNumber"));
		log.debug("Entering PhoneNumber");
		//Thread.sleep(3000);
		rp.getBirthdateClick().click();
		log.debug("Clicked on Birthdate Calender");
		//Thread.sleep(3000);
		rp.getDay().sendKeys(testData.get("Reports_Birthdate"));
		log.debug("Clicked on Birthdate Calender Date");
		//Thread.sleep(3000);
		rp.getMonth().sendKeys(testData.get("Reports_BirthMonth"));
		log.debug("Clicked on Birthdate Calender month");
		//Thread.sleep(3000);
		rp.getYear().sendKeys(testData.get("Reports_BirthYear"));
		log.debug("Clicked on Birthdate Calender year");
		//Thread.sleep(3000);
		log.debug("Clicked on Gender");

		Select select = new Select(rp.getGender());

		select.selectByVisibleText("Male");

		log.debug("Clicked on bloodgroup");
		//Thread.sleep(3000);

		Select select1 = new Select(rp.getBloodgroup());
		select1.selectByVisibleText("A+");

		rp.getOccupationField().sendKeys(testData.get("Reports_Occupation"));
		log.debug("Entering QA value");
		//Thread.sleep(3000);
		rp.getAddressField().sendKeys(testData.get("Reports_Address"));
		log.debug("Entering Address");
		//Thread.sleep(3000);
		rp.getEmergencyField().sendKeys(testData.get("Reports_EmergencyNum"));
		log.debug("Entering Emergency Number");
		//Thread.sleep(3000);
		rp.getAllergiesField().sendKeys(testData.get("Reports_Allergies"));
		log.debug("Entering Value");
		//Thread.sleep(3000);
		rp.getHistoryField().sendKeys(testData.get("Reports_History"));
		log.debug("Entering Value");
		//Thread.sleep(3000);
		//rp.getHabitsField().sendKeys(testData.get("Reports_Habits"));
		//log.debug("Entering Value");
		//Thread.sleep(3000);
		rp.getClickingPlusSign().click();
		log.debug("Clicked on Plus Sign");
		//Thread.sleep(3000);
		//rp.getHabitsField().sendKeys(testData.get("Reports_Habits2"));
		//log.debug("Entered Habits value");
		//Thread.sleep(3000);
		rp.getClickSaveButton().click();
		log.debug("Clicking Save Button");
		Thread.sleep(12000);
		//waitForElementVisibility(rp.getClosebuttonreports(), Duration.ofSeconds(60), "AddPatient", driver);
		//rp.getClosebuttonreports().click();

	}

	@Test(priority = 2)
	public void PatientsTab() throws Exception {

		ReportPage rp = new ReportPage(driver);
		waitForElementVisibility(rp.getClickReports(), Duration.ofSeconds(60), "AddPatient", driver);
		Thread.sleep(1000);
		rp.getClickReports().click();
		//Thread.sleep(3000);
		log.debug("Clicked on Reports");
		rp.getYearlyTab().click();
		log.debug("Clicked on Yrly Tab");
		//Thread.sleep(3000);
		rp.getMonthlyTab().click();
		log.debug("Clicked on Monthly Tab");
		//Thread.sleep(3000);
		rp.getWeeklyTab().click();
		log.debug("Clicked on Weekly Tab");
		//Thread.sleep(3000);
		rp.getDailyTab().click();
		log.debug("Clicked on Daily Tab");
		//Thread.sleep(8000);

	}

	@Test(priority = 3)
	public void Cancel() throws Exception {

		ReportPage rp = new ReportPage(driver);
		waitForElementVisibility(rp.getClickReports(), Duration.ofSeconds(60), "AddPatient", driver);
		rp.getClickReports().click();
		// Thread.sleep(3000);
		log.debug("Clicked on Reports");
		waitForElementVisibility(rp.getCancelButton(), Duration.ofSeconds(60), "AddPatient", driver);
		// Thread.sleep(3000);
		rp.getCancelButton().click();
		log.debug("Clicked on Cancel");
		//Thread.sleep(8000);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
