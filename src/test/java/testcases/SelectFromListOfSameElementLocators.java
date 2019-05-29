package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectFromListOfSameElementLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://qa.way2automation.com");
		//This will return a list of webelements which has same locators now click using the 
		//index of element
		driver.findElements(By.xpath("//input[@value='Submit']")).get(1).click();
	}
}
