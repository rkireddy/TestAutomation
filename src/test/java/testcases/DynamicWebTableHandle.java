package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) {
		// username= rkireddy password=test@123
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://classic.crmpro.com/index.html");

		driver.findElement(By.name("username")).sendKeys("rkireddy");
		driver.findElement(By.name("password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// a[@title='Contacts'] or //*[@id='navmenu']/ul/li[4]/a
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();

		String beforeXpath = "//*[@id='vContactsForm']/table/tbody/tr[";
		String afterXpath = "]/td[2]/a";

		// Method -1

		/*
		 * for (int i = 4; i <= 8; i++) { String name =
		 * driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
		 * System.out.println("Name of contact: " + name + " rowNumber: " + i); if
		 * (name.contentEquals("test2 test2")) {
		 * driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[" + i +
		 * "]/td[1]/input")).click(); break; } }
		 */

		// a[contains(text(),'test2
		// test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']

		// Method-2
		driver.findElement(By.xpath(
				"//a[contains(text(),'test2 test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']"))
				.click();

	}
}
