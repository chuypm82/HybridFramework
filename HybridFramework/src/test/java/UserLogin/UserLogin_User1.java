package UserLogin;

import Automation.HybridFramework.Keyword;

public class UserLogin_User1 {
	
	public static void UserLogin_User1_Test() throws Exception{
		
		try {
			// ** Login Page **
			Keyword.ADD_COMMENT_TO_LOG("Login Page");
			Keyword.GET_PAGE_OBJECTS("PO_App_DS.csv");
			Keyword.GET_TESTDATA_VALUES("UserProfiles_App.csv");
			//Keyword.WAIT(1000);
			//Keyword.INPUT("txt_loginPg_userName","Jesus");//user
			Keyword.INPUT("//input[@id='inputUsername']","Jesus");//user
			//Keyword.WAIT(1000);
			Keyword.INPUT("txt_loginPg_password","rahulshettyacademy");//psw
			//Keyword.WAIT(1000);
			//Login to App
			Keyword.EXISTS_in30Secs_CLICK("//button[@class='submit signInBtn']");
			Keyword.WAIT(1000);		
			Keyword.EXISTS_in30Secs("//h2[contains(text(),'Hello')]");
			
		}catch (Exception e) {
	
			Keyword.ON_ERROR_LOGOUT();
		}
	}

}
