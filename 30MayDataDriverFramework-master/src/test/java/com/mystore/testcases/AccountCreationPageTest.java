package com.mystore.testcases;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
//import com.mystore.dataprovider.DataProviders;
import com.mystore.pageObjects.AccountCreationPage;
import com.mystore.pageObjects.HomePage;
import com.mystore.pageObjects.IndexPage;
import com.mystore.pageObjects.LoginPage;
//import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage acountCreationPage;
	//private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(groups="Sanity")
	public void verifyCreateAccountPageTest() throws Throwable {
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount("baliraj@gmail.com");
		boolean result=acountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
	}
	
//	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
//	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
//		Log.startTestCase("createAccountTest");
//		indexPage= new IndexPage();
//		loginPage=indexPage.clickOnSignIn();
//		acountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
//		acountCreationPage.createAccount(
//				hashMapValue.get("Gender"),
//				hashMapValue.get("FirstName"),
//				hashMapValue.get("LastName"),
//				hashMapValue.get("SetPassword"),
//				hashMapValue.get("Day"),
//				hashMapValue.get("Month"),
//				hashMapValue.get("Year"),
//				hashMapValue.get("Company"),
//				hashMapValue.get("Address"),
//				hashMapValue.get("City"),
//				hashMapValue.get("State"),
//				hashMapValue.get("Zipcode"),
//				hashMapValue.get("Country"),
//				hashMapValue.get("MobilePhone"));
//		homePage=acountCreationPage.validateRegistration();
//		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrURL());
//		Log.endTestCase("createAccountTest");
//	}

}
