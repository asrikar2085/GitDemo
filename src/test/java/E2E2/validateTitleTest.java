package E2E2;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitleTest extends base{
	
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	LandingPage lp;

	
@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		Log.info("driver is initialized - validateTitle");
		driver.get(prop.getProperty("url"));
		Log.info("URL is retrieved - validateTitle");
		MaxWindow();
		Log.info("Window is maximized - validateTitle");
	}
	
@Test
	
	public void getTitle() throws IOException
	{
		
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		Log.info("Title bar value is displayed - validateTitle");
		
	}

public void getHeader() throws IOException
{
	
	Assert.assertEquals(lp.getTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	Log.info("Header is displayed - validateTitle");
	
}
	
@AfterTest
	
	public void closewindow()
	{
		driver.close();
		System.out.println("closing the driver");
	}

}
