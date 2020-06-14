package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	//Declare the variables as private to achieve encapsulation in the framework. 
	//This will hide the data implementation & the variables are not accessible from other classes.
	//These variables can only be accessed using the below public methods.
	private By signin = By.xpath("//span[contains(text(),'Login')]");
	private By title = By.cssSelector(".text-center h2");
	private By NavigationBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage LoginButton()
	{
		driver.findElement(signin).click();
		LoginPage lp1 = new LoginPage(driver);
		return lp1;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavigationBar);
	}
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
	
	public int getpopupsize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getpopup()
	{
		return driver.findElement(popup);
	}

}
