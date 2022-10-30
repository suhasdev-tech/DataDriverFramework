/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
//import com.mystore.dataprovider.DataProviders;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;
//import com.mystore.utility.Log;

/**
 * @author Baliraj
 *
 */
public class SearchResultPageTest extends BaseClass {
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="Smoke")
	public void productAvailabilityTest() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}

}
