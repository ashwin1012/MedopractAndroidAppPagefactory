package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTest {
	
	
		WebDriver driver;
		ExtentReports extent;
		ExtentTest etest;
		@BeforeMethod
		public void configuration() {
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
			reporter.config().setReportName("ATW Test report");
			reporter.config().setDocumentTitle("ATW report");
			
			extent= new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("opertaing system", "Windows 11");
			extent.setSystemInfo("Tested By", "Surendra");
			extent.setSystemInfo("Tested on", "10-08-2022");
			
		}

		
		@Test
		public void testOne() {
			etest = extent.createTest("TestOne execution started");
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			 etest.info("ChromeBrowesr launched");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://surendrareddy1248.github.io/WebElementsTesting/");
			etest.info("Navigated to WebElements page");
			String actualTitle = driver.getTitle();
			etest.info("retrieved title of the page ");
			String expTitle="ATW-WebElementsPractise123";
			etest.info("Asserting actual title with expected title");
			etest.fail("Test failed");
			Assert.assertEquals(actualTitle, expTitle);
			
		}
		@AfterMethod
		public void closure() {
			driver.close();
			etest.info("Browser got closed");
			extent.flush();
		}

	}

