package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
		
	@BeforeTest
	public void createDBConn() {
		System.out.println("Opening DB Connection");
	}

	@AfterTest
	public void closeDBConn() {
		System.out.println("Closing DB connection");
	}

	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Launching browser");
	}

	@Test(priority = 2,groups = "p2")
	public void doLogin() {
		System.out.println("Executing Login test");
		Reporter.log("Inside Login Test");
	}

	@Test(priority = 1,groups = "p1")
	public void doUserReg() {
		System.out.println("Executing User Reg test");
		/*
		 * try { Assert.fail(); }catch(Throwable t) {
		 * Reporter.log("Test case failed from catch block"); }
		 */ //instead of try catch block for each failure use Listeners class
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Closing Browser");
	}
}
