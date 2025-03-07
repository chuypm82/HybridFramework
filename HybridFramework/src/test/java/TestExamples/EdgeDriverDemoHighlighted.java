package TestExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import Automation.HybridFramework.Miscellaneous;

public class EdgeDriverDemoHighlighted {

	public static void main(String[] args) throws InterruptedException {
		
		//Creating webDriver instance
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver= new EdgeDriver(options);
		
		//WebDriver driver= new FirefoxDriver();
		
		//Navigate to web page
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//use implicit wait to wait for pages to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Maximize window
		driver.manage().window().maximize();
		
		//Retrieving web page title
		String title= driver.getTitle();
		System.out.println("The page title is: "+ title);
		
		//Locating web element
		WebElement uName= driver.findElement(By.xpath("//input[@id='inputUsername']"));
		WebElement pass= driver.findElement(By.xpath("//input[@name='inputPassword']"));
		WebElement loginBtn= driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		
		//Performing actions on web elements
		Thread.sleep(1000);
		uName.sendKeys("Jesus");
		Thread.sleep(1000);
		pass.sendKeys("rahulshettyacademy");
		
		
		Miscellaneous.highLight(driver, loginBtn);
		
		loginBtn.click();
		//putting implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(2000);
		
		//Validate user was able to login
		
		try {
			//locating web element
			WebElement logOutBtn= driver.findElement(By.xpath("//button[@class='logout-btn']"));
			Miscellaneous.highLight(driver, logOutBtn);
			Thread.sleep(2000);
			//validating presence of web element
			if(logOutBtn.isDisplayed()) {
				//Performing action on web element
				logOutBtn.click();
				System.out.println("Logout Successful");	
			}			
		}
		catch (Exception e){
			System.out.println("Incorrec Login...");
			
		}	
		Thread.sleep(2000);
		//Closing browser session
		//driver.quit();

	}

}
