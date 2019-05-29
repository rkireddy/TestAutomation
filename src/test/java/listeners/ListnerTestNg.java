package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerTestNg implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// This argument getname will print the test case name
		Reporter.log("Test case passed " + " Test case name : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// add the following system property to avoid the escape characters given in the
		// Reportng log given to display the link and thumb nail.
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		// target="-blank" will open the link in new tab
		Reporter.log("<a target = \"_blank\" href=\"C:\\links\\Error.jpg\">Screenshot link</a>");
		// For new line
		Reporter.log("<br>");
		// For adding a thumb nail of the image to the report
		Reporter.log(
				"<a target = \"_blank\" href=\"C:\\links\\Error.jpg\"><img src=\"C:\\links\\Error.jpg\"height=200 width=200></a>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
