package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class Write_Photos {
	
	public WebDriver driver;
	By menu_write_msg = By.xpath("//i[@class='fa fa-pencil']");//*[@id="achrWtiteMsg"]
	By menu_photos = By.id("ContentPlaceHolder1_photosInfo");
	By dwn_select_inmate = By.id("ddlInmate");
	By txt_subject = By.id("ContentPlaceHolder1_txtTitle");
	By btn_choose_file = By.id("fluDocument");
	By btn_upload = By.id("ContentPlaceHolder1_btnUpload");
	By btn_Send = By.id("btnSend");
	By btn_ok = By.id("btnOk");
	
	public void write_photos(DataTable wrt_photos) throws Exception{
		this.driver = new Login_Page().getDriver();
		List<List<String>>li = wrt_photos.raw();
		Thread.sleep(1000);
		driver.findElement(menu_write_msg).click();
		Thread.sleep(1000);
		driver.findElement(menu_photos).click();
		Thread.sleep(1000);
		Select s = new Select(driver.findElement(dwn_select_inmate));
		s.selectByValue(li.get(0).get(1));
		Thread.sleep(1000);
		driver.findElement(txt_subject).sendKeys(li.get(1).get(1));
		Thread.sleep(1000);
		driver.findElement(btn_choose_file).sendKeys(li.get(2).get(1));
		Thread.sleep(1000);
		driver.findElement(btn_upload).sendKeys(li.get(2).get(1));
		Thread.sleep(1000);
		driver.findElement(btn_Send).sendKeys(li.get(2).get(1));
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();
		
	}

}
