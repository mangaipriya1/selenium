package step_defintion;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;

public class Messages {

	public WebDriver driver;
	Logger log = Logger.getLogger(Messages.class.getName());

	By menu_messages = By.xpath("//a[contains(text(),'Messages')]");
	By dwn_inmate_last_name = By.xpath("//*[@id='ddlInmateLastNameSearch_chosen']/a/span");
	By last_name_txt = By.xpath("//*[@id='ddlInmateLastNameSearch_chosen']/div/div/input");
	By dwn_inmate_first_name = By.xpath("//div[@id='ddlInmateFirstNameSearch_chosen']/a/span");
	By first_name_txt = By.xpath("//div[@id='ddlInmateFirstNameSearch_chosen']/div/div/input");
	By dwn_pu_last_name = By.xpath("//*[@id='ddlPublicUserLastNameSearch_chosen']/a/span");
	By last_pu_name = By.xpath("//*[@id='ddlPublicUserLastNameSearch_chosen']/div/div/input");
	By dwn_pu_first_name = By.xpath("//*[@id='ddlPublicUserFirstNameSearch_chosen']/a/span");
	By first_pu_name = By.xpath("//*[@id='ddlPublicUserFirstNameSearch_chosen']/div/div/input");
	By lst_subject = By.id("lblMessageSubject");
	By dwn_flag = By.xpath("//*[@id='ContentPlaceHolder1_ddlMessageFlag']");
	By btn_search = By.id("btnSearch");
	By btn_back = By.id("ContentPlaceHolder1_btnBack");
	By btn_quarantine_msg = By.id("btnApproveQuarantineMessage");
	By btn_yes = By.id("btnYes");
	By btn_ok= By.id("btnOk");

	public void messages(DataTable msg) throws Exception{		
		List<List<String>>li = msg.raw();
		this.driver = new Login_Staff().getDriver();		
		driver.findElement(menu_messages).click();
		Thread.sleep(1000);
		driver.findElement(dwn_inmate_last_name).click();
		Thread.sleep(1000);
		driver.findElement(last_name_txt).sendKeys("john");
		Thread.sleep(1000);
		driver.findElement(last_name_txt).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(dwn_inmate_first_name).click();
		Thread.sleep(1000);
		driver.findElement(first_name_txt).sendKeys("peter");
		Thread.sleep(1000);
		driver.findElement(first_name_txt).sendKeys(Keys.ENTER);
		Thread.sleep(1000);		
		driver.findElement(dwn_pu_last_name).click();
		Thread.sleep(1000);
		driver.findElement(last_pu_name).sendKeys("priya");
		Thread.sleep(1000);
		driver.findElement(last_pu_name).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(dwn_pu_first_name).click();
		Thread.sleep(1000);
		driver.findElement(first_pu_name).sendKeys("mangai");
		Thread.sleep(1000);
		driver.findElement(first_pu_name).sendKeys(Keys.ENTER);

		char flag = 'B';

		switch (flag) {
		case 'A':
			noflag(msg);
			break;
		case 'B':
			flag(msg);
			break;
		case 'C':
			quarantine(msg);
		default:
			break;
		}

	}

	public void noflag(DataTable flag) throws Exception{
		List<List<String>> li = flag.raw();
		webdriverwait(dwn_flag, 50);
		Thread.sleep(1000);
		Select noflag = new Select(driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlMessageFlag']")));		
		Thread.sleep(1000);
		noflag.selectByValue(li.get(0).get(1));		
		webdriverwait(btn_search, 50);
		driver.findElement(btn_search).click();
		webdriverwait(btn_search, 90);
		/*List<WebElement> lis = driver.findElements(lst_subject);
		for(int i=0;i<=lis.size();i++){
			Thread.sleep(1000);
			lis = driver.findElements(lst_subject);
			System.out.println("size"+lis.size());
			Thread.sleep(1000);
			scroll();
			Thread.sleep(2000);
			lis.get(i).click();
			driver.findElement(btn_back).click();
		}*/
		Thread.sleep(1000);
		driver.findElement(lst_subject).click();
		Thread.sleep(2000);
		driver.findElement(btn_back).click();
	}

	public void flag(DataTable flag) throws Exception{
		List<List<String>> li = flag.raw();
		webdriverwait(dwn_flag, 50);
		Select noflag = new Select(driver.findElement(dwn_flag));
		noflag.selectByValue(li.get(1).get(1));
		webdriverwait(btn_search, 50);
		driver.findElement(btn_search).click();
		/*List<WebElement> lis = driver.findElements(lst_subject);
		for(int i=0;i<=lis.size();i++){
			Thread.sleep(1000);
			lis = driver.findElements(lst_subject);
			System.out.println("size"+lis.size());
			Thread.sleep(1000);
			scroll();
			Thread.sleep(2000);
			lis.get(i).click();
			driver.findElement(btn_back).click();
		}*/
		Thread.sleep(1000);
		driver.findElement(lst_subject).click();
		Thread.sleep(2000);
		driver.findElement(btn_back).click();
	}

	public void quarantine(DataTable flag) throws Exception{
		List<List<String>> li = flag.raw();
		webdriverwait(dwn_flag, 50);
		Thread.sleep(1000);
		Select noflag = new Select(driver.findElement(dwn_flag));
		Thread.sleep(1000);
		noflag.selectByValue(li.get(2).get(1));
		Thread.sleep(1000);
		webdriverwait(btn_search, 50);
		driver.findElement(btn_search).click();
		/*List<WebElement> lis = driver.findElements(lst_subject);
		for(int i=0;i<=lis.size();i++){
			Thread.sleep(1000);
			lis = driver.findElements(lst_subject);
			System.out.println("size"+lis.size());
			Thread.sleep(1000);
			scroll();
			Thread.sleep(2000);
			lis.get(i).click();
			driver.findElement(btn_back).click();
		}*/	
		Thread.sleep(1000);
		driver.findElement(lst_subject).click();
		Thread.sleep(2000);
		driver.findElement(btn_quarantine_msg).click();
		Thread.sleep(2000);
		driver.findElement(btn_yes).click();
		Thread.sleep(2000);
		driver.findElement(btn_ok).click();
		Thread.sleep(2000);
		driver.findElement(btn_back).click();
		}

	public void webdriverwait(By locator, long seconds){
		WebDriverWait wait =  new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,950)");
		Thread.sleep(1000);
	}

}
