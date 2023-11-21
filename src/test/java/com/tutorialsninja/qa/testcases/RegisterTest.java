package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.utils.Utilities;

import base.Base;

public class RegisterTest extends Base {
	
	public RegisterTest()
	{
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=InitialiseBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void VerifyRegisteringAnAccountWithMandatoryFields()
	{
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("TelephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String ActualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(ActualSuccessHeading, dataprop.getProperty("AccountSuccesfullyCreatedHeading"),"Account success page is not crated");
		

 }
	@Test(priority=2)
	public void VerifyRegisteringAccountbyProvidingAllTheFields()
	{
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("TelephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys("asdfg");
		driver.findElement(By.id("input-confirm")).sendKeys("asdfg");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String ActualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(ActualSuccessHeading, dataprop.getProperty("AccountSuccesfullyCreatedHeading"),"Account success page is not crated");
		
	}
	@Test(priority=3)
	public void VerifyRegisteringAccountWithExistingEmailAddress()
	{
		
		driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("FirstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("LastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("TelephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String ActualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(ActualWarning.contains(dataprop.getProperty("DuplicateEmailWarning")),"Warning message regarding duplicate emailaddress is not displayed");
		
	}
	
@Test(priority=4)
	
	public void VerifyRegisteringAnAccountWithoutFillingAnyDetails()
	{
		
		//driver.findElement(By.id("input-firstname")).sendKeys("Tina");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String ActualPrivacyPolicyWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(ActualPrivacyPolicyWarning.contains(dataprop.getProperty("PrivacyPolicyWarning")),"Privacy policy warning message is not displayed");
		
		String ActualFirstnameWarning=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(ActualFirstnameWarning, dataprop.getProperty("FirstNameWarning"),"First name warning message is not displayed");
		
		String ActualLastnameWarning=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(ActualLastnameWarning, dataprop.getProperty("LastNameWarning"),"Last name warning message is not displayed");
		
		String ActualEmailWarning=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(ActualEmailWarning, dataprop.getProperty("EmailAddressWarning"),"Email warning message is not displayed");
		
		String ActualTelephoneWarning=driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(ActualTelephoneWarning, dataprop.getProperty("TelephoneWarning"),"Telephone warning message is not displayed");
		
		String ActualPasswordWarning=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(ActualPasswordWarning, dataprop.getProperty("PasswordWarning"),"Password warning message is not displayed");
		
		
		
	}

}
