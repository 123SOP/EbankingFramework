package com.EbankingFramework.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File source = new File("./Configuration/Config.properties");
		//C:\Users\boyap\eclipse-workspace\EbankingFramework\Config.properties
		
		try
		{
			FileInputStream fis = new FileInputStream(source);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e.getMessage());
		}
	}
		public String getApplicationURL()
		{
			String url = pro.getProperty("BaseURL");
			return url;
		}
		
		public String getUserName()
		{
			String uname = pro.getProperty("username");
			return uname;
		}
		
		public String getPassword()
		{
			String pswd = pro.getProperty("password");
			return pswd;
		}
		
		public String GetTitle()
		{
			String title = pro.getProperty("title");
			return title;
		}
		
}
