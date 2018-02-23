package stepdefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;

public class Sent_Item_Page {

	
	public WebDriver driver;
	By lnk_sent_item = By.id("achrSentItems");
	By lnk_sent_msg = By.id("ContentPlaceHolder1_liMessageOpen");
	By lnk_sent_photo = By.id("ContentPlaceHolder1_liPhotoOpen");
	By view_msg = By.xpath("//*[@id='example']/tbody/tr[1]/td[1]");
	By view_photo = By.xpath("//*[@id='example1']/tbody/tr[1]/td[1]");
	By btn_msg_back = By.id("ContentPlaceHolder1_btnMessageBack");
	By btn_photo_back = By.id("ContentPlaceHolder1_btnPhotoBack");
	private static Logger log = Logger.getLogger(Sent_Item_Page.class.getName());
	
	public void Sent_Messages() throws Exception{
		this.driver = new Login_Page().getDriver();	
		driver.findElement(lnk_sent_item).click();	
		
		Thread.sleep(1000);
		driver.findElement(lnk_sent_msg).click();	
		log.info("Sent Message has been clicked");
		Thread.sleep(1000);
		driver.findElement(view_msg).click();
		log.info("View Message has been clicked");
		Thread.sleep(1000);
		driver.findElement(btn_msg_back).click();
		Thread.sleep(1000);
		driver.findElement(lnk_sent_photo).click();
		Thread.sleep(1000);
		driver.findElement(view_photo).click();
		log.info("View photo has been clicked");
		Thread.sleep(1000);
		driver.findElement(btn_photo_back).click();
		
	}
}
