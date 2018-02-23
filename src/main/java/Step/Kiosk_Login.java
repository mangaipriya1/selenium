package Step;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import stepdefinition.Find_Inmates_Page;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Kiosk_Login {

	public  static WebDriver driver;
	
	By btn_login = By.id("btnEnter");
	By txt_username = By.name("txtUsername");
	By txt_password = By.name("txtPassword");
	By btn_login_click = By.id("btnLogin");
	By btn_1 = By.xpath(".//span[text()='1']");
	By btn_accept = By.xpath(".//span[text()='Accept']");
	
	private static Logger log = Logger.getLogger(Kiosk_Login.class.getName());

	public Kiosk_Login()
	{
		this.driver=driver;
	}

	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	@Given("^Open IE and start app$")
	public void Navigate_To_Kiosk() throws Exception{
	//	PropertyConfigurator.configure("C:\\Users\\mangaipriya\\selenium\\cucumber_project\\log4j.properties");
		System.setProperty("webdriver.ie.driver", "D:\\Mangai\\Courthouse\\IEDriverServer.exe");	
		driver = new InternetExplorerDriver();	
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		ieCapabilities.setCapability("requireWindowFocus", true);
		

	}
	
	@When("^User navigates to login page1$")
	public void Navigate_To_Login() throws Exception{
		driver.get("http://inmatecr01.sgssys.info/kioskapplogin");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);	
		log.info("Windows Maximized successfully");
	}
	
	@Then("^User should login to the application$")
	public void Enter_Login_Data() throws Exception{
	
		//driver.manage().window().maximize();	
		driver.findElement(btn_login).click();
		log.info("Login entered successfully");
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		driver.findElement(By.name("txtUsername")).click();
		Thread.sleep(1000);
		driver.findElement(btn_1).click();
		Thread.sleep(2000);
		driver.findElement(btn_accept).click();
		Thread.sleep(1000);
		driver.findElement(By.name("txtUsername")).click();
		//Thread.sleep(1000);
		driver.findElement(btn_1).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(btn_accept).click();
		log.info("Username entered successfully");
		Thread.sleep(1000);		
		driver.findElement(txt_password).click();
		Thread.sleep(1000);
		driver.findElement(btn_1).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(btn_accept).click();
		Thread.sleep(2000);
		driver.findElement(txt_password).click();
		Thread.sleep(1000);
		driver.findElement(btn_1).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(btn_accept).click();
		log.info("Password entered successfully");
		Thread.sleep(1000);	
		System.out.println( driver.getTitle());
		driver.findElement(btn_login_click).click();
	}
	

	@And("^Click Messages$")
	public void Messages() throws Exception{
		Messages_kiosk obj = new Messages_kiosk();
		obj.Messages_kiosk();
		
	}
	
}
