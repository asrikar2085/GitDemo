package CucumberOptions;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@io.cucumber.testng.CucumberOptions(
		features="src/test/java/features",
		glue="stepdefinitions")
		//stepNotifications = true)
@Listeners({E2E2.Listeners.class})

public class TestRunner extends AbstractTestNGCucumberTests{

	

}
