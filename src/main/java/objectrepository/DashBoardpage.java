package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardpage {
	
	//driver
	WebDriver driver;
	
	public DashBoardpage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	
	//Locators
	By m1 = By.xpath("....");
	By m2 = By.xpath("....");
	By m3 = By.xpath("....");
	
	//Webelements
	public WebElement getm1()
	{
		WebElement m1e = driver.findElement(m1);
		return m1e;
	}
	public WebElement getm2()
	{
		WebElement m1e = driver.findElement(m2);
		return m1e;
	}
	private WebElement getm3()
	{
		WebElement m1e = driver.findElement(m1);
		return m1e;
	}
	
	//Actions
	public void Clickm1()
	{	
		getm1().click();
	}
	public void Clickm2()
	{	
		getm2().click();
	}
	public void Clickm3()
	{	
		getm3().click();
	}	

}
