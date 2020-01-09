package com.Resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementAction {
	
	WebDriver driver;
	//Action action = new Action();
	
	/**
	 * checks whether a web element is displayed or not
	 * @param driver
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void checkElementDisplayed(WebDriver driver, String xpath, String message) throws Exception
	{
		try
		{
			if(driver.findElement(By.xpath(xpath)).isDisplayed())
				MyListeners.pass_Screenshot(driver, message + " is displayed");
			else
				MyListeners.fail_Screenshot(driver, message + " is not displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
	}
	
	/**
	 * checks whether a web element is displayed or not
	 * @param driver
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void checkTextDisplayed(WebDriver driver, String xpath, String expected, String message) throws Exception
	{
		try
		{
			if(driver.findElement(By.xpath(xpath)).getText().contentEquals(expected))
				MyListeners.pass_Screenshot(driver, message + " is displayed");
			else
				MyListeners.fail_Screenshot(driver, message + " is not displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
	}
	
	/**
	 * checks whether a web element is displayed or not using size
	 * @param driver
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void checkElementDisplay(WebDriver driver, String xpath, String message) throws Exception
	{
		try
		{
			System.out.println(driver.findElements(By.xpath(xpath)).size());
			if(driver.findElements(By.xpath(xpath)).size()>0)
				MyListeners.pass_Screenshot(driver, message + " is displayed");
			else
				MyListeners.fail_Screenshot(driver, message + " is not displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
	}
	
	
	/**
	 * used to clear text from input field
	 * @param driver
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void clearInput(WebDriver driver, String xpath, String message) throws Exception
	{
		try
		{
			driver.findElement(By.xpath(xpath)).clear();
			if(driver.findElement(By.xpath(xpath)).getAttribute("value").length()>0)
				MyListeners.pass_Screenshot(driver, message + " is cleared");
			else
				MyListeners.fail_Screenshot(driver, message + " is not cleared");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not cleared due to Exception");
		}
	}
	
	
	/**
	 * used to enter text in input field
	 * @param driver
	 * @param xpath
	 * @param value
	 * @param message
	 * @throws Exception
	 */
	public void InputText(WebDriver driver, String xpath, String value, String message) throws Exception
	{
		try
		{
			driver.findElement(By.xpath(xpath)).sendKeys(value);
			if(driver.findElement(By.xpath(xpath)).getAttribute("value").length()>0)
				MyListeners.pass_Screenshot(driver, message + " is entered");
			else
				MyListeners.fail_Screenshot(driver, message + " is not entered");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not entered due to Exception");
		}
	}
	
	/**
	 * used to clear and enter text in input field
	 * @param driver
	 * @param xpath
	 * @param value
	 * @param message
	 * @throws Exception
	 */
	public void clearInputText(WebDriver driver, String xpath, String value, String message) throws Exception
	{
		try
		{
			
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(value);
			if(driver.findElement(By.xpath(xpath)).getAttribute("value").length()>0)
				MyListeners.pass_Screenshot(driver, message + " is entered");
			else
				MyListeners.fail_Screenshot(driver, message + " is not entered");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not entered due to Exception");
		}
	}
	
	/**
	 * used to click a button or link
	 * @param driver
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void clickButtonLink(WebDriver driver, String xpath, String message) throws Exception
	{
		try
		{
			driver.findElement(By.xpath(xpath)).click();
			MyListeners.pass_Screenshot(driver, message + " is clicked");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not clicked due to Exception");
		}
	}
	
	public void clkBtn(WebDriver driver, String xpath, int index, String message) throws Exception
	{
		try
		{
			driver.findElements(By.xpath(xpath)).get(index).click();
			MyListeners.pass_Screenshot(driver, message + " is clicked");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not clicked due to Exception");
		}
	}
	
	/**
	 * used to get list of web elements
	 * @param driver
	 * @param xpath
	 * @return list<WebElemnet>
	 * @throws Exception
	 */
	public List<WebElement> getListofWebElements(WebDriver driver, String xpath) throws Exception
	{
		List<WebElement> elements = null;
		try
		{
			elements = driver.findElements(By.xpath(xpath));
			if(elements.size()>0)
				MyListeners.pass_Screenshot(driver, " Elements are displayed");
			else
				MyListeners.fail_Screenshot(driver, " Elements are not displayed");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, " Elements are not displayed due to Exception");
		}
		return elements;
	}
	
	/**
	 * used to get text of a web element
	 * @param driver
	 * @param xpath
	 * @param message
	 * @return string
	 * @throws Exception
	 */
	public String getText(WebDriver driver, String xpath, String message) throws Exception
	{
		String text = null;
		try
		{
			text = driver.findElement(By.xpath(xpath)).getText();
			if(text.length()>0)
				MyListeners.pass_Screenshot(driver, message + " has " + text);
			else
				MyListeners.fail_Screenshot(driver, message + " is not displayed");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, " is not displayed due to Exception");
		}
		return text;
	}
	
	/**
	 * this method is used to get text for list of element
	 * @param driver
	 * @param xpath should be common for all elemnts
	 * @param message
	 * @return
	 * @throws Exception
	 */
	
	public String getAllText(WebDriver driver, String xpath, String message) throws Exception
	{
		String text = null;
		try
		{
			List<WebElement> objects = driver.findElements(By.xpath(xpath));
			for(int i=0;i<objects.size();i++)
			{
				text = objects.get(i).getText();
				if(text.length()>0)
					MyListeners.pass_Screenshot(driver, message + " has " + text);
				else
					MyListeners.fail_Screenshot(driver, message + " is not displayed");
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, " is not displayed due to Exception");
		}
		return text;
	}
	
	/**
	 * used to get text of input field
	 * @param driver
	 * @param xpath
	 * @return string text
	 * @param message
	 * @throws Exception
	 */
	public String getInputText(WebDriver driver, String xpath, String message) throws Exception
	{
		String text = null;
		try
		{
			text = driver.findElement(By.xpath(xpath)).getAttribute("value");
			if(text.length()>0)
				MyListeners.pass_Screenshot(driver, message + " has " + text);
			else
				MyListeners.fail_Screenshot(driver, message + " is not displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
		return text;
	}
	
	/**
	 * used to get text of input field
	 * @param driver
	 * @param xpath
	 * @return string text
	 * @param message
	 * @throws Exception
	 */
	public String getAttributeValue(WebDriver driver, String xpath, String attribute, String message) throws Exception
	{
		String text = null;
		try
		{
			text = driver.findElement(By.xpath(xpath)).getAttribute("attribute");
			if(text.length()>0)
				MyListeners.pass_Screenshot(driver, message + " has " + text);
			else
				MyListeners.fail_Screenshot(driver, message + " is not displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
		return text;
	}
	
	/**
	 * checks whether a web element is enabled or not
	 * @param driver
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void checkElementisEnabled(WebDriver driver, String xpath, String message) throws Exception
	{
		try
		{
			if(driver.findElement(By.xpath(xpath)).isEnabled())
				MyListeners.pass_Screenshot(driver, message + " is Enabled");
			else
				MyListeners.fail_Screenshot(driver, message + " is not Enabled");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
	}
	
	/**
	 * checks whether a web element is selected or not
	 * @param driver
	 * @param xpath
	 * @param message
	 * @throws Exception
	 */
	public void checkElementisSelected(WebDriver driver, String xpath, String message) throws Exception
	{
		try
		{
			if(driver.findElement(By.xpath(xpath)).isSelected())
				MyListeners.pass_Screenshot(driver, message + " is selected");
			else
				MyListeners.fail_Screenshot(driver, message + " is not selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
	}
	
	/**
	 * used to select an option by visible text from static drop down using select clause
	 * @param driver
	 * @param xpath----select tag X-path should be used
	 * @param text
	 * @throws Exception 
	 */
	public void selectDropdownbyVisibleText(WebDriver driver, String xpath, String text) throws Exception
	{
		try
		{
			Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
			dropdown.selectByVisibleText(text);
			if(driver.findElement(By.xpath(xpath)).isSelected())
				MyListeners.pass_Screenshot(driver, text + " is selected");
			else
				MyListeners.fail_Screenshot(driver, text + " is not selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, text + " is not displayed due to Exception");
		}
	}
	
	/**
	 * used to select an option by value from static drop down using select clause
	 * @param driver
	 * @param xpath----select tag X-path should be used
	 * @param text
	 * @throws Exception 
	 */
	public void selectDropdownbyValue(WebDriver driver, String xpath, String text) throws Exception
	{
		try
		{
			Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
			dropdown.selectByValue(text);
			if(driver.findElement(By.xpath(xpath)).isSelected())
				MyListeners.pass_Screenshot(driver, text + " is selected");
			else
				MyListeners.fail_Screenshot(driver, text + " is not selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, text + " is not displayed due to Exception");
		}
	}
	
	/**
	 * used to select an option by index from static drop down using select clause
	 * @param driver
	 * @param xpath----select tag X-path should be used
	 * @param text
	 * @throws Exception 
	 */
	public void selectDropdownbyIndex(WebDriver driver, String xpath, int index, String message) throws Exception
	{
		try
		{
			Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
			dropdown.selectByIndex(index);
			if(driver.findElement(By.xpath(xpath)).isSelected())
				MyListeners.pass_Screenshot(driver, message + " is selected");
			else
				MyListeners.fail_Screenshot(driver, message + " is not selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			MyListeners.fail_Screenshot(driver, message + " is not displayed due to Exception");
		}
	}
}
