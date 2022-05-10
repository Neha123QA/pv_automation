package pv_admin;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;

import Listener.ExtentTestManager;
import Listener.Screenshot_extra;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PV_UserManagement {
	WebDriver driver;
	Screenshot_extra ll=new Screenshot_extra();
	String i="PV_UserManagement_extra_ss";
	
	@BeforeClass
	public void setDriver(ITestContext context) throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();

	}
	
	
	@BeforeMethod
	@Test
	public void Openurl(ITestContext context) throws InterruptedException 
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		context.setAttribute("WebDriver", driver);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(Login_repository.url);
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
	
	@Test(priority=0,description="To verify that user is able to expand/collapse \"User Management\" menu from left panel of \"Home\" page.")
	public void PV_UserManagement_01(Method method) throws InterruptedException 
	{
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		String a1=driver.findElement(By.xpath(UserManagement_repository.style_exp_coll)).getAttribute("style");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\" menu from left pane.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"User Management\" in expanded mode ."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"User Management\" menu from left panel.");
		String a2=driver.findElement(By.xpath(UserManagement_repository.style_exp_coll)).getAttribute("style");
		Thread.sleep(1000);
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"User Management\" in collapse mode."));
	}
	
	@Test(priority=1,description="To verify that user is able to get \"User Management\" functionality list from left panel of \"Home\" page.")
	public void PV_UserManagement_02() throws InterruptedException 
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).getText(), "Application Users");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).getText(), "Organization Units");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).getText(), "Application Roles");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).getText(), "Office");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).getText(), "Application Roles");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).getText(), "Designations");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).getText(), "Police Personnel");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"User Management\" in expanded mode with following:</br>1. Application Users </br>2. Application Roles </br> 3. Organization Units </br>4. Office </br> 5. Designations </br> 6. Police Personnel"));
	}
	
	@Test(priority=2,description="To verify that user is able to get \"Application Users\" page.")
	public void PV_UserManagement_03() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.searchbox)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Actions)).getText(), "Actions");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).getText(), "User name");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).getText(), "Email address");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_phonenum)).getText(), "Phone Number");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_IDproof)).getText(),"ID Proof");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_firstname)).getText(), "First Name");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_lastname)).getText(), "Last Name");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_DOB)).getText(), "Date Of Birth");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_age)).getText(), "Age");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_usertype)).getText(), "User Type");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_country)).getText(), "Country");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_state)).getText(), "State");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).getText(), "District");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Users\" page with following: </br>"
				+ "1. Buttons: \"New User\" , \"Next\" , \"Previous\" ,  Page Control Numbers.</br>"
				+ "2. Text-box: \"Search by  Username or Email Address\".</br>"
				+ "3. Table of users with following column fields:\r\n"
				+ "\"Actions\" , \"Username\" , \"Email address\" , \"Phone Number\" , \"Id Proof\" ,\"First Name\" , \"Last Name\" , \"Date of Birth\", \"Age\" , \"Country\" , \"State\" , \"District\" .</br>"
				+ "4. Dropdown: \"Actions\" button ,\"Show entries\" .</br>"
				+ "5. Links:  \"Home\" icon.</br>"
				+ "6. Visibility icon for \"Id Proof\"."));
	}
	
	@Test(priority=3,description="To verify that user is able to perform \"+New User\" functionality from \"Users\" page.")
	public void PV_UserManagement_04() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select Type Of User");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.op_citizen)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.op_dep_user)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Select Type Of User\" window with following:</br>"
				+ "1. Radio button for \"Citizen User\" , \"Department User\".</br>"
				+ "2. Buttons : \"Cancel\" , \"Save\" , \"X\"(Close)."));
	}
	
	@Test(priority=4,description="To verify that user is able to close \"Select Type Of User\" window.")
	public void PV_UserManagement_05() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select Type Of User");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Select Type Of User\" window."));
	}
	
	@Test(priority=5,description="To verify that user is able to perform \"Cancel\" functionality of \"Select Type Of User\" window.")
	public void PV_UserManagement_06() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select Type Of User");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Select Type Of User\" window and \"Select Type Of User\" window should close."));
	}
	
	@Test(priority=6,description="To verify that user is able to get \"New User\" window.")
	public void PV_UserManagement_07(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\"/\"Department User\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New User");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_DOB)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_gender)).isDisplayed(), true);
		driver.findElement(By.xpath(UserManagement_repository.val_citizen_selected)).isDisplayed();
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_country)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_state)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_city)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_taluka)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_village)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.btn_cancel));
		Coordinates co1 = ((Locatable)e1).getCoordinates();
		co1.onPage(); co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br> >> User should get \"New User\" window with 2 tab sections namely \"User information\" and \"Roles\"./If user type is \"Department User\" then \"Police Personnel\" tab section should also get." + 
		">> User should get \"User information\" section with following : </br>"+
				"1. User Type is \"Citizen\"/\"Department user\" as per pre-selection.</br>"
				+ "2. <b>Text-boxes :-</b></br>"
				+ "-> Mandatory: \"Username\" , \"Email Address\", \"First Name\" , \"Last Name\", \"Password\", \"Confirm Password\", \"Date of Birth\" , \"Address Line 1\" , \"PIN Code\" , \"Phone Number\" .</br>"
				+ "-> Optional : \"Middle Name\" ,\"Address Line 2\".</br>"
				+ "3. <b>Dropdown :-</b></bt>"
				+ "-> -> Mandatory: \"Country \", \"State\", \"District/City \" , \"Country Code\"(Pre-selected), \"Gende\", \"ID Proof Type\".</br>"
				+ "-> Optional: \"Taluka\" , \"Village\". </br>"
				+ "4. <b>Buttons :</b> \"Browse\" for \"Id Proof\" attachment ,\"Cancel\" , \"Save\", \"X\"(close).</br>"
				+ "5. <b>Check-boxes :</b> \"Lockout Enabled\" (Pre-selected)."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(UserManagement_repository.tab_roles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Roles\" tab in \"New User\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Roles\" section with following :</br>"
				+ "1. Check boxes of added Roles.</br>"
				+ "2. <b>Buttons :</b> \"Cancel\" , \"Save\", \"X\"(close)."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		List<WebElement> listElement = driver.findElements(By.xpath(UserManagement_repository.list_roles));

			System.out.println(listElement.size());

			String[] arr = new String[listElement.size()];

			for (int i = 0; i < listElement.size(); i++) {
			    String elementText = listElement.get(i).getText();

			    System.out.println(elementText);

			    (arr[i]) = elementText;
			}
			
			driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
			Thread.sleep(1000);
			List<WebElement> listElement1 = driver.findElements(By.xpath(UserManagement_repository.list_roles_approles_page));

			System.out.println(listElement1.size());

			String[] arr1 = new String[listElement1.size()];

			for (int i = 0; i < listElement1.size(); i++) {
			    String elementText1 = listElement1.get(i).getText();

			    System.out.println(elementText1);

			    (arr1[i]) = elementText1;
			    
			    Assert.assertEquals(arr1[i], arr[i]);
			}
			
			
			
			driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UserManagement_repository.op_dep_user)).click();
			driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(UserManagement_repository.tab_policepersonnel)).click();
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Police Personnel\" tab in \"New User\" window.(For \"Department User\" type.)");
			Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_badgeNo)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_reportmanager)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_office)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_designation)).isDisplayed(), true);
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Police Personnel\" section with following :</br>"
					+ "1. <b>Text-box :</b> \"Badge Number\"(Mandatory).</br>"
					+ "2. <b>Dropdowns :</b> \"Reporting Manager\" , \"Office\" , \"Designation\".(Mandatory).</br> "
					+ "3. <<b>Buttons :</b> \"Cancel\" , \"Save\", \"X\"(close)."));
			
	}
	
	@Test(priority=7,description="To verify that user is able to close \"New User\" window.")
	public void PV_UserManagement_08() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\"/\"Department User\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New User");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"X\"(close) button of \"New User\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New User\" window."));
	}
	
	
	
	@Test(priority=8,description="To verify that user is able to perform \"Cancel\" functionality of \"New User\" window.")
	public void PV_UserManagement_09() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\"/\"Department User\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New User");
		Thread.sleep(1000);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.btn_cancel));
		Coordinates co1 = ((Locatable)e1).getCoordinates();
		co1.onPage(); co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button from \"User information\" or \"Roles\" or \"Police Personnel\"(For Department User) section  of \"New user\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button  and \"New User\" window should close."));
	}
	
	@Test(priority=9,description="To verify that user is able to create \"New User\" as \"Citizen\" user type.")
	public void PV_UserManagement_10() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).sendKeys("Test_112");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test112@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		WebElement w1=driver.findElement(By.xpath(UserManagement_repository.txtbox_DOB));
		w1.sendKeys("01-05");
		w1.sendKeys(Keys.TAB);
		w1.sendKeys("1995");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_gender)).sendKeys("Female");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Select any of Gender selection radio button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_state_Gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_city_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Browse\" button of \"ID Proof\" attachment field and Upload file from device.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-27</b> : Click on \"Save\" button.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText(), "Test_112");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button and \"Citizen\" user should create."
				+ "2. \"New User\" window should close.</br>"
				+ "3. Created user should display in list of  \"Users\" page."));
	}
	
	@Test(priority=10,description="To verify that user is able to create \"New User\" as \"Department User\" user type.")
	public void PV_UserManagement_11() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_dep_user)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Department User\" user type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).sendKeys("Za_Test_123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("zatest123@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Mittal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Rathod");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		WebElement w1=driver.findElement(By.xpath(UserManagement_repository.txtbox_DOB));
		w1.sendKeys("01-05");
		w1.sendKeys(Keys.TAB);
		w1.sendKeys("1995");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_gender)).sendKeys("Female");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Select any of Gender selection radio button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_state_Gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_city_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Browse\" button of \"ID Proof\" attachment field and Upload file from device.");
		driver.findElement(By.xpath(UserManagement_repository.tab_policepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-27</b> : Click on \"Police Personnel\" tab from \"New User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_badgeNo)).sendKeys("PS123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-28</b> : Enter Badge number into \"Badge Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_reportmanager)).sendKeys("megh_thakkar");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-29</b> : Select reporting manager from \"Select Manager\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_office)).sendKeys("Ambli Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-30</b> : Select office from \"Office\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_designation)).sendKeys("Assistant Police Inspector");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-31</b> : Select designation from \"Designation\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-32</b> : Click on \"Save\" button of \"New User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Za_Test_123");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText(), "Za_Test_123");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_usertype)).getText(), "Department User");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button and \"Department User\" type user should create."
				+ "2. \"New User\" window should close."
				+ "3. Created user should display in list of  \"Users\" page."));
	}
	
	@Test(priority=11,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Adding details in \"New User\" window.")
	public void PV_UserManagement_12(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).sendKeys("Test_112");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test112@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_gender)).sendKeys("Female");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select any of Gender selection radio button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_state_Gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_city_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Click on \"Browse\" button of \"ID Proof\" attachment field and Upload file from device.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Click on \"Cancel\" button of \"Add OGC Service\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close."
				+ "2. \"New User\" window should also close."));
	}
	
	@Test(priority=12,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New User\" window.")
	public void PV_UserManagement_13() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).sendKeys("Test_112");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test112@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_gender)).sendKeys("Female");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select any of Gender selection radio button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_state_Gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_city_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Click on \"Browse\" button of \"ID Proof\" attachment field and Upload file from device.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Cancel\" button of \"Add OGC Service\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-27</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=13,description="To verify that user is able to view \"Id Proof\" of user by clicking on visibility icon from \"Users\" page.")
	public void PV_UserManagement_14(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.icon_btn_visibility)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on visibility icon of particular user  from \"Id Proof\" column.");
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		Thread.sleep(2000);
		String Title_child = driver.switchTo().window(child_window).getTitle();
		System.out.println(Title_child);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get attached \"Id Proof\" of user in new window tab."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.close();
		
		driver.switchTo().window(parent);
		String Title_parent=driver.switchTo().window(parent).getTitle();
		System.out.println(Title_parent);
		Assert.assertNotEquals(Title_child, Title_parent);
		}
		}
		
	}
	
	@Test(priority=14,description="To verify that user gets validation when create \"New User\" with already exists user  with \"Username\" and \"Email Address\".")
	public void PV_UserManagement_15() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).sendKeys("Test_112");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test112@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		WebElement w1=driver.findElement(By.xpath(UserManagement_repository.txtbox_DOB));
		w1.sendKeys("01-05");
		w1.sendKeys(Keys.TAB);
		w1.sendKeys("1995");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_gender)).sendKeys("Female");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Select any of Gender selection radio button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_state_Gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_city_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Browse\" button of \"ID Proof\" attachment field and Upload file from device.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-27</b> : Click on \"Save\" button of \"New User\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(), "Username 'Test_112' is already taken., Email 'test112@gmail.com' is already taken.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Username 'Test_112' is already taken., Email 'test@gmail.com' is already taken.\"."));
	}
	
	@Test(priority=15,description="To verify that user gets validation messages when perform \"Save\" functionality of \"New User\" window without entering mandatory field details.")
	public void PV_UserManagement_16() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"New User\" window without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_username)).getText(), "The Username field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_email)).getText(), "The Email Address field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_firstname)).getText(), "The First Name field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_lastname)).getText(), "The Last Name field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_pass)).getText(), "The Password field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_confipass)).getText(), "The Confirm Password field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_add1)).getText(), "The Address Line 1 field is required.");
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.validation_fileupload));
		Coordinates co1 = ((Locatable)e1).getCoordinates();
		co1.onPage(); co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_PINcode)).getText(), "The PIN Code field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_phonenum)).getText(), "The Phone Number field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_fileupload)).getText(), "The ID Proof field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like:</br>"
				+ "\"The Username field is required.\",</br>"
				+ "\"The First Name field is required.\",</br>"
				+ "\"The Last Name field is required.\",</br>"
				+ "\"The Email Address field is required.\",</br>"
				+ "\"The Password field is required.\"</br>"
				+ "\"The Confirm Password field is required.\",</br>"
				+ "\"The Address Line 1 field is required.\",</br>"
				+ "\"Not a Valid PIN Code\",</br>"
				+ "\"The Phone Number field is required.\",</br>"
				+ "\"The Id Proof field is required.\"."));
	}
	
	@Test(priority=16,description="To verify that user gets validation message for entering invalid \"Username\".")
	public void PV_UserManagement_17() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).sendKeys("Test 123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid Username in \"Username\" text-box and fill valid all other details in \"New User\" page.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_username)).getText(), "Invalid User Name");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid User Name\" below respective field."));
	}
	
	@Test(priority=17,description="To verify that user gets validation message for entering invalid \"Email Address\".")
	public void PV_UserManagement_18() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("..test999@gmail.com");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid Email address in \"Email Address\" text-box and fill valid all other details in \"New User\" page.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_email)).getText(), "Invalid Email Address");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid Email Address\" below respective field."));
	}
	
	@Test(priority=18,description="To verify that user gets validation message for mismatch in entered \"Password\" and \"Confirm Password\" fields .")
	public void PV_UserManagement_19() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).sendKeys("Abc@123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Password\" in \"Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).sendKeys("Asd@123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter confirm password in \"Confirm Password\" text-box differ than entered \"Password\".");
		driver.findElement(By.xpath(UserManagement_repository.radio_btn_male)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_confipass)).getText(), "'Confirm Password' and 'Password' do not match.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"'Confirm Password' and 'Password' do not match.\"below respective field."));
	}
	
	@Test(priority=19,description="To verify that user gets validation message for entering invalid \"PIN Code\".")
	public void PV_UserManagement_20() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("11111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid PIN Code in \"PIN Code\" text-box and fill valid all other details in \"New User\" page.");
		driver.findElement(By.xpath(UserManagement_repository.radio_btn_male)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_PINcode)).getText(), "Invalid PIN Code");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid PIN Code\"below respective field."));
	}
	
	@Test(priority=20,description="To verify that user gets validation message for entering invalid \"Phone Number\".")
	public void PV_UserManagement_21() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("1999999999");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid Phone Number in \"Phone Number\" text-box and fill valid all other details in \"New User\" page.");
		driver.findElement(By.xpath(UserManagement_repository.radio_btn_male)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_phonenum)).getText(), "Invalid Mobile Number");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid Mobile Number\" below respective field."));
	}
	
	@Test(priority=21,description="To verify that user gets validation message when select \"Date Of Birth\" from date picker is greater than today.")
	public void PV_UserManagement_22() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		WebElement w1=driver.findElement(By.xpath(UserManagement_repository.txtbox_DOB));
		w1.sendKeys("01-12");
		w1.sendKeys(Keys.TAB);
		w1.sendKeys("2022");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Date Of Birth\" from date picker which is greater than today.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_DOB)).getText(), "Date of Birth must be Earlier than Today.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Date Of Birth must be Earlier than Today.\"below respective field."));
	}
	
	@Test(priority=22,description="To verify that user gets validation message when upload file in \"ID proof\" attachment is more than 2 mb.")
	public void PV_UserManagement_23() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Videos\\Captures\\test_video.mp4");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Browse\" button and upload file which size is more than 2 mb.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_fileupload)).getText(), "Invalid File Type");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid File Type\" below respective field."));
	}
	
	@Test(priority=23,description="To verify that user gets validation message for password format restrictions.")
	public void PV_UserManagement_24() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New User\" button from \"Users\" page.");
		driver.findElement(By.xpath(UserManagement_repository.op_citizen)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select radio button of \"Citizen\" type from \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Select Type Of User\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_username)).sendKeys("Test_112");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test112@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_pass)).sendKeys("12345");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_confipass)).sendKeys("12345");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		WebElement w1=driver.findElement(By.xpath(UserManagement_repository.txtbox_DOB));
		w1.sendKeys("01-05");
		w1.sendKeys(Keys.TAB);
		w1.sendKeys("1995");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.radio_btn_female)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Select any of Gender selection radio button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_state_Gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_city_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Browse\" button of \"ID Proof\" attachment field and Upload file from device.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(), "Passwords must be at least 6 characters., Passwords must have at least one non alphanumeric character., Passwords must have at least one lowercase ('a'-'z')., Passwords must have at least one uppercase ('A'-'Z').");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Passwords must be at least 6 characters., Passwords must have at least one non alphanumeric character., Passwords must have at least one lowercase ('a'-'z')., Passwords must have at least one uppercase ('A'-'Z').\"."));
	}
	
	@Test(priority=24,description="To verify that user is able to perform \"Search by Username or Email Address\" functionality of \"Users\" page.")
	public void PV_UserManagement_25() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("dep_user_1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter search criteria into \"Search by Username or Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on Seach button icon.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText(), "dep_user_1");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Users\" page."));
	}
	
	@Test(priority=25,description="To verify that user is able to perform Pagination functionality of \"Users\" page.")
	public void PV_UserManagement_26(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		int f=Integer.valueOf(c);
		System.out.println(c);
		driver.findElement(By.xpath(UserManagement_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 11 to 20 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of \"Users\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(UserManagement_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of \"Users\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		driver.findElement(By.xpath(UserManagement_repository.lnk_pageno_2)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Users\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 11 to 20 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get particular page no. of records in \"Users\" page."));
	}
	
	@Test(priority=26,description="To verify that user is able to select number of entries show in \"Users\" page from Show entries dropdown.")
	public void PV_UserManagement_27() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		int f=Integer.valueOf(c);
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from the \"Show No. of entries\" dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 25 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Users\" page."));
		
	}
	
	@Test(priority=27,description="To verify that user is able to get back to \"Home\" page from \"Users\" page by clicking on \"Home\" icon.")
	public void PV_UserManagement_28() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(),"Application Users");
		driver.findElement(By.xpath(UserManagement_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Home\" icon in \"Users\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(),"Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Users\" page."));
	}
	
	@Test(priority=28,description="To verify that user is able to perform sorting functionality for the \"Username\" , \"Email address\" , \"Phone Number\" , \"Id Proof\" ,\"First Name\" , \"Last Name\" , \"Date of Birth\", \"Age\" , \"Country\" , \"State\" , \"District\", \"PIN Code\" columns of \"Users\" page.")
	public void PV_UserManagement_29(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(2000,0)");
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Sorting\" icon of the \"Username\" column.");
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical order of \"Username\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Sorting\" icon of the \"Email address\" column.");
		String s4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical order of \"Email Address\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_phonenum)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_phonenum)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_phonenum)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Sorting\" icon of the \"Phone Number\" column.");
		String s6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_phonenum)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in numerical order of \"Phone Number\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_firstname)).click();
		Thread.sleep(1000);
		String s7=driver.findElement(By.xpath(UserManagement_repository.col_lbl_firstname)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_firstname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> :  Click on \"Sorting\" icon of the \"First Name\" column.");
		String s8=driver.findElement(By.xpath(UserManagement_repository.col_lbl_firstname)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical order of \"First Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_lastname)).click();
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_lastname)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_lastname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Sorting\" icon of the \"Last Name\" column.");
		String t2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_lastname)).getAttribute("aria-label");
		Assert.assertNotEquals(t1, t2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical order of \"Last Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_05");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_DOB)).click();
		Thread.sleep(1000);
		String t3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_DOB)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_DOB)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"Date of Birth\" column.");
		String t4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_DOB)).getAttribute("aria-label");
		Assert.assertNotEquals(t3, t4);
		ll.Screenshotnew(driver,i,method.getName()+"_06");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in sorting order of \"Date Of Birth\" data fields."));
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_age)).click();
		Thread.sleep(1000);
		String t5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_age)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_age)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Sorting\" icon of the \"Age\" column.");
		String t6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_age)).getAttribute("aria-label");
		Assert.assertNotEquals(t5, t6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in numerical order of \"Age\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_07");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_usertype)).click();
		Thread.sleep(1000);
		String t7=driver.findElement(By.xpath(UserManagement_repository.col_lbl_usertype)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_usertype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Sorting\" icon of the \"Country\" column.");
		String t8=driver.findElement(By.xpath(UserManagement_repository.col_lbl_usertype)).getAttribute("aria-label");
		Assert.assertNotEquals(t7, t8);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Users\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_08");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_state)).click();
		Thread.sleep(1000);
		String u1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_state)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_state)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Sorting\" icon of the \"State\" column.");
		String u2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_state)).getAttribute("aria-label");
		Assert.assertNotEquals(u1, u2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical order of \"State\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_09");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).click();
		Thread.sleep(1000);
		String u3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Sorting\" icon of the \"District\" column.");
		String u4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).getAttribute("aria-label");
		Assert.assertNotEquals(u3, u4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical order of \"District\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_10");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.scroll_to_hori));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).click();
		Thread.sleep(1000);
		String u5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"PIN Code\" column.");
		String u6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).getAttribute("aria-label");
		Assert.assertNotEquals(u5, u6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in sorting order of \"PIN Code\" data fields."));
	}
	
	@Test(priority=29,description="To verify that user is able to get \"Actions\" dropdown list.")
	public void PV_UserManagement_30() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\" button of particular user on which want to perform actions.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_savecitizen)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_claims)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_lock)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_changehistory)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Actions\" dropdown list with following :</br>"
				+ "\"Save As Police Personnel\",</br>"
				+ "\"Save As Citizen\",</br>"
				+ "\"Edit\", </br>"
				+ "\"Claims\",</br>"
				+ "\"Lock\" , </br>"
				+ "\"Permissions\",</br>"
				+ "\"Set Password\" ,</br> \"Delete\"."));
	}
	
	@Test(priority=30,description="To verify that user is able to save user as Police Personnel by clicking on \"Save As Police Personnel\" option from \"Actions\" dropdown.")
	public void PV_UserManagement_31(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Police Personnel\" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Police Personnel");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_badgeno_savepolicepersonnel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_reportmanager_savepolicepersonnel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_office_savepolicepersonnel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_designation_savepolicepersonnel)).isDisplayed(), true);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get \"New Police Personnel\" window with following:</br>"
				+ "1. Text-box : \"Badge Number\".</br>"
				+ "2. Dropdowns : \"Reporting Manager \", \"Office\", \"Designation\".</br>"
				+ "3. Buttons : \"Cancel\" , \"Save\" , \"X\"(close)."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_badgeno_savepolicepersonnel)).sendKeys("PS112");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Badge Number in \"Badge Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_reportmanager_savepolicepersonnel)).sendKeys("megh_thakkar");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Reporting Manager\" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_office_savepolicepersonnel)).sendKeys("Ambli Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Office\" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_designation_savepolicepersonnel)).sendKeys("Assistant Police Inspector");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Designation \" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Save\" button of \"New Police Personnel\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "Saved as Police Personnel");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_usertype)).getText(), "Department User");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : 1. User should able to click on \"Save\" button of \"New Police Personnel\" window and window should close.\r\n"
				+ "2. User should get toast validation like  \"Saved as Police Personnel\".\r\n"
				+ "3. User should saved as Department User type."));
	}
	
	@Test(priority=31,description="To verify that user is able to close \"New Police Personnel\" window.")
	public void PV_UserManagement_32() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Police Personnel\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"New Police Personnel\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Police Personnel\" window."));
	}
	
	@Test(priority=32,description="To verify that user is able to perform \"Cancel\" functionality of \"New Police Personnel\" window.")
	public void PV_UserManagement_33() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Police Personnel\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New Police Personnel\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newuser)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Police Personnel\" window and \"New Police Personnel\" window should close."));
	}
	
	@Test(priority=33,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Adding details in \"New Police Personnel\" window.")
	public void PV_UserManagement_34() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Police Personnel\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_badgeno_savepolicepersonnel)).sendKeys("PS001");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Badge Number in \"Badge Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_reportmanager_savepolicepersonnel)).sendKeys("megh_thakkar");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Reporting Manager\" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_office_savepolicepersonnel)).sendKeys("Ambli Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Office\" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_designation_savepolicepersonnel)).sendKeys("Assistant Police Inspector");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Designation \" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of \"New Police Personnel\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> :</br> 1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Police Personnel\" window should also close."));
	}
	
	@Test(priority=34,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Police Personnel\" window.")
	public void PV_UserManagement_35() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Police Personnel\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_badgeno_savepolicepersonnel)).sendKeys("PS001");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Badge Number in \"Badge Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_reportmanager_savepolicepersonnel)).sendKeys("megh_thakkar");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Reporting Manager\" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_office_savepolicepersonnel)).sendKeys("Ambli Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Office\" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_designation_savepolicepersonnel)).sendKeys("Assistant Police Inspector");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Designation \" from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of \"New Police Personnel\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Police Personnel\" window should display on screen."));
	}
	
	@Test(priority=35,description="To verify that user gets validation message when \"Save\" user as Police Personnel with blank mandatory details.")
	public void PV_UserManagement_36() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Police Personnel\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button without filling mandatory fields details.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_badgeno_policepersonnel)).getText(), "The Badge Number field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_office_policepersonnel)).getText(), "The Office field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_designation_policepersonnel)).getText(), "The Designation field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like :</br>"
				+ "\"The Badge Number field is required.\",</br>"
				+ "\"The Office field is required.\",</br>"
				+ "\"The Designation field is required.\"."));
	}
	
	@Test(priority=36,description="To verify that user gets validation message if save user as \"Police Personnel\" which is already saved as Police Personnel.")
	public void PV_UserManagement_37() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savepolicepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Police Personnel\" option from \"Actions\" dropdown of particular user which is already saved as police Personnel.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "User is already assign as Police Personnel");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"User is already assign as Police Personnel\"."));
	}
	
	@Test(priority=37,description="To verify that user is able to save user as citizen by clicking on \"Save As Citizen\"option from \"Actions\" dropdown.")
	public void PV_UserManagement_38() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savecitizen)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Citizen\" option from \"Actions\" dropdown of particular user which is already saved as police Personnel.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "User is saved as Citizen user");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_usertype)).getText(), "Citizen");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should get validation message like \"User Saved as Citizen user\".</br>"
				+ "2. User should saved as Citizen User type."));
	}
	
	@Test(priority=38,description="To verify that user gets validation message if save user as \"Citizen\" which is already saved as citizen user.")
	public void PV_UserManagement_39() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_savecitizen)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Save As Citizen\" option from \"Actions\" dropdown of particular user which is already saved as police Personnel.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "User is already saved as Citizen user");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"User is already saved as Citizen user\"."));
	}
	
	@Test(priority=39,description="To verify that user is able to \"Edit\" created user details by clicking on \"Edit\" option  from \"Actions\" dropdown.")
	public void PV_UserManagement_40() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Application User");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test112@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Valand");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Last Name in \"Last Name\" text-box.");
		WebElement w1=driver.findElement(By.xpath(UserManagement_repository.txtbox_DOB));
		w1.sendKeys("01-05");
		w1.sendKeys(Keys.TAB);
		w1.sendKeys("1998");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.radio_btn_female)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select any of Gender selection radio button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_state_Gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_city_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_IDprooftype_edit)).click();
		driver.findElement(By.xpath(UserManagement_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_fileupload)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Click on \"Browse\" button of \"ID Proof\" attachment field Upload file from device.");
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.btn_save));
		Coordinates co1 = ((Locatable)e1).getCoordinates();
		co1.onPage(); co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Click on \"Save\" button of \"Edit User\" window.");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText(), "Test_112");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit User\" window and window should close.</br>"
				+ "2. Edited details of user should update in  \"Users\" page accordingly."));
	}
	
	@Test(priority=40,description="To verify that user is able to check existing ID proof by clicking on \"Check Your Existing IdProof Here\" link from \"Edit User\" window.")
	public void PV_UserManagement_41(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular user.");
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.btn_save));
		Coordinates co1 = ((Locatable)e1).getCoordinates();
		co1.onPage(); co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_existing_idproof)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on \"Check Your Existing IdProof Here\" link.");
		String parent=driver.getWindowHandle();
		Set<String> s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		Thread.sleep(2000);
		String Title_child = driver.switchTo().window(child_window).getTitle();
		System.out.println(Title_child);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get existing \"Id Proof\" of user in new window tab."));
		}
		}
	}
	
	@Test(priority=41,description="To verify that user is able to close \"Edit User\" window.")
	public void PV_UserManagement_42() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Application User");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(2000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\"(close) button of \"Edit User\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit User\" window."));
	}
	
	@Test(priority=42,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit User\" window.")
	public void PV_UserManagement_43() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Application User");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Edit User\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit User\" window and \"Edit User\" window should close."));
	}
	
	@Test(priority=43,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Editing details in \"Edit User\" window.")
	public void PV_UserManagement_44() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test121@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\"/ button of \"Edit User\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit User\" window should also close."));
	}
	
	@Test(priority=44,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit User\" window.")
	public void PV_UserManagement_45() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid)).sendKeys("test121@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of \"Edit User\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit User\" window should display on screen."));
	}

	@Test(priority=48,description="To verify user is able to \"Save\" Lockout duration by clicking on \"Lock\" option from \"Actions\" dropdown.")
	public void PV_UserManagement_49(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_lock)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Lock \" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_lockoutduration)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_lockoutdurationtype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get \"Lock - username\" window with following:</br>"
				+ "1. Text-box: \"Lockout duration\" .(By default 0)</br>"
				+ "2.  Dropdown box: \"Lockout duration type\".(By Default second)</br>"
				+ "3. Buttons: \"Cancel\" , \"Save\", \"X\"(close)."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Lock - " + s1);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lockoutduration)).sendKeys("80");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Lockout duration\" value in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_lockoutdurationtype)).sendKeys("Minutes");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Lockout duration Type\" from respective dropdown box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"Lock - username\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"Save\" button of \"Lock-username\" window and lockout duration should update."));
	}
	
	@Test(priority=49,description="To verify that user is able to close \"Lock - username\" window.")
	public void PV_UserManagement_50() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_lock)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Lock \" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Lock - " + s1);
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\"(close) button of \"Lock - username\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Lock - username\"  window."));
	}
	
	@Test(priority=50,description="To verify that user is able to perform \"Cancel\" functionality of \"Lock - username\" window.")
	public void PV_UserManagement_51() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_lock)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Lock \" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Lock - " + s1);
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Lock - username\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Lock - username\" window and \"Lock - username\" window should close."));
	}
	
	@Test(priority=51,description="To verify that user gets validation message when \"Save\" Lockout duration with blank field.")
	public void PV_UserManagement_52() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_lock)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Lock \" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Lock - " + s1);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lockoutduration)).clear();
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button with blank Lockout duration field.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_lockoutduration)).getText(), "The Lockout duration field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like : \"The Lockout duration field is required.\"."));
	}
	
	@Test(priority=52,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Adding details in \"Lock-username\" window.")
	public void PV_UserManagement_53() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_lock)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Lock \" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Lock - " + s1);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lockoutduration)).sendKeys("80");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Lockout duration\" value in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_lockoutdurationtype)).sendKeys("Minutes");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Lockout duration Type\" from respective dropdown box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\"/\"X\"(close) button of \"Lock-username\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Lock-username\" window should also close."));
		
	}
	
	@Test(priority=52,description="To verify that user is able to \"Cancel\" validation message for unsaved changes.")
	public void PV_UserManagement_54() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_lock)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Lock \" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Lock - " + s1);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_lockoutduration)).sendKeys("80");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Lockout duration\" value in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_lockoutdurationtype)).sendKeys("Minutes");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Lockout duration Type\" from respective dropdown box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\"/\"X\"(close) button of \"Lock-username\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Lock-username\" window should display on screen."));
	}
	
	@Test(priority=54,description="To verify that user is able to get \"Permissions\" window.")
	public void PV_UserManagement_55() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions \" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Permissions - " +s1);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.account_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.auditlog_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.cms_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.crimemapp_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.databasconfi_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.featuremanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.filemanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.forms_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.identityserver_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.langmanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.leptontheam_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.saas_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.settingmanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.sglmapcom_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.sglpv_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txttemplate_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.usermanage_permisions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Permissions\" window with following : </br>"
				+ "1. Check boxes: \"Grant all permissions\" , \"Select all\".</br>"
				+ "2. Permission options: \r\n"
				+ "\"Account\" , \"Audit Logging\" , \"CmsKit\", \"Database Configurator\", \"Feature management\" ,\"File Management\" , \"Forms\", \"Identity management\", \"Identity Server\", \"Language Management\", \"Lepton Theme management\", \"Saas\", \"Setting Management\", \"SGLPV\", \"Text Template Management\".</br>"
				+ "3. Buttons: \"Cancel\" , \"Save\" , \"X\"(close)."));
	}
	
	@Test(priority=57,description="To verify that user is able to close \"Permissions\" window.")
	public void PV_UserManagement_58() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions \" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\"(close) button of \"Permissions\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Permissions\" window."));
	}
	
	@Test(priority=58,description="To verify that user is able to perform \"Cancel\" functionality of \"Permissions\" window.")
	public void PV_UserManagement_59() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions \" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Permissions\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Permissions\" window and \"Permissions\" window should close."));
		
	
	}
	
	@Test(priority=59,description="To verify that user gets validation message when perform \"Cancel\" functionality after Adding permissions in \"Permissions-username\" window.")
	public void PV_UserManagement_60() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.chbox_grantallpermissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select \"Grant all permissions\" checkbox for select all permissions.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Permissions-username\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Permissions-username\" window should also close."));
	}
	
	@Test(priority=60,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Permissions-username\" window.")
	public void PV_UserManagement_61() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions \" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.chbox_grantallpermissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select \"Grant all permissions\" checkbox for select all permissions.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Permissions-username\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Permissions-username\" window should displt on screen."));
	}
	
	@Test(priority=61,description="To verify that user is able to perform \"Set Password\" functionality.")
	public void PV_UserManagement_62(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Set Password - " +s1);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_newpass)).isDisplayed() , true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_generate_randompass)).isDisplayed() , true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed() , true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed() , true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed() , true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get \"Set Password\" window with following :</br>"
				+ "1. Text-box : \"Password\" .</br>"
				+ "2. Buttons : \"Generate Random Password\" icon , \"Cancel\" , \"Save\" , \"X\" (close)."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_newpass)).sendKeys("Abc@321");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Password in \"password\" text-box which user want to set.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Set Password\" window.");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(Login_repository.profile_admin))).
		build().perform(); Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.lnk_logout)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Test_112");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("Abc@321");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.profile_admin)).getText(), "Test_112");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : 1. User should able to click on \"Save\" button of \"Set Password\" window and window should close.</br>"
				+ "2. User should able to login with setted password."));
	}
	
	@Test(priority=62,description="To verify that user is able to close \"Set Password\" window.")
	public void PV_UserManagement_63() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\"(close) button of \"Set Password\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Set Password\"  window."));
	}
	
	@Test(priority=63,description="To verify that user is able to perform \"Cancel\" functionality of \"Set Password\" window.")
	public void PV_UserManagement_64() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Set Password\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Set Password\" window and \"Set Password\" window should close."));
	}
	
	@Test(priority=64,description="To verify that user is able to get random password in \"Password\" text-box by clicking on \"Generate Random Password\" icon button.")
	public void PV_UserManagement_65() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_generate_randompass)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Generate Random Password\" icon button.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.txtbox_newpass)).getText();
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get random password in \"Password\" text-box."));
	}
	
	@Test(priority=65,description="To verify that user gets validation message when perform \"Save\" functionality with blank details of \"Set Password\" window.")
	public void PV_UserManagement_66() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_pass_setpassword)).getText(), "The set password field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"The set password field is required.\"."));
	}
	
	@Test(priority=66,description="To verify that user gets validation message when perform \"Cancel\" functionality after Adding password in \"Set Password\" window.")
	public void PV_userManagement_67() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_newpass)).sendKeys("Abc@321");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Password in \"password\" text-box which user want to set.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Set Password\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Set Password\" window should also close."));
	}
	
	@Test(priority=67,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Set Password\" window.")
	public void PV_UserManagement_68() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
	driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
	driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(UserManagement_repository.lnk_setpassword)).click();
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
	driver.findElement(By.xpath(UserManagement_repository.txtbox_newpass)).sendKeys("Abc@321");
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter Password in \"password\" text-box which user want to set.");
	driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Set Password\" window.");
	Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
	Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
    Thread.sleep(1000);	
	driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
	Thread.sleep(1000);	
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of validation message popup.");
	Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
			+ "2. \"Set Password\" window should display on screen."));	
	}
	
	
	@Test(priority=68,description="To verify that user is able to \"Cancel\" validation message of delete User. ")
	public void PV_UserManagement_70() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
	driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
	driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
	Thread.sleep(1000);
	String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
	Thread.sleep(1000);
	driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).click();
	Thread.sleep(2000);	
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
	Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
	Assert.assertEquals("Are you sure you want to delete the user '" + s1 +"'?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
    Thread.sleep(1000);	
	driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
	Thread.sleep(1000);	
	ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=69,description="To verify that user is able to delete particular user by clicking on \"Delete\" option from \"Actions\" dropdown.")
	public void PV_UserManagement_69() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Users\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test_112");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Set Password\" option from \"Actions\" dropdown of particular user.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to delete the user '" + s1 +"'?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
	    Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and popup should close.</br>"
				+ "2. Selected user should be delete from portal."));
	}
	
	@Test(priority=70,description="To verify that user is able to get \"Application Roles\" page.")
	public void PV_UserManagement_71() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Roles");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.searchbox)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries)).isDisplayed(), true);
		List<WebElement> listElement = driver.findElements(By.xpath(UserManagement_repository.raw_datatable));
		
		System.out.println(listElement.size());
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		int f=Integer.valueOf(c);
		System.out.println(c);
		Assert.assertEquals(listElement.size(), f);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Roles\" page with following :</br>"
				+ "1. Buttons: \"New Role\" , \"Next\" , \"Previous\" ,  Page Control Numbers.</br>"
				+ "2. Text-box : \"Search\".</br>"
				+ "3. Table of users with following column fields:\r\n"
				+ "\"Actions\" , \"Role Name\".</br>"
				+ "4. Dropdowns: \"Actions\" button ,\"Show entries\" .</br>"
				+ "5. Links: \"Home\" icon."));
	}
	
	@Test(priority=71,description="To verify that user is able to get \"New Role\" window by performing \"+New Role\" functionality from \"Roles\" page.")
	public void PV_UserManagement_72() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.chbox_defalut_role)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.chbox_public_role)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Role\" window with following:</br>"
				+ "1. Text-box : \"Role name\".(mandatory)</br>"
				+ "2. Buttons: \"Cancel\", \"Save\" , \"X\"(close).</br>"
				+ "3. Checkboxes: \"Public\" , \"Default\"."));
	}
	
	@Test(priority=72,description="To verify that user is able to create \"New Role\" by performing \"+New Role\" functionality.")
	public void PV_UserManagement_73() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).sendKeys("Test role");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Role Name\" in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"New Role\" window.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_rolename)).getText(), "Test role");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Role\" window and window should close.</br>"
				+ "2. Added roles should display in list of \"Roles\" section of user."));
	}
	
	@Test(priority=73,description="To verify that user is able to close \"New Role\" window.")
	public void PV_UserManagement_74() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\"(close) button of \"New Role\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Role\"  window."));
	}
	
	@Test(priority=74,description="To verify that user is able to perform \"Cancel\" functionality of \"New Role\" window.")
	public void PV_UserManagement_75() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New Role\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Role\" window and \"New Role\" window should close."));
	}
	
	@Test(priority=75,description="To verify that user gets validation message when perform \"Save\" functionality with blank details of \"New Role\" window.")
	public void PV_UserManagement_76() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_rolename)).getText(), "The Role name field is required.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like :\r\n"
				+ "\"The Role name field is required.\"."));
	}
	
	@Test(priority=76,description="To verify that user gets validation message when create New Role which is already exist.")
	public void PV_UserManagement_77() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		Thread.sleep(1000);driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).sendKeys("Test role");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Role Name\" in respective text-box which is already exist.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"New Role\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(), "Role name 'Test role' is already taken.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Role name 'Test role' is already taken.\"."));
	}
	
	@Test(priority=77,description="To verify that user gets validation message when perform \"Cancel\" functionality after Adding details in \"New Role\" window.")
	public void PV_UserManagement_78() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		Thread.sleep(1000);driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).sendKeys("Test role");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Role Name\" in respective text-box which is already exist.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"New Role\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Role\" window should also close."));
	}
	
	@Test(priority=78,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Role\" window.")
	public void PV_UserManagement_79() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newrole)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Role\" button from \"Roles\" page.");
		Thread.sleep(1000);driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).sendKeys("Test role");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Role Name\" in respective text-box which is already exist.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"New Role\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New role");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Role\" window should display on screen."));
	}
	
	@Test(priority=79,description="To verify that user is able to perform \"Search\" functionality of \"Roles\" page.")
	public void PV_UserManagement_80() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter search criteria into \"Search\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on search icon button.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_rolename)).getText(), "Test role");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Roles\" page."));
	}
	
	@Test(priority=82,description="To verify that user is able to get back to \"Home\" page from \"Roles\" page by clicking on \"Home\" icon.")
	public void PV_UserManagement_83() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Roles");
		driver.findElement(By.xpath(UserManagement_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Home\" icon in \"Roles\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Roles\" page."));
	}
	
	@Test(priority=83,description="To verify that user is able to perform \"Edit\" functionality of particular role.")
	public void PV_UserManagement_84() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).sendKeys("Test role 1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Role name\" in Role name text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"Edit\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_rolename)).getText(), "Test role 1");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User is able to click on \"Edit\" window and window should close.</br>"
				+ "2. Edited details should update on portal."));
	}
	
	@Test(priority=84,description="To verify that user is able to close \"Edit\" window.")
	public void PV_UserManagement_85() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"X\"(close) button of \"Edit\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit\"  window."));
	}
	
	@Test(priority=85,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit\" window.")
	public void PV_UserManagement_86() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Edit\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit\" window and \"Edit\" window should close."));
	}
	
	@Test(priority=86,description="To verify that user gets validation message when perform \"Cancel\" functionality after Editing details in \"New Role\" window.")
	public void PV_UserManagement_87() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).sendKeys("Test");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Role name\" in Role name text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Edit\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit\" window should also close."));
	}
	
	@Test(priority=87,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit\" window of Role.")
	public void PV_UserManagement_88() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_rolename)).sendKeys("Test");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Role name\" in Role name text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Edit\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit\" window should display on screen."));
	}
	
	@Test(priority=91,description="To verify user is able perform \"Permissions\" functionality for particular role by clicking on \"Permissions\" option from \"Actions\" dropdown.")
	public void PV_UserManagement_92() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_rolename)).getText();
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Permissions - " + s1);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.account_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.auditlog_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.cms_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.crimemapp_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.databasconfi_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.featuremanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.filemanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.forms_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.identityserver_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.langmanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.leptontheam_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.saas_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.settingmanage_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.sglmapcom_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.sglpv_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txttemplate_permissions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.usermanage_permisions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		
	}
	
	@Test(priority=93,description="To verify that user is able to close \"Permissions-Role\" window of particular role.")
	public void PV_UserManagement_94() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\"(close) button of \"Permissions - Role\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Permissions - Role\"  window."));
	}
	

	@Test(priority=94,description="To verify that user is able to perform \"Cancel\" functionality of \"Permissions - Role\" window.")
	public void PV_UserManagement_95() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions\" option from \"Actions\" dropdown of particular role from list.");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.btn_cancel));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Permissions - Role\"  window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Permissions - Role\" window and \"Permissions - Role\" window should close."));
	}
	
	@Test(priority=95,description="To verify that user gets validation message when perform \"Cancel\" functionality after adding permissions in \"Permissions-Role\" window.")
	public void PV_UserManagement_96() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.chbox_grantallpermissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select \"Grant all Permissions\"check-box.");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.btn_cancel));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Permissions-Role\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Permissions-Role\" window should also close."));
	}
	
	@Test(priority=96,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Permissions\" window of Role.")
	public void PV_UserManagement_97() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_permissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Permissions\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.chbox_grantallpermissions)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select \"Grant all Permissions\"check-box.");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.btn_cancel));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Permissions-Role\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Permissions\" window should display on screen."));
	}
	
	@Test(priority=98,description="To verify that user is able to delete particular role from \"Roles\" page by clicking on \"Delete\" option from \"Actions\" dropdown.")
	public void PV_userManagement_98() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Delete\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to delete the role 'Test role 1'?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and popup should close.</br>"
				+ "2. Selected role should be delete from portal."));
	}
	
	@Test(priority=97,description="To verify that user is able to \"Cancel\" validation message of delete role. ")
	public void PV_UserManagement_99() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Approles)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Application Roles\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("Test role 1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Delete\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to delete the role 'Test role 1'?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=99,description="To verify that user is able to get \"Designations\" page.")
	public void PV_UserManagement_100() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Designations");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_code)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_description)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries)).isDisplayed(), true);
		List<WebElement> l1=driver.findElements(By.xpath(UserManagement_repository.raw_datatable));
		
		String a=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		String[] b=a.split("");
		String c=b[5];
		int d=Integer.valueOf(c);
		Assert.assertEquals(l1.size(), d);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Designations\" page with following :</br>"
				+ "1. Buttons : \"+New Designation\" , \"Next\" , \"Previous\" ,  Page Control Numbers.</br>"
				+ "2. Table of users with following column fields :\r\n"
				+ "\"Actions\" , \"Name\", \"Code\" , \"Description\".</br>"
				+ "3. Dropdowns: \"Actions\" button ,\"Show entries\" .</br>"
				+ "4. Link : \"Home\" icon."));
		
	}
	
	@Test(priority=100,description="To verify that user is able to get \"New Designation\" window by performing \"+New Designation\" functionality from Designations page.")
	public void PV_UserManagement_101() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_description_newdesignation)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Designation\" window with following :</br>"
				+ "1. Text-boxes : \"Name\" , \"Code\",\"Description\".</br>"
				+ "2. Buttons : \"Cancel\", \"Save\" , \"X\"(close)."));
	}
	
	@Test(priority=101,description="To verify that user is able to create \"New Designation\" by performing \"+New Designation\" functionality.")
	public void PV_UserManagement_102() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).sendKeys("Test Designation");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Designation Name\" in \"Designation Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).sendKeys("TD01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter \"Code\" in \"Code\" text-box. ");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_description_newdesignation)).sendKeys("Test Designation functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button of \"New Designation\" window.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_designation)).getText(), "Test Designation");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Designation\" window and window should close.</br>"
				+ "2. Added designation should display in list of \"Designations\" page."));
	}
	
	@Test(priority=102,description="To verify that user is able to close \"New Designation\" window.")
	public void PV_UserManagement_103() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\" (close) button of \"New Designation\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Designation\"  window."));
	}
	
	@Test(priority=103,description="To verify that user is able to perform \"Cancel\" functionality of \"New Designation\" window.")
	public void PV_UserManagement_104() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New Designation\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Designation\" window and \"New Designation\" window should close."));
	}
	
	@Test(priority=104,description="To verify that user gets validation message when perform \"Save\" functionality with blank details of \"New Designation\" window.")
	public void PV_UserManagement_105() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button without entering \"Role name\" value.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_designationname)).getText(), "The Designation Name field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_code)).getText(), "The Code field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like :</br>"
				+ "\"The Name field is required.\",</br>"
				+ "\"The Code field is required.\" below their respective fields."));
	}
	
	@Test(priority=105,description="To verify that user gets validation message when create \"New Designation\" with already exist data.")
	public void PV_UserManagement_106(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).sendKeys("Test Designation");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Designation Name\" in \"Designation Name\" text-box which is already exist.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).sendKeys("TD01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter \"Code\" in \"Code\" text-box. ");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_description_newdesignation)).sendKeys("Test Designation functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button of \"New Designation\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(), "Designation name : Test Designation already exists.");
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like : \r\n"
				+ "\"Designation name : Test Designation already exists.\"."));
		driver.findElement(By.xpath(UserManagement_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"OK\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : </br>1. User should able to click on \"OK\" button of validation message popup and popup should close.</br>"
				+ "2. \"New Designation\" window should disply on screen."));
		
	}
	
	@Test(priority=106,description="To verify that user gets validation message when perform \"Cancel\" functionality after adding details in \"New Designation\" window.")
	public void PV_UserManagement_107() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).sendKeys("Test Designation");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Designation Name\" in \"Designation Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).sendKeys("TD01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter \"Code\" in \"Code\" text-box. ");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_description_newdesignation)).sendKeys("Test Designation functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"New Designation\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Designation\" window should also close."));
	}
	
	@Test(priority=107,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Designation\" window.")
	public void PV_UserManagement_108() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newdesignation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+New Designation\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).sendKeys("Test Designation");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter \"Designation Name\" in \"Designation Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).sendKeys("TD01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter \"Code\" in \"Code\" text-box. ");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_description_newdesignation)).sendKeys("Test Designation functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter \"Description\" in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"New Designation\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Designation\" window should display on screen."));
	}
	
	@Test(priority=108,description="To verify that user is able to perform Pagination functionality of \"Designations\" page.")
	public void PV_UserManagement_109(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		String a=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		String b=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(a, b);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of \"Designations\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		String c=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(c, b);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of \"Designations\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.lnk_pageno_2)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Designations\" page.");
		String d=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(a, d);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get particular page no. of records in \"Designations\" page."));
	}
	
	@Test(priority=109,description="To verify that user is able to select number of entries show in \"Roles\" page from Show entries dropdown.")
	public void PV_UserManagement_110() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		String a=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).click();
		driver.findElement(By.xpath(UserManagement_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from the \"Show No. of entries\" dropdown list.");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		String b=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(a, b);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Designations\" page."));
	}
	
	@Test(priority=110,description="To verify that user is able to get back to \"Home\" page from \"Designations\" page by clicking on \"Home\" icon.")
	public void PV_UserManagement_111() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Designations");
		driver.findElement(By.xpath(UserManagement_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Home\" icon in \"Designations\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Designations\" page."));
	}
	
	@Test(priority=111,description="To verify that user is able to perform sorting functionality for the \"Name\" ,  \"Code\"  of \"Designations\" page.")
	public void PV_UserManagement_112(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on Sorting icon of the \"Designation Name\" column.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in alphabetical order of \"Designation Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_code)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on Sorting icon of the \"Code\" column.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_code)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_code)).click();
		Thread.sleep(1000);
		String s4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_code)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in sorting order of \"Code\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_description)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on Sorting icon of the \"Description\" column.");
		String s5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_description)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_description)).click();
		Thread.sleep(1000);
		String s6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_description)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Description\" data fields."));
	}
	
	@Test(priority=112,description="To verify that user is able to perform \"Edit\" functionality of particular designation from list of \"Designations\" page.")
	public void PV_UserManagement_113() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Designation");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).sendKeys("Test Edit Designation");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Designation Name\" in \"Designation Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).sendKeys("TD11");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit \"Code\" in \"Code\" text-box. ");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"Edit Designation\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_designation)).getText(), "Test Edit Designation");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Designation\" window and window should close.</br>"
				+ "2. Edited designation should update on portal and display in list of \"Designations\" page."));
	}
	
	@Test(priority=113,description="To verify that user is able to close \"Edit Designation\" window.")
	public void PV_UserManagement_114() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\" (close) button of \"Edit Designation\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Update Designation\"  window."));
	}
	
	@Test(priority=114,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Designation\" window.")
	public void PV_UserManagement_115() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Edit Designation\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Designation\" window and \"Edit Designation\" window should close."));
	}
	
	@Test(priority=115,description="To verify that user gets validation message when perform \"Cancel\" functionality after editing details in \"Edit Designation\" window.")
	public void PV_UserManagement_116() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).sendKeys("Test Designation");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Designation Name\" in \"Designation Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).sendKeys("TD01");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit \"Code\" in \"Code\" text-box. ");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Edit Designation\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Designation\" window should also close."));
	}
	
	@Test(priority=116,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Designation\" window.")
	public void PV_UserManagement_117() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_designationname)).sendKeys("Test Designation");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit \"Designation Name\" in \"Designation Name\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_code)).sendKeys("TD01");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit \"Code\" in \"Code\" text-box. ");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Edit Designation\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Designation\" window should display on screen."));
	}
	
	@Test(priority=118,description="To verify that user is able to delete particular designation from \"Designations\" page by clicking on \"Delete\" option from \"Actions\" dropdown.")
	public void PV_UserManagement_118() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Delete\" option from \"Actions\" dropdown of particular designation from list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and popup should close.</br>"
				+ "2. User should get toast validation like \"Successfully discarded!\".</br>"
				+ "3. Selected designation should be delete from portal."));
		
	}
	
	@Test(priority=117,description="To verify that user is able to \"Cancel\" validation message of delete record of designation. ")
	public void PV_UserManagement_119() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Designations\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designationname)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Delete\" option from \"Actions\" dropdown of particular designation from list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=119,description="To verify that user is able to get \"Police Personnel\" page.")
	public void PV_UserManagement_120() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Police Personnel");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_badgeno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_designation)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_reportingmanager)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_disctrictname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries)).isDisplayed(), true);
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).click();
		driver.findElement(By.xpath(UserManagement_repository.entries_100)).click();
		Thread.sleep(2000);
		List<WebElement> l1=driver.findElements(By.xpath(UserManagement_repository.raw_datatable));
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).click();
		driver.findElement(By.xpath(UserManagement_repository.entries_100)).click();
		Thread.sleep(2000);
		List<WebElement> l2=driver.findElements(By.xpath(UserManagement_repository.depuser_entries_appusers));
		Assert.assertEquals(l1.size(), l2.size());
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Police Personnel\" page with following :</br>"
				+ "1. List of \"Police Personnel\" users.</br>"
				+ "2. Table of Police Personnel users with following column fields :"
				+ "\"Actions\" , \"Username\", \"Badge Number\" , \"Designation\", \"Reporting Manager\" , \"Office\" , \"Office Type\" , \"DistrictName\".</br>"
				+ "3. Buttons: \"Next\" , \"Previous\" ,  Page Control Numbers.</br>"
				+ "4. Dropdown: \"Actions\" button ,\"Show entries\".</br>"
				+ "5. Links : \"Home\" icon."));
	}
	
	@Test(priority=120,description="To verify that user is able to perform Pagination functionality of \"Police Personnel\" page.")
	public void PV_UserManagement_121(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		String a=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		String b=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(a, b);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of \"Police Personnel\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		String c=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(c, b);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of \"Police Personnel\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.lnk_pageno_2)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Police Personnel\" page.");
		String d=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(a, d);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get particular page no. of records in \"Police Personnel\" page."));
	}
	
	@Test(priority=121,description="To verify that user is able to select number of entries show in \"Police Personnel\" page from Show entries dropdown.")
	public void PV_UserManagement_122() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		String a=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).click();
		driver.findElement(By.xpath(UserManagement_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from the \"Show No. of entries\" dropdown list.");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		String b=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(a, b);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Police Personnel\" page."));
	}
	
	@Test(priority=122,description="To verify that user is able to get back to \"Home\" page from \"Police Personnel\" page by clicking on \"Home\" icon.")
	public void PV_UserManagement_123() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Police Personnel");
		driver.findElement(By.xpath(UserManagement_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Home\" icon in \"Police Personnel\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Police Personnel\" page."));
	}
	
	@Test(priority=123,description="To verify that user is able to perform sorting functionality for the \"Username\" ,  \"Badge Number\" , \"Designation\", \"Reporting Manager\" , \"Office\" , \"Office Type\" , \"DistrictName\" of \"Police Personnel\" page.")
	public void PV_UserManagement_124(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on sorting icon of the \"Username\" column.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in alphabetical order of \"Username\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_badgeno)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on sorting icon of the \"Badge Number\" column.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_badgeno)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_badgeno)).click();
		Thread.sleep(1000);
		String s4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_badgeno)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in sorting order of \"Badge Number\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of the \"Designation\" column.");
		String s5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_designation)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_designation)).click();
		Thread.sleep(1000);
		String s6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_designation)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Designation\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_reportingmanager)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of the \"Reporting Manager\" column.");
		String t1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_reportingmanager)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_reportingmanager)).click();
		Thread.sleep(1000);
		String t2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_reportingmanager)).getAttribute("aria-sort");
		Assert.assertNotEquals(t1, t2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in alphabetical order of \"Reporting Manager\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of the \"Office\" column.");
		String t3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).click();
		Thread.sleep(1000);
		String t4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).getAttribute("aria-sort");
		Assert.assertNotEquals(t3, t4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_5</b> : User should get records in alphabetical order of \"Office\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_05");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Office Type\" column.");
		String t5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).click();
		Thread.sleep(1000);
		String t6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).getAttribute("aria-sort");
		Assert.assertNotEquals(t5, t6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_6</b> : User should get records in alphabetical order of \"Office Type\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_06");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_disctrictname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on sorting icon of the \"DistrictName\" column.");
		String t7=driver.findElement(By.xpath(UserManagement_repository.col_lbl_disctrictname)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_disctrictname)).click();
		Thread.sleep(1000);
		String t8=driver.findElement(By.xpath(UserManagement_repository.col_lbl_disctrictname)).getAttribute("aria-sort");
		Assert.assertNotEquals(t7, t8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_7</b> : User should get records in alphabetical order of \"DistrictName\" data fields."));
		
	}
	
	@Test(priority=124,description="To verify that user is able to perform \"Edit\" functionality of particular Police Personnel user.")
	public void PV_UserManagement_125() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText();
		System.out.println(s1);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Police Personnel Information");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_policepersonnel_username)).getAttribute("value"), s1);
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_reportingmana)).sendKeys("dep_user_1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Change selection of \"Reporting Manager\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_office)).sendKeys("Gota Police Chawki");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Change selection of \"Office\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_designation)).sendKeys("Assistant Police Sub Inspector");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Change selection of \"Designation\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button of \"Edit Police Personnel Information\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of  \"Edit Police Personnel Information\" window and window should close.</br>"
				+ "2. Edited details of Police Personnel should update."));
	}
	
	@Test(priority=125,description="To verify that user is able to close \"Edit Police Personnel Information\" window.")
	public void PV_UserManagement_126() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"X\" (close) button of \"Edit Police Personnel Information\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Police Personnel Information\"  window."));
	}
	
	@Test(priority=126,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Police Personnel Information\" window.")
	public void PV_UserManagement_127() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Edit Police Personnel Information\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Police Personnel Information\" window and \"Edit Police Personnel Information\" window should close."));
	}
	
	@Test(priority=127,description="To verify that user gets validation message when perform \"Cancel\" functionality after editing details in \"Edit Police Personnel Information\" window.")
	public void PV_UserManagement_128() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_reportingmana)).sendKeys("dep_user_2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Change selection of \"Reporting Manager\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_office)).sendKeys("Jodhpur Police Chawki");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Change selection of \"Office\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_designation)).sendKeys("Assistant Police Sub Inspector");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Change selection of \"Designation\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"Edit  Police Personnel Information\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Police Personnel Information\" window should also close."));
	}
	
	@Test(priority=128,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Police Personnel Information\" window.")
	public void pV_UserManagement_129() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from \"Actions\" dropdown of particular role from list.");  
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_reportingmana)).sendKeys("dep_user_2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Change selection of \"Reporting Manager\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_office)).sendKeys("Jodhpur Police Chawki");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Change selection of \"Office\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.dd_policepersonnel_designation)).sendKeys("Assistant Police Sub Inspector");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Change selection of \"Designation\" from respective dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"Edit  Police Personnel Information\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Police Personnel Information\" window shouldn't close."));
	}
	
	@Test(priority=129,description="To verify that user is able to \"Cancel\" validation message of delete record of user's Police Personnel Information. ")
	public void PV_UserManagement_131() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You want to delete Police Personnel Information?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=130,description="To verify that user is able to delete particular Police Personnel user from \"Police Personnel\" page by clicking on \"Delete\" option from \"Actions\" dropdown.")
	public void PV_UserManagement_130() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_PolicePersonnel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Police Personnel\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_username_policepersonnel)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"Actions\"-> \"Discard\" option from \"Actions\" dropdown of particular role from list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You want to delete Police Personnel Information?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and popup should close.</br>"
				+ "2. Selected Police Personnel user should be delete."));
	}
	
	
	
	@Test(priority=131,description="To verify that user is able to get \"Organization Units\" page.")
	public void PV_UserManagement_132() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Organization Units");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.sec_orgtree)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.tab_roles_orgunits)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.orguser_mememptyinfo)).getText(), "Select an organization unit to see members");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Organization Units\" page with following :</br>"
				+ "1. Sections: \"Organization tree\" , \"Members\" , \"Roles\", \"Offices\".</br>"
				+ "2. Buttons:  \"Add root unit\".</br>"
				+ "3. \"Member\" section is by default selected and display \"Select an organization unit to see members \" message."));
	}
	
	@Test(priority=132,description="To verify that user is able to navigate to \"Home Page\" from \"Organization Units\" page.")
	public void PV_UserManagement_133() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Organization Units");
		driver.findElement(By.xpath(UserManagement_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on home icon \"Home\" from \"Organization Units\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Organization Units\" page."));
	}
	
	@Test(priority=133,description="To verify that user is able to get \"Add root unit\" window by performing \"Add root unit\" functionality from \"Organization Units\" page.")
	public void PV_UserManagement_134() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+Add root unit\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New organization unit");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New organization unit\" window with following :</br>"
				+ "1. Text-box : \"Display name * \".</br>"
				+ "2. Buttons: \"Cancel\" , \"Save\" , \"X\"(close)."));
	}
	
	@Test(priority=134,description="To verify that user is able to close \"New organization unit\" window.")
	public void PV_UserManagement_135() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"+Add root unit\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"X\"(close) button of \"New organization unit\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New organization unit\" window."));
	}
	
	@Test(priority=135,description="To verify that user is able to perform \"Cancel\" functionality of \"New organization unit\" window.")
	public void PV_UserManagement_136() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+Add root unit\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New organization unit\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New organization unit\" window and \"New organization unit\" window should close."));
	}
	
	@Test(priority=136,description="To verify that user is able to perform \"Add root unit\" functionality.")
	public void PV_UserManagement_137() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+Add root unit\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test Organization unit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter display name in \"Display Name\" textbox.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"New Organization Units\".");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.added_orgunit));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.added_orgunit)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to get added new organization unit in \"Organization Tree\" section of \"Organization Units\" page."));
	}
	
	@Test(priority=137,description="To verify that user is not able to perform \"Add root unit\" functionality without entering mandatory details.")
	public void PV_UserManagement_138() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+Add root unit\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button of \"New Organization Units\" without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_dispname_orgunit)).getText(), "The Display name field is required.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"The Display name field is required.\"."));
	}
	
	@Test(priority=138,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Adding details in \"New organization unit\" window.")
	public void PV_UserManagement_139() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+Add root unit\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test Organization unit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter display name in \"Display Name\" textbox.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"New organization unit\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New organization unit\" window should also close."));
	}
	
	@Test(priority=139,description="To verify that user is able to \"Cancel\" validation message for unsaved changes.")
	public void PV_UserManagement_140() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+Add root unit\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test Organization unit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter display name in \"Display Name\" textbox.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"New organization unit\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New organization unit\" window should display on screen."));
	}
	
	@Test(priority=140,description="To verify that user gets validation message when create New Organization Unit which is already exist.")
	public void PV_userManagement_141(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrootunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"+Add root unit\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test Organization unit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter display name in \"Display Name\" textbox which is already exist.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button of \"New Organization Unit\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(), "There is already an organization unit with name Test Organization unit. Two units with same name can not be created in same level.");
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get validation message like \"There is already an organization unit with name Test Unit. Two units with same name can not be created in same level.\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"OK\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should able to click on \"OK\" button  of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=141,description="To verify that user is able to get dropdown list by clicking on down arrow of any one of the organization unit from \"Organization tree\" section.")
	public void PV_UserManagement_142() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.added_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addsubunit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addrole)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addoffice)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get dropdown list with following : </br>"
				+ "\"Edit\", \"Add sub-unit\", \"Add member\", \"Add role\", \"Add Office\",\"Delete\"."));
	}
	
	@Test(priority=142,description="To verify that user is able to perform \"Edit\" functionality from dropdown list of particular organization unit of particular organization unit.")
	public void PV_UserManagement_143() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.added_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Edit\" functionality from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test Edit orgunit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit display name from \"Display Name\" textbox.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"Edit\" window.");
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. \"Edit\" window should close.</br>"
				+ "2. User should get edited data in \"Organization tree\" section."));
	}
	
	@Test(priority=143,description="To verify that user is able to close \"Edit\" window of particular Organization Unit.")
	public void PV_UserManagement_144() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Edit\" functionality from dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on close icon \"X\" of \"Edit\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit\" window."));
	}
	
	@Test(priority=144,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit\" window of particular Organization Unit.")
	public void PV_userManagement_145() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Edit\" functionality from dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Edit\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit\" window and \"Edit\" window should close."));
	}
	
	@Test(priority=145,description="To verify that user gets validation message when perform \"Cancel\" functionality after Editing details in \"Edit\" window.")
	public void PV_UserManagement_146() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Edit\" functionality from dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test OrganizationUnit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit display name from \"Display Name\" textbox.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"New organization unit\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New organization unit\" window should also close."));
	}
	
	@Test(priority=146,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit\" window.")
	public void PV_UserManagement_147() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Edit\" functionality from dropdown list.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test OrganizationUnit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit display name from \\\"Display Name\\\" textbox.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"New organization unit\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New organization unit\" window should display on screen."));
	}
	
	@Test(priority=147,description="To verify that user is able to perform \"Add sub-unit\" functionality from dropdown list of particular organization unit of particular Organization unit.")
	public void PV_UserManagement_148() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addsubunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add sub-unit\" functionality from dropdown list of particular organization unit.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_dispname_orgunit)).sendKeys("Test subunit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter display name in \"Display Name\" textbox.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"New organization unit\" window.");
		WebElement l2 = driver.findElement(By.xpath(UserManagement_repository.added_subunit));
		Coordinates co1=((Locatable)l2).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.added_subunit)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. \"New organization unit\" window should close.</br>"
				+ "2. User should get added sub-unit of particular organization unit in \"Organization tree\" section."));
		
	}
	
	@Test(priority=148,description="To verify that user is able to close \"New organization unit\" window of \"Add sub-unit\" functionality.")
	public void PV_UserManagement_149() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addsubunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add sub-unit\" functionality from dropdown list of particular organization unit.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on close icon \"X\"(close) of \"New organization unit\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New organization unit\" window."));
	}
	
	@Test(priority=149,description="To verify that user is able to perform \"Cancel\" functionality of  \"New organization unit\" window of \"Add sub-unit\" functionality.")
	public void PV_UserManagement_150() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addsubunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add sub-unit\" functionality from dropdown list of particular organization unit.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"New organization unit\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New organization unit\" window and \"New organization unit\" window should close."));
	}
	
	@Test(priority=150,description="To verify that user is able to get list of functionalities by clicking on downside arrow of added sub-unit of particular \"Organization Unit\".")
	public void PV_UserManagement_151() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.added_subunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of added sub-unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addsubunit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addrole)).isDisplayed(), true);
		//Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_addoffice)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get dropdown list of following functionality :</br>"
				+ "\"Edit\", \"Add sub-unit\", \"Add member\", \"Add role\", \"Delete\"."));
	}
	
	@Test(priority=151,description="To verify that user is able to perform \"Add member\" functionality from dropdown list of particular organization unit.")
	public void PV_UserManagement_152() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add member\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("admin");
		driver.findElement(By.xpath(UserManagement_repository.chbox_user_admin)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select checkbox of member from \"Select users\" window.");
		WebElement l3 = driver.findElement(By.xpath(UserManagement_repository.btn_save1));
		Coordinates co2=((Locatable)l3).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"Select users\" window.");
		WebElement l2 = driver.findElement(By.xpath(UserManagement_repository.added_subunit));
		Coordinates co1=((Locatable)l2).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText(),"admin" );
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. \"Select users\" window should close.</br>"
				+ "2. User should able to view added member in \"Members\" section of \"Organization Units\" page."));
	}
	
	@Test(priority=152,description="To verify that user is able to close \"Select users\" window of \"Add member\" functionality.")
	public void PV_UserManagement_153() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add member\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on close icon (\"X\") of \"Select users\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Select users\" window."));
	}
	
	@Test(priority=153,description="To verify that user is able to perform \"Cancel\" functionality of \"Select users\" window.")
	public void PV_UserManagement_154() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add member\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel1)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Select users\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Select users\" window and \"Select users\" window should close."));
	}
	
	
	@Test(priority=154,description="To verify that user is able to perform \"Search\" functionality from \"Select Users\" window.")
	public void pV_UserManagement_155() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add member\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("dep_user_1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter search criteria in \"Search\" textbox.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText(), "dep_user_1");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to get searched result in \"Select users\" window."));
	}
	
	@Test(priority=155,description="To verify that user is able to perform pagination functionality from \"Select users\" window.")
	public void PV_UserManagement_156(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add member\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Next\" button of \"Select users\" window.");
		String s2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get next page records in \"Select users\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Previous\" button of \"Select users\" window.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s2, s3);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get previous page records in \"Select users\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.lnk_pageno_3)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on any particular page No. of \"Select users\" window.");
		String s4=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should redirect to selected page Np. In \"Select users\" window."));
	}
	
	@Test(priority=156,description="To verify that user is able to change number of records from \"Select users\" window.")
	public void PV_UserManagement_157() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add member\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		int f=Integer.valueOf(c);
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select number from \"Show entries\" dropdown.");
		WebElement l2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries));
		Coordinates co1=((Locatable)l2).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 25 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Select users\" window."));
	}
	
	@Test(priority=157,description="To verify that user is able to perform sorting functionality for \"User name\" ,\"Email address\" column .")
	public void PV_UserManagement_158(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add member\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of \"User name\" column of \"Select users\" window.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).getAttribute("style");
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get records of users in alphabetical sorting order of \"Username\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).click();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).getAttribute("style");
		Assert.assertNotEquals(s1, s2);
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of \"Email address\" column of \"Select users\" window.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).getAttribute("style");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).click();
		Thread.sleep(1000);
		String s4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).getAttribute("style");
		Assert.assertNotEquals(s3, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get records of users in alphabetical sorting order \"Email Address\"."));
	}
	
	@Test(priority=158,description="To verify that user is able to perform \"Add role\" functionality from dropdown list of particular organization unit.")
	public void PV_UserManagement_159() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add role\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select roles");
		driver.findElement(By.xpath(UserManagement_repository.chbox_role_depuser)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select checkbox of role from \"Select roles\" window.");
		WebElement l3 = driver.findElement(By.xpath(UserManagement_repository.btn_save1));
		Coordinates co2=((Locatable)l3).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"Select roles\" window.");
		WebElement l2 = driver.findElement(By.xpath(UserManagement_repository.added_subunit));
		Coordinates co1=((Locatable)l2).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select respected organization unit from \"Organization Tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_roles_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Roles\" tab from \"Organization Unit\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_role_rolesec)).getText(),"Departmental User");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to view added role in \"Roles\" section of \"Organization Units\" page."));
		
	}
	
	@Test(priority=159,description="To verify that user is able to close \"Select roles\" window of \"Add role\" functionality.")
	public void PV_UserManagement_160() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add role\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select roles");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on close(\"X\") icon  of \"Select roles\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Select roles\" window."));
	}
	
	@Test(priority=160,description="To verify that user is able to perform \"Cancel\" functionality of \"Add role\" window.")
	public void PV_UserManagement_161() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add role\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select roles");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> :  Click on \"Cancel\" button of \"Add role\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Add role\" window and \"Add role\" window should close."));
	}
	
	@Test(priority=163,description="To verify that user is able to perform sorting functionality for \"Role name\"column .")
	public void PV_UserManagement_164() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_addrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add role\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select roles");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of \"Role name\" column from \"Select roles\" window.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).click();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records of roles in alphabetical sorting order of \"Role name\"."));
	}
	
	@Test(priority=166,description="To verify that user is able to get \"Members\" section of Organization unit.")
	public void PV_UserManagement_167() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_addmember)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_previous)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Members\" section with following : </br>"
				+ "1. Buttons: \"Add member\", \"Delete\", \"Previous\", \"Next\", page control buttons.</br>"
				+ "2. Textbox: \"SEARCH\".</br>"
				+ "3. Dropdown: \"Show entries\"."));
	}
	
	@Test(priority=167,description="To verify that user is able to perform \"+Add member\" functionality of \"Member\" section.")
	public void PV_UserManagement_168() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_addmember)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Add member\" button from \"Members\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("dep_user_1");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.chbox_user_depuser1)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select checkbox of member from \"Select users\" window.");
		WebElement l3 = driver.findElement(By.xpath(UserManagement_repository.btn_save1));
		Coordinates co2=((Locatable)l3).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"Select users\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. \"Select users\" window should close.</br>"
				+ "2. User should able to view added member in \"Members\" section of \"Organization Units\" page."));
	}
	
	@Test(priority=168,description="To verify that user is able to perform \"Search\" functionality from \"Members\" section.")
	public void PV_UserManagement_169() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("dep_user_1");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter search criteria in \"Search\" textbox.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_username)).getText(), "dep_user_1");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to get searched result in \"Members\" section."));
	}
	
	
	
	@Test(priority=169,description="To verify that user is able to \"Cancel\" validation message of delete member from member section.")
	public void PV_UserManagement_171() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("dep_user_1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_icon_delete)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Delete\" icon of \"Members\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to you want to remove the user dep_user_1 from organization unit Test Edit orgunit?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation popup should not close."));
	}
	
	@Test(priority=170,description="To verify that user is able to delete member from \"Members\" section.")
	public void PV_UserManagement_170() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("dep_user_1");
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_icon_delete)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Delete\" icon of \"Members\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to you want to remove the user dep_user_1 from organization unit Test Edit orgunit?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. Validation message popup should close.</br>"
				+ "2. Member should get deleted from \"Members\" section."));
	}
	
	@Test(priority=171, description="To verify that user is able to perform pagination functionality from \"Members\" section.")
	public void PV_UserManagement_172(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
	
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(UserManagement_repository.btn_addmember)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).sendKeys("25");
		Thread.sleep(1000);
		List<WebElement> el = driver.findElements(By.xpath(UserManagement_repository.chbox_member_window));
		System.out.println(el.size());
		for(int i=0 ; i<16 ; i++)
		{
			el.get(i).click();
		}
		Thread.sleep(1000);
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.btn_save1));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(UserManagement_repository.btn_save1)).click();
		Thread.sleep(3000);
		WebElement e2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries));
		Coordinates co2=((Locatable)e2).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(4000);
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		
		driver.findElement(By.xpath(UserManagement_repository.btn_next)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Next\" button of \"Members\" section.");
		String s2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get next records in \"Members\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Previous\" button of \"Members\" section.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s3, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get previous records in \"Members\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.lnk_pageno_2)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on any particular page No. from \"Members\" section.");
		String s4=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should redirect to selected page No. in \"Members\" section."));
	}
	
	@Test(priority=172,description="To verify that user is able to change number of records entries from \"Members\" section.")
	public void PV_UserManagement_173() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
	
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).sendKeys("25");
		Thread.sleep(3000);
		WebElement e2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries));
		Coordinates co2=((Locatable)e2).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(4000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
	}
	
	@Test(priority=173,description="To verify that user is able to perform sorting functionality for \"User name\" ,\"Email address\" columns of \"Member\" section .")
	public void PV_UserManagement_174(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_members_orgunits)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_addmember)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select users");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("dep_user_1");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.chbox_user_depuser1)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("dep_admin_1");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.chbox_user_depadm1)).click();
		Thread.sleep(2000);
		WebElement l3 = driver.findElement(By.xpath(UserManagement_repository.btn_save1));
		Coordinates co2=((Locatable)l3).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save1)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on sorting icon of \"User name\" column of \"Member\" section.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).getAttribute("style");
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get records of users in alphabetical sorting order of \"Username\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).click();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_Username)).getAttribute("style");
		Assert.assertNotEquals(s1, s2);
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of \"Email address\" column of \"Member\" section.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).getAttribute("style");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).click();
		Thread.sleep(1000);
		String s4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailadd)).getAttribute("style");
		Assert.assertNotEquals(s3, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get records of users in sorting order of \"Email address\"."));
	}
	
	@Test(priority=174,description="To verify that user is able to get \"Roles\" section of Organization unit.")
	public void PV_UserManagement_175() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_roles_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Roles\" tab from \"Organization Units\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_addrole)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).isDisplayed(), true);
		//Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries_rolsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next_rolesec)).isDisplayed(), true);
	    Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_pre_rolesec)).isDisplayed(), true);
	    ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Roles\" section with following : </br>"
	    		+ "1. Buttons: \"Add role\", \"Delete\", \"Previous\", \"Next\", page control buttons.</br>"
	    		+ "2. Dropdown: \"Show entries\"."));
	}
	
	@Test(priority=175,description="To verify that user is able to perform \"Add role\" functionality from \"Roles\" section.")
	public void PV_UserManagement_176(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_roles_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Roles\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrole)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add role\" button of \"Roles\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select roles");
		driver.findElement(By.xpath(UserManagement_repository.chbox_role_depuser)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select checkbox of role from \"Select roles\" window.");
		WebElement l3 = driver.findElement(By.xpath(UserManagement_repository.btn_save1));
		Coordinates co2=((Locatable)l3).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button of \"Select role\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. \"Select roles\" window should close.</br>"
				+ "2. User should able to view added member in \"Roles\" section of \"Organization Units\" page.</br>"
				+ "3. All the added members  should get selected role from that organization unit."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.menu_item_Appusers)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.searchbox)).sendKeys("dep_user_1");
		driver.findElement(By.xpath(UserManagement_repository.btn_search)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.tab_roles)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_muted)).getAttribute("class"), "text-muted");
		Thread.sleep(1000);
		
	}

	
	@Test(priority=176,description="To verify that user is able to \"Cancel\" validation message of delete role from \"Roles\" section.")
	public void PV_UserManagement_178() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_roles_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Roles\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_icon_delete_rolesec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Roles\" tab from \"Organization Units\" page.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to you want to remove the role Departmental User from organization unit Test Edit orgunit?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of  validation message popup and validation popup should not close."));
	}
	
	@Test(priority=177,description="To verify that user is able to delete roles from \"Roles\" section of particular organization unit.")
	public void PV_UserManagement_177() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_roles_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Roles\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_icon_delete_rolesec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Roles\" tab from \"Organization Units\" page.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to you want to remove the role Departmental User from organization unit Test Edit orgunit?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
        driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. Validation message popup should close.</br>"
				+ "2. Role should get deleted from \"Roles\" section."));
	}
	
	@Test(priority=180,description="To verify that user is able to perform sorting functionality for \"Role name\" column from \"Roles\" section.")
	public void PV_UserManagement_181() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_roles_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Roles\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_addrole)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Select roles");
		driver.findElement(By.xpath(UserManagement_repository.chbox_role_depuser)).click();
		driver.findElement(By.xpath(UserManagement_repository.chbox_role_orguser)).click();
		Thread.sleep(1000);
		WebElement l3 = driver.findElement(By.xpath(UserManagement_repository.btn_save1));
		Coordinates co2=((Locatable)l3).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save1)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of \"Role name\" column from \"Roles\" section.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).getAttribute("style");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).click();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_rolename)).getAttribute("style");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records of roles in alphabetical sorting order of \"Role name\" column."));
	}
	
	@Test(priority=181,description="To verify that user is able to get \"Office\" section of particular Organization Unit.")
	public void PV_UserManagement_182() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_search_officesec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_Name)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next_officesec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_pre_officesec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries_officesec)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Offices\" section with following : </br>"
				+ "1. Buttons : \"Add Office\", \"Actions\" dropdown , \"Previous\", \"Next\", page control buttons.</br>"
				+ "2. Dropdown : \"Show entries\".</br>"
				+ "3. Text-box : \"SEARCH\".</br>"
				+ "4. Table with columns like : \"Actions\", \"Name\" , \"Address Line 1\", \"Address Line 2\" , \"District\"."));
	}
	
	@Test(priority=182,description="To verify that user is able to get \"New Office\" window by performing \"Add Office\" functionality from \"Office\" section of particular organization unit.")
	public void PV_UserManagement_183() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_country)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_state)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_city)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_taluka)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_village)).isDisplayed(), true);
		String s1=driver.findElement(By.xpath(UserManagement_repository.preselected_dep_office)).getText();
		System.out.println(s1);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.preselected_dep_office)).getText(), "Test Edit orgunit");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_save)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_close)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Office\" window with following :</br>"
				+ "1. Text-boxes : \"Name\" , \"Address Line 1\" , \"Address Line 2\" , \"PIN Code\" , \"OGC fid\", \"Phone Number 1\" , \"Phone Number 2\" , \"Email ID\" , \"Description\".</br>"
				+ "2. Dropdowns : \"Country\" , \"State\" , \"District\" ,\"Taluka\" , \"Village\" , \"Department\" , \"Type\".</br>"
				+ "3. Buttons : \"Cancel\" , \"Save\" , close(\"X\")."));
	}
	
	@Test(priority=183,description="To verify that user is able to \"Add Office\" in particular Organization unit by performing \"Add Office\" functionality.")
	public void PV_UserManagement_184() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Select District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> :  Select value of \"OGC fid\" from respective textbox.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Phone Number in \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Select Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Click on \"Save\" button of \"New Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office_officesec)).getText(), "Test Office");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Office\" window.</br>"
				+ "2. Added office should display in \"Offices\" section of respected Organization unit."));
	}
	
	@Test(priority=184,description="To verify that user is able to close \"New Office\" window.")
	public void PV_UserManagement_185() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(2000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on close(\"X\") button of \"New Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Office\" window."));
	}
	
	@Test(priority=185,description="To verify that user is able to perform \"Cancel\" functionality of \"New Office\" window.")
	public void PV_UserManagement_186() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on close(\"X\") button of \"New Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Office\" window and \"New Office\" window should close."));
	}
	
	@Test(priority=186,description="To verify that user gets validation message when perform \"Save\" functionality of \"New Office\" window without entering mandatory fields detail. ")
	public void PV_UserManagement_187() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button without entering mandatory fields detail.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_officename)).getText(), "The Office field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_add1_office)).getText(), "The Address Line 1 field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_pincode_office)).getText(), "The PIN Code field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_phone1_office)).getText(), "The Phone Number 1 field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_emailid_office)).getText(), "The Email Id field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like : </br>"
				+ "\"The Name field is required.\" , </br>"
				+ "\"The Address Line 1 field is required.\" , </br>"
				+ "\"The PIN Code field is required.\", \",</br>"
				+ "\"The Phone Number 1 field is required.\" ,</br>"
				+ "\"The Email Id field is required.\" below their respective fields."));
	}
	
	@Test(priority=187,description="To verify that user gets validation message for entering invalid data in \"Office\" text-box.")
	public void PV_UserManagement_188() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("1234  ^&(&$@");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid data in \"Office\" text-box of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_officename)).getText(), "InvalidOfficeName");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"InvalidOfficeName\" below respective text-box."));
	}
	
	@Test(priority=188,description="To verify that user gets validation message for entering invalid PIN Code in \"PIN Code\" text-box.")
	public void PV_UserManagement_189() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("1111");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid PIN Code in \"PIN Code\" text-box of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_pincode_office)).getText(), "Invalid PIN Code");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"Invalid PIN Code\" below respective text-box."));
	}
	
	
	@Test(priority=189,description="To verify that user gets validation message for entering invalid Phone Number in \"Phone Number 1\" text-box.")
	public void PV_UserManagement_190() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("1999999999");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid Phone Number in \"Phone Number 1\" text-box  of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_phone1_office)).getText(), "Invalid Phone Number");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"Invalid Phone Number\" below respective text-box."));
	}
	
	@Test(priority=190,description="To verify that user gets validation message for entering invalid Email ID in \"Email ID\" text-box.")
	public void PV_UserManagement_191() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("abc@gmail..com");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter invalid Email ID in \"Email ID\" text-box of \"New Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_emailid_office)).getText(), "Invalid Email Address");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"Invalid Email Address\" below respective text-box."));
	}
	
	@Test(priority=191,description="To verify that user gets validation message when perform \"Cancel\" functionality after entering any field of \"New Office\" window. ")
	public void PV_UserManagement_192() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Select District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> :  Select value of \"OGC fid\" from respective textbox.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Phone Number in \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Select Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Click on \"Cancel\" button of \"New Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Office\" window should also close."));
	}
	
	@Test(priority=192,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Office\" window.")
	public void PV_UserManagement_193() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"New Office\" button.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Select District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> :  Select value of \"OGC fid\" from respective textbox.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Phone Number in \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Select Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Click on \"Cancel\" button of \"New Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Office\" window should display on screen."));
		
	}
	
	@Test(priority=193,description="To verify that user is able to edit details of Office by performing \"Edit\" functionality from \"Actions\" dropdown of respected Office.")
	public void PV_UserManagement_194() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_action_office)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Edit Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit selection of State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit selection of District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> :  Edit PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit \"OGC fId\" from respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999990991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testeditoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> :  Edit selection of Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Click on \"Save\" button of \"Edit Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office_officesec)).getText(), "Test Edit Office");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Office\" window and \"Edit Office\" window should close.</br>"
				+ "2. Edited details of Office should update on portal."));
		
	}
	
	@Test(priority=194,description="To verify that user is able to close \"Edit Office\" window.")
	public void PV_UserManagement_195() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_action_office)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on close(\"X\") button of \"Edit Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Office\" window."));
	}
	
	@Test(priority=195,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Office\" window.")
	public void PV_UserManagement_196() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_action_office)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Edit Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Office\" window and \"Edit Office\" window should close."));
	}
	
	@Test(priority=196,description="To verify that user gets validation message when perform \"Cancel\" functionality after edit any field of \"Edit Office\" window. ")
	public void PV_UserManagement_197() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_action_office)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Edit Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit selection of State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit selection of District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> :  Edit PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit \"OGC fId\" from respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999990991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testeditoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> :  Edit selection of Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> :  Click on \"Cancel\" button of \"Edit Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> :  Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Office\" window should also close."));
	}
	
	@Test(priority=197,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Office\" window.")
	public void PV_UserManagement_198() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_action_office)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Edit Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit selection of State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit selection of District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> :  Edit PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit \"OGC fId\" from respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999990991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testeditoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> :  Edit selection of Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> :  Click on \"Cancel\" button of \"Edit Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> :  Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Office\" window should display on screen."));
	}
	
	@Test(priority=198,description="To verify that user is able to cancel the validation  message of delete office record from \"Offices\" section of selected Organization unit.")
	public void PV_UserManagement_200() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_action_office)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Actions\"-> \"Discard\" option from Actions dropdown of any particular office.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=199,description="To verify that user is able to \"Delete\" office from \"Offices\" section by performing \"Delete\" functionality from \"Actions\" dropdown of respected Office.")
	public void PV_UserManagement_199() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_action_office)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Actions\"-> \"Discard\" option from Actions dropdown of any particular office.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and popup should close.</br>"
				+ "2. User should get toast validation message like \"Successfully discarded!\".</br>"
				+ "3. Selected office should delete from \"Offices\" section of respected organization unit."));
	}
	
	@Test(priority=202,description="To verify that user is able to perform \"SEARCH\" functionality from \"Offices\" section of selected Organization Unit.")
	public void PV_UserManagement_203() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		for(int i=1;i<3;i++)
		{
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Office" +i);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		}
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office_officesec)).getText(), "Test Office1");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search_officesec)).sendKeys("Test Office2");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office_officesec)).getText(), "Test Office2");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries_office)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Offices\" section of selected Organization unit."));
	}
	
	@Test(priority=203,description="To verify that user is able to perform sorting functionality for the \"Name\" , \"Address Line 1\" , \"Address Line 2\" , \"District\" columns of \"Offices\" section of selected Organization Unit.")
	public void PV_UserManagement_204(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Organization Units\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on any organization unit from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Offices\" tab from \"Organization Units\" page.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Demo Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, aashram road ");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Paladi");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("504030");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9009999991");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9009999992");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testdemooffice@gmail.com");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of the \"Office\" column of \"Office\" section of selected organization unit.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).click();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical sorting order of \"Office\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of the \"Address Line 1\" column of \"Office\" section of selected organization unit.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).click();
		Thread.sleep(1000);
		String s4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in sorting order of \"Address Line 1\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of the \"Address Line 2\" column of \"Office\" section of selected organization unit.");
		String s5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).click();
		Thread.sleep(1000);
		String s6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in sorting order of \"Address Line 2\" name data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"District\" column of \"Office\" section of selected organization unit.");
		String s7=driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).click();
		Thread.sleep(1000);
		String s8=driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).getAttribute("aria-sort");
		Assert.assertNotEquals(s7, s8);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical sorting order of \"District\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on sorting icon of the \"Office Type\" column of \"Office\" section of selected organization unit.");
		String s9=driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).click();
		Thread.sleep(1000);
		String s0=driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).getAttribute("aria-sort");
		Assert.assertNotEquals(s9, s0);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records in alphabetical sorting order of \"Office Type\" data fields."));
	}
	
	@Test(priority=204,description="To verify that user that user is able to get Landing page \"Office\".")
	public void PV_UserManagement_205() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_header)).getText(), "Office");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_country)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_state)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_taluka)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_village)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_dep)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_ogcfid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone1)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone2)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get Landing page of \"Office\" with following :</br>"
				+ "1. Buttons : \"New Office\", \"Previous\" ,\"Next\", Page control Number.</br>"
				+ "2. Text-box : \"SEARCH\".</br>"
				+ "3. Table with the column fields like : \r\n"
				+ "\"Actions\" , \"Name\", \"Address Line 1\",\"Address Line 2\", \"Country\",\"State\",\"District\",\"Taluka\", \"Village\",\"PIN Code\" , \"Department\" , \"OGC fid\" , \"Phone Number 1\" , \"Phone Number 2\" , \"Email Id\" , \"Type\", \"Description\".</br>"
				+ "4. Dropdowns : \"Actions\" button ,\"Show entries\" .</br>"
				+ "5. Link : \"Home\" icon."));
	}
	
	@Test(priority=205,description="To verify that user is able to create \"New Office\" by performing \"New Office\" functionality from \"Office\" page.")
	public void PV_UserManagement_206(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Police Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_dep_office)).sendKeys("Test Edit Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Select Department from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter \"OGC fId\" in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Click on \"Save\" button of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office)).getText(), "Test Police Office");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Office\" window.</br>"
				+ "2. Added office should display in \"Offices\" page list."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		driver.findElement(By.xpath(UserManagement_repository.tab_office_orgunits)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search_officesec)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office_officesec)).getText(), "Test Police Office");
		ExtentTestManager.getTest().log(Status.INFO, String.format("3. Added office should also display in office section of respected Organization Unit."));
	}
	
	@Test(priority=206,description="To verify that user is able to close \"New Office\" window.")
	public void PV_UserManagement_207() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"New Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Office\" window."));
	}
	
	@Test(priority=207,description="To verify that user is able to perform \"Cancel\" functionality of \"New Office\" window.")
	public void PV_UserManagement_208() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"New Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Office\" window and \"New Office\" window should close."));
	}
	
	@Test(priority=208,description="To verify that user is able to get validation message when perform \"Save\" functionality of \"New Office\" window without entering mandatory fields detail. ")
	public void PV_UserManagement_209() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Save\" button without entering mandatory fields detail.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_officename)).getText(), "The Office field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_add1_office)).getText(), "The Address Line 1 field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_pincode_office)).getText(), "The PIN Code field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_phone1_office)).getText(), "The Phone Number 1 field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_emailid_office)).getText(), "The Email Id field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like : </br>"
				+ "\"The Name field is required.\" , </br>"
				+ "\"The Address Line 1 field is required.\" , </br>"
				+ "\"The PIN Code field is required.\", \",</br>"
				+ "\"The Phone Number 1 field is required.\" ,</br>"
				+ "\"The Email Id field is required.\" below their respective fields."));
	}
	
	@Test(priority=209,description="To verify that user is able to get validation message for entering invalid data in \"Office\" text-box of \"New Office\" window.")
	public void PV_UserManagement_210() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("1234  ^&(&$@");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter invalid data in \"Office\" text-box  of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_officename)).getText(), "InvalidOfficeName");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"InvalidOfficeName\" below respective text-box."));
	}
	
	@Test(priority=210,description="To verify that user is able to get validation message for entering invalid PIN Code in \"PIN Code\" text-box of \"New Office\" window.")
	public void PV_UserManagement_211() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("1111");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter invalid PIN Code in \"PIN Code\" text-box of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_pincode_office)).getText(), "Invalid PIN Code");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"Invalid PIN Code\" below respective text-box."));
	}
	
	@Test(priority=210,description="To verify that user is able to get validation message for entering invalid Phone Number in \"Phone Number 1\" text-box of \"New Office\" window.")
	public void PV_UserManagement_212() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("1999999999");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter invalid Phone Number in \"Phone Number 1\" text-box of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_phone1_office)).getText(), "Invalid Phone Number");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"Invalid PIN Code\" below respective text-box."));
	}
	
	@Test(priority=212,description="To verify that user is able to get validation message for entering invalid Email ID in \"Email ID\" text-box of \"New Office\" window.")
	public void PV_UserManagement_213() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail..com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter invalid Email ID in \"Email ID\" text-box of \"New Office\" window.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.val_emailid_office)).getText(), "Invalid Email Address");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message \"Invalid Email Address\" below respective text-box."));
	}
	
	@Test(priority=213,description="To verify that User gets validation message when Add office with same name which is already exist.")
	public void PV_UserManagement_214() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Police Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_dep_office)).sendKeys("Test Edit Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Select Department from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter \"OGC fId\" in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Click on \"Save\" button of \"New Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(), "Office name is already exist with same name.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : "));
	}
	              	
	@Test(priority=214,description="To verify that User gets validation message when perform \"Cancel\" functionality after entering any field of \"New Office\" window. ")
	public void PV_UserManagement_215() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Police Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_dep_office)).sendKeys("Test Edit Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Select Department from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter \"OGC fId\" in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Click on \"Cancel\" button of \"New Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Office\" window should also close."));
	}
	
	@Test(priority=215,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Office\" window.")
	public void PV_UserManagement_216() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.btn_newoffice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"New Office\" button from \"Office\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "New Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Police Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_dep_office)).sendKeys("Test Edit Office");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Select Department from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter \"OGC fId\" in respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9999999991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone2_office)).sendKeys("9999999992");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testoffice@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test add office functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Click on \"Cancel\" button of \"New Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Office\" window should display on screen."));
	}
	
	@Test(priority=216,description="To verify that user is able to edit details of Office by performing \"Edit\" functionality from \"Actions\" dropdown of  Office.")
	public void PV_UserManagement_217() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Police Office1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> :  Edit selection of District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit \"OGC fId\" from respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9199990991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testeditoffice1@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit selection of Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test Edit Office functionality.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Click on \"Save\" button of \"Edit Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office)).getText(), "Test Police Office1");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Office\" window.</br>"
				+ "2. Edited details of Office should update on portal."));
	}
	
	@Test(priority=217,description="To verify that user is able to close \\\"Edit Office\\\" window.")
	public void PV_UserManagement_218() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"Edit Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Office\" window."));
	}
	
	@Test(priority=218,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Office\" window.")
	public void PV_UserManagement_219() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Edit Office\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Office\" window and \"Edit Office\" window should close."));
	}
	
	@Test(priority=219,description="To verify that User gets validation message when perform \"Cancel\" functionality after edit any field of \"Edit Office\" window. ")
	public void PV_UserManagement_220() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Police Office1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> :  Edit selection of District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit \"OGC fId\" from respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9199990991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testeditoffice1@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit selection of Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test Edit Office functionality.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Click on \"Cancel\" button of \"Edit Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Office\" window should also close."));
	}
	
	@Test(priority=220,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Office\" window.")
	public void PV_UserManagement_221() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Edit\" option from Actions dropdown of any particular office.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).getText(), "Edit Office");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_name_office)).sendKeys("Test Police Office1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit Office Name in \"Office\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add1_office)).sendKeys("12, ambli road ");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Address in \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_add2_office)).sendKeys("Bopal");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_state)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of State from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.dd_city)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> :  Edit selection of District from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_PIN_office)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit PIN code in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_ogcfid_office)).sendKeys("2");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit \"OGC fId\" from respective text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_phone1_office)).sendKeys("9199990991");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit Phone Number in \"Phone Number 1\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.txtbox_emailid_office)).sendKeys("testeditoffice1@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit Email ID in \"Email ID\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.dd_type_office)).sendKeys("Police Station");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit selection of Office Type from respective dropdown.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).clear();
		driver.findElement(By.xpath(UserManagement_repository.txtbox_desc_office)).sendKeys("Test Edit Office functionality.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit Description in \"Description\" text-box.");
		driver.findElement(By.xpath(UserManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Click on \"Cancel\" button of \"Edit Office\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Office\" window should display on screen."));
	}
	
	@Test(priority=221,description="To verify that user is able to cancel the validation  message of delete office record from \"Offices\" page.")
	public void PV_UserManagement_223() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from Actions dropdown of any particular office.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=222,description="To verify that user is able to \"Delete\" office by performing \"Delete\" functionality from \"Actions\" dropdown of respected Office.")
	public void PV_UserManagement_222() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Test Police Office");
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"-> \"Discard\" option from Actions dropdown of any particular office.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and popup should close.</br>"
				+ "2. User should get toast validation message like \"Successfully discarded!\".</br>"
				+ "3. Selected office should delete from \"Offices\" section of respected organization unit."));
	}
	
	@Test(priority=223,description="To verify that user is able to perform pagination functionality of \"Office\" page.")
	public void PV_UserManagement_224(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(UserManagement_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of \"Office\" page.");
		String s2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get next records of Offices in \"Office\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of \"Office\" page.");
		String s3=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s3, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get previous records of Offices in \"Office\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.lnk_pageno_2)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. button from \"Office\" page.");
		String s4=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get selected page no. records of Offices in  \"Office\" page."));
	}
	
	@Test(priority=224,description="To verify that user is able to change number of entries of \"Office\" page.")
	public void PV_UserManagement_225() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		String s1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(UserManagement_repository.dd_entries)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from \"Show entries\" dropdown.");
		String s2=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText();
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Office\" page."));
	}
	
	@Test(priority=225,description="To verify that user is able to perform \"SEARCH\" functionality of \"Office\" page.")
	public void PV_UserManagement_226() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.txtbox_search)).sendKeys("Gota Police Chawki");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.verify_office)).getText(), "Gota Police Chawki");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Office\" page."));
	}
	
	@Test(priority=226,description="To verify that user is able to perform sorting functionality of all columns present on \"Office\" page.")
	public void PV_UserManagement_227(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_offie)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on sorting icon of the \"Office\" column.");
		String a1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).click();
		Thread.sleep(1000);
		String a2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_office)).getAttribute("aria-sort");
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get records in alphabetical sorting order of \"Office\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on sorting icon of the \"Address Line 1\" column.");
		String a3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).click();
		Thread.sleep(1000);
		String a4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add1)).getAttribute("aria-sort");
		Assert.assertNotEquals(a3, a4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get records in sorting order of \"Address Line 1\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of the \"Address Line 2\" column.");
		String a5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).click();
		Thread.sleep(1000);
		String a6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_add2)).getAttribute("aria-sort");
		Assert.assertNotEquals(a5, a6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get records in sorting order of \"Address Line 2\" name data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of the \"District\" column.");
		String a7=driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).click();
		Thread.sleep(1000);
		String a8=driver.findElement(By.xpath(UserManagement_repository.col_lbl_district)).getAttribute("aria-label");
		Assert.assertNotEquals(a7, a8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_04</b> : User should get records in alphabetical sorting order of \"District\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_taluka)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of the \"Taluka\" column.");
		String b1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_taluka)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_taluka)).click();
		Thread.sleep(1000);
		String b2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_taluka)).getAttribute("aria-sort");
		Assert.assertNotEquals(b1, b2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_05</b> : User should get records in alphabetical sorting order of \"Taluka\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_05");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_village)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Village\" column.");
		String b3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_village)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_village)).click();
		Thread.sleep(1000);
		String b4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_village)).getAttribute("aria-sort");
		Assert.assertNotEquals(b3, b4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_06</b> : User should get records in alphabetical sorting order of \"Village\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_06");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on sorting icon of the \"PIN Code\" column.");
		String b5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).click();
		Thread.sleep(1000);
		String b6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_pincode)).getAttribute("aria-sort");
		Assert.assertNotEquals(b5, b6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_07</b> : User should get records in sorting order of \"PIN Code\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_07");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_dep)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on sorting icon of the \"Department\" column.");
		String b7=driver.findElement(By.xpath(UserManagement_repository.col_lbl_dep)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_dep)).click();
		Thread.sleep(1000);
		String b8=driver.findElement(By.xpath(UserManagement_repository.col_lbl_dep)).getAttribute("aria-label");
		Assert.assertNotEquals(b7, b8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_08</b> : User should get records in sorting order of \"Department\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_08");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_ogcfid)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on sorting icon of the \"OGC fid\" column.");
		String c1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_ogcfid)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_ogcfid)).click();
		Thread.sleep(1000);
		String c2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_ogcfid)).getAttribute("aria-sort");
		Assert.assertNotEquals(c1, c2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_09</b> : User should get records in sorting order of \"OGC fid\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_09");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on sorting icon of the \"Phone Number 1\" column.");
		String c3=driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone1)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone1)).click();
		Thread.sleep(1000);
		String c4=driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone1)).getAttribute("aria-sort");
		Assert.assertNotEquals(c3, c4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_10</b> : User should get records in sorting order of \"Phone Number 1\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_10");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone2)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Click on sorting icon of the \"Phone Number 2\" column.");
		String c5=driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone2)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone2)).click();
		Thread.sleep(1000);
		String c6=driver.findElement(By.xpath(UserManagement_repository.col_lbl_phone2)).getAttribute("aria-sort");
		Assert.assertNotEquals(c5, c6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_11</b> : User should get records in sorting order of \"Phone Number 2\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_11");
		//WebElement e=driver.findElement(By.xpath(UserManagement_repository.text_showing_entries));
		
		WebElement e1=driver.findElement(By.xpath(UserManagement_repository.scroll_to_hori));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailid)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Click on sorting icon of the \"Email Id\" column.");
		String c7=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailid)).getAttribute("aria-label");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailid)).click();
		Thread.sleep(1000);
		String c8=driver.findElement(By.xpath(UserManagement_repository.col_lbl_emailid)).getAttribute("aria-label");
		Assert.assertNotEquals(c7, c8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_12</b> : User should get records in sorting order of \"Email Id\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_12");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Click on sorting icon of the \"Office Type\" column.");
		String d1=driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).getAttribute("aria-sort");
		driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).click();
		Thread.sleep(1000);
		String d2=driver.findElement(By.xpath(UserManagement_repository.col_lbl_officetype)).getAttribute("aria-sort");
		Assert.assertNotEquals(d1, d2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_13</b> : User should get records in sorting order of \"Type\" data fields."));
	}
	
	@Test(priority=227,description="To verify that user is able to \"Cancel\" validation message of delete Organization unit.")
	public void PV_UserManagement_166(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Delete\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to delete the organization unit 'Test Edit orgunit'?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
        ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get validation message like \r\n"
        		+ "\"Are you sure? Are you sure you want to delete the organization unit 'Test Edit orgunit'?"));
        ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should able to click on \"Cancel\" button of validation message pop up and message pop up should not close."));
	}
	
	
	
	@Test(priority=228,description="To verify that user is able to perform \"Delete\" functionality from dropdown list of particular organization unit.")
	public void PV_UserManagement_165(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(UserManagement_repository.opt_UserManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.menu_item_orgunits)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"User Management\"-> \"Office\" menu from left pane.");
		Actions act = new Actions(driver);
		WebElement e1 = driver.findElement(By.xpath(UserManagement_repository.orgunit_gujarat));
		act.doubleClick(e1).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UserManagement_repository.edited_orgunit)).click();
		WebElement l1 = driver.findElement(By.xpath(UserManagement_repository.edited_orgunit));
		act.contextClick(l1).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on downside arrow of any one of the organizations from \"Organization tree\" section.");
		driver.findElement(By.xpath(UserManagement_repository.lnk_delete)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Delete\" functionality from dropdown list of particular organization unit.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to delete the organization unit 'Test Edit orgunit'?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
        ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Office\" page."));
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(), "Successfully deleted");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. Validation message popup should close.</br>"
				+ "2. User should get validation message like \"Successfully deleted\".</br>"
				+ "3. Selected organization unit should get deleted from \"Organization tree\" section of \"Organization Units\" page."));
	}
	
	
	
	@AfterMethod
	public void Aftermethod() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(Login_repository.profile_admin))).
		build().perform(); Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.lnk_logout)).click();
		Thread.sleep(2000);
		 
		driver.close();
		Thread.sleep(1000);
	}
}
