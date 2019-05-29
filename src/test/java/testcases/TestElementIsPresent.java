package testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestElementIsPresent {

	public static WebDriver driver;

	public static boolean isElementPresent(String xpath) {
		/*
		 * try { driver.findElement(By.xpath(xpath)); return true; } catch (Throwable t)
		 * { return false; }
		 */

		int num = driver.findElements(By.xpath(xpath)).size();

		if (num == 0) {
			return false;
		} else {
			return true;
		}

	}

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://gmail.com");
		boolean flag = isElementPresent("//input[@id='identifierId']");
		System.out.println("is element present: "+flag);
	}

}
