package com.crm.qa.pages;
	
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomeDashBoardPage extends TestBase{
		BankManagerLoginFunctionalitiesPage bmPage=new BankManagerLoginFunctionalitiesPage();
		CustomerLoginFunctionalitiesPage custPage=new CustomerLoginFunctionalitiesPage();
		
		@FindBy(xpath="//strong[contains(text(),'XYZ Bank')]")
		WebElement title;
		
		@FindBy(xpath="//button[contains(text(),'Home')]")
		WebElement homeBtn;
		
		@FindBy(xpath="//button[contains(text(),'Customer Login')]")
		WebElement custLoginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Bank Manager Login')]")
		WebElement bankManagerLoginBtn;
		
		//customer login page
		@FindBy(xpath="//select[@id='userSelect']")
		WebElement loginDropdown;
		
		//bank manager login page
		@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
		WebElement addCustomerBtn;
		
		//Initializing the Page Objects:
		
		public HomeDashBoardPage(){
			PageFactory.initElements(driver, this);
		}
		
		public String VerifyTitle() {
			return title.getText();
		}
		
		public Boolean VerifyHomeBtn() {
			return homeBtn.isDisplayed();
		}
		
		public Boolean VerifycustLoginBtn() {
			return custLoginBtn.isDisplayed();
		}
		
		public Boolean VerifybankManagerLoginBtn() {
			return bankManagerLoginBtn.isDisplayed();
		}
		
		public Boolean VerifyHomeBtnFunctionality() {
			homeBtn.click();
			return custLoginBtn.isDisplayed() && bankManagerLoginBtn.isDisplayed();
		}
		
		public Boolean VerifycustLoginBtnFunctionality() {
			custLoginBtn.click();
			return loginDropdown.isDisplayed();
		}
		
		public Boolean VerifybankManagerLoginBtnFunctionality() {
			bankManagerLoginBtn.click();
			return addCustomerBtn.isDisplayed();
		}
		
		//Non account holders related functionalities
	     public String nonAccountCustomers(){ 
	    	//transactions tab
	    	driver.get(prop.getProperty("url"));
	    	bankManagerLoginBtn.click();
	    	addCustomerBtn.click();
	    	
	    	WebElement fnametext=driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));
			WebElement lnametext=driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
			WebElement pcodetext=driver.findElement(By.xpath("//input[@placeholder=\"Post Code\"]"));
			WebElement customerSubmitBtn=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]"));
	    	
			fnametext.sendKeys("Sirius");
	    	lnametext.sendKeys("Black");
	    	pcodetext.sendKeys("22356");
	       
	    	customerSubmitBtn.click();
	     
		    Alert alert = driver.switchTo().alert();
	        alert.accept();
	        
	    	driver.get(prop.getProperty("url"));
	    	
	    	custLoginBtn.click();
	    	loginDropdown.click();
		    
	    	new Select(loginDropdown).selectByVisibleText("Sirius Black");
			WebElement loginBtn=driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		    loginBtn.click();
	    	
	    	//bank manager login page
	    	WebElement noncustomer=driver.findElement(By.xpath("//span[contains(text(),'Please open an account with us.')]"));
	    	System.out.println(noncustomer.getText());
	    	return noncustomer.getText();
	    }   
		
}
