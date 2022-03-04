package Reports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Constants.Constant;

public class Reports {

	public static ExtentReports reports = new ExtentReports(Constant.ReportsPath, false);
	public static ExtentTest test;

	public static void startTest(String TestCaseName, String desc) {
		test = reports.startTest(TestCaseName, desc);
		test.assignCategory("Regression_DARA");
		test.assignAuthor("Madhuri");
		SystemInfo();
	}

	public static void SystemInfo() {
		Map<String, String> systemInformation = new HashMap<String, String>();
		systemInformation.put("Selenium Verison", "3.7.1");
		reports.addSystemInfo(systemInformation);
	}

	public static void info(String testStepName, String details) {
		test.log(LogStatus.INFO, testStepName, details);
	}

	public static void pass(String testStepName, String details) {
		test.log(LogStatus.PASS, testStepName, details);
	}

	public static void fail(String testStepName, String details, String Imagepath) {
		test.log(LogStatus.FAIL, testStepName,
				"<span style ='font-weight:bold; color:red;'" + details + "</span>" + test.addScreenCapture(Imagepath));
	}

	public static void warn(String testStepName, String details) {
		test.log(LogStatus.WARNING, testStepName,
				"<span style ='font-weight:bold; color:brown'>" + details + "</span>");
		// test.log(LogStatus.INFO,"", "<span style= 'font-weight:bold;
		// color:red'>"+desc+"</span>");
	}

	public static void fatal(String testStepName, String details) {
		test.log(LogStatus.FATAL, testStepName, details);
	}

	public static void endTest() {
		reports.endTest(test);
	}

	public static void flush() {
		reports.flush();
	}

}
