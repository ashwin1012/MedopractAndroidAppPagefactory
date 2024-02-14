package Tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.AddPrescriptionPage;
import pageObjects.LoginPage;

public class TC_AddPrescriptionTest_010 extends Base {

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

	@Test(priority=1)
	public void AddPrescription() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		//Thread.sleep(2000);
		AddPrescriptionPage pp = new AddPrescriptionPage(driver);

		// driver.findElement(By.xpath("(//a[text()='Prescription'])[1]")).click();
		base.waitForElementVisibility(pp.getclickPrescriptionlink(), Duration.ofSeconds(150), "AddPatient", driver);
		pp.getclickPrescriptionlink().click();
		log.debug("Clicked on Link");
		//Thread.sleep(2000);
		pp.getPatientNameField().sendKeys(testData.get("AddPrescription_Name"));
		//Thread.sleep(2000);
		
		pp.getPatientNameField().sendKeys(Keys.ENTER);
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='sonam']")).click();

		log.debug("Entered Value in patientfield");
		//Thread.sleep(2000);
		pp.getEmailField().sendKeys(testData.get("AddPrescription_EmailId"));
		log.debug("Entered Value in emailfield");
		//Thread.sleep(2000);
	    pp.getMedicineNameField().sendKeys(testData.get("MedicineField"));
		log.debug("Entered Value as Dolo650");
		//Thread.sleep(2000);
		pp.getTotalNumberDays().sendKeys(testData.get("TotalNumberDays"));
		log.debug("Entered No of Days");
		//Thread.sleep(2000);
		pp.getTimingsInput().sendKeys(testData.get("TimingsInput"));
		log.debug("Entered Time Zone");
		//Thread.sleep(2000);
		pp.getAmountInput().sendKeys(testData.get("AmountInput"));
		log.debug("Entered Amount to be Taken");
		//Thread.sleep(5000);
		pp.getClickingPlusSign().click();
		log.debug("Clicked On Plus Sign");
		//Thread.sleep(2000);
		pp.getMedicineNameField().sendKeys(testData.get("MedicineField"));
		log.debug("Entered Value as Dolo650");
		//Thread.sleep(2000);
		pp.getTotalNumberDays().sendKeys(testData.get("TotalNumberDays"));
		log.debug("Entered No of Days");
		//Thread.sleep(2000);
		pp.getTimingsInput().sendKeys(testData.get("TimingsInput"));
		log.debug("Entered Time Zone");
		//Thread.sleep(2000);
		pp.getAmountInput().sendKeys(testData.get("AmountInput"));
		log.debug("Entered Amount to be Taken");
		//Thread.sleep(5000);
		pp.getPlusSign().click();
		//Thread.sleep(2000);
		pp.getSaveAndPrintButton().click();
		log.debug("Clicked On Save Button");
		//Thread.sleep(5000);
		base.waitForElementVisibility(pp.getSaveAndPrintButton(), Duration.ofSeconds(150), "AddPatient", driver);
		pp.getYesButton().click();
		
	}
	@Test(priority=2)
	public void Backbutton() {
		AddPrescriptionPage pp = new AddPrescriptionPage(driver);
		pp.getBackButton().click();
		log.debug("Clicked On Back Button");
		//Thread.sleep(4000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}

}
