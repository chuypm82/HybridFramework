package Automation.HybridFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	protected static WebDriver driver;
	protected static WebElement element;
	protected static String URL;
	protected static String Browser;
	protected static String myProfilePath;
	protected static String HeadlessExecution;
	protected static String POFileName;
	protected static String TestDataFileName;
	protected static ExtentTest extentTest;
	protected static ExtentReports extentReports;
	static ExtentSparkReporter extentSparkReporter;
	protected static String codeLine;
	protected static int reportFlag;
	protected static String testName;

	public static void createDriver(EdgeOptions options) {
		driver = new EdgeDriver(options);
	}

	public static void initializeReport() {

		if (reportFlag < 1) {
			// report = new ExtentReports(System.getProperty("user.dir")+"/
			// ExtentReportResults.html");
			// test = report.startTest("ExtentDemo");
			extentSparkReporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "/test-output/extentReport.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(extentSparkReporter);
			// configuration items to change the look and feel
			// add content, manage tests etc
			extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
			extentSparkReporter.config().setReportName("Test Report");
			extentSparkReporter.config().setTheme(Theme.STANDARD);
			extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			reportFlag++;
		}

	}

	public static void createTestCaseReport(String testCaseName) {
		
		testName = getCleanTestName(testCaseName);
		if (reportFlag > 0)
			extentTest = extentReports.createTest(testName, "");
	}

	public static void closeReport() {
		extentReports.flush();
	}

	public static void getCodeLine(int iCodeLine, String className) {
		codeLine = "Code Line: " + iCodeLine + " -> " + className + " -> ";
	}

	public static String takeScreenshot() throws Exception {
		
		Thread.sleep(500);
		// Convert web driver object to TakeScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		// Call getScreenshotAs method to create image file
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File destFile = new File("test-output/Screenshots/" + testName + ".png");
		// Copy file at destination
		FileUtils.copyFile(srcFile, destFile);
		return destFile.getAbsolutePath();
	}
	
	public static String getCleanTestName(String testCaseName) {

		String[] data =  testCaseName.split("\\$");
		if (data.length>=2)
			return data[0].trim();
		else 
			return testCaseName;
	}

}