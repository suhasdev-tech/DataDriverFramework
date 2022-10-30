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
import com.mystore.pageObjects.OrderPage;
import com.mystore.pageObjects.SearchResultPage;
//import com.mystore.utility.Log;

/**
 * @author Baliraj
 *
 */
public class OrderPageTest extends BaseClass {

	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	
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
	public void verifyTotalPrice() throws Throwable {
		index= new IndexPage();
		searchResultPage=index.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		//addToCartPage.enterQuantity(qty);
		//addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble("1")))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
}
