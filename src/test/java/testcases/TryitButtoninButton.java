package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TryitButtoninButton {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		
		driver.switchTo().frame("iframeResult");
//		driver.findElement(By.xpath("/html/body/button")).click();
		((JavascriptExecutor) driver).executeScript("myFunction()");
		//the following code defaultContent will switch to main page from iframe.	
		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Frames on main page: "+ frames.size()+"\n");
		
		for (WebElement frame : frames) {
			System.out.println(frame.getAttribute("id"));
		}
		
		driver.switchTo().defaultContent();
		System.out.println(" Windows on main page: "+ driver.getWindowHandles().size());
		
	}
}
