/*package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class My_Contacts {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//*[@id='example']/tbody/tr[1]/td[1]")
	WebElement ggg;
	
	@FindBy(id= "myAccount")
	WebElement myAccount;
	
public My_Contacts(WebDriver driver){
    this.driver = driver;    
    PageFactory.initElements(driver, this);	
}


public void Mycontacts(){
	try{
		myAccount.click();
	}catch(Exception e){
		e.printStackTrace();
	}
}
	
	}

*/