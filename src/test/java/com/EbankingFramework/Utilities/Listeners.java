package com.EbankingFramework.Utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.EbankingFramework.TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listeners extends TestListenerAdapter {
	
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public static ExtentTest logger;
	
	public void onStart(ITestContext TestContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		spark = new ExtentSparkReporter("target/spark listeners" + timeStamp + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Sreeni");
		
		spark.config().getTimeStampFormat();
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Reports");
		spark.config().setReportName("Test Reports Summary");
		

		//Use below script when "Extent-config.xml" is used to setup properties
		/*final File conf = new File("extentconfig.xml");
		try {
			spark.loadXMLConfig(conf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		logger.pass("Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromBase64String(com.EbankingFramework.TestCases.BaseClass.getBase64Screenshot()).build());
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		logger.log(Status.FAIL, "TEST CASE FAILED IS " + tr.getThrowable()); // to add error/exception in extent report
		logger.fail("Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromBase64String(BaseClass.getBase64Screenshot()).build());
		
		//Use this code when a method is created to store screenshots in a destination folder
		/*
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		String screenshotPath=".//Screenshots/"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
				
			} 
			catch (Exception e) 
				{
				e.printStackTrace();
				} 
		} */
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}	
}