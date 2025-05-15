package com.amazon.in_Utiles;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.google.common.io.Files;

public class Screnshor {
WebDriver driver;
	public Screnshor(WebDriver driver) {
		this.driver=driver;
	}
	
	public  void screenShot() throws IOException {
		//TakesScreenshot sc = (TakesScreenshot) driver;
		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String DateTime=new SimpleDateFormat("yyy-dd-mm_HH-MM-SS").format(new Date());
		File destination=new File("C:\\Users\\HP\\eclipse-workspace\\com.amazon.in\\ScreenShots" + DateTime + ".png");
		//FileUtils.copyFile(source, destination);
		FileHandler.copy(source, destination);
		  System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
	}

}
