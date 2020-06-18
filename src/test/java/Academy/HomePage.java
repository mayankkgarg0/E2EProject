package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
   public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
@BeforeTest
	
	public void initialize() throws IOException {
		
		driver =initializeDriver();
		
		
		}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Usernane, String Password, String Text ) throws IOException {
		
		driver.get(prop.getProperty("url"));
		//driver.findElement(By.xpath("//div[@style='position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']")).click();
		
		LandingPage l = new LandingPage(driver);
		LoginPage lp= l.getLogin();
		
		 
		
		lp.getEmail().sendKeys(Usernane);
		lp.getPassword().sendKeys(Password);
		
		Log.info(Text);
		lp.getLogin().click();
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("xxx");
		fp.sendMeInstructions().click();
	}
	
	  @AfterTest
	  public void teardown() {
		
		driver.close();
		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data= new Object[2][3];
		//0th row
		data[0][0] ="nonrestricteduser@qw.com"; 
		data[0][1]="123456";
		data[0][2]= "Restricted User";
		//1st row
		data[1][0] ="restricteduser@qw.com"; 
		data[1][1]="123456";			
		data[1][2]= "Non-Restricted User";
		
		return data;
	}
}
