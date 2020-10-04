package com.insureincanada.testCases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.SuperVisaInsurancePage;
import resources.Base;
public class SuperVisaInsurancePageTest extends Base {
	
	public WebDriver driver; 		// declaring it here coz helpful for parallel testing; not needed for sequential run
	public static Logger log= LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initializeBroswer_AndGoTo_URL () throws IOException {
		driver= initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("clicking URL");
	}
	
	@Test 
	public void singlePolicy_SV_GetTitle_AfterContinueButtonClick() throws IOException {
		HomePage hp= new HomePage(driver);
		log.info("creating obj of HomePage and passing driver to constructor; from here, local driver of HomePgae will  get life");
		hp.superVisaInsurance().click();
		SuperVisaInsurancePage spi= new SuperVisaInsurancePage(driver);
		spi.applicantAgeTextBox().sendKeys("45");
		spi.continueButton().click();
		log.info("click on continous button");
		System.out.println(driver.getTitle());
		log.info("get title of page");
		
	}
	@Test 
	public void singlePolicy_SV_isContinousButtonClickable() throws IOException {
		//driver=initializeDriver();
		//driver.get("https://www.insureincanada.ca/");		// hard coded, use properties file
		HomePage hp= new HomePage(driver);
		hp.superVisaInsurance().click();
		SuperVisaInsurancePage spi= new SuperVisaInsurancePage(driver);
		if(spi.continueButton().isDisplayed() && spi.continueButton().isEnabled()) {
		//assert.assertTrue(spi.continueButton().isDisplayed() && spi.continueButton().isEnabled());	
		}
		spi.applicantAgeTextBox().sendKeys("45");
		spi.continueButton().click();
		log.info("click on continous button");
		System.out.println(driver.getTitle());
		log.info("get title of page");
		}
	
	@Test 
	public void singlePolicy_SV_BlankAge_VerifyErrorMsg() throws IOException {
		HomePage hp= new HomePage(driver);
		hp.superVisaInsurance().click();
		SuperVisaInsurancePage spi= new SuperVisaInsurancePage(driver);
		spi.continueButton().click();
		log.info("click on continous button");
		Assert.assertEquals(spi.ageError().getText(), "This field is required.");	
			//System.out.println(spi.ageError());						//proper msg not printing. verify
			
		}
	
	@Test (dataProvider="getDataForApplicantAge")
	public void singlePolicy_SV_GetQuote_DiffAge_restDefault(String age) throws IOException {
		HomePage hp= new HomePage(driver);
		hp.superVisaInsurance().click();
		SuperVisaInsurancePage spi= new SuperVisaInsurancePage(driver);
		spi.applicantAgeTextBox().sendKeys(age);
		spi.continueButton().click();
		log.info("click on continous button");
		if (!age.equalsIgnoreCase("lol")) {
			System.out.println(spi.ageError());
			}
		}
	@DataProvider 
	public Object[][] getDataForApplicantAge() {
		Object [][] age= new Object[2][1];
		age [0][0]= "39";
		age[1][0]= "92";
		return age;
		
		// providing data but TC is not correct. make it correct
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
