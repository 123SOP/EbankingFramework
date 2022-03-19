package com.EbankingFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

		public WebDriver ldriver;
		
		public LoginPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(name="uid")
		WebElement txtUserName;
		
		@FindBy(name="password")
		WebElement txtPassword;
		
		@FindBy(name="btnLogin")
		WebElement btnLogin;
		
		@FindBy(xpath="//a[contains(text(),'Log out')]")
		WebElement btnLogout; 
		
		public void setUSerID(String user)
		{
			txtUserName.sendKeys(user);
		}
		
		public void setPassword(String pwd)
		{
			txtPassword.sendKeys(pwd);
		}
		
		public void setLogin()
		{
			btnLogin.click();
		}
		
		public void setLogout()
		{
			btnLogout.click();
		}
	}

