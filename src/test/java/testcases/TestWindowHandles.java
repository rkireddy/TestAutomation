package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestWindowHandles {

	public static void main(String[] args) throws InterruptedException {

		// Adding options to disable the popup notifications.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get("https://www.hdfcbank.com/personal/HNW_Banking/hnw_banking");
		driver.findElement(By.xpath("//div[@class='loginetbank']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'NetBanking')]")).click();
		driver.findElement(By.xpath("//a[@id='loginsubmit']")).click();

		Set<String> windows = driver.getWindowHandles();

		Iterator<String> it = windows.iterator();
		String parentWindowId = it.next().toString();
		String secondWindowId = it.next().toString();

		// Print window handles
		windows = driver.getWindowHandles();
		System.out.println("Number of Window Handles: " + windows.size());

		it = windows.iterator();
		while (it.hasNext()) {
			System.out.println("windowHandles: " + it.next());
		}

		driver.switchTo().window(secondWindowId);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[4]/div[2]/div[1]/a")).click();
		String tittle = driver.getTitle();
		System.out.println(tittle);
		System.out.println(driver.getTitle().contains("NetBanking"));
		driver.close();
		// Switch back to main page
		driver.switchTo().window(parentWindowId);
		driver.close();
	}

}
