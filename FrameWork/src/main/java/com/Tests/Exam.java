package com.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exam {
	
	public static final String search = "//input[@id='twotabsearchtextbox']";
	public static final String searchicon = "(//input[@class='nav-input'])[1]";
	public static final String iphoneprice_amazon = "(//div[@class='sg-col-inner'][.//span[contains(text(),'Apple iPhone XR, 64GB, Yellow - For Sprint (Renewed)')]])[3]//span[@class='a-color-base']";
	public static final String search_flip = "//input[@name='q']";
	public static final String searchicon_flip="//button[@class='vh79eN']";
	public static final String iphoneprice_flip = "//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB')]/../..//div[@class='_1vC4OE _2rQ-NK']";
	
	@Test
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "/home/sakha-shaik/Downloads/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		/*
		 * driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).
		 * sendKeys("iPhone XR (64GB)-yellow");
		 * driver.findElement(By.xpath("(//input[@class='nav-input'])[1]")).click();
		 */
		
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath(search)).sendKeys("iPhone XR (64GB)-yellow");
			//driver.findElement(By.xpath(search)).sendKeys(Keys.ENTER);
			System.out.println(driver.findElement(By.xpath(searchicon)).isDisplayed());
			driver.findElement(By.xpath(searchicon)).click();

			WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iphoneprice_amazon)));
			String iphonepriceAmazon = driver.findElement(By.xpath(iphoneprice_amazon)).getText().substring(1);
			System.out.println(iphonepriceAmazon);
			Double ip1 = Double.valueOf(iphonepriceAmazon);
			System.out.println(ip1);

			driver.get("https://www.flipkart.com");
			driver.findElement(By.xpath(search_flip)).sendKeys("iPhone XR (64GB)-yell");
			driver.findElement(By.xpath(searchicon_flip)).click();
			//WebDriverWait wait = new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(iphoneprice_flip)));
			String iphonepriceflip = driver.findElement(By.xpath(iphoneprice_flip)).getText().substring(1, 2);
			System.out.println(iphonepriceflip);
			Integer ip2 = Integer.valueOf(iphonepriceflip);
			System.out.println(ip2);
		}
			/*
			if(ip1 < ip2)
			System.out.println("Amazon iphone price is lesser campared to flipcart"+" "+ iphonepriceAmazon);
			else
			System.out.println("Flipcart iphone price is lesser campared amazon"+" "+iphonepriceflip);
			}*/
			catch(Exception e){
			System.out.println(e);
			}
	}

}
