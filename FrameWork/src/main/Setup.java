package com.Resources;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Setup {
	
	
	protected WebDriver driver = null;
	protected String tc_id = null; 
	
	
	public WebDriver invokeBrowser(String browser, String url)
	{
		if(browser.contentEquals("CHROME"))
		{
			/*WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);*/
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
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
		return driver;
	}

}
