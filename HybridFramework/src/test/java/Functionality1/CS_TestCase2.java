package Functionality1;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import Automation.HybridFramework.BaseClass;
import Automation.HybridFramework.Keyword;
import InitiateScript.Open_Browser;
import TestSuites.RunLocalTestInterface;
//import UserLogin.UserLogin_User1;
import UserLogin.UserLogin_User2;

public class CS_TestCase2 extends BaseClass {

	public void CS_TestCase2_Test() throws Exception {

		// ** Open Browser **
		Keyword.ADD_COMMENT_TO_LOG("Open Browser");
		Open_Browser.Open_Browser_Test();

		// ** Login to Application using User1 **
		Keyword.ADD_COMMENT_TO_LOG("Login to Application using User1");
		UserLogin_User2.UserLogin_User2_Test();
	}

	@Category(RunLocalTestInterface.class)
	@Test
	public void testApp() throws Exception {
		createTestCaseReport(new Object() {}.getClass().getName());
		System.out.println("In regular method");
		// Keyword.Selenium.HubBrowser = local;
		CS_TestCase2_Test();
	}
}
