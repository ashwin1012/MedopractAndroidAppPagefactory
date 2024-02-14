package MedoPractApp.MedoPractApp.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import MedoPractApp.MedoPractApp.Resources.Base;
import MedoPractApp.MedoPractApp.Utilities.ExtentReporter;



public class Listeners extends Base implements ITestListener {

	WebDriver driver = null;
	//ExtentReporter extentReport = ExtentReporter.getExtentReport();
	//ExtentTest extent;
	//ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		//extent = extentReport.createTest(result.getName() + "execution started");
		//extentTestThread.set(extent);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//extentTestThread.get().log(Status.PASS, result.getName() + "got passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String testMethodName = result.getName();
		//ExtentTest.get().fail(result.getThrowable());

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}

		//try {
	//		try {
				//takeScreenShot(testMethodName, driver);
			//} catch (IOException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
		//	}
			//ExtentTest.get().addScreenCaptureFromPath(testMethodName, testMethodName);
		//} catch (IllegalArgumentException | SecurityException e) {

		//	e.printStackTrace();
	//	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	
	

	@Override
	public void onFinish(ITestContext context) {
		ExtentReporter.flush();

	}

}
