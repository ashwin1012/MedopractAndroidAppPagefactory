package Tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.AddPatientPage;
import pageObjects.LoginPage;
import pageObjects.ViewEditPage;

public class TC_ViewEditTest_009 extends Base{
	
	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void openApplication() throws Exception {
		log = LogManager.getLogger(TC_ViewEditTest_009.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");
		 base = new Base(); 

	}
	
	
	@Test
	public void ViewEdit() throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
		//Thread.sleep(3000);
		
		String patientnamevalue="sania Agarwal";
		AddPatientPage app = new AddPatientPage(driver);
		base.waitForElementVisibility(app.getPatientsClick(), Duration.ofSeconds(150), "View/Edit", driver);
		app.getPatientsClick().click();
		ViewEditPage vp = new ViewEditPage(driver);
		vp.getViewEdit().click();
		log.debug("Clicked On ViewEditTab");
		base.waitForElementVisibility(app.getPatientNameField(), Duration.ofSeconds(150), "View/Edit", driver);
		//Thread.sleep(4000);
		vp.getPatientNameField().sendKeys(patientnamevalue);
		log.debug("Entered Name in PatientName Field");
		//Thread.sleep(4000);
		//vp.getPhoneNumberField().sendKeys("8087366616");
		//log.debug("Entered Phone Number");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//input[@value='"+patientnamevalue+"'])[2]")).click();
		
		base.waitForElementVisibility(vp.getClickeditpatientdetail(), Duration.ofSeconds(150), "View/Edit", driver);
		Thread.sleep(1000);
		vp.getClickeditpatientdetail().click();
		
		base.waitForElementVisibility(vp.getEditoccupation(), Duration.ofSeconds(150), "View/Edit", driver);
		Thread.sleep(1000);
		vp.getEditoccupation().clear();
		vp.getEditoccupation().sendKeys("doc");
		
		base.waitForElementVisibility(vp.getUpdateButtonClick(), Duration.ofSeconds(150), "View/Edit", driver);
		Thread.sleep(1000);
		vp.getUpdateButtonClick().click();
		Thread.sleep(3000);
		vp.getCancelButtonClick().click();
		
		
		base.waitForElementVisibility(vp.getUpdateassertion(), Duration.ofSeconds(150), "View/Edit", driver);
		String actualDisplayMessage = driver
				.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"))
				.getText();

		String expectedDisplayMessage = "Patient record updated successfully!";
		Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
}
}