package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	WebDriver driver;

	//PageFactory or Object Repository
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement Loginbtn;
	
	@FindBy(xpath="//button[@type='button'][@class='btn']")
	WebElement Signupbtn;
	
	@FindBy(css=".navbar-brand .img-responsive")
	WebElement crmLogo;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Create methods for actions or functionalities
	//---------------------------------------------
	//validate the login page title
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	//validate the crm image logo
	public boolean validateCRMimageLogo() {
		return crmLogo.isDisplayed();
	}
	
	//validate the crm login credentials
	public HomePage Login(String un, String pw) {
		
		Username.sendKeys(un);
		Password.sendKeys(pw);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", Loginbtn);
		
		 return new HomePage(driver);
		
	}
	
}

