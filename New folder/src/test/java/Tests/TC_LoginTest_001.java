package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.MyPage;

public class TC_LoginTest_001 extends Base {

	public WebDriver driver;
	Logger log;
	Base base;

	@BeforeClass
	public void openApplication() throws InterruptedException, IOException {
		log = LogManager.getLogger(TC_LoginTest_001.class.getName());
		//etest = extent.createTest("Test login execution started");
		driver = initializeDriver();
		log.debug("Browser got launched");
		base = new Base(); 
		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");

	}

	@Test(priority = 1)
	public void SubmitButtonWithoutData() throws InterruptedException {
		driver.navigate().refresh();

		LoginPage lp = new LoginPage(driver);

		lp.SubmitButton();
		//Thread.sleep(3000);
		MyPage mp = new MyPage(driver);
		//Assertion

	}

	@Test(priority = 2)
	public void login() throws Exception {
		driver.navigate().refresh();
		//etest = extent.createTest("login execution started");
		driver.navigate().refresh();
		//Thread.sleep(5000);
		//etest.info("login Page");
		LoginPage lp = new LoginPage(driver);
		
		lp.login1(prop.getProperty("username"), prop.getProperty("password"));
		//Thread.sleep(3000);

		MyPage mp = new MyPage(driver);

		String actual = null;
		try {
			if (mp.getEditaccinfo().isDisplayed()) {
				log.debug("user go to the login Page");
				actual = "successful";
			} else {
				log.debug("User didn't go to login page");
				actual = "failure";
			}
		} catch (Exception e) {
			log.debug("User didn't go to login page");
			actual = "failure";
		}
		Assert.assertTrue(actual.equals("successful"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
