package UnitTests;

import org.junit.Assert;
import org.junit.Test;

import com.aventstack.extentreports.Status;

import Automation.HybridFramework.BaseClass;

public class TestExtentReportBasic extends BaseClass{

	//@Test
	public void testPassed() {
		extentTest = extentReports.createTest("Test Case 1", "This test case has passed");
		extentTest.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extentTest.log(Status.INFO, "This is a logging event for MyFirstTest, its just informative");
		Assert.assertTrue(true);
	}

	//@Test
	public void testFailed() {
		extentTest = extentReports.createTest("Test Case 2", "This test case has failed");
		extentTest.log(Status.FAIL, "This is a logging event for MyFirstTest, and it failed!");
		Assert.assertTrue(false);
	}

	//@Test
	public void testSkipped() {
		extentTest = extentReports.createTest("Test Case 3", "This test case has been skipped");
		extentTest.log(Status.SKIP, "This is a logging event for MyFirstTest, and the scenraio was skipped!");
		//throw new SkipException("The test has been skipped");
	}

}
