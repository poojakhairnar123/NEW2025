package com.amazon.in;

import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart_Page {

    WebDriver driver;
    Logger log = LogManager.getLogger(Cart_Page.class);
   
    public Cart_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchBtn;

    @FindBy(xpath = "//h2[contains(@aria-label,'Men')]")
    WebElement clickProduct;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    WebElement QtyDropdown;

    @FindBy(xpath = "//ul[@class='a-nostyle a-list-link']//a[@id='quantity_2']")
    WebElement SelectQty;
    
 
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement AddTocartBtn;
    
    public void searchBox() {
        try {
            searchBox.sendKeys("watch for men");
            searchBtn.click();
        } catch (Exception e) {
            System.out.println("Error performing search: ");
            e.printStackTrace();
        }
    }

    public void clickProduct() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
            wait.until(ExpectedConditions.visibilityOf(clickProduct));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", clickProduct);
            clickProduct.click();

            String parentWindow = driver.getWindowHandle();
            driver.getTitle();
            Set<String> allWindows = driver.getWindowHandles();

            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    System.out.println("Window switched successfully.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error clicking product: ");
            e.printStackTrace();
        }
    }

    public void selectQtyandAddintoCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            
            // Wait for the quantity dropdown to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(QtyDropdown));
            
            // Scroll into view and click the dropdown
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", QtyDropdown);
            QtyDropdown.click();
            
            // Wait for the quantity options to load and select the desired quantity
            wait.until(ExpectedConditions.visibilityOf(SelectQty));
            wait.until(ExpectedConditions.elementToBeClickable(SelectQty));
            SelectQty.click();
            
            System.out.println("Quantity selected successfully.");
            AddTocartBtn.click();
            
            
        } catch (Exception e) {
        	 log.error("Login failed! Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
