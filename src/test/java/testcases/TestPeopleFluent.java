package testcases;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPeopleFluent {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("https://www.peoplefluent.com/request-demo");
		// a[@class='nav-utility__link'][contains(text(),'Newsroom')]
		driver.findElement(By.linkText("Newsroom")).click();
		String title = driver.findElement(By.xpath("//div[contains(text(),'Newsroom')]")).getText();
		System.out.println(title);
		if (title.equals("Newsroom")) {
			System.out.println("true");
		};
		
		driver.findElement(By.linkText("Community Login")).click();

		// get Window Handles
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindwoId = it.next().toString();
		String childWindowId = it.next().toString();

		System.out.println(parentWindwoId);
		System.out.println(childWindowId);

		driver.switchTo().window(childWindowId);
		
		WebElement element = driver.findElement(By.xpath("//*[@id='primaryLogo']/img"));
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("raj@email.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abcdes");
		driver.findElement(By.xpath("//input[@name='login']")).click();

	}
}
