package pv_admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import com.aventstack.extentreports.Status;

import Listener.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestResult;

public class PV_Settings {
	WebDriver driver;

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeClass
	public void setDriver(ITestContext context) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		driver=new FirefoxDriver();
		//ExtentTestManager.getTest().log(Status.INFO, "Open browser.");
		context.setAttribute("WebDriver", driver);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@BeforeMethod
	public void Openurl() throws InterruptedException 
	{
		driver.get(Login_repository.url);
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//ExtentTestManager.getTest().log(Status.INFO, "Enter URL in addressbar of browser.");
	}

	@Test(priority=0, description="To verify that user is able to expand/collapse \"Application Settings\" menu from left panel of \"Home\" page.")
	public void PV_Settings_01() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		WebElement e1=driver.findElement(By.xpath(Login_repository.btn_Login));
		e1.isDisplayed();
		e1.click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("1q2w3E*");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		String e2= driver.findElement(By.xpath("//div[@class='row entry-row']/div/h1")).getText();
		Assert.assertEquals(e2, "Home");
		Thread.sleep(1000);
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		WebElement e4 = driver.findElement(By.xpath(PV_Settings_repository.op_aroundme_config));
		Coordinates co4 = ((Locatable)e4).getCoordinates();
		co4.onPage(); co4.inViewPort();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Click on \"Application Settings\" menu from left panel.");
		String a1=driver.findElement(By.xpath(PV_Settings_repository.expand_style)).getAttribute("style");
		Thread.sleep(2000);
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Application Settings\" menu from left panel.");
		String a2=driver.findElement(By.xpath(PV_Settings_repository.expand_style)).getAttribute("style");
		Thread.sleep(2000);
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Application Settings\" in collapse mode."));
		
	}


	@Test(priority=1,description="To verify that user is able to get \"Application Settings\" functionality list from left panel of \"Home\" page.")
	public void PV_Settings_02() throws InterruptedException, AWTException {
		
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\" menu from left panel.");	
		WebElement e4 = driver.findElement(By.xpath(admin_page_repository.opt_DatabaseConfing));
		Coordinates co4 = ((Locatable)e4).getCoordinates();
		co4.onPage(); co4.inViewPort();
		Thread.sleep(1000);
		String a1=driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).getText();
		Assert.assertEquals(a1, "Police Vertical Settings"); 
		String a2=driver.findElement(By.xpath(PV_Settings_repository.op_bookmarks)).getText();
		Assert.assertEquals(a2, "Bookmarks"); 
		String a3=driver.findElement(By.xpath(PV_Settings_repository.op_NamedQuery)).getText();
		Assert.assertEquals(a3, "Named Queries"); 
		WebElement element = driver.findElement(By.xpath(admin_page_repository.opt_DatabaseConfing));
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.onPage(); coordinate.inViewPort();
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.op_aroundme_config)).getText(), "Around Me Configuration"); 
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Application Settings\" in expanded mode with following :</br>\r\n"
				+ "1. Police Vertical Settings</br>"
				+ "2. Bookmarks</br>"
				+ "3. Named Queries</br>"
				+ "4. Around Me Configuration")); 

	}


	@Test(priority=2,description="To verify that user is able to get  \"Police Vertical Settings\" page.")
	public void PV_Settings_03() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\" menu from left panel.");	
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");	
		String b1=driver.findElement(By.xpath(PV_Settings_repository.header_pvSettings)).getText();
		Assert.assertEquals(b1, "Police Vertical Settings");
		Thread.sleep(1000);
		boolean b2=driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).isDisplayed();
		Assert.assertEquals(b2, true);
		boolean b3=driver.findElement(By.xpath(PV_Settings_repository.btn_previous)).isDisplayed();
		Assert.assertEquals(b3, true);
		boolean b4=driver.findElement(By.xpath(PV_Settings_repository.btn_next)).isDisplayed();
		Assert.assertEquals(b4, true);
		boolean b5=driver.findElement(By.xpath(PV_Settings_repository.lnk_pageno_1)).isDisplayed();
		Assert.assertEquals(b5, true);
		boolean b6=driver.findElement(By.xpath(PV_Settings_repository.dd_entries)).isDisplayed();
		Assert.assertEquals(b6, true);
		String s1=driver.findElement(By.xpath(PV_Settings_repository.col_lbl_Actions)).getText();
		Assert.assertEquals(s1, "Actions");
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(PV_Settings_repository.col_lbl_SettingName)).getText();
		Assert.assertEquals(s2, "Setting Name");
		Thread.sleep(1000);
		String s3=driver.findElement(By.xpath(PV_Settings_repository.col_lbl_SettingValue)).getText();
		Assert.assertEquals(s3, "Setting Value");
		Thread.sleep(1000);
		String s4=driver.findElement(By.xpath(PV_Settings_repository.col_lbl_Module)).getText();
		Assert.assertEquals(s4, "Module");
		Thread.sleep(1000);
		String s5=driver.findElement(By.xpath(PV_Settings_repository.col_lbl_Description)).getText();
		Assert.assertEquals(s5, "Description");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get  of \"Police Vertical Settings\" page with following :</br> 1. Buttons: \"+Add Police Vertical Setting\", \"Next\" , \"Previous\", Page Control Numbers. </br>2. \"SEARCH\" text-box.</br>3. Table with the fields like:\r\n"
				+ "\"Actions\", \r\n"
				+ "\"Setting Name\", \r\n"
				+ "\"Setting Value\",\r\n"
				+ "\"Module\",\r\n"
				+ "\"Description\".</br>4. Dropdown: \"Actions\" button ,\"Show entries\". </br>5. Links: Home icon."));

	}

	@Test(priority=3,description="To verify that user is able to perform \"SEARCH\" functionality of \"Police Vertical Settings\" page.")
	public void PV_Settings_04() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");	
		String b1=driver.findElement(By.xpath(PV_Settings_repository.header_pvSettings)).getText();
		Assert.assertEquals(b1, "Police Vertical Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Landing Page");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals("Landing Page",driver.findElement(By.xpath(PV_Settings_repository.verify_settingname)).getText() );
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.text_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched Result in \"Police Vertical Settings\" page."));

	}

	@Test(priority=4,description="To verify that user is able get back to \"Home\" page from \"Police Vertical Settings\" page by clicking on Home icon.")
	public void PV_Settings_08() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");	
		String b1=driver.findElement(By.xpath(PV_Settings_repository.header_pvSettings)).getText();
		Assert.assertEquals(b1, "Police Vertical Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on Home icon in \"Police Vertical Settings\" page.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='row entry-row']/div/h1")).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Police Vertical Settings\" page."));
	}

	@Test(priority=5,description="To verify that user is able to get \"Add Police Vertical Setting\" window by clicking on \"+Add Police Vertical Setting\" button.")
	public void PV_Settings_09() throws InterruptedException
	{	
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");	
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		String s1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Assert.assertEquals(s1, "Add Police Vertical Setting");
		Thread.sleep(1000);
		String l1=driver.findElement(By.xpath(PV_Settings_repository.lbl_Module_win_add_pvsetting)).getText();
		Assert.assertEquals(l1, "Module");
		String l2=driver.findElement(By.xpath(PV_Settings_repository.lbl_SettingName_win_add_pvsetting)).getText();
		Assert.assertEquals(l2, "Setting Name");
		String l3=driver.findElement(By.xpath(PV_Settings_repository.lbl_SettingVal_win_add_pvsetting)).getText();
		Assert.assertEquals(l3, "Setting Value *");
		String l4=driver.findElement(By.xpath(PV_Settings_repository.lbl_Description_win_add_pvsetting)).getText();
		Assert.assertEquals(l4, "Description");
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.btn_save)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.btn_close)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Add Police Vertical Setting\" window with following :</br>1. Text boxes: \r\n"
				+ "Mandatory: \"Module\", \"Setting Name\" , \"Setting Value\".\r\n"
				+ "Optional : \"Description\".</br> 2. Buttons : \"Cancel\" , \"Save\" , \"X(close)\"."));
	}

	@Test(priority=6,description="To verify that user is able to perform \"Add Police Vertical Setting\" functionality.")
	public void PV_Settings_10() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");	
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)).sendKeys("Test Module");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter Module name in \"Module\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)).sendKeys("Test_PV_Settings");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter Setting Name in \"Setting Name\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)).sendKeys("[{slug : 'footer', sequence :12}]");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter Setting value in \"Setting Value\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)).sendKeys("Test create functionality of PV Settings page.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b><b>Step-6</b></b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Save\" button of \"Add Police Vertical Setting\" window.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_PV_Settings");
		Thread.sleep(1000);
		String t1=driver.findElement(By.xpath(PV_Settings_repository.verify_settingname)).getText();
		Thread.sleep(1000);
		Assert.assertEquals("Test_PV_Settings", t1);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> :</br> 1. User should able to click on \"Save\" button and \"Save\" added Police Vertical Setting.</br>2. Saved Police Vertical Setting should display in list of \"Police Vertical Settings\" page."));
	}

	@Test(priority=7,description="To verify that user is able to close \"Add Police Vertical Setting\" window.")
	public void PV_Settings_11() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		String s1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Assert.assertEquals(s1, "Add Police Vertical Setting");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on close(\"X\") button of \"Add Police Vertical Setting\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Add Police Vertical Setting\" window."));
	}

	@Test(priority=8,description="To verify that user is able to perform \"Cancel\" functionality of \"Add Police Vertical Setting\" window.")
	public void PV_Settings_12() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		String s1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Assert.assertEquals(s1, "Add Police Vertical Setting");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on \"Cancel\" button of \"Add Police Vertical Setting\" window.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Police Vertical Setting\" window and \"Add Police Vertical Setting\" window should close."));
	}

	@Test(priority=9,description="To verify that user is able to get validation message when click on \"Save\" button of \"Add Police Vertical Setting\" window with blank required details.")
	public void PV_Settings_13() throws InterruptedException
	{

		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		String s1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Assert.assertEquals(s1, "Add Police Vertical Setting");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on \"Save\" button without entering details in \"Add Police Vertical Setting\" window.");
		String v1=driver.findElement(By.xpath(PV_Settings_repository.validation_module)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(v1, "The Module field is required.");
		String v2=driver.findElement(By.xpath(PV_Settings_repository.validation_SettingName)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(v2, "The Setting Name field is required.");
		String v3=driver.findElement(By.xpath(PV_Settings_repository.validation_SettingValue)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(v3, "The Setting Value field is required.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like : \r\n"
				+ "\"The Module field is required.\", \r\n"
				+ "\"The Setting Name field is required.\", \r\n"
				+ "\"The Setting Value field is required.\" below their respective fields."));
	}


	

	@Test(priority=10,description="To verify that user is able to get validation message when \"Add Police Vertical Setting\" which is already exsits.")
	public void PV_Settings_14() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)).sendKeys("Test Module");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter Module name in \"Module\" text-box which is already exists.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)).sendKeys("Test_PV_Settings");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter Setting Name in \"Setting Name\" text-box which is already exists.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)).sendKeys("[{slug : 'footer', sequence :12}]");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter Setting value in \"Setting Value\" text-box which is already exists.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)).sendKeys("Test create functionality of PV Settings page.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b><b>Step-6</b></b> : Enter Description in \"Description\" text-box which is already exists.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Save\" button of \"Police Vertical Setting\" window.");
		String v1=driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(v1, "Police Vertical Setting : Test_PV_Settings already exists.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User shoud get validation message like \"Police Vertical Setting : Crime Mapping already exists.\"."));
	}
	
	@Test(priority=11,description="To verify that user is able to get validation message when perform Cancel functionality after adding details in \"Add Police Vertical Setting\" window.")
	public void PV_Settings_15() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)).sendKeys("Test Module");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter Module name in \"Module\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)).sendKeys("Test_PV_Settings");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter Setting Name in \"Setting Name\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)).sendKeys("[{slug : 'footer', sequence :12}]");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter Setting value in \"Setting Value\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)).sendKeys("Test create functionality of PV Settings page.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b><b>Step-6</b></b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Cancel\" button from \"Add OGC Service\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).getText(), "Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.validation_2ndline)).getText(), "You have unsaved changes.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> :</br> 1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br> 2. \"Edit Police Vertical Setting\" window should also close."));
	}
	
	@Test(priority=12,description="To verify that user is able to \"Cancel\" validation message of unsaved changes of \"Add Police Vertical Setting\" window.")
	public void PV_Settings_16() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_add_pvSettings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"+Add Police Vertical Setting\" button.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)).sendKeys("Test Module");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter Module name in \"Module\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)).sendKeys("Test_PV_Settings");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter Setting Name in \"Setting Name\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)).sendKeys("[{slug : 'footer', sequence :12}]");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter Setting value in \"Setting Value\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)).sendKeys("Test create functionality of PV Settings page.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b><b>Step-6</b></b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Cancel\" button from \"Add OGC Service\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).getText(), "Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.validation_2ndline)).getText(), "You have unsaved changes.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b>: Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(true, driver.findElement(By.xpath(PV_Settings_repository.title_window)).isDisplayed());
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> :</br> 1.'User should able to click on \"Cancel\" button of validation message popup and validation message popup should close. </br> 2. \"Add Police Vertical Setting\" window should display."));
	}
	
	@Test(priority=13,description="To verify that user is able to get \"Edit Police Vertical Setting\" window by clicking on \"Edit\" option from the \"Actions\" dropdown from \"Police Vertical Setting\" page. ")
	public void PV_Settings_17() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_PV_Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular Setting Name.");
		String t1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(t1, "Edit Police Vertical Setting");
		Thread.sleep(1000);
		Assert.assertEquals(true,driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(PV_Settings_repository.btn_save)).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(PV_Settings_repository.btn_close)).isDisplayed());
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Edit Police Vertical Setting\" window with following: </br>1. Text boxes with pre entered data: \r\n"
				+ "Mandatory: \"Module\", \"Setting Name\" , \"Setting Value\".\r\n"
				+ "Optional : \"Description\".</br>2. Buttons : \"Cancel\" , \"Save\" , \"X(close)\"."));
	}
	
	@Test(priority=14,description="To verify that user is able to \"Edit\" Police Vertical Setting by performing \"Edit\" functionality from \"Actions\" dropdown.")
	public void PV_Settings_18() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_PV_Settings");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular Setting Name.");
		WebElement e1=driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)); 
		e1.clear();
		Thread.sleep(1000);
		e1.sendKeys("Test Module1"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Edit Module name in \"Module\" text-box.");
		WebElement e2=driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)); 
		e2.clear(); 
		Thread.sleep(1000);
		e2.sendKeys("Test_Edit_PV_Settings"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Edit Setting Name in \"Setting Name\" text-box.");
		WebElement e3=driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)); 
		e3.clear(); 
		Thread.sleep(1000);
		e3.sendKeys("[{slug : 'footer', sequence :05}]"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Edit Setting value in \"Setting Value\" text-box.");
		WebElement e4=driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)); 
		e4.clear(); 
		Thread.sleep(1000);
		e4.sendKeys("Test create functionality of PV Settings page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b><b>Step-6</b></b> : Edit Description in \"Description\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_save)).click(); 
		Thread.sleep(2000); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Save\" button of \"Edit Police Vertical Setting\" window.");
		String t2=driver.findElement(By.xpath(PV_Settings_repository.verify_settingname)).getText();
		Thread.sleep(1000); 
		Assert.assertEquals("Test_Edit_PV_Settings", t2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> :</br> 1. User should able click on \"Save\" button and \"Edit Police Vertical Setting\" window should close.</br> 2. User should get editted details in \"Police Vertical Settings\" page."));

	}

	@Test(priority=15,description="To verify that user is able to close(\"X\") \"Edit Police Vertical Setting\" window.")
	public void PV_Settings_19() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_Edit_PV_Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular Setting Name.");
		String t1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(t1, "Edit Police Vertical Setting");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Verify 'Edit Police Vertical Setting' window is displaying.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on close(\"X\") button of \"Edit Police Vertical Setting\" page.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Police Vertical Setting\" window."));
	}
	
	@Test(priority=16,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Police Vertical Setting\" window.")
	public void PV_Settings_20() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_Edit_PV_Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular Setting Name.");
		String t1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(t1, "Edit Police Vertical Setting");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Verify 'Edit Police Vertical Setting' window is displaying.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Click on \"Cancel\" button of \"Edit Police Vertical Setting\" page.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Police Vertical Setting\" window."));
	}
	
	@Test(priority=17,description="To verify that user is able to get validation message when perform \"Cancel\" functionality after edit any field of \"Edit Police Vertical Setting\" window.")
	public void PV_Settings_21() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_Edit_PV_Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular Setting Name.");
		String t1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(t1, "Edit Police Vertical Setting");
		Thread.sleep(1000);
		WebElement e1=driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)); 
		e1.clear();
		Thread.sleep(1000);
		e1.sendKeys("Test Module"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Edit Module name in \"Module\" text-box.");
		WebElement e2=driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)); 
		e2.clear(); 
		Thread.sleep(1000);
		e2.sendKeys("Test_PV_Settings"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Edit Setting Name in \"Setting Name\" text-box.");
		WebElement e3=driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)); 
		e3.clear(); 
		Thread.sleep(1000);
		e3.sendKeys("[{slug : 'footer', sequence :05}]"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Edit Setting value in \"Setting Value\" text-box.");
		WebElement e4=driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)); 
		e4.clear(); 
		Thread.sleep(1000);
		e4.sendKeys("Testing PV Settings.");
		ExtentTestManager.getTest().log(Status.INFO, "<b><b>Step-6</b></b> : Edit Description in \"Description\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Cancel\" button of \"Edit Police Vertical Setting\" window. ");
		String l1=driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).getText();
		Assert.assertEquals(l1, "Are you sure?");
		Thread.sleep(1000);
		String l2=driver.findElement(By.xpath(PV_Settings_repository.validation_2ndline)).getText();
		Assert.assertEquals(l2, "You have unsaved changes.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Validations text verify.");
		driver.findElement(By.xpath(PV_Settings_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Yes\" button of validation message popup.");
		String t2=driver.findElement(By.xpath(PV_Settings_repository.verify_settingname)).getText();
		Thread.sleep(1000);
		Assert.assertEquals("Test_Edit_PV_Settings", t2);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>2. \"Edit Police Vertical Setting\" window should also close."));
	}

	

	@Test(priority=18,description="To verify that user is able to \"Cancel\" validation message of unsaved changes.")
	public void PV_Settings_22() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_Edit_PV_Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular Setting Name.");
		String t1=driver.findElement(By.xpath(PV_Settings_repository.title_window)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(t1, "Edit Police Vertical Setting");
		Thread.sleep(1000);
		WebElement e1=driver.findElement(By.xpath(PV_Settings_repository.txtbox_Module_pvsetting)); 
		e1.clear();
		Thread.sleep(1000);
		e1.sendKeys("Test Module"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Edit Module name in \"Module\" text-box.");
		WebElement e2=driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingName_pvsetting)); 
		e2.clear(); 
		Thread.sleep(1000);
		e2.sendKeys("Test_PV_Settings"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Edit Setting Name in \"Setting Name\" text-box.");
		WebElement e3=driver.findElement(By.xpath(PV_Settings_repository.txtbox_SettingVal_pvsetting)); 
		e3.clear(); 
		Thread.sleep(1000);
		e3.sendKeys("[{slug : 'footer', sequence :05}]"); 
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Edit Setting value in \"Setting Value\" text-box.");
		WebElement e4=driver.findElement(By.xpath(PV_Settings_repository.txtbox_Description_pvsetting)); 
		e4.clear(); 
		Thread.sleep(1000);
		e4.sendKeys("Testing PV Settings.");
		ExtentTestManager.getTest().log(Status.INFO, "<b><b>Step-6</b></b> : Edit Description in \"Description\" text-box.");
		driver.findElement(By.xpath(PV_Settings_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Cancel\" button of \"Edit Police Vertical Setting\" window. ");
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).getText(), "Are you sure?");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.validation_2ndline)).getText(), "You have unsaved changes.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(true, driver.findElement(By.xpath(PV_Settings_repository.title_window)).isDisplayed());
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br> 2. \"Edit Police Vertical Setting\" window should also close."));
	}


	@Test(priority=19,description="To verify that user is able to \"Cancel\" the validation message of delete record of Police Vertical Setting.")
	public void PV_Settings_24() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_Edit_PV_Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Delete\" option from dropdown of particular Setting Name.");
		String l1=driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).getText();
		Assert.assertEquals(l1, "Are you sure?");
		Thread.sleep(1000);
		String l2=driver.findElement(By.xpath(PV_Settings_repository.validation_2ndline)).getText();
		Assert.assertEquals(l2, "Are you sure you want to discard this record?");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on Cancel button of validation message popup.");
		Assert.assertEquals(false, driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).isDisplayed());
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
	}

	@Test(priority=20,description="To verify that user is able to delete Police Vertical Setting by clicking on \"Delete\" option from the \"Actions\" dropdown.")
	public void PV_Settings_23() throws InterruptedException
	{
		driver.findElement(By.xpath(admin_page_repository.opt_AppSettings)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.op_pv_settings)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on \"Application Settings\"->\"Police Vertical Settings\" menu from the left pane.");
		driver.findElement(By.xpath(PV_Settings_repository.txtbox_search)).sendKeys("Test_Edit_PV_Settings");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Actions\"-->\"Delete\" option from dropdown of particular Setting Name.");
		String l1=driver.findElement(By.xpath(PV_Settings_repository.validation_1stline)).getText();
		Assert.assertEquals(l1, "Are you sure?");
		Thread.sleep(1000);
		String l2=driver.findElement(By.xpath(PV_Settings_repository.validation_2ndline)).getText();
		Assert.assertEquals(l2, "Are you sure you want to discard this record?");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PV_Settings_repository.validation_btn_yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on Yes button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(PV_Settings_repository.toast_msg)).getText(), "Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> :</br> 1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br> 2. Deleted record should also delete from \"Police Vertical Settings\" page."));
	}


	@AfterMethod

	public void schreenshot(ITestResult Result) throws IOException {

		if(ITestResult.FAILURE==Result.getStatus()){
			try{
				Date currentdate=new Date();
				File ScreenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// <b>Result</b>.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(ScreenshotFile, new File(".//Screenshot//Fail-"+Result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}
		else if(ITestResult.SUCCESS==Result.getStatus())
		{
			try
			{
				Date currentdate=new Date();
				File ScrrenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(ScrrenshotFile, new File(".//Screenshot\\Pass-" + Result.getName() + ".png"));
			}
			catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			}
		}
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
		Thread.sleep(1000);
	}

}
