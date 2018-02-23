package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class Purchase_credit {
	
	public WebDriver driver;
	By lnk_purchase = By.id("purchaseCredit");
	By dwn_inmate = By.id("ddlInmate");
	By dwn_amt = By.id("ContentPlaceHolder1_ddlCredits");
	By txt_fullname = By.id("ContentPlaceHolder1_txtFullName");
	By txt_card = By.id("ContentPlaceHolder1_txtCreditCardNumber");
	By btn_submit = By.id("btnSubmit");
	By cancel = By.xpath("//*[@id='cancelLink']/span");
	By paypal_email = By.xpath("//input[@id='email']");
	By paypal_pwd = By.id("password");
	By btn_paypal_login = By.id("btnLogin");
	By btn_paynow = By.id("confirmButtonTop");
	
	
public void purchase(DataTable credit) throws Exception{
try{
	this.driver = new Login_Page().getDriver();	
	List<List<String>>li=credit.raw();
	Thread.sleep(1000);	
	driver.findElement(lnk_purchase).click();
	Thread.sleep(1000);	
	
	Select inmate = new Select(driver.findElement(dwn_inmate));
	inmate.selectByValue(li.get(0).get(1));	
	Thread.sleep(1000);	
	
	Select amt = new Select(driver.findElement(dwn_amt));
	amt.selectByValue(li.get(1).get(1));	
	
	
	Thread.sleep(1000);	
	driver.findElement(txt_fullname).sendKeys(li.get(2).get(1));	
	Thread.sleep(1000);	
	driver.findElement(txt_card).sendKeys(li.get(3).get(1));
	Thread.sleep(1000);	
	driver.findElement(btn_submit).click();	
	Thread.sleep(10000);	
	driver.findElement(cancel).click();
	/*driver.findElement(paypal_email).sendKeys(li.get(4).get(1));
	Thread.sleep(3000);	
	driver.findElement(paypal_pwd).sendKeys(li.get(5).get(1));	
	Thread.sleep(2000);	
	driver.findElement(btn_paypal_login).click();
	Thread.sleep(5000);	
	driver.findElement(btn_paynow).click();*/
}catch(Exception e){
	e.printStackTrace();
}
}
}
