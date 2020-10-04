package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuperVisaInsurancePage {
	
	public WebDriver driver;
	public SuperVisaInsurancePage (WebDriver driver){
		this.driver=driver;
	}
	
	By applicantAge= By.xpath("//input[@name='age']");
	By dateOfBirth= By.xpath("//input[@name='dob']");
	By policyStartDate= By.xpath("//input[@name='startDate']");
	By continueButton= By.xpath("//input[@id='next_1']");
	By ageError= By.xpath("//label[@id='age-error']");
	
	
	
	public WebElement applicantAgeTextBox() {
		return driver.findElement(applicantAge);
	}
	public WebElement dateOfBirth() {
		return driver.findElement(dateOfBirth);
	}
	public WebElement policyStartDate() {
		return driver.findElement(policyStartDate);
	}
	public WebElement continueButton() {
		return driver.findElement(continueButton);
	}
	public WebElement ageError() {
		return driver.findElement(ageError);
	}
}
