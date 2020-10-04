package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomePage {

		public WebDriver driver;
		public HomePage (WebDriver driver){
			this.driver=driver;
		}
		By superVisaInsurance= By.xpath("//html//body//div//header//div//div//div//nav//div//ul//li//a[contains(text(),'Super Visa Insurance')]");
		By logo= By.xpath("//img[@alt='logo-insure-in-canada']");
		By travelInsuranceLink= By.linkText("Travel Insurance");		// its not gud to use coz multiple links on page
		
		public WebElement superVisaInsurance() {
			return driver.findElement(superVisaInsurance);
		}
		public WebElement logo_HomePage() {
			return driver.findElement(logo);
		}
		public WebElement travelInsurance() {
			return driver.findElement(travelInsuranceLink);
		}
		
}
