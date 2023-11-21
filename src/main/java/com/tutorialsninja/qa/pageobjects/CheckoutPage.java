package com.tutorialsninja.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	
	@FindBy(id="button-payment-address")
	private WebElement FirstContinueButton;
	
	@FindBy(id="button-shipping-address")
	private WebElement SecondContinueButton;
	
	@FindBy(id="button-shipping-method")
	private WebElement ThirdContinueButton;
	
	@FindBy(name="agree")
	private WebElement TermsAndConditionButton;
	
	@FindBy(id="button-payment-method")
	private WebElement FourthContinueButton;
	
	@FindBy(id="button-confirm")
	private WebElement ConfirmOrderButton;
	
	@FindBy(linkText="Continue")
	private WebElement ContinueButton;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void ClickonFirstContinueButton()
	{
		FirstContinueButton.click();
	}
	public void ClickonSecondContinueButton()
	{
		SecondContinueButton.click();
	}
	
	public void ClickonThirdContinueButton()
	{
		ThirdContinueButton.click();
	}
	public void ClickonTermsAndConditionButton()
	{
		TermsAndConditionButton.click();
	}
	
	public void ClickonFourthContinueButton()
	{
		FourthContinueButton.click();
	}
	
	public void ClickonConfirmOrderButton()
	{
		ConfirmOrderButton.click();
	}
	

}
