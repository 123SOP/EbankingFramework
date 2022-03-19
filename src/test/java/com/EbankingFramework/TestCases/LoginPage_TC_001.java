package com.EbankingFramework.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.EbankingFramework.PageObjects.LoginPage;

	public class LoginPage_TC_001 extends BaseClass {
		
		@Test
		public void login() throws IOException
		{
			
			LoginPage lp = new LoginPage(driver);
			lp.setUSerID(uname);
			lp.setPassword(pwd);
			lp.setLogin();
			
			if(driver.getTitle().equals(title))
			{
				Assert.assertTrue(true);
				getBase64Screenshot();
			}
			else
			{
				Assert.assertTrue(false);
				getBase64Screenshot();
			}
		}

	}
