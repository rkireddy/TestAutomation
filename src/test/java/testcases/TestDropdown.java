package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * driver.get("http://www.echoecho.com/htmlforms11.htm");
		 * driver.findElement(By.xpath("//select[@name='dropdownmenu']")).sendKeys(
		 * "Cheese");
		 */

		driver.get("https://www.wikipedia.org/");
		/*
		 * driver.findElement(By.xpath("//select[@name='language']")).click();
		 * driver.findElement(By.xpath("//select[@name='language']")).sendKeys("WAR");
		 * driver.findElement(By.xpath("//body[@id='www-wikipedia-org']")).click();
		 */
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchLanguage']"));
		Select select = new Select(dropdown);
		// select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		List<WebElement> values = select.getOptions();
		// List<WebElement> values = driver.findElements(By.tagName("option"));
		System.out.println("Option List " + values.size());
		System.out.println(values.get(1).getText());
		
		/*
		 * for (WebElement dd : values) { System.out.println(dd.getAttribute("lang")); }
		 */

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links on the page: " +links.size());

		/*
		 * for (WebElement ht : links) { System.out.println(
		 * "Printing Link URLs on the page --- " + ht.getAttribute("href") +
		 * "  --- Text ----" + ht.getText()); }
		 */
		WebElement  block = driver.findElement(By.xpath("//div[@class='other-projects']"));
		List<WebElement> blockurls = block.findElements(By.tagName("a"));
		System.out.println("number of URL Links in the Other Block is: " +blockurls.size());

	}
}
