package step_defintion;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Dashboard {

	public WebDriver driver;
	Logger log = Logger.getLogger(Dashboard.class.getName());
	By duplicates = By.xpath("//a[contains(text(),'Duplicates')]");
	By Errors = By.xpath("//a[contains(text(),'Errors :')]");
	By menu_dashboard = By.id("rptUser_menuAnchor_0");
	By dup_export = By.id("ContentPlaceHolder1_imbtnExportToExcel");
	By btn_back = By.id("ContentPlaceHolder1_btnBack");
	
	
	public void Dashboard() throws Exception{
		this.driver = new Login_Staff().getDriver();
		driver.findElement(menu_dashboard).click();
		Thread.sleep(1000);
		scroll();
		Thread.sleep(1000);
		driver.findElement(duplicates).click();
		Thread.sleep(1000);		
		driver.findElement(dup_export).click();
		Thread.sleep(1000);
		driver.findElement(btn_back).click();
		Thread.sleep(1000);
		scroll();
		driver.findElement(Errors).click();
	
		Thread.sleep(1000);		
		driver.findElement(dup_export).click();
		Thread.sleep(1000);
		driver.findElement(btn_back).click();
		Thread.sleep(1000);
		
		
	}
	
	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,450)");
		Thread.sleep(1000);
	}
}
