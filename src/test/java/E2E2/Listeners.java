package E2E2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	
	public static WebDriver driver;
	public ExtentTest test;
	ThreadLocal<ExtentTest> localthreadsafeobject = new ThreadLocal<ExtentTest>();
	ExtentReports extent = ExtentReporterNG.getReporter();

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
		test = extent.createTest(result.getMethod().getMethodName());
		localthreadsafeobject.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		localthreadsafeobject.get().log(Status.PASS, "TEST CASE PASSED");
		String testCaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			System.out.println(driver.toString());
		} catch (Exception e) {

		} 
		try {
			localthreadsafeobject.get().addScreenCaptureFromPath(getScreenShot(testCaseName, driver), 
					result.getMethod().getMethodName());
			
		} catch (IOException e) {
		}
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		localthreadsafeobject.get().fail(result.getThrowable());
		String testCaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch (Exception e) {

		} 
		try {
			localthreadsafeobject.get().addScreenCaptureFromPath(getScreenShot(testCaseName, driver), 
					result.getMethod().getMethodName());
			System.out.println("inside failure " + driver.toString());
		} catch (IOException e) {
			System.out.println("inside catch failure " + driver.toString());
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
