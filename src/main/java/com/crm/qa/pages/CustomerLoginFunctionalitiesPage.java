package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class CustomerLoginFunctionalitiesPage extends TestBase {
	
		BankManagerLoginFunctionalitiesPage bmPage=new 	BankManagerLoginFunctionalitiesPage();
;


	    @FindBy(xpath="//select[@id='userSelect']")
	    WebElement loginDropdown;
	    
	  
	
	    @FindBy(xpath="//button[contains(text(),'Login')]")
	    WebElement loginBtn;
	
	    public String optionToSelect = "Hermoine Granger";
	
	    // post-login
	    @FindBy(xpath="//span[contains(text(),'Hermoine Granger')]")
	    WebElement welcomeName;
	    
	    @FindBy(xpath="//select[@id='accountSelect']")
	    WebElement accDropdown;
	    
		// Initializing the Page Objects:
	
	    public CustomerLoginFunctionalitiesPage() {
	        PageFactory.initElements(driver, this);
	    }
	    
	    //login related functionalities
	    
	    public String verifyCustomerLogin() {
	        loginDropdown.click();
	        new Select(loginDropdown).selectByVisibleText(optionToSelect);
	        loginBtn.click();
	        return welcomeName.getText();
	    }
	    
//	    public String verifyCustomerAccounts() {
//	    	// Store dropdown options in a list
//	    	Boolean flag=true;
//	        List<String> dropdownOptions = new ArrayList<>();
//	        // Iterate over the dropdown options
//	        for (WebElement option : new Select(accDropdown).getOptions()) {
//	            String optionText = option.getText();
//	            dropdownOptions.add(optionText);
//	        }
//	        
//	        String num=bmPage.getAccountNumber("Hermoine");
//	        System.out.println(num);
//	        String[] stringArray = num.split(" ");
//	        for (String element : stringArray) {
//	            System.out.println(element);
//	        }
//	        
//	        // Match dropdown options with accountNumberArray
//	        for (String accountNumber : stringArray) {
//	            if (dropdownOptions.contains(accountNumber)) {
//	                System.out.println("Match found for Account Number: " + accountNumber);
//	                flag=true;
//	            } else {
//	                System.out.println("No match found for Account Number: " + accountNumber);
//	                flag=false;
//	            }
//	        }
//	        if(flag=true) {
//	        	return "All account numbers of" + optionToSelect + "has been verified";
//	        }
//	        else {
//	        	return "Account number mismatch has been found";
//	        }
//	    }
//	    
	    //deposit related functionalities
	    
	    //deposit tab
	    @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[3]/button[2]")
	    WebElement depositTab;
	    
	    //deposit text field tab
	    @FindBy(xpath="//input[@placeholder='amount']")
	    public
	    WebElement depositTextField;
	    
	    //deposit button
	    @FindBy(xpath="//button[@type='submit']")
	    WebElement depositButton;
	    
	    //deposit valid functions
	    public String depositAmount(int amount){
	    	WebElement initialBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
	        int initialbal=Integer.parseInt(initialBalance.getText());
	        
	    	depositTab.click();
	        depositTextField.sendKeys(String.valueOf(amount));
	        depositButton.click();
	        
	        //deposit acknowledgement
	        WebElement depositAck=driver.findElement(By.xpath("//span[contains(text(),'Deposit Successful')]"));
	    	
	        WebElement finalBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
	        
	        int finalbal=Integer.parseInt(finalBalance.getText());
	        
	        System.out.println(initialbal + " " + finalbal);
	        
	        if(finalbal==initialbal+amount) {
	          return depositAck.getText();
		    }
		    else{
		      return "Invalid Input";
		    }
	    }
	    
		//deposit valid functions
		public String depositAmount(double amount){
	    	WebElement initialBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
	        int initialbal=Integer.parseInt(initialBalance.getText());
	        
	    	depositTab.click();
	        depositTextField.sendKeys(String.valueOf(amount));
	        depositButton.click();
	
	        WebElement finalBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
	        int finalbal=Integer.parseInt(finalBalance.getText());
	        
	        System.out.println(initialbal + " " + finalbal);
	        
	        if(finalbal==initialbal+amount) {
	          return "Deposit successfull";
		    }
		    else{
		      return "Please enter a valid value";
		    }  
	    }
	
		//wihtdrawl related functionalities
	
    	//withdraw tab
	    @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[3]/button[3]")
	    public
	    WebElement withdrawlTab;
	    
	    //withdraw text field tab
	    @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
	    public
	    WebElement withdrawTextField;
	    
	    //withdraw button
	    @FindBy(xpath="//button[@type='submit']")
	    WebElement withdrawButton;
  	
		//withdraw valid functions
		public String withdrawAmount(int amount){
		      WebDriverWait wait = new WebDriverWait(driver, 20);  
			  wait.until(ExpectedConditions.elementToBeClickable(withdrawlTab));
			  
			  withdrawlTab.click();
		      withdrawTextField.sendKeys(String.valueOf(amount));
		      withdrawButton.click();
		      
		      //withdrawl acknowledgement
		      WebElement depositAck3=driver.findElement(By.xpath("//span[contains(text(),'Transaction successful')]"));
		      
		      if(depositAck3.isDisplayed()) {
		        return depositAck3.getText();
		    }
		    else{
		    	return "Invalid Input";
		    }
		      
		  }
		  
		//withdraw invalid functions
		public String withdrawInValidAmount(double amount){
			  WebElement initialBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
		      int initialbal=Integer.parseInt(initialBalance.getText());
			 
		      withdrawlTab.click();
		  	  withdrawTextField.sendKeys(String.valueOf(amount));
		  	  withdrawButton.click();

		      WebElement finalBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
			  int finalbal=Integer.parseInt(finalBalance.getText());
			      			      
			  if(finalbal==initialbal-amount) {
			      return "Transaction successful";
			  }
			  else{
			      return "Invalid Input";
			  }
		  }
		  
  
		  //withdraw decimal functions
		  public String withdrawAmount(double amount){
		  	  WebElement initialBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
		      int initialbal=Integer.parseInt(initialBalance.getText());
		      
		  	  withdrawlTab.click();
		  	  withdrawTextField.sendKeys(String.valueOf(amount));
		      withdrawButton.click();
		      
		      WebElement finalBalance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));
		      int finalbal=Integer.parseInt(finalBalance.getText());
		      
		      System.out.println("withdrawl "+initialbal + " " + finalbal);
		      
		      if(finalbal==initialbal-amount) {
		        return "Withdrawl successfull";
		      }
		      else{
		    	return "Please enter a valid value";
		      }    
		  }
		  
		  
		  //insufficient balance
		  public String withdrawInSufficientAmount(double amount){		
			  
			  	withdrawlTab.click();
			  	withdrawTextField.sendKeys(String.valueOf(amount));
			    withdrawButton.click();  
			    
			  	WebElement warning=driver.findElement(By.xpath("//span[contains(text(),'Transaction Failed. You can not withdraw amount mo')]"));
	
			    if(warning.isDisplayed()) {
			        return "Warning raised regading insufficient balance.";
			    }
			    else{
			    	return "No warning raised";
			    }      
	      }
		  
	    
		 //transactions related functionalities
	     public String resetTransactions(){
	    	 
	    	//transactions tab
	    	WebElement transactionsTab=driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[3]/button[1]"));
	    	transactionsTab.click();
	    	
	    	WebElement transactiontable = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/table[1]"));    
	    	
	    	WebElement resetBtn=driver.findElement(By.xpath("//button[contains(text(),'Reset')]"));
	
	    	resetBtn.click();
	    	
	    	if(!transactiontable.isDisplayed()) {
	    		return "Data reset successful";
	    	}
	    	else {
	    		return "Data reset unsuccessful";
	    	}
	    	
	    }    
	    
	    public String backTransactions(){
	    	//transactions tab
	    	WebElement backBtn=driver.findElement(By.xpath("//button[contains(text(),'Back')]"));
	
	    	backBtn.click();
	    	
	    	WebElement Balance=driver.findElement(By.cssSelector("body.ng-scope:nth-child(2) div.ng-scope:nth-child(1) div.container-fluid.ng-scope div.ng-scope div.borderM.box.padT20.ng-scope div.center:nth-child(3) > strong.ng-binding:nth-child(2)"));	     
	    	
	    	if(Balance.isDisplayed()) {
	    		return "Back button works successfully";
	    	}
	    	else {
	    		return "Back button does not work";
	    	}
	    }
	    
	    //logout related functionalities
	    @FindBy(xpath="//button[contains(text(),'Logout')]")
		WebElement logoutBtn;
	    
	    public Boolean logout() {
			logoutBtn.click();
			return loginDropdown.isDisplayed();
		}
		
		public String postlogout(){
			if(logout()) {
				driver.navigate().back();
				// post-login
				if(!welcomeName.isDisplayed()) {
					return "Customer is not able to visit the session after logging out.";
				}
				else {
					return "Customer is able to visit the session after logging out. New issue";
				}
			}
			else {
				return "Login unsuccessful";
			}
		}
		
		public String redirectToNonaccessablePage(){
			if(logout()) {
				driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
				// post-login
				if(!welcomeName.isDisplayed()) {
					return "Customer is not access the account after logging out.";
				}
				else {
					return "Customer is able to access the account after logging out. New issue";
				}
			}
			else {
				return "Login unsuccessful";
			}
		}
 
}
