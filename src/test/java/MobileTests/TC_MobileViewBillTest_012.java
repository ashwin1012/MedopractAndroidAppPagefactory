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
import MedoPractApp.MedoPractApp.pageObjects.ViewBillPage;
//import MedoPractApp.MedoPractApp.pageObjects.AddPrescriptionPage;
import MedoPractApp.MedoPractApp.pageObjects.LoginPage;

//import pageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class TC_MobileViewBillTest_012 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileViewBillTest_012.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();

	}

	@Test(priority = 1)
	public void MobileViewBillTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
	    lp.login(prop.getProperty("username"), prop.getProperty("password"));
		ViewBillPage vbp = new ViewBillPage(driver);
		Thread.sleep(3000);
		vbp.getClickMenu().click();
		Thread.sleep(2000);
		//waitForElementVisibility(app.getPatientsClick(), 10, "AddPatient", driver);
		vbp.getBillingClick().click();
		Thread.sleep(2000);
		vbp.getPatientNameField().sendKeys(testData.get("ViewBill_PatientName"));
		Thread.sleep(2000);
		vbp.getClickNamelist().click();
		Thread.sleep(2000);



}
}
