package testnglearning;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testcases.TestProperties;

public class TestParametarization {

	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "getData")
	public void doLogin(String username, String password) throws InterruptedException {

		driver.get("http://gmail.com");
		String title = driver.getTitle();

		if (title.equals("Gmail - Free Storage and Email from Google")) {
			driver.findElement(By.xpath(
					"//ul[@class='h-c-header__cta-list header__nav--ltr']//a[contains(@class,'h-c-header__nav-li-link')][contains(text(),'Sign in')]"))
					.click();
			TestProperties.switchToSecondWindowUsingTitle(driver);		
		}

		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@DataProvider
	public Object[][] getData() {

		String sheetName = "LoginTest";
		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		System.out.println(rowNum - 1);
		Object[][] data = new Object[rowNum - 1][colNum];

		for (int rows = 2; rows <= rowNum; rows++) {
			for (int cols = 0; cols < colNum; cols++) {
				System.out.println(excel.getCellData(sheetName, cols, rows));
				data[rows - 2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
		return data;
	}

}
