package pv_admin;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listener.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class PV_Login {
	WebDriver driver;
	
	@BeforeClass
	public void setDriver(ITestContext context) throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\neha.p\\AppData\\Local\\Temp\\geckodriver.exe");
		//driver=new FirefoxDriver();	
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		Thread.sleep(1000);
		context.setAttribute("WebDriver", driver);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@BeforeMethod
	public void Openurl() throws InterruptedException 
	{
		driver.get(admin_page_repository.url_admin);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	@Test(priority = 0 , description="To verify that user is able to get \"Login\" page by clicking on \"Login\" button from Home page.")
	public void PV_Login_01() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Step-1</b> : Click on \"Login\" button from \"Home\" page."));
		String l1=driver.findElement(By.xpath(Login_repository.lbl_Username)).getText();
		Assert.assertEquals(l1, "User name or email address");
		Thread.sleep(1000);
		String l2=driver.findElement(By.xpath(Login_repository.lbl_Password)).getText();
		Assert.assertEquals(l2, "Password");
		Thread.sleep(1000);
		boolean b1=driver.findElement(By.xpath(Login_repository.txtbox_Username)).isDisplayed();
		Assert.assertEquals(b1, true);
		Thread.sleep(1000);
		boolean b2=driver.findElement(By.xpath(Login_repository.txtbox_Password)).isDisplayed();
		Assert.assertEquals(b2, true);
		Thread.sleep(1000);
		boolean b4=driver.findElement(By.xpath(Login_repository.lnk_ForgotPassword)).isDisplayed();
		Assert.assertEquals(b4, true);
		Thread.sleep(1000);
		boolean b5=driver.findElement(By.xpath(Login_repository.btn_Login1)).isDisplayed();
		Assert.assertEquals(b5, true);
		Thread.sleep(1000);
		boolean b6=driver.findElement(By.xpath(Login_repository.lnk_Register)).isDisplayed();
		Assert.assertEquals(b6, true);
		Thread.sleep(1000);
		boolean b3=driver.findElement(By.xpath(Login_repository.chbox_rememberme)).isDisplayed();
	    Assert.assertEquals(b3, true);
	    ExtentTestManager.getTest().log(Status.INFO,   String.format("<b>Result</b> : User should get \"Login\" page with following:,<br/> 1. Textboxes: \"User name or email address\" \"Password,<br/> 2. Buttons: \"Login\", \"Cancel\",</br> 3. Links: \"Forgot Password?\", \"Register\", </br> 4. \"Remember me\" checkbox. "));
		
	}
	
	@Test(priority = 8 , description="To verify that user is able to \"Login\" in Police Vertical web portal with \"Remember me\" checkbox selection.")
	public void PV_Login_02() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		WebElement e1=driver.findElement(By.xpath(Login_repository.btn_Login));
		e1.click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Admin");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Enter valid \"Username\" or \"Email address\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("1q2w3E*");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter valid \"Password\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.chbox_rememberme)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Check-on \"Remember me\" check-box.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		String e2= driver.findElement(By.xpath("//li[@class='breadcrumb-item active']")).getText();
		Assert.assertEquals(e2, "Home");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.hamburgermenu)).isDisplayed(), true);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.logo_leftpane)).isDisplayed(), true);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_home)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_map)).isDisplayed(), true);
		Thread.sleep(1000);
		
		//Dashboard icon and label verify
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_dashboard)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_saas)).isDisplayed(), true);
		Thread.sleep(1000);

		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_CMS)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_administration)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_resourcetype)).isDisplayed(), true);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_FIRs)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_FileManagement)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_forms)).isDisplayed(), true);
		Thread.sleep(1000);
	
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_LayerManagement)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_UserManagement)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_masters)).isDisplayed(), true);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_crimemapping)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_patrollings)).isDisplayed(), true);
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.findElement(By.xpath(admin_page_repository.opt_DatabaseConfing)).isDisplayed(), true);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Admin\" department Home page with following :</br>1. In header panel: \r\n"
				+ "-> Link: \"English\",  Login status of \"admin\".\r\n"
				+ "-> Maximize icon.</br> 2. Left Pane: \r\n"
				+ "-> \"Logo\" , \"Hamburger menu\".</br>"
				+ "-> Menu Buttons: \"Home\" , \"Map\", \"Areas\", \"Dashboard\", \"Designations\", \"Crime Types\", \"Police Vertical Settings\", \"File Management\", \"Forms\", \"Landmark Configurator\", \"Office\" , \"Named Query\", \"Bookmarks\".</br>"
				+ "-> Dropdown Menu: \"Saas\", \"Layer Management\" ,\"CMS\" , \"Administration, \"Database Configurator.</br> 3. Home Page link."));
	}
	
	@Test(priority = 1,description="To verify that user is able to perform \"Forgot password?\" functionality of \"Login\" page.")
	public void PV_Login_04() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		
		driver.findElement(By.xpath(Login_repository.lnk_ForgotPassword)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Forgot password?\" link from \"Login\" page.");
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(Login_repository.lbl_Email)).getText();
		Assert.assertEquals(t1, "Email");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Forgot Password?\" window with following : </br>1. \"Email\" text-box.</br> 2. \"Submit\" button.</br> 3. \"<-Login\" link."));
	}
	
	@Test(priority = 2,description="To verify that user is able to perform \" Register\" functionality of \"Login\" page.")
	public void PV_Login_05() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(Login_repository.lbl_FirstName_Register)).getText();
		Assert.assertEquals(t1, "First Name *");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Register\" page with following :</br>1. Text-boxes :</br>\r\n"
				+ "-> Mandatory: \"Username\" , \"Email Address\", \"First Name\" , \"Last Name\", \"Password\", \"Confirm Password\", \"Date of Birth\" , \"Address Line 1\" , \"Pin Code\" , \"Phone Number\" .</br>\r\n"
				+ "-> Optional : \"Middle Name\" ,\"Address Line 2\" .</br>2. Dropdowns : </br>\r\n"
				+ "-> Mandatory: \"Country \", \"State\", \"District/City \" , \"Country Code\"(Pre-selected).</br>-> Optional: \"Taluka\" , \"Village\". </br>3. Radio buttons for \"Gender\" selection: \r\n"
				+ "\"Male\" , \"Female\", \"Other\".</br>4. Button : \"Next\".</br>5. Link : \"Login\"."));
		Thread.sleep(1000);
	}
	
	@Test(priority = 3,description="To verify that user is not able to \"Login\" in Police Vertical web portal with blank credential.")
	public void PV_Login_06() throws InterruptedException 
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Login\" button without entering mandatory fields details.");
		String t1=driver.findElement(By.xpath(Login_repository.username_validation)).getText();
		Assert.assertEquals(t1, "The User name or email address field is required.");
		Thread.sleep(1000);
		String t2=driver.findElement(By.xpath(Login_repository.password_validation)).getText();
		Assert.assertEquals(t2, "The Password field is required.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like :\r\n"
				+ "\"The User name or email address field is required.\" and \r\n"
				+ "\"The Password field is required.\" below their respective fields."));
	}
	
	@Test(priority = 4,description="To verify that user is not able to \"Login\"  in Police Vertical web portal with invalid username and valid password.")
	public void PV_Login_07() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Enter invalid \"Username\" or \"Email address\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("1q2w3E*");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter valid \"Password\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Click on \"Login\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.validation_of_Invalid)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like : \r\n"
				+ "\"Invalid username or password!  \""));
		Thread.sleep(1000);
		
	}
	
	@Test(priority = 5,description="To verify that user is not able to \"Login\"  in Police Vertical web portal with valid username and invalid password.")
	public void PV_Login_08() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Admin");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Enter valid \"Username\" or \"Email address\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("Abc@123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter invalid \"Password\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Click on \"Login\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.validation_of_Invalid)).isDisplayed(), true);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like : \r\n"
				+ "\"Invalid username or password!  \""));
	}
	
	@Test(priority = 6,description="To verify that user is not able to \"Login\"  in Police Vertical web portal with invalid username and invalid password.")
	public void PV_Login_09() throws InterruptedException 
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Enter invalid \"Username\" or \"Email address\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("Abc@123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter invalid \"Password\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		ExtentTestManager.getTest().log(Status.INFO, " <b>Step-4</b> : Click on \"Login\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.validation_of_Invalid)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like : \r\n"
				+ "\"Invalid username or password!  \""));
		Thread.sleep(1000);
	}
	
	@Test(priority = 7,description="To verify that iser is able to close validation message popup.")
	public void PV_Login_10() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Login\" button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Enter invalid \"Username\" or \"Email address\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("Abc@123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter invalid \"Password\" in respective text-box.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Click on \"Login\" button.");
		boolean v1=driver.findElement(By.xpath(Login_repository.temp)).isDisplayed();
		Assert.assertEquals(v1, true);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.btn_X_validation)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"X\" icon of message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close validation message popup."));
	}
	

	
	
	@AfterClass
	public void Afterclass() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(Login_repository.profile_admin))).
		build().perform(); Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.lnk_logout)).click();
		 
		Thread.sleep(2000);
		driver.close();
	}
	
}

