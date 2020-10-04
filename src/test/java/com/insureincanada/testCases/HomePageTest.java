package com.insureincanada.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SuperVisaInsurancePage;
import resources.Base;
public class HomePageTest extends Base {
	public WebDriver driver; 
	public static Logger log= LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initializeBroswer_AndGoTo_URL () throws IOException {
		driver= initializeDriver();
		driver.get(prop.getProperty("url1"));
		log.info("clicking URL");
	}

	@Test 
	public void homePageNavigaiton () throws IOException {
		
//		driver= initializeDriver();      					// coz we have put this in beforetest
//		driver.get(prop.getProperty("url"));
		System.out.println(driver.getTitle());
		log.info("get title of page");
	}
	@Test 
	public void superVisaTitle() throws IOException {
		HomePage hp= new HomePage(driver);
		hp.superVisaInsurance().click();
		log.info("click on super visa insurance link");
		System.out.println(driver.getTitle());
		
	}
	@Test 
	public void superVisaSinglePolicyInitialInfoDefaultDate() throws IOException {
		HomePage hp= new HomePage(driver);
		hp.superVisaInsurance().click();
		log.info("click on super visa insurance link");
		SuperVisaInsurancePage spi= new SuperVisaInsurancePage(driver);
		spi.applicantAgeTextBox().sendKeys("45");
		spi.continueButton().click();
		log.info("click on continous button");
		System.out.println(driver.getTitle());
	}
	@Test
	private void toCheckSS_onTCFailure() {
		String exp= "hi";
		String act= "hloo";
		Assert.assertEquals(act, exp);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
