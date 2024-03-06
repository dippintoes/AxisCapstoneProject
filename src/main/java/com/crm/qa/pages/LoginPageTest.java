package com.crm.qa.pages;
	
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	
		@FindBy(xpath="//input[@id='user-name']")
		WebElement username;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement password;
		
		@FindBy(xpath="//input[@id='login-button']")
		WebElement login;
		
		@FindBy(xpath="//span[contains(text(),'Products')]")
		WebElement title;
		
		//Initializing the Page Objects:
		
		public LoginPageTest(){
			PageFactory.initElements(driver, this);
		}
		
		// Actions or the methods for add to cart page
		
		public String addtocart() {
			username.sendKeys("standard_user");
			password.sendKeys("secret_sauce");
			login.click();
			return title.getText();
		}
		
}
