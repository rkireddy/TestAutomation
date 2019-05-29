package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHigLightCaptureScreenShot {
	public static WebDriver driver;

	public static void captureScreenShot() throws IOException {
		Date d = new Date();
		String fileName = d.toString().replace(":", "-").replace(" ", "_")+".jpg";

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir") + "//screenShot//"+fileName));
	}

	public static void main(String[] args) throws IOException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		// Highlight the element with Red color boarder
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
				driver.findElement(By.xpath("//input[@id='mySubmit']")));
		captureScreenShot();
	}

}
