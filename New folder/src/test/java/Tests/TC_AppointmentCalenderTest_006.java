package Tests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.AppointmentCalenderPage;
import pageObjects.LoginPage;
import pageObjects.ReportPage;

public class TC_AppointmentCalenderTest_006 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException {
		log = LogManager.getLogger(TC_AppointmentCalenderTest_006.class.getName());
		driver = initializeDriver();
		log.debug("Browser got launched");

		driver.get(prop.getProperty("url"));
		log.debug("navigated to application URL");
		 base = new Base(); 


	}

	@Test(priority = 1)
	public void NewAppointment() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		// Thread.sleep(2000);

		AppointmentCalenderPage ap = new AppointmentCalenderPage(driver);
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getClickAppointmentCalender(), Duration.ofSeconds(150), "AppCalender", driver);
		ap.getClickAppointmentCalender().click();
		log.debug("Clicked On Appointment Link");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getNewAppointment(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getNewAppointment().click();
		log.debug("Clicked On New Appointment Button");
		// Thread.sleep(3000);
		ap.getFirstNameField().sendKeys(testData.get("AppointmentCalender_Name"));
		log.debug("Entered value as Sonam");
		// Thread.sleep(3000);
		ap.getLastNameField().sendKeys(testData.get("AppointmentCalender_LastName"));
		log.debug("Entered value as Jain");
		// Thread.sleep(3000);
		ap.getVisitreasonField().sendKeys(testData.get("AppointmentCalender_visitreason"));
		log.debug("Entered value fever");
		// Thread.sleep(4000);
		ap.getSaveAppointmentButton().click();
		log.debug("Clicking on Save Button");
		// Thread.sleep(5000);

		base.waitForElementVisibility(ap.getAppointmentCalenderMessage(), Duration.ofSeconds(60), "AppCalender",
				driver);
		Thread.sleep(1000);
		String actualDisplayMessage = driver.findElement(By.xpath("//div[text()='Appointment added Successfully']"))
				.getText();

		String expectedDisplayMessage = "Appointment added Successfully";
		Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);

		base.waitForElementVisibility(ap.getMonthButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getMonthButton().click();
		log.debug("Clicked on Month Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getWeekButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getWeekButton().click();
		log.debug("Clicked on Week Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getTodaybuttonWeek(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getTodaybuttonWeek().click();
		log.debug("Clicked on Week Today Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getBackButtonWeek(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getBackButtonWeek().click();
		log.debug("Clicked on Week Back Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getNextButtonWeek(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getNextButtonWeek().click();
		log.debug("Clicked on Week Next Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getNextButtonWeek(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getDayButton().click();
		log.debug("Clicked on Day Button");
		 Thread.sleep(2000);
		base.waitForElementVisibility(ap.getAgendaButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getAgendaButton().click();
		log.debug("Clicked on Agenda Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getTodayAgendaButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getTodayAgendaButton().click();
		log.debug("Clicked on Toady Agenda  Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getBackAgendaButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getBackAgendaButton().click();
		log.debug("Clicked on Back Agenda  Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getNextAgendaButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getNextAgendaButton().click();
		log.debug("Clicked on Next Agenda  Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getDayToday(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getDayToday().click();
		log.debug("Clicked on Today Day Button");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getBackDay(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getBackDay().click();
		log.debug("Clicked on Back Day Button");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getNextDay(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getNextDay().click();
		log.debug("Clicked on next Day Button");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getTodayMonth(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getTodayMonth();
		log.debug("Clicked on today month Button");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getBackMonth(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getBackMonth().click();
		log.debug("Clicked on back month Button");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getNextMonth(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getNextMonth().click();
		log.debug("Clicked on next month Button");
		// Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void ExistingAppointment() throws Exception {

		// LoginPage lp = new LoginPage(driver);
		// lp.login(prop.getProperty("username"), prop.getProperty("password"));
		// Thread.sleep(3000);
		AppointmentCalenderPage ap = new AppointmentCalenderPage(driver);
		base.waitForElementVisibility(ap.getClickAppointmentCalender(), Duration.ofSeconds(150), "AppCalender", driver);
		ap.getClickAppointmentCalender().click();
		log.debug("Clicked On Appointment Link");
		// Thread.sleep(3000);
		base.waitForElementVisibility(ap.getNewAppointment(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getNewAppointment().click();
		log.debug("Clicked On New Appointment Button");
		// Thread.sleep(3000);
		ap.getFirstNameField().sendKeys(testData.get("AppointmentCalender_Name"));
		log.debug("Entered value as Sonam");
		// Thread.sleep(3000);
		ap.getLastNameField().sendKeys(testData.get("AppointmentCalender_LastName"));
		log.debug("Entered value as Jain");
		// Thread.sleep(3000);
		String visitReason = "sneeza" + Base.randomNumber();
		ap.getVisitreasonField().sendKeys(visitReason); // put unique value // Apppend
		log.debug("Entered value fever");
		// Thread.sleep(4000);
		base.waitForElementVisibility(ap.getSaveAppointmentButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getSaveAppointmentButton().click();
		Thread.sleep(4000);
		log.debug("Clicking on Save Button");
		base.waitForElementVisibility(ap.getMonthButton(), Duration.ofSeconds(60), "AppCalender", driver);
		ap.getMonthButton().click();
		log.debug("Clicked on Month Button");
		// Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='rbc-date-cell rbc-now rbc-current']//a")).click();
		// Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text( )='" + visitReason + "']")).click(); // Same as Above Value for Xpath
		// ap.getExistingAppointment().click();
		log.debug("Clicked On New Existing Appointment");
		// Thread.sleep(3000); // unable to Locate
		ap.getEditfirstNameField().clear();
		ap.getEditfirstNameField().sendKeys(testData.get("AppointmentCalender_EditfirstName"));
		ap.getSaveAppointmentButton().click();
		log.debug("Clicking on Save Button");
		// Thread.sleep(5000);
		base.waitForElementVisibility(ap.getAppointmentSaveMessage(), Duration.ofSeconds(60), "AppCalender", driver);
		Thread.sleep(1000);
		String actualDisplayMessage = driver
				.findElement(By.xpath("//div[@class='react-toast-notifications__toast__content css-1ad3zal']"))
				.getText();

		String expectedDisplayMessage = "Appointment Updated Successfully";
		Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
