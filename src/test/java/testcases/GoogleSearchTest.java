package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java");
		// ul[@role='listbox']//li//div[contains(@class,'sbl1')]/span
		// ul[@role='listbox']//li/descendant::div[@class='sbl1']/span
		// ul[@role='listbox']//li/descendant::div[contains(@class,'sbl1')]/span
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li//div[contains(@class,'sbl1')]/span"));
		System.out.println("Totoal number of suggestions in search box: --> " + list.size());

		for (WebElement l : list) {
			System.out.println(l.getText());
			if (l.getText().contains("javascript array")) {
				l.click();
				break;
			}
		}

		/*
		 * for (int i = 0; i < list.size(); i++) {
		 * System.out.println(list.get(i).getText()); if
		 * (list.get(i).getText().contains("javascript array")) { list.get(i).click();
		 * break; } }
		 */

	}

}
