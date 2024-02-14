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
import MedoPractApp.MedoPractApp.pageObjects.AddPatientPage;
import MedoPractApp.MedoPractApp.pageObjects.AddPrescriptionPage;
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

public class TC_MobileAddPatientTest_004 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileAddPatientTest_004.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();

	}

	@Test(priority = 1)
	public void AddPatientTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		AddPatientPage app = new AddPatientPage(driver);
		Thread.sleep(5000);
		//waitForElementVisibility(app.getPatientsClick(), 10, "AddPatient", driver);
		app.getPatientsClick().click();
		Thread.sleep(2000);
		app.getPatientNameField().sendKeys(testData.get("AddPatient_Name"));
		Thread.sleep(2000);
		app.getPhoneNoField().sendKeys(testData.get("AddPatient_MobileNumber"));
		Thread.sleep(2000);
		app.getRadioButton().click();
		Thread.sleep(2000);

		driver.findElement(By.id("com.clinic.myclinic.debug:id/etDOB")).click();
		Thread.sleep(2000);
		Date Now = new Date();

		DateFormat df = new SimpleDateFormat("dd MMMM yyyy ");
		df.format(Now);
		System.out.println(df.format(Now));
		driver.findElement(By.xpath("//android.view.View[@content-desc='" + df.format(Now).trim() + "']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))
				.click();
		Thread.sleep(2000);
		app.getOccupationField().sendKeys(testData.get("occupation"));
		Thread.sleep(2000);
		app.getEmergencyField().sendKeys(testData.get("EmergencyNumber"));
		Thread.sleep(2000);
		app.getAddressField().sendKeys("GauriHans");
		Thread.sleep(2000);
		app.getAllergiesField().sendKeys(testData.get("Allergies"));
		Thread.sleep(2000);
		app.getHistoryField().sendKeys(testData.get("History"));
		Thread.sleep(2000);
		app.getHabitsField().sendKeys(testData.get("Habits1") + "," + testData.get("Habits2"));
		Thread.sleep(2000);
		app.getRemarksField().sendKeys(testData.get("Remarks"));
		Thread.sleep(2000);
		app.getSaveButton().click();
		Thread.sleep(2000);

		String PatientValue = app.getAddPatientMessage().getText();
		Assert.assertEquals(PatientValue, "Patient Added Successfully!");

		app.getAddPatientOKMessage().click();

	}

	@Test(priority = 2)

	public void AddPatientTestWithoutData() throws Exception {

		//LoginPage lp = new LoginPage(driver);
		//lp.login(prop.getProperty("username"), prop.getProperty("password"));
		AddPatientPage app = new AddPatientPage(driver);
		Thread.sleep(5000);

		app.getPatientsClick().click();
		Thread.sleep(3000);
		
		app.getSaveButton().click();
		Thread.sleep(2000);


	}

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

}
