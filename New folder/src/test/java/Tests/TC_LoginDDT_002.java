package Tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.MyPage;

public class TC_LoginDDT_002 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void openApplication() throws IOException {
		log = LogManager.getLogger(TC_LoginTest_001.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");

	}

	@Test(dataProvider = "getLoginData")
	public void login(String email, String pass, String expected) throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(email, pass);
	

		

		MyPage mp = new MyPage(driver);
		
	
		try {
			if (expected.equalsIgnoreCase("successful")) {
				log.debug("user got logged in");
				base.waitForElementVisibility(mp.getEditaccinfo(),Duration.ofSeconds(60), "user name", driver);
				Assert.assertTrue(mp.getEditaccinfo().isDisplayed());
			}
			else {
				{
					Thread.sleep(2000);
					Assert.assertFalse(mp.getEditaccinfo().isDisplayed());
				}
			}
		} catch (Exception e) {
			log.debug("User didn't login");

	
		}

	}

	@AfterMethod
	public void tearDown() {
		 driver.close();
		log.debug("Browser got closed");
	}

	@DataProvider
	public Object[][] getLoginData() {

		Object[][] data = { { "sonamo008@aanksolutions.in", "sonam29", "successful" },
				{ "sample@test.com", "sonam29", "failure" }, { "sonamo008@aanksolutions.in", "saniya", "failure" },
				{ "", "", "failure" } };

		return data;
	}

}
