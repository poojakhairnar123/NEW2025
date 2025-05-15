package com.amazon_in_Test;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.amazon.in.Product_Page;
import com.amazon.in.TestBase;

public class Search_Product_Test extends TestBase  {

	@Test
	public void testScrollAndClickProduct() {
        Product_Page productPage = new Product_Page(driver);

        // Search for the product
        productPage.searchBoxAndBtn();

        // Scroll to the specific product and click it
        productPage.scrollToSpecificProductAndClick();
    }
}