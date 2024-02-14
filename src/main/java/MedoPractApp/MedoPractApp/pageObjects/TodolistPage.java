package MedoPractApp.MedoPractApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TodolistPage {

	WebDriver driver;

	public TodolistPage(WebDriver driver) {
		this.driver = (WebDriver) driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "com.clinic.myclinic.debug:id/txtHomeFragment")
	public WebElement taskPageScreen;

	@FindBy(id = "com.clinic.myclinic.debug:id/txtAddTask")
	private WebElement Addtask;

	@FindBy(id= "com.clinic.myclinic.debug:id/etTask")
	private WebElement TaskName;
	
	@FindBy(id= "com.clinic.myclinic.debug:id/etDate")
			
	public WebElement DueDateClick;

	@FindBy(id = "com.clinic.myclinic.debug:id/btnAddTask")
	private WebElement AddTaskButton;
	
	@FindBy(id="android:id/button1")
	public WebElement OkButtonToDoList;
	
	@FindBy(xpath="//android.widget.LinearLayout[@content-desc=\"COMPLETED TASKS\"]/android.widget.TextView")
	public WebElement ClickViewCompletedTask;
	
	@FindBy(xpath="//android.widget.LinearLayout[@content-desc=\"OPEN TASKS\"]/android.widget.TextView")
	public WebElement ClickOpenTask;
	
	@FindBy(id="com.clinic.myclinic.debug:id/btnyes")
	public WebElement ClickYesDeleteButton;
	
			
			

	/*@FindBy(xpath = "(//a[@title='Complete'])[1]")
	private WebElement ClickingComplete;

	@FindBy(xpath = "(//a[@title='Delete'])[1]")
	private WebElement deleteTask;*/

	/*@FindBy(xpath = "//a[text( )='View Completed Tasks']")
	private WebElement ViewCompletedTask;

	@FindBy(xpath = "//a[text( )='View Open Tasks']")
	private WebElement ViewOpenTask;

	@FindBy(xpath = "//input[@class='todoList_todotime__1bSAv']")
	private WebElement DateSelect;*/

	/*@FindBy(xpath = "//div[text( )='Tasks record added']")
	public WebElement taskrecordmessage;

	@FindBy(xpath = "//div[text( )='Tasks record added']")
	public WebElement taskrecordmessage2;*/

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTaskPageScreen() {
		return taskPageScreen;
	}

	public WebElement getAddtask() {
		return Addtask;
	}

	public WebElement getTaskName() {
		return TaskName;
	}

	

	public WebElement getAddTaskButton() {
		return AddTaskButton;
	}

	public WebElement getDueDateClick() {
		return DueDateClick;
	}

	public WebElement getOkButtonToDoList() {
		return OkButtonToDoList;
	}

	public WebElement getClickViewCompletedTask() {
		return ClickViewCompletedTask;
	}

	public WebElement getClickOpenTask() {
		return ClickOpenTask;
	}

	public WebElement getClickYesDeleteButton() {
		return ClickYesDeleteButton;
	}
	
	

	
	
	/*public WebElement getClickingComplete() {
		return ClickingComplete;
	}

	public WebElement getDeleteTask() {
		return deleteTask;
	}

	public WebElement getViewCompletedTask() {
		return ViewCompletedTask;
	}

	public WebElement getViewOpenTask() {
		return ViewOpenTask;
	}

	public WebElement getDateSelect() {
		return DateSelect;
	}

	public WebElement getTaskrecordmessage() {
		return taskrecordmessage;
	}

	public WebElement getTaskrecordmessage2() {
		return taskrecordmessage2;*/
	}

