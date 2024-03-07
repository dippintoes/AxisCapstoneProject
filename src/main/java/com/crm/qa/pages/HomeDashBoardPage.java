package com.crm.qa.pages;
	
import org.openqa.selenium.WebElement;	
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomeDashBoardPage extends TestBase{
	
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
		
}
