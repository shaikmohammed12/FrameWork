package com.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BusinessLogic.BussLogic_HopScotch;
import com.Resources.MyListeners;
import com.Resources.Setup;

public class HomePage extends Setup{

	public static WebDriver webdriver = null;
	public static String TC_ID = null;
	BussLogic_HopScotch bussi= null;
	

	@Parameters({"tc_id","browser","url","device","devicename"})
	@BeforeTest(alwaysRun = true)
	public void setup1(String t,String b,String u, String d, String dname)
	{
		webdriver = invokeBrowser(b,u,d,dname);
		TC_ID = t;
		MyListeners.createTest(t);
	}
	
	
	@Test
	public void malik() throws Throwable
	{
		webdriver.manage().window().maximize();
		bussi = new BussLogic_HopScotch(webdriver,TC_ID);
		bussi.verifyingHomePage();
		
	}
}
