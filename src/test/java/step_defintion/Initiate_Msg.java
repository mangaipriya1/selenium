package step_defintion;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import cucumber.api.DataTable;

public class Initiate_Msg {

	public WebDriver driver;
	Logger log = Logger.getLogger(Initiate_Msg.class.getName());

	By menu_request = By.id("rptUser_menuAnchor_1");
	By btn_Initiate_Msg = By.id("btnRaiseMyQuery");
	By dwn_type = By.id("ContentPlaceHolder1_ddlRequestType");
	By dwn_status = By.id("ContentPlaceHolder1_ddlRequestStatusSearch");
	By btn_search = By.id("btnSearchRequest");
	By btn_create_new = By.id("btnCreateNew");
	By btn_msg_type = By.id("ContentPlaceHolder1_ddlRequestType");
	By dwn_choose_inmate = By.id("ContentPlaceHolder1_ddlSingleInmates");
	By radio_by_text = By.id("ContentPlaceHolder1_rdolstReplyMode_0");
	By radio_by_pdf = By.id("ContentPlaceHolder1_rdolstReplyMode_1");
	By radio_by_both = By.id("ContentPlaceHolder1_rdolstReplyMode_2");
	By chk_closed = By.id("ContentPlaceHolder1_chkClosedStatus");
	By btn_form_save = By.id("btnForumSave");
	By textarea_desc = By.id("ContentPlaceHolder1_txtForumContent");
	By list_form = By.className("listoneGrid");
	By btn_ok = By.id("btnOk");
	By btn_choose_file_pdf = By.id("ContentPlaceHolder1_fluDocument");
	By radio_Initiate_to_multi = By.id("ContentPlaceHolder1_rdolstSelectTypeOfConvo_1");
	By multi_inmate1 = By.id("ContentPlaceHolder1_cblstMultiInmate_2");
	By multi_inmate2 = By.id("ContentPlaceHolder1_cblstMultiInmate_5");
	By dwn_type_search = By.id("ContentPlaceHolder1_ddlRequestTypeSearch");		
	By list_form_admin = By.xpath("//a[contains(text(),'Message To Inmate 2')]");
	By txtarea_reply = By.id("ContentPlaceHolder1_txtForumContentComment");
	By chk_closed_editreply = By.id("ContentPlaceHolder1_chkClosedComment");
	By btn_pst_comments = By.id("ContentPlaceHolder1_btnReplyPostComment");
	By radio_reply_pdf = By.id("ContentPlaceHolder1_rdolstForumReplyMode_1");
	By choose_file_reply_pdf = By.id("ContentPlaceHolder1_fluForumUpload");	
	By radio_reply_both = By.id("ContentPlaceHolder1_rdolstForumReplyMode_2");
	By btn_back = By.id("ContentPlaceHolder1_btnBackForum");

	public void Create_New_Msg(DataTable reply) throws Exception{

		List<List<String>>li=reply.raw();
		this.driver = new Login_Staff().getDriver();
		Thread.sleep(1000);
		driver.findElement(menu_request).click();
		Thread.sleep(1000);
		driver.findElement(btn_Initiate_Msg).click();
		Thread.sleep(1000);
		driver.findElement(btn_create_new).click();
		Thread.sleep(1000);

		List<WebElement> list = driver.findElements(By.name("ctl00$ContentPlaceHolder1$rdolstSelectTypeOfConvo"));
		boolean bvalue =false;
		Thread.sleep(1000);
		bvalue = list.get(0).isSelected();

		if(bvalue==false){
			list.get(1).click();
			Initiate_multi();			
		}else
		{
			list.get(0).click();
			Initiate_single(reply);			
		}
		Select s1 = new Select(driver.findElement(dwn_type));
		s1.selectByValue(li.get(0).get(1));

		char reply_mode ='A';
		switch(reply_mode)
		{
		case 'A':
			By_Text(reply);
			break;
		case 'B':
			By_pdf(reply);
			break;
		case 'C':
			By_both(reply);
			break;
		}

		//driver.findElement(chk_closed).click();
		Thread.sleep(1000);
		driver.findElement(btn_form_save).click();			
		Thread.sleep(1000);
		driver.findElement(btn_ok).click();	
		Search_form(reply);

	}

	public void By_Text(DataTable reply) throws Exception{
		Thread.sleep(1000);
		List<List<String>>li=reply.raw();
		driver.findElement(textarea_desc).sendKeys(li.get(2).get(1));
		Thread.sleep(1000);

	}

	public void By_pdf(DataTable reply) throws Exception{
		List<List<String>>li=reply.raw();
		driver.findElement(radio_by_pdf).click();
		Thread.sleep(1000);
		driver.findElement(btn_choose_file_pdf).sendKeys(li.get(3).get(1));

	}

