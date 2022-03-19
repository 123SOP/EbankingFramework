package com.EbankingFramework.TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.EbankingFramework.PageObjects.AddNewCustomerPage;
import com.EbankingFramework.PageObjects.LoginPage;

public class AddNewCustomer_TC_003 extends BaseClass {

	@Test
	public void AddNewCustomer() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUSerID(uname);
		lp.setPassword(pwd);
		lp.setLogin();
		
		AddNewCustomerPage anc = new AddNewCustomerPage(driver);
		anc.setNewCustomer();
		anc.setCustomername("Selenium Community");
		anc.setGender("female");
		anc.SetDob("18", "08", "2022");
		anc.setAddress("Selenium cloudinternet");
		anc.setCity("Google");
		anc.setState("internet");
		anc.SetPin("502032");
		anc.setPhone("123456789");
		String email = RandomString() + "@gmail.com";
		anc.setEmail(email);
		anc.setPassword("Selenium");
		anc.setSubmitButton();
		Thread.sleep(5000);
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
}
