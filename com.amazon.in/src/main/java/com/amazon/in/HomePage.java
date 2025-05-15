
package com.amazon.in;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
	
	Logger log=LogManager.getLogger(HomePage.class);
    WebDriver driver;

    // Constructor to initialize the WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    // WebElements identified using @FindBy annotations
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchBtn;

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    WebElement selectCategories; // Dropdown or list box

    
    
    // Method to select a specific category
    public void selectCategories() {
        try {
            Select s = new Select(selectCategories); // Create Select instance
            s.selectByVisibleText("All Categories"); // Select "All Categories" option
            log.info(" option selected");
        } catch (Exception e) {
            System.out.println("Error selecting category: " + e.getMessage());
        }
    }

    // Method to print all available categories in the dropdown
    public void getAllCategories() {
        try {
            Select s = new Select(selectCategories); // Create Select instance
            List<WebElement> options = s.getOptions(); // Fetch all dropdown options
            for (WebElement option : options) {
                System.out.println(option.getText()); // Print the visible text of each option
            }
        } catch (Exception e) {
            System.out.println("Error fetching categories: " + e.getMessage());
        }
    }

    // Method to perform a search operation
    public void searchBox() {
        try {
            searchBox.sendKeys("Camera"); // Input "Camera" in the search box
            searchBtn.click(); // Click the search button
        } catch (Exception e) {
            System.out.println("Error performing search: " + e.getMessage());
        }
    }
}
