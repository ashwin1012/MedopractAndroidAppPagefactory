package Tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LoginPage;
import pageObjects.PatientVisitPage;

public class TC_PatientvisitTest_008 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws InterruptedException, IOException {
		log = LogManager.getLogger(TC_PatientvisitTest_008.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");
		base = new Base();

	}

	@Test(priority = 1)
	public void PatientVisitWithPrimaryComplaintupload() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		// Thread.sleep(2000);

		PatientVisitPage ppv = new PatientVisitPage(driver);
		base.waitForElementVisibility(ppv.getPatientvisitClick(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientvisitClick().click();
		log.debug("Clicked on Patient visit Tab");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ppv.getPatientName(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientName().sendKeys(testData.get("PatientVisit_Name"));
		// Thread.sleep(2000);

		ppv.getPatientName().sendKeys(Keys.ENTER);
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='sonam']")).click();
		log.debug("Clicked on Patient visit Tab");
		// Thread.sleep(3000);
		ppv.getPrimaryComplaint().sendKeys(testData.get("PrimaryComplaint"));
		log.debug("Clicked on Primary Complaint Tab");
		// Thread.sleep(3000);
		ppv.getSymptoms().sendKeys(testData.get("Symptoms"));
		log.debug("Clicked on Primary Complaint Tab");
		// Thread.sleep(3000);
		ppv.getClickingPlusSign().click();
		log.debug("Clicked on Plus Sign");
		// Thread.sleep(2000);
		ppv.getSymptoms().sendKeys(testData.get("Symptoms2"));
		log.debug("Clicked on Primary Complaint Tab");
		ppv.getClickingPlusSign2().click();
		Thread.sleep(2000);
		ppv.getDeletesymptom().click();
		Thread.sleep(2000);
		ppv.getInvestigationTests().sendKeys(testData.get("InvestigationTests1"));
		log.debug("Entered Investigation tests Value");
		// Thread.sleep(3000);
		ppv.getclickingInvestigationTestplusSign().click();
		// Thread.sleep(3000);
		log.debug("Entered Investigation tests Value");
		ppv.getInvestigationTests().sendKeys(testData.get("InvestigationTests2"));
		log.debug("Entered Investigation tests Value");
		ppv.getClickingInvestigationTestplusSign2().click();
		//Thread.sleep(2000);
		base.waitForElementVisibility(ppv.getDeleteinvestigation(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getDeleteinvestigation().click();
		//Thread.sleep(2000);
		ppv.getSelectfiles().sendKeys(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Issue_While Running Browser.png");
		Thread.sleep(5000);
		ppv.getSelectfiles().sendKeys(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\demoupload.txt");
		Thread.sleep(6000);
		String actualDisplayMessage = driver
				.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"))
				.getText();

		String expectedDisplayMessage = "File uploaded successfully!";
		Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);

	}

	@Test(priority = 2)
	public void DeletePatientvisitDocument() throws Exception {

		PatientVisitPage ppv = new PatientVisitPage(driver);
		 base.waitForElementVisibility(ppv.getDeletefile(),Duration.ofSeconds(60), "patientName", driver);

		ppv.getDeletefile().click();
		Thread.sleep(6000);

		String actualDisplayMessage = driver
				.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"))
				.getText();

		String expectedDisplayMessage = "File deleted successfully!";
		Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);
		
	}

	@Test(priority = 3)
	public void SavePatientVisit() throws Exception {

		PatientVisitPage ppv = new PatientVisitPage(driver);
		 base.waitForElementVisibility(ppv.getSaveButton(),Duration.ofSeconds(60), "patientName", driver);
		ppv.getSaveButton().click();
		log.debug("Clicked on Save Button");

		base.waitForElementVisibility(ppv.getPatientvisitmessage(), Duration.ofSeconds(150), "namefield", driver);
		Thread.sleep(2000);

		String actualDisplayMessage = ppv.getPatientvisitmessage().getText();

		System.out.println(actualDisplayMessage);
		String expectedDisplayMessage = "Patient visit added successfully!";
		if (actualDisplayMessage.contains(expectedDisplayMessage)) {
			Assert.assertEquals(true, true);

		} else {
			Assert.assertEquals(true, false);
		}
		
		
	}

	@Test(priority = 4)
	public void Followup() throws Exception {

		PatientVisitPage ppv = new PatientVisitPage(driver);
		base.waitForElementVisibility(ppv.getFollowup(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getFollowup().click();
		log.debug("Clicked on Followup Button");
		
			//Thread.sleep(3000);
			base.waitForElementVisibility(ppv.getPatientVisitReason(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientVisitReason().sendKeys("fever1");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text( )='Visit Reason: '] ")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='PatientVisit_followupInput__3tX-8'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[contains(@class,'react-datepicker__day--today')]//following-sibling::div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text( )='Visit Reason: '] ")).click();
		//Thread.sleep(2000);

		log.debug("Clicked on visitreason Button");
		//Thread.sleep(3000);
		base.waitForElementVisibility(ppv.getAddAppointment(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getAddAppointment().click();
		log.debug("Clicked on Followup Button");
		Thread.sleep(3000);

		// base.waitForElementVisibility(ppv.getFollowupmessage(),
		// Duration.ofSeconds(60), "patientName", driver);

		String actualDisplayMessage1 = driver.findElement(By.xpath("//div[text()='Appointment added Successfully']"))
				.getText();

		String expectedDisplayMessage1 = "Appointment added Successfully";
		Assert.assertEquals(actualDisplayMessage1, expectedDisplayMessage1);
		
	}

	@Test(priority = 5)
	public void PatientVisitWithoutPrimaryComplaint() throws Exception {
		driver.navigate().refresh();
		

		PatientVisitPage ppv = new PatientVisitPage(driver);
		base.waitForElementVisibility(ppv.getPatientvisitClick(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientvisitClick().click();
		log.debug("Clicked on Patient visit Tab");
		//Thread.sleep(3000);
		base.waitForElementVisibility(ppv.getPatientName(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientName().clear();
		ppv.getPatientName().sendKeys(testData.get("PatientVisit_Name"));
		// Thread.sleep(2000);
		base.waitForElementVisibility(ppv.getPatientName(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientName().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='sonam']")).click();
		log.debug("Clicked on Patient visit Tab");
		//Thread.sleep(3000);
		log.debug("Clicked on Patient visit Tab");
		//Thread.sleep(3000);
		ppv.getPrimaryComplaint().sendKeys("");
		log.debug("Clicked on Primary Complaint Tab");
		//Thread.sleep(3000);
		ppv.getSymptoms().sendKeys(testData.get("Symptoms"));
		log.debug("Clicked on Primary Complaint Tab");
		//Thread.sleep(3000);
		ppv.getClickingPlusSign().click();
		log.debug("Clicked on Plus Sign");
		//Thread.sleep(2000);
		ppv.getInvestigationTests().sendKeys(testData.get("InvestigationTests1"));
		log.debug("Clicked on Investigation tests");
		//Thread.sleep(3000);
		
		ppv.getSaveButton().click();
		log.debug("Clicked on Save Button");
		Thread.sleep(3000);

		String actualDisplayMessage1 = driver.findElement(By.xpath("//div[text()='Please add Primary complaint']"))
				.getText();

		String expectedDisplayMessage1 = "Please add Primary complaint";
		Assert.assertEquals(actualDisplayMessage1, expectedDisplayMessage1);
		
	}

	@Test(priority = 6)
	public void PatientVisitWithoutDate() throws Exception {
		driver.navigate().refresh();
		PatientVisitPage ppv = new PatientVisitPage(driver);
		base.waitForElementVisibility(ppv.getPatientvisitClick(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientvisitClick().click();
		log.debug("Clicked on Patient visit Tab");
		//Thread.sleep(3000);
		base.waitForElementVisibility(ppv.getPatientName(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientName().clear();
		ppv.getPatientName().sendKeys(testData.get("PatientVisit_Name"));
		// Thread.sleep(2000);
		base.waitForElementVisibility(ppv.getPatientName(), Duration.ofSeconds(60), "patientName", driver);
		ppv.getPatientName().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='sonam']")).click();
		log.debug("Clicked on Patient visit Tab");
		base.waitForElementVisibility(ppv.getDateClick2(), Duration.ofSeconds(60), "patientName", driver);
		//Thread.sleep(3000);
		ppv.getDateClick2().click();
		Thread.sleep(2000);
		for (int i = 1; i <= 10; i++) {
			ppv.getAfterDateClick().sendKeys(Keys.BACK_SPACE);

		}
		//Thread.sleep(2000);
		ppv.getPrimaryComplaint().sendKeys(testData.get("PrimaryComplaint"));
		log.debug("Clicked on Primary Complaint Tab");
		//Thread.sleep(3000);
		ppv.getSymptoms().sendKeys(testData.get("Symptoms"));
		log.debug("Clicked on Primary Complaint Tab");
		//Thread.sleep(3000);
		// ppv.getClickingPlusSign().click(); //by.name
		log.debug("Clicked on Plus Sign");
		//Thread.sleep(2000);
		ppv.getInvestigationTests().sendKeys(testData.get("InvestigationTests1"));
		log.debug("Clicked on Investigation tests");
		//Thread.sleep(3000);
		ppv.getSaveButton().click();
		log.debug("Clicked on Save Button");
		Thread.sleep(5000);

		String actualDisplayMessage1 = driver.findElement(By.xpath("//div[text( )='Please add Date & Time']"))
				.getText();

		String expectedDisplayMessage1 = "Please add Date & Time";
		Assert.assertEquals(actualDisplayMessage1, expectedDisplayMessage1);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
