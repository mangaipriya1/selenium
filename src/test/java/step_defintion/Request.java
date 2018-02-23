package step_defintion;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefinition.Login_Page;
import cucumber.api.DataTable;

public class Request {

	public static WebDriver driver;
	Logger log = Logger.getLogger(Request.class.getName());

	By menu_request = By.id("rptUser_menuAnchor_1");
	By dwn_type = By.id("ContentPlaceHolder1_ddlRequestTypeSearch");
	By btn_search = By.id("btnSearchRequest");
	By list_form_admin = By.xpath("//a[contains(text(),'Admin')]");
	By list_form_req = By.xpath("//a[contains(text(),'Request')]");
	By list_form_visitor = By.xpath("//a[contains(text(),'Visitor')]");
	By txtarea_investigation = By.id("ContentPlaceHolder1_txtInvestigation");
	By txtarea_review = By.id("ContentPlaceHolder1_txtReviewFindings");
	By txt_signature = By.id("ContentPlaceHolder1_txtSupervisorSignature");
	By txt_title = By.id("ContentPlaceHolder1_txtReviewTitle");
	By btn_submit = By.id("btnSaveRemedyForm");
	By btn_ok = By.id("btnOk");	
	By dwn_status = By.id("ContentPlaceHolder1_ddlRequestStatusSearch");
	By txtarea_description = By.id("ContentPlaceHolder1_txtForumContent");
	By btn_forum_submit = By.id("btnForumSave");
	By btn_back = By.id("ContentPlaceHolder1_btnBackForum");
	By chk_disapprove = By.xpath("//label[contains(text(),'Disapprove')]");
	By btn_Resubmit = By.id("ContentPlaceHolder1_btnResubmit");
	By chk_address = By.id("ContentPlaceHolder1_grvVisitorDetails_chkAddressIncomplete_0");
	By chk_pdf = By.id("ContentPlaceHolder1_rdolstReplyMode_1");
	By chk_both = By.id("ContentPlaceHolder1_rdolstReplyMode_2");
	By choose_file = By.id("ContentPlaceHolder1_fluDocument");
	By btn_form_save = By.id("btnForumPDFSave");
	By txtarea_both = By.id("ContentPlaceHolder1_txtForumBodyBoth");
	By choose_file_both = By.id("ContentPlaceHolder1_fluDocumentBoth");
	By btn_form_submit_both = By.id("btnForumSaveBoth");

