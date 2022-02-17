package testclasses;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import objectrepository.DashBoardpage;
import utility.BrowserDriver;
import utility.GlobalValuesDrive;

public class DashBoardTest {
	@Test
	void DashboardMenu() throws IOException {
		
		GlobalValuesDrive gvdriver = new GlobalValuesDrive();
		gvdriver.Initialize();	
		
		BrowserDriver d = new BrowserDriver(gvdriver.getBrowser());
		WebDriver driver = d.getDriver();
		
		DashBoardpage dashboard = new DashBoardpage(driver);

		dashboard.Clickm1();
		dashboard.Clickm2();
		dashboard.Clickm3();
	}
}
