package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.RegistrationPage;

public class TC_RegistrationTestWDT_004 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void openApplication() throws IOException {
		log = LogManager.getLogger(TC_LoginTest_001.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/register");
		log.debug("navigated to application URL");

	}

	@Test
	public void Registration() throws InterruptedException {

		RegistrationPage rp = new RegistrationPage(driver);
		// rp.getClickRegisterNow().click();
		//log.debug("Clicked RegisterNow Button");
		//rp.NameField.sendKeys("");
		//log.debug("Entered Name");
		//rp.getEmailfield().sendKeys("");
		//log.debug("Entered Email Address");
		//rp.getMobilefield().sendKeys("");
		//log.debug("Entered Phone Number");
		//rp.getUsernamefield().sendKeys("");
		//log.debug("Entered UserName");
		//rp.getConfirmusernamefield().sendKeys("");
		//log.debug("Entered ConfirmUserName");
		//rp.getAgreetermcheckbox().click();
		//log.debug("Clicked Checkbox");
		
		//Thread.sleep(5000);
		rp.getClickregisterbutton().click();
		log.debug("Clicked On Register Button");

		Thread.sleep(5000);

			
	
	}
}
