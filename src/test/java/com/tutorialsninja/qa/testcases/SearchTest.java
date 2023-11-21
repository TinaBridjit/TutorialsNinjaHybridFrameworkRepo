package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class SearchTest extends Base{
	
	public SearchTest()
	{
		super();
	}
	public WebDriver driver;
	@BeforeMethod
	public void Setup()
	{
		driver=InitialiseBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		
		
	}
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void VerifySearchWithValidProduct()
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"Valid product HP is not displayed");
	}
	@Test(priority=2)
	public void VerifySearchWithInvalidProduct()
	{
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("HONDA");
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String ActualSearchMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(ActualSearchMessage, "There is no product that matches the search criteria.","No product message in search result not displayed");
				
		
	}
	@Test(priority=3)
	public void VerifySearchWithoutAnyProduct()
	{
		
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String ActualSearchMessage=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(ActualSearchMessage, "There is no product that matches the search criteria.","No product message in search result not displayed");
				
		
	}


}
