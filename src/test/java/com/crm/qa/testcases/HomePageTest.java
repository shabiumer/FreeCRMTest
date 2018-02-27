package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

import qa.crm.qa.base.TestBase;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	DealsPage dealspage;
	TasksPage taskspage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod	
	public void setUp() {
		initialization();
		loginpage=new LoginPage(driver); 
		testutil=new TestUtil();
		contactpage = new ContactPage(driver);
		dealspage = new DealsPage(driver);
		taskspage = new TasksPage(driver);
		homepage = new HomePage(driver);
		homepage = loginpage.Login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void validatePageTitleTest() {
		String hptitle = homepage.verifyPageTitle();
		Assert.assertEquals(hptitle,"CRMPRO","Page Title does not mathch");		
	}
	
	@Test(priority=2)
	public void varifyUsernameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyUsername()); 
		
	}
	
	@Test(priority=3)
	public void verifyContactsLink() {
		testutil.switchToFrame();
		contactpage = homepage.clickOnContactLink();
	}
	
	@Test(priority=4)
	public void verifyDealsLink() {
		testutil.switchToFrame();
		dealspage = homepage.clickOnDealsLink();
	}
	@Test(priority=5)
	public void verifyTasksLink() {
		testutil.switchToFrame();
		taskspage = homepage.clickOnTasksLink();
	}
}
