package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class Write_Msg {

	public WebDriver driver;
	By lnk_wrt_msg = By.id("achrWtiteMsg");
	By lnk_msg = By.id("ContentPlaceHolder1_defaultOpen");
	By lnk_photo = By.id("ContentPlaceHolder1_photosInfo");
	By dwn_select_inmate = By.id("ddlInmate");
	By txt_subject = By.id("ContentPlaceHolder1_txtTitle");
	By txtarea_wrt_ur_msg = By.id("ContentPlaceHolder1_editor");
	By btn_send = By.id("btnSend");
	By btn_cancel = By.id("ContentPlaceHolder1_btnCancel");
	By btn_ok = By.id("btnOk");
	
	By dwn_purchase_limit = By.id("ContentPlaceHolder1_ddlCredits");
	By txt_full_name = By.id("ContentPlaceHolder1_txtFullName");
	By txt_credit_card_digit = By.id("ContentPlaceHolder1_txtCreditCardNumber");
	By btn_purchase = By.id("btnSubmit");
	
	By btn_proceed = By.id("btnStepTwoProceed");
	
	public void write_msg(DataTable wrtmsg){
		try{
			this.driver = new Login_Page().getDriver();
			List<List<String>>li = wrtmsg.raw();
			Thread.sleep(1000);
			driver.findElement(lnk_wrt_msg).click();
			Thread.sleep(1000);
			driver.findElement(lnk_msg).click();
			Thread.sleep(1000);
			driver.findElement(btn_send).click();
			
			Thread.sleep(1000);		
			Select s = new Select(driver.findElement(dwn_select_inmate));
			s.selectByValue(li.get(0).get(1));
			Thread.sleep(1000);
			driver.findElement(btn_send).click();
			Thread.sleep(1000);
			driver.findElement(txt_subject).sendKeys(li.get(1).get(1));
			Thread.sleep(1000);
			driver.findElement(btn_send).click();
			Thread.sleep(1000);
			driver.findElement(btn_ok).click();
			Thread.sleep(1000);
			driver.findElement(txtarea_wrt_ur_msg).sendKeys(li.get(2).get(1));
			Thread.sleep(1000);
			driver.findElement(btn_send).click();
			Thread.sleep(1000);
			driver.findElement(btn_ok).click();
			Thread.sleep(1000);
			/*Select s1 = new Select(driver.findElement(dwn_purchase_limit));
			s1.selectByValue(li.get(3).get(1));
			Thread.sleep(1000);
			driver.findElement(btn_proceed).click();*/
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
			
}
