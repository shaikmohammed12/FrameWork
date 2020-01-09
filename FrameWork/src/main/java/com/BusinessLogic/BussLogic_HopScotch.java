package com.BusinessLogic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PageObjects.PageObjects;
import com.Resources.ElementAction;
import com.Resources.Excel;

public class BussLogic_HopScotch extends PageObjects {
	
	public static WebDriver driver = null;
	public static String TC_ID = null;
	ElementAction action = new ElementAction();
	
	public BussLogic_HopScotch(WebDriver webdriver,String tc_ID)
	{
		driver = webdriver;
		TC_ID = tc_ID;
		
	}

	
	public void register() throws Throwable
	{
		action.checkElementDisplay(driver, boutiques, "Discovery page");
		action.checkElementDisplayed(driver, MW_accountsTab, "Accounts tab");
		action.clickButtonLink(driver, MW_accountsTab, "Accounts tab");
		action.checkElementDisplayed(driver, MW_signInBtn, "SignIn button");
		action.clickButtonLink(driver, MW_signInBtn, "SignIn button");
		action.checkTextDisplayed(driver, MW_signInpageHeader, "Sign in", "Login page");
		action.checkElementDisplay(driver, MW_JoinusLink, "Join us link");
		action.clickButtonLink(driver, MW_JoinusLink, "Join us link");
		action.checkElementDisplayed(driver, MW_signInpageHeader, "Sign up page");
		action.checkElementDisplayed(driver, MW_fullName, "Full name field");
		action.InputText(driver, MW_fullName, Excel.getData("Data", TC_ID, "fullname"), "Full name");
		action.checkElementDisplayed(driver, MW_email, "Email field");
		action.InputText(driver, MW_email, Excel.getData("Data", TC_ID, "loginid"), "Email");
		action.checkElementDisplayed(driver, MW_phoneNo, "Mobile Number field");
		action.InputText(driver, MW_phoneNo, Excel.getData("Data", TC_ID, "phonenumber"), "mobile number");
		action.checkElementDisplayed(driver, MW_sendOTPBtn, "Send OTP button");
		action.clickButtonLink(driver, MW_sendOTPBtn, "Send OTP button");
	}
	
	public void login() throws Throwable
	{
		try
		{
			action.checkElementDisplay(driver, boutiques, "Discovery page");
			action.checkElementDisplayed(driver, MW_accountsTab, "Accounts tab");
			action.clickButtonLink(driver, MW_accountsTab, "Accounts tab");
			action.checkElementDisplayed(driver, MW_signInBtn, "SignIn button");
			action.clickButtonLink(driver, MW_signInBtn, "SignIn button");
			action.checkTextDisplayed(driver, MW_signInpageHeader, "Sign in", "Login page");
			action.checkElementDisplayed(driver, MW_useEmailLink, "Use your email to sign in link");
			action.clickButtonLink(driver, MW_useEmailLink, "Use your email to sign in link");
			action.checkElementDisplayed(driver, MW_loginId, "Login Email field"); 
			action.InputText(driver, MW_loginId, Excel.getData("Data", TC_ID, "loginid"), "Login email id");
			action.InputText(driver, MW_password, Excel.getData("Data", TC_ID, "password"), "Password");
			action.clickButtonLink(driver, MW_signInBtnLoginpage, "Sign In button");
			action.checkTextDisplayed(driver, MW_accountsUserMail, Excel.getData("Data", TC_ID, "loginid"), "Sucessfully LoggedIn user ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void verifyingHomePage() throws Throwable
	{
		try
		{
			action.checkElementDisplayed(driver, MW_hopscotchLogo, "Hopscotch Logo");
			action.checkElementDisplayed(driver, MW_accountsTab, "Accounts tab");
			action.checkElementDisplayed(driver, MW_helpTab, "Help tab");
			action.checkElementDisplayed(driver, MW_searchIcon, "Search Icon");
			action.checkElementDisplayed(driver, MW_wishlistIcon, "WishList Icon");
			action.checkElementDisplayed(driver, MW_cartIcon, "Cart Icon");
			action.checkElementDisplayed(driver, MW_discoverTab, "Discover tab");
			action.checkElementDisplayed(driver, MW_categoriesTab, "Categories tab");
			action.checkElementDisplayed(driver, MW_momentsTab, "Moments tab");
			action.checkElementDisplay(driver, boutiques, "Boutiques");
			action.checkElementDisplayed(driver, MW_shopFor, "Sort bar");
			action.getText(driver, MW_shopFor, "Sort bar title");
			action.checkElementDisplay(driver, MW_sortIconsText, "Sort bar Icons");
			action.getAllText(driver, MW_sortIconsText, "Sort Icon bar");
			action.clkBtn(driver, MW_sorticons, 2, "Sort Icon");
			action.checkElementDisplayed(driver, MW_ageSorts, "Age sort section");
			action.getText(driver, MW_ageSortTitle, "Age sort title");
			action.checkElementDisplay(driver, MW_ageSorts, "Age sort tabs");
			action.getAllText(driver, MW_ageSorts, "Age sort bar");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
