package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
//Adding logs
//Generating html logs
//Screenshot on failure
//Jenkins integration
public class ValidateNavigationBar extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void initialize() throws IOException {
		
		driver =initializeDriver();
		
		driver.get(prop.getProperty("url"));
		}
	@Test
	public void basePageNavigation() throws IOException {
		
		//driver.findElement(By.xpath("//div[@style='position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']")).click();
		
		LandingPage l = new LandingPage(driver);
		//compare the text from browzer with the actual text
		Assert.assertTrue(l.getNavigationBar().isDisplayed() ); 	
		Log.info("Navigation Bar is displayed");
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.close();
		
	}
}
