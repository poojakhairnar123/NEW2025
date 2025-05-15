package com.amazon.in_Utiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{
WebDriver driver;
	Logger log=LogManager.getLogger(Listener.class);
	
	  @Override
	    public void onStart(ITestContext context) {
	        driver = (WebDriver) context.getAttribute("WebDriver"); // Fetch driver from TestBase
	    }
public void onTestStart(ITestResult result) {
	log.info("Executing Test: " + result.getMethod().getMethodName() + " in Class: " + result.getTestClass().getName());

}
public void onTestFail(ITestResult result) {
	ScreenShot screenShot = new ScreenShot(driver);
    screenShot.takeScreenShot(result.getMethod().getMethodName());
}
public void onTestSucess(ITestResult result) {
	
}

}
