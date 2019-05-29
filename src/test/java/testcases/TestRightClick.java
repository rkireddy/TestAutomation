package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestRightClick {

	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		Actions action = new Actions(driver);
		WebElement img = driver.findElement(By.xpath("//img[@style='cursor: pointer;']"));
		action.contextClick(img).perform();
	}

}
