package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement SearchButton;
	
	@FindBy(xpath="//span[normalize-space()='Add to Cart']")
	private WebElement AddToCart;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement AddToCart2;
	
	@FindBy(xpath="//span[text()='Shopping Cart']")
	private WebElement ShoppingCartButton;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void EnterSearchItem(String item)
	{
		SearchField.sendKeys(item);
		
	}
	
	public  void ClickOnSearchButton()
	{
		SearchButton.click();
	}
	
	public void ClickOnAddtocartButton()
	{
		AddToCart.click();
	}
	public void ClickOnAddtocartbutton2()
	{
		AddToCart2.click();
	}
	public void ClickOnShoppingCartButton()
	{
		ShoppingCartButton.click();
	}
	
}
