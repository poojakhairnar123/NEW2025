package com.amazon_in_Test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgEnable {
    @Test(priority = 1)
  public void Login()
	  {
		  Reporter.log("Login sucess",true);
		 // Assert.fail();
	  }
	
	@Test(priority = 2)

	public void VerifyPin()
	{
	  Reporter.log("Pin Verified", true);
	}
	
	@Test (dependsOnMethods = "Login")
		public void Logout()
	{
		Reporter.log("Logout",true);

	}
}

