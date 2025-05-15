package com.amazon.in;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchResult_Page extends TestBase{
     WebDriver driver;
	public SearchResult_Page(WebDriver driver) {
		this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	@FindBy(linkText="Featured")
	WebElement SortByDropDwn;
	
	@FindBy(xpath = "//input[@id='p_36/range-slider_slider-item_lower-bound-slider']")
	WebElement rangeSliderLowerBound;
	
	@FindBy(id = "p_36/range-slider_slider-item_upper-bound-slide")
	WebElement rangeSliderUpperBound;
	
	
	
	public void searchBoxandbtn() {
		searchBox.sendKeys("watch for man");
		searchBtn.click();
	}
	public void rangeSliderLowerBoundPrice() {
		Select s=new Select(SortByDropDwn);
		s.selectByVisibleText("Price: Low to High");
		rangeSliderUpperBound.sendKeys("500");
	}
	
	

}
