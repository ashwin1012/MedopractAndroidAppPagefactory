package MobileTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MedoPractApp.MedoPractApp.Resources.Base;
import MedoPractApp.MedoPractApp.pageObjects.LoginPage;
import MedoPractApp.MedoPractApp.pageObjects.RegistrationPage;
import MedoPractApp.MedoPractApp.pageObjects.SearchPatientPage;
import MedoPractApp.MedoPractApp.pageObjects.TodolistPage;

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

public class TC_MobilePatientVisit_009 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobilePatientVisit_009.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();

	}

	@Test(priority = 1)
	public void PatientVisitTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		SearchPatientPage sp = new SearchPatientPage(driver);
		sp.getClickMenu().click();
		Thread.sleep(3000);
		sp.getPatientsClick().click();
		Thread.sleep(2000);
		sp.getSearchName().sendKeys(testData.get("Mobile_PatientVisit_Name"));
		Thread.sleep(2000);
		String patientNameValue = sp.getResultValueClick().getText();
		Thread.sleep(2000);
		// System.out.println(patientNameValue); To Add Assertion.

		sp.getResultValueClick().click();
		Thread.sleep(1000);
		sp.getAboutPatientClick().click();
		Thread.sleep(1000);
		sp.getPatientVisitButton().click();
		Thread.sleep(3000);
		sp.getClickPrimaryComplaint().sendKeys(testData.get("Mobile_PrimaryComplaint"));
		Thread.sleep(1000);
		sp.getPatientvisitDateTimeField().click();
		Thread.sleep(1000);
		sp.getOkButton().click();
		Thread.sleep(1000);
		sp.getClickTimeOkButtonPV().click();
		Thread.sleep(3000);
		sp.getAddSymptoms().sendKeys(testData.get("Mobile_AddSymptoms"));
		Thread.sleep(3000);
		sp.getAddClinicalObservation().sendKeys(testData.get("Mobile_AddClinicalObservation"));
		Thread.sleep(1000);
		sp.getAddDiagnosisRemarks().sendKeys(testData.get("Mobile_AddDiagnosisRemarks"));
		Thread.sleep(1000);
		//sp.getAddBloodPressure().sendKeys(testData.get("Mobile_AddBloodPressure"));
		//Thread.sleep(1000);
		//sp.getAddSugarLevel().sendKeys(testData.get("Mobile_AddSugarLevel"));
		//Thread.sleep(1000);
		//sp.getAddHeartRate().sendKeys(testData.get("Mobile_AddHeartRate"));
		//Thread.sleep(1000);
		sp.getAddInvestigations().sendKeys(testData.get("Mobile_AddInvestigations"));
		Thread.sleep(1000);
		sp.getAddSymptoms().sendKeys(testData.get("Mobile_AddSymptoms"));
		Thread.sleep(1000);
		sp.getClickSaveButton().click();
		Thread.sleep(5000);
		
		String PatientVisitValue = sp.getPatientVisitMessageValidation().getText();
		Assert.assertEquals( PatientVisitValue, "Visit Added Successfully!");
		
		
		sp.getOKButtonPatientVisit().click();
		
	}

	@Test(priority = 2)

	public void PatientVisitTestWithoutPrimarycomplaint() throws Exception {

		//LoginPage lp = new LoginPage(driver);
		//lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//Thread.sleep(10000);
		SearchPatientPage sp = new SearchPatientPage(driver);
		Thread.sleep(3000);
		sp.getPatientVisitButton().click();
		Thread.sleep(3000);
	    sp.getPatientvisitDateTimeField().click();
		Thread.sleep(1000);
		sp.getOkButton().click();
		Thread.sleep(1000);
		sp.getClickTimeOkButtonPV().click();
		Thread.sleep(3000);
		sp.getAddSymptoms().sendKeys(testData.get("Mobile_AddSymptoms"));
		Thread.sleep(3000);
		sp.getAddClinicalObservation().sendKeys(testData.get("Mobile_AddClinicalObservation"));
		Thread.sleep(1000);
		sp.getAddDiagnosisRemarks().sendKeys(testData.get("Mobile_AddDiagnosisRemarks"));
		Thread.sleep(1000);
		//sp.getAddBloodPressure().sendKeys(testData.get("Mobile_AddBloodPressure"));
		//Thread.sleep(1000);
		//sp.getAddSugarLevel().sendKeys(testData.get("Mobile_AddSugarLevel"));
		//Thread.sleep(1000);
		//sp.getAddHeartRate().sendKeys(testData.get("Mobile_AddHeartRate"));
		//Thread.sleep(1000);
		sp.getAddInvestigations().sendKeys(testData.get("Mobile_AddInvestigations"));
		Thread.sleep(1000);
		sp.getAddSymptoms().sendKeys(testData.get("Mobile_AddSymptoms"));
		Thread.sleep(1000);
		sp.getClickSaveButton().click();
		Thread.sleep(5000);
		
		//String PatientVisitValue = sp.getPatientVisitMessageValidation().getText();
		//Assert.assertEquals( PatientVisitValue, "Visit Added Successfully!");
		
		//followup

	}

	/*
	 * @Test(priority = 3)
	 * 
	 * public void PatientVisitWithoutDate() throws Exception {
	 * driver.navigate().refresh(); PatientVisitPage ppv = new
	 * PatientVisitPage(driver);
	 * base.waitForElementVisibility(ppv.getPatientvisitClick(),
	 * Duration.ofSeconds(60), "patientName", driver);
	 * ppv.getPatientvisitClick().click();
	 * log.debug("Clicked on Patient visit Tab"); //Thread.sleep(3000);
	 * base.waitForElementVisibility(ppv.getPatientName(), Duration.ofSeconds(60),
	 * "patientName", driver); ppv.getPatientName().clear();
	 * ppv.getPatientName().sendKeys(testData.get("PatientVisit_Name")); //
	 * Thread.sleep(2000); base.waitForElementVisibility(ppv.getPatientName(),
	 * Duration.ofSeconds(60), "patientName", driver);
	 * ppv.getPatientName().sendKeys(Keys.ENTER); Thread.sleep(2000);
	 * driver.findElement(By.xpath("//li[text()='sonam']")).click();
	 * log.debug("Clicked on Patient visit Tab");
	 * base.waitForElementVisibility(ppv.getDateClick2(), Duration.ofSeconds(60),
	 * "patientName", driver); //Thread.sleep(3000); ppv.getDateClick2().click();
	 * Thread.sleep(2000); for (int i = 1; i <= 10; i++) {
	 * ppv.getAfterDateClick().sendKeys(Keys.BACK_SPACE);
	 * 
	 * } //Thread.sleep(2000);
	 * ppv.getPrimaryComplaint().sendKeys(testData.get("PrimaryComplaint"));
	 * log.debug("Clicked on Primary Complaint Tab"); //Thread.sleep(3000);
	 * ppv.getSymptoms().sendKeys(testData.get("Symptoms"));
	 * log.debug("Clicked on Primary Complaint Tab"); //Thread.sleep(3000); //
	 * ppv.getClickingPlusSign().click(); //by.name
	 * log.debug("Clicked on Plus Sign"); //Thread.sleep(2000);
	 * ppv.getInvestigationTests().sendKeys(testData.get("InvestigationTests1"));
	 * log.debug("Clicked on Investigation tests"); //Thread.sleep(3000);
	 * ppv.getSaveButton().click(); log.debug("Clicked on Save Button");
	 * Thread.sleep(5000);
	 * 
	 * String actualDisplayMessage1 =
	 * driver.findElement(By.xpath("//div[text( )='Please add Date & Time']"))
	 * .getText();
	 * 
	 * String expectedDisplayMessage1 = "Please add Date & Time";
	 * Assert.assertEquals(actualDisplayMessage1, expectedDisplayMessage1);
	 * 
	 * }
	 */

	

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

}
