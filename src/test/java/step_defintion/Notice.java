package step_defintion;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class Notice {

	public WebDriver driver;
	Logger log = Logger.getLogger(Notice.class.getName());
	By menu_notice = By.id("rptUser_menuAnchor_4");
	By btn_add_notice = By.id("ContentPlaceHolder1_btnAddNotice");
	By txt_title = By.id("txtTitle");
	By txtarea_arrow = By.id("ContentPlaceHolder1_Editor1_ctl03_ctl01");
	By txtarea_desc = By.id("ContentPlaceHolder1_Editor1_ctl02_ctl01");
	By txt_start_date = By.id("ContentPlaceHolder1_txtStartDate");
	By txt_end_date = By.id("ContentPlaceHolder1_txtEndDate");
	By chk_kiosk = By.id("chkSelectAll");
	By btn_submit = By.id("btnSubmit");
	By btn_ok = By.id("btnOk");
	By dwn_kiosk = By.id("ContentPlaceHolder1_ddlKioskSearch");
	By lnk_title = By.id("lnkNotices");
	By sort_title = By.xpath("//a[contains(text(),'Title')]");
	By sort_start_date = By.xpath("//a[contains(text(),'Start From')]");
	By sort_end_date = By.xpath("//a[contains(text(),'End by')]");
	By pagination = By.xpath("//a[contains(text(),'2')]");
	By export_excel = By.id("ContentPlaceHolder1_imbtnExportToExcel");
	By btn_search = By.id("btnSearch");
	
	public void notice(DataTable notice) throws Exception{
		List<List<String>> li = notice.raw();
		this.driver = new Login_Staff().getDriver();
		Thread.sleep(1000);
		driver.findElement(menu_notice).click();
		Thread.sleep(1000);
		driver.findElement(btn_add_notice).click();
		Thread.sleep(1000);
		
		driver.findElement(txtarea_arrow).click();
		Thread.sleep(1000);
		driver.findElement(txtarea_desc).sendKeys(li.get(1).get(1));
		Thread.sleep(1000);
		//driver.findElement(btn_submit).click();
		Thread.sleep(1000);
		driver.findElement(txt_title).sendKeys(li.get(0).get(1));
		Thread.sleep(1000);
		driver.findElement(txt_start_date).sendKeys(li.get(2).get(1));
		Thread.sleep(1000);
		driver.findElement(txt_end_date).sendKeys(li.get(3).get(1));
		Thread.sleep(1000);
		driver.findElement(chk_kiosk).click();
		Thread.sleep(3000);
		scroll();
		driver.findElement(btn_submit).click();
		Thread.sleep(1000);		
		driver.findElement(btn_ok).click();
		Select s = new Select(driver.findElement(dwn_kiosk));
		s.selectByIndex(1);
		Thread.sleep(1000);
		driver.findElement(btn_search).click();
		Thread.sleep(1000);
		sorting();
		Thread.sleep(1000);
		scroll();
		Thread.sleep(1000);
		driver.findElement(pagination).click();
		Thread.sleep(1000);
		driver.findElement(export_excel).click();
	}
	
	public void sorting() throws Exception{
		
		Thread.sleep(1000);
		driver.findElement(sort_title).click();
		Thread.sleep(1000);
		driver.findElement(sort_title).click();
		Thread.sleep(1000);
		driver.findElement(sort_start_date).click();
		Thread.sleep(1000);
		driver.findElement(sort_start_date).click();
		Thread.sleep(1000);
		driver.findElement(sort_end_date).click();
		Thread.sleep(1000);
		driver.findElement(sort_end_date).click();
		Thread.sleep(1000);
		
		
		
	}
	
	
	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,450)");
		Thread.sleep(1000);
	}
}
