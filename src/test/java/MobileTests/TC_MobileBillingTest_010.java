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
import MedoPractApp.MedoPractApp.pageObjects.BillingPage;
import MedoPractApp.MedoPractApp.pageObjects.LoginPage;


//import pageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


 
public class TC_MobileBillingTest_010 extends Base {
	
	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileBillingTest_010.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();
		
	}
	@Test(priority = 1)
	public void GenerateBillTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		BillingPage bp = new BillingPage(driver);
		Thread.sleep(10000);
		bp.getClickMenu().click();
		Thread.sleep(2000);
		//waitForElementVisibility(app.getPatientsClick(), 10, "AddPatient", driver);
		bp.getBillingClick().click();
		Thread.sleep(2000);
		bp.getPatientsNameField().sendKeys(testData.get("Billing_AddPatient_Name"));
		Thread.sleep(2000);
		bp.getBedNumber().sendKeys(testData.get("Billing_Bed_Number"));
		Thread.sleep(2000);
		bp.getAdmissionDate().click();
		Thread.sleep(2000);
		bp.getOKButton().click();
		
		Thread.sleep(2000);
		bp.getDischargeDate().click();
		Thread.sleep(2000);
		bp.getOKButton().click();
		
		Thread.sleep(2000);
		
		bp.getDescription().sendKeys(testData.get("Billing_Description"));
		Thread.sleep(1000);
		
		bp.getQuantity().sendKeys(testData.get("Billing_Quantity"));
		Thread.sleep(1000);
		
		bp.getRate().sendKeys(testData.get("Billing_Rate"));
		Thread.sleep(1000);
		//bp.getCancelButton().click();
		Thread.sleep(1000);
		bp.getGenerateBillButton().click();
		
		// Assertion to Put
	}
	
	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}
		

}
