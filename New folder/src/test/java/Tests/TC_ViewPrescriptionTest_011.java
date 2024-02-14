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
import pageObjects.ViewPrescriptionPage;

public class TC_ViewPrescriptionTest_011 extends Base {

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

	@Test
	public void ViewPrescription() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
		Thread.sleep(3000);

		AddPrescriptionPage pp = new AddPrescriptionPage(driver);
		base.waitForElementVisibility(pp.getclickPrescriptionlink(), Duration.ofSeconds(150), "AddPatient", driver);
		pp.getclickPrescriptionlink().click();
		log.debug("Clicked on Link");
		//Thread.sleep(2000);

		ViewPrescriptionPage vp = new ViewPrescriptionPage(driver);
		log.debug("Clicked On Submit Button");
		//Thread.sleep(5000);
		base.waitForElementVisibility(vp.getViewPrescriptionLink(), Duration.ofSeconds(150), "AddPatient", driver);
		vp.getViewPrescriptionLink().click();
		log.debug("Clicked On View Prescription ");
		//Thread.sleep(3000);
		vp.getPatientNameField().sendKeys("sonam");
		Thread.sleep(1000);
		vp.getPatientNameField().sendKeys(Keys.ENTER);
		log.debug("Entered Value as Sonam");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[text()='sonam']")).click();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
