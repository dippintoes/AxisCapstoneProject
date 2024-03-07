package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class BankManagerLoginFunctionalitiesPage extends TestBase{
	
	    @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
	    WebElement addCustomerBtn;
	    
	    @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[2]")
	    WebElement openAccountBtn;
	    
	    @FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[3]")
	    WebElement customersBtn;
		
	    @FindBy(xpath="//span[contains(text(),'Hermoine Granger')]")
	    WebElement welcomeName;
	    
		// Initializing the Page Objects:
	
	    public BankManagerLoginFunctionalitiesPage() {
	        PageFactory.initElements(driver, this);
	    }
	    
	   
	    @FindBy(xpath="//input[@placeholder=\"First Name\"]")
	    WebElement fnametext;
	    
	    @FindBy(xpath="//input[@placeholder=\"Last Name\"]")
	    WebElement lnametext;
	    
	    @FindBy(xpath="//input[@placeholder=\"Post Code\"]")
	    WebElement pcodetext;
	    
	    @FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/form[1]/button[1]")
	    WebElement customerSubmitBtn;
	    
	    //add customer functionalities
	    public String addCustomer(String fname,String lname, String pcode){
	    	addCustomerBtn.click();
	    	
	    	fnametext.sendKeys(fname);
	    	lnametext.sendKeys(lname);
	    	pcodetext.sendKeys(pcode);
	    	
	        customerSubmitBtn.click();
	        try {
		    // Handle the pop-up (JavaScript alert)
		    Alert alert = driver.switchTo().alert();
	        

	        // Get the text from the alert
	        String alertText = alert.getText();	      
	        System.out.println(alertText);
	        
	        // Close the alert by accepting it
	        alert.accept();

	        // Validate the content of the alert
	        if (alertText.contains("Customer added successfully")) {
//	        	 int id=Integer.parseInt(alertText.substring(46));
	            return "Pop-up validation: Customer added successfully";
	        } 
	        else if(alertText.contains("Customer may be duplicate.")) {
	        	return "Pop-up validation: Customer may be duplicate.";
	        }
	        else {
	            return "Pop-up validation: Unexpected or no success message";
	        }
	        }
	        catch(NoAlertPresentException e) {
	        	return "No customer added. Mandatory fields works.";
	        }
	    }
	    
	    @FindBy(xpath="//select[@id='userSelect']")
	    WebElement dropdownCust;
	    
	    @FindBy(xpath="//select[@id='currency']")
	    WebElement dropdownCurr;
	
	    @FindBy(xpath="//button[contains(text(),'Process')]")
	    WebElement processBtn;
	
	    public String optionToSelect = "Rutuja Gosavi";
	    public String optionToSelect2 = "Rupee";
	    
	    //open account functionalities
	    public String openAccount(){
	    	openAccountBtn.click();
	    	dropdownCust.click();
		    new Select(dropdownCust).selectByVisibleText(optionToSelect);
		    dropdownCurr.click();
		    new Select(dropdownCurr).selectByVisibleText(optionToSelect2);
		    processBtn.click();
		    
		    Alert alert = driver.switchTo().alert();
	        
	        // Get the text from the alert
	        String alertText = alert.getText();	      
	        System.out.println(alertText);
	        
	        // Close the alert by accepting it
	        alert.accept();

	        // Validate the content of the alert
	        if (alertText.contains("Account created successfully")) {
	            return "Pop-up validation: Opened account successfully";
	        } 
	        else {
	            return "Pop-up validation: Account opening failed";
	        }
	    }
	    
	    @FindBy(xpath="//input[@placeholder=\"Search Customer\"]")
	    public
	    WebElement searchInput;
	    
	    //display customers functionality
	    public String displayCustomersSearch(String keyword) {
	    	customersBtn.click();
	        searchInput.sendKeys(keyword);
	        
	        WebElement searchResultsTable = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]")); 

	        boolean isKeywordPresentInResults = false;


	        for (WebElement row : searchResultsTable.findElements(By.tagName("tr"))) {
	            if (row.getText().contains(keyword)) {
	                isKeywordPresentInResults = true;
	                break;
	            }
	        }

	        // Verify if the keyword is present in the search results
	        if (isKeywordPresentInResults) {
	            return "Search results verification successful.";
	        } else {
	            return "Search results verification failed. Keyword not found in results.";
	        }
	    }
	    
	    @FindBy(xpath="//button[contains(text(),'Delete')]")
	    public
	    WebElement deleteBtn;
	    
	    public String deleteCustomer(String Keyword) {
	    		if(displayCustomersSearch(Keyword)=="Search results verification successful.") {
	    	        deleteBtn.click();
	    		}
	    		searchInput.clear();
	    		if(displayCustomersSearch(Keyword)=="Search results verification failed. Keyword not found in results.") {
	    			return "Delete operation successful";
	    		}
	    		else {
	    			return "Delete operation unsuccessful";
	    		}
	    }
	    
	    
	    //store data
	    public String getAccountNumber(String name) {
	    	 // Find the table element
	        WebElement table = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/table[1]"));  // Replace with your actual table ID

	        // Store data in arrays
	        List<String> firstNameArray = new ArrayList<>();
	        List<String> lastNameArray = new ArrayList<>();
	        List<String> postCodeArray = new ArrayList<>();
	        List<String> accountNumberArray = new ArrayList<>();

	        // Iterate through rows
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	        for (WebElement row : rows) {
	            // Extract data from columns
	            List<WebElement> columns = row.findElements(By.tagName("td"));
	            
	            // Assuming the table structure has four columns (First Name, Last Name, Post Code, Account Number)
	            firstNameArray.add(columns.get(0).getText());
	            lastNameArray.add(columns.get(1).getText());
	            postCodeArray.add(columns.get(2).getText());
	            accountNumberArray.add(columns.get(3).getText());
	        }

	        // Print or use the stored data as needed
	        for (int i = 0; i < firstNameArray.size(); i++) {
	            if(firstNameArray.get(i)==name) {
	            	return accountNumberArray.get(i);
	            }
	        }
	        return "customer not found";
	    }
}
