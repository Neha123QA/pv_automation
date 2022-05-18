package pv_admin;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listener.ExtentTestManager;
import Listener.Screenshot_extra;

public class PV_Patrollings {

	WebDriver driver;
	Screenshot_extra ll=new Screenshot_extra();
	String i="PV_Patrollings_extra_ss";
	FirefoxProfile geoenabled = new FirefoxProfile();
	
	
	@BeforeClass
	public void setDriver(ITestContext context) throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();

	}
	
	
	@BeforeMethod
	@Test
	public void Openurl(ITestContext context) throws InterruptedException, MalformedURLException 
	{
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
		
		  //WebDriverManager.chromedriver().setup();
		/*
		  FirefoxOptions options = new FirefoxOptions();
	      Map<String, Object> prefs = new HashMap<String, Object>();
	      prefs.put("profile.default_content_setting_values.geolocation", 1);
	      options.setCapability("prefs", prefs);
		  driver = new FirefoxDriver(options);
		  context.setAttribute("WebDriver", driver);
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.manage().getCookies();
		  */
		
		
		geoenabled.setPreference("geo.enabled", true);
		geoenabled.setPreference("geo.provider.use_corelocation", true);
		geoenabled.setPreference("geo.prompt.testing", true);
		geoenabled.setPreference("geo.prompt.testing.allow", true);
		geoenabled.setPreference("security.mixed_content.block_active_content",false);
		geoenabled.setPreference("security.mixed_content.block_display_content",true);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoenabled);
		driver = new FirefoxDriver(capabilities);
		
		
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		  context.setAttribute("WebDriver", driver);
		  Thread.sleep(2000);
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("http://pvqaadmin.sgligis.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("1q2w3E*");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		Thread.sleep(5000);
	}
	
	public static void explicitwait(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		//element.sendKeys(val);
	}
	
	@Test(priority=0,description="To verify that user is able to expand/collapse \"Patrollings\" menu from left panel of \"Home\" page of Police Vertical web portal.")
	public void PV_Patrollings_01(Method method) throws InterruptedException
	{
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		String a1=driver.findElement(By.xpath(Patrollings_repository.style_exp_coll)).getAttribute("style");
		System.out.println(a1);
		Thread.sleep(1000);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.menu_item_beat_bandobast)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.menu_item_dutytypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.menu_item_3dmodel)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get \"Patrollings\" in expanded mode with following list of functionalities :</br>"
				+ "\"Beat & Bandobast\" , </br>"
				+ "\"Duty Types\" , </br>"
				+ "\"Vehicles\" ,</br>"
				+ "\"Vehicle Types\" ,</br>"
				+ "\"Resources\" ,</br>"
				+ "\"Resource Type\" ,</br>"
				+ "\"3D Models\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Patrollings\" menu from left pane.");
		String a2=driver.findElement(By.xpath(Patrollings_repository.style_exp_coll)).getAttribute("style");
		System.out.println(a2);
		Thread.sleep(1000);
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get \"Patrollings\" in collapse mode."));
	}
	
	@Test(priority=1,description="To verify that user is able to get Landing page of \"Vehicle Types\".")
	public void PV_Patrollings_02() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Vehicle Types");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_type)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_isactive)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_entries)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Vehicle Types\" page with following :</br>"
				+ "1. Buttons : \"New Vehicle Type\" , \"Next\" , \"Previous\" ,  Page Control Numbers, .</br>"
				+ "2. Text-box : \"SEARCH\".</br>"
				+ "3. Table of users with following column fields :</br>"
				+ "\"Actions\", \"Type\",\"Description\", \"Is Active?\".</br>"
				+ "4. Dropdown : \"Actions\" button for each duty listed in page ,\"Show entries\" .</br>"
				+ "5. Links : \"Home\" icon."));
		
	}
	
	@Test(priority=2,description="To verify that user is able to get \"New Vehicle Type\" window by performing \"New Vehicle Type\" functionality.")
	public void PV_Patrollings_03() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Vehicle Type");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_type)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_des_vehtype_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.chbox_isactive)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Vehicle Type\" window with following :</br>"
				+ "1. Textboxes : \"Vehicle Type\" , \"Description\".</br>"
				+ "2. Buttons : \"Cancel\" , \"Save\" , \"Close(X)\" .</br>"
				+ "3. Check-box : \"Is Active?\"."));
	}
	
	@Test(priority=3,description="To verify that user is able to add new Vehicle Type by performing \"New Vehicle Type\" functionality.")
	public void PV_Patrollings_04() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Enter \"Vehicle Type\" in respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_vehtype_win)).sendKeys("Testing Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> :  Enter \"Description\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"New Vehicle Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Test Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Vehicle Type\" window and window should close.</br>"
				+ "2. Added vehicle should display in list of \"Vehicle Types\" page."));
	}
	
	@Test(priority=4,description="To verify that user is able to close \"New Vehicle Type\" window.")
	public void PV_Patrollings_05() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		driver.findElement(By.xpath(Patrollings_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Click on \"X\"(close) button of \"New Vehicle Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Vehicle Type\" window."));
	}
	
	@Test(priority=4,description="To verify that user is able to perform \"Cancel\" functionality of \"New Vehicle Type\" window.")
	public void PV_Patrollings_06() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Click on \"Cancel\" button of \"New Vehicle Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"New Vehicle Type\" window and \"New Vehicle Type\" window should close."));
	}
	
	@Test(priority=6,description="To verify that user gets validation message when \"Save\" New Vehicle Type with blank mandatory details.")
	public void PV_Patrollings_07() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button of \"New Vehicle\" window with blank mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.val_type_vehtype_win)).getText(), "The Type field is required.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like :\r\n"
				+ "\"The Type field is required.\"."));
	}
	
	@Test(priority=7,description="To verify that user gets validation message when  add new Vehicle Type which is already exist.")
	public void PV_Patrollings_08(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Enter \"Vehicle Type\" in respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_vehtype_win)).sendKeys("Testing Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> :  Enter \"Description\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"New Vehicle Type\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText(), "This Vehicle Type already exist.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like \"Vehicle type already exist with this Name \"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Patrollings_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : </br>1. Validation message popup should close.</br>"
				+ "2. \"New Vehicle Type\" window should display with entered details."));
	}
	
	@Test(priority=8,description="To verify that user gets validation message when perform \"Cancel\" functionality after Adding details in \"New Vehicle Type\" window.")
	public void PV_Patrollings_09() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Enter \"Vehicle Type\" in respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_vehtype_win)).sendKeys("Testing Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> :  Enter \"Description\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"New Vehicle Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Vehicle Type\" window should also close."));
	}
	
	@Test(priority=9,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Vehicle Type\" window.")
	public void PV_Patrollings_10() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"New Vehicle Type\" button from \"Vehicle Type\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Enter \"Vehicle Type\" in respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_vehtype_win)).sendKeys("Testing Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> :  Enter \"Description\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"New Vehicle Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Vehicle Type\" window shouldn't close."));
	}
	
	@Test(priority=10,description="To verify that user is able to edit any particular vehicle type by performing \"Edit\" functionality from \"Actions\" button dropdown.")
	public void PV_Patrollings_11() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle Type");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type_editvehtype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type_editvehtype_win)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Edit \"Vehicle Type\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_editvehtype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_editvehtype_win)).sendKeys("This is testing of vehicle type.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit \"Description\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.chbox_isactive)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit selection of \"Is Active?\" check-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Save\" button of \"Edit Vehicle Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Edit Vehicle Type");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Vehicle Type\" window and window should close.</br>"
				+ "2. Edited details of Vehicle type should update in  \"Vehicle Types\" page accordingly."));
	}
	
	@Test(priority=11,description="To verify that user is able to close \"Edit Vehicle Type\" window.")
	public void PV_Patrollings_12() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle Type");
		driver.findElement(By.xpath(Patrollings_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Click on \"X\"(close) button of \"Edit Vehicle Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Vehicle Type\" window."));
	}
	
	@Test(priority=12,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Vehicle Type\" window.")
	public void PV_Patrollings_13() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle Type");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> :  Click on \"Cancel\" button of \"Edit Vehicle Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Vehicle Type\" window and \"Edit Vehicle Type\" window should close."));
	}
	
	@Test(priority=13,description="To verify that user gets validation message when perform \"Cancel\" functionality after Editing details in \"Edit Vehicle Type\" window.")
	public void PV_Patrollings_14() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle Type");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type_editvehtype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type_editvehtype_win)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Edit \"Vehicle Type\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_editvehtype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_editvehtype_win)).sendKeys("This is testing of vehicle type.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit \"Description\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.chbox_isactive)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit selection of \"Is Active?\" check-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Vehicle Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Vehicle Type\" window should also close."));
	}
	
	@Test(priority=14,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Vehicle Type\" window.")
	public void PV_Patrollings_15() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle Type");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type_editvehtype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_type_editvehtype_win)).sendKeys("Test Vehicle Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Edit \"Vehicle Type\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_editvehtype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_des_editvehtype_win)).sendKeys("This is testing of vehicle type.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit \"Description\" from respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.chbox_isactive)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit selection of \"Is Active?\" check-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Vehicle Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Vehicle Type\" window shouldn't close."));
	}
	
	@Test(priority=15,description="To verify that user is able to \"Cancel\" validation message of discard Vehicle Type record.")
	public void PV_Patrollings_17() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular vehicle type which want to discard.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to discard the Vehicle Type: 'Edit Vehicle Type'?", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=16,description="To verify that user is able to discard particular Vehicle Type by performing \"Discard\" functionality from \"Actions\" dropdown.")
	public void PV_Patrollings_16() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Vehicle Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular vehicle type which want to discard.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to discard the Vehicle Type: 'Edit Vehicle Type'?", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.toast_msg)).getText(), "Successfully discarded!");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 0 to 0 of 0 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and message pop up should close.</br>"
				+ "2. User should get validation message like : \"Successfully discarded!\".</br>"
				+ "3. Selected vehicletype record should discarded from \"Vehicle Types\" page."));
	}
	
	@Test(priority=17,description="To verify that user is able to perform \"SEARCH\" functionality of \"Vehicle Type\" page.")
	public void PV_Patrollings_18() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Car");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Car");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Vehicle Type\" page."));
	}
	
	@Test(priority=18,description="To verify that user is able to perform Pagination functionality of \"Vehicle Type\" page.")
	public void PV_Patrollings_19(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		
		for(int i=0;i<7;i++)
		{
			driver.findElement(By.xpath(Patrollings_repository.btn_newvehicletype)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Patrollings_repository.txtbox_type)).sendKeys("Test"+i);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
			Thread.sleep(2000);
		}
		
		
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		
		driver.findElement(By.xpath(Patrollings_repository.btn_next)).click();
		Thread.sleep(3000);
		String[] b1=s1.split(" "); 
		String d= b1[5]; 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of \"Vehicle Type\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(Patrollings_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of \"Vehicle Type\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		driver.findElement(By.xpath(Patrollings_repository.lnk_pageno_2)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Vehicle Type\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get particular page no. of records in \"Vehicle Type\" page."));
	}
	
	@Test(priority=19,description="To verify that user is able to select number of entries show in \"Vehicle Type\" page from Show entries dropdown.")
	public void PV_Patrollings_20(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		String s2=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(Patrollings_repository.dd_entries)).sendKeys("25");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Vehicle Type\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		for(int i=0;i<7;i++)
		{
			driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test"+i);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
			Thread.sleep(1000);
			Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
			driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Patrollings_repository.searchbox)).clear();
			Thread.sleep(1000);
		}
		
	}
	
	@Test(priority=20,description="To verify that user is able to get back to \"Home\" page from \"Vehicle Type\" page by clicking on \"Home\" icon.")
	public void PV_Patrollings_21() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Vehicle Types");
		driver.findElement(By.xpath(Patrollings_repository.lnk_Home)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Home\" icon in \"Vehicle Type\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Vehicle Type\" page."));
	}
	
	@Test(priority=21,description="To verify that user is able to perform sorting functionality for columns present in \"Vehicle Type\" page. ")
	public void PV_Patrollings_22(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicletypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicle Types\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Vehicle Types");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_type)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(Patrollings_repository.col_lbl_type)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_type)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Sorting\" icon of the \"Type\" column.");
		String s2=driver.findElement(By.xpath(Patrollings_repository.col_lbl_type)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in sorting order of \"Type\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Sorting\" icon of the \"Description\" column.");
		String s4=driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in alphabetical sorting order of \"Description\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_isactive)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(Patrollings_repository.col_lbl_isactive)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_isactive)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Sorting\" icon of the \"Is Active?\" column.");
		String s6=driver.findElement(By.xpath(Patrollings_repository.col_lbl_isactive)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Is Active?\" data field."));
	}
	
	
	
	@Test(priority=22,description="To verify that user is able to get Landing page of \"Vehicles\".")
	public void PV_Patrollings_23() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Vehicles");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.searchbox)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicleno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicletype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_regdate)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_chassisno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_seatingcapacity)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_ownershiptype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_fueltype)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Vehicles\" page with following :</br>"
				+ "1. Buttons: \"New Vehicle\" , \"Next\" , \"Previous\" ,  Page Control Numbers, .</br>"
				+ "2. Text-box : \"SEARCH\".</br>"
				+ "3. Table of users with following column fields :</br>"
				+ "\"Actions\" , \"Vehicle Number\", \"Type\", \"Registration Date(MM/DD/YYYY)\", \"Chassis Number\", \"Registration Date\" , \"Seating Capacity\" , \"Fuel Type\" , \"Ownership Type\" .</br>"
				+ "4. Dropdown : \"Actions\" button for each duty listed in page ,\"Show entries\" .</br>"
				+ "5. Links : \"Home\" icon."));
	}
	
	@Test(priority=23,description="To verify that user is able to get \"New Vehicle\" window by performing \"New Vehicle\" functionality from \"Vehicles\" page.")
	public void PV_Patrollings_24() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Vehicle");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_ownershiptype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_fueltype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Vehicle\" window with following :</br>"
				+ "1. Text-boxes : \"Vehicle Type\" , \"Vehicle Number\" , \"Registration Date(MM/DD/YYYY)\" , \"Chassis Number\" , \"Seating Capacity\" , \"Ownership Type\" , \"Fuel Type\" .</br>"
				+ "2. Buttons : \"Cancel\" , \"Save\" , close(\"X\")."));
	}
	
	@Test(priority=24,description="To verify that user is able to add New Vehicle by performing \"New Vehicle\" functionality from \"Vehicles\" page.")
	public void PV_Patrollings_25() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Vehicle Number\" into \"Vehicle Number\" text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)));
		select.selectByVisibleText("Car");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Vehicle Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).sendKeys("06/06/2021");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Registration Date\" into \"Registration Date\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).sendKeys("123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Chassis Number\" into \"Chassis Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).sendKeys("11");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"Seating Capacity\" into \"Seating Capacity\" text-box.");
		Select select1 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_ownershiptype)));
		select1.selectByVisibleText("Private");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter \"Ownership Type\" into \"Ownership Type\" text-box.");
		Select select2 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_fueltype)));
		select2.selectByVisibleText("Petrol");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"Fuel Type\" into \"Fuel Type\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button of \"New Vehicle\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test123456");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"New Vehicle\" window and window should close.</br>"
				+ "2. Added Vehicle should display in list of \"Vehicles\" page."));
	}
	
	@Test(priority=25,description="To verify that user is able to close \"New Vehicle\" window.")
	public void PV_Patrollings_26() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Vehicle");
		driver.findElement(By.xpath(Patrollings_repository.btn_close)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"New Vehicle\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Vehicle\" window."));
	}
	
	@Test(priority=26,description="To verify that user is able to perform \"Cancel\" functionality of \"New Vehicle\" window.")
	public void PV_Patrollings_27() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Vehicle");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New Vehicle\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Vehicle\" window and \"New Vehicle\" window should close."));
	}
	
	@Test(priority=27,description="To verify that user gets validation messages when click on \"Save\" button without entering mandatory details of \"New Layer Tree\" window.")
	public void PV_Patrollings_28() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Vehicle");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button of \"New Vehicle\" window without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.val_vehicleno_newveh_win)).getText(), "The Vehicle Number field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.val_seatingcap_newveh_win)).getText(), "Please enter a value greater than or equal to 1.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should gets validation messages like : </br>"
				+ "\"The Vehicle Number field is required.\",</br>"
				+ "\"Please enter a value greater than or equal to 1.\" below respective fields."));
		
	}
	
	@Test(priority=28,description="To verify that user gets validation message when add new Vehicle which is already exist.")
	public void PV_Patrollings_29(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Vehicle Number\" into \"Vehicle Number\" text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)));
		select.selectByVisibleText("Car");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Vehicle Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).sendKeys("06/06/2021");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Registration Date\" into \"Registration Date\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).sendKeys("123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Chassis Number\" into \"Chassis Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).sendKeys("11");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"Seating Capacity\" into \"Seating Capacity\" text-box.");
		Select select1 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_ownershiptype)));
		select1.selectByVisibleText("Private");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter \"Ownership Type\" into \"Ownership Type\" text-box.");
		Select select2 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_fueltype)));
		select2.selectByVisibleText("Petrol");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"Fuel Type\" into \"Fuel Type\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button of \"New Vehicle\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText(), "Vehicle with this Vehicle Number already exist.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Vehicle with this Vehicle Number Already Exists.\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Patrollings_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. Validation message popup should close.</br>"
				+ "2. \"New Vehicle\" window should display with entered details."));
	}
	
	@Test(priority=29,description="To verify that user gets toast validation message when create \"New Vehicle\" with future \"Registration Date\".")
	public void PV_Patrollings_30() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Vehicle Number\" into \"Vehicle Number\" text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)));
		select.selectByVisibleText("Car");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Vehicle Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).clear();
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.add(Calendar.DATE, 1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		
		WebElement tomDate = driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)); 
		tomDate.sendKeys(tommorowsDate); 
		Thread.sleep(3000);
		System.out.println(tommorowsDate);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter/select future \"Registration Date\" into \"Registration Date\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.toast_msg)).getText(), "Registration Date must not be of future.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get toast validation like \"Registration Date must not be of future.\"."));
	}
	
	@Test(priority=30,description="To verify that user gets validation when enter invalid \"Seating Capacity\" capacity in respective field of \"New Vehicle\" window.")
	public void PV_Patrollings_31() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Vehicle Number\" into \"Vehicle Number\" text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)));
		select.selectByVisibleText("Car");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Vehicle Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).sendKeys("06/06/2021");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Registration Date\" into \"Registration Date\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).sendKeys("123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Chassis Number\" into \"Chassis Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).sendKeys("-2");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter invalid number into \"Seating Capacity\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.val_seatingcap_newveh_win)).getText(), "Please enter a value greater than or equal to 1.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Please enter a value greater than or equal to 1.\" below respective field."));
	}
	
	@Test(priority=31,description="To verify that user gets validation message when perform \"Cancel\" functionality of \"New Vehicle\" window after adding details in respective fields of \"New Vehicle\" window.")
	public void PV_Patrollings_32() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Vehicle Number\" into \"Vehicle Number\" text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)));
		select.selectByVisibleText("Car");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Vehicle Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).sendKeys("06/06/2021");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Registration Date\" into \"Registration Date\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).sendKeys("123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Chassis Number\" into \"Chassis Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).sendKeys("11");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"Seating Capacity\" into \"Seating Capacity\" text-box.");
		Select select1 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_ownershiptype)));
		select1.selectByVisibleText("Private");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter \"Ownership Type\" into \"Ownership Type\" text-box.");
		Select select2 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_fueltype)));
		select2.selectByVisibleText("Petrol");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"Fuel Type\" into \"Fuel Type\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Cancel\" button of \"New Vehicle\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Vehicle\" window should also close."));
	}
	
	@Test(priority=32,description="To verify that user is able to \"Cancel\" validation message popup of unsaved changes of \"New Vehicle\" window.")
	public void PV_Patrollings_33() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Vehicle\" button from \"Vehicles\" page.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Vehicle Number\" into \"Vehicle Number\" text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)));
		select.selectByVisibleText("Car");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Vehicle Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).sendKeys("06/06/2021");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Registration Date\" into \"Registration Date\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).sendKeys("123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Chassis Number\" into \"Chassis Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).sendKeys("11");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"Seating Capacity\" into \"Seating Capacity\" text-box.");
		Select select1 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_ownershiptype)));
		select1.selectByVisibleText("Private");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter \"Ownership Type\" into \"Ownership Type\" text-box.");
		Select select2 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_fueltype)));
		select2.selectByVisibleText("Petrol");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"Fuel Type\" into \"Fuel Type\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Cancel\" button of \"New Vehicle\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Vehicle\" window shouldn't close."));
	}
	
	@Test(priority=33,description="To verify that user is able to edit Vehicle details by performing \"Edit\" functionality from \"Actions\" dropdown of particular Vehicle from \"Vehicles\" page.")
	public void PV_Patrollings_34() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Edit123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Vehicle Number\" into \"Vehicle Number\" text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_vehicletype)));
		select.selectByVisibleText("Car");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit selection of \"Vehicle Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_registrationdate)).sendKeys("06/06/2021");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit \"Registration Date\" into \"Registration Date\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_chassisno)).sendKeys("123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit \"Chassis Number\" into \"Chassis Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).sendKeys("08");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit \"Seating Capacity\" into \"Seating Capacity\" text-box.");
		Select select1 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_ownershiptype)));
		select1.selectByVisibleText("Government");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit \"Ownership Type\" into \"Ownership Type\" text-box.");
		Select select2 = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_fueltype)));
		select2.selectByVisibleText("CNG");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit \"Fuel Type\" into \"Fuel Type\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button of \"Edit Vehicle window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).clear();
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit123456");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Edit123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Vehicle\" window and window should close.</br>"
				+ "2. Edited details of vehicle should update in  \"Vehicles\" page accordingly."));
	}
	
	@Test(priority=34,description="To verify that user is able to close \"Edit Vehicle\" window.")
	public void PV_Patrollings_35() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle");
		driver.findElement(By.xpath(Patrollings_repository.btn_close)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"Edit Vehicle\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Vehicle\" window."));
	}
	
	@Test(priority=35,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Vehicle\" window.")
	public void PV_Patrollings_36() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Vehicle");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Edit Vehicle\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Vehicle\" window and window should close."));
	}
	
	@Test(priority=36,description="To verify that user is able to validation message when perform \"Cancel\" functionality of \"Edit Vehicle\" window after editing details in respective fields of \"Edit Vehicle\" window.")
	public void PV_Patrollings_37() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Vehicle Number\" from \"Vehicle Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Edit Vehicle\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Vehicle\" window should also close."));
	}
	
	@Test(priority=37,description="To verify that user is able to \"Cancel\" validation message popup of unsaved changes of \"Edit Vehicle\" window.")
	public void PV_Patrollings_38() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular vehicle.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test123456");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Vehicle Number\" from \"Vehicle Number\" text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Edit Vehicle\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Vehicle\" window shouldn't close."));
	}
	
	@Test(priority=38,description="To verify that user is able to \"Cancel\" validation message of discard Vehicle record.")
	public void PV_Patrollings_40() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular vehicle which want to discard.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals(true, driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).isDisplayed());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=39,description="To verify that user is able to discard particular Vehicle by performing \"Discard\" functionality from \"Actions\" dropdown.")
	public void PV_Patrollings_39() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit123456");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular vehicle which want to discard.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals(true, driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).isDisplayed());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.toast_msg)).getText(), "Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 0 to 0 of 0 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and message pop up should close.</br>"
				+ "2. User should get validation message like : \"Successfully discarded!\".</br>"
				+ "3. Selected vehicle record should discarded from \"Vehicles\" page."));
	}
	
	@Test(priority=40,description="To verify that user is able to perform \"SEARCH\" functionality of \"Vehicles\" page.")
	public void PV_Patrollings_41() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Ambulance");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter search criteria into \"SEARCH\" text-box.");
		String s2=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_firstrow_2ndcol)).getText(), "Ambulance");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Vehicles\" page."));
	}
	
	@Test(priority=41,description="To verify that user is able to perform Pagination functionality of \"Vehicles\" page.")
	public void PV_Patrollings_42(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		for(int i=0;i<8;i++)
		{
			driver.findElement(By.xpath(Patrollings_repository.btn_newvehicle)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.txtbox_vehicleno)).sendKeys("Test00"+i);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.txtbox_seatingcapacity)).sendKeys("2");
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
			Thread.sleep(1000);
		}
		
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		
		driver.findElement(By.xpath(Patrollings_repository.btn_next)).click();
		Thread.sleep(3000);
		String[] b1=s1.split(" "); 
		String d= b1[5]; 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of \"Vehicles\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(Patrollings_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of \"Vehicles\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		driver.findElement(By.xpath(Patrollings_repository.lnk_pageno_2)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Vehicles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get particular page no. of records in \"Vehicles\" page."));
		
	}
	
	@Test(priority=42,description="To verify that user is able to select number of entries show in \"Vehicles\" page from Show entries dropdown.")
	public void PV_Patrollings_43(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		
		String s2=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(Patrollings_repository.dd_entries)).sendKeys("25");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Vehicles\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		for(int i=0;i<7;i++)
		{
			driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test00"+i);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
			Thread.sleep(1000);
			Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
			driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Patrollings_repository.searchbox)).clear();
			Thread.sleep(1000);
		}
	}
	
	
	@Test(priority=43,description="To verify that user is able to get back to \"Home\" page from \"Vehicles\" page by clicking on \"Home\" icon.")
	public void PV_Patrollings_44() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Vehicles");
		driver.findElement(By.xpath(Patrollings_repository.lnk_Home)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Home\" icon in \"Vehicles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Vehicles\" page."));
	}
	
	@Test(priority=44,description="To verify that user is able to perform sorting functionality for  columns present in \"Vehicles\" page. ")
	public void PV_Patrollings_45(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_vehicles)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Vehicles\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Vehicles");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicleno)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicleno)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicleno)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Sorting\" icon of the \"Vehicle Number\" column.");
		String s2=driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicleno)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in numerical sorting order of \"Vehicle Number\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicletype)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicletype)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicletype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on sorting icon of the \"Vehicle Type\" column.");
		String s4=driver.findElement(By.xpath(Patrollings_repository.col_lbl_vehicletype)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in sorting order of \"Vehicle Type\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_regdate)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(Patrollings_repository.col_lbl_regdate)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_regdate)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of the \"Registration Date\" column.");
		String s6=driver.findElement(By.xpath(Patrollings_repository.col_lbl_regdate)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Registration Date\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_chassisno)).click();
		Thread.sleep(1000);
		String s7=driver.findElement(By.xpath(Patrollings_repository.col_lbl_chassisno)).getAttribute("aria-label");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_chassisno)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of the \"Chassis Number\" column.");
		String s8=driver.findElement(By.xpath(Patrollings_repository.col_lbl_chassisno)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in sorting order of \"Chassis Number\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_seatingcapacity)).click();
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(Patrollings_repository.col_lbl_seatingcapacity)).getAttribute("aria-label");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_seatingcapacity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of the \"Seating Capacity\" column.");
		String t2=driver.findElement(By.xpath(Patrollings_repository.col_lbl_seatingcapacity)).getAttribute("aria-label");
		Assert.assertNotEquals(t1, t2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_5</b> : User should get records in sorting order of \"Seating Capacity\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_05");
		
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_ownershiptype)).click();
		Thread.sleep(1000);
		String t3=driver.findElement(By.xpath(Patrollings_repository.col_lbl_ownershiptype)).getAttribute("aria-label");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_ownershiptype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Ownership Type\" column.");
		String t4=driver.findElement(By.xpath(Patrollings_repository.col_lbl_ownershiptype)).getAttribute("aria-label");
		Assert.assertNotEquals(t3, t4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_6</b> : User should get records in sorting order of \"Ownership Type\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_06");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_fueltype)).click();
		Thread.sleep(1000);
		String t5=driver.findElement(By.xpath(Patrollings_repository.col_lbl_fueltype)).getAttribute("aria-label");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_fueltype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Fuel Type\" column.");
		String t6=driver.findElement(By.xpath(Patrollings_repository.col_lbl_fueltype)).getAttribute("aria-label");
		Assert.assertNotEquals(t5, t6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_7</b> : User should get records in sorting order of \"Fuel Type\" data field."));
	}
	
	@Test(priority=45,description="To verify that user is able to get Landing Page of \"Resource Types\".")
	public void PV_Patrollings_46() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resource Types");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.searchbox)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_restypename)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_rescategorytype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.lnk_Home)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Resource Types\" page with following :</br>"
				+ "1. Buttons: \"New Resource Type\" , \"Next\" , \"Previous\" ,  Page Control Numbers.</br>"
				+ "2. Text-box : \"SEARCH\".</br>"
				+ "3. Table of users with following column fields :</br>"
				+ "\"Actions\" , \"Resource Type Name\", \"Resource Category Type\" , \"Description\".</br>"
				+ "4. Dropdown : \"Actions\" button for each Resource Type listed in page ,\"Show entries\" .</br>"
				+ "5. Links : \"Home\" icon."));
	}
	
	@Test(priority=46,description="To verify that user is able to get \"New Resource Type\" window.")
	public void PV_Patrollings_47() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Resource Type\" window with following :</br>"
				+ "1) Text-boxes : \"Resource Type Name\" , \"Description\".</br>"
				+ "2) Dropdown : \"Resource Category Type\".</br>"
				+ "3) Buttons : \"Cancel\" , \"save\" , close(\"X\")."));
	}
	
	@Test(priority=47,description="To verify that user is able to add \"New Resource Type\" by performing \"New Resource Type\" functionality from \"Resource Types\" page.")
	public void PV_Patrollings_48() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Type Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
		select.selectByVisibleText("weapon");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Category Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).sendKeys("Testing of add new resource type.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button  of \"New Resource Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Test Res_Type");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"New Resource Type\" window and window should close.</br>"
				+ "2. Added resource type should display in list of \"Resource Types\" page."));
	}
	
	@Test(priority=48,description="To verify that user is able to close \"New Resource Type\" window.")
	public void PV_Patrollings_49() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"New Resource Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Resource Type\" window."));
	}
	
	@Test(priority=49,description="To verify that user is able to perform \"Cancel\" functionality of \"New Resource Type\" window.")
	public void PV_Patrollings_50() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New Resource Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Resource Type\" window and window should close."));
	}
	
	@Test(priority=50,description="To verify that user gets validation messages when click on \"Save\" button without entering mandatory details of \"New Resource Type\" window.")
	public void PV_Patrollings_51() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button of \"New Resource Type\" window without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.val_restypename)).getText(), "The Resource Type Name field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should gets validation messages like : \"The Resource Type Name field is required.\" below respective field."));
	}
	
	@Test(priority=51,description="To verify that user gets validation message when  add new Resource Type which is already exist.")
	public void PV_Patrollings_52(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Type Name\" into respective text-box which is already exist.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
		select.selectByVisibleText("weapon");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Category Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).sendKeys("Testing of add new resource type.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button  of \"New Resource Type\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText(), "Resource type already exist with this Name");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like \"Resource type already exist with this Name\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Patrollings_repository.btn_OK)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : </br>1. Validation message popup should close.</br>"
				+ "2. \"New Resource Type\" window should display with entered details."));
	}
	
	@Test(priority=52,description="To verify that user is able to validation message when perform \"Cancel\" functionality of \"New Resource Type\" window after adding details in respective fields of \"New Resource Type\" window.")
	public void PV_Patrollings_53() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Type Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
		select.selectByVisibleText("weapon");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Category Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).sendKeys("Testing of add new resource type.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button  of \"New Resource Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Resource Type\" window should also close."));
	}
	
	@Test(priority=53,description="To verify that user is able to \"Cancel\" validation message popup of unsaved changes of \"New Resource Type\" window.")
	public void PV_Patrollings_54() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource Type\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "New Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Type Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
		select.selectByVisibleText("weapon");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Category Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).sendKeys("Testing of add new resource type.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button  of \"New Resource Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Resource Type\" window shouldn't close."));
	}
	
	@Test(priority=54,description="To verify that user is able to edit Resource Type details by performing \"Edit\" functionality from \"Actions\" dropdown of particular resource type from\"Resource Types\" page.")
	public void PV_Patrollings_55() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular resource type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Resource Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Resource Type Name\" from respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
		select.selectByVisibleText("weapon");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Selection of \"Resource Category Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).sendKeys("Testing of add new resource type.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit \"Description\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button of \"Edit Resource Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).clear();
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Edit Res_Type");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Vehicle\" window and window should close.</br>"
				+ "2. Edited details of resource type should update in  \"Resource Types\" page accordingly."));
	}
	
	@Test(priority=55,description="To verify that user is able to close \"Edit Resource Type\" window.")
	public void PV_Patrollings_56() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular resource type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"Edit Resource Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Resource Type\" window."));
	}
	
	@Test(priority=56,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Resource Type\" window.")
	public void PV_Patrollings_57() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular resource type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Resource Type");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Edit Resource Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Resource Type\" window and window should close."));
	}
	
	@Test(priority=57,description="To verify that user is able to validation message when perform \"Cancel\" functionality of \"Edit Resource Type\" window after editing details in respective fields of \"Edit Resource Type\" window.")
	public void PV_Patrollings_58() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular resource type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Resource Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Resource Type Name\" from respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
		select.selectByVisibleText("weapon");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Selection of \"Resource Category Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).sendKeys("Testing of add new resource type.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit \"Description\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Resource Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Resource Type\" window should also close."));
	}
	
	@Test(priority=58,description="To verify that user is able to \"Cancel\" validation message popup of unsaved changes of \"Edit Resource Type\" window.")
	public void PV_Patrollings_59() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular resource type.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Resource Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Test Res_Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Resource Type Name\" from respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
		select.selectByVisibleText("weapon");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Selection of \"Resource Category Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtarea_des_newrestype_win)).sendKeys("Testing of add new resource type.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit \"Description\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Resource Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Resource Type\" window shouldn't close."));
	}
	
	@Test(priority=59,description="To verify that user is able to \"Cancel\" validation message popup of discard record of Resource Type.")
	public void PV_Patrollings_61() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular resource type which want to discard.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals(true, driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).isDisplayed());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=60,description="To verify that user is able to discard Resource Type by performing \"Discard\" functionality from  \"Actions\" dropdown of particular resource type from\"Resource Types\" page.")
	public void PV_Patrollings_60() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Edit Res_Type");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular resource type which want to discard.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
		Assert.assertEquals(true, driver.findElement(By.xpath(Patrollings_repository.validation_2ndline)).isDisplayed());
		driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.toast_msg)).getText(), "Successfully discarded!");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 0 to 0 of 0 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and message pop up should close.</br>"
				+ "2. User should get validation message like : \"Successfully discarded!\".</br>"
				+ "3. Selected resource type record should discarded from \"Resource Types\" page."));
	}
	
	@Test(priority=61,description="To verify that user is able to perform \"SEARCH\" functionality of \"Resource Types\" page.")
	public void PV_Patrollings_62() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Gun");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Gun");
		String s2=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Resource Types\" page."));
	}
	
	@Test(priority=62,description="To verify that user is able to perform Pagination functionality of \"Resource Types\" page.")
	public void PV_Patrollings_63(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		for(int i=0;i<8;i++)
		{
			driver.findElement(By.xpath(Patrollings_repository.btn_newrestype)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Patrollings_repository.txtbox_restypename)).sendKeys("Test Res_Type"+i);
			Thread.sleep(1000);
			Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_rescategoryname)));
			select.selectByVisibleText("weapon");
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
			Thread.sleep(2000);
		}
		
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		
		driver.findElement(By.xpath(Patrollings_repository.btn_next)).click();
		Thread.sleep(3000);
		String[] b1=s1.split(" "); 
		String d= b1[5]; 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of \"Resource Types\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(Patrollings_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of \"Resource Types\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		driver.findElement(By.xpath(Patrollings_repository.lnk_pageno_2)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Resource Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get particular page no. of records in \"Resource Types\" page."));
		
	}
	
	@Test(priority=63,description="To verify that user is able to select number of entries show in \"Resource Types\" page from Show entries dropdown.")
	public void PV_Patrollings_64(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		
		String s2=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_entries)));
		select.selectByVisibleText("25");
		//driver.findElement(By.xpath(Patrollings_repository.dd_entries)).sendKeys("25");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e1=driver.findElement(By.xpath(Patrollings_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.text_showing_entries)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Vehicle Type\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		for(int i=0;i<8;i++)
		{
			driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test Res_Type"+i);
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Patrollings_repository.lnk_discard_first)).click();
			Thread.sleep(1000);
			Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText());
			driver.findElement(By.xpath(Patrollings_repository.validation_btn_yes)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Patrollings_repository.searchbox)).clear();
			Thread.sleep(1000);
		}
	}
	
	@Test(priority=64,description="To verify that user is able to get back to \"Home\" page from \"Resource Types\" page by clicking on \"Home\" icon.")
	public void PV_Patrollings_65() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resource Types");
		driver.findElement(By.xpath(Patrollings_repository.lnk_Home)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Home\" icon in \"Resource Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Resource Types\" page."));
	}
	
	@Test(priority=65,description="To verify that user is able to perform sorting functionality for columns present in \"Resource Types\" page. ")
	public void PV_Patrollings_66(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resourcetypes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resource Types\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resource Types");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_restypename)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(Patrollings_repository.col_lbl_restypename)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_restypename)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Sorting\" icon of the \"Resource Type Name\" column.");
		String s2=driver.findElement(By.xpath(Patrollings_repository.col_lbl_restypename)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in sorting order of \"Resource Type Name\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_rescategorytype)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(Patrollings_repository.col_lbl_rescategorytype)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_rescategorytype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Sorting\" icon of the \"Resource Category Type\" column.");
		String s4=driver.findElement(By.xpath(Patrollings_repository.col_lbl_rescategorytype)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in sorting order of \"Resource Category Type\" data field."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).getAttribute("aria-sort");
		driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Sorting\" icon of the \"Description\" column.");
		String s6=driver.findElement(By.xpath(Patrollings_repository.col_lbl_description)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Description\" data field."));
	}
	
	@Test(priority=66,description="To verify that user is able to get Landing Page of \"Resources\".")
	public void PV_Patrollings_67() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.searchbox)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_resname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_restypename)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.col_lbl_totcount)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_entries)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Resources\" page with following :</br>"
				+ "1. Buttons: \"New Resource\" , \"Next\" , \"Previous\" ,  Page Control Numbers, .</br>"
				+ "2. Text-box : \"SEARCH\".</br>"
				+ "3. Table of users with following column fields :</br>"
				+ "\"Actions\" , \"Resource Type Name\", \"Resource Name\" , \"Total\".</br>"
				+ "4. Dropdown : \"Actions\" button for each Resource Type listed in page ,\"Show entries\" .</br>"
				+ "5. Links : \"Home\" icon."));
	}
	
	@Test(priority=67,description="To verify that user is able to get \"New Resource\" window.")
	public void PV_Patrollings_68()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_resname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.dd_restype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Resource\" window with following :</br>"
				+ "1. Text-boxes : \"Resource Name\" , \"Total Count\".</br>"
				+ "2. Dropdown : \"Resource Type\".</br>"
				+ "3. Buttons : \"Cancel\" , \"save\" , close(\"X\")."));
	}
	
	@Test(priority=68,description="To verify that user is able to add \"New Resource\" by performing \"New Resource\" functionality from \"Resources\" page.")
	public void PV_Patrollings_69() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_resname)).sendKeys("Test Resource");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_restype)));
		select.selectByVisibleText("Gun");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Total Count\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button  of \"New Resource\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test Resource");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.verify_first)).getText(), "Test Resource");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"New Resource\" window and window should close.</br>"
				+ "2. Added resource should display in list of \"Resources\" page."));
	}
	
	@Test(priority=69,description="To verify that user is able to close \"New Resource\" window.")
	public void PV_Patrollings_70() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.btn_close)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"New Resource\" window.");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Resource\" window."));
	}
	
	@Test(priority=70,description="To verify that user is able to perform \"Cancel\" functionality of \"New Resource\" window.")
	public void PV_Patrollings_71() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New Resource\" window.");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Resource\" window and window should close."));
	}
	
	@Test(priority=71,description="To verify that user gets validation messages when click on \"Save\" button without entering mandatory details of \"New Resource\" window.")
	public void PV_Patrollings_72() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button of \"New Resource\" window without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.val_resname)).getText(), "The Resource Name field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should gets validation messages like : \r\n"
				+ "\"The Resource Name field is required.\""));
	}
	
	@Test(priority=72,description="To verify that user gets validation message when  add new Resource with the same as which is already exist.")
	public void PV_Patrollings_73(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_resname)).sendKeys("Test Resource");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_restype)));
		select.selectByVisibleText("Gun");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Total Count\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button  of \"New Resource\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Resource type already exist with this Name\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).getText(), "Resource already exist with this Name");
		driver.findElement(By.xpath(Patrollings_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. Validation message popup should close.</br>"
				+ "2. \"New Resource Type\" window should display with entered details."));
		
	}
	
	@Test(priority=73,description="To verify that user gets validation message when \"Total Count\" value of resource is greater than 50 and less than 1.")
	public void PV_Patrollings_74() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_resname)).sendKeys("Test Resource");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_restype)));
		select.selectByVisibleText("Gun");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).sendKeys("0");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Total Count\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button  of \"New Resource\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.val_totcount)).getText(), "The field Total Count must be between 1 and 50.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"The field Total Count must be between 1 and 50.\" below respective field."));
	}
	
	@Test(priority=74,description="To verify that user is able to validation message when perform \"Cancel\" functionality of \"New Resource\" window after adding details in respective fields of \"New Resource\" window.")
	public void PV_Patrollings_75() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_resname)).sendKeys("Test Resource");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_restype)));
		select.selectByVisibleText("Gun");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Total Count\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button  of \"New Resource\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Resource\" window should also close."));
	}
	
	@Test(priority=75,description="To verify that user is able to \"Cancel\" validation message popup of unsaved changes of \"New Resource\" window.")
	public void PV_Patrollings_76() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.btn_newresource)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Resource\" button.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_resname)).sendKeys("Test Resource");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Resource Name\" into respective text-box.");
		Select select = new Select(driver.findElement(By.xpath(Patrollings_repository.dd_restype)));
		select.selectByVisibleText("Gun");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Resource Type\" from respective dropdown.");
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).clear();
		driver.findElement(By.xpath(Patrollings_repository.txtbox_totcount)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Total Count\" into respective text-box.");
		driver.findElement(By.xpath(Patrollings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button  of \"New Resource\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(Patrollings_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Resource\" window should display on screen."));
	}
	
	
	
	@Test
	public void PV_Patrollings_77() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		/*
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		WebDriverWait wait = new WebDriverWait(driver,30);
		*/
		driver.findElement(By.xpath(Patrollings_repository.menu_patrolling)).click();
		driver.findElement(By.xpath(Patrollings_repository.menu_item_resources)).click();
		//ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Patrollings\"-> \"Resources\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_header)).getText(), "Resources");
		driver.findElement(By.xpath(Patrollings_repository.searchbox)).sendKeys("Test Resource");
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Patrollings_repository.btn_actions_first)).click();
		
		driver.findElement(By.xpath(Patrollings_repository.lnk_edit_first)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Patrollings_repository.title_window)));
		Assert.assertEquals(driver.findElement(By.xpath(Patrollings_repository.title_window)).getText(), "Edit Resource");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
		
	}
	
	@AfterMethod
	public void Aftermethod() throws InterruptedException
	{
		/*
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(Login_repository.profile_admin))).
		build().perform(); Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.lnk_logout)).click();
		Thread.sleep(2000); 
		*/
		driver.close();
		Thread.sleep(1000);
		
	}
	
}
