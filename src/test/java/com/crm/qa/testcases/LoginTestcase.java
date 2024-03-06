package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPageTest;

public class LoginTestcase extends TestBase {
	LoginPageTest login;
	
	public LoginTestcase(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		login = new LoginPageTest();	
	}
	
	@Test
	public void loginPageTitleTest(){
		String title = login.addtocart();
		Assert.assertEquals(title, "Products");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}