	public void By_both(DataTable reply) throws Exception{
		List<List<String>>li=reply.raw();
		driver.findElement(radio_by_both).click();
		Thread.sleep(1000);
		driver.findElement(textarea_desc).sendKeys(li.get(2).get(1));
		Thread.sleep(1000);
		driver.findElement(btn_choose_file_pdf).sendKeys(li.get(3).get(1));
	}

	public void Initiate_multi() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(multi_inmate1).click();
		Thread.sleep(1000);
		driver.findElement(multi_inmate2).click();
	}

	public void Initiate_single(DataTable reply) throws InterruptedException{
		List<List<String>>li=reply.raw();
		Thread.sleep(1000);
		Select s2 = new Select(driver.findElement(dwn_choose_inmate));
		s2.selectByValue(li.get(1).get(1));
	}

	public void Search_form(DataTable reply) throws Exception{
		try {
			List<List<String>>li = reply.raw();
			Select select_type = new Select(driver.findElement(dwn_type_search));
			select_type.selectByValue(li.get(4).get(1));
			Thread.sleep(1000);
			Select select_status = new Select(driver.findElement(dwn_status));
			select_status.selectByValue(li.get(5).get(1));
			Thread.sleep(1000);
			driver.findElement(btn_search).click();
			Thread.sleep(1000);
			List<WebElement> list_form = driver.findElements(list_form_admin);

			//List<WebElement> element = driver.findElements(By.id("ctl00$ContentPlaceHolder1$rdolstForumReplyMode"));
			for(int i=0;i<list_form.size();i++){
				Thread.sleep(1000);

				list_form = driver.findElements(list_form_admin);
				Thread.sleep(1000);
				list_form.get(i).click();
				System.out.println(list_form.size());
				char value = 'A';
				//Text(reply);
				//pdf(reply);
				//both(reply);
				switch (value) {
				case 'A':
					Text(reply);
					//break;
				case 'B':
					pdf(reply);
					//break;
				case 'C':
					both(reply);
					//break;
				default:
					break;
				}

			}
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void Text(DataTable reply) throws Exception{
		try{
			List<List<String>>li= reply.raw();
			//	WebElement text = driver.findElement(By.name("ctl00$ContentPlaceHolder1$rdolstForumReplyMode"));
			List<WebElement> textcount = driver.findElements(By.name("ctl00$ContentPlaceHolder1$rdolstForumReplyMode"));
			int a=textcount.size();
			System.out.println(textcount.size());
			for(int i=0;i<a;i++){
				//textcount = driver.findElements(By.name("ctl00$ContentPlaceHolder1$rdolstForumReplyMode"));
				Thread.sleep(1000);
				textcount.get(0).click();
				Thread.sleep(1000);
				driver.findElement(txtarea_reply).sendKeys(li.get(2).get(1));
				Thread.sleep(1000);
				driver.findElement(btn_pst_comments).click();
				Thread.sleep(1000);		
				driver.findElement(btn_ok).click();
				Thread.sleep(1000);	
			}}catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}



	}

	//driver.findElement(btn_back).click();
	//}

	public void pdf(DataTable reply) throws Exception{
		try{
			List<List<String>>li= reply.raw();
			List<WebElement> textcount = driver.findElements(By.name("ctl00$ContentPlaceHolder1$rdolstForumReplyMode"));
			int a=textcount.size();
			for(int i=0;i<a;i++){
				Thread.sleep(1000);
				textcount.get(1).click();
				Thread.sleep(1000);
				driver.findElement(radio_reply_pdf).click();
				Thread.sleep(1000);
				driver.findElement(choose_file_reply_pdf).sendKeys(li.get(3).get(1));
				Thread.sleep(1000);
				driver.findElement(btn_pst_comments).click();
				Thread.sleep(1000);	
				driver.findElement(btn_ok).click();
				Thread.sleep(1000);	

				//driver.findElement(btn_back).click();
			}

		}catch(StaleElementReferenceException e){
			e.printStackTrace();
		}
	}

	public void both(DataTable reply) throws Exception{
		try{
			List<List<String>>li= reply.raw();
			List<WebElement> textcount = driver.findElements(By.name("ctl00$ContentPlaceHolder1$rdolstForumReplyMode"));
			int a=textcount.size();
			for(int i=0;i<a;i++){
				Thread.sleep(1000);
				textcount.get(2).click();
				Thread.sleep(1000);
				driver.findElement(radio_reply_both).click();
				Thread.sleep(1000);
				driver.findElement(choose_file_reply_pdf).sendKeys(li.get(3).get(1));
				Thread.sleep(1000);
				driver.findElement(txtarea_reply).sendKeys(li.get(2).get(1));
				Thread.sleep(1000);		
				driver.findElement(btn_pst_comments).click();
				Thread.sleep(1000);	
				driver.findElement(btn_ok).click();
				Thread.sleep(1000);	
				//driver.findElement(btn_back).click();
				//driver.navigate().refresh();
				Thread.sleep(1000);
				driver.findElement(btn_back).click();}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}


