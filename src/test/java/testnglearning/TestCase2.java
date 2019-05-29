package testnglearning;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import testcases.TestProperties;

public class TestCase2 {
	@Test(groups = {"p1","p2"})
	public void validateTitle() {
		String actual_title = "Google.com";
		String expected_title = "Yahoo.com";
		/*
		 * if (actual_title.equals(expected_title)) {
		 * System.out.println("Test case passed"); }else {
		 * System.out.println("Test case failed"); } }
		 */
//		assertEquals(actual_title, expected_title);
		Assert.assertTrue(false,"Element not found");

	}
}
