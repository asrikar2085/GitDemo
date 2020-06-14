package stepdefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

   // @RunWith(Cucumber.class)
	public class stepdefinition extends base{
		
		public LoginPage lp1;
		public static Logger Log = LogManager.getLogger(base.class.getName());

	    @Given("^Initialize the driver$")
	    public void initialize_the_driver() throws Throwable {
	    	
	            driver=initializeDriver();
	        
	    }
	    
	    @And("^User launches the \"([^\"]*)\" website$")
	    public void user_launches_the_something_website(String strArg1) throws Throwable {
	    	driver.get(strArg1);
			Log.info("URL is retrieved - HomePage");
			MaxWindow();
			Log.info("Window is maximized - HomePage");
			
			
	    }

	    @And("^User clicks on Login Button$")
	    public void user_clicks_on_login_button() throws Throwable {
	    	LandingPage lp = new LandingPage(driver);
	    	Thread.sleep(10000);
	    	if(lp.getpopupsize() > 0)
	    	{
	    		lp.getpopup().click();
	    	}
	    	lp1=lp.LoginButton();
	    }

	    /*@When("^User enter username \"([^\"]*)\" and password \"([^\"]*)\" and logs in$")
	    public void user_enter_username_something_and_password_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
	    	lp1.EmailId().sendKeys(strArg1);
			Log.info("Email is entered - HomePage");
			lp1.Password().sendKeys(strArg2);
			Log.info("password is entered - HomePage");
			lp1.Login().click();
	    }*/
	    
	    @When("^User enter username (.+) and password (.+) and logs in$")
	    public void user_enter_username_and_password_and_logs_in(String username, String password) throws Throwable {
	        
	    	lp1.EmailId().sendKeys(username);
			Log.info("Email is entered - HomePage");
			lp1.Password().sendKeys(password);
			Log.info("password is entered - HomePage");
			lp1.Login().click();
	    
          }

	    @Then("^User should be able to login$")
	    public void user_should_be_able_to_login() throws Throwable {
	    	
	    	System.out.println("No access");
	        
	    	
	    }
	    
	    
	    
	    @And("^CLose the browser$")
	    public void close_the_browser() throws Throwable {
	        driver.close();
	    }
    }


