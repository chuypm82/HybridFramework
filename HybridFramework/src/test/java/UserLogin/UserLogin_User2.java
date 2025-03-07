package UserLogin;

import Automation.HybridFramework.Keyword;

public class UserLogin_User2 {
	
	public static void UserLogin_User2_Test() throws Exception {
		
		try {
			// ** Login Page **
			Keyword.ADD_COMMENT_TO_LOG("Login Page");
			Keyword.GET_PAGE_OBJECTS("PO_App_DS.csv");
			Keyword.GET_TESTDATA_VALUES("UserProfiles_App.csv");
			//Keyword.EXISTS("//input[@id='inputUsername']");
			//Keyword.INPUT("//input[@id='inputUsername']","Jesus");//user
			//Keyword.INPUT("txt_loginPg_userName","Jesus");//user
			Keyword.CLICK("txt_loginPg_userName");
			Keyword.INPUT("txt_loginPg_userName","App_Admin1");//user
			Keyword.INPUT("txt_loginPg_password","App_Admin1_Pwd");//psw
			
		}catch (Exception e) {
	
			Keyword.ON_ERROR_LOGOUT();
		}
	}

}
