

package com.crm.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;




import com.crm.qa.pages.HomePage;

import com.crm.qa.pages.LoginPage;

import qa.crm.qa.base.TestBase;



public class LoginPageTest extends TestBase{

	LoginPage loginPage;

	HomePage homePage;

	

	public LoginPageTest() {

		super();

	}

	

	@BeforeMethod

	public void setUp(){

		initialization();

		loginPage = new LoginPage(driver);	

	}

	

	@Test(priority=1)

	public void loginPageTitleTest(){

		String title = loginPage.validateLoginPageTitle();

		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");

	}

	

	@Test(priority=2)

	public void crmLogoImageTest(){

		boolean flag = loginPage.validateCRMimageLogo();

		Assert.assertTrue(flag);

	}

	

	@Test(priority=3)

	public void loginTest(){

		homePage = loginPage.Login(prop.getProperty("userName"), prop.getProperty("password"));

	}


	@AfterMethod

	public void tearDown(){

		driver.quit();

	}
}