package Automation.HybridFramework;

import static org.junit.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import Utilities.File_Reader;

public class Keyword extends BaseClass {
	
	public static void ADD_COMMENT_TO_LOG(String User_Comment) {

		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		// Printing comment
		System.out.println(codeLine + "User Comment --> " + User_Comment);
		if (reportFlag > 0)
			extentTest.log(Status.INFO, codeLine + "User Comment --> " + User_Comment);

	}
	
	public static void CLICK(String xpathName) throws Exception {
		
		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());
		
		try {
			// Check if xpathName is found in PO DataSet
			String xpathValue = File_Reader.findXpathValue(xpathName);
			
			element = driver.findElement(By.xpath(xpathValue));
			Miscellaneous.highLight(driver, element);
			element.click();
				
			System.out.println(codeLine + "SUCCESS -> " + xpathName + " element clicked");
			if (reportFlag > 0)
				extentTest.log(Status.PASS, codeLine + "SUCCESS -> " + xpathName + " element clicked");

		} catch (Exception e) {
			System.out.println(codeLine + "ERROR -> " + xpathName + " element does not exist or previous step failed, hence not clicked");
			if (reportFlag > 0)
				extentTest.log(Status.FAIL, codeLine + "ERROR -> " + xpathName + " element does not exist or previous step failed, hence not clicked");
			throw e;
		} finally {
			// Close the browser optional
			// driver.quit();
		}
	}

	public static Boolean EXISTS(String xpathName) throws Exception {
		
		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());
		
		try {
			// Check if xpathName is found in PO DataSet
			String xpathValue = File_Reader.findXpathValue(xpathName);
			
			element = driver.findElement(By.xpath(xpathValue));
			element.isDisplayed();
			Miscellaneous.highLight(driver, element);

			System.out.println(codeLine + "SUCCESS -> " + xpathName + " element displayed");
			if (reportFlag > 0)
				extentTest.log(Status.PASS, codeLine + "SUCCESS -> " + xpathName + " element displayed");
			return true;

		} catch (Exception e) {
			System.out.println(codeLine + "ERROR -> " + xpathName + " element not displayed or previous step failed");
			if (reportFlag > 0)
				extentTest.log(Status.FAIL, codeLine + "ERROR -> " + xpathName + " element not displayed or previous step failed");
			throw e;
		} finally {
			// Close the browser optional
			// driver.quit();
		}
	}

	public static void EXISTS_in30Secs(String xpathName) throws Exception {

		int timeoutInSeconds = 30;
		
		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		try {

			// Check if xpathName is found in PO DataSet
			String xpathValue = File_Reader.findXpathValue(xpathName);
			
			// define elements locator
			By elementLocator = By.xpath(xpathValue);

			// Create a WebDriverWait Object
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			
			// wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
			element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			Miscellaneous.highLight(driver, element);
			
			System.out.println(codeLine + "SUCCESS -> " + xpathName + " element exists within " + timeoutInSeconds + " seconds");
			if (reportFlag > 0)
				extentTest.log(Status.PASS, codeLine + "SUCCESS -> " + xpathName + " element exists within " + timeoutInSeconds + " seconds");

		} catch (Exception e) {
			System.out.println(codeLine + "ERROR -> " + xpathName + " element not found within " + timeoutInSeconds + " seconds or previous step failed");
			if (reportFlag > 0)
				extentTest.log(Status.FAIL, codeLine + "ERROR -> " + xpathName + " element not found within " + timeoutInSeconds + " seconds or previous step failed");
			throw e;
		}
	}

	public static void EXISTS_in30Secs_CLICK(String xpathName) throws Exception {

		int timeoutInSeconds = 30;
		
		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		try {
			

			// Check if xpathName is found in PO DataSet
			String xpathValue = File_Reader.findXpathValue(xpathName);
			
			// define elements locator
			By elementLocator = By.xpath(xpathValue);

			// Create a WebDriverWait Object
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			// wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
			element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			Miscellaneous.highLight(driver, element);
			element.click();
			
			System.out.println(codeLine + "SUCCESS -> " + xpathName + " element exists and clicked");
			if (reportFlag > 0)
				extentTest.log(Status.PASS, codeLine + "SUCCESS -> " + xpathName + " element exists and clicked");

		} catch (Exception e) {
			System.out.println(codeLine + "SUCCESS -> " + xpathName + " element does not exist or previous step failed, hence not clicked");
			if (reportFlag > 0)
				extentTest.log(Status.FAIL, codeLine + "ERROR -> " + xpathName + " element does not exist or previous step failed, hence not clicked");
			throw e;
		}
	}

	public static void GET_PAGE_OBJECTS(String fileName1) {

		String cvsFilePath = "PO_DataSets";
		// Concatenate file path and name
		POFileName = cvsFilePath + "/" + fileName1;

		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());
		System.out.println(codeLine + "PO DataSet selected --> " + fileName1);
		// File PO_File = new File(POFileName);
		// System.out.println("PO DataSet file location: --> " +
		// PO_File.getAbsolutePath());
		if (reportFlag > 0)
			extentTest.log(Status.INFO, codeLine + "PO DataSet selected --> " + fileName1);
	}
	
	public static void GET_TESTDATA_VALUES(String fileName1) {

		String cvsFilePath = "TestData_DataSets";
		// Concatenate file path and name
		TestDataFileName = cvsFilePath + "/" + fileName1;

		// File PO_File = new File(TestDataFileName);
		// System.out.println("TestData DataSet file location: --> " +
		// TestDataFileName.getAbsolutePath());
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());
		System.out.println(codeLine + "TestData DataSet selected --> " + fileName1);
		if (reportFlag > 0)
			extentTest.log(Status.INFO, codeLine + "TestData DataSet selected --> " + fileName1);
	}
	
	public static void IF_EXISTS_CLICK(String xpathName) throws Exception {

		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		try {
			// Check if xpathName is found in PO DataSet
			String xpathValue = File_Reader.findXpathValue(xpathName);
			
			// define elements locator
			By elementLocator = By.xpath(xpathValue);

			int timeoutInSeconds = 5;

			// Create a WebDriverWait Object
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			// wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
			element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			Miscellaneous.highLight(driver, element);
			element.click();			
			
			System.out.println(codeLine + "INFO -> " + xpathName + " element exists and clicked");
			if (reportFlag > 0)
				extentTest.log(Status.INFO, codeLine + "INFO -> " + xpathName + " element exists and clicked");

		} catch (Exception e) {
			System.out.println(codeLine + "INFO -> " + xpathName + " element does not exist, hence not clicked (expected)");
			if (reportFlag > 0)
				extentTest.log(Status.INFO, codeLine + "INFO -> " + xpathName + " element does not exist, hence not clicked (expected)");
		}
	}

	public static void INITIALIZE() {
	
		// read parameters from config file
		File_Reader.getAllParameters();
		POFileName = "";
		TestDataFileName = "";
		codeLine = "";
	}

	public static void INPUT(String xpathName, String input)throws Exception {

		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		try {
			// Check if xpathName and input are located in DataSets
			String xpathValue = File_Reader.findXpathValue(xpathName);
			String inputValue = File_Reader.findInputValue(input);
			
			element = driver.findElement(By.xpath(xpathValue));
			element.sendKeys(inputValue);
			if(element.getDomAttribute("type").equalsIgnoreCase("password"))				
				inputValue="**********";
			//getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());
			System.out.println(codeLine + "SUCCESS --> " + inputValue + " was entered on element " + xpathValue);
			if (reportFlag > 0)
				extentTest.log(Status.INFO, codeLine + "SUCCESS --> " + inputValue + " was entered on element " + xpathValue);

		} catch (Exception e) {
			//getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());
			System.out.println(codeLine + "ERROR -> INPUT FAILED on element " + xpathName);
			if (reportFlag > 0)
				extentTest.log(Status.FAIL, codeLine + "ERROR -> INPUT FAILED on element " + xpathName);
			throw e;
		}

	}

	public static void ON_ERROR_LOGOUT() throws Exception {

		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		// Error message
		System.out.println(codeLine + "ERROR --> Previous step failed, ending test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		if (reportFlag > 0)
			extentTest.log(Status.FAIL, codeLine + "ERROR --> Previous step failed, ending test " + new Object() {
			}.getClass().getEnclosingMethod().getName(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
		// Close Browser
		assertTrue(1==2);
		driver.quit();
	}

	public static void OPEN_BROWSER() throws Exception {

		//Miscellaneous.closeAllBrowsers();
		INITIALIZE();
		// Get code line for report
		
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		// Creating webDriver instance
		EdgeOptions options = new EdgeOptions();
		if (HeadlessExecution.equalsIgnoreCase("YES"))
			options.addArguments("--headless");
		// options.addArguments(myProfilePath);// Use when a profile is created only
		options.addArguments("--remote-allow-origins=*");
		// WebDriver driver = new EdgeDriver(options);
		createDriver(options);
		// super(options);
		// Navigate to web page
		driver.get(URL);
		// use implicit wait to wait for pages to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Maximize window
		driver.manage().window().maximize();
		System.out.println(codeLine + "SUCCESS -> Navigated to: " + URL);
		System.out.println(codeLine + "SUCCESS -> Maximized browser");
		if (reportFlag > 0) {
			extentTest.log(Status.INFO, codeLine + "SUCCESS -> Navigated to: " + URL);
			extentTest.log(Status.INFO, codeLine + "SUCCESS -> Maximized browser");
		}
	}

	public static void WAIT(int timeInMillisec) throws Exception {

		// Get code line for report
		getCodeLine(Thread.currentThread().getStackTrace()[2].getLineNumber(),Thread.currentThread().getStackTrace()[2].getClassName());

		// Wait function
		Thread.sleep(timeInMillisec);
		System.out.println(codeLine + "SUCCESS -> Wait time applied: " + timeInMillisec);
		if (reportFlag > 0)
			extentTest.log(Status.INFO, codeLine + "SUCCESS -> Wait time applied: " + timeInMillisec);
	}

}
