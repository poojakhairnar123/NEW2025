package com.amazon_in_Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.amazon.in.Cart_Page;
import com.amazon.in.TestBase;
import com.amazon.in_Utiles.ScreenShot;

public class Product_AddedCart_price_Qty_Test extends TestBase {

    @Test


    public void AddProductInCartAndSelectQty() {
        Cart_Page addProductPage = new Cart_Page(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        addProductPage.searchBox();
        screenshot.takeScreenShot("SearchBoxFilled");
        addProductPage.clickProduct();
        screenshot.takeScreenShot("ProductClicked");
  
     
        
    }
}
