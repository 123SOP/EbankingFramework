package com.EbankingFramework.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.*;

import com.EbankingFramework.PageObjects.LoginPage;
import com.EbankingFramework.Utilities.XLUtils;


public class DDT_TC_002 extends BaseClass {

		@Test(dataProvider = "testdata")
		public void DDTlogin(String uid, String psd) throws IOException
		{
			LoginPage lp = new LoginPage(driver);
			lp.setUSerID(uid);
			lp.setPassword(psd);
			lp.setLogin();
			
			if(IsAlertPresent() == true)
			{
				getBase64Screenshot();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				//ScreenshotCapture(driver, "login");
				Assert.assertTrue(false);
			}
			else
			{
				getBase64Screenshot();
				lp.setLogout();
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				Assert.assertTrue(true);
			}
		}
		
		public static boolean IsAlertPresent()
		{
			try
			{
			driver.switchTo().alert();
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		@DataProvider(name="testdata")
		public static String[][] getExceldata() throws IOException
		{
			String path = System.getProperty("user.dir") + "//src//test//java//com//EbankingFramework//testData//DDT test data.xlsx";
			
			//C:\Users\boyap\eclipse-workspace\Ebanking\src\test\java\com\ebanking\testData\DDT test data.xlsx
			
			int rows = XLUtils.getrowcount(path, "Sheet1");
			int columns = XLUtils.getcellcount(path, "Sheet1", 1);
			
			String logindata[][] = new String[rows][columns];
			
			for(int r=1; r<=rows;r++)
			{
				for(int c=0;c<columns;c++)
				{
					logindata[r-1][c] = XLUtils.getCellData(path, "Sheet1", r, c);
				}
			}
			return logindata;
		}

	}
