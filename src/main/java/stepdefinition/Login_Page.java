package stepdefinition;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Page {
	public  static WebDriver driver;

	By txt_username = By.id("txtLoginUserName");
	By txt_password = By.id("txtLoginpassword");
	By btn_login = By.id("btnlogin");
	
	private static Logger log = Logger.getLogger(Login_Page.class.getName());

	public Login_Page()
	{
		this.driver=driver;
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}
	@Given("^Open chrome and start application$")
	public void Navigate_To_Inmate() throws Exception{
		PropertyConfigurator.configure("C:\\Users\\mangaipriya\\selenium\\cucumber_project\\log4j.properties");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mangaipriya\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();	
		
		Thread.sleep(1000);
		driver.get("http://inmatecr01.sgssys.info");
		Thread.sleep(1000);

	}

	@When("^User navigates to login page$")
	public void Navigate_To_Login() throws Exception{
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
		log.info("Windows Maximized successfully");
	}

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void Enter_Login_Data(String username,String password) throws Exception{
		//List<List<String>> data = usercredentials.raw();
		driver.manage().window().maximize();		
		driver.findElement(txt_username).sendKeys(username);
		log.info("Username entered successfully");
		Thread.sleep(1000);		
		driver.findElement(txt_password).sendKeys(password);
		log.info("Password entered successfully");
		Thread.sleep(1000);	
	}

	@Then("^User should login to the application$")
	public void get_Title() throws Exception{
		try{
			System.out.println( driver.getTitle());
			driver.findElement(btn_login).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@And("^Click Find Inmates$")
	public void Navigate_To_Find_Inmate(DataTable findIn) throws Exception{
		Find_Inmates_Page obj = new Find_Inmates_Page();
		obj.Find_Inmates(findIn);

	}
	
	
	@And("^Click Inbox$")
	public void Navigate_To_Inbox(DataTable msg) throws Exception{
		Inbox obj = new Inbox();
		obj.Messages(msg);

	}
	
	@And("^Click Write Message$")
	public void Navigate_To_Write_Msg(DataTable wrtmsg) throws Exception{
		Write_Msg msg = new Write_Msg();
		msg.write_msg(wrtmsg);

	}
	
	@And("^Click Sent Items$")
	public void Navigate_To_Sent_Item() throws Exception{
		Sent_Item_Page snt = new Sent_Item_Page();
		snt.Sent_Messages();

	}
	
	
	@And("^Click Photos$")
	public void Navigate_To_write_photos(DataTable wrtphotos) throws Exception{
		Write_Photos photos = new Write_Photos();
		photos.write_photos(wrtphotos);
	}
	
	@And("^Click My account$")
	public void Navigate_To_Myaccount(DataTable acc) throws Exception{
		My_Account account = new My_Account();
		account.Mycontact(acc);

	}
	
	@And("^Click purchase credit$")
	public void Navigate_To_Purchase_Credit(DataTable credit) throws Exception{
		Purchase_credit pur = new Purchase_credit();
		pur.purchase(credit);

	}
	
	
	 @After
	  public void Screenshot(Scenario scenario) {  
	      if (scenario.isFailed()) {  
	          try {  
	        	  scenario.write("Current Page URL is " + driver.getCurrentUrl());
	              byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); 	             
	              scenario.embed(screenshot, "image/png");         
	             
	          } catch (WebDriverException wde) {  
	              System.err.println(wde.getMessage());  
	          } catch (ClassCastException cce) {  
	              cce.printStackTrace();  
	          }  
	      }
	 }
	 
	
}

	





