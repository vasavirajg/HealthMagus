package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

public class TestListeners implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + "::" + result.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Method " + result.getMethod().getMethodName() + " Successful");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
		extentTest.get().log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
		
		//Add Screenshot
		WebDriver driver = ((BaseTest)result.getInstance()).driver;
		String screenshotPath = "";
		try {
			screenshotPath = getScreenshot(driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			System.out.println("onTestFailure");
			e.printStackTrace();
		}
		extentTest.get().log(Status.FAIL, (Markup) extentTest.get().addScreenCaptureFromPath(screenshotPath));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Test Method " + result.getMethod().getMethodName() + " Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}

	}	

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyymmdd").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// After execution you could see a folder "reports".
		String destination = System.getProperty("user.dir") + "\\reports\\" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		System.out.println("getScreenshot at " + destination);
		return destination;
	}

}
