/**
 * 
 */
package com.mystore.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actionDriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Baliraj
 *
 */
public class AddToCartPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath="//a[@class='btn btn-default button-plus product_quantity_up']")
	private WebElement quantity;
	
	@FindBy(xpath="//select[@id='group_1']")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		action.type(quantity, quantity1);	
		//action.click(driver,quantity);
		Thread.sleep(2000);

	}
	
	public void selectSize(String size1) throws Throwable {
		
		action.selectByVisibleText(size1, size);
		Thread.sleep(2000);

	}
	
	public void clickOnAddToCart() throws Throwable {
		Thread.sleep(2000);
		//action.click(driver, addToCartBtn);
		action.JSClick(driver, addToCartBtn);
		Thread.sleep(3000);

	}
	
	public boolean validateAddtoCart() throws Throwable {
		action.fluentWait(driver, addToCartMessag, 10);
		return action.isDisplayed(driver, addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		action.fluentWait(driver, proceedToCheckOutBtn, 10);
		action.JSClick(driver, proceedToCheckOutBtn);
		Thread.sleep(3000);
		return new OrderPage();
	}
	
}
