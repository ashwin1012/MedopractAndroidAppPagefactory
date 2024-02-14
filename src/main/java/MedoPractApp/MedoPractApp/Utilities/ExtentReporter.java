package MedoPractApp.MedoPractApp.Utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	static ExtentReporter extentReport;

	public static ExtentReporter getExtentReport() {

		String extentPath = System.getProperty("user.dir") + "\\reports\\"+TestUtil.TimeStamp()+"extentReport.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(extentPath);
		reporter.config().setReportName("Automation lab Login Test");
		reporter.config().setDocumentTitle("Test Report");

		extentReport = new ExtentReporter();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating system", "Windows 11");
		extentReport.setSystemInfo("Tested By", "Sonam");

		return extentReport;

	}

	private void setSystemInfo(String string, String string2) {
		// TODO Auto-generated method stub

	}

	private void attachReporter(ExtentSparkReporter reporter) {
		// TODO Auto-generated method stub

	}

	public ExtentTest createTest(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void flush() {
		// TODO Auto-generated method stub
		
	}

}
