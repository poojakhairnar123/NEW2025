package com.amazon_in_Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkValidations {
	public static void main(String[] args) {
        
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
      driver.get("https://www.browserstack.com/guide/findelement-in-selenium");
        driver.manage().deleteAllCookies();
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        String parent =driver.getWindowHandle();
        System.out.println(parent);
       List< WebElement> w=driver.findElements(By.xpath("//ul[@class='horizontal-list footer-menu social-menu']//li"));
      int totallinks =w.size();
      System.out.println("total links "+totallinks);
       
       for(int i=0;i< totallinks;i++) {
		w=driver.findElements(By.tagName("li"));
		WebElement li= w.get(i);
		String linktext=li.getText();
		String linkhyperlink=li.getAttribute("href");
		if(linkhyperlink== null ) {
		System.out.println("avoid" +linktext);	
		continue;
		}
		li.click();
	}
  Set<String> set=    driver.getWindowHandles() ;
	String expected_result="BrowserStack (@browserstack) / X";
	}

}
