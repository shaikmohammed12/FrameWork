package com.Resources;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyListeners implements ISuiteListener {

	// builds a new report using the html template
	ExtentHtmlReporter htmlReporter;

	static ExtentReports extent;
	
	static ExtentTest test; // helps to generate the logs in test report.
	
	
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_ddHH_mm_ss"); 
	
	static LocalDateTime now = LocalDateTime.now();

	public void onStart(ISuite suite) {
		
		
		// initialize the HtmlReporter
		
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src/test/Results/html/"+dtf.format(now)+".html");
		  
		  //initialize ExtentReports and attach the HtmlReporter 
		  extent = new ExtentReports(); 
		  extent.attachReporter(htmlReporter);
		  
		  //configuration items to change the look and feel 
		  //add content, manage tests etc 
		  htmlReporter.config().setChartVisibilityOnOpen(true);
		  htmlReporter.config().setDocumentTitle("Extent Report Demo");
		  htmlReporter.config().setReportName(dtf.format(now));
		  htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		  htmlReporter.config().setTheme(Theme.STANDARD); 
		  htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		  htmlReporter.config().setFilePath("");
		 
		
		System.out.println("invoked on start");
		
	}
	
	public static void createTest(String name)
	{
		test = extent.createTest(name);
		
	}

	public void onFinish(ISuite suite) {

		// to write or update test information to reporter
		extent.flush();
		System.out.println("invoked on finish");

	}

	/*
	 * public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	 * 
	 * System.out.println("before invokation");
	 * 
	 * test = extent.createTest("sample");
	 * 
	 * 
	 * }
	 * 
	 * public void afterInvocation(IInvokedMethod method, ITestResult result) {
	 * 
	 * 
	 * }
	 */
	
	public static String capture(WebDriver driver) throws Exception {
		try {
			dtf = DateTimeFormatter.ofPattern("yyyy_MM_ddHH_mm_ss");
			now = LocalDateTime.now();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			System.out.println(System.getProperty("user.dir") + "/src/test/Results/screenshots/");
			File Dest = new File(
					System.getProperty("user.dir") + "/src/test/Results/screenshots/" + dtf.format(now) + ".png");
			String errflpath = Dest.getAbsolutePath();
			System.out.println(errflpath);
			FileUtils.copyFile(scrFile, Dest);
			return errflpath;
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}

	}
	
	
	public static void pass_Screenshot1(WebDriver driver , String message) {
		try {
			
			String path = capture(driver);
			
			Thread.sleep(3000);
			test.log(Status.PASS, message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
						
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void fail_Screenshot1(WebDriver driver , String message) {
		try {
			test.log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(capture(driver)).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
