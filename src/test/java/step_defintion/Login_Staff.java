package step_defintion;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import stepdefinition.Find_Inmates_Page;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Staff {

	public static WebDriver driver;
	By txtusername = By.id("txtUsername");
	By txtpassword = By.id("txtPassword");
	By btn_login = By.id("btnLogin");

	private static Logger log = Logger.getLogger(Login_Staff.class.getName());

	public Login_Staff(){
		this.driver = driver;		
	}

	public WebDriver getDriver(){
		return this.driver;		
	}

	@Given("^Open chrome and start application$")
	public void Navigate_To_Inmate() throws Exception{
		PropertyConfigurator.configure("C:\\Users\\mangaipriya\\selenium\\cucumber_project\\log4j.properties");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mangaipriya\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();	
		Thread.sleep(1000);
		driver.get("http://inmatecr01.sgssys.info/facilityuser");
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
		driver.findElement(txtusername).sendKeys(username);
		log.info("Username entered successfully");
		Thread.sleep(1000);		
		driver.findElement(txtpassword).sendKeys(password);
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

	@And("^Click Request$")
	public void Request(DataTable reply) throws Exception{		
		Request obj = new Request();
		obj.request(reply);
	}

	@And("^click Initiate Message$")
	public void Initiate_Msg(DataTable reply) throws Exception{		
		Initiate_Msg obj = new Initiate_Msg();
		obj.Create_New_Msg(reply);
	}

	@And("^Click Messages$")
	public void Msg(DataTable msg) throws Exception{		
		Messages obj = new Messages();
		obj.messages(msg);
	}

	@And("^Click Photos$")
	public void Photos(DataTable photos) throws Exception{	
		Photos obj = new Photos();
		obj.photos(photos);
	}

	@And("^Click Notices$")
	public void Notice(DataTable not) throws Exception{		
		Notice obj = new Notice();
		obj.notice(not);
	}

	
	@And("^Click Dashboard$")
	public void Dashboard() throws Exception{		
		Dashboard obj = new Dashboard();
		obj.Dashboard();
	}
}
