package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;



public class Mycontacts_new {

	public WebDriver driver;
	By account = By.id("myAccount");
	By txt_fname = By.id("ContentPlaceHolder1_txtUserFirstName");
	By txt_lname = By.id("ContentPlaceHolder1_txtUserLastName");
	By datepicker_date = By.id("ContentPlaceHolder1_txtDob");
	By btn_update = By.id("btnSubmit");
	By btn_ok = By.id("btnOk");


	public void Mycontact(DataTable acc) throws Exception{
		List<List<String>> li = acc.raw();
		this.driver = new Login_Page().getDriver();	
		driver.findElement(account).click();
		Thread.sleep(1000);
		driver.findElement(txt_fname).clear();
		driver.findElement(txt_fname).sendKeys("mangaipriya");
		driver.findElement(txt_lname).clear();
		driver.findElement(txt_lname).sendKeys("new");
		Thread.sleep(1000);
		driver.findElement(btn_update).click();
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();
	}
}
