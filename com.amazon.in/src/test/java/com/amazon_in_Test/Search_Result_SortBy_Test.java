package com.amazon_in_Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.amazon.in.SearchResult_Page;
import com.amazon.in.TestBase;

public class Search_Result_SortBy_Test extends TestBase {

	//Test that filters (price range, brand, rating, etc.) apply correctly on the search results page.
 
	@Test
	public void searchBoxTest() {
		SearchResult_Page searchResult=new SearchResult_Page(driver);
		searchResult.searchBoxandbtn();
	}
	@Test
	public void rangeSliderLowerBoundPriceTest() {
		SearchResult_Page PriceTest=new SearchResult_Page(driver);
		PriceTest.rangeSliderLowerBoundPrice();
	}
	
}
