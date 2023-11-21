package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.pageobjects.AccountPage;
import com.tutorialsninja.qa.pageobjects.CheckoutPage;
import com.tutorialsninja.qa.pageobjects.LoginPage;
import com.tutorialsninja.qa.pageobjects.SearchPage;
import com.tutorialsninja.qa.pageobjects.ShoppingCartPage;
import com.tutorialsninja.qa.utils.Utilities;

import base.Base;
public class EndToEndTest extends Base{
	
	public EndToEndTest()
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
	@Test(priority=1)
	public void EndToEndTest() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);

		loginpage.EnterEmailAddress(prop.getProperty("validEmail"));
		loginpage.EnterPassword(prop.getProperty("validpassword"));
		loginpage.ClickOnLogin();
		SearchPage searchpage=new SearchPage(driver);
		searchpage.EnterSearchItem("HP");
		searchpage.ClickOnSearchButton();
		searchpage.ClickOnAddtocartButton();
		searchpage.ClickOnAddtocartbutton2();
		WebElement message = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String msg = message.getText();
		System.out.println(msg);
		boolean successstatus=message.isDisplayed();
		System.out.println(successstatus);
		Assert.assertTrue(successstatus);
		searchpage.ClickOnShoppingCartButton();
		ShoppingCartPage shoppingcartpage=new ShoppingCartPage(driver);
		shoppingcartpage.ClickonCheckoutButton();
			
		CheckoutPage chechoutpage=new CheckoutPage(driver);
		chechoutpage.ClickonFirstContinueButton();
		chechoutpage.ClickonSecondContinueButton();
		chechoutpage.ClickonThirdContinueButton();
		chechoutpage.ClickonTermsAndConditionButton();
		chechoutpage.ClickonFourthContinueButton();
		chechoutpage.ClickonConfirmOrderButton();
		
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}
	

}
