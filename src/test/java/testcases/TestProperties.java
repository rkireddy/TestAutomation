package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestProperties {

	/*
	 * 
	 * 
	 * log4j api - jar Logger Appenders - log4j.properties
	 * 
	 */

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static int size;
//		public static Logger log = Logger.getLogger(TestLogs.class);
//		public static MonitoringMail mail = new MonitoringMail();
	public static String fileName;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "//screenshot//" + fileName));

	}

	public static void click(String locatorKey) {

		try {
			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();

			}

			else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();

			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

				driver.findElement(By.id(locatorKey)).click();

			}

//			log.info("Clicking on an Element : " + locatorKey);
		} catch (Throwable t) {
			// Capture screenshot
			// send mail with attachment

		}
	}

	public static void type(String locatorKey, String value) throws IOException, AddressException, MessagingException {
		try {
			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);

			}

			else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);

			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

				driver.findElement(By.id(locatorKey)).sendKeys(value);

			}

//			log.info("Typing in an Element : " + locatorKey+" entered the value as : "+value);
		} catch (Throwable t) {

//				log.info("Error while Typing in an Element : "+locatorKey);
//				log.error(t.getMessage());
			captureScreenshot();
//				mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, t.getMessage(), System.getProperty("user.dir")+"//screenshot//"+fileName, fileName);
			t.printStackTrace();
		}
	}

	public static boolean isElementPresentByXpath(String locatorKey) {
		try {
			driver.findElement(By.xpath(locatorKey));
			return true;
		} catch (Throwable t) {
			return false;
		}
	}

	public static boolean isSecondWindowByTitlePresent(String title, String expected) {
		if (title.equals(expected)) {
		}
		return true;
	}

	public static void switchToSecondWindowUsingTitle(WebDriver driver) throws InterruptedException {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindowId = it.next().toString();
		String secondWindowId = it.next().toString();
		// Print window handles
		/*
		 * windows = driver.getWindowHandles();
		 * System.out.println("Number of Window Handles: " + windows.size());
		 * it = windows.iterator(); while (it.hasNext()) {
		 * System.out.println("windowHandles: " + it.next()); }
		 */
		driver.close();
		driver.switchTo().window(secondWindowId);
		Thread.sleep(1000);
	}

	public static boolean isElementPresent(String locatorKey) {

		try {

			if (locatorKey.endsWith("_XPATH")) {

				driver.findElement(By.xpath(OR.getProperty(locatorKey)));

			}

			else if (locatorKey.endsWith("_CSS")) {

				driver.findElement(By.cssSelector(OR.getProperty(locatorKey)));

			} else if (locatorKey.endsWith(OR.getProperty("_ID"))) {

				driver.findElement(By.id(locatorKey));

			}

//				log.info("Finding the Element : "+locatorKey);
			return true;
		} catch (Throwable t) {

			return false;
		}

	}

	public static void main(String[] args) throws IOException, AddressException, MessagingException {

		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

		/*
		 * //System.setProperty("webdriver.chrome.driver", value) WebDriver driver = new
		 * ChromeDriver();
		 */
		// System.out.println(System.getProperty("user.dir"));

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
//			log.info("OR Properties loaded !!!");

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
//			log.info("Config Properties loaded !!!");

		/*
		 * //driver.findElement(By.xpath(OR.getProperty("username_XPATH")).click();
		 * System.out.println(OR.getProperty("username_XPATH"));
		 * System.out.println(Config.getProperty("testsiteurl"));
		 * //driver.get(Config.getProperty("testsiteurl"));
		 */

		if (Config.getProperty("browser").equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
//				log.info("Firefox Launched !!!");

		} else if (Config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
//				log.info("Chrome Launched !!!");

		} else if (Config.getProperty("browser").equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.get(Config.getProperty("testsiteurl"));
//			log.info("Navigated to : " + Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implict.wait")),
				TimeUnit.SECONDS);

		// wait = new WebDriverWait(driver, 10);

		wait = new WebDriverWait(driver, Integer.parseInt(Config.getProperty("explicit.wait")));

		type("username_XPATH", "trainer@way2automation.com");
		click("nextBtn_XPATH");

		/*
		 * System.out.println(isElementPresent("closeBtn_XPATH"));
		 * 
		 * // driver.findElement(By.xpath(OR.getProperty("closeBtn_xpath"))).click();
		 * 
		 * click("closeBtn_xpath");
		 * 
		 * OR.getProperty("username_XAPTH"); click("btn_XPATH");
		 * 
		 * 
		 * click type tyep getTxt
		 * 
		 * 
		 * add(10, 20);
		 */
	}

}
