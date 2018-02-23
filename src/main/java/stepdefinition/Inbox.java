package stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;

public class Inbox {
	public WebDriver driver;
	By menu_inbox = By.id("achrMenuInbox");
	By lnk_msg = By.xpath("//*[@id='example']/tbody/tr[1]/td[1]");
	//By btn_reply = By.id("ContentPlaceHolder1_gvMessageConversation_btnRe_0");
	By btn_reply1 = By.id("ContentPlaceHolder1_gvMessageConversation_btnRe_8");
	//*[@id="ContentPlaceHolder1_gvMessageConversation_btnRe_0"]/i
	By btn_reply = By.className("fa-reply");
	By txtarea_write_msg = By.id("ContentPlaceHolder1_editor");
	By btn_send = By.id("btnSend");
	By btn_ok = By.id("btnOk");
	By dwn_purchase_limit = By.id("ContentPlaceHolder1_ddlCredits");
	By txt_full_name = By.id("ContentPlaceHolder1_txtFullName");
	By txt_credit_card_digit = By.id("ContentPlaceHolder1_txtCreditCardNumber"); 
	By btn_purchase = By.id("btnSubmit");
	By lnk_sub = By.xpath("//*[@id='example']/tbody/tr[2]/td[1]");
	By row = By.className("listtwoGridCheckMessage");
	By rep = By.className("fa-reply");
	By sort = By.className("even");
	private static Logger log = Logger.getLogger(Sent_Item_Page.class.getName());

	
	public void Messages(DataTable msg) throws Exception{
		try{
			this.driver = new Login_Page().getDriver();	
			List<List<String>>li=msg.raw();
			driver.findElement(menu_inbox).click();	
			log.info("Inbox link clicked successfully");
			Thread.sleep(1000);
			//driver.findElement(lnk_msg).click();	
			//Thread.sleep(1000);	


			List<WebElement> sortcode = driver.findElements(By.className("odd"));
			Thread.sleep(1000);
			//WebDriverWait w1 = new WebDriverWait(driver, 50);
			for(int i=0;i<sortcode.size();i++){
				System.out.println("loop1212");
				WebDriverWait w1 = new WebDriverWait(driver, 200);
				System.out.println(i);
				System.out.println("size="+sortcode.size());
				sortcode = driver.findElements(By.className("odd"));
				try{
					{
						Thread.sleep(2000);						
						sortcode.get(i).click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						Thread.sleep(2000);
					}
					List<WebElement> sortcode1 = driver.findElements(By.className("btnRe"));
					Thread.sleep(1000);
					for(int j=0;j<=sortcode1.size();j++){
						Thread.sleep(2000);
						sortcode1.get(j).click();
						Thread.sleep(1000);
						driver.findElement(txtarea_write_msg).sendKeys(li.get(0).get(1));
						Thread.sleep(2000);
						driver.findElement(btn_send).click();
						log.info("Reply sent successfully");
						Thread.sleep(1000);
						driver.findElement(btn_ok).click();
						break;
					}
					driver.findElement(menu_inbox).click();	
					log.info("Inbox link clicked successfully");
					Thread.sleep(1000);
					int x=0;
					while(x<1){
						Thread.sleep(1000);
						driver.findElement(By.id("example_next")).click();
						x++;
						
					}
					Thread.sleep(2000);
					//driver.navigate().refresh();
					Thread.sleep(1000);
					System.out.println("loop");
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}


			




			/*Thread.sleep(1000);
		Select s1 = new Select(driver.findElement(dwn_purchase_limit));
		s1.selectByValue("10");
		Thread.sleep(1000);
		driver.findElement(txt_full_name).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(txt_credit_card_digit).sendKeys("1234");
		Thread.sleep(1000);
		driver.findElement(btn_purchase).click();*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/* code for explicit wait*/
	public void webdriverWait(By locator, long sec){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}
