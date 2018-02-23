package stepdefinition;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class Find_Inmates_Page {

	public WebDriver driver;
	By menu_find_inmate = By.id("achrFindInmates");
	By dwn_state = By.id("ContentPlaceHolder1_ddlState");
	By dwn_facility = By.id("ddlFacilityCodes");
	By btn_search = By.id("btnSubmit");
	By select_inmate = By.className("odd");
	By txt_relationship = By.id("ContentPlaceHolder1_txtRelationShip");
	By btn_Add_To_Contacts = By.id("ContentPlaceHolder1_btnCircle");
	By btn_ok = By.id("btnOk");
	private static Logger log = Logger.getLogger(Sent_Item_Page.class.getName());
	
	public void Find_Inmates(DataTable findIn) throws Exception{
		
		this.driver = new Login_Page().getDriver();	
		List<List<String>>li=findIn.raw();
		Thread.sleep(1000);		
		driver.findElement(menu_find_inmate).click();				
		Select obj = new Select(driver.findElement(dwn_state));
		obj.selectByValue(li.get(0).get(1));
		log.info("State has been chosen successfully");		
		Thread.sleep(1000);
		Select obj1 = new Select(driver.findElement(dwn_facility));
		obj1.selectByValue(li.get(1).get(1));
		log.info("Facility has been chosen successfully");
		Thread.sleep(1000);
		driver.findElement(btn_search).click();
		Thread.sleep(1000);
		driver.findElement(select_inmate).click();
		Thread.sleep(1000);
		driver.findElement(txt_relationship).sendKeys(li.get(2).get(1));		
		Thread.sleep(1000);
		driver.findElement(btn_Add_To_Contacts).click();
		log.info("Contact successfully added");
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();
	}
	 
}
