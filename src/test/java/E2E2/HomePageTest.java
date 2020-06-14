package E2E2;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base{
	
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
@BeforeTest
	
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		Log.info("driver is initialized - HomePage");
	}
	
	@Test(dataProvider="getdata")
	
	public void HomePageNavigation(String Username, String Password) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		Log.info("URL is retrieved - HomePage");
		MaxWindow();
		Log.info("Window is maximized - HomePage");
		LandingPage lp = new LandingPage(driver);
		LoginPage lp1=lp.LoginButton();
		//LoginPage lp1 = new LoginPage(driver);
		lp1.EmailId().sendKeys(Username);
		Log.info("Email is entered - HomePage");
		lp1.Password().sendKeys(Password);
		Log.info("password is entered - HomePage");
		lp1.Login().click();
		
		ForgotPassword fp = lp1.Forgotpwd();
		fp.Resetpwd().sendKeys("asrikar@gmail.com");
		fp.Sendlink().click();
		
		
		
	}
	
	@DataProvider
	
	public Object[][] getdata()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "asrikar2085@gmail.com";
		data[0][1] = "tp123";
		
		data[1][0] = "asrikar@gmail.com";
		data[1][1] = "tp123";
		
		return data;
		
	}
	
@AfterTest
	
	public void closewindow()
	{
		driver.close();
	}

}
