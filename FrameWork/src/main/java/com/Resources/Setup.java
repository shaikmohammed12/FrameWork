package com.Resources;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Setup {
	
	
	public static WebDriver driver = null;
	public String tc_id = null; 
	
	
	public WebDriver invokeBrowser(String browser, String url, String device, String devicename)
	{
		
		if(device.contentEquals("MOBILE"))
		{
			if(browser.contentEquals("CHROME"))
			{
				Map<String, String> mobileEmulation = new HashMap<>();

				mobileEmulation.put("deviceName", devicename);


				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
				System.setProperty("webdriver.chrome.driver", "/home/sakha-shaik/Downloads/chromedriver_linux64/chromedriver");
				WebDriver driver = new ChromeDriver(chromeOptions);
				/*WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(url);*/
				driver.get(url);
				return driver;
			}
			
		}
		else if(device.contentEquals("WEB"))
		{
			if(browser.contentEquals("CHROME"))
			{
				/*WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(url);*/
				System.setProperty("webdriver.chrome.driver", "/home/sakha-shaik/Downloads/chromedriver_linux64/chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				driver = new ChromeDriver();
				driver.get(url);
			}
			else if(browser.contentEquals("FIREFOX"))
			{
				driver = new FirefoxDriver();
				driver.get(url);
			}
			else if(browser.contentEquals("IE"))
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.get(url);
			}
		}
		return driver;
	}

}
