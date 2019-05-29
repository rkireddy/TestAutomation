package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {

	@Test(priority = 2, dependsOnMethods = "doUserReg",groups = "p3")
	public void doLogin() {
		System.out.println("Executing Login test");
	}

	@Test(priority = 1,groups = "p3")
	public void doUserReg() {
		System.out.println("Executing User Reg test");
//		Assert.fail("User not registered successfully");
	}

	@Test(priority = 3,groups = "p2")
	public void isSkip() {
		throw new SkipException("Skiping the test as the condition is not met");
	}

}
