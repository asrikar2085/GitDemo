package E2E2;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;
import pageObjects.LandingPage;

public class validateNavigationBarTest extends base{
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	
@BeforeTest
	
	public void initialize() throws IOException
	{
	driver=initializeDriver();
	Log.info("driver is initialized - validateNavigationBar");
	driver.get(prop.getProperty("url"));
	Log.info("URL is retrieved - validateNavigationBar");
	MaxWindow();
	Log.info("Window is maximized - validateNavigationBar");
	}
	
@Test
	
	public void getNavigation() throws IOException
	{
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		Log.info("getNavigationBar value is displayed - validateNavigationBar");
				
	}
	
@AfterTest
	
	public void closewindow()
	{
		driver.close();
	}
	
	
}
