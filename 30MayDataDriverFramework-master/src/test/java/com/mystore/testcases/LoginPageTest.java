/**
 * 
 */
package com.mystore.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
//import com.mystore.dataprovider.DataProviders;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
//import com.mystore.utility.Log;

/**
 * @author Baliraj
 *
 */
public class LoginPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
    @Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(groups={"Smoke","Sanity"})
	public void loginTest() throws Throwable {
		
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),homePage);
		//homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Assert.assertEquals(actualURL, expectedURL);
	}

}
