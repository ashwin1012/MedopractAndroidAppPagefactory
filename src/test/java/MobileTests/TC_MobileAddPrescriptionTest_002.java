package MobileTests;

import java.io.IOException;

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
import MedoPractApp.MedoPractApp.pageObjects.AddPrescriptionPage;
import MedoPractApp.MedoPractApp.pageObjects.LoginPage;

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

public class TC_MobileAddPrescriptionTest_002 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileAddPrescriptionTest_002.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();

	}

	@Test(priority = 1)
	public void AddPrescriptionTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		AddPrescriptionPage ap = new AddPrescriptionPage(driver);
		Thread.sleep(7000);
		ap.getClickMenu().click();
		Thread.sleep(2000);
		ap.getClickingAddPrescriptionTab().click();
		Thread.sleep(2000);
		ap.getPatientNameField().sendKeys(testData.get("AddPrescription_Name"));
		Thread.sleep(5000);
		//ap.getPatientNameField().click();
		//Thread.sleep(10000);
		//ap.getPatientNameField().sendKeys(Keys.TAB);
		//Thread.sleep(2000);'-
		//ap.getPatientNameField().sendKeys(Keys.ENTER);
		ap.getEmailField().sendKeys(testData.get("AddPrescription_EmailId"));
		Thread.sleep(2000);
		ap.getMedicineNameField().sendKeys(testData.get("AddPrescription_MedicineField"));
		Thread.sleep(2000);
		ap.getTotalNumberDays().sendKeys(testData.get("AddPrescription_TotalNumberDays"));
		Thread.sleep(2000);
		ap.getTimingsInput().sendKeys(testData.get("AddPrescription_TimingsInput"));
		Thread.sleep(2000);
		ap.getAmountInput().sendKeys(testData.get("AddPrescription_AmountInput"));
		Thread.sleep(2000);
		//ap.getPlusSign().click();
		//Thread.sleep(20000);
		// add cancel code
		ap.getSaveAndPrintButton().click();
		Thread.sleep(5000);

	}

	
	public void tearDown() throws IOException {

		//driver.quit();
	}

}
