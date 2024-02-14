package MobileTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MedoPractApp.MedoPractApp.Resources.Base;

import MedoPractApp.MedoPractApp.pageObjects.LoginPage;
import MedoPractApp.MedoPractApp.pageObjects.TodolistPage;

import org.openqa.selenium.Alert;

//import pageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class TC_MobileToDoListTest_006 extends Base {

	public WebDriver driver;
	Logger log;

	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		log = LogManager.getLogger(TC_MobileToDoListTest_006.class.getName());
		// etest = extent.createTest("Testcase execution started");
		driver = initializeDriver();
		log.debug("Mobile App got launched");

		// base = new Base();

	}

	@Test(priority = 1)
	public void ToDoListTest() throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.login(prop.getProperty("username"), prop.getProperty("password"));
		TodolistPage lpp = new TodolistPage(driver);
		Thread.sleep(10000);

		lpp.taskPageScreen.click();
		Thread.sleep(8000);
		lpp.getAddtask().click();
		Thread.sleep(5000);
		lpp.getTaskName().sendKeys(testData.get("Todo_TaskName"));
		Thread.sleep(2000);
		// driver.findElement(By.id("com.clinic.myclinic.debug:id/etDate")).sendKeys("");
		// Thread.sleep(2000);
		lpp.getAddTaskButton().click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"COMPLETED
		// TASKS\"]/android.widget.TextView")).click();

		/*
		 * String actualDisplayMessage = driver.findElement(By.xpath("")).getText();
		 * 
		 * String expectedDisplayMessage = "Tasks added";
		 * Assert.assertEquals(actualDisplayMessage, expectedDisplayMessage);
		 */

	}

	@Test(priority = 2)
	public void WithDueDate() throws Exception {

		TodolistPage td = new TodolistPage(driver);
		Thread.sleep(5000);
		// base.waitForElementVisibility(td.taskfield, Duration.ofSeconds(60),
		// "taskfield", driver);
		// td.getWithDueDate().click();// rename with plussign Click

		td.getAddtask().click();
		Thread.sleep(2000);
		td.getTaskName().sendKeys(testData.get("Todo_TaskName"));
		Thread.sleep(2000);
		td.getDueDateClick().click();

		Date Now = new Date();

		DateFormat df = new SimpleDateFormat("dd MMMM yyyy ");
		df.format(Now);
		driver.findElement(By.xpath("//android.view.View[@content-desc='" + df.format(Now).trim() + "']")).click();
		td.getOkButtonToDoList().click();
		Thread.sleep(2000);
		td.getAddTaskButton().click();
		log.debug("Clicked on Add Task Button");
		// Thread.sleep(2000);
		// base.waitForElementVisibility(td.taskrecordmessage2, Duration.ofSeconds(60),
		// "taskrecordmessage", driver);

		// String actualDisplayMessage = driver.findElement(By.xpath("")).getText();

		// String expectedDisplayMessage = "";
	}

	@Test(priority = 3)
	public void ViewCompletedTasks() throws Exception {

		TodolistPage td = new TodolistPage(driver);
		Thread.sleep(5000);
		// base.waitForElementVisibility(td.getWithDueDate(), Duration.ofSeconds(60),
		// "taskfield", driver);
		int taskCount = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout"))
				.size();
		System.out.println(taskCount);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout["
						+ taskCount + "]/android.widget.ImageView[1]"))
				.click();

		td.getClickViewCompletedTask().click();
		log.debug("Clicked on Completed Task");
		Thread.sleep(5000);
		td.getClickOpenTask().click();
		log.debug("Clicked on Open Task");
		Thread.sleep(5000);

	}

	/*
	 * @Test(priority = 6) public void WithoutMandatoryField() throws
	 * InterruptedException {
	 * 
	 * TodolistPage td = new TodolistPage(driver); td.getWithDueDate().click();
	 * log.debug("Clicked on plus Sign"); Thread.sleep(3000);
	 * td.getAddtask().click(); log.debug("Clicked on Add Task Button");
	 * Thread.sleep(6000);
	 * 
	 * }
	 */

	@Test(priority = 4)
	public void TodoListDeleteTask() throws InterruptedException {

		TodolistPage td = new TodolistPage(driver);
		int taskcount = driver.findElements(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout"))
				.size();
		System.out.println(taskcount);
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout["
						+ taskcount + "]/android.widget.ImageView[2]"))
				.click();
		log.debug("Deleting task");
		Thread.sleep(3000);
		td.ClickYesDeleteButton.click();

		Thread.sleep(3000);

		// String actualDisplayMessage2 = alert.getText();

		// String expectedDisplayMessage2 =
		// "Task would be permanently deleted. Are you sure, you want to delete the task
		// ? "
		// ; Assert.assertEquals(actualDisplayMessage2, expectedDisplayMessage2);
		// alert.accept();

	}

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

}
