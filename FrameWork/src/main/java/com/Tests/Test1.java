package com.Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BusinessLogic.BussLogic_HopScotch;
import com.Resources.MyListeners;
import com.Resources.Setup;


public class Test1 extends Setup
{
	public static WebDriver webdriver = null;
	public static String TC_ID = null;
	BussLogic_HopScotch bussi= null;
	

	
	  @Parameters({"tc_id","browser","url","device","devicename"})
	  
	  @BeforeTest(alwaysRun = true) 
	  public void setup1(String t,String b,String u,String d, String dname) { 
		  webdriver = invokeBrowser(b,u,d,dname); 
		  TC_ID =t; 
		  MyListeners.createTest(TC_ID); 
	  
	  }
	 
	 public static WebDriver getDriver()
	 {
		return webdriver;
		 
	 }
	
	
	@Test
	public void malik() throws Throwable
	{
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "/home/sakha-shaik/Downloads/chromedriver_linux64/chromedriver"); webdriver =
		 * new ChromeDriver(); webdriver.get("https://google.com");
		 */
		 System.out.println("Test1");
		 webdriver.manage().window().maximize();
		 MyListeners.pass_Screenshot(webdriver, "test1");
		 System.out.println(webdriver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).isDisplayed());
		 MyListeners.pass_Screenshot(webdriver, "test1displayed");
		 webdriver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("testng");
		
		
		
		
		MyListeners.pass_Screenshot(webdriver, "entered");
		
	}
	
	
	
}
