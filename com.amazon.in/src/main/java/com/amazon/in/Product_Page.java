package com.amazon.in;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Product_Page extends TestBase  {
   
	WebDriver driver;
	
	public Product_Page(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver,this);	
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	@FindBy(xpath="//h2[@aria-label='Apple iPhone 15 (128 GB) - Blue']")
	WebElement ClickOnProduct;
	
	
	public void searchBoxAndBtn() {
		searchBox.sendKeys("iphone");
		searchBtn.click();
	}
	// Method to scroll down to the specific product and click it
    public void scrollToSpecificProductAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the product to be visible
        wait.until(ExpectedConditions.visibilityOf(ClickOnProduct));

        // Scroll to the product
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ClickOnProduct);

        // Assert that the product is visible
        Assert.assertTrue(ClickOnProduct.isDisplayed(), "Product is not visible after scrolling!");

        // Click the product
        ClickOnProduct.click();
    }
	
	
}
