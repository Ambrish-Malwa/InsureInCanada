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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Base {
	
	public static WebDriver driver;
	public Properties prop;				// declare it here otherwise its scope wud be inside initiazeDriver only, but we need it for url as well
	public WebDriver initializeDriver() throws IOException {
		prop= new Properties(); 
		FileInputStream fis= new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\insureincanada\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\eclipse-workspace\\insureincanada\\src\\test\\java\\com\\insureincanada\\utilities\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		} 
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);		// stores SS in 'source' file but its in vertual place, we need to create in local system.
		String destinaitonFile= System.getProperty("user.dir")+"\\reports\\"+ testCaseName+".png";
		FileUtils.copyFile(source,new File (destinaitonFile));		// add dependency to use FileUtils. 
	}

}