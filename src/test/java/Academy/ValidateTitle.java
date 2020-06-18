package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateTitle extends base {
	public WebDriver driver;
public static Logger Log = LogManager.getLogger(base.class.getName());
@BeforeTest
	
	public void initialize() throws IOException {
		
		driver =initializeDriver();
		Log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
		}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		//driver.findElement(By.xpath("//div[@style='position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']")).click();
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTittle().getText(), "FEATURED CO123URSES");
		System.out.println(l.getTittle().getText()); 
		Log.info("Successfully validated Text Message");
	}
	@AfterTest
	public void teardown() {
		
		driver.close();
		
	}
}
