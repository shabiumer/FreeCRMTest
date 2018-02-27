package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import qa.crm.qa.base.TestBase;

public class ContactPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	
	String sheetname ="contacts";
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		contactpage = new ContactPage(driver);
		testutil = new TestUtil();
		homepage = loginpage.Login(prop.getProperty("userName"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactpage = homepage.clickOnContactLink();
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifiyContactlabelTest() {
		Assert.assertTrue(contactpage.contactLabelPresent(), "Contacts");
	}
	
	@Test(priority=2)
	public void clickOnCheckBoxTest() {
		contactpage.selectContact();		
	}
	
	@Test(priority=3)
	public void clickOnCheckbox1Test() {
		contactpage.selectContact1();	
	}
	
	@Test(priority=4)
	public void verifyContactSelectedTest() {
		boolean result = contactpage.contactSelected();
		Assert.assertFalse(result);
	}
	
	@Test(priority=5)
	public void multiselectTest() {
		contactpage.multiselect();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws Exception{
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=6, dataProvider = "getCRMTestData")
	public void validateCreatNewContactTest(String title, String firstName, String lastName, String company) {
		homepage.clickOnNewContactLink();
		contactpage.newContactDetails(title, firstName, lastName, company);
	}
	
}
