package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriver {
	String browser;

	public BrowserDriver(String browser) {
		this.browser = browser;
	}

	public WebDriver getDriver() throws IOException {
		
		WebDriver driver = null;
				
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			Assert.assertFalse(false);
		}
		return driver;
	}

}
