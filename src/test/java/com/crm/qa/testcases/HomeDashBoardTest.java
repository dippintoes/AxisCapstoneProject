package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomeDashBoardPage;

public class HomeDashBoardTest extends TestBase {
	HomeDashBoardPage hdbPage;
	
	public HomeDashBoardTest(){
		super();
	}
	
	@BeforeClass 
	@Parameters("browser") 
	public void setUp(@Optional("chrome") String browser){
		initialization(browser);
		hdbPage = new HomeDashBoardPage();
	}
	
	@Test(priority=1)
	public void VerifyTitle(){
		Assert.assertEquals(hdbPage.VerifyTitle(), "XYZ Bank");
	}
	
	@Test(priority=2)
	public void VerifyHomeBtn(){
		Assert.assertTrue(hdbPage.VerifyHomeBtn(),"Home button is not displayed on the screen.");
	}
	

	@Test(priority=3)
	public void VerifycustLoginBtn(){
		Assert.assertTrue(hdbPage.VerifycustLoginBtn(),"Customer Login button is not displayed on the screen.");
	}
	

	@Test(priority=4)
	public void VerifybankManagerLoginBtn(){
		Assert.assertTrue(hdbPage.VerifybankManagerLoginBtn(),"Bank Manager Login button is not displayed on the screen.");
	}
	
	@Test(priority=5)
	public void VerifyHomeBtnFunctionality(){
		Assert.assertTrue(hdbPage.VerifyHomeBtnFunctionality(),"Home button is working properly.");
	}
	
	@Test(priority=6)
	public void VerifycustLoginBtnFunctionality(){
		Assert.assertTrue(hdbPage.VerifycustLoginBtnFunctionality(),"Customer Login button is working properly.");
		driver.navigate().back();
	}
	
	@Test(priority=7)
	public void VerifybankManagerLoginBtnFunctionality(){
		Assert.assertTrue(hdbPage.VerifybankManagerLoginBtnFunctionality(),"Bank Manager button is working properly.");
		driver.navigate().back();
	}
	
	@Test(priority=8)
	public void VerifyNonAccountCustomersFunctionality(){
		Assert.assertEquals(hdbPage.nonAccountCustomers(),"Please open an account with us.","Customer can login to account without creating one!! Major issue");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}