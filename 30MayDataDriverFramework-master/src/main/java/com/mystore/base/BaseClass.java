package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.ietf.jgss.Oid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.mystore.actionDriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Baliraj: BaseClass is used to load the config file and Initialize
 *         WebDriver
 * 
 */
public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	@BeforeTest(groups= {"Smoke","Sanity","Regression"})
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchApp(String browserName ) {
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		//implicit wait new syntax
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launching the URL	
		driver.get(prop.getProperty("url"));
	}

}
