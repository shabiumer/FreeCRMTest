package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.crm.qa.base.TestBase;

public class HomePage extends TestBase{


	WebDriver driver;
	
	@FindBy(xpath="//td[contains(text(),'User: shoaib umer')]")
	WebElement userverified;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//div[@id='navmenu']//a[@title='New Contact']")
	WebElement newContactLink;
		
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() { 
		 return driver.getTitle();
		 
	}
	
	public boolean verifyUsername() {
		return userverified.isDisplayed();
	}
	
	public ContactPage clickOnContactLink() {
		contactLink.click();
		return new ContactPage(driver);
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage(driver);
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage(driver);
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		newContactLink.click();
	}
	
	
}
