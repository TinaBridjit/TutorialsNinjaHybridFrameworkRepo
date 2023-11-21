package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	WebDriver driver;
	//objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);//this means Home.class
	}
	//Actions
	public void MyAccount()
	{
		MyAccountDropMenu.click();
	}
	public void selectLoginOption()
	{
		LoginOption.click();
	}

	

}
