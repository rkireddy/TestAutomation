package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestKeyBoadKeys {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://gmail.com");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("trainer@way2automation.com");
		// Actions action = new Actions(driver);
		// this will performone sigle keyboard key event
		// action.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div")).click();
		Actions action = new Actions(driver);
		
		// This will do a combination opf keyboard keys controland a to select all.
		action.sendKeys(Keys.chord(Keys.CONTROL + "a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		driver.findElement(By.xpath("//input[@id='identifierId']")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL + "a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
	}
}
