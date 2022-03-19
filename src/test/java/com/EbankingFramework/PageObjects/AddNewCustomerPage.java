package com.EbankingFramework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
			
		WebDriver ldriver;
		
		public AddNewCustomerPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//a[contains(text(),'New Customer')]")
		@CacheLookup
		WebElement tabNewCustomer;
		
		@FindBy(name="name")
		@CacheLookup
		WebElement txtName;
		
		@FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")
		@CacheLookup
		WebElement radbtnmale; 

		@FindBy(xpath="//tbody/tr[5]/td[2]/input[2]")
		@CacheLookup
		WebElement radbtnfemale;
		
		@FindBy(name="dob")
		@CacheLookup
		WebElement txtdate;
		
		@FindBy(name="addr")
		@CacheLookup
		WebElement txtaddress;

		@FindBy(name="city")
		@CacheLookup
		WebElement txtcity;
		
		@FindBy(name="state")
		@CacheLookup
		WebElement txtstate;
		
		@FindBy(name="pinno")
		@CacheLookup
		WebElement txtPin;
		
		@FindBy(name="telephoneno")
		@CacheLookup
		WebElement txttelephone;
		
		@FindBy(name="emailid")
		@CacheLookup
		WebElement txtemail;
		
		@FindBy(name="password")
		@CacheLookup
		WebElement txtpassword;
		
		@FindBy(name="sub")
		@CacheLookup
		WebElement btnsubmit;
		
		public void setNewCustomer()
		{
			tabNewCustomer.click();
		}
		
		public void setCustomername(String name)
		{
			txtName.sendKeys(name);
		}
		
		public void setGender(String gender)
		{
			switch(gender)
			{
			case "male":
				radbtnmale.click(); break;
				
			case "female":
				radbtnfemale.click(); break;
			}	
		}
		public void SetDob(String day, String month, String year)
		{
			txtdate.sendKeys(day);
			txtdate.sendKeys(month);
			txtdate.sendKeys(year);
		}
		public void setAddress(String address)
		{
			txtaddress.sendKeys(address);
		}
		public void setCity(String city)
		{
			txtcity.sendKeys(city);
		}
		public void setState(String state)
		{
			txtstate.sendKeys(state);
		}
		public void SetPin(String pin)
		{
			txtPin.sendKeys(pin);
		}
		public void setPhone(String phone)
		{
			txttelephone.sendKeys(phone);
		}
		public void setEmail(String mail)
		{
			txtemail.sendKeys(mail);
		}
		public void setPassword(String pswd)
		{
			txtpassword.sendKeys(pswd);
		}
		public void setSubmitButton()
		{
			btnsubmit.click();
		}
		
	}
