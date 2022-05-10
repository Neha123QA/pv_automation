package pv_admin;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
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

public class PV_CrimeMapping {
	WebDriver driver;
	Screenshot_extra ll=new Screenshot_extra();
	String i="PV_CrimeMapping_extra_ss";
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
	
	
	@Test(priority=0,description="To verify that user is able to expand/collapse \"Crime Mapping\" menu from left panel of police vertical web portal.")
	public void PV_CrimeMapping_01(Method method) throws InterruptedException
	{
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		String a1=driver.findElement(By.xpath(CrimeMapping_repository.style_exp_coll)).getAttribute("style");
		System.out.println(a1);
		Thread.sleep(1000);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mapping\" menu from left pane.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get \"Crime Mapping\" in expanded mode with following :</br>"
				+ "1. Crimes</br>"
				+ "2. Crime Types</br>"
				+ "3. Crime Analysis"));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Crime Mapping\" menu from left panel.");
		String a2=driver.findElement(By.xpath(CrimeMapping_repository.style_exp_coll)).getAttribute("style");
		System.out.println(a2);
		Thread.sleep(1000);
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get \"Crime Mapping\" in collapse mode."));
	}
	
	@Test(priority=2,description="To verify that user is able to get \"Crimes\" page.")
	public void PV_CrimeMapping_02() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(),"Crimes");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_Actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creationtime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatorname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodificationtime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodifiername)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>>> User should get \"Crimes\" page with following :</br>"
				+ "1. Buttons : \"Register Crime\" , \"Next\" , \"Previous\" ,  Page Control Numbers.</br>"
				+ "2. Text-box : \"SEARCH\".</br>"
				+ "3. Table of added crime list with following column fields :</br>"
				+ "\"Actions\" , \"Record No\" , \"Crime Type\" ,\"Summary\" , Jurisdiction\" , \"Crime Time\", \"Reporting Time\",\"Severity\" , \"Creation Time\" , \"CreatorName(BadgeNo)\" , \"Last Modification Time\" , \"LastModifierName(BadgeNo).</br>"
				+ "4. Dropdown : \"Actions\" button ,\"Show entries\" .</br>"
				+ "5. Links : \"Home\" icon.\r\n"
				+ "</br>"
				+ ">> User should get \"Crimes\" page with list of crimes If added otherwise displays No data available."));
	}

	
	@Test(priority=2,description="To verify that user is able to get back to \"Home\" page from \"Crimes\" page by clicking on \"Home\" icon.")
	public void PV_CrimeMapping_03() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(),"Crimes");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Home\" icon from \"Users\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(),"Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Crimes\" page."));
	}
	
	@Test(priority=3,description="To verify that user is able to perform Pagination functionality of \"Crimes\" page.")
	public void PV_CrimeMapping_04(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 11 to 20 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page record list of \"Crimes\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page record list of \"Crimes\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_3)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Crimes\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 21 to 30 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get selected page no. record list of \"Crimes\" page ."));
	}
	
	@Test(priority=4,description="To verify that user is able to perform \"SEARCH\" functionality of \"Crimes\" page.")
	public void PV_CrimeMapping_05() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("1886");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_first)).getText(), "1886");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Crimes\" page."));
	}
	
	@Test(priority=5,description="To verify that user is able to perform \"Show No. of entries\" functionality from \"Crimes\" page.")
	public void PV_CrimeMapping_06() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from the \"Show No. of entries\" dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 25 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Crimes\" page."));
	}
	
	@Test(priority=6,description="To verify that user is able to perform sorting functionality of columns from \"Crimes\" page.")
	public void PV_CrimeMapping_07(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on sorting icon of the \"Record No\" column.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in numerical sorting order of \"Record No\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on sorting icon of the \"Crime Type\" column.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in alphabetical sorting order of \"Crime Type\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of the \"Summary\" column.");
		String s6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in alphabetical sorting order of \"Summary\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).click();
		Thread.sleep(1000);
		String s7=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of the \"Jurisdiction\" column.");
		String s8=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in alphabetical sorting order of \"Jurisdiction\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).click();
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of the \"Crime Time\" column.");
		String t2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).getAttribute("aria-label");
		Assert.assertNotEquals(t1, t2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_5</b> : User should get records in sorting order of \"Crime Time\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_05");
		
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).click();
		Thread.sleep(1000);
		String t3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Reporting Time\" column.");
		String t4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).getAttribute("aria-label");
		Assert.assertNotEquals(t3, t4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_6</b> : User should get records in sorting order of \"Reporting Time\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_06");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).click();
		Thread.sleep(1000);
		String t5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Severity\" column.");
		String t6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).getAttribute("aria-label");
		Assert.assertNotEquals(t5, t6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_7</b> : User should get records in sorting order of \"Severity\" data fields."));
	}
	
	@Test(priority=7,description="To verify that user is able to get \"Register Crime\" page by performing \"Register Crime\" functionality from \"Crimes\" page.")
	public void PV_CrimeMapping_08() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.repoTime_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_FIRno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_Fileno)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should get message popup for location access.</br>"
				+ "2. User should get \"Register Crime\" page with two sections : Window section(For create new crime) , Map.</br>"
				+ "3. Window section contains following : </br>"
				+ "3.1. Dropdowns: \"Select Location\", \"Select Crime\",\"Severity\".</br>"
				+ "3.2. Text-boxes : \"Latitude\" , \"Longitude\" ,\"Summary\" , \"Description\" , \"Crime Time\", \"Crime End Time\" , \"Reporting Time\",\"FIR No\", \"File No\".</br>"
				+ "3.3. Buttons : \"Cancel\" ,\"Save\" , \"Update & Continue\" .</br>"
				+ "4. Map contains following :</br>"
				+ "Icon Buttons : Kebab Menu (3 vertical dot) ,\"Hamburger menu\"."));
	}
	
	@Test(priority=8,description="To verify that user is able to get back to \"Home\" page from \"Register Crime\" page by clicking on \"Home\" icon.")
	public void PV_CrimeMapping_09() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Home\" icon from \"Register Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(),"Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Register Crime\" page."));
	}
	
	@Test(priority=9,description="To verify that user is able to register new crime by performing \"Register Crime\" functionality with selection of \"Current Location\" option.")
	public void PV_CrimeMapping_10(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Murder");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select type of crime from \"Select Crime\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("High");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select Crime Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select Crime End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).sendKeys("This is Test1.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Crime Incident Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).sendKeys("Test Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Crime description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_registercrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Save\" button from \"Register Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "Your crime has been successfully registered.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : </br>1. User should able to click on \"Save\" button from \"Register Crime\" page.</br>"
				+ "2. User should get validation message like \"Your crime has been successfully registered.\r\n"
				+ "Record Number : x\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crimes");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test1.");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime)).getText(), "This is Test1.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should redirect back to listing of \"Crimes\" page by clicking on \"OK\" button of validation message popup.</br>"
				+ "2. Added crime should display in list of \"Crimes\" page."));
	}
	
	@Test(priority=10,description="To verify that user is able to register new crime by performing \"Register Crime\" functionality with selection of \"Enter Coordinates\" option.")
	public void PV_CrimeMapping_11(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Murder");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select type of crime from \"Select Crime\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("High");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select Severity value from \"Severity\" dropdown.");
		
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)));
		  elm.selectByVisibleText("Enter Coordinates");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Enter Coordinates\" option from \"Select Location\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long)).sendKeys("72.544567");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Longitude value in \"Longitude\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat)).sendKeys("23.028306");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Latitude value in \"Latitude\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select Crime Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Select Crime End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).sendKeys("This is Test2.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Crime Incident Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_FIRno)).sendKeys("101");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_Fileno)).sendKeys("E11");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).sendKeys("Test Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter Crime description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_registercrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Click on \"Save\" button from \"Register Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "Your crime has been successfully registered.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button from \"Register Crime\" page.</br>"
				+ "2. User should get validation message like \"Your crime has been successfully registered.\r\n"
				+ "Record Number : x\"."));
		
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crimes");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime)).getText(), "This is Test2.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should redirect back to listing of \"Crimes\" page by clicking on \"OK\" button of validation message popup.</br>"
				+ "2. Added crime should display in list of \"Crimes\" page."));
				
	}
	
	@Test(priority=11,description="To verify that user is able to register new crime by performing \"Register Crime\" functionality with selection of \"Click on map\" option.")
	public void PV_CrimeMapping_12(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Theft");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select type of crime from \"Select Crime\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).click();
		Thread.sleep(1000);
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)));
		elm.selectByVisibleText("Click On Map");
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Click on map\" option from \"Select Location\" dropdown.");
		WebElement el=driver.findElement(By.xpath(CrimeMapping_repository.img_map));
		int width = el.getSize().getWidth();
		Actions act = new Actions(driver);
		act.moveToElement(el);
		act.moveByOffset((width/4)-5,100).click().build().perform();
		//(width/2)-25
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click at any point of map.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select Crime Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select Crime End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).sendKeys("This is Test3.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Crime Incident Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).sendKeys("Test Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Crime description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_registercrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Save\" button from \"Register Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "Your crime has been successfully registered.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button from \"Register Crime\" page.</br>"
				+ "2. User should get validation message like \"Your crime has been successfully registered.\r\n"
				+ "Record Number : x\"."));
		
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crimes");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test3.");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime)).getText(), "This is Test3.");
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should redirect back to listing of \"Crimes\" page by clicking on \"OK\" button of validation message popup.</br>"
				+ "2. Added crime should display in list of \"Crimes\" page."));
				
	}
	
	@Test(priority=12,description="To verify that user is able to perform \"Cancel\" functionality from \"Register Crime\" page.")
	public void PV_CrimeMapping_13() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button from \"Register Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crimes");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button.</br>"
				+ "2. User should redirect back to \"Crimes\" page."));
	}
	
	
	
	@Test(priority=13,description="To verify that user gets validation messages when perform \"Save\"/\"Save & Continue\" functionality of \"Register Crime\" page with selection of \"Current Location\" option and blank mandatory details.")
	public void PV_CrimeMapping_14() throws InterruptedException, MalformedURLException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Allow\" button of message pop-up.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_registercrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\"/\"Update & Continue\" button from \"Register Crime\" page without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_summary_regcrime)).getText(), "The Summary field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like :\r\n"
				+ "\"The Summary field is required.\" below respective field."));
	}
	
	@Test(priority=14,description="To verify that user gets validation messages when perform \"Save\"/\"Update & Continue\" functionality of \"Register Crime\" page with selection of \"Enter Coordinates\"/\"Click on map\" option and blank mandatory details.")
	public void PV_CrimeMapping_15() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)).sendKeys("Enter Coordinates");
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select \"Enter Coordinates\" option from \"Select Location\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_registercrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\"/\"Update & Continue\" button from \"Register Crime\" page without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_summary_regcrime)).getText(), "The Summary field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_long)).getText(), "The Longitude field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_lat)).getText(), "The Latitude field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like :</br> \"The Longitude field is required.\", </br>\"The Latitude field is required.\", </br>\"The Summary field is required.\" below their respective fields."));
	}
	
	@Test(priority=15,description="To verify that user gets validation message when select invalid date or time for \"Crime Time\" from Date & Time Picker of \"Register Crime\" form.")
	public void PV_CrimeMapping_16(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		
		
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.add(Calendar.DATE, 1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		 
		//enter tomorrow's date in the field 
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		Thread.sleep(1000);
		WebElement tomDate = driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)); 
		tomDate.sendKeys(tommorowsDate); 
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select invalid \"Crime Time\" in \"Register Crime\" form.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "Start Date-Time Must Not Be Of Future");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : </br>1. User should able to select invalid \"Crime Time\" in \"Register Crime\" form. </br>2. User should get validation message like \"Start Date-Time Must Not Be Of Future\" below respective field."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=16,description="To verify that user gets validation message when select invalid date or time for \"Crime End Time\" from Date & Time Picker of \"Register Crime\" form.")
	public void PV_CrimeMapping_17(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		
		
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.add(Calendar.DATE, 1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		 
		//enter tomorrow's date in the field 
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		Thread.sleep(1000);
		WebElement tomDate = driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)); 
		tomDate.sendKeys(tommorowsDate);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select invalid \"Crime End Time\" in \"Register Crime\" form.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "End Date-Time Must Not Be Of Future");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : </br>1. User should able to select invalid \"Crime End Time\" in \"Register Crime\" form. </br>2. User should get validation message like \"End Date-Time Must Not Be Of Future\" below respective field."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=17,description="To verify that user gets validation message when End Crime Date is earlier than Start Crime Date.")
	public void PV_CrimeMapping_18(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		
		
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.roll(Calendar.DATE, -1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		 
		//enter tomorrow's date in the field 
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		Thread.sleep(1000);
		WebElement tomDate = driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)); 
		tomDate.sendKeys(tommorowsDate);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select End Crime Date is earlier than Start Crime Date.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "End Date-Time Must Not Be Earlier Than Start Date-Time");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like \"End Date-Time Must Not Be Earlier Than Start Date-Time\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=18,description="To verify that user gets validation message when select invalid date or time for \"Reporting Time\" from Date & Time Picker of \"Register Crime\" form.")
	public void PV_CrimeMapping_19(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		
		
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.add(Calendar.DATE, 1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		 
		//enter tomorrow's date in the field 
		driver.findElement(By.xpath(CrimeMapping_repository.repoTime_crime)).clear();
		Thread.sleep(1000);
		WebElement tomDate = driver.findElement(By.xpath(CrimeMapping_repository.repoTime_crime)); 
		tomDate.sendKeys(tommorowsDate);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long)).click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select invalid \"Reporting Time\" in \"Register Crime\" form.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "Reporting Time Must Not Be Of Future");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like \"Reporting Time Must Not Be Of Future\" below respective field."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	}
	
	@Test()
	public void PV_CrimeMapping_20() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		//ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(3000);
		//ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		
		//FirefoxProfile geoenabled = new FirefoxProfile();
		/*
		geoenabled.setPreference("geo.enabled", false);
		geoenabled.setPreference("geo.provider.use_corelocation", false);
		geoenabled.setPreference("geo.prompt.testing", false);
		geoenabled.setPreference("geo.prompt.testing.allow", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoenabled);
		*/
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		caps.setCapability("locationContextEnabled", false);
		

		
		//driver = new FirefoxDriver(capabilities);
		//WebDriver driver = new RemoteWebDriver(DesiredCapabilities.FirefoxDriver(capabilities));
		
		//ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Allow\" button of message pop-up.");
		
	}
	
	@Test(priority=20,description="To verify that user is able to get next screen of \"Register Crime\" form by performing \"Update & Continue\" functionality.")
	public void PV_CrimeMapping_21(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Register Crime\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Register Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Auto Theft");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select type of crime from \"Select Crime\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)).sendKeys("Click On Map");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Click on map\" option from \"Select Location\" dropdown.");
		WebElement el=driver.findElement(By.xpath(CrimeMapping_repository.img_map));
		int width = el.getSize().getWidth();
		Actions act = new Actions(driver);
		act.moveToElement(el);
		act.moveByOffset((width/4)-5,100).click().build().perform();
		//(width/2)-25
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click at any point of map.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select Crime Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select Crime End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_FIRno)).sendKeys("198");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_Fileno)).sendKeys("69");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).sendKeys("This is Test3.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Crime Incident Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).sendKeys("Test Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Crime description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_continue_registercrime)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Save & Continue\" button of \"Register Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "Your crime has been successfully registered.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should get validation message like \"Your crime has been successfully registered. Record Number : x\".</br>"
				+ "2. User should navigate to \"Crime Mappings\" page."));
		
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.recordno_crimeinfo)).getText(), "Record No");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.fileno_crimeinfo)).getText(), "File No");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.firno_crimeinfo)).getText(), "FIR No");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.crimetime_crimeinfo)).getText(), "Crime Time");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.crimeendtime_crimeinfo)).getText(), "Crime End Time");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.reptime_crimeinfo)).getText(), "Reporting Time");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.severity_crimeinfo)).getText(), "Severity");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.summary_crimeinfo)).getText(), "Summary");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.des_crimeinfo)).getText(), "Description");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.investigationstatus_crimeinfo)).getText(), "Investigation Status");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.jurisdiction_crimeinfo)).getText(), "Jurisdiction");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.creatorname_crimeinfo)).getText(), "Creator Name (Badge No)");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.creationtime_crimeinfo)).getText(), "Creation Time");
		
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_map_crimemappings)).getAttribute("aria-selected"), "true");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.img_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_tools)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomout)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should navigate to \"Crime Mappings\" page with following :</br>"
				+ "1. Crime Tree section with registered crime.</br>"
				+ "2. Tab sections : \"Map\" , \"Attachment\", \"Person\" , \"Police Person\".(By default \"Map\" tab is selected.</br>"
				+ "3. Button : \"<-Back\".</br>"
				+ "4. Text-box : \"Search\".</br>"
				+ "5. User should get \"Crime Information\" of saved crime with following details : </br>"
				+ "\"Record No\" , \r\n"
				+ "\"File No\" , \r\n"
				+ "\"FIR No\" ,\r\n"
				+ "\"Crime Time\"\r\n"
				+ "\"Crime End Time\" , \r\n"
				+ "\"Reporting Time\" ,\r\n"
				+ "\"Severity\" ,\r\n"
				+ "\"Summary\" ,\r\n"
				+ "\"Investigation Status\",\r\n"
				+ "\"Description\" ,\r\n"
				+ "\"Jurisdiction\",\r\n"
				+ "\"Creator Name\",\r\n"
				+ "\"Creation Time\"."));
		
	}
	
	@Test(priority=21,description="To verify that user is able to perform \"Crime Details\" functionality from \"Actions\" dropdown  of particular crime in \"Crimes\" page.")
	public void PV_CrimeMapping_22() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.recordno_crimeinfo)).getText(), "Record No");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.fileno_crimeinfo)).getText(), "File No");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.firno_crimeinfo)).getText(), "FIR No");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.crimetime_crimeinfo)).getText(), "Crime Time");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.crimeendtime_crimeinfo)).getText(), "Crime End Time");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.reptime_crimeinfo)).getText(), "Reporting Time");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.severity_crimeinfo)).getText(), "Severity");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.summary_crimeinfo)).getText(), "Summary");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.des_crimeinfo)).getText(), "Description");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.investigationstatus_crimeinfo)).getText(), "Investigation Status");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.jurisdiction_crimeinfo)).getText(), "Jurisdiction");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.creatorname_crimeinfo)).getText(), "Creator Name (Badge No)");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.creationtime_crimeinfo)).getText(), "Creation Time");
		
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_map_crimemappings)).getAttribute("aria-selected"), "true");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.img_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_tools)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomout)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should navigate to \"Crime Mappings\" page."));
	}
	
	@Test(priority=22,description="To verify that user is able to perform \"<-Back\" functionality from \"Crime Mappings\"page.")
	public void PV_CrimeMapping_23() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test3.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_back)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"<- Back\" button from \"Crime Mapping\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crimes");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should redirect back to the \"Crimes\" page from \"Crime mappings\" page."));
	}
	
	@Test(priority=23,description="To verify that user gets dropdown list menu items by right clicking on saved crime from \"Crime Mappings\" page.")
	public void PV_CrimeMapping_26() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_editcrime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get dropdown list with following menu items :</br>"
				+ "\"Add Parson\" ,</br>"
				+ "\"Add Police Person\" ,</br>"
				+ "\"Add Attachment\" , </br>"
				+ "\"Edit Crime\",</br>"
				+ "\"Add Event\"."));
	}
	
	@Test(priority=24,description="To verify that user is able to get \"New Person\" window by performing \"Add Person\" functionality from dropdown list.")
	public void PV_CrimeMapping_27() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_category_newperson_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.searchbox_newperson_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_newperson_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Person\" window with following : </br>"
				+ "1. Dropdown : Search Category\".</br>"
				+ "2. Text-box : \"Search\".</br>"
				+ "3. Buttons : \"New Person\" , \"Cancel\", \"Save\" , close(\"X\") , Search icon button."));
		
	}
	
	@Test(priority=25,description="To verify that user is able to add new person in any particular saved crime by performing \"Add Person\" functionality from dropdown list.")
	public void PV_CrimeMapping_28(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_newperson_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"New Person\" button from \"New Person\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_searchpr_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_dob_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_age_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_gen_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_add1_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_state_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_dist_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_taluka_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_village_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_pin_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_phoneno_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_altphoneno_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_email_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_phydes_newpr_win)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_browse_newpr_win)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get \"New Person\" detailed form window with following :</br>"
				+ "1. Text-boxes : \"First Name\" , \"Middle Name\" , \"Last Name\", \"Age\" , \"Address Line 1\" , \"Address Line 2\" , \"PIN Code \" , \"Phone Number 1\" , \"Phone Number 2 \" , \"Email Id\" , \"Physical Description\".</br>"
				+ "2. Dropdowns : \"Associated Type\" , \"Country\" , \"State\" , \"District\" , \"Taluka\" , \"Village\".</br>"
				+ "3. Date picker : \"Date Of Birth\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).sendKeys("Complainant");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select Associated Type\" from  respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).sendKeys("Rahul");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First name into \"First Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).sendKeys("Mohanbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name into \"Middle Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).sendKeys("Patel");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name into \"Last Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_age_newpr_win)).sendKeys("24");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter \"Age\" in respective field.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_gen_newpr_win)).sendKeys("Male");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Select \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_add1_newpr_win)).sendKeys("A/123 Nikunj park,Thaltej");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter address into \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_state_newpr_win)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Select \"State\" from \"State\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_dist_newpr_win)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select \"District\" from \"District\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_pin_newpr_win)).sendKeys("380052");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter PIN Code into \"PIN Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_phoneno_newpr_win)).sendKeys("9999911111");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter Phone Number into \"Phone Number 2 \" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_altphoneno_newpr_win)).sendKeys("9999922222");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Enter alternate phone number into \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_email_newpr_win)).sendKeys("rp@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Enter Email Id into \"Email Id\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse_newpr_win)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Upload file of person in \"Select image\" field.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Click on \"Save\" button of \"New Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Rahul");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_persec)).getText(), "Rahul");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Person\" window and window should close.</br>"
				+ "2. Added person should display in list of \"Person\" section of selected crime."));
	}
	
	@Test(priority=26,description="To verify that user is able to add existing person in any particular saved crime by performing \"Search\" functionality of \"New Person\" window.")
	public void PV_CrimeMapping_29() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_category_newperson_win)).sendKeys("Name");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Search Category\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_newperson_win)).sendKeys("Jesal");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter search criteria into \"Search\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Search\" icon button.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_add_first)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Add\" button of person which want to add.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Save\" button of \"New Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Jesal");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_persec)).getText(), "Jesal");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Person\" window and window should close.</br>"
				+ "2. Added person should display in list of \"Person\" section of selected crime."));
	}
	
	@Test(priority=27,description="To verify that user is able to perform \"Search Person\" functionality from \"New Person\" detailed form window.")
	public void PV_CrimeMapping_30() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_category_newperson_win)).sendKeys("Name");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Search Category\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_newperson_win)).sendKeys("Jesal");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter search criteria into \"Search\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Search\" icon button.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_add_first)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Add\" button of person which want to add.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_searchpr_newpr_win)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_searchpr_newpr_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Search Person\" button from \"New Person\" detailed form window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_searchpr_newpr_win)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_category_newperson_win)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should redirect back to \"New Person\" search window."));
		
	}
	
	@Test(priority=28,description="To verify that user is able to perform pagination functionality of searched person list in \"New Person\" window.")
	public void PV_CrimeMapping_31(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Search\" icon button.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Next\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 11 to 20 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of persons in \"New Person\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Previous\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of persons in \"New Person\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_3)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on particular page no. of person table list in \"New Person\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 21 to 30 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get particular page no. records of persons in \"New Person\" window."));
	}
	
	@Test(priority=29,description="To verify that user is able to perform show no. of entries functionality of searched person list in \"New Person\" window.")
	public void PV_CrimeMapping_32() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Search\" icon button.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		WebElement el1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries));
		Coordinates co1=((Locatable)el1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.entries_25)).click();
		Thread.sleep(1000);
		
		Thread.sleep(3000);
		WebElement el2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries));
		Coordinates co2=((Locatable)el2).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select number from the \"Show No. of entries\" dropdown list.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"New Person\" window."));
	}
	
	@Test(priority=30,description="To verify that user is able to perform sorting functionality of columns present in searched person list of \"New Person\" window.")
	public void PV_CrimeMapping_33(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Search\" icon button.");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Sorting\" icon of the \"First Name\" column of \"New Person\" window.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).getAttribute("style");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).click();
		Thread.sleep(2000);
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).getAttribute("style");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in sorting order of \"First Name\" data field in \"New Peron\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"Last Name\" column of \"New Person\" window.");
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).getAttribute("style");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).click();
		Thread.sleep(2000);
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).getAttribute("style");
		Assert.assertNotEquals(s3, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in sorting order of \"Last Name\" data field in \"New Peron\" window."));
		
	}
	
	@Test(priority=31,description="To verify that user is able to close \"New Person\" window.")
	public void PV_CrimeMapping_34() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"X\"(close)  button of \"New Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Person\" window."));
	}
	
	@Test(priority=32,description="To verify that user is able to perform \"Cancel\" functionality of \"New Person\" window.")
	public void PV_CrimeMapping_35() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\"  button of \"New Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Person\" window and \"New Person\" window should close."));
	}
	
	@Test(priority=33,description="To verify that user gets validation message for add person in \"Person\" section which is already added for particular saved crime.")
	public void PV_CrimeMapping_36() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Search Category\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_newperson_win)).sendKeys("Jesal");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter search criteria into \"Search\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Search\" icon button.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_add_first)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Add\" button of person which want to add.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "This person is already associated in the current record.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get toast validation like \"This person is already associated in the current record.\"."));
		
	}
	
	@Test(priority=34,description="To verify that user gets validation message when perform \"Cancel\" functionality after adding details in \"New Person\" window.")
	public void PV_CrimeMapping_37() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_newperson_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"New Person\" button from \"New Person\" window.");
		
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).sendKeys("Complainant");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select Associated Type\" from  respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).sendKeys("Rahul");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First name into \"First Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).sendKeys("Mohanbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name into \"Middle Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).sendKeys("Patel");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name into \"Last Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_age_newpr_win)).sendKeys("24");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter \"Age\" in respective field.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_gen_newpr_win)).sendKeys("Male");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Select \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_add1_newpr_win)).sendKeys("A/123 Nikunj park,Thaltej");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter address into \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_state_newpr_win)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Select \"State\" from \"State\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_dist_newpr_win)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select \"District\" from \"District\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_pin_newpr_win)).sendKeys("380052");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Enter PIN Code into \"PIN Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_phoneno_newpr_win)).sendKeys("9999911111");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter Phone Number into \"Phone Number 2 \" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_altphoneno_newpr_win)).sendKeys("9999922222");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Enter alternate phone number into \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_email_newpr_win)).sendKeys("rp@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Enter Email Id into \"Email Id\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse_newpr_win)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Upload file of person in \"Select image\" field.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Click on \"Cancel\"  button of \"New Person\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Person\" window should close."));
	}
	
	@Test(priority=35,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Person\" window.")
	public void PV_CrimeMapping_38() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Person\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Person");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_newperson_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"New Person\" button from \"New Person\" window.");
		
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).sendKeys("Complainant");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select Associated Type\" from  respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).sendKeys("Rahul");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter First name into \"First Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).sendKeys("Mohanbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Middle Name into \"Middle Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).sendKeys("Patel");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Last Name into \"Last Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Cancel\"  button of \"New Person\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-166</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Person\" window shouldn't close."));
	}
	
	@Test(priority=36,description="To verify that user is able to get \"Add Police Persons\" window by performing \"Add Police Person\" functionality from dropdown list.")
	public void PV_CrimeMapping_39() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		WebElement el1=driver.findElement(By.xpath(CrimeMapping_repository.btn_save1));
		Coordinates co1=((Locatable)el1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Add Police Personnels");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>User should get \"Add Police Persons\" window with following :</br>"
				+ "1. Buttons: \"Cancel\", \"Save\", \"X\", \"Next\", \"Previous\", page control button.</br>"
				+ "2. Dropdown: \"Show entries\".</br>"
				+ "3. Columns: \"Username\" , \"Badge Number\" , \"Designation\".</br>"
				+ "4. Checkboxes for select police persons. "));
	}
	
	@Test(priority=37,description="To verify that user is able to add police person in any particular saved crime by performing \"Add Police Person\" functionality from dropdown list.")
	public void PV_CrimeMapping_40() throws InterruptedException 
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).sendKeys("Madhav");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_pptable)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).sendKeys("Hill");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_pptable)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select one or more police persons by selecting checkboxes from list of police persons available in \"Add Police Personnels\" window.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button of \"Add Police Personnels\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_ppsec)).getText(), "Hill");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText(), "Showing 1 to 2 of 2 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Add Police Personnels\" window.</br>"
				+ "2. Added police persons for selected crime should display in list of \"Police Personnel\" section of that crime."));
	}
	
	@Test(priority=38,description="To verify that user is able to close \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_41() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(1000);
		
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"X\"(close) button of \"Add Police Personnels\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Add Police Personnels\" window."));
	}
	
	@Test(priority=39,description="To verify that user is able to perform \"Cancel\" functionality of \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_42() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Add Police Personnels\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Police Personnels\" window and \"Add Police Personnels\" window should close."));
	}
	
	@Test(priority=40,description="To verify that user is able to perform \"Search\" functionality of \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_43() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).sendKeys("Megh");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter search criteria into \"Search\" text-box of \"Add Police Personnels\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_pptable)).getText(), "Megha");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get searched result in \"Add Police Personnels\" window."));
	}
	
	
	@Test(priority=41,description="To verify that user is able to perform pagination functionality of \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_44(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of \"Add Police Personnels\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 11 to 20 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records in \"Add Police Personnels\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of \"Add Police Personnels\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records in \"Add Police Personnels\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_3)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. from \"Add Police Personnels\" window.");
		Assert.assertNotEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get selected page no. records in \"Add Police Personnels\" window."));
	}
	
	@Test(priority=42,description="To verify that user is able to perform Show No. of entries functionality of \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_45() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		String[] b=s1.split(" "); 
		String c= b[5];
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.entries_25)).click();
		Thread.sleep(1000);
		WebElement el1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries));
		Coordinates co1=((Locatable)el1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		String[] b1=s2.split(" "); 
		String c1= b1[3];
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from the \"Show No. of entries\" dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to "+ c1 +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Add Police Personnels\" window."));
	}
	
	@Test(priority=43,description="To verify that user is able to perform sorting functionality of columns present in \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_46(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).click();
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Sorting\" icon of the \"First Name\" column.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in alphabetical sorting order of \"First Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).click();
		Thread.sleep(2000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Sorting\" icon of the \"Last Name\" column.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in alphabetical sorting order of \"Last Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno)).click();
		Thread.sleep(2000);
		String s5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"Badge Number\" column.");
		String s6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Badge Number\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_designation)).click();
		Thread.sleep(2000);
		String s7=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_designation)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_designation)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Sorting\" icon of the \"Designation\" column.");
		String s8=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_designation)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in sorting order of \"Designation\" data fields."));
	}
	
	@Test(priority=44,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Adding details in \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_47() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).sendKeys("Megha");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_pptable)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Add Police Personnels\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Add Police Personnels\" window should also close."));
		
	}
	
	@Test(priority=45,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Add Police Personnels\" window.")
	public void PV_CrimeMapping_48() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Police Personnel\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).sendKeys("Megha");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_pptable)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Add Police Personnels\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Add Police Personnels\" window shouldn't close."));
	}
	
	@Test(priority=46,description="To verify that user is able to get \"Add Attachment\" window by performing \"Add Attachment\" functionality from dropdown list.")
	public void PV_CrimeMapping_49() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Attachment\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Add Attachment\" window with following :</br>"
				+ "1. Buttons: \"Cancel\", \"Save\", \"X\"(close).</br>"
				+ "2. Dropdown: \"Attachment Type\" , \"Attachment\".</br>"
				+ "3. Text-box : \"Description\"."));
	}
	
	@Test(priority=47,description="To verify that user is able to add attachment in any particular saved crime by performing \"Add Attachment\" functionality from dropdown list.")
	public void PV_CrimeMapping_50() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Attachment\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Identity");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select attachment type from \"Attachment Type\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select file from file browse window and click on \"Open\" button of window.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("This is identity attachment.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Save\" button of \"Add Attachment\" window.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_att_attsec)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Add Attachment\" window.</br>"
				+ "2. Added attachment for selected crime should display in list of \"Attachment\" section of that crime."));
	}
	
	@Test(priority=48,description="To verify that user is able to close \"Add Attachment\" window.")
	public void PV_CrimeMapping_51() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Attachment\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"X\"(close) button of \"Add Attachment\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Add Attachment\" window."));
	}
	
	@Test(priority=49,description="To verify that user is able to perform \"Cancel\" functionality of \"Add Attachment\" window.")
	public void PV_CrimeMapping_52() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Attachment\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Add Attachment\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Attachment\" window and \"Add Attachment\" window should close."));
	}

	@Test(priority=50,description="To verify that user gets validation message when perform \"Save\" functionality with blank required details of \"Add Attachment\" window.")
	public void PV_CrimeMapping_53() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Attachment\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button without filling mandatory details of \"Add Attachment\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_fileupload)).getText(), "The Attachment field is required.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"The Attachment field is required.\" below respective field."));
	}
	
	@Test(priority=51,description="To verify that user gets validation message when perform \"Cancel\"/ functionality after Adding details in \"Add Attachment\" window.")
	public void PV_CrimeMapping_54() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Attachment\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Identity");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select attachment type from \"Attachment Type\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select file from file browse window and click on \"Open\" button of window.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("This is identity attachment.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of \"Add Attachment\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Add Attachment\" window should also close."));
	}
	
	@Test(priority=52,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Add Attachment\" window.")
	public void PV_CrimeMapping_55() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Attachment\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Identity");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select attachment type from \"Attachment Type\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select file from file browse window and click on \"Open\" button of window.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("This is identity attachment.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of \"Add Attachment\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Add Attachment\" window shouldn't close."));
	}
	
	@Test(priority=53,description="To verify that user is able to edit any particular saved crime by performing \"Edit Crime\" functionality from dropdown list.")
	public void PV_CrimeMapping_56() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.verify_recno_first)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editcrime)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit Crime\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Edit Crime (Record No." +s1+")");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Murder");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit selection of type of crime from \"Select Crime\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)).sendKeys("Enter Coordinates");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of location from \"Select Location\" dropdown.");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long)).sendKeys("72.549830");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat)).sendKeys("23.027090");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit Longitude and Latitude values from respective text-boxes.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-29-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit selection of Crime Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit selection of Crime End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).sendKeys("Edit Test2.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit Crime Incident Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).sendKeys("Test Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit Crime description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_registercrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Click on \"Update\" button of \"Edit Crime\" page.");
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\"/ button of \"Edit Crime\" page and redirect back to \"Crime Mappings\" page.</br>"
				+ "2. Edited details should update on portal."));
		
	}
	
	
	
	
	
	@Test(priority=54,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Crime\" page.")
	public void PV_CrimeMapping_57() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.verify_recno_first)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editcrime)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit Crime\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Edit Crime (Record No." +s1+")");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Edit Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Crime\" page and redirect back to \"Crime Mappings\" page."));
	}
	
	@Test(priority=55,description="To verify that user is able to get back to \"Home\" page from \"Edit Crime\" page by clicking on \"Home\" icon.")
	public void PV_CrimeMapping_58() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test2.");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.verify_recno_first)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "This is Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editcrime)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit Crime\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Edit Crime (Record No." +s1+")");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Home\" icon in \"Edit Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Edit Crime\" page."));
	}
	
	@Test(priority=56,description="To verify that user is able to get \"New Event\" page by performing \"Add Event\" functionality from dropdown list.")
	public void PV_CrimeMapping_59() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_ipc_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selelocation_addeventsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat_addeventsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long_addeventsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.repoTime_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_addeventsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).isDisplayed(), true);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"New Event\" page with following two sections : Window section , Map.</br>"
				+ "1. Window section contains following : \r\n"
				+ "1.1. Dropdowns: \"Select Event\",\"Severity\", \"Select Location\".\r\n"
				+ "1.2. Text-boxes : \"IPC\" , \"Latitude\" , \"Longitude\" , \"Event Time\" , \"Event End Time\" , \"Reporting Time\",\",\"Summary\" , \"Description\".\r\n"
				+ "1.3. Buttons : \"Cancel\" ,\"Save\".\r\n"
				+ "2. Map contains following :\r\n"
				+ "Icon Buttons : Kebab Menu (3 vertical dot) , \"Tools\",\"+\"(Zoom in) , \"-\"(Zoom out) , \"Home\" (Reset perspective) , \"Compass\"."));
	}
	
	@Test(priority=57,description="To verify that user is able to add event under any particular saved crime by performing \"Add Event\" functionality from dropdown list.")
	public void PV_CrimeMapping_60() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Attempt to Murder (E)");
		Thread.sleep(7000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select event from \"Select Event\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("High");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_ipc_crime)).sendKeys("section 307");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"IPC\" of crime into respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selelocation_addeventsec)).sendKeys("Enter Coordinates");
		Thread.sleep(7000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select \"Enter Coordinates\" option from \"Select Location\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long_addeventsec)).sendKeys("72.551505");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Longitude value in \"Longitude\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat_addeventsec)).sendKeys("23.022887");
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Latitude value in \"Latitude\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-29-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Select Event Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-29-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select Event End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventsec)).sendKeys("This is Event.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter Crime event Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_addeventsec)).sendKeys("Test event Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Enter Crime event description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Click on \"Save\" button from \"New Event\" page.");
		
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).getText(), "Event Information");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Event\" page navigate to \"Crime Mappings\" page.</br>"
				+ "2. Added event should display under crime in which event is added in \"Crime Mappings\" page.</br>"
				+ "3. Added event of crime should display on map."));
	}
	
	@Test(priority=58,description="To verify that user is able to perform \"Cancel\" functionality of  \"New Event\" page.")
	public void PV_CrimeMapping_61() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\"  button of \"New Event\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Event\" page and back to \"Crime Mappings\" page."));
	}
	
	@Test(priority=59,description="To verify that user is able to get back to \"Home\" page from \"New Event\" page by clicking on \"Home\" icon.")
	public void PV_CrimeMapping_62() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_Home)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Home\" icon from \"New Event\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"New Event\" page."));
	}
	
	@Test(priority=60,description="To verify that user gets validation messages when perform \"Save\" functionality of \"New Event\" page with selection of \"Current Location\" option and blank mandatory details.")
	public void PV_CrimeMapping_63() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button without filling mandatory fields.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_summary_addeventsec)).getText(), "The Summary field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_ipc_addeventsec)).getText(), "The IPC field is required.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like :</br>"
				+ "\"The IPC field is required.\" </br>"
				+ "\"The Summary field is required.\" below respective fields."));
	}
	
	@Test(priority=61,description="To verify that user gets validation messages when perform \"Save\" functionality of \"New Event\" page with selection of \"Enter Coordinates\" option and blank mandatory details.")
	public void PV_CrimeMapping_64() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selelocation_addeventsec)).sendKeys("Enter Coordinates");
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Enter Coordinates\" option from \"Select Location\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button without filling mandatory fields.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_summary_addeventsec)).getText(), "The Summary field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_ipc_addeventsec)).getText(), "The IPC field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_long_addeventsec)).getText(), "The Longitude field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_lat_addeventsec)).getText(), "The Latitude field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation messages like :</br>"
				+ "\"The IPC field is required.\" ,</br>"
				+ "\"The Longitude field is required.\" ,</br>"
				+ "\"The Latitude field is required.\",</br>"
				+ "\"The Summary field is required.\" below respective fields."));
		
	}
	
	@Test(priority=62,description="To verify that user gets validation message when select invalid date or time for \"Event Time\" from Date & Time Picker of \"New Event\" form.")
	public void PV_CrimeMapping_65(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.add(Calendar.DATE, 1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		 
		//enter tomorrow's date in the field 
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		Thread.sleep(1000);
		WebElement tomDate = driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)); 
		tomDate.sendKeys(tommorowsDate); 
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_ipc_crime)).click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select invalid \"Event Time\" and fill all required details in \"New Event\" form.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "Start Date-Time Must Not Be Of Future");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : </br>1. User should able to select invalid \"Event Time\" from date & time picker.</br>"
				+ "2. User should get validation message like \"Start Date-Time Must Not Be Of Future\" below respective field."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=63,description="To verify that user gets validation message when select invalid date or time for \"Event End Time\" from Date & Time Picker of \"New Event\" form.")
	public void PV_CrimeMapping_66(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.add(Calendar.DATE, 1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		 
		//enter tomorrow's date in the field 
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		Thread.sleep(1000);
		WebElement tomDate = driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)); 
		tomDate.sendKeys(tommorowsDate);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_ipc_crime)).click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select invalid \"Event End Time\" and fill all required details in \"New Event\" form.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "End Date-Time Must Not Be Of Future");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : </br>1. User should able to select invalid \"Event End Time\" from date & time picker.</br>"
				+ "2. User should get validation message like \"End Date-Time Must Not Be Of Future\" below respective field."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	
	}
	
	@Test(priority=64,description="To verify that user gets validation message when select  \"Event End Time\" is earlier than Event start time from Date & Time Picker of \"New Event\" form.")
	public void PV_CrimeMapping_67(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.contextClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Right-click on particular crime from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addevent)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Add Event\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "New Event");
		Date dt = new Date(); 
		 
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(dt); 
		calendar.roll(Calendar.DATE, -1); 
		dt = calendar.getTime(); 
		 
		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt); 
		 
		//enter tomorrow's date in the field 
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		Thread.sleep(1000);
		WebElement tomDate = driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)); 
		tomDate.sendKeys(tommorowsDate);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_ipc_crime)).click();
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select Event End Date is earlier than Event Start Date.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText(), "End Date-Time Must Not Be Earlier Than Start Date-Time");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like \"End Date-Time Must Not Be Earlier Than Start Date-Time\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	
	}
	
	@Test(priority=65,description="To verify that user is able to perform \"Add Event Detail\" functionality for particular crime event.")
	public void PV_CrimeMapping_68(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-Click on particular event of \"Crime\".");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addperson)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addpp)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addattachment)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_editevent)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_addeventdetail)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard)).isDisplayed(), true);
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addeventdetail)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Add Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).sendKeys("Test Event detail summary.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Summary\" of new event in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).sendKeys("Test Event details.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"Details\" of new event in \"Details\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Save\" button of \"New Event Detail\" window.");
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e3).perform();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_added_eventdetail)).getText(), "Test Event detail summary.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_added_eventdetail)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).getText(), "Event Detail Information");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Event Detail\" window and window should close.</br>"
				+ "2. Added event details should display under that particular event."));
	}
	
	@Test(priority=66,description="To verify that user is able to get details of Crime or Crime Event by clicking on crime from \"Crime Tree\" section in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_24() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Event\" from \"Crime Tree\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_added_eventdetail)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).getText(), "Event Detail Information");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.recordno_crimeinfo)).getText(), "Summary");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on particular crime/crime event from \"Crime Tree\" section in \"Crime Mapping\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).getText(), "Event Information");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.recordno_crimeinfo)).getText(), "Event Time");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Event Information\" of saved crime event with following details : </br>"
				+ "\"Event Time\" , \"Event End Time\" , \"Reporting Time\" ,\"Severity\" ,\"Summary\" , \"Description\" ,\"Investigation Status\",\"Description\" ,\"Sequence\",\"Creator Name\",\"Creation Time\"."));
	}
	
	
	@Test(priority=67,description="To verify that user is able to perform \"Search\" functionality from \"Crime Mappings\" page.")
	public void PV_CrimeMapping_25() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).size()!=0, false);
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_crimemapping)).sendKeys("This is Event");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).isDisplayed(), true);
	}
	
	
	@Test(priority=68,description="To verify that user is able to close \"New Event Detail\" window.")
	public void PV_CrimeMapping_69() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-Click on particular event of \"Crime\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addeventdetail)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Add Event Detail\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on close(\"X\") button of \"New Event Detail\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Event Detail\" window."));
	}
	
	@Test(priority=69,description="To verify that user is able to perform \"Cancel\" functionality of  \"New Event Detail\" window.")
	public void PV_CrimeMapping_70() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-Click on particular event of \"Crime\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addeventdetail)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Add Event Detail\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"New Event Detail\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"New Event Detail\" window and \"New Event Detail\" window should close."));
	}
	
	@Test(priority=70,description="To verify that user gets validation message while perform \"Save\" functionality of \"New Event Detail\" with blank required details.")
	public void PV_CrimeMapping_71() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-Click on particular event of \"Crime\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addeventdetail)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Add Event Detail\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Save\" button without entering mandatory details of \"New Event Detail\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_summary_addeventdetail)).getText(), "The Summary field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_details_addeventdetail)).getText(), "The Details field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should gets validation message like </br>"
				+ "\"The Summary field is required.\",</br>"
				+ "\" The Details field is required.\" below their respective fields."));
	}
	
	@Test(priority=71,description="To verify that user gets validation message when perform \"Cancel\" functionality after adding details into \"New Event Detail\" window.")
	public void PV_CrimeMapping_72() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-Click on particular event of \"Crime\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addeventdetail)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Add Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).sendKeys("Test Event detail summary.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Summary\" of new event in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).sendKeys("Test Event details.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"Details\" of new event in \"Details\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of \"New Event Detail\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Event Detail\" window should also close."));
	}
	
	@Test(priority=71,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Event Detail\" window.")
	public void PV_CrimeMapping_73() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-Click on particular event of \"Crime\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_addeventdetail)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Add Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "New Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).sendKeys("Test Event detail summary.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter \"Summary\" of new event in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).sendKeys("Test Event details.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"Details\" of new event in \"Details\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of \"New Event Detail\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Event Detail\" window shouldn't close."));
	}
	
	@Test(priority=73,description="To verify that user is able to perform \"Edit Event Detail\" functionality for particular event.")
	public void PV_CrimeMapping_74() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Event\" from \"Crime Tree\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_added_eventdetail)).click();
		Thread.sleep(2000);
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_added_eventdetail));
		act.contextClick(e3).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right-Click on particular event detail of \"Crime Event\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editeventdetails)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Edit Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).sendKeys("Edit Event detail summary.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit \"Summary\" of new event from \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).sendKeys("Test edit Event details.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit \"Details\" of new event from \"Details\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Save\" button of \"Edit Event Detail\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).getText(), "Edit Event detail summary.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Edit Event Detail\" window and window should close.</br>"
				+ "2. Edited details of event should update on portal accordingly."));
	}
	
	@Test(priority=74,description="To verify that user is able to close \"Edit Event Detail\" window.")
	public void PV_CrimeMapping_75() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Event\" from \"Crime Tree\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).click();
		Thread.sleep(2000);
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail));
		act.contextClick(e3).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right-Click on particular event detail of \"Crime Event\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editeventdetails)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Edit Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on close(\"X\") button of \"Edit Event Detail\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Event Detail\" window."));
	}
	
	@Test(priority=75,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Event Detail\" window.")
	public void PV_CrimeMapping_76() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Event\" from \"Crime Tree\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).click();
		Thread.sleep(2000);
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail));
		act.contextClick(e3).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right-Click on particular event detail of \"Crime Event\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editeventdetails)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Edit Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Cancel\" button of \"Edit Event Detail\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Event Detail\" window and \"Edit Event Detail\" window should close."));
	}
	
	@Test(priority=76,description="To verify that user gets validation message when perform \"Cancel\" functionality after editing details into \"Edit Event Detail\" window.")
	public void PV_CrimeMapping_77() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Event\" from \"Crime Tree\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).click();
		Thread.sleep(2000);
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail));
		act.contextClick(e3).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right-Click on particular event detail of \"Crime Event\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editeventdetails)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Edit Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).sendKeys("Test Event detail summary.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit \"Summary\" of new event from \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).sendKeys("Test edit Event details.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit \"Details\" of new event from \"Details\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of \"Edit Event Detail\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Event Detail\" window should also close."));
	}
	
	@Test(priority=77,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Event Detail\" window.")
	public void PV_CrimeMapping_78() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Event\" from \"Crime Tree\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).click();
		Thread.sleep(2000);
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail));
		act.contextClick(e3).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right-Click on particular event detail of \"Crime Event\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editeventdetails)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Edit Event Detail\" option from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Event Detail");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_addeventdetail)).sendKeys("Test Event detail summary.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit \"Summary\" of new event from \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_details_addevebtdetail)).sendKeys("Test edit Event details.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit \"Details\" of new event from \"Details\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of \"Edit Event Detail\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Event Detail\" window shouldn't close."));
	}
	
	@Test(priority=78,description="To verify that user is able to discard functionality added Event Detail from \"Crime Mapping\" page.")
	public void PV_CrimeMapping_79() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.doubleClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Event\" from \"Crime Tree\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).click();
		Thread.sleep(2000);
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_edited_eventdetail));
		act.contextClick(e3).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right-Click on particular event detail of \"Crime Event\".");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Discard\" option from dropdown list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.verify_edited_eventdetail)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation  message popup and validatin message popup should close.</br>"
				+ "2. User should get toast validation message like \"Successfully discarded!\" .</br>"
				+ "3. Discarded event detail should remove from portal."));
	}
	
	@Test(priority=79,description="To verify that user is able to perform \"Edit Event\" functionality of particular Crime Event.")
	public void PV_CrimeMapping_80() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-click on particular crime event from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editevent)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Edit Event\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Attempt to Murder (E)");
		Thread.sleep(7000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of event from \"Select Event\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit selection of Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_ipc_editevent)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_ipc_editevent)).sendKeys("section 306");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit \"IPC\" of crime into respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selelocation_addeventsec)).sendKeys("Enter Coordinates");
		Thread.sleep(7000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit selection of any of option from \"Select Location\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long_addeventsec)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long_addeventsec)).sendKeys("72.551510");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit Longitude value from \"Longitude\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat_addeventsec)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat_addeventsec)).sendKeys("23.022889");
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit Latitude value from \"Latitude\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-30-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit selection of Event Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-30-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit selection of Event End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_editevent)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary_editevent)).sendKeys("Edit Crime Event.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Edit Crime event Summary from \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_addeventsec)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_addeventsec)).sendKeys("Test event Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Edit Crime event description from \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Click on \"Save\" button from \"Edit Event\" page.");
		WebElement e3= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e3).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "Edit Crime Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).getText(), "Event Information");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Event\" page and navigate to \"Crime Mappings\" page.</br>"
				+ "2. Edited event details  should update on portal."));
	}
	
	@Test(priority=80,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Event\" page.")
	public void PV_CrimeMapping_81() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-click on particular crime event from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_editevent)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Edit Event\" option from dropdown list.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Event\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should redirect back to \"Crime Mappings\" page from \"Edit Event\" page."));
		
	}
	
	@Test(priority=81,description="To verify that user is able to \"Cancel\" validation message of discard crime event record.")
	public void PV_CrimeMapping_83() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-click on particular crime event from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Discard\" option from dropdown list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=82,description="To verify that user is able to perform \"Discard\" functionality of particular Crime Event.")
	public void PV_CrimeMapping_82() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test2.");
		Actions act = new Actions(driver);
		WebElement e1= driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree));
		act.doubleClick(e1).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon of \"Crime\" from \"Crime Tree\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).getText(), "This is Event.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).click();
		Thread.sleep(1000);
		WebElement e2= driver.findElement(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree));
		act.contextClick(e2).perform();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Right-click on particular crime event from \"Crime Tree\" section in \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Discard\" option from dropdown list.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.verify_crimeevent_ceimetree)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. User should get toast validation message like \"Successfully discarded!\".</br>"
				+ "3. Selected particular crime event should discarded from portal."));
	}
	
	@Test(priority=83,description="To verify that user is able to get \"Attachment\" section of particular selected crime in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_84() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_addattachment)).isDisplayed(), true);
		
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.searchbox_attachmentsec)).isDisplayed(), true);
		
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_attatype_attsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_view_attsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desc_attsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_type_attsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatorname)).isDisplayed(), true);
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.scroll_to_hori));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodiname_attsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodificationtime)).isDisplayed(), true);
		
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creationtime)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Attachment\" section of selected crime with following :</br>"
				+ "1. List of attachment of selected crime(if added).</br>"
				+ "2. Buttons : \"+Add Attachment\" , \"Next\" , \"Previous\",Page control No. , \"Actions\" dropdown.</br>"
				+ "3. Text-box : \"SEARCH\".</br>"
				+ "4. Data table of added attachments with column fields like :</br> \"Actions\" , \"AttachmentType\" , \"View\" , \"Description\",\"Type\" , \"Creator Name\" ,Creation Time\" , \"Last Modifier Name\" , \"Last Modification Name."));
	}
	
	@Test(priority=84,description="To verify that user is able to add attachment for particular crime by performing \"Add Attachment\" functionality from \"Attachment\" section in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_85() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addattachment)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"+Add Attachment\" button from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Add Attachment");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Crime Attachment");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select attachment type from \"Attachment Type\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\download.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select file from file browse window and click on \"Open\" button of window.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("Test1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Save\" button of \"Add Attachment\" window.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Thread.sleep(1000);	
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Add Attachment\" window.</br>"
				+ "2. Added attachment for selected crime should display in list of \"Attachment\" section of that crime."));
	}
	
	@Test(priority=85,description="To verify that user is able to view added attachment by clicking on visibility icon from \"Attachment\" section of selected crime in \"Crime Mapping\" page.")
	public void PV_CrimeMapping_86(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_viewatta_attsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click to view attachment icon of particular attachment from \"Attachment\" section.");
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
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get existing attachment in new tab of browser."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.close();
		
		driver.switchTo().window(parent);
		String Title_parent=driver.switchTo().window(parent).getTitle();
		System.out.println(Title_parent);
		Assert.assertNotEquals(Title_child, Title_parent);
		}
		}
		
	}
	
	@Test(priority=86,description="To verify that user is able to get \"Attachment Detail\" window by performing \"View Detail\" functionality from \"Actions\" dropdown of particular attachment in \"Attachment\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_87() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_viewdetail)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"View Detail \" button of particular attachment from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Attachment Detail");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_view_attdetails_win)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Attachment Detail\" window with following :</br>"
				+ "1. Buttons: \"X\"(close).</br>"
				+ "2. Pre filled details of crime record like : \"Attachment Type\" , \"Description\", \"Creator Name(Badge No)\" , \"creation Time\" , \"Last Modifier Name (BadgeNo)\", \"Last Modification Time\".</br>"
				+ "3. Link : \"View\" attachment."));
		Thread.sleep(1000);
	}
	
	@Test(priority=87,description="To verify that user is able to close \"Attachment Detail\" window.")
	public void PV_CrimeMapping_88() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_viewdetail)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"View Detail \" button of particular attachment from \"Attachment\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on close(\"X\") button of \"Attachment Detail\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Attachment Detail\" window."));
	}
	
	@Test(priority=88,description="To verify that user is able to view attachment of selected crime record by clicking on \"View\" link from \"Attachment Detail\" window.")
	public void PV_CrimeMapping_89(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_viewdetail)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"View Detail \" button of particular attachment from \"Attachment\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_view_attdetails_win)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"View\" link from \"Attachment Detail\" window.");
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
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get attachment of crime record in new tab of browser."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.close();
		
		driver.switchTo().window(parent);
		String Title_parent=driver.switchTo().window(parent).getTitle();
		System.out.println(Title_parent);
		Assert.assertNotEquals(Title_child, Title_parent);
		}
		}
	}
	
	@Test(priority=89,description="To verify that user is able to edit attachment by performing \"Edit\" functionality from \"Actions\" dropdown of particular attachment in \"Attachment\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_90() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular attachment which want to edit from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Attachment");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Identity");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit attachment type from \"Attachment Type\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit attachment file by uploading new attachment file from \"Attachment\" field.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("Test Edit attachment functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit description from \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Save\" button of \"Edit Attachment\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_desc_attsec)).getText(), "Test Edit attachment functionality.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Attachment\" window and window should close.</br>"
				+ "2. Edited details of attachment should update on portal."));
	}
	
	@Test(priority=90,description="To verify that user is able to view existing attachment by clicking on \"View\" link from \"Edit Attachment\" window.")
	public void PV_CrimeMapping_91(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular attachment which want to edit from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Attachment");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_view_attdetails_win)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"View\" link from \"Edit Attachment\" window.");
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
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get attachment of crime record in new tab of browser."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.close();
		
		driver.switchTo().window(parent);
		String Title_parent=driver.switchTo().window(parent).getTitle();
		System.out.println(Title_parent);
		Assert.assertNotEquals(Title_child, Title_parent);
		}
		}
		
	}
	
	@Test(priority=91,description="To verify that user is able to close \"Edit Attachment\" window.")
	public void PV_CrimeMapping_92() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular attachment which want to edit from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Attachment");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"X\"(close) button of \"Edit Attachment\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Attachment\" window."));
	}
	
	@Test(priority=92,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Attachment\" window.")
	public void PV_CrimeMapping_93() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular attachment which want to edit from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Attachment");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Attachment\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Attachment\" window and \"Edit Attachment\" window should close."));
		
	}
	
	@Test(priority=93,description="To verify that user gets validation message when perform \"Cancel\" functionality after editing details in \"Edit Attachment\" window.")
	public void PV_CrimeMapping_94() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular attachment which want to edit from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Attachment");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Crime Attachment");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit attachment type from \"Attachment Type\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit attachment file by uploading new attachment file from \"Attachment\" field.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("Test attachment functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit description from \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Cancel\" button of \"Edit Attachment\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Attachment\" window should also close."));
	}
	
	@Test(priority=94,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Attachment\" window.")
	public void PV_CrimeMapping_95() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular attachment which want to edit from \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Attachment");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Crime Attachment");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit attachment type from \"Attachment Type\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit attachment file by uploading new attachment file from \"Attachment\" field.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("Test attachment functionality.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit description from \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Cancel\" button of \"Edit Attachment\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Attachment\" window shouldn't close."));
	}
	
	@Test(priority=95,description="To verify that user is able to discard attachment by performing \"Discard\" functionality from \"Actions\" dropdown of particular attachment in \"Attachment\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_96() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Discard\" button of particular attachment which want to delete from \"Attachment\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and message pop up should close.</br>"
				+ "2. User should get validation message like : \"Successfully discarded!\".</br>"
				+ "3. Selected attachment record should delete from \"Attachment\" section."));
	}
	
	@Test(priority=96,description="To verify that user is able to \"Cancel\" validation message of discard attachment record.")
	public void PV_CrimeMapping_97() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Discard\" button of particular attachment which want to delete from \"Attachment\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=97,description="To verify that user is able to perform \"SEARCH\" functionality of \"Attachment\" section of particular selected crime.")
	public void PV_CrimeMapping_98() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_attachmentsec)).sendKeys("Test1");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_desc_attsec)).getText(), "Test1");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
	}
	
	@Test(priority=98,description="To verify that user is able to perform pagination functionality of \"Attachment\" section of particular selected crime.")
	public void PV_CrimeMapping_99(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		
		for(int i=2;i<12;i++)
		{
			driver.findElement(By.xpath(CrimeMapping_repository.btn_addattachment)).click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Add Attachment");
			driver.findElement(By.xpath(CrimeMapping_repository.dd_atttype_attwin)).sendKeys("Identity");
			Thread.sleep(1000);
			driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\download.jpg");
			Thread.sleep(1000);
			driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des_attwin)).sendKeys("Test"+i);
			Thread.sleep(1000);
			driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
			Thread.sleep(4000);
		}
		
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5]; 
		System.out.println(c);
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).click();
		Thread.sleep(3000);
		String[] b1=s1.split(" "); 
		String d= b1[5]; 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Next\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of the attachment in \"Attachment\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Previous\" button of the paging.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 10 of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of the attachment in \"Attachment\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_2)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on particular page no. in \"Attachment\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 11 to " + d +" of " + c + " entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get attachment records as per selected page no. in \"Attachment\" section."));
		
	}
	
	@Test(priority=99,description="To verify that user is able to perform Show No. of entries functionality of \"Attachment\" section of particular selected crime.")
	public void PV_CrimeMapping_100() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).sendKeys("25");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Attachment\" section."));
	}
	
	@Test(priority=100,description="To verify that user is able to perform sorting functionality for the \"Attachment Type\" , \"Description\" , \"Creator Name\" , \"Creation Time\" columns of \"Attachment\" section in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_101(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Attachment\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_attatype_attsec)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_attatype_attsec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_attatype_attsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Sorting\" icon of the \"Attachment Type\" column.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_attatype_attsec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in alphabetical sorting order of \"Attachment Type\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desc_attsec)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desc_attsec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desc_attsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Sorting\" icon of the \"Description\" column.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desc_attsec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in sorting order of \"Description\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatname_attsec)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatname_attsec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatname_attsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"Creator Name\" column.");
		String s6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatname_attsec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Creator Name\" data fields."));
		
	}
	
	@Test(priority=101,description="To verify that user is able to get \"Person\" section of particular selected crime in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_102() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_addperson)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_pre_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assotype_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_age_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_gender_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_img_persec)).isDisplayed(), true);
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.scroll_to_hori1_persec));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assocount_persec)).isDisplayed(), true);
		WebElement e2=driver.findElement(By.xpath(CrimeMapping_repository.scroll_to_hori2_persec));
		Coordinates co2=((Locatable)e2).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatname_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatime_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodiname_persec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodificationtime)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Person\" section of selected crime with following :</br>"
				+ "1. List of persons of selected crime(if added).</br>"
				+ "2. Buttons : \"+Add Person\" , \"Next\" , \"Previous\",Page control No. , \"Actions\" dropdown.</br>"
				+ "3. Text-box : \"SEARCH\".</br>"
				+ "4. Dropdown : \"Show entries\",</br>"
				+ "5. Data table of added crimes with column fields like : </br>\"Actions\" , \"First Name\" , \"Last Name\" , \"Age\" , \"Gender\",\"Association Count\" , \"Creator Name (Badge No)\", \"Creation Time\",\"Last Modifier Name (Badge No)\", \"Last Modification Time\"."));
	}
	
	@Test(priority=102,description="To verify that user is able to add new person for particular crime by performing \"Add Person\" functionality from \"Person\" section in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_103(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addperson)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"+Add Person\" button from \"Person\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_newperson_win)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"New Person\" button from \"New Person\" window.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).sendKeys("Complainant");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select Associated Type\" from  respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).sendKeys("Krishna");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter First name into \"First Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).sendKeys("Mohanbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter Middle Name into \"Middle Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).sendKeys("Patel");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter Last Name into \"Last Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_age_newpr_win)).sendKeys("24");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Enter \"Age\" in respective field.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_gen_newpr_win)).sendKeys("Male");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Select \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_add1_newpr_win)).sendKeys("A/123 Nikunj park,Thaltej");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Enter address into \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_state_newpr_win)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select \"State\" from \"State\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_dist_newpr_win)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Select \"District\" from \"District\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_pin_newpr_win)).sendKeys("380052");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Enter PIN Code into \"PIN Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_phoneno_newpr_win)).sendKeys("9999911111");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Enter Phone Number into \"Phone Number 2 \" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_altphoneno_newpr_win)).sendKeys("9999922222");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Enter alternate phone number into \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_email_newpr_win)).sendKeys("rp@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Enter Email Id into \"Email Id\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse_newpr_win)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-25</b> : Upload file of person in \"Select image\" field.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-26</b> : Click on \"Save\" button of \"New Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Krishna");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_persec)).getText(), "Krishna");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Person\" window.</br>"
				+ "2. Added person for selected crime should display in list of \"Person\" section of that crime."));
	}
	
	@Test(priority=103,description="To verify that user is able to add existing person in any particular crime by performing \"Search\" functionality of \"New Person\" window.")
	public void PV_CrimeMapping_104() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addperson)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"+Add Person\" button from \"Person\" section.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_category_newperson_win)).sendKeys("Name");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Search Category\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_newperson_win)).sendKeys("Devanshi");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter search criteria into \"Search\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Search\" icon button.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_add_first)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Add\" button of person which want to add.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button of \"New Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Devanshi");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_persec)).getText(), "Devanshi");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Person\" window and window should close.</br>"
				+ "2. Added person should display in list of \"Person\" section of selected crime."));
	}
	
	@Test(priority=104,description="To verify that user is able to get \"Person Detail\" window by performing \"View Detail\" functionality from \"Actions\" dropdown of particular person from \"Person\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_105() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Devanshi");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_viewdetail_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"View Detail \" button of particular person from \"Person\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Person Detail");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Person Detail\" window with pre filled details of person."));
	}
	
	@Test(priority=105,description="To verify that user is able to close \"Person Detail\" window.")
	public void PV_CrimeMapping_106() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Devanshi");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_viewdetail_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"View Detail \" button of particular person from \"Person\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Person Detail");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"X\"(close) button of \"Person Detail\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Person Detail\" window."));
	}
	
	@Test(priority=106,description="To verify that user is able to edit person details by performing \"Edit\" functionality from \"Actions\" dropdown of particular Person in \"Person\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_107() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Krishna");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular person which want to edit from \"Person\" section.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).sendKeys("Complainant");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of Associated Type\" from  respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).sendKeys("Krisna");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit First name into \"First Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).sendKeys("Mohanbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit Middle Name into \"Middle Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).sendKeys("Patel");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit Last Name into \"Last Name\" text-box.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_gen_newpr_win)).sendKeys("Male");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit selection of \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_add1_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_add1_newpr_win)).sendKeys("A/123 Nikunj park,Thaltej");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Edit address into \"Address Line 1\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_state_newpr_win)).sendKeys("Gujarat");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Edit selection of \"State\" from \"State\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_dist_newpr_win)).sendKeys("Ahmedabad");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Edit selection of \"District\" from \"District\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_pin_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_pin_newpr_win)).sendKeys("380052");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Edit PIN Code into \"PIN Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_phoneno_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_phoneno_newpr_win)).sendKeys("9999911111");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Edit Phone Number into \"Phone Number 2 \" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_altphoneno_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_altphoneno_newpr_win)).sendKeys("9999922222");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Edit alternate phone number into \"Phone Number 2\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_email_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_email_newpr_win)).sendKeys("rp@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Edit Email Id into \"Email Id\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse_newpr_win)).sendKeys("C:\\Users\\neha.p\\Pictures\\user_image.jpg");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Upload file of person in \"Select image\" field.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-24</b> : Click on \"Save\" button of \"New Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Krisna");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_persec)).getText(), "Krisna");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Person\" window.</br>"
				+ "2. Edited person details should update on portal."));
	}
	
	@Test(priority=107,description="To verify that user is able to close \"Edit Person\" window.")
	public void PV_CrimeMapping_108() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Devanshi");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular person which want to edit from \"Person\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Person");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(3000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"X\"(close) button of \"Edit Attachment\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Person\" window."));
	}
	
	@Test(priority=107,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Person\" window.")
	public void PV_CrimeMapping_109() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Devanshi");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular person which want to edit from \"Person\" section.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Person");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(3000);
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Person\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Person\" window and \"Edit Person\" window should close."));
	}
	
	@Test(priority=109,description="To verify that user gets validation message when perform \"Cancel\" functionality after editing details in \"Edit Person\" window.")
	public void PV_CrimeMapping_110() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Krisna");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular person which want to edit from \"Person\" section.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).sendKeys("Complainant");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of Associated Type\" from  respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).sendKeys("Krishna");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit First name into \"First Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_midname_newpr_win)).sendKeys("Mohanbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit Middle Name into \"Middle Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lastname_newpr_win)).sendKeys("Vakeria");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit Last Name into \"Last Name\" text-box.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Cancel\" button of \"Edit Person\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Person\" window should also close."));
	}
	
	@Test(priority=110,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Person\" window.")
	public void PV_CrimeMapping_111() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Krisna");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Edit\" button of particular person which want to edit from \"Person\" section.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_associatedtype_newpr_win)).sendKeys("Complainant");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit selection of Associated Type\" from  respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_firstname_newpr_win)).sendKeys("Krishna");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit First name into \"First Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Cancel\" button of \"Edit Person\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size() != 0, true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Person\" window shouldn't close."));
	}
	
	@Test(priority=111,description="To verify that user is able to delete person record by performing \"Discard\" functionality from \"Actions\" dropdown of particular person in \"Person\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_113() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Krisna");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Discard\" button of particular person record which want to delete from \"Person\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=112,description="To verify that user is able to delete person record by performing \"Discard\" functionality from \"Actions\" dropdown of particular person in \"Person\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_112() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Krisna");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first_persec)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Actions\"->\"Discard\" button of particular person record which want to delete from \"Person\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and message pop up should close.</br>"
				+ "2. User should get validation message like : \"Successfully discarded!\".</br>"
				+ "3. Selected person record should delete from \"Person\" section."));
	}
	
	@Test(priority=113,description="To verify that user is able to perform \"SEARCH\" functionality of \"Person\" section of particular selected crime in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_114() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_personsec)).sendKeys("Jesal");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_persec)).getText(), "Jesal");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText(), "Showing 1 to 1 of 1 entries");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Person\" section of \"Crime Mappings\" page."));
	}
	
	@Test(priority=114,description="To verify that user is able to perform pagination functionality of \"Person\" section of particular selected crime  in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_115(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		
		for(int j=0;j<10;j++)
		{
			
			driver.findElement(By.xpath(CrimeMapping_repository.btn_addperson)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(CrimeMapping_repository.icon_search_newperson_win)).click();
			Thread.sleep(6000);
			List<WebElement> el = driver.findElements(By.xpath(CrimeMapping_repository.btn_add_newper_win));
			for(int i=1 ; i<2 ; i++)
				{
			
					el.get(j).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
					Thread.sleep(3000);
				}
			
		}
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Next\" button of \"Person\" section.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get next records of persons in \"Person\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_pre_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Previous\" button of \"Person\" section.");
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText();
		Assert.assertNotEquals(s3, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get previous records of persons in \"Person\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_2_persec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on any particular page No. from \"Person\" section.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get Person records as per selected page no. in \"Person\" section."));
	}
	
	@Test(priority=115,description="To verify that user is able to perform Show No. of entries functionality of \"Person\" section of particular selected crime  in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_116() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText();
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries_persec)).sendKeys("25");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec));
		Coordinates co2=((Locatable)e2).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_persec)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Person\" section."));
	}
	
	@Test(priority=116,description="To verify that user is able to perform sorting functionality for columns of \"Person\" section in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_117(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Person\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assotype_persec)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assotype_persec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assotype_persec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Sorting\" icon of the \"Association Type\" column.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assotype_persec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in sorting order of \"Association Type\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_persec)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_persec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_persec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Sorting\" icon of the \"First Name\" column.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_persec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in alphabetical sorting order of \"First Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_persec)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_persec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_persec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"Last Name\" column.");
		String s6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_persec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in alphabetical sorting order of \"Last Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_age_persec)).click();
		Thread.sleep(1000);
		String s7=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_age_persec)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_age_persec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Sorting\" icon of the \"Age\" column.");
		String s8=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_age_persec)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in sorting order of \"Age\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_gender_persec)).click();
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_gender_persec)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_gender_persec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Sorting\" icon of the \"Gender\" column.");
		String t2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_gender_persec)).getAttribute("aria-label");
		Assert.assertNotEquals(t1, t2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_5</b> : User should get records in sorting order of \"Gender\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_05");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assocount_persec)).click();
		Thread.sleep(1000);
		String t3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assocount_persec)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assocount_persec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Sorting\" icon of the \"Association Count\" column.");
		String t4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_assocount_persec)).getAttribute("aria-label");
		Assert.assertNotEquals(t3, t4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_6</b> : User should get records in sorting order of \"Association Count\" data fields."));
		
	}
	
	@Test(priority=117,description="To verify that user is able to get \"Police Personnel\" section of particular selected crime in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_118() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_add_pp)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_pre_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.searchbox_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desig_ppsec)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_asscount_ppsec)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Police Personnel\" section of selected crime with following :</br>"
				+ "1. List of Police Persons of selected crime(if added).</br>"
				+ "2. Buttons : \"+Add Police Person\" , \"Next\" , \"Previous\",Page control No. , \"Actions\" dropdown</br>"
				+ "3. Text-box : \"SEARCH\".</br>"
				+ "4. Data table of added crimes with column fields like : \"First Name\", \"Last Name\" , \" Badge Number\" , \"Designation\", \"Association Count\"."));
	}
	
	@Test(priority=118,description="To verify that user is able to add police person for particular crime by performing \"Add Police Person\" functionality from \"Police Personnel\" section in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_119() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_add_pp)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"+Add Police Person\" button from \"Police Personnel\" section");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Add Police Personnels");
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).sendKeys("Dhruvita");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_pptable)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.seach_txtbox_1st)).sendKeys("Divya");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_pptable)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select one or more police persons by selecting checkboxes from list of police persons available in \"Add Police Personnels\" window.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Save\" button of \"Add Police Personnels\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_ppsec)).sendKeys("Dhruvita");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_ppsec)).getText(), "Dhruvita");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_ppsec)).clear();
		Thread.sleep(4000);
		Assert.assertNotEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), s1);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Add Police Personnels\" window.</br>"
				+ "2. Added police persons for selected crime should display in list of \"Police Personnel\" section of that crime."));
	}
	
	@Test(priority=119,description="To verify that user is able to delete particular Police Person by performing \"Discard\" functionality from \"Police Personnel\" section in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_120() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_icon_discard_ppsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on Discard icon of particular Police Person from \"Police Personnel\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).isDisplayed(), true);
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Thread.sleep(1000);
		Assert.assertNotEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText(), s1);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and message popup should close.</br>"
				+ "2. User should get validation message like \"Successfully discarded!\".</br>"
				+ "3. Selected Police Person should discard from \"Police Personnel\" section."));
	}
	
	@Test(priority=120,description="To verify that user is able to \"Cancel\" validation message of discard Police Person record from \"Police Personnel\" section.")
	public void PV_CrimeMapping_121() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_icon_discard_ppsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on Discard icon of particular Police Person from \"Police Personnel\" section.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).isDisplayed(), true);
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText(), s1);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=121,description="To verify that user is able to perform \"SEARCH\" functionality of \"Police Personnel\" section of particular selected crime in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_122() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_ppsec)).sendKeys("Madhav");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_firstname_ppsec)).getText(), "Madhav");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Police Personnel\" section of \"Crime Mappings\" page."));
	}
	
	@Test(priority=122,description="To verify that user is able to perform pagination functionality of \"Police Personnel\" section of particular selected crime  in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_123(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_add_pp)).click();
		Thread.sleep(3000);
		
		List<WebElement> el = driver.findElements(By.xpath(CrimeMapping_repository.chbox_pp_addppwindow));
		System.out.println(el.size());
		for(int i=0 ; i<10 ; i++)
		{
			el.get(i).click();
		}
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save1)).click();
		Thread.sleep(5000);
		
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next_ppsec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Next\" button of \"Police Personnel\" section.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page records of the Police Person in \"Police Personnel\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_pre_ppsec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Previous\" button of \"Police Personnel\" section.");
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		Assert.assertNotEquals(s3, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page records of the Police Person in \"Police Personnel\" section."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_2_ppsec)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on any particular page No. from \"Police Personnel\" section.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get Police Person records as per selected page no. in \"Police Personnel\" section."));
		
	}
	
	@Test(priority=123,description="To verify that user is able to perform Show No. of entries functionality of \"Police Personnel\" section of particular selected crime  in \"Crime Mappings\" page.")
	public void PV_CrimeMapping_124() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries_ppsec)).sendKeys("25");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec));
		Coordinates co2=((Locatable)e2).getCoordinates();
		co2.onPage();
		co2.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries_ppsec)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Police Personnel\" section."));
	}
	
	@Test(priority=124,description="To verify that user is able to perform sorting functionality of columns present in \"Police Personnel\" section of \"Crime Mappings\" page.")
	public void PV_CrimeMapping_125(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_crimedetails_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Crime Details\" option from Actions dropdown of particular crime.");
		driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on particular crime from \"Crime Tree\" section in \"Crime Mappings\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Police Personnel\" tab from \"Crime Mapping\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_ppsec)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_ppsec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_ppsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Sorting\" icon of the \"First Name\" column.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_firstname_ppsec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in alphabetical sorting order of \"First Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_ppsec)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_ppsec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_ppsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of the \"Last Name\" column.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastname_ppsec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in alphabetical sorting order of \"Last Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno_ppsec)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno_ppsec)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno_ppsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"Badge Number\" column.");
		String s6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_badgeno_ppsec)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in sorting order of \"Badge Number\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desig_ppsec)).click();
		Thread.sleep(1000);
		String s7=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desig_ppsec)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desig_ppsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Sorting\" icon of the \"Designation\" column.");
		String s8=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_desig_ppsec)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in sorting order of \"Designation\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_asscount_ppsec)).click();
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_asscount_ppsec)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_asscount_ppsec)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Sorting\" icon of the \"Association Count\" column.");
		String t2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_asscount_ppsec)).getAttribute("aria-label");
		Assert.assertNotEquals(t1, t2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_5</b> : User should get records in sorting order of \"Association Count\" data fields."));
		
	}
	
	@Test(priority=125,description="To verify that user is able to get \"Edit Crime\" Page.")
	public void PV_CrimeMapping_126() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test1.");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.verify_recno_first)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Edit\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Edit Crime (Record No." +s1+")");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_lat)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_long)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.repoTime_crime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_FIRno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_Fileno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toggle_swith_crimestatus)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.img_map)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should navigate to \"Edit Crime\" page with following  pre filled crime details :</br>"
				+ "Dropdowns: \"Select Location\", \"Select Crime\",\"Severity\".</br>"
				+ "Text-boxes : \"Latitude\" , \"Longitude\" ,\"Summary\" , \"Description\" , \"Crime Time\", \"Crime End Time\" , \"Reporting Time\".</br>"
				+ "Buttons : \"Cancel\" ,\"Save\" , \"Update & Continue\" .</br>Toggle switch : for \"Investigation Status\" open/close.</br>"
				+ "2. Pre added Crime pinpoint should display on map."));
	}
	
	@Test(priority=126,description="To verify that user is able to edit crime details by performing \"Edit\" functionality from \"Actions\" dropdown of particular crime.")
	public void PV_CrimeMapping_127() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test3.");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.verify_recno_first)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Edit\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Edit Crime (Record No." +s1+")");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Auto Theft");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit selection of type of crime from \"Select Crime\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit selection of Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)).sendKeys("Click On Map");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit selection of location from \"Select Location\" dropdown.");
		WebElement el=driver.findElement(By.xpath(CrimeMapping_repository.img_map));
		int width = el.getSize().getWidth();
		Actions act = new Actions(driver);
		act.moveToElement(el);
		act.moveByOffset((width/4)-5,100).click().build().perform();
		//(width/2)-25
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click at any point of map.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-29-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit selection of Crime Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit selection of Crime End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).sendKeys("Edit Test3.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit Crime Incident Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).sendKeys("Test Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit Crime description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_registercrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Update\" button of \"Edit Crime\" page.");
		
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crimes");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test3.");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime)).getText(), "Edit Test3.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Update\" button of \"Edit Crime Page\" and redirect back to \"Crimes\" listing page.</br>"
				+ "2. Edited details of crime should update on portal."));
	}
	
	@Test(priority=127,description="To verify that user is able to perform \"Update & Continue\" functionality of \"Edit Crime\" Page.")
	public void PV_CrimeMapping_128() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test1.");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.verify_recno_first)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Edit\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Edit Crime (Record No." +s1+")");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selCrime)).sendKeys("Attempt to Murder");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Edit selection of type of crime from \"Select Crime\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit selection of Severity value from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selLocation)).sendKeys("Click On Map");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit selection of location type from \"Select Location\" dropdown.");
		WebElement el=driver.findElement(By.xpath(CrimeMapping_repository.img_map));
		int width = el.getSize().getWidth();
		Actions act = new Actions(driver);
		act.moveToElement(el);
		act.moveByOffset((width/4)-5,100).click().build().perform();
		//(width/2)-25
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click at any point of map.");
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.startdate_crime)).sendKeys("03-29-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit selection of Crime Time from Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.enddate_crime)).sendKeys("03-28-22");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit selection of Crime End Date and Time from opened Date and Time picker.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_summary)).sendKeys("Edit Test1.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Edit Crime Incident Summary in \"Summary\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_des)).sendKeys("Test Description.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Edit Crime description in \"Description\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save_continue_registercrime)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Update & Continue\" button of \"Edit Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText(), "Edit Test1");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.header_crimeinfo)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.recordno_crimeinfo)).getText(), "Record No");
		
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_map_crimemappings)).getAttribute("aria-selected"), "true");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.img_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_tools)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomout)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should navigate to \"Crime Mappings\" page.</br>"
				+ "2. Edited details of crime should update on portal."));
	}
	
	@Test(priority=128,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Crime\" page.")
	public void PV_CrimeMapping_129() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("This is Test3.");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.verify_recno_first)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Edit\" option from Actions dropdown of particular crime.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Edit Crime (Record No." +s1+")");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of \"Edit Crime\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crimes");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should redirect back to \"Crimes\" listing page from \"Edit Crime\" page."));
	}
	
	
	
	@Test(priority=129,description="To verify that user is able to \"Cancel\" validation message popup of discard Crime record from \"Crimes\" listing page.")
	public void PV_CrimeMapping_131(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Discard\" option from Actions dropdown of particular crime.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like : \r\n"
				+ "\"Are you sure?\r\n"
				+ "Are you sure you want to discard this record?\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"Cancel\" button of validation message popup and message popup should close."));
	}
	
	@Test(priority=130,description="To verify that user is able to discard particular crime by performing \"Discard\" functionality from \"Actions\" dropdown in \"Crime\" page.")
	public void PV_CrimeMapping_130(Method method) throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crimes\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Edit Test2.");
		Thread.sleep(2000);
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Actions\"->\"Discard\" option from Actions dropdown of particular crime.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like : \r\n"
				+ "\"Are you sure?\r\n"
				+ "Are you sure you want to discard this record?\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_nodataavailable)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and message popup should close.</br>"
				+ "2. User should get toast validation message like \" Successfully discarded!\".</br>"
				+ "3. Discarded record should removed from \"Crimes\" listing page."));
	}
	
	//-------Crime Analysis---------
	
	@Test(priority=131,description="To verify that user is able to get \"Crime Analysis\" page .")
	public void PV_CrimeMapping_132() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_clear)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_heatmap)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_honeycomb)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_honeycombgrid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_legend)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_tools)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.img_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_home_map)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_zoomout)).isDisplayed(), true);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to get \"Crime Analysis\" page with following :</br>"
				+ "1. Dropdowns : \r\n"
				+ "\"Select AOI\" , \r\n"
				+ "dropdown of \"Select Ward\" ,\"Select Jurisdiction\" as per selected AOI, \r\n"
				+ "\"Crime Type\" ,\r\n"
				+ "\"Severity\" ,\r\n"
				+ "\"Status\" , \r\n"
				+ "\"Period\". </br>"
				+ "2. Buttons : \"Apply\" , \"Clear\" ,\"Statistics\" .</br>"
				+ "3. Link : \"Home\" icon.\r\n"
				+ "4. Map display with following :</br>"
				+ ">> Icon buttons : \"Heat map\" , \"Honeycomb\" , \"Honeycomb Grid\",\"Legend\" , \"Hamburger menu\" , Kebab menu  , Home , \"+\" , \"-\", compass.</br>"
				+ ">> Scale : 10 km</br>"
				+ ">> Latitude , Longitude values at bottom bar of map."));
	}
	
	@Test(priority=132,description="To verify that user is able to get Crimes on map as per applied filter query for selected ward boundary   in \"Crime Analysis\" page.")
	public void PV_CrimeMapping_133() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		Select select = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		select.selectByVisibleText("Ward"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> :  Click on \"Apply\" button.");
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Apply\" button.</br>"
				+ "2. User should get crime record on map as per applied filter query for Ward boundary."));
	}
	
	@Test(priority=133,description="To verify that user is able to get Crimes on map as per applied filter query for selected jurisdiction boundary   in \"Crime Analysis\" page.")
	public void PV_CrimeMapping_134() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_jurisdiction)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Jurisdiction\" option from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_seljuris_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_juris_vastrapurpolicestation)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Jurisdiction from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> :  Click on \"Apply\" button.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Apply\" button.</br>"
				+ "2. User should get crime record on map as per applied filter query for Jurisdiction boundary."));
	}
	
	@Test(priority=134,description="To verify that user is able to get Crimes on map as per applied filter query for boundary drawn by user using Draw tool  in \"Crime Analysis\" page.")
	public void PV_CrimeMapping_135() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_drawtool)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Draw Tool\" option from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_drawtool_crimeanalysis)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Draw\" button functionality from \"Crime Analysis\" page.");
		WebElement el=driver.findElement(By.xpath(CrimeMapping_repository.img_map));
		
		Actions act = new Actions(driver);
		act.moveToElement(el);
		act.moveByOffset(0,-100).click().build().perform();
		Thread.sleep(3000);
		act.moveByOffset(0,100).click().build().perform();
		Thread.sleep(3000);
		act.moveByOffset(200,30).doubleClick().build().perform();
		Thread.sleep(3000);
	
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Draw required area on map.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> :  Click on \"Apply\" button.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Apply\" button.</br>"
				+ "2. User should get crime record on map as per applied filter query for boundary drawn by user."));
		
	}
	
	@Test(priority=135,description="To verify that user is able to get Crimes on map as per applied filter query for uploaded file in \"Crime Analysis\" page.")
	public void PV_CrimeMapping_136() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_uploadfile)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Upload File\" option from \"Select AOI\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_uploadfile)).getText(), "Upload File");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_filetype_uploadfilewin)).sendKeys("GeoJson File");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select \"File Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse_uploadfile)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\PV\\GeoJson_Kml_Files\\GeoJson_Kml_Files\\Ahm_map4.geojson");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Upload file from device.(File should be GeoJson/KML as per selected option.)");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_accept)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Accept\" button of \"Upload File\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_uploadfile)).isDisplayed(), false);
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> :  Click on \"Apply\" button.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Apply\" button.</br>"
				+ "2. User should get crime record on map as per applied filter query."));
	}
	
	@Test(priority=136,description="To verify that user is able to close \"Upload File\" window.")
	public void PV_CrimeMapping_137() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_uploadfile)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Upload File\" option from \"Select AOI\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Upload File");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_uploadfile)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Close\" button of \"Upload File\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Upload File\" window."));
		
	}
	
	@Test(priority=137,description="To verify that user is able to get all records of crime by clicking on \"Apply\" button without applying filter value.")
	public void PV_CrimeMapping_138() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on \"Apply\" button from \"Crime Analysis\" page.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Apply\" button.</br>"
				+ "2. User should get All crime records  on map."));
	}
	
	@Test(priority=138,description="To verify that user is able to close \"Enter Date\" window.")
	public void PV_CrimeMapping_139() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(".//*[@id='dateRange']")).click();    
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='dateRange']/option[9]")));
		
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath("//div[@id='beforeDateRange']")).getCssValue("display");
		System.out.println(s1);
		Thread.sleep(4000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"After Date\" or \"Before Date\" option from \"Period\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_beforedate)).getText(), "Enter Date");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_beforedatemodel)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Close\" button of \"Enter Date\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Upload File\" window."));
		
	}
	
	@Test(priority=139,description="To verify that user is able to close \"Custom Date Range\" window.")
	public void PV_CrimeMapping_140() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(".//*[@id='dateRange']")).click();    
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='dateRange']/option[@id='csDate']")));
		
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath("//div[@id='beforeDateRange']")).getCssValue("display");
		System.out.println(s1);
		Thread.sleep(4000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Custom Range\" option from \"Period\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_customrangedate)).getText(), "Custom Date Range");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_customdaterangemodel)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Close\" button of \"Custom Date Range\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Custom Date Range\" window."));
	}
	
	@Test(priority=140,description="To verify that user gets validation message when perform \"Accept\" functionality of \"Upload File\" window with blank mandatory details.")
	public void PV_CrimeMapping_141() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_uploadfile)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Upload File\" option from \"Select AOI\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_uploadfile)).getText(), "Upload File");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_accept)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Accept\" button of \"Upload File\" window with blank details.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Please select file before Submit");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_uploadfile)).isDisplayed(), true);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get toast validation message like \"Please select file before Submit\"."));
	}
	
	@Test(priority=141,description="To verify that  user gets validation message for upload invalid file in \"Upload File\" window.")
	public void PV_CrimeMapping_142() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_uploadfile)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Upload File\" option from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse_uploadfile)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\PV\\GeoJson_Kml_Files\\GeoJson_Kml_Files\\Ahm_map4.kml");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Upload file from device.(File should be GeoJson/KML as per selected option.)");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_accept)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Accept\" button of \"Upload File\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "The file type is incorrect, please select correct format to mark the file!");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_uploadfile)).isDisplayed(), true);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get toast validation like : \"The file type is incorrect, please select correct format to mark the file!\""));
	}
	
	@Test(priority=142,description="To verify that user gets validation message when perform \"Accept\" functionality of \"Enter Date\" window with blank mandatory details.")
	public void PV_CrimeMapping_143() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(".//*[@id='dateRange']")).click();    
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='dateRange']/option[9]")));
		
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath("//div[@id='beforeDateRange']")).getCssValue("display");
		System.out.println(s1);
		Thread.sleep(4000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"After Date\" or \"Before Date\" option from \"Period\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_beforedate)).getText(), "Enter Date");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_accept_beforedatemodel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Accept\" button of \"Enter Date\" window with blank details.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Date is Mandatory");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_beforedate)).isDisplayed(), true);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get toast validation message like \"Date is Mandatory\"."));
		
		
	}
	
	@Test(priority=143,description="To verify that user gets validation message when perform \"Accept\" functionality of \"Custom Date Range\" window with blank mandatory details.")
	public void PV_CrimeMapping_144() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(10000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(".//*[@id='dateRange']")).click();    
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='dateRange']/option[@id='csDate']")));
		
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath("//div[@id='beforeDateRange']")).getCssValue("display");
		System.out.println(s1);
		Thread.sleep(4000);
		
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Custom Range\" option from \"Period\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_customrangedate)).getText(), "Custom Date Range");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_accept_customrangemodel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Accept\" button of \"Custom Date Range\" window with blank details.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Both dates are mandatory");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_customrangedate)).isDisplayed(), true);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get toast validation message like \"Both dates are mandatory\"."));
	}
	
	@Test(priority=144,description="To verify that user is able to perform \"Clear\" functionality from \"Crime Analysis\" page.")
	public void PV_CrimeMapping_145() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_ward)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		String t1=driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).getAttribute("title");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Apply\" button.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_clear)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Clear\" button from \"Crime Analysis\" page.");
		String t2=driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).getAttribute("title");
		Thread.sleep(1000);
		Assert.assertNotEquals(t1, t2);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Clear\" button.</br>"
				+ "2. All crime records should clear from \"Map\"."));
	}
	
	@Test(priority=145,description="To verify that user is able to perform \"Statistics\" functionality from \"Crime Analysis\" page.")
	public void PV_CrimeMapping_146() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_ward)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		String t1=driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).getAttribute("title");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_close_grid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_minimize_grid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next_grid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_pre_grid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries_grid)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creationtime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_creatorname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodificationtime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_lastmodifiername)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_location)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Statistics\" button.</br>"
				+ "2.\"Crime Statistics\" data grid should open as per applied query filter with following :</br>"
				+ "2.1. Column fields : \"Record No\" , \"Crime Type\" ,\"Summary\" , Jurisdiction\" , \"Crime Time\", \"Reporting Crime\",\"Severity\" , \"Creation Time\" , \"CreatorName(BadgeNo)\" , \"Last Modification Time\" , \"LastModifierName(BadgeNo).</br>"
				+ "2.2. Buttons : close(\"X\") , \"Next\" , \"Previous\" , Page No. controls.</br>"
				+ "2.3. Text-box \" SEARCH\" .</br>"
				+ "2.4. Dropdown : \"Show No. of entries\"."));
		
	}
	
	@Test(priority=146,description="To verify that user is able to collapse/expand \"Crime Statistics\" data grid.")
	public void PV_CrimeMapping_147(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(3000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.btn_maximize_grid)).getCssValue("display");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_minimize_grid)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"-\"(collapse) button of \"Crime Statistics\" data grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.btn_maximize_grid)).getCssValue("display");
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get \"Crime Statistics\" data grid in collapsed mode."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_maximize_grid)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"+\"(expand) button of \"Crime Statistics\" data grid.");
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.btn_maximize_grid)).getCssValue("display");
		Thread.sleep(1000);
		Assert.assertEquals(s1, s3);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get \"Crime Statistics\" data grid in expanded mode."));
	}
	
	@Test(priority=147,description="To verify that user is able to get location of selected crime on map by performing \"Location\" functionality from \"Crime Statistics\" window.")
	public void PV_CrimeMapping_148() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		  elm.selectByVisibleText("Ward");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		String t1=driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).getAttribute("title");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.pinpoint_loc_first_grid)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Location\" icon of particular crime from \"Crime Statistics\" data grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_crime)).getText(), "Crime");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.recono_crime_popup)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.crimetype_crime_popup)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.summary_crime_popup)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.jurisdiction_crime_popup)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.crimetime_crime_popup)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.severity_crime_popup)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.creatorname_crime_popup)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_viewmoredetail)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_attachment)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_person)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_pp)).isDisplayed(), true);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should get pin-point location of particular Crime on map with specific zoom-level.</br>"
				+ "2. User should get \"Crime\" information popup of selected particular crime."));
		
	}
	
	@Test(priority=148,description="To verify that user is able to perform close functionality of  \"Crime Statistics\" data grid.")
	public void PV_CrimeMapping_149() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_grid)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"Crime Statistics\" grid.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Crime Statistics\" grid."));
	}
	
	@Test(priority=149,description="To verify that user is able to perform \"SEARCH\" functionality of  \"Crime Statistics\" data grid.")
	public void PV_CrimeMapping_150() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(3000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_grid)).sendKeys("Arson");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter text in \"SEARCH\" text-box of \"Crime Statistics\" grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get only filtered searched record(s) in \"Crime Statistics\" grid."));
		
	}
	
	@Test(priority=150,description="To verify that user able to perform \"No of entries\" functionality of \"Crime Statistics\" data grid.")
	public void PV_CrimeMapping_151() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(3000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries_grid)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from \"Show entries\" dropdown.");
		
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		System.out.println(s2);
		String[] b=s2.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get no. of entries as per selected option in  \"Crime Statistics\" data grid."));
	}
	
	@Test(priority=151,description="To verify that user able to perform pagination functionality of \"Crime Statistics\" data grid.")
	public void PV_CrimeMapping_152(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(3000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next_grid)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Next\" button of the paging.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get next page record list of \"Crime Statistics\" data grid."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_pre_grid)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : 8. Click on \"Previous\" button of the paging.");
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		Assert.assertNotEquals(s3, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get previous page record list of \"Crime Statistics\" data grid."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_3)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on particular page no. from \"Crime Statistics\" data grid.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.txt_showing_entries_grid)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get selected page no. record list of \"Crime Statistics\" data grid."));
	}
	
	@Test(priority=152,description="To verify that user able to perform the \"Sorting\" functionality of columns in \"Crime Statistics\" data grid.")
	public void PV_CrimeMapping_153(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on sorting icon of the \"Record No\" column.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_recordno)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in numerical sorting order of \"Record No\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on sorting icon of the \"Crime Type\" column.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetype)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in alphabetical sorting order of \"Crime Type\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of the \"Summary\" column.");
		String s6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_summary)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in alphabetical sorting order of \"Summary\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).click();
		Thread.sleep(1000);
		String s7=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of the \"Jurisdiction\" column.");
		String s8=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_jurisdiction)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in alphabetical sorting order of \"Jurisdiction\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_04");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).click();
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on sorting icon of the \"Crime Time\" column.");
		String t2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_crimetime)).getAttribute("aria-label");
		Assert.assertNotEquals(t1, t2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_5</b> : User should get records in sorting order of \"Crime Time\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_05");
		
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).click();
		Thread.sleep(1000);
		String t3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Reporting Time\" column.");
		String t4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_reportingtime)).getAttribute("aria-label");
		Assert.assertNotEquals(t3, t4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_6</b> : User should get records in sorting order of \"Reporting Time\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_06");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).click();
		Thread.sleep(1000);
		String t5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on sorting icon of the \"Severity\" column.");
		String t6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity)).getAttribute("aria-label");
		Assert.assertNotEquals(t5, t6);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_7</b> : User should get records in sorting order of \"Severity\" data fields."));
	}
	
	@Test(priority=153,description="To verify that user is able to save applied filter for \"Crime Analysis\" by performing \"Save Filter\" functionality.")
	public void PV_CrimeMapping_154() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		Select select = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		select.selectByVisibleText("Ward"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"New Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Test Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Enter \"FilterName\" into respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Click on \"Save\" button of \"New Filter\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Filter");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_filtername_win)).getText(), "Test Filter");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able to click on \"Save\" button of \"New Filter\" window and window should close.\r\n"
				+ "2. Saved filter should display in list of \"Load Filter\"."));
		
	}
	
	@Test(priority=154,description="To verify that user is able to close \"New Filter\" window.")
	public void PV_CrimeMapping_155() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"New Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on close(\"X\") button of \"New Filter\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"New Filter\" window."));
	}
	
	@Test(priority=155,description="To verify that user is able to perform \"Cancel\" functionality of  \"New Filter\" window.")
	public void PV_CrimeMapping_156() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"New Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"New Filter\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"New Filter\" window and \"New Filter\"  window should close."));
	}
	
	@Test(priority=156,description="To verify that user is able to gets validation message when \"Save\" New Filter with blank mandatory fields.")
	public void PV_CrimeMapping_157() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"New Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Save\" button without entering mandatory field details.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_filtername)).getText(),"The Filter Name field is required.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like : \"The FilterName field is required.\" below respective field."));
	}
	
	@Test(priority=157,description="User should get validation message like \"Data with this Test already exist\".")
	public void PV_CrimeMapping_158(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"New Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Test Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter \"FilterName\" into respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"New Filter\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_filtername)).getText(),"Data with this Test Filter already exist");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like \"Data with this Test already exist\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(),false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(),true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
		
	}
	
	@Test(priority=158,description="To verify that user gets validation message when \"Save\" New Filter without applying filter on map.")
	public void PV_CrimeMapping_159(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get validation message like \"Filters are not applied so it can't be saved.\"."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_OK)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(),false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should able to click on \"OK\" button of validation message popup and validation message popup should close."));
	}
	
	@Test(priority=159,description="To verify that user gets validation message when perform \"Cancel\" functionality after adding details in \"New Filter\" window.")
	public void PV_CrimeMapping_160() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"New Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Test Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter \"FilterName\" into respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"New Filter\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(UserManagement_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Filter\" window should also close."));
	}
	
	@Test(priority=160,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"New Filter\" window.")
	public void PV_CrimeMapping_161() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Action\"->\"Save Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"New Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Test Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter \"FilterName\" into respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"New Filter\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElements(By.xpath(UserManagement_repository.title_window)).size()!=0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"New Filter\" window shouldn't close."));
	}
	
	@Test(priority=161,description="To verify that user is able to get \"Saved Filters\" window by performing \"Load Filter\" functionality.")
	public void PV_CrimeMapping_162() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_Actions)).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_filtername)).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_apply)).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_statistics)).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).isDisplayed(),true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Saved Filters\" window with following :</br>"
				+ "1. List of saved filters.</br>"
				+ "2. Buttons : \"Actions\" , \"Apply\" , \"Statistics\" for each saved filters, \"Next\" , \"Previous\" , Page no. control.</br>"
				+ "3. Text-box : \"SEARCH\".</br>"
				+ "4. Dropdown : \"Show entries\".</br>"
				+ "5. Table of \"Saved Filters\" with the column fields like:</br>"
				+ "\"Actions\", \"FilterName\" , \"Apply\" , \"Statistics\"."));
		
	}
	
	@Test(priority=162,description="To verify that user is able to perform \"Apply\" functionality from \"Saved Filters\" window.")
	public void PV_CrimeMapping_163() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Filter");
		Thread.sleep(1000);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply_first)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Apply\" button of particular saved filter which want to apply on map.");
	
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		Thread.sleep(1000);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Apply\" button of particular saved filter.</br>"
				+ "2. \"Saved Filters\" window should close.</br>"
				+ "3. Applied filter should display on map."));
		 
	}
	
	@Test(priority=163,description="To verify that user is able to perform \"Statistics\" functionality from \"Saved Filters\" window.")
	public void PV_CrimeMapping_164() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Filter");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics_first)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Statistics\" button of particular saved filter which want to apply on map.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Statistics\" button of particular saved filter.</br>"
				+ "2. \"Saved Filters\" window should close.</br>"
				+ "3. \"Crime Statistics\" data grid should open as per applied Saved Filter query."));
	}
	
	@Test(priority=164,description="To verify that user is able to close \"Saved Filters\" window.")
	public void PV_CrimeMapping_165() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"Saved Filters\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Saved Filters\" window."));
	}
	
	@Test(priority=165,description="To verify that user is able to \"Edit\" particular saved filter by performing \"Edit\" functionality from \"Actions\" dropdown of \"Saved Filters\" window.")
	public void PV_CrimeMapping_166() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Filter");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"->\"Edit\" button of particular saved filter which want to edit.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"Edit Filter");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit \"Filter Name\" from respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Save\" button of \"Edit Filter\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_filtername_win)).getText(), "Test Edit Filter");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"save\" button of \"Edit Filter window and window should close.</br>"
				+ "2. Edited details of saved crime analysis should update on portal."));
	}
	
	@Test(priority=166,description="To verify that user is able to close \"Edit Filter window.")
	public void PV_CrimeMapping_167() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"->\"Edit\" button of particular saved filter which want to edit.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"Edit Filter");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on close(\"X\") button of \"Edit Filter window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Filter window."));
	}
	
	@Test(priority=167,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Filter window.")
	public void PV_CrimeMapping_168() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"->\"Edit\" button of particular saved filter which want to edit.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"Edit Filter");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of \"Edit Filter window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Filter window and window should close."));
	}
	
	@Test(priority=168,description="To verify that user gets validation message when perform \"Cancel\" functionality after Editing details in \"Edit Filter\" window.")
	public void PV_CrimeMapping_169() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"->\"Edit\" button of particular saved filter which want to edit.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"Edit Filter");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Edit Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit \"Filter Name\" from respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Edit Filter\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Filter\" window should also close."));
		
	}
	
	@Test(priority=169,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Filter\" window.")
	public void PV_CrimeMapping_170() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"->\"Edit\" button of particular saved filter which want to edit.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(),"Edit Filter");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), false);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Edit Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit \"Filter Name\" from respective text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Cancel\" button of \"Edit Filter\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Filter\" window shouldn't close."));
		
	}
	
	@Test(priority=170,description="To verify that user is able to \"Cancel\" validation message of discard Saved Filter record.")
	public void PV_CrimeMapping_172() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"->\"Discard\" button of particular saved filter which want to delete.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message pop up and message popup should close."));
	}
	
	@Test(priority=171,description="To verify that user is able to \"Cancel\" validation message of discard Saved Filter record.")
	public void PV_CrimeMapping_171() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Actions\"->\"Discard\" button of particular saved filter which want to delete.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure you want to discard this record?", driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText());
		driver.findElement(By.xpath(UserManagement_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).isDisplayed(), true);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Test Edit Filter");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 0 to 0 of 0 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message pop up and message popup should close.</br>"
				+ "2. User should get toast validation like \"Successfully discarded!\".</br>"
				+ "3. Selected saved filter should delete from list of \"Saved Filters\" window."));
	}
	
	@Test(priority=172,description="To verify that user is able to perform \"SEARCH\" functionality of \"Saved Filters\" window.")
	public void PV_CrimeMapping_173() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_savedfilters)).getText(),"Saved Filters");
		driver.findElement(By.xpath(CrimeMapping_repository.searchbox_savedfilter_win)).sendKeys("Ward Filter");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter search criteria in \"Search\" textbox.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_filtername_win)).getText(), "Ward Filter");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to get searched result in \"Saved Filters\" window."));
	}
	
	@Test(priority=173,description="To verify that user is able to perform pagination functionality from \"Saved Filters\" window.")
	public void PV_CrimeMapping_174(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(1000);
		
		for(int j=0;j<5;j++)
		{
			driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(CrimeMapping_repository.op_savefilter)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(CrimeMapping_repository.txtbox_filtername_newfilter_win)).sendKeys("Test"+j);
			Thread.sleep(2000);
			driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
			Thread.sleep(2000);
		}
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Next\" button of \"Saved Filters\" window.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get next page records in \"Saved Filters\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Previous\" button of \"Saved Filters\" window.");
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s3, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get previous page records in \"Saved Filters\" window."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_2)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on any particular page No. of \"Saved Filters\" window.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get selected page no. records in \"Saved Filters\" window."));
	}
	
	@Test(priority=174,description="To verify that user is able to change number of records from \"Saved Filters\" window.")
	public void PV_CrimeMapping_175() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records as per selected number of entries in \"Saved Filters\" window."));
	}
	
	@Test(priority=175,description="To verify that user is able to perform sorting functionality for \"FilterName\"  column of \"Saved Filters\" window.")
	public void PV_CrimeMapping_176() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_loadfilter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Action\"->\"Load Filter\" from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_filtername)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_filtername)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_filtername)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> :  Click on sorting icon of \"FilterName\" column of \"Saved Filters\" window.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_filtername)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get records of saved filters in alphabetical sorting order \"FilterName\"."));
	}
	
	@Test(priority=176,description="To verify that user is able to perform \"Heat map\" functionality from \"Crime Analysis\" page.")
	public void PV_CrimeMapping_177() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		Select select = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		select.selectByVisibleText("Ward"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		String s1= driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_heatmap)).click();
		Thread.sleep(4000);
		String s2= driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Heat map\" functionality from \"Crime Analysis\" page.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get Heat map for applied filter Crime records on map."));
	}
	
	@Test(priority=177,description="To verify that user is able to perform \"Honey comb\" functionality from \"Crime Analysis\" page.")
	public void PV_CrimeMapping_178() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		Select select = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		select.selectByVisibleText("Ward"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		String s1= driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_honeycomb)).click();
		Thread.sleep(4000);
		String s2= driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Honey comb\" functionality from \"Crime Analysis\" page.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get Honey comb for applied filter Crime records on map."));
	}
	
	@Test(priority=178,description="To verify that user is able to perform \"Honey comb Grid\" functionality from \"Crime Analysis\" page.")
	public void PV_CrimeMapping_179() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		Select select = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		select.selectByVisibleText("Ward"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_apply)).click();
		Thread.sleep(4000);
		String s1= driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Apply\" button from \"Crime Analysis\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_honeycomb)).click();
		Thread.sleep(4000);
		String s2= driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Honey comb grid\" functionality from \"Crime Analysis\" page.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get Honey comb grid for applied filter Crime records on map."));
	}
	
	@Test(priority=180,description="To verify that user is able to close \"Crime\" popup of crime details.")
	public void PV_CrimeMapping_181() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		  elm.selectByVisibleText("Ward");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.pinpoint_loc_first_grid)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Location\" icon of particular crime from \"Crime Statistics\" data grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_crime)).getText(), "Crime");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_popup_win_map)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on close\"X\" button of \"Crime\" popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_win_crime)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Crime\" popup window."));
		
	}
	
	@Test(priority=181,description="To verify that user is able to get more details of crime by performing \"View More Details\" functionality of \"Crime\" popup window.")
	public void PV_CrimeMapping_182(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		  elm.selectByVisibleText("Ward");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.pinpoint_loc_first_grid)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Location\" icon of particular crime from \"Crime Statistics\" data grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_grid)).click();
		Thread.sleep(2000);
		WebElement frameElement = driver.findElement(By.id("crimeInfoBox"));
		driver.switchTo().frame(frameElement);
		Thread.sleep(2000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.txt_summary_crime_popup)).getText();
		Thread.sleep(1000);
		System.out.println(s3);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_viewmoredetail)).click();
		Thread.sleep(6000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"View More Details\" link from \"Crime\" popup window.");
		
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
		String Title_child = driver.switchTo().window(child_window).getCurrentUrl();
		System.out.println(Title_child);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(s3, s4);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_map_crimemappings)).getAttribute("aria-selected"), "true");
		
		}
		}
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should navigate to \"Crime Mappings\" page with selected particular crime in new tab of browser."));
		
	}
	
	@Test(priority=182,description="To verify that user is able to get crime related attachment by clicking on \"Attachment\" link from \"Crime\" window of particular crime.")
	public void PV_CrimeMapping_183(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		  elm.selectByVisibleText("Ward");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.pinpoint_loc_first_grid)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Location\" icon of particular crime from \"Crime Statistics\" data grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_grid)).click();
		Thread.sleep(2000);
		WebElement frameElement = driver.findElement(By.id("crimeInfoBox"));
		driver.switchTo().frame(frameElement);
		Thread.sleep(2000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.txt_summary_crime_popup)).getText();
		Thread.sleep(1000);
		System.out.println(s3);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_attachment)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Attachment\" link from \"Crime\" popup window.");
		
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
		String Title_child = driver.switchTo().window(child_window).getCurrentUrl();
		System.out.println(Title_child);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(s3, s4);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_attach_crimemappings)).getAttribute("aria-selected"), "true");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_map_crimemappings)).getAttribute("aria-selected"), "false");
		}
		}
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should navigate to \"Crime Mappings\" page with the tab of \"Attachment\" already open of selected particular crime in new tab of browser."));
		
	}
	
	@Test(priority=183,description="To verify that user is able to get crime related Persons by clicking on \"Person\" link from \"Crime\" window of particular crime.")
	public void PV_CrimeMapping_184(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		  elm.selectByVisibleText("Ward");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.pinpoint_loc_first_grid)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Location\" icon of particular crime from \"Crime Statistics\" data grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_grid)).click();
		Thread.sleep(2000);
		WebElement frameElement = driver.findElement(By.id("crimeInfoBox"));
		driver.switchTo().frame(frameElement);
		Thread.sleep(2000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.txt_summary_crime_popup)).getText();
		Thread.sleep(1000);
		System.out.println(s3);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_person)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Persons\" link from \"Crime\" popup window.");
		
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
		String Title_child = driver.switchTo().window(child_window).getCurrentUrl();
		System.out.println(Title_child);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(s3, s4);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_person_crimemappings)).getAttribute("aria-selected"), "true");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_map_crimemappings)).getAttribute("aria-selected"), "false");
		}
		}
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should navigate to \"Crime Mappings\" page with the tab of \"Person\" already open of selected particular crime in new tab of browser."));
		
	}
	
	@Test(priority=184,description="To verify that user is able to get crime related Police Personnel by clicking on \"Police Personnel\" link from \"Crime\" window of particular crime.")
	public void PV_CrimeMapping_185(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Analysis");
		
		Select elm = new Select(driver.findElement(By.xpath(CrimeMapping_repository.dd_selAOI_cranalysis)));
		  elm.selectByVisibleText("Ward");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select \"Ward\" from \"Select AOI\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_selward_cranalysis)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_ward_Ghatlodia)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Select Ward from Ward dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.dd_crimetype_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_selall_crimetype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Crime Type\" from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_severity_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_sev_high)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select \"Severity\" from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_invstatus_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.chbox_invstatus_open)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select status of crime from \"Status\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_period_cranalysis)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.op_pastyear)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Select period from \"Period\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_statistics)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on \"Statistics\" button from \"Crime Analysis\" page.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_grid)).getText(), "Crime Statistics");
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.pinpoint_loc_first_grid)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Click on \"Location\" icon of particular crime from \"Crime Statistics\" data grid.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.scale_map)).getText();
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_grid)).click();
		Thread.sleep(2000);
		WebElement frameElement = driver.findElement(By.id("crimeInfoBox"));
		driver.switchTo().frame(frameElement);
		Thread.sleep(2000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.txt_summary_crime_popup)).getText();
		Thread.sleep(1000);
		System.out.println(s3);
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_pp)).click();
		Thread.sleep(5000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Police Personnel\" link from \"Crime\" popup window.");
		
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
		String Title_child = driver.switchTo().window(child_window).getCurrentUrl();
		System.out.println(Title_child);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Mappings");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.verify_crime_crimetree)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(s3, s4);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_pp_crimemappings)).getAttribute("aria-selected"), "true");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.tab_map_crimemappings)).getAttribute("aria-selected"), "false");
		}
		}
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should navigate to \"Crime Mappings\" page with the tab of \"Police Personnel\" already open of selected particular crime in new tab of browser."));
		
	}
	
	
	
	@Test(priority=185,description="To verify that user is able to get \"Legend\" window by performing \"Legend\" functionality from \"Crime Analysis\" page.")
	public void PV_CrimeMapping_186() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_legend)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Legend\" icon button from map in\"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_legend_win)).getText(), "Legend");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_legend_box)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Legend\" window with symbolic information of Crime Type."));
	}
	
	@Test(priority=186,description="To verify that user is able to close \"Legend\" window.")
	public void PV_CrimeMapping_187() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_legend)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Legend\" icon button from map in\"Crime Analysis\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_legend_win)).getText(), "Legend");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_legend_box)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Legend\" window with symbolic information of Crime Type."));
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close_popup_win_map)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on close(\"X\") button of \"Legend window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_legend_win)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_legend_box)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Legend\" window."));
	}
	
	@Test(priority=187,description="To verify that user is able to get dropdown list of functionalities by clicking on \"Tools\" menu icon from map in \"Crime Analysis\" page.")
	public void PV_CrimeMapping_188() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimeanalysis)).click();
		Thread.sleep(8000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Analysis\" menu from left panel.");
		driver.findElement(By.xpath(CrimeMapping_repository.icon_btn_tools)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Tools\" icon button.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_layer)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_identify)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_bookmark)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_swipe)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_measure)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_drawtool)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.lnk_aroundme)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should dropdown list with following functionalities :</br>"
				+ "\"Layer\" ,</br>"
				+ "\"Identify\" , </br>"
				+ "\"Bookmark\" , </br>"
				+ "\"Swipe\" ,</br>"
				+ "\"Measure\",</br>"
				+ "\"Draw Tool\" ,</br>"
				+ "\"Around me\"."));
	}
	
	
	//-------Crime Types page-------
	
	@Test(priority=188,description="To verify that user is able to get \"Crime Types\" page.")
	public void PV_CrimeMapping_189() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_name_crimetypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_code_crimetypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_parentname_crimetypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_symimg_crimetypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity_crimetypes)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_visibility_crimetypes)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to get \"Crime Types\" page with following :</br>"
				+ "1. Buttons : \"+Add Crime Type\" , \"Next\" , \"Previous\" ,  Page Control Numbers.</br>"
				+ "2. Text-box : \"SEARCH\".</br>"
				+ "3. Table of added crime types list with following column fields :</br>"
				+ "\"Actions\" , \"Name\" , \"Code\" ,\"Parent Name\" , \"Symbol Image\" , \"Severity\", \"Visibility\".</br>"
				+ "4. Dropdown : \"Actions\" button ,\"Show entries\".</br>"
				+ "5. Links : \"Home\" icon.</br>"
				+ "\r\n"
				+ ">> User should get \"Crime Types\" page with list of crime types If added otherwise displays No data available."));
	}
	
	
	
	
	@Test(priority=189,description="To verify that user is able to get back to \"Home\" page from \"Crime Types\" page by clicking on \"Home\" icon.")
	public void PV_CrimeMapping_190() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_Home)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Home\" icon in \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Home");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Crime Types\" page."));
	}
	
	@Test(priority=190,description="To verify that user is able to perform Pagination functionality of \"Crime Types\" page.")
	public void PV_CrimeMapping_191(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		Thread.sleep(2000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		
		driver.findElement(By.xpath(CrimeMapping_repository.btn_next)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Next\" button of the paging.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get next page record list of \"Crime Types\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_previous)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : 8. Click on \"Previous\" button of the paging.");
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s3, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get previous page record list of \"Crime Types\" page."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_pageno_3)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on particular page no. in \"Crime Types\" page.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get selected page no. record list of \"Crime Types\" page ."));
	}
	
	@Test(priority=191,description="To verify that user is able to perform \"SEARCH\" functionality of \"Crime Types\" page.")
	public void PV_CrimeMapping_192() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Crime");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimetype_first)).getText(), "Crime");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Crime Types\" page."));
	}
	
	@Test(priority=192,description="To verify that user is able to perform \"Show No. of entries\" functionality from \"Crime Types\" page.")
	public void PV_CrimeMapping_193() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(CrimeMapping_repository.dd_entries)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(CrimeMapping_repository.entries_25)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Select number from \"Show entries\" dropdown.");
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText();
		System.out.println(s1);
		String[] b=s1.split(" "); 
		String c= b[5];
		String d= b[3];
		WebElement e1=driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries));
		Coordinates co1=((Locatable)e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 1 to " + d + " of " + c + " entries");
		Assert.assertNotEquals(s1,s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get Crime record list as per selected  number of entries in \"Crime Types\" page."));
	}
	
	@Test(priority=193,description="To verify that user is able to perform sorting functionality from \"Crime Types\" page.")
	public void PV_CrimeMapping_194(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_name_crimetypes)).click();
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_name_crimetypes)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_name_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on sorting icon of the \"Name\" column.");
		String s2=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_name_crimetypes)).getAttribute("aria-sort");
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get records in alphabetical sorting order of \"Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_code_crimetypes)).click();
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_code_crimetypes)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_code_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on sorting icon of the \"Code\" column.");
		String s4=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_code_crimetypes)).getAttribute("aria-sort");
		Assert.assertNotEquals(s3, s4);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get records in sorting order of \"Code\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_parentname_crimetypes)).click();
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_parentname_crimetypes)).getAttribute("aria-sort");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_parentname_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on sorting icon of the \"Parent Name\" column.");
		String s6=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_parentname_crimetypes)).getAttribute("aria-sort");
		Assert.assertNotEquals(s5, s6);
		
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get records in alphabetical sorting order of \"Parent Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity_crimetypes)).click();
		Thread.sleep(1000);
		String s7=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity_crimetypes)).getAttribute("aria-label");
		driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on sorting icon of the \"Severity\" column.");
		String s8=driver.findElement(By.xpath(CrimeMapping_repository.col_lbl_severity_crimetypes)).getAttribute("aria-label");
		Assert.assertNotEquals(s7, s8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_4</b> : User should get records in alphabetical sorting order of \"Severity\" data fields."));
	}
	
	@Test(priority=194,description="To verify that user is able to get \"Add Crime Type\" window.")
	public void PV_CrimeMapping_195() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"+Add Crime Type\" button from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Add Crime Type");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.chbox_visibility_addcrtypewin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_sev_addcrtypewin)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.dd_parentcrimetype_addcrtypewin)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Add Crime Type\" window with following :</br>"
				+ "1. Text-boxes : \"Name\" , \"Code\" .</br>"
				+ "2. Dropdowns : \"Severity\" , \"Parent Crime Type\".</br>"
				+ "3. Buttons : \"Choose File\"(For symbol upload) , \"Cancel\" , \"Save\", Close(\"X\").</br>"
				+ "4. Check-box : \"Visibility\"."));
	}
	
	@Test(priority=195,description="To verify that user is able to add crime type by performing \"+Add Crime Type\" functionality from \"Crime Types\" page.")
	public void PV_CrimeMapping_196() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"+Add Crime Type\" button from \"Crime Types\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).sendKeys("Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Enter crime \"Name\" in \"Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).sendKeys("T111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Enter Code in \"Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\crimetype.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Upload Symbol Image file from device.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_sev_addcrtypewin)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Select severity of crime from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_parentcrimetype_addcrtypewin)).sendKeys("Crime");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Select Parent Crime Type from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Click on \"Save\" button of \"Add Crime Type\" window.");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Test");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_name_crimetype)).getText(), "Test");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_parenttype_crimetype)).getText(), "Crime");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Add Crime Type\" window and window should close.</br>"
				+ "2. Added Crime type should display in list of \"Crime Types\" page.</br>"
				+ "3. Added crime type should display in \"Select Crime\" dropdown as per selected parent type."));
	}
	
	@Test(priority=196,description="To verify that user is able to close \"Add Crime Type\" window.")
	public void PV_CrimeMapping_197() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"+Add Crime Type\" button from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Add Crime Type");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on close(\"X\") button of \"Add Crime Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Add Crime Type\" window."));
	}
	
	@Test(priority=197,description="To verify that user is able to perform \"Cancel\" functionality of \"Add Crime Type\" window.")
	public void PV_CrimeMapping_198() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"+Add Crime Type\" button from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Add Crime Type");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Cancel\" button of \"Add Crime Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Crime Type\" window and window should close."));
	}
	
	@Test(priority=198,description="To verify that user gets validation message when click on \"Save\" button with blank mandatory details of \"Add Crime Type\" window.")
	public void PV_CrimeMapping_199() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"+Add Crime Type\" button from \"Crime Types\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Save\" button of \"Add Crime Type\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_name_addcrtypewin)).getText(), "The Name field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.val_code_addcrtypewin)).getText(), "The Code field is required.");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validations message like :</br>"
				+ "\"The Name field is required.\",</br>"
				+ "\"The Code field is required.\" below respective fields."));
		
	}
	
	@Test(priority=199,description="To verify that user gets validation message when perform \"Cancel\" functionality after Adding details in \"Add Crime Type\" window.")
	public void PV_CrimeMapping_200() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"+Add Crime Type\" button from \"Crime Types\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).sendKeys("Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Enter crime \"Name\" in \"Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).sendKeys("T111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Enter Code in \"Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\crimetype.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Upload Symbol Image file from device.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_sev_addcrtypewin)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Select severity of crime from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_parentcrimetype_addcrtypewin)).sendKeys("Crime");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Select Parent Crime Type from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Click on \"Cancel\" button of \"Add Crime Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Add Crime Type\" window should also close."));
	}
	
	@Test(priority=199,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Add Crime Type\" window.")
	public void PV_CrimeMapping_201() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_addcrimetype)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"+Add Crime Type\" button from \"Crime Types\" page.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).sendKeys("Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Enter crime \"Name\" in \"Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).sendKeys("T111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Enter Code in \"Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\crimetype.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Upload Symbol Image file from device.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_sev_addcrtypewin)).sendKeys("Moderate");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Select severity of crime from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_parentcrimetype_addcrtypewin)).sendKeys("Crime");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Select Parent Crime Type from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Click on \"Cancel\" button of \"Add Crime Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Add Crime Type\" window shouldn't close."));
	}
	
	@Test(priority=201,description="To verify that user is able to edit \"Crime Type\" by performing \"Edit\" functionality from \"Actions\" dropdown of particular selected crime type.")
	public void PV_CrimeMapping_202() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Test");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Actions\"->\"Edit\" button of particular crime type from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Crime Type");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).sendKeys("EditCrimeType");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Edit crime \"Name\" from \"Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).sendKeys("T111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Code from \"Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\crimetype.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Upload Symbol Image file from device.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_sev_addcrtypewin)).sendKeys("Low");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit severity selection of crime from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_parentcrimetype_addcrtypewin)).sendKeys("Crime");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit selection of Parent Crime Type from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Click on \"Save\" button of \"Edit Crime Type\" window.");
		
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("EditCrimeType");
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.verify_crimetype_first)).getText(), "EditCrimeType");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Edit Crime Type\" window and window should close.</br>"
				+ "2. Edited crime type details should update on portal and display in list of \"Crime Types\" page."));
	}
	
	
	
	@Test(priority=202,description="To verify that user is able to close \"Edit Crime Type\" window.")
	public void PV_CrimeMapping_203() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Burglary");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Actions\"->\"Edit\" button of particular crime type from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Crime Type");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> :  Click on close(\"X\") button of \"Edit Crime Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Crime Type\" window."));
	}
	
	@Test(priority=203,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Crime Type\" window.")
	public void PV_CrimeMapping_204() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("Burglary");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Actions\"->\"Edit\" button of particular crime type from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Crime Type");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> :  Click on \"Cancel\" button of \"Edit Crime Type\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Crime Type\" window and window should close."));
	}
	
	@Test(priority=204,description="To verify that user gets validation message when perform \"Cancel\" functionality after editing details of \"Edit Crime Type\" window.")
	public void PV_CrimeMapping_205() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("EditCrimeType");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Actions\"->\"Edit\" button of particular crime type from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Crime Type");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).sendKeys("EditTest");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Edit crime \"Name\" from \"Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).sendKeys("T111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Code from \"Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\crimetype.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Upload Symbol Image file from device.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_sev_addcrtypewin)).sendKeys("Low");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit severity selection of crime from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_parentcrimetype_addcrtypewin)).sendKeys("Crime");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit selection of Parent Crime Type from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Click on \"Cancel\" button of \"Edit Crime Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Crime Type\" window should also close."));
	}
	
	@Test(priority=204,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Crime Type\" window.")
	public void PV_CrimeMapping_206() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("EditCrimeType");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_edit_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Actions\"->\"Edit\" button of particular crime type from \"Crime Types\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_window)).getText(), "Edit Crime Type");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_name_addcrtypewin)).sendKeys("EditTest");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Edit crime \"Name\" from \"Name\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.txtbox_code_addcrtypewin)).sendKeys("T111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Code from \"Code\" text-box.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Pictures\\crimetype.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Upload Symbol Image file from device.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_sev_addcrtypewin)).sendKeys("Low");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit severity selection of crime from \"Severity\" dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.dd_parentcrimetype_addcrtypewin)).sendKeys("Crime");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit selection of Parent Crime Type from respective dropdown.");
		driver.findElement(By.xpath(CrimeMapping_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Click on \"Cancel\" button of \"Edit Crime Type\" window.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("You have unsaved changes.", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElements(By.xpath(CrimeMapping_repository.title_window)).size()!=0, true);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Crime Type\" window shouldn't close."));
	}
	
	@Test(priority=206,description="To verify that user is able to \"Cancel\" validation message of discard the Crime Type record.")
	public void PV_CrimeMapping_208() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("EditCrimeType");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Actions\"->\"Discard\" button of particular crime type from \"Crime Types\" page.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to Discard the Crime Type: 'EditCrimeType'?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and message popup should close."));
	}
	
	@Test(priority=207,description="To verify that user is able to \"Discard\" particular selected Crime Type from the \"Crime Types\" page.")
	public void PV_CrimeMapping_207(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(CrimeMapping_repository.menu_crimemapping)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(CrimeMapping_repository.menu_item_crimetypes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Crime Mappings\"->\"Crime Types\" menu from left panel.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.title_header)).getText(), "Crime Types");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("EditCrimeType");
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.btn_actions_first)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(CrimeMapping_repository.lnk_discard_first)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on \"Actions\"->\"Discard\" button of particular crime type from \"Crime Types\" page.");
		Assert.assertEquals("Are you sure?", driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).getText());
		Assert.assertEquals("Are you sure to Discard the Crime Type: 'EditCrimeType'?", driver.findElement(By.xpath(CrimeMapping_repository.validation_2ndline)).getText());
        Thread.sleep(1000);	
        ll.Screenshotnew(driver, i, method.getName()+"01");
		driver.findElement(By.xpath(CrimeMapping_repository.validation_btn_yes)).click();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.validation_1stline)).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.toast_msg)).getText(), "Successfully discarded!");
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).clear();
		driver.findElement(By.xpath(CrimeMapping_repository.textbox_search)).sendKeys("EditCrimeType");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath(CrimeMapping_repository.text_showing_entries)).getText(), "Showing 0 to 0 of 0 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message and message popup should close.</br>"
				+ "2. User should get toast validation message like \"Successfully discarded!\".</br>"
				+ "3. Selected crime type should delete from \"Crime Types\" listing page."));
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