package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.pageobjects.AccountPage;
import com.tutorialsninja.qa.pageobjects.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

import base.Base;

public class LoginTest extends Base {
	
	public LoginTest()
	{
		super();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=InitialiseBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
	    driver.findElement(By.linkText("Login")).click();
	}
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	@Test(priority=1,dataProvider="ValidCredentialSupplier")
	public void VerifyLoginWithValidCredentials(String email,String password)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterEmailAddress(email);
		loginpage.EnterPassword(password);
		loginpage.ClickOnLogin();
		AccountPage accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.getDisplayStatusOfEditYourAccountInformation(),"Edit your account information not displayed");
		
	  
		
	}
	
	
	@DataProvider(name="ValidCredentialSupplier")
	public Object[][] SupplyTestData()
	{
		Object[][] data= Utilities.getTestDataFromExcel("Login");
        return data; 
	}
	@Test(priority=2)
	public void VerifyLoginWithInvalidCredentials()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterEmailAddress(Utilities.generateEmailTimestamp());
		loginpage.EnterPassword(dataprop.getProperty("InvalidPassword"));
		loginpage.ClickOnLogin();
		String ActualWarningMessage = loginpage.RetriveEmailPasswordNotMatchingWarningMessage();
	    
	    
	}
	@Test(priority=3)
	public void verifyEmailwithInvalidEmailandValidPassword()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterEmailAddress(Utilities.generateEmailTimestamp());
		loginpage.EnterPassword(prop.getProperty("validpassword"));
		loginpage.ClickOnLogin();
		String ActualWarningMessage = loginpage.RetriveEmailPasswordNotMatchingWarningMessage();
		    
		    
	}
	
	@Test(priority=4)
	public void verifyLoginwithValidEmailandInvalidPassword()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterEmailAddress(prop.getProperty("validEmail"));
		loginpage.EnterPassword(dataprop.getProperty("InvalidPassword"));
		loginpage.ClickOnLogin();
		String ActualWarningMessage = loginpage.RetriveEmailPasswordNotMatchingWarningMessage();
		
	
	}
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials()
	
	{
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.ClickOnLogin();
		String ActualWarningMessage = loginpage.RetriveEmailPasswordNotMatchingWarningMessage();
	}
	

	
	

}
