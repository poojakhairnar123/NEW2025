package com.amazon_in_Test;

import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();

	
	 driver.get("https://www.amazon.in");
    
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    // FileInputStream files = new FileInputStream("");
     System.out.println("DONE");
	}
}
