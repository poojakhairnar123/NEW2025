package com.amazon_in_Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.amazon.in.HomePage;
import com.amazon.in.TestBase;

public class SearchCategorysTest extends TestBase{

@Test
	 public void testGetAllCategories() {
		 HomePage homePage= new HomePage(driver);// Print all categories in the dropdown
		 homePage.selectCategories();
		 
	 }
@Test
public void getAllCategories() {
	HomePage homePage1= new HomePage(driver);
	homePage1.getAllCategories();
}




}