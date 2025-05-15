package com.amazon.in_Utiles;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

    WebDriver driver;

    Logger log=LogManager.getLogger(ScreenShot.class);
    // Constructor to initialize the WebDriver
    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }

    // Method to take a screenshot
    public void takeScreenShot(String fileName) {
        // Convert the WebDriver object to TakesScreenshot
        TakesScreenshot sc = (TakesScreenshot) driver;

        // Capture the screenshot as a File object
        File screenshot = sc.getScreenshotAs(OutputType.FILE);

        // Generate timestamp for unique filenames
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

        // Define the destination folder and file path
        String screenshotFolder = System.getProperty("user.dir") + "/ScreenShots/";
        String filePath = screenshotFolder + fileName + "_" + timestamp + ".png";

        // Create the folder if it doesn't exist
        File directory = new File(screenshotFolder);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Save the screenshot to the specified location
        File destination = new File(filePath);
        try {
            // Copy temporary file to the permanent location
            Files.copy(screenshot.toPath(), destination.toPath());
            log.info("screnshot taking", filePath, fileName, sc, screenshot, timestamp, screenshotFolder, filePath, directory, destination);
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
