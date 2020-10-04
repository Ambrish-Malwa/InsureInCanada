package com.insureincanada.testCases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import resources.Base;
public class TravelInsuranceTest extends Base {
	
	public WebDriver driver; 		
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	
	
	@BeforeTest
	public void initializeBroswer_AndGoTo_URL () throws IOException {
		driver= initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("clicking URL");
	}
	
	@Test 
	public void clickOnTravelInsurance() throws IOException {
		HomePage hp= new HomePage(driver);
		log.info("creating obj of HomePage and passing driver to constructor; from here, local driver of HomePgae will  get life");
		hp.travelInsurance().click();
		log.info("get title of page"+driver.getTitle());
	}	
		
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
