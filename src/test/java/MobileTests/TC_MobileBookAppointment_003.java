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
import MedoPractApp.MedoPractApp.pageObjects.BookAppointmentPage;
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

public class TC_MobileBookAppointment_003 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileBookAppointment_003.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();

	}

	@Test(priority = 1)
	public void BookAppointmentTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		BookAppointmentPage abp = new BookAppointmentPage(driver);
		Thread.sleep(3000);
		abp.getClickBookAppointment().click();
		Thread.sleep(2000);
		abp.getFullNameField().sendKeys(testData.get("BookAppointment_FullName"));
		Thread.sleep(2000);
		abp.getPhoneNoField().sendKeys(testData.get("BookAppointment_MobileNumber"));
		Thread.sleep(5000);
		abp.getClickVisitReasonField().sendKeys(testData.get("BookAppointment_VisitReason"));
		Thread.sleep(3000);
		abp.getClickConfirmAppointment().click();
		Thread.sleep(5000);	
		
		String AppointmentValue = abp.getAppointmentBookMessage().getText();
		Assert.assertEquals(AppointmentValue, "Appointment Booked Successfully!!");

		abp.getAppointmentBookOkMessage().click();
		Thread.sleep(2000);	
		
	}
	
	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}
	
	// Editing Appointment
	// Cancelling Appointment
}
	
	
	
	
	
	
	
	
	
	


