package InitiateScript;

import Automation.HybridFramework.BaseClass;
import Automation.HybridFramework.Keyword;

public class Open_Browser extends BaseClass{
	
	public static void Open_Browser_Test() throws Exception{
	
		try {
			// Open browser
			Keyword.OPEN_BROWSER();
			
		}catch (Exception e) {
	
			Keyword.ON_ERROR_LOGOUT();
		}
	}
}
