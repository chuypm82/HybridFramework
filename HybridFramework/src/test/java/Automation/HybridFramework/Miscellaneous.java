package Automation.HybridFramework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Miscellaneous{
	
	public static void closeAllBrowsers() throws Exception {
		
		// Kill all the active edge browser
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("taskkill /im msedge.exe");
		Thread.sleep(3000);
		proc = rt.exec("taskkill /f /im msedge.exe");
		
	}
	
	public static void highLight(WebDriver driver, WebElement element) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(500);
		//js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: red; border: 4px solid red;");//includes font color
		//js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 4px solid red;");// red
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: 4px solid blue;");// blue
		Thread.sleep(500);
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		
	}

}