	public void request(DataTable reply) throws Exception{

		this.driver = new Login_Staff().getDriver();
		//List<List<String>>li = req.raw();
		driver.findElement(menu_request).click();
		log.info("Request Menu has been clicked");
		Thread.sleep(1000);
		//	driver.findElement(list_form).click();
		System.out.println("Form has been chosen");

		char form ='C';
		switch(form){
		case 'A':				
			Admin_Remedy_Form();
			break;
		case 'B':
			Request_Form(reply);
			break;
		case 'C':	
			Visitor_Form(reply);
			break;
		}
	}
	public void Admin_Remedy_Form() throws Exception{
		Select s1 = new Select(driver.findElement(dwn_type));
		s1.selectByValue("2");
		Thread.sleep(1000);
		driver.findElement(btn_search).click();
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(list_form_admin);
		Thread.sleep(1000);
		for(int i=0;i<=2;i++){
			Thread.sleep(3000);
			list = driver.findElements(list_form_admin);
			System.out.println("size = "+ list.size());
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(list_form_admin));			
			list.get(0).click();
			Thread.sleep(1000);
			driver.findElement(txtarea_investigation).sendKeys("test");
			Thread.sleep(1000);
			driver.findElement(txtarea_review).sendKeys("sample");
			Thread.sleep(1000);
			driver.findElement(txt_signature).sendKeys("testsignature");
			Thread.sleep(1000);
			driver.findElement(txt_title).sendKeys("test title");
			Thread.sleep(1000);
			driver.findElement(btn_submit).click();
			Thread.sleep(1000);
			driver.findElement(btn_ok).click();
		}
	}

	public void Request_Form(DataTable reply) throws Exception{
		Select s1 = new Select(driver.findElement(dwn_type));
		s1.selectByValue("10");
		Thread.sleep(1000);
		Select s2 = new Select(driver.findElement(dwn_status));
		s2.selectByValue("1");
		Thread.sleep(1000);
		driver.findElement(btn_search).click();
		Thread.sleep(1000);
		By_Text(reply);

	}

	public void Visitor_Form(DataTable reply) throws Exception{
		Select s1 = new Select(driver.findElement(dwn_type));
		s1.selectByValue("1");
		Thread.sleep(1000);
		Select s2 = new Select(driver.findElement(dwn_status));
		s2.selectByValue("1");
		Thread.sleep(1000);
		driver.findElement(btn_search).click();
		Thread.sleep(1000);
		driver.findElement(list_form_visitor).click();	
		Thread.sleep(1000);
		//List<WebElement> list1 = driver.findElements(chk_disapprove);
		//for(int i=0;i<=list1.size();i++){
		Thread.sleep(1000);
		driver.findElement(chk_disapprove).click();
		Thread.sleep(1000);
		//list1.get(i).click();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		scroll1();
		wait.until(ExpectedConditions.elementToBeClickable(chk_address));	
		driver.findElement(chk_address).click();
		Thread.sleep(1000);
		scroll();			
		driver.findElement(btn_Resubmit).click();
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();	
		
	}

	/* code for scroll*/
	private void scroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,950)");
		Thread.sleep(1000);
	}

	private void scroll1() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,150)");
		Thread.sleep(1000);
	}


	public void By_Text(DataTable reply) throws Exception {
		//	this.driver = new Login_Page().getDriver();	
		List<List<String>>li=reply.raw();
		System.out.println("sssss");
		Thread.sleep(1000);
		List<WebElement> list = driver.findElements(By.xpath("//a[contains(text(),'Request')]"));
		Thread.sleep(1000);
		for(int i=0;i<=list.size();i++){
			Thread.sleep(1000);			
			list = driver.findElements(By.xpath("//a[contains(text(),'Request Form 8')]"));
			Thread.sleep(1500);
			list.get(i).click();
			Thread.sleep(1000);
			driver.findElement(txtarea_description).sendKeys(li.get(0).get(1));			
			Thread.sleep(1000);
			driver.findElement(btn_forum_submit).click();
			Thread.sleep(1000);
			driver.findElement(btn_ok).click();
			Thread.sleep(1000);
			//driver.findElement(btn_back).click();
			By_pdf(reply);
			System.out.println("size:"+list.size());
		}

	}

	public void By_pdf(DataTable reply) throws Exception{		
		/*Thread.sleep(1000);
		List<WebElement> li = driver.findElements(By.xpath("//a[contains(text(),'Request')]"));
		Thread.sleep(1000);
		for(int i=0;i<=li.size();i++){
			Thread.sleep(1000);
			li = driver.findElements(By.xpath("//a[contains(text(),'Request Form 8')]"));
			Thread.sleep(1000);
			li.get(i).click();*/
		Thread.sleep(1000);
		System.out.println("hii");
		driver.findElement(chk_pdf).click();
		log.info("Pdf checkbox has chosen");
		Thread.sleep(1000);
		driver.findElement(choose_file).sendKeys("C:\\Users\\mangaipriya\\Desktop\\pdf123.pdf");
		log.info("file path has chosen");
		Thread.sleep(1000);
		driver.findElement(btn_form_save).click();
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();
		Thread.sleep(1000);
		//driver.findElement(btn_back).click();
		By_both(reply);
	}



	public void By_both(DataTable reply) throws Exception{		
		/*Thread.sleep(1000);

		System.out.println("hjhjhj");
		Thread.sleep(1000);
		List<WebElement> li = driver.findElements(By.xpath("//a[contains(text(),'Request')]"));
		Thread.sleep(1000);
		for(int i=0;i<=li.size()-1;i++){
			Thread.sleep(1000);
			li = driver.findElements(By.xpath("//a[contains(text(),'Request Form 8')]"));
			Thread.sleep(1000);
			li.get(i).click();*/
		System.out.println("both");
		List<List<String>>list=reply.raw();
		Thread.sleep(1000);
		System.out.println("nbnbnbnb");
		driver.findElement(chk_both).click();
		Thread.sleep(1000);
		driver.findElement(txtarea_both).sendKeys(list.get(0).get(1));			
		log.info("Pdf checkbox has chosen");
		Thread.sleep(1000);
		driver.findElement(choose_file_both).sendKeys("C:\\Users\\mangaipriya\\Desktop\\pdf123.pdf");
		log.info("file path has chosen");
		Thread.sleep(1000);
		driver.findElement(btn_form_submit_both).click();
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();
		Thread.sleep(1000);
		driver.findElement(btn_back).click();
	}

	

}



