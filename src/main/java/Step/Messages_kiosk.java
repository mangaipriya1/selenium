package Step;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefinition.Login_Page;

public class Messages_kiosk {

	public  static WebDriver driver;

	By btn_msg = By.id("ContentPlaceHolder1_dldashboard_imgApps_0");
	By lnk_odd = By.className("odd");
	By lnk_reply = By.className("btnRe");
	By txtarea_write_msg = By.name("ctl00$ContentPlaceHolder1$txtEditor");
	By btn_1 = By.xpath(".//span[text()='1']");
	By btn_accept = By.xpath(".//span[text()='Accept']");
	By btn_Send = By.name("ctl00$ContentPlaceHolder1$btnSend"); 
	By btn_Send1 = By.xpath(".//input[@value='Send']");
	By btn_ok = By.id("btnOk");
	By scroll_down = By.className("mCSB_buttonDown");
	public void Messages_kiosk() throws Exception{

		this.driver = new Kiosk_Login().getDriver();	
		Thread.sleep(2500);
		System.out.println("hiii");
		driver.findElement(btn_msg).click();
		Thread.sleep(2500);

		List<WebElement> li = driver.findElements(By.className("odd"));

		Thread.sleep(2500);
		for(int i=0;i<li.size();i++){


			WebDriverWait w1 = new WebDriverWait(driver, 200);
			System.out.println(i);
			System.out.println("size="+li.size());

			li = driver.findElements(By.className("odd"));

			try{
				Thread.sleep(2000);
				
				Thread.sleep(2000);						
				li.get(i).click();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(2000);
				Thread.sleep(2500);
				List<WebElement> list = driver.findElements(By.className("fa-reply"));
				Thread.sleep(2500);
				for(int j=0;j<list.size();j++){
					Thread.sleep(2500);
					list = driver.findElements(By.className("fa-reply"));
					Thread.sleep(2500);
					list.get(j).click();
					Thread.sleep(2500);
					driver.findElement(txtarea_write_msg).click();
					Thread.sleep(2500);
					driver.findElement(btn_1).click();
					Thread.sleep(2500);
					WebElement html = driver.findElement(By.tagName("html"));
					html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
					Thread.sleep(2500);

					driver.findElement(btn_accept).click();
					Thread.sleep(2500);
					WebElement html1 = driver.findElement(By.tagName("html"));
					html1.sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));
					Thread.sleep(2500);
					driver.findElement(btn_Send).click();
					Thread.sleep(2500);
					driver.findElement(btn_ok).click();
					break;
				}
				Thread.sleep(2500);
				//scroll();
				driver.findElement(scroll_down).click();
				Thread.sleep(2500);
				driver.findElement(lnk_odd).click();
				Thread.sleep(2500);
				
				Thread.sleep(2500);
			}catch(Exception e){
				e.printStackTrace();
			}


		}


	}
	/* code for explicit wait*/
	public void webdriverWait(By locator, long sec){
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void scroll(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)", "");
	}

}
