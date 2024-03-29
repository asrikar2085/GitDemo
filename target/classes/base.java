package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		//String browsername = System.getProperty("browser");
		System.out.println(browsername);
		
		if (browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			
			if (browsername.contains("headless"))
			{
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless","user-agent=rock");
				driver = new ChromeDriver(co);
			}
			else
			{
				driver = new ChromeDriver();
			}
		}
		else if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public void MaxWindow()
	{
		
		driver.manage().window().maximize();
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		base.driver = driver;
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.dir"));
		String Destination = System.getProperty("user.dir") +"\\reports\\"+testCaseName+".png";
		System.out.println(Destination);
		FileUtils.copyFile(Source,new File(Destination));
		return Destination;
		
	}

}
