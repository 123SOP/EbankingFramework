package com.EbankingFramework.TestCases;



import java.time.Duration;



import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.EbankingFramework.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		
		public static WebDriver driver;
		
		ReadConfig rc = new ReadConfig();
		String url = rc.getApplicationURL();
		String uname = rc.getUserName();
		String pwd = rc.getPassword();
		String title = rc.GetTitle();
		
		@Parameters("browser")
		@BeforeClass
		public void setup(String br)
		{
			if(br.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(br.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			driver.manage().window().maximize();
		}	

			@AfterClass
			public static void Teardown()
			{
				driver.quit();
			}  
		
			public static String RandomString()
			{
				String generatedstring = RandomStringUtils.randomAlphabetic(5);
				return generatedstring;
			}
			
			/*public static void ScreenshotCapture(WebDriver driver, String tr) throws IOException
			{
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File target = new File(".//Screenshots/" + tr + ".png");
				FileUtils.copyFile(source, target);
			} */
			
			public static String getBase64Screenshot()
			{
				return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				
			}

	}

