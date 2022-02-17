package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Loginpage {
	WebDriver driver;

	By email = By.xpath("//input[@id=\"email\"]");
	By password = By.xpath("//input[@id=\"password\"]");
	By clinic = By.xpath("//select[@name=\"selectedClinics\"]");
	By login = By.xpath("//button");

	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Emailid() {

		return driver.findElement(email);
	}

	public WebElement Password() {

		return driver.findElement(password);
	}

	public WebElement Clinic() {

		return driver.findElement(clinic);
	}

	public WebElement Login() {		
		return driver.findElement(login);
	}

	// Actions
	public void SelectClinic(String clinic) {
		Select select_clinic = new Select(Clinic());
		select_clinic.selectByVisibleText(clinic);
	}

	public void SetEmailid(String email) {
		Emailid().sendKeys(email);
	}

	public void SetPassword(String password) {
		Password().sendKeys(password);
	}
	
	public void ClickLogin() {
		Login().click();
	}
	
}
