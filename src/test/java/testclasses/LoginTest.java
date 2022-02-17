package testclasses;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.Loginpage;
import utility.GlobalValuesDrive;

public class LoginTest extends BaseTest {
	@Parameters({"user", "password","clinic"})
	@Test
	public void Login(@Optional("")String user, String password, String clinic) throws IOException {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		
		GlobalValuesDrive gvdrive = new GlobalValuesDrive();
		gvdrive.Initialize();
		String env= gvdrive.getEnvironment();
		if (env.equals("qa")) {
			driver.get(gvdrive.getQaUrl());
		} else if (env.equals("dev")) {
			driver.get(gvdrive.getDevUrl());
		} else {
			Assert.assertFalse(false);
		}
		
		//For now including implicit wait. Need to Handle properly.
		//driver.manage().timeouts().getImplicitWaitTimeout();
		
		String title = driver.getTitle();
		if (title.equals(gvdrive.getTitle())) {
			System.out.println(title + "is correct");
			Loginpage loginpg = new Loginpage(driver);
			loginpg.SetEmailid(user);
			loginpg.SetPassword(password);
			loginpg.SelectClinic(clinic);
			loginpg.ClickLogin();
		} else {
			System.out.println(title + "is not correct");
			Assert.assertFalse(true);
		}
		//driver.quit();
	}
}
