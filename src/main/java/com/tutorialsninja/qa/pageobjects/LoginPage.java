package com.tutorialsninja.qa.pageobjects;


	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		
		WebDriver driver;
		//objects
		@FindBy(id="input-email")
		private WebElement EmailAddressField;
		
		@FindBy(id="input-password")
		private WebElement PasswordField;
		
		@FindBy(xpath="//input[@value='Login']")
		private WebElement LoginButton;
		
		@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
		private WebElement EmailPasswordnotMatchingWarning;
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);//this means Logipage
		}
		//Actions
		public void EnterEmailAddress(String emailText)
		{
			EmailAddressField.sendKeys(emailText);
		}
		public void EnterPassword(String PasswordText)
		{
			PasswordField.sendKeys(PasswordText);
		}
		
		public void ClickOnLogin()
		{
			LoginButton.click();
		}
		
		public String RetriveEmailPasswordNotMatchingWarningMessage()
		{
			String text = EmailPasswordnotMatchingWarning.getText();
			return text;
		}


	}


