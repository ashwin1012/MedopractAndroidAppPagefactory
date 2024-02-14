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
import MedoPractApp.MedoPractApp.pageObjects.LoginPage;
import MedoPractApp.MedoPractApp.pageObjects.RegistrationPage;
import MedoPractApp.MedoPractApp.pageObjects.SearchPatientPage;
import MedoPractApp.MedoPractApp.pageObjects.TodolistPage;

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

public class TC_MobileSearchPatientTest_008 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileSearchPatientTest_008.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		//base = new Base();

	}

	@Test(priority = 1)
	public void SearchPatientTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		SearchPatientPage sp = new SearchPatientPage(driver);
		
		
		sp.getClickMenu().click();
		Thread.sleep(2000);
	    sp.getPatientsClick().click();
        Thread.sleep(2000);
        sp.getSearchName().sendKeys("Akhil");
        Thread.sleep(2000);	
        String patientNameValue=sp.getResultValueClick().getText();
        	 Thread.sleep(2000);		
       // System.out.println(patientNameValue); To Add Assertion.

        sp.getResultValueClick().click();
        Thread.sleep(1000);	
        sp.getAboutPatientClick().click();
        Thread.sleep(1000);	
        sp.getPatientVisitButton().click();
        Thread.sleep(1000);	
        		 
	}

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

}
