package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;

public class TC_LogoutTest_013 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException {
		log = LogManager.getLogger(TC_LogoutTest_013.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));

		log.debug("navigated to application URL");
		 base = new Base(); 

	}

	@Test
	public void LogoutwithValidCredentials() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);

		LogoutPage lop = new LogoutPage(driver);
		lop.getLogoutButton().click();
        
	}
	
    @Test  
	public void ReLoginWithSameAccount() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login1(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(6000);

	}

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

}
