package step_defintion;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class Photos {
	
	public WebDriver driver;
	Logger log = Logger.getLogger(Photos.class.getName());
	
	By menu_photos = By.id("rptUser_menuAnchor_3");
	By Inmate_last_name = By.xpath("//*[@id='ddlInmateLastNameSearch_chosen']/a/span");
	By Inmate_first_name = By.xpath("//*[@id='ddlInmateFirstNameSearch_chosen']/a/span");
	By Inmate_search_lastname = By.xpath("//*[@id='ddlInmateLastNameSearch_chosen']/div/div/input");
	By Inmate_search_firstname = By.xpath("//*[@id='ddlInmateFirstNameSearch_chosen']/div/div/input");
	By dwn_status = By.id("ContentPlaceHolder1_ddlStatusSearch");
	By btn_search = By.id("btnSearch");
	By lnk_subject = By.id("lblPhotoSubject");
	By btn_back = By.id("ContentPlaceHolder1_btnBack");
	By pagination = By.xpath("//*[@id='grvPhotosInfo']/tbody/tr[12]/td/table/tbody/tr/td[3]/a");
	By lnk_approved_subject = By.xpath("//a[contains(text(),'sfsdf...')]");
	
	public void photos(DataTable photos) throws Exception{
		List<List<String>>li = photos.raw();
		this.driver= new Login_Staff().getDriver();
		PropertyConfigurator.configure("log4j.properties");
		Thread.sleep(1000);		
		driver.findElement(menu_photos).click();
		Thread.sleep(1000);		
		driver.findElement(Inmate_last_name).click();
		Thread.sleep(1000);
		driver.findElement(Inmate_search_lastname).sendKeys("john");
		Thread.sleep(1000);
		driver.findElement(Inmate_search_lastname).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(Inmate_first_name).click();
		Thread.sleep(1000);
		driver.findElement(Inmate_search_firstname).sendKeys("peter");
		Thread.sleep(1000);
		driver.findElement(Inmate_search_firstname).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		char status ='B';
		switch (status) {
		case 'A':
			Pending(photos);
			break;
		case 'B':
			Approved(photos);
			break;
		case 'C':	
			Rejected(photos);
			break;
		case 'D':	
			All(photos);
			break;
		default:
			break;
		}
		
		//Thread.sleep(1000);
		//driver.findElement(btn_search).click();
		
		Thread.sleep(1000);
		
 	}
	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,950)");
		Thread.sleep(1000);
	}
	
	public void Pending(DataTable pending){
		List<List<String>>li = pending.raw();
		Select s1 = new Select(driver.findElement(dwn_status));
		s1.selectByValue(li.get(0).get(1));
	}
	
	public void Approved(DataTable approved) throws Exception{
		try{
		List<List<String>>li = approved.raw();
		Thread.sleep(2000);
		Select s1 = new Select(driver.findElement(dwn_status));
		s1.selectByValue(li.get(1).get(1));
		Thread.sleep(2000);
		driver.findElement(btn_search).click();
		Thread.sleep(2000);
		driver.findElement(lnk_approved_subject).click();
		Thread.sleep(1000);
		driver.findElement(btn_back).click();
		Thread.sleep(3500);
		scroll();
		Thread.sleep(5500);
		driver.findElement(pagination).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Rejected(DataTable rejected){
		List<List<String>>li = rejected.raw();
		Select s1 = new Select(driver.findElement(dwn_status));
		s1.selectByValue(li.get(2).get(1));
	}
	
	public void All(DataTable all){
		List<List<String>>li = all.raw();
		Select s1 = new Select(driver.findElement(dwn_status));
		s1.selectByValue(li.get(3).get(1));
	}
	
	
}
