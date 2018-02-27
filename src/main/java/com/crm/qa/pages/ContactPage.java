package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import qa.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	WebDriver driver;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@value='51547566']")
	@CacheLookup
	WebElement selectcontact;
	
	@FindBy(xpath="//input[@value='51547567']")
	@CacheLookup
	WebElement selectcheckbox1;
	
	@FindBy(xpath="//a[@_id='51547567']")
	@CacheLookup
	WebElement selectcontact1;
	
	@FindBy(xpath="//select[@name='title']")
	@CacheLookup
	WebElement contactTitle;
	
	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstName;

	@FindBy(id="surname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save']")
	@CacheLookup
	WebElement saveBtn;


	public ContactPage(WebDriver driver) {
		TestBase.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public boolean contactLabelPresent() {
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContact() {
		if(selectcontact.isSelected()!=true) {
		selectcontact.click();
		}
		
	}

	public void selectContact1() {
		if(selectcontact1.isSelected()==false) {
		selectcontact1.click();
		}
	}
	
	public boolean contactSelected() {
		return selectcontact.isSelected();
	}
	
	public void multiselect() {
		selectcheckbox1.click();
	}
	
	public void newContactDetails(String title, String fname, String lname, String comp) {
		
	Select selectTitle = new Select(contactTitle);
	selectTitle.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		saveBtn.click();

	}
	

}
