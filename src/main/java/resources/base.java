package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
    public Properties prop;
    
	public WebDriver initializeDriver() throws IOException {
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Mayank\\eclipse-workspace\\E2EProject\\src\\main\\java\\data.properties");
		prop.load(fis);
		
	String browzerName = prop.getProperty("browzer");
	System.out.println(browzerName);
	
	if(browzerName.equals("chrome")) {
		//Chrome
		System.setProperty("webdriver.chrome.driver","D:\\Software mayank\\chromedriver.exe");
		driver = new ChromeDriver();
	}	
	else if(browzerName.equals("firefox")){
	//Firefox
		
		System.setProperty("webdriver.gecko.driver", "D:\\Software mayank\\eckodriver");
		driver = new FirefoxDriver();
		
	}
	else if(browzerName.equals("IE")){
	//IE
		}
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
	}
	
	public String getScreenShotPath( String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile)); 
		return destinationFile;
	}
}

