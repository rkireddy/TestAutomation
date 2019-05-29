package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		
		/*
		 * driver.switchTo().alert().getText(); driver.switchTo().alert().accept();
		 */
		//Instead of swithchingto alert twice to do actin on it as above we can capture the 
			//	alert and do acations as shown below
		
		Alert alert = driver.switchTo().alert();
		String str = alert.getText();
		System.out.println("Alert Message: " + str);
		alert.accept();
	}

}
