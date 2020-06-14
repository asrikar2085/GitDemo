package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
	public WebDriver driver;
	
	By email = By.id("user_email");
	By pwd = By.id("user_password");
	By submit = By.name("commit");
	By ForgotPwd = By.cssSelector("a[href*='password/new']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement EmailId()
	{
		return driver.findElement(email);
	}
	
	public WebElement Password()
	{
		return driver.findElement(pwd);
	}
	
	public WebElement Login()
	{
		return driver.findElement(submit);
	}
	
	public ForgotPassword Forgotpwd()
	{
		driver.findElement(ForgotPwd).click();
		return new ForgotPassword(driver);
	}
}
