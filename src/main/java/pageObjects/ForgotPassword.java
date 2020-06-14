package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	
	public WebDriver driver;
	
	By email = By.id("user_email");
	By submit = By.name("commit");
	
	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Resetpwd()
	{
		return driver.findElement(email);
	}
	
	public WebElement Sendlink()
	{
		return driver.findElement(submit);
	}
	
}
