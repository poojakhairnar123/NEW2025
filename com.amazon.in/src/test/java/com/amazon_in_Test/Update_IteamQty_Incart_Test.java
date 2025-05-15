package com.amazon_in_Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Update_IteamQty_Incart_Test {

		@Test
			public void w3school() {
				WebDriver driver= new ChromeDriver();
				driver.get("https://demo.guru99.com/test/simple_context_menu.html");
				driver.manage().window().maximize();
				SoftAssert sofart=new SoftAssert ();
				driver.get("https://www.w3schools.com/html/default.asp");
				String actualurl="https://www.w3schols.com/html/default.asp";
				String exceptedurl= driver.getCurrentUrl();
				AssertJUnit.assertEquals(actualurl,exceptedurl,"verification pass");
				System.out.println("pass");
				
				String act= driver.getTitle();
				String expt="HTML Tutorial";
				AssertJUnit.assertEquals(act,expt);
				System.out.println("pass");
				

			}

}
