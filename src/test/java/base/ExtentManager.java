package base;

import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extent;

	public static ExtentReports createInstance() {		
		
		String path = System.getProperty("user.dir") + "\\reports" + "\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Lead", "Rajendra");
		return extent;

	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

}
