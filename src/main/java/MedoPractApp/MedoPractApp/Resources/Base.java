package MedoPractApp.MedoPractApp.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.github.bonigarcia.wdm.WebDriverManager;
import MedoPractApp.MedoPractApp.Utilities.*;
import java.util.concurrent.TimeUnit;

public class Base {
	
	//protected static Properties testDataProp = null;

	public WebDriver driver;
	public Properties prop;
	public WebDriverWait webDriverWait;

	public ExtentReports extent;
	public ExtentTest etest;
	public static Map<String, String> testData = new HashMap<String, String>();
	//public Base base;

	@BeforeSuite
	public void configuration() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\reports\\" + TestUtil.TimeStamp() + "_extentReport.html");
		reporter.config().setReportName("ATW Test report");
		reporter.config().setDocumentTitle("ATW report");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("opertaing system", "Windows 11");
		extent.setSystemInfo("Tested By", "Surendra");
		extent.setSystemInfo("Tested on", "10-08-2022");
		try {
			excelsheetReading("DemoExcel");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//base = new Base();
	}

	
	
	@AfterSuite
	public void closure() {

		// etest.info("Browser got Closed");

		extent.flush();
		driver.quit();
	}

	public WebDriver initializeDriver() throws InterruptedException, IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\MedoPractApp\\MedoPractApp\\Resources\\data.properties");
		prop.load(fis);
		// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

		capabilities.setCapability("appPackage", "com.clinic.myclinic.debug");
		capabilities.setCapability("appActivity", "com.clinic.myclinic.SplashScreenActivity");

		RemoteWebDriver driver = new RemoteWebDriver(new URL(prop.getProperty("url")), capabilities);
		Thread.sleep(5000);

		

		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		return driver;
	}
	
		
	

	public void waitForElementVisibility(WebElement element, int sec, String pageElementName, WebDriver driver)
			throws Exception {
        Thread.sleep(800);
		webDriverWait = new WebDriverWait(driver, sec);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.clinic.myclinic.debug:id/largeLabel")));

	}


	public void waitForElementVisibility2(By by, long sec, String pageElementName, WebDriver driver) throws Exception {
		Thread.sleep(800);
		webDriverWait = new WebDriverWait(driver, sec);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public void click(WebElement element, String pageElementName, WebDriver driver) throws Exception {

		// waitForElementVisibility(element, Duration.ofSeconds(20), pageElementName,
		// driver);
		element.click();

	}

	/*
	 * public String takeScreenShot(String testName,WebDriver driver) throws
	 * IOException { File SourceFile =
	 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); String
	 * destination=
	 * System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
	 * FileUtils.copyFile(SourceFile, new File(destination)); return destination; }
	 */

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		// File source = ts.getScreenshotAs(OutputType.FILE);
		// File target = new File(System.getProperty("user.dir") + "/Screenshots/" +
		// tname + ".png");
		// FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public void excelsheetReading(String excelsheetfilename) throws IOException {
		String projectdir = System.getProperty("user.dir");
		FileInputStream fileInputStream = new FileInputStream(projectdir + "\\Excel\\" + excelsheetfilename + ".xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		for (int sheetcount = 0; sheetcount < workbook.getNumberOfSheets(); sheetcount++) {

			XSSFSheet sheet = workbook.getSheetAt(sheetcount);
			for (int rowcount = 0; rowcount < sheet.getPhysicalNumberOfRows(); rowcount++) {

				testData.put(sheet.getRow(rowcount).getCell(0).getStringCellValue(),
						sheet.getRow(rowcount).getCell(1).getStringCellValue());
			}
		}

	}

	public static int randomNumber() {
		Random random = new Random();
		int uniqueNumber = random.nextInt(80000);
		return uniqueNumber;
	}

}
