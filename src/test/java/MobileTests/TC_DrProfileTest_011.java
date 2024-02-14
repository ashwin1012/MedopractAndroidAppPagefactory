package MobileTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MedoPractApp.MedoPractApp.Resources.Base;
import MedoPractApp.MedoPractApp.pageObjects.DrProfilePage;
import MedoPractApp.MedoPractApp.pageObjects.LoginPage;

public class TC_DrProfileTest_011 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_DrProfileTest_011.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		// base = new Base();

	}

	@Test(priority = 1)
	public void DrProfileTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		DrProfilePage dpp = new DrProfilePage(driver);
		Thread.sleep(10000);
		dpp.getClickMenu().click();
		Thread.sleep(2000);
		dpp.getProfileClick().click();
		Thread.sleep(2000);
		dpp.getUpdateProfile().click();
		Thread.sleep(2000);
		dpp.getFirstName().sendKeys(testData.get("DocProfile_FirstName"));
		Thread.sleep(2000);
		dpp.getLastName().sendKeys(testData.get("DocProfile_LastName"));
		Thread.sleep(2000);
		dpp.getEmailId().sendKeys(testData.get("DocProfile_Email_Id"));
		Thread.sleep(2000);
		dpp.getDoctorId().sendKeys(testData.get("DocProfile_Doctor_Id"));
		Thread.sleep(2000);
		//dpp.getOKButton().click(); check it becoz calender date method left to add
		Thread.sleep(2000);
		dpp.getStudies().sendKeys(testData.get("DocProfile_Studies"));
		Thread.sleep(2000);
		dpp.getMobile().sendKeys(testData.get("DocProfile_Mobile"));
		Thread.sleep(2000);
		dpp.getPhone().sendKeys(testData.get("DocProfile_Phone"));
		Thread.sleep(2000);
		dpp.getFax().sendKeys(testData.get("DocProfile_Fax"));
		Thread.sleep(2000);
		dpp.getHospitalName().sendKeys(testData.get("DocProfile_HospitalName"));
		Thread.sleep(2000);
		dpp.getAddressLine1().sendKeys(testData.get("DocProfile_AddressLine1"));
		Thread.sleep(2000);
		dpp.getAddressLine2().sendKeys(testData.get("DocProfile_AddressLine2"));
		Thread.sleep(2000);
		dpp.getCountry().sendKeys(testData.get("DocProfile_Country"));
		Thread.sleep(2000);
		dpp.getCity().sendKeys(testData.get("DocProfile_City"));
		Thread.sleep(2000);
		dpp.getState().sendKeys(testData.get("DocProfile_State"));
		Thread.sleep(2000);
		dpp.getPostalCode().sendKeys(testData.get("DocProfile_PostalCode"));
		Thread.sleep(2000);
		dpp.getUpdateButton().click();
		Thread.sleep(5000);

	}

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}
}