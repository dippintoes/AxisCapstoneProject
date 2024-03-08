package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CustomerLoginFunctionalitiesPage;
import com.crm.qa.pages.HomeDashBoardPage;

public class CustomerLoginFunctionalitiesTest extends TestBase {
	HomeDashBoardPage hdbPage;
	CustomerLoginFunctionalitiesPage custPage;
	
	public CustomerLoginFunctionalitiesTest(){
		super();
	}
	
	@BeforeClass 
	@Parameters("browser") 
	public void setUp(@Optional("chrome") String browser){
		initialization(browser);
		hdbPage = new HomeDashBoardPage();
		custPage= new CustomerLoginFunctionalitiesPage();
	}
	
	@Test(priority=20)
	public void VerifycustLoginBtnFunctionality(){
		Assert.assertTrue(hdbPage.VerifycustLoginBtnFunctionality(),"Customer Login button is working properly.");
	}
	
	@Test(priority=21)
	public void VerifyCustomerLogin(){
		Assert.assertEquals(custPage.verifyCustomerLogin(), custPage.optionToSelect, "Customer Login is unsuccessfull");
	}
	
//	@Test(priority=22)
//	public void verifyCustomerAccounts(){
//		Assert.assertEquals(custPage.verifyCustomerAccounts(), "All account numbers of\" + optionToSelect + \"has been verified", "Account number mismatch has been found");
//	}
	
	// Deposit related functionalities
	
	@Test(priority=23)
	public void depositValidAmount(){
		Assert.assertEquals(custPage.depositAmount(100),"Deposit Successful","Deposit unsuccessfull");
	}
	
	@Test(priority=24)
	public void depositInValidAmount(){
		custPage.depositTextField.clear();
		Assert.assertEquals(custPage.depositAmount(-133),"Deposit Successful","No warning raised. New issue detected");
	}
	
	@Test(priority=25)
	public void depositDecimalAmount(){
		custPage.depositTextField.clear();
		Assert.assertEquals(custPage.depositAmount(35.43),"Please enter a valid value","Deposit successfull. New Issue detected");
	}
	
	// Withdrawl related functionalities
	
	@Test(priority=26)
	public void withdrawValidAmount(){
		// Refresh the page
		driver.navigate().refresh();
		Assert.assertEquals(custPage.withdrawAmount(100),"Transaction successful","Transaction unsuccessfull");
	}
	
	@Test(priority=27)
	public void withdrawInValidAmount(){
		driver.navigate().refresh();
		Assert.assertEquals(custPage.withdrawInValidAmount(-133),"Transaction successful","No warning raised. New issue detected");
	}
	
	@Test(priority=28)
	public void withdrawDecimalAmount(){
		custPage.depositTextField.clear();
		Assert.assertEquals(custPage.withdrawAmount(35.43),"Please enter a valid value","Transaction successfull. New Issue detected");
	}
	
	@Test(priority=29)
	public void withdrawInsufficientAmount(){
		custPage.depositTextField.clear();
		Assert.assertEquals(custPage.withdrawInSufficientAmount(1000000),"Warning raised regading insufficient balance.","No warning raised. New Issue detected");
	}
	
	// Transaction related functionalities
	
	@Test(priority=30)
	public void transactionResetFunctionalities(){
		Assert.assertEquals(custPage.resetTransactions(),"Data reset successful","No warning raised. Major Issue detected. Balance is resetting, too.");
	}
	
	@Test(priority=31)
	public void transactionBackFunctionalities(){
		Assert.assertEquals(custPage.backTransactions(),"Back button works successfully","Back button does not work");
	}
	
	
	
	//logout related functionalities
	
	@Test(priority=32)
	public void VerifyLogoutFunctionality(){
		Assert.assertTrue(custPage.logout(),"Logout Functionality is working properly.");
		driver.navigate().back();
	}
	
	@Test(priority=33)
	public void VerifyPostLogoutFunctionality(){
		Assert.assertEquals(custPage.postlogout(),"Customer is not able to visit the session after logging out.","Customer is able to visit the session after logging out. New issue");
	}
	
	@Test(priority=34)
	public void VerifyredirectToNonaccessablePageFunctionality(){
		Assert.assertEquals(custPage.redirectToNonaccessablePage(),"Customer is not access the account after logging out.","Customer is able to access the account after logging out. New issue");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}