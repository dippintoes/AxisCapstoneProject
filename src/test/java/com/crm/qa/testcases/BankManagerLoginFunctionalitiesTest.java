package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.BankManagerLoginFunctionalitiesPage;
import com.crm.qa.pages.HomeDashBoardPage;

public class BankManagerLoginFunctionalitiesTest extends TestBase{
	HomeDashBoardPage hdbPage;
	BankManagerLoginFunctionalitiesPage bmPage;
	
	public BankManagerLoginFunctionalitiesTest(){
		super();
	}
	
	@BeforeClass 
	public void setUp(){
		initialization();
		hdbPage = new HomeDashBoardPage();
		bmPage= new BankManagerLoginFunctionalitiesPage();
	}
	
	@Test(priority=8)
	public void VerifyBankManagerLoginBtnFunctionality(){
		Assert.assertTrue(hdbPage.VerifybankManagerLoginBtnFunctionality(),"Bank Manager Login button is working properly.");
	}
	
	// add customer related functionalities
	
	@Test(priority=9)
	public void VerifyBankManagerLogin(){
		Assert.assertEquals(bmPage.addCustomer("Rutuja", "Gosavi", "431003"),"Pop-up validation: Customer added successfully", "Customer additon is unsuccessfull");
	}
	
	@Test(priority=10)
	public void VerifyInvalidFnameBankManagerLogin(){
		Assert.assertEquals(bmPage.addCustomer("Rutuja#(483", "Gosavi", "431003"),"Pop-up validation: Unexpected or no success message", "First name is containing special characters and numbers. New issue");
	}
	
	@Test(priority=11)
	public void VerifyInvalidLnameBankManagerLogin(){
		Assert.assertEquals(bmPage.addCustomer("Rutuja", "Go648(#(*savi", "431003"),"Pop-up validation: Unexpected or no success message", "Last name is containing special characters and numbers. New issue");
	}
	
	@Test(priority=12)
	public void VerifyEmptyFieldBankManagerLogin(){
		driver.navigate().refresh();
		Assert.assertEquals(bmPage.addCustomer("", "Gosavi", "431003"),"No customer added. Mandatory fields works.", "The text fields must be mandatory. New issue");
	}
	
	@Test(priority=13)
	public void VerifyDuplicateBankManagerLogin(){
		Assert.assertEquals(bmPage.addCustomer("Rutuja", "Gosavi", "431003"),"Pop-up validation: Customer may be duplicate.", "Mandatory fields are not working. New issue.");
	}
	
	// open account functionalities
	
	@Test(priority=14)
	public void VerifyOpenAccountFunctionality(){
		Assert.assertEquals(bmPage.openAccount(),"Pop-up validation: Opened account successfully", "Opening account failed. New issue.");
	}
	
	// display customer functionalities
	
	@Test(priority=15)
	public void searchCustomersFunctionalityByName(){
		Assert.assertEquals(bmPage.displayCustomersSearch("Rutuja"),"Search results verification successful.", "Searching failed. New issue.");
	}
	
	@Test(priority=16)
	public void searchCustomersFunctionalityByID(){
		bmPage.searchInput.clear();
		Assert.assertEquals(bmPage.displayCustomersSearch("6"),"Search results verification successful.", "Searching failed. New issue.");
	}
	
	@Test(priority=17)
	public void searchCustomersFunctionalityByPostCode(){
		bmPage.searchInput.clear();
		Assert.assertEquals(bmPage.displayCustomersSearch("431003"),"Search results verification successful.", "Searching failed. New issue.");
	}
	
	@Test(priority=18)
	public void deleteCustomerFunctionality(){
		bmPage.searchInput.clear();
		Assert.assertEquals(bmPage.deleteCustomer("Harry"),"Delete operation successful", "Deleting existing user failed. New issue.");
		bmPage.searchInput.clear();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
	