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
import com.mystore.pageObjects.AddToCartPage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.SearchResultPage;
//import com.mystore.utility.Log;

/**
 * @author Baliraj
 *
 */
public class AddToCartPageTest extends BaseClass {
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="Regression")
	public void addToCartTest() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		//addToCartPage.enterQuantity("2");
		//addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		
	}
}
