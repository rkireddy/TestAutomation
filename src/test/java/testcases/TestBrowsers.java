package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	public static String browser = "chrome";
	public static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.isEmpty()) {
			System.out.println("Browser not entered, please use chrome or firefox or ie: ");
		}
		driver.get("http://gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("trainer@way2automation.com");

		driver.findElement(By.xpath("//content[@class='CwaK9']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abcdeeee");
		
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='GQ8Pzc']")));
		String str = driver.findElement(By.xpath("//div[@class='GQ8Pzc']")).getText();
		System.out.println("Message: "+str);
		
		driver.quit();

	}

}
