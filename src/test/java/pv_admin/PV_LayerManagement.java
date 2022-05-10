package pv_admin;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listener.ExtentTestManager;
import Listener.Screenshot_extra;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PV_LayerManagement {
	WebDriver driver;
	Screenshot_extra ll = new Screenshot_extra();
	String i = "PV_LayerManagement_extra_ss";

	@BeforeClass
	public void setDriver(ITestContext context) throws InterruptedException {
		// System.setProperty("webdriver.gecko.driver",
		// "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		// driver=new FirefoxDriver();

	}

	@BeforeMethod
	public void Openurl(ITestContext context) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		context.setAttribute("WebDriver", driver);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
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

	@Test(priority = 01, description = "To verify that user is able to expand/collapse \"Layer Management\" menu from left panel of \"Home\" page.")
	public void PV_LayerManagement_01(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get \"Layer Management\" in expanded mode.");
		Assert.assertEquals("block",
				driver.findElement(By.xpath("//ul[@id=\"MenuItem_LayerManagement\"]")).getCssValue("display"));
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get \"Layer Management\" in collapse mode.");
		Assert.assertEquals("none",
				driver.findElement(By.xpath("//ul[@id=\"MenuItem_LayerManagement\"]")).getCssValue("display"));
	}

	@Test(priority = 02, description = "To verify that user that user is able to get Landing page \"Layer\".")
	public void PV_LayerManagement_02() throws InterruptedException {

		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result</b> : 1. Buttons:\r\n"
				+ "\"ADD ogc service\", \"SCAN LAYER\", Edit icon, (\"X\") icon, \"Previous\" ,\"Next\", Page control Number.\r\n"
				+ "2. \"SEARCH\" text-box.\r\n" + "3. Table with the fields like: \r\n"
				+ "\"Actions\" , \"LayerTitle\", \"LayerName\", \"TableName\", \"IsActive\", \"IsBaseLayer\", \"IsQueryTable\", \"IsVisible\", \r\n"
				+ "\"Creation Time\".\r\n" + "4. Dropdown: \"OGC Service\" \"Actions\" button ,\"Show entries\" .\r\n"
				+ "5. Links:           icon.");
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).isDisplayed());
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).isDisplayed());
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.btn_Delete_OGC_services)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_next)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_previous)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.lnk_pageno_1)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Layer Title\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Layer Name\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Table Name\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Active\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Is Base Layer?\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Is Queryable?\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Creation Time\"]")).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath("//th[text()=\"Is Visible ?\"]")).isDisplayed());
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.ddm_OGC_services)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(LayerManagement_repository.btn_Action)).isDisplayed());
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.ddm_Show_Entries)).isDisplayed());
	}

	@Test(priority = 03, description = "To verify that user is able to get \"Add OGC service\" window by clicking on \"Add OGC Service\" button  from \"Layer\" page.")
	public void PV_LayerManagement_03() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on  \"Add OGC Service\" button.\r\n"
						+ "2. User should get \"Add OGC service\" window with following:\r\n"
						+ "Dropdown: \"Layer Type\".\r\n"
						+ "Text Boxes: \"Name\", \"DB Name\" , \"URL\" , \"Db Connection String\".\r\n"
						+ "Checkbox: \"Is Active?\".\r\n" + "Buttons: \"Cancel\" , \"Save\" , \"X\"(close).");
		Assert.assertEquals(true, driver.findElement(By.xpath("//h5[text()=\"Add OGC Service\"]")).isDisplayed());
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();

	}

	@Test(priority = 04, description = "To verify that user is able to perform \"Save\" functionality of \"Add OGC Service\" window with \"Is Active?\" check-box selection.")
	public void PV_LayerManagement_04() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Name in \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"URL\" in\"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys(
				"http://192.168.3.85:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=police_vertical_ws&IEG_PROJECT=police_vertical_ws&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString))
				.sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1) User should able to click on \"Save\" button and \"Add OGC Service\" window should close.\r\n"
						+ "2) Added OGC service should display on portal.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test OGC Service1");
	}

	@Test(priority = 05, description = "To verify that user is able to perform \"Save\" functionality of \"Add OGC Service\" window without \"Is Active?\" check-box selection.")
	public void PV_LayerManagement_05() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Name in \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service2");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys(
				"http://192.168.3.85:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=police_vertical_ws&IEG_PROJECT=police_vertical_ws&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString))
				.sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chk_Active)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Save\" button and \"Save\" OGC Service.\r\n"
						+ "2. Saved \"OGC Service\" should display in Landing page of \"Layer\".");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test OGC Service2");
	}

	@Test(priority = 06, description = "To verify that user is able to close \"ADD OGC service\" window.")
	public void PV_LayerManagement_06() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on close(\"X\") button of \"ADD OGC services\" window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should able to close \"Add OGC Service\" window.");
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]"))
				.isDisplayed(), true);
	}

	@Test(priority = 07, description = "To verify that user is able to perform \"Cancel\" functionality of \"ADD OGC service\" window.")
	public void PV_LayerManagement_07() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Cancel\" button of \"ADD OGC services\" window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"ADD OGC services\" window and \"ADD OGC services\" window should close.");
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]"))
				.isDisplayed(), true);
	}

	@Test(priority = 8, description = "To verify that user gets validation message while \"Save\"  OGC Service with blank required details.")
	public void PV_LayerManagement_08() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Save\" button without entering mandatory details in \"Add OGC service\" window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like:\r\n" + "\"The Name field is required.\", \r\n"
						+ "\"The URL field is required.\" below their respective text-boxes.");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[text()=\"The Name field is required.\"]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"The URL field is required.\"]")).isDisplayed(),
				true);
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	}

	@Test(priority = 9, description = "To verify that user gets validation message while \"Save\"  OGC Service with invalid URL.")
	public void PV_LayerManagement_09(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Name in \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service141");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl))
				.sendKeys("htt.168.3.REQUEST=GetCapabilities");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString))
				.sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Result</b> : User should get validation message like: \r\n"
				+ "\"Invalid URI: The format of the URI could not be determined.\".");
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[text()=\"Invalid URI: The format of the URI could not be determined.\"]"))
				.isDisplayed(), true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"OK\" button of validation message popup.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Ok)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"OK\" button of validation message popup.\r\n"
						+ "2. Validation message popup should close.");
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[text()=\"Invalid URI: The format of the URI could not be determined.\"]"))
				.isDisplayed(), false);
		ll.Screenshotnew(driver, i, method.getName() + "_02");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();

	}

	@Test(priority = 10, description = "To verify that user gets validation message when perform \"Cancel\" functionality after adding details into \"Add OGC Service\" window.")
	public void PV_LayerManagement_10(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Name in \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl))
				.sendKeys("htt.168.3.REQUEST=GetCapabilities");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString))
				.sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Cancel\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
						+ "You have unsaved changes.\".");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Yes\"\" button of validation message popup and validation message popup should close.\r\n"
						+ "2. \"Add OGC Service\" window should also close.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				false);

	}

	@Test(priority = 11, description = "To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Add OGC Service\" window.")
	public void PV_LayerManagement_11(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Name in \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl))
				.sendKeys("htt.168.3.REQUEST=GetCapabilities");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString))
				.sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Cancel\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
						+ "You have unsaved changes.\".");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
		driver.findElement(By.xpath("//div[@class=\"swal-modal\"]//button[text()=\"Cancel\"]")).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.\r\n"
						+ "2. \"Add OGC Service\" window should display on screen.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				false);
		ll.Screenshotnew(driver, i, method.getName() + "_02");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000);
	}

	@Test(priority = 12, description = "To verify that user gets validation message for create \"OGC Service\" which is already exist.")
	public void PV_LayerManagement_12(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Add OGC Service\" button from the \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_OGC_Services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Select \"Layer Type\" from respective dropdown.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Name in \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test OGC Service1");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Enter Database name in \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("police_vertical_new");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter \"URL\" in \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys(
				"http://192.168.3.85:1213/cgi-bin/IGiS_Ent_service.exe?IEG_PROJECT=police_vertical_ws&IEG_PROJECT=police_vertical_ws&SERVICE=WMS&VERSION=1.1.1&REQUEST=GetCapabilities");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Enter Database connection string in \"DB Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString))
				.sendKeys("Server=192.168.2.37;Port=5432;User Id=igis;Password=igis;Database=police_vertical_new; ");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Check-on \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"OGC service with this Name already exist\".");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"OGC service with this Name already exist\"]"))
				.isDisplayed(), true);
		Thread.sleep(2000);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> :  Click on \"OK\" button of validation popup.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Ok)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000);
	}

	@Test(priority = 13, description = "To verify that user is able to Edit \"OGC service\" from  \"Layer\" page.")
	public void PV_LayerManagement_13() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test OGC Service1");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Name from \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("Test_OGC");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit Database name from \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit \"URL\" from \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit Database connection string from \"Db Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Edit selection of  \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Save\" button of \"Edit OGC Service\" window .");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Save)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Save\" button and \"Save\" OGC Service.\r\n"
						+ "2. User should able to save edited changes of OGC Service and should display in \"Layer\" page.");
		Select dropdown1 = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown1.selectByVisibleText("Test_OGC");
	}

	@Test(priority = 14, description = "To verify that user is able to close \"Edit OGC service\" window.")
	public void PV_LayerManagement_14() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> :  Click on close(\"X\") button of \"Edit OGC Service\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should able to close \"Edit OGC Service\" window.");
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]"))
				.isDisplayed(), true);
	}

	@Test(priority = 15, description = "To verify that user is able to perform \"Cancel\" functionality of \"Edit OGC Service\" window.")
	public void PV_LayerManagement_15() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> :  Click on \"Cancel\" button of \"Edit OGC services\" window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit OGC services\" window and \"Edit OGC services\" window should close.");
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]"))
				.isDisplayed(), true);
	}

	@Test(priority = 16, description = "To verify that user gets validation message when perform \"Cancel\" functionality after editing details into \"Add OGC Service\" window.")
	public void PV_LayerManagement_16(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Name from \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("EDIT OGC");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit Database name from \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit \"URL\" from \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit Database connection string from \"Db Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Edit selection of  \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on\"Cancel\"/\"X\"(close) button of \"Edit OGC Service\" window. .");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
						+ "You have unsaved changes.\".");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> :Click on \"Yes\" button of validation message popup.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Yes\"\" button of validation message popup and validation message popup should close.\r\n"
						+ "2. \"Edit OGC Service\" window should also close.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				false);
	}

	@Test(priority = 17, description = "To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit OGC Service\" window.")
	public void PV_LayerManagement_17(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Edit\" button in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Edit_OGC_services)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Edit Name from \"Name\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_Name)).sendKeys("EDIT OGC");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Edit Database name from \"DB Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbName)).sendKeys("");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Edit \"URL\" from \"URL\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_URl)).sendKeys("");
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit Database connection string from \"Db Connection String\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_OgcServices_DbConnectionString)).sendKeys("");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> :  Edit selection of  \"Is Active ?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on\"Cancel\"/\"X\"(close) button of \"Edit OGC Service\" window. .");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		;
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"Are you sure?\r\n"
						+ "You have unsaved changes.\".");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> :Click on \"Cancel\" button of validation message popup.");
		driver.findElement(By.xpath("//div[@class=\"swal-modal\"]//button[text()=\"Cancel\"]")).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.\r\n"
						+ "2. \"Edit OGC Service\" window should display on screen.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				false);
		ll.Screenshotnew(driver, i, method.getName() + "_02");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000);
	}

	@Test(priority = 18, description = "To verify that user is able to perform \"SCAN LAYER\" functionality of \"Layer\"page.")
	public void PV_LayerManagement_18() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get Scan Layer page of selected \"OGC Service\"  with following:"
						+ "1. Links: \" Layer Error Count : \", \" Layer Publish Pending : \", \" Layer With Columns Issue : \", \r\n"
						+ "\" Layer Recorded Pending : \" , \" Layer Table Not Found :\" , \" Layer Sync Pending : \" , \" Clear \""
						+ "2. Buttons: \"<- Back\" , \"Rescan\", \"Next\" , \"Previous\", Page No. control."
						+ "3. \"Select Layer\" dropdown.");
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Layer Error Count : 0')]")).isDisplayed(),
				true);
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[contains(text(),'Layer Recorded Pending : 0')]")).isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[contains(text(),'Layer Publish Pending : 0')]")).isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[contains(text(),'Layer Table Not Found : 0')]")).isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[contains(text(),'Layer With Columns Issue : 0')]")).isDisplayed(),
				true);
		Assert.assertEquals(
				driver.findElement(By.xpath("//*[contains(text(),'Layer Sync Pending : 0')]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Clear')]")).isDisplayed(), true);
	}

	@Test(priority = 19, description = "To verify that user is able to get back to \"Layer\" page from selected \"OGC Service\" Scan Layer page after clicking on the \"<-Back\" button.")
	public void PV_LayerManagement_19() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"<-Back\" button of Scan Layer page of selected \"OGC Service\" .");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Back)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get back to \"Layer\" page from Scan Layer page of selected \"OGC Service\".");
		Assert.assertEquals(driver.findElement(By.xpath("//h5[text()=\"Layers\"]")).isDisplayed(), true);
	}

	@Test(priority = 20, description = "To verify that user is able to perform \"Rescan\" functionality.")
	public void PV_LayerManagement_20() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get list of available layers in selected \"OGC\" service.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Error)).isDisplayed(),
				true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Record_Pending)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Publish)).isDisplayed(),
				true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Table_NotFound)).isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Columns_Issue)).isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_Clear)).isDisplayed(), true);
	}

	@Test(priority = 21, description = "To verify that user is able to get layers in which error count is present by clicking on \"Layer Error Count\" link from Scan Layer page of selected \"OGC Service\".")
	public void PV_LayerManagement_21() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Layer Error Count\" link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Error)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get list of layers in which error count is present.");
		String a1 = driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Error)).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[4];
		System.out.println(b1);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}

	@Test(priority = 22, description = "To verify that user is able to get layers in which publishing work is pending by clicking on \"Layer Publish Pending\" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_22() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Layer Publish Pending\" link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Publish)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should get list of layers in which some publishing work is pending./Showing 0 entries if layers have no publishing work is pending.\r\n"
						+ "(Ideally shows 0.)\r\n"
						+ "2. Layers in which publishing work is pending should display with           icon.");
		String a1 = driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Publish)).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[4];
		System.out.println(b1);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}

	@Test(priority = 23, description = "To verify that user is able to get layers in which issue with DB column present by clicking on \"Layer with Column Issue\" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_23() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Layer with Column Issue\" link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Columns_Issue)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should get list of layers in which  issue with DB column present./Showing 0 entries if layers have no issue with DB column is present.\r\n"
						+ "2. Layers in which issue with DB column is present display with             icon.");
		String a1 = driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Columns_Issue)).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[5];
		System.out.println(b1);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}

	@Test(priority = 24, description = "To verify that user is able to get layers in which layer recorded is pending by clicking on \"Layer Recorded Pending\" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_24() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		// ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on "Scan
		// Layer" button from "Layer" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		// ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click "Rescan"
		// button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);

		// ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on "Layer
		// Recorded Pending" link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Record_Pending)).click();
		Thread.sleep(2000);

		/*
		 * ExtentTestManager.getTest().log(Status.
		 * INFO,"<b>Result</b> : 1. User should get list of layers in which layer recorded pending.\r\n"
		 * +
		 * "2. Layers with layer recorded pending should display with             icon."
		 * );
		 */

		String a1 = driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Record_Pending)).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[4];
		System.out.println(b1);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}

	@Test(priority = 25, description = "To verify that user is able to get layers in which no table available in current database by clicking on \"Layer Table Not Found \" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_25() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		// ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on "Scan
		// Layer" button from "Layer" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		// ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click "Rescan"
		// button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);

		// ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on "Layer
		// Table Not Found " link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Table_NotFound)).click();
		Thread.sleep(2000);

		/*
		 * ExtentTestManager.getTest().log(Status.
		 * INFO,"<b>Result</b> : 1. User should get list of layers in which no table available in current database./Showing 0 entries if layers have no table available in current database.\r\n"
		 * +
		 * "2. Layers with  no table available in current database should display with         icon."
		 * );
		 */

		String a1 = driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Table_NotFound)).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[5];
		System.out.println(b1);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}

	@Test(priority = 26, description = "To verify that use is able to get layers in which some syncing is pending by clicking on \"Layer Sync Pending\" link from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_26() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Layer Sync Pending\" link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should get layers in which some syncing is pending./Showing 0 entries if layers have no syncing is pending.\r\n"
						+ "2. Layers with some syncing is pending should display with            icon.");
		String a1 = driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[4];
		System.out.println(b1);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		Assert.assertEquals(b1, b2);
	}

	@Test(priority = 27, description = "To verify that user is able to perform \"Clear\" link functionality from Scan Layer page of selected \"OGC Service\" .")
	public void PV_LayerManagement_27() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Layer Sync Pending\" link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).click();
		Thread.sleep(2000);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Clear\" link.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Clear)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get all the layers available in \"OGC Service\" and removing any other pre-applied filters.");
		String a1 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[5];
		System.out.println(b1);
		Assert.assertNotEquals(b1, b2);
	}

	@Test(priority = 28, description = "To verify that user is able to perform \"Add Layer\" functionality.")
	public void PV_LayerManagement_28(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Layer\" button of any particular layer.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Layer_ATM)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should get validation message like \"Added Successfully\".\r\n"
						+ "2. \"Layer Sync Pending\" shows 1 increment value after  adding layer.\r\n"
						+ "3. Added layer should display in list of  \"OGC service \" in \"Layer\" page.\r\n"
						+ "4. User should get two button namely \"Activate\" , \"Delete\" on added layer.");
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.btn_Activate_ATM)).isDisplayed());
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.btn_Discard_ATM)).isDisplayed());
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get \"0\" value of \"Layer Sync Pending\".");
		String a1 = driver.findElement(By.xpath(LayerManagement_repository.lnk_Layer_Sync_Pending)).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[4];
		System.out.println(b1);
		Assert.assertEquals("0", b1);
	}

	@Test(priority = 29, description = "To verify that user is able to \"Activate\"/\"Deactivate\" added layer.")
	public void PV_LayerManagement_29(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> :  Click on \"Deactivate\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Deactivate_ATM)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should get validation message like \"Layer Updated Successfully\".\r\n"
						+ "2. User should get \"Activate\" button at place of \"Deactivate\" button.");
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.btn_Activate_ATM)).isDisplayed());
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> :  Click on \"Activate\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Activate_ATM)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should get validation message like \"Layer Updated Successfully\".\r\n"
						+ "2. User should get \"Activate\" button at place of \"Deactivate\" button.");
		Assert.assertEquals(true,
				driver.findElement(By.xpath(LayerManagement_repository.btn_Deactivate_ATM)).isDisplayed());

	}

	@Test(priority = 30, description = "To verify that user is able to perform \"Delete\" functionality of scan layer page of selected \"OGC Service.")
	public void PV_LayerManagement_30(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		String a2 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] words = a2.split("\\s");
		for (String w : words) {
			System.out.println(w);
		}
		String b2 = words[5];
		System.out.println(b2);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> :  Click on \"Delete\" button any particular layer.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Discard_ATM)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"Deleted Successfully\" and layer should delete.");
		String a1 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] word = a1.split("\\s");
		for (String w : word) {
			System.out.println(w);
		}
		String b1 = word[5];
		System.out.println(b1);
		Assert.assertNotEquals(b1, b2);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> :   Click on \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should get validation message like \"Layer Updated Successfully\".\r\n"
						+ "2. User should get \"Activate\" button at place of \"Deactivate\" button.");
		String a3 = driver.findElement(By.xpath("//div[@class=\"col-sm-12 col-md-5\"]")).getText();
		String[] wordss = a3.split("\\s");
		for (String w : wordss) {
			System.out.println(w);
		}
		String b3 = wordss[5];
		System.out.println(b3);
		Assert.assertEquals(b3, b2);
	}

	@Test(priority = 31, description = "To verify that user is able to perform \"Add Mask Layer\" functionality.")
	public void PV_LayerManagement_31() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Layer_ATM)).click();
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Mask_Layer_boundary_ward)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
		Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));
		dropdown1.selectByVisibleText("atm");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able click on \"Save button\" and \"Add-Mask Layer\" window should close.\r\n"
						+ "2. Selected particular layer is added as Mask Layer");
		Select dropdown2 = new Select(driver.findElement(By.id("sl_LayersList")));
		dropdown2.selectByVisibleText("boundary_ward");
	}

	@Test(priority = 32, description = "To verify that user is able to perform \"Add Mask Layer\" functionality without \"Is Mask?\" check-box selection.")
	public void PV_LayerManagement_32() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Add_Mask_Layer_bank)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer1");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chk_Is_Mask)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
		Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));
		dropdown1.selectByVisibleText("atm");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Click on \"Save\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able click on \"Save button\" and \"Add-Mask Layer\" window should close.\r\n"
						+ "2. Selected particular layer is added as Mask Layer");
		Select dropdown2 = new Select(driver.findElement(By.id("sl_LayersList")));
		dropdown2.selectByVisibleText("bank");
	}

	@Test(priority = 33, description = "To verify that user is able to perform \"Cancel\" functionality of \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_33() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
		driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on \"Cancel\" button of \"Add-Mask Layer\" window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Layer\" window and \"Add-Mask Layer\" window should close.");
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]"))
				.isDisplayed(), true);
	}

	@Test(priority = 34, description = "To verify that user is able to close \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_34() throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
		driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on \"X\"(close) button of Add-Mask Layer window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Layer\" window and \"Add-Mask Layer\" window should close.");
		Assert.assertEquals(driver.findElement(By.xpath("//body[@class=\"abp-application-layout lp-opened-sidebar\"]"))
				.isDisplayed(), true);
	}

	@Test(priority = 35, description = "To verify that user gets validation message when perform \"Save\" functionality with blank required details of \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_35(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
		driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on \"Save\" button of \"Add-Mask Layer\" window without entering mandatory deta");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Add Layer\" window and \"Add-Mask Layer\" window should close.");
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()=\"Title Name is required\"]")).isDisplayed(),
				true);
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[text()=\"MaskLayer Name is required.\"]")).isDisplayed(), true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(2000);
	}

	@Test(priority = 36, description = "To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Adding details in \"Add Layer\" window.")
	public void PV_LayerManagement_36(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
		driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
		Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));
		dropdown1.selectByVisibleText("atm");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Cancel\"/\"X\"(close) button of \"Add Layer\" window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"Are you sure? You have unsaved changes.\".");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Yes\"\" button of validation message popup and validation message popup should close.\r\n"
						+ "2. \"Add-Mask Layer\" window should also close.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				false);
	}

	@Test(priority = 37, description = "To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Add-Mask Layer\" window.")
	public void PV_LayerManagement_37(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on \"Layer Management\" menu from left panel.");
		driver.findElement(By.xpath(LayerManagement_repository.ddm_Layer_Management)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		Select dropdown = new Select(driver.findElement(By.id("sl_OgcService")));
		dropdown.selectByVisibleText("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Scan_Layers)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_Rescan)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Add Mask Layer\" button of any particular layer.");
		driver.findElement(By.xpath("//div[@id=\"_boundary_zone\"]//a[text()=\"Add Mask-Layer\"]")).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Enter \"Title Name\" in \"Title Name\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Name)).sendKeys("Test Mask Layer");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Check-on \"Is Mask?\" check-box.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Select \"Mask Layer Name\" from respective dropdown.");
		Select dropdown1 = new Select(driver.findElement(By.id("sl_LayerList")));
		dropdown1.selectByVisibleText("atm");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Cancel\"/\"X\"(close) button of \"Add Layer\" window.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : User should get validation message like \"Are you sure? You have unsaved changes.\".");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				true);
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Result</b> : 1. User should able to click on \"Cancel\"\" button of validation message popup and validation message popup should close.\r\n"
						+ "2. \"Add-Mask Layer\" window should also close.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"Are you sure?\"]")).isDisplayed(), false);
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"You have unsaved changes.\"]")).isDisplayed(),
				false);
		ll.Screenshotnew(driver, i, method.getName() + "_02");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		driver.findElement(By.xpath(LayerManagement_repository.btn_Yes)).click();
		Thread.sleep(2000);
	}

	@Test(priority = 38, description = "To verify that user is able to perform pagination functionality in  Scan Layer page of selected \"OGC Service\".")
	public void PV_LayerManagement_38(Method method) throws InterruptedException

	{
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_scanlayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_rescan)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click \"Rescan\" button.");
		String s1 = driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(LayerManagement_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Next\" button of the paging.");
		String s2 = driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String
				.format("<b>Result_1</b> : User should get next page of selected \"OGC Service\" Scan Layer page."));
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		driver.findElement(By.xpath(LayerManagement_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Previous\" button of the paging.");
		String s3 = driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s2, s3);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result_2</b> : User should get previous page of selected \"OGC Service\" Scan Layer page."));
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_pageno_3)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on particular page no. in Scan Layer page of selected \"OGC Service\" .");
		String s4 = driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s3, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result_3</b> : User should get selected page no. of records in Scan Layer page of selected \"OGC Service\" ."));
	}

	@Test(priority = 39, description = "To verify that user is able to select particular layer  from \"--Select Layer--\" dropdown list in scan layer page of selected \"OGC Service\".")
	public void PV_LayerManagement_39() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_scanlayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_rescan)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_addlay_crimemapping)).click();
		Thread.sleep(1000);
		WebElement e1 = driver.findElement(By.xpath(LayerManagement_repository.btn_rescan));
		Coordinates co1 = ((Locatable) e1).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_rescan)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(LayerManagement_repository.dd_sellayer)).sendKeys("bridge");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"--Select Layer--\" dropdown list.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Select particular layer from the dropdown list.");
		String s1 = driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		System.out.println(s1);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText(),
				"Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should get selected layer in Scan Layer page of selected \"OGC Service\" ."));
	}

	@Test(priority = 40, description = "To verify that user is able to get Landing page of \"Layer Field\"  by clicking on \"Layer Field\" option from the \"Actions\" dropdown on \"Layer\" page.")
	public void PV_UserManagement_42() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_pageheader)).getText(),
				"Layer Field");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_actions)).isDisplayed(),
				true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_coalesceval)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_previous)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should get Landing page of \"Layer Field\" with following :</br>"
						+ "1. Text-box :\"SEARCH\".</br>" + "2. Table with the fields like : \r\n"
						+ "\"Actions\" dropdown\r\n" + "\"LayerFieldDisplayName\", \r\n" + "\"TableName\",\r\n"
						+ "\"CoelaceValue\",\r\n" + "\"DataType\",\r\n" + "\"AllowEdit\",\r\n"
						+ "\"CreationTime\".</br>"
						+ "3. Buttons: \"<-Back\" , \"Next\" , \"Previous\" ,Page control."));
	}

	@Test(priority = 41, description = "To verify that user is able to get back to the \"Layer\" page from \"LayerField\" page by clicking on the \"<- Back\" button.")
	public void PV_LayerManagement_43() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_back_layerfield)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"<-Back\" button of \"Layer Field\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_pageheader)).getText(),
				"Layers");
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should get back to the \"Layer\" page from \"Layer Field\" page."));
	}

	@Test(priority = 42, description = "To verify that user is able to \"Edit\"  layer field from \"Layer Field\" page.")
	public void PV_LayerManagement_44() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).sendKeys("NA");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Edit \"Coalesce Value\" in \"Coalesce Value\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_infotooldispindex)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Edit selection of \"Info-Tool Visibility\"check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_reportdispindext)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit selection of \"Report Visibility \" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit value of \"Info-Tool Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit value of \"Report Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).sendKeys("Crime id edit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> :  Edit \"Display Name\" in \"Display Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Save\" button \"Edit Layer Field\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(),
				"Crime id edit");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1.User should able to click on \"Save\" button \"Edit Layer Field\" window and \"Edit Layer Field\" window should close.</br>"
						+ "2. Edited details should update on portal."));
	}

	@Test(priority = 43, description = "To verify that user is able to close(\"X\")  \"Edit Layer Field\" window.")
	public void PV_LayerManagement_45() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on close(\"X\") button of \"Update Layer Field\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should able to close \"Edit Layer Field\" window."));
	}

	@Test(priority = 44, description = "To verify that user is able to perform \"Cancel\" functionality of \"Edit Layer Field\" window.")
	public void PV_LayerManagement_46() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Cancel\" button of \"Update Layer Field\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Layer Field\" window and \"Edit Layer Field\" window should close."));
	}

	@Test(priority = 45, description = "To verify that user gets validation message when perform \"Cancel\" functionality after edit any field of \"Edit Layer Field\" window. ")
	public void PV_LayerManagement_47() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).sendKeys("NA");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Edit \"Coalesce Value\" in \"Coalesce Value\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_infotooldispindex)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Edit selection of \"Info-Tool Visibility\"check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_reportdispindext)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit selection of \"Report Visibility \" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit value of \"Info-Tool Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit value of \"Report Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).sendKeys("Crime id edit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> :  Edit \"Display Name\" in \"Display Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Cancel\" button of \"Edit Layer Field\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
						+ "2. \"Edit Layer\" window should also close."));
	}

	@Test(priority = 46, description = "To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Layer Field\" window.")
	public void PV_LayerManagement_48() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).sendKeys("NA");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Edit \"Coalesce Value\" in \"Coalesce Value\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_infotooldispindex)).click();
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Edit selection of \"Info-Tool Visibility\"check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_reportdispindext)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit selection of \"Report Visibility \" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit value of \"Info-Tool Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit value of \"Report Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).sendKeys("Crime id edit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> :  Edit \"Display Name\" in \"Display Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Cancel\" button of \"Edit Layer Field\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
						+ "2. \"Edit Layer\" window should display on screen."));
	}

	@Test(priority = 47, description = "To verify that user is able to \"Cancel\" the validation message of delete Layer Field.")
	public void PV_LayerManagement_50() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Actions\"-> \"Discard\" option from dropdown of particular layer field in \"Layer Field\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You want to delete this Layer Field?");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup of delete Layer Field should close."));
	}

	@Test(priority = 48, description = "To verify that user is able to \"Delete\"  layer field from \"Layer Field\" page.")
	public void PV_LayerManagement_49() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Actions\"-> \"Discard\" option from dropdown of particular layer field in \"Layer Field\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You want to delete this Layer Field?");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),
				"Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message should close.</br>"
						+ "2. Selected \"Layer Field\" should delete from \"Layer Field\" page."));
	}

	@Test(priority = 49, description = "To verify that user is able to perform \"SEARCH\" functionality of \"Layer Field\" page.")
	public void PV_LayerManagement_51() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime type");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(),
				"Crime type");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText(),
				"Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should get the searched result in \"Layer Field\" page."));
	}

	@Test(priority = 50, description = "To verify that user is able to perform sorting functionality for \"Layer Field Display Name\" , \"Table Name\" , \"Coalesce Value\" , \"Data Type\" , \"Allow Edit\" , \"Creation Time\" columns of \"Layer Field\" page. ")
	public void PV_LayerManagement_54(Method method) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");

		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Sorting\" icon of the \"Layer Field Display Name\" column.");
		String a1 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname))
				.getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).click();
		Thread.sleep(1000);
		String a2 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname))
				.getAttribute("aria-sort");
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result_01</b> : User should get records in alphabetical order of \"Layer Field Display Name\" data fields."));
		ll.Screenshotnew(driver, i, method.getName() + "_01");

		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Sorting\" icon of the \"Data Type\" column.");
		String a7 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype))
				.getAttribute("aria-label");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).click();
		Thread.sleep(1000);
		String a8 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype))
				.getAttribute("aria-label");
		Assert.assertNotEquals(a7, a8);
		ExtentTestManager.getTest().log(Status.INFO, String
				.format("<b>Result_02</b> : User should get records in sorting order of \"Data Type\" data fields."));
		ll.Screenshotnew(driver, i, method.getName() + "_02");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Sorting\" icon of the \"Allow Edit\" column.");
		String b1 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit))
				.getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).click();
		Thread.sleep(1000);
		String b2 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit))
				.getAttribute("aria-sort");
		Assert.assertNotEquals(b1, b2);
		ExtentTestManager.getTest().log(Status.INFO, String
				.format("<b>Result_03</b> : User should get records in sorting order of \"Allow Edit\" data fields."));
		ll.Screenshotnew(driver, i, method.getName() + "_03");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on \"Sorting\" icon of the \"Creation Time\" column.");
		String b3 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).click();
		Thread.sleep(1000);
		String b4 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).getAttribute("aria-sort");
		Assert.assertNotEquals(b3, b4);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result_04</b> : User should get records in sorting order of \"Creation Time\" data fields."));
	}

	@Test(priority = 51, description = "To verify that user is able to edit layer information by clicking on \"Edit\" option from the \"Actions\" dropdown.")
	public void PV_LayerManagement_55() throws InterruptedException {

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Crime mapping Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("0.5");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4375");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6891");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9703");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1854");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win))
				.getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
						+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Save\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(),
				"Crime mapping Test");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able click on \"Save\" button and \"Edit Layer\" window should close.</br>"
						+ "2. User should get updated information in \"Layer\" page."));
	}

	@Test(priority = 52, description = "To verify that user is able to close(\"X\") \"Edit Layer\" window.")
	public void PV_LayerManagement_56() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on close(\"X\") button of \"Edit Layer\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should able to close \"Edit Layer\" window."));
	}

	@Test(priority = 53, description = "To verify that user is able to perform \"Cancel\" functionality of \"Edit Layer\" window.")
	public void PV_LayerManagement_57() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Cancel\" button of \"Edit Layer\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Layer Field\" window and \"Edit Layer\" window should close."));
	}

	@Test(priority = 54, description = "To verify that user gets validation message when perform \"Cancel\" functionality after edit any field of \"Edit Layer\" window. ")
	public void PV_LayerManagement_58() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Crime mapping Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("0.5");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4375");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6891");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9703");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1854");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win))
				.getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
						+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Cancel\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
						+ "2. \"Edit Layer\" window should also close."));
	}

	@Test(priority = 55, description = "To verify that user is able to \"Cancel\" validation message for unsaved changes for \"Edit Layer\" window.")
	public void PV_LayerManagement_59() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Crime mapping Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("0.5");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4375");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6891");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9703");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1854");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win))
				.getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
						+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Cancel\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
						+ "2. \"Edit Layer\" window should display on screen."));
	}

	@Test(priority = 56, description = "To verify that user gets validation message when edited opacity value is greater than 1 and less than 0.")
	public void PV_LayerManagement_60() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("2");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.val_opacity)).getText(),
				"The field Opacity must be between 0 and 1.");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should get validation message like \"The field Opacity must be between 0 and 1.\"."));
	}

	@Test(priority = 57, description = "To verify that user is able to perform \"SEARCH\" functionality of \"Layer\" page.")
	public void PV_LayerManagement_63() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(),
				"Crime mapping Test");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText(),
				"Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should get the searched result in \"Layer\" page."));
	}

	@Test(priority = 58, description = "To verify that user is able to \"Cancel\" the validation message of delete the Layer.")
	public void PV_LayerManagement_62() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Delete\" option from dropdown of particular layer in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You want to delete this Layer ?");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup of delete Layer should close."));
	}

	@Test(priority = 59, description = "To verify that user is able to delete Layer from \"Layer\" page by clicking on \"Delete\" option from the \"Actions\" dropdown.")
	public void PV_LayerManagement_61() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Actions\"-->\"Delete\" option from dropdown of particular layer in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You want to delete this Layer ?");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),
				"Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
						+ "2. User should get toast validation like \"Successfully discarded!\".</br>"
						+ "3. Deleted \"Layer\" should delete from \"Layer\" page."));
	}

	@Test(priority = 60, description = "To verify that user is able to perform sorting functionality for \"Layer Title\" , \"Layer Name\" , \"Table Name\" columns of \"Layer\" page. ")
	public void PV_LayerManagement_66(Method method) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"Sorting\" icon of the \"Layer Title\" column.");
		String a1 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).click();
		Thread.sleep(1000);
		String a2 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).getAttribute("aria-sort");
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result_01</b> : User should get records in alphabetical sorting order of \"Layer Title\" data fields."));
		ll.Screenshotnew(driver, i, method.getName() + "_01");

		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Sorting\" icon of the \"Layer Name\" column.");
		String a7 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).getAttribute("aria-label");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).click();
		Thread.sleep(1000);
		String a8 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).getAttribute("aria-label");
		Assert.assertNotEquals(a7, a8);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result_02</b> : User should get records in alphabetical sorting order of \"Layer Name\" data fields."));
		ll.Screenshotnew(driver, i, method.getName() + "_02");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Click on \"Sorting\" icon of the \"Table Name\" column.");
		String b1 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename))
				.getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).click();
		Thread.sleep(1000);
		String b2 = driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename))
				.getAttribute("aria-sort");
		Assert.assertNotEquals(b1, b2);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result_03</b> : User should get records in alphabetical sorting order of \"Table Name\" data fields."));
	}

	@Test(priority = 61, description = "To verify that user is able to get back to \"Home\" page from \"Layer\" page by clicking on\"Home\" icon.")
	public void PV_LayerManagement_67() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_pageheader)).getText(),
				"Layers");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on\"Home\" icon in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should get back to \"Home\" page from \"Layer\" page."));
	}

	@Test(priority = 62, description = "To verify that user is able to \"Cancel\" the validation message of Delete OGC service.")
	public void PV_LayerManagement_41() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_delete_ogcservice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"X\"(Delete) button from Landing page of \"Layer\".");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"Are you sure to delete the OGCService?");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> :  Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message should close."));
	}

	@Test(priority = 63, description = "To verify that user is able to \"Delete\" OGC service by clicking on  \"X\"  button from \"Layers\" page.")
	public void PV_LayerManagement_40(Method method) throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_delete_ogcservice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"X\"(Delete) button from Landing page of \"Layer\".");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"Are you sure to delete the OGCService?");
		ll.Screenshotnew(driver, i, method.getName() + "_01");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> :  Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),
				"Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message should close.</br>"
						+ "2. User should get toast validation like \"Successfully discarded!\".</br>"
						+ "3. Selected \"OGC Service\" should delete from \"Layer\" page."));
	}

	@Test(priority=68,description="To verify that user is able to get \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_68() throws InterruptedException {

		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_pageheader)).getText(), "Layer Tree & Group");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_EditLayerTree)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_delete_layerTree)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_GetConfigFile)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Layer Tree & Group\" page with following :</br>"
				+ "1. Buttons : \r\n"
				+ "\"+New LayerTree\", \"+GetConfigFile\", Edit icon, Close(\"X\"),\"Map\".</br>"
				+ "2. Search-boxes :\r\n"
				+ "At left pane for Search Layer , For Layer Tree and Group.</br>"
				+ "3. Dropdown : \"Layer Tree\".</br>"
				+ "4. Existing layers present at left pane.\r\n"
				+ "5. Links : \"Home\" icon ."));
	}

	@Test(priority=69,description = "To verify that user is able to get \"New Layer Tree\" window by clicking on \"New Layer Tree\" button from \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_69(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.text_title_NewLayerTree_popup)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_description_NewLayerTree_popup))
				.isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.textb_title_NewLayerTree_popup)).isDisplayed(),
				true);
		Assert.assertEquals(driver
				.findElement(By.xpath(LayerManagement_repository.textb_description_NewLayerTree_popup)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_save)).isDisplayed(), true);

		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should get \"New Layer Tree\" window with following :\r\n"
						+ "</br>1. Text-boxes : \"Title*\", \"Description*\". \r\n"
						+ "</br>2. Buttons: \"Cancel\", \"Save\", close\"X\". "));
	}

	@Test(priority=70,description = "To verify that user is able to create new Layer Tree by clicking on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_70(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		Thread.sleep(1000);
		try {
			value.selectByVisibleText("Test Drag");
			Thread.sleep(5000);
			driver.findElement(By.xpath(LayerManagement_repository.btn_delete_layerTree)).click();
			driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
			Thread.sleep(3000);
		} finally {

			driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.INFO,
					"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
			driver.findElement(By.xpath(LayerManagement_repository.textb_title_NewLayerTree_popup))
					.sendKeys("Test Drag");
			ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Title Name in \"Title\" text-box.");
			driver.findElement(By.xpath(LayerManagement_repository.textb_description_NewLayerTree_popup))
					.sendKeys("Add Layer Test Drag");
			Thread.sleep(1000);
			ExtentTestManager.getTest().log(Status.INFO,
					"<b>Step-9</b> : Enter Description in \"Description\" text-box.");
			driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(Status.INFO,
					"<b>Step-10</b> : Click on \"Save\" button of \"New Layer Tree\" window.");
			Thread.sleep(3000);
			Assert.assertEquals(
					driver.findElements(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).size() != 0,
					false);
			Thread.sleep(1000);
			Select value1 = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
			value1.selectByVisibleText("Test Drag");

		}
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"New Layer Tree\" window and window should close.\r\n"
						+ "</br>2. Added Layer Tree is display in \"Layer Tree\" dropdown list."));
	}

	@Test(priority=71,description = "To verify that user is able to close \"New Layer Tree\" window  by clicking on the close(\"X\") button.")
	public void PV_LayerManagement_71(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).isDisplayed(), true);
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"X\"(close)  button of \"New Layer Tree\" window.");
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should able to close \"New Layer Tree\" window."));

	}

	@Test(priority=72,description = "To verify that user is able to perform \"Cancel\" functionality of \"New Layer Tree\" window.")
	public void PV_LayerManagement_72(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).isDisplayed(), true);
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Cancel\" button of \"New Layer Tree\" window.");
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"New Layer Tree\" window and window should close."));

	}

	@Test(priority=73,description = "To verify that user is able to validation message when perform \"Cancel\" functionality of \"New Layer Tree\" window after adding details in respective fields.")
	public void PV_LayerManagement_73(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_NewLayerTree_popup)).sendKeys("Test Drag");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Title Name in \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_description_NewLayerTree_popup))
				.sendKeys("Add Layer Tree test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Cancel\" button of \"New Layer Tree\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).size() != 0, false);

		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.\r\n"
						+ "</br>2. \"New Layer Tree\" window should also close."));
	}

	@Test(priority=74,description = "To verify that user is able to \"Cancel\" validation message popup of unsaved changes of \"New Layer Tree\" window.")
	public void PV_LayerManagement_74(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_NewLayerTree_popup)).sendKeys("Test Drag");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Title Name in \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_description_NewLayerTree_popup))
				.sendKeys("Add Layer Tree test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Cancel\" button of \"New Layer Tree\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.title_NewLayerTree_popup)).size() != 0, true);

		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.\r\n"
						+ "</br>2. \"New Layer Tree\" window shouldn't close."));
	}

	@Test(priority=75,description = "To verify that user gets validation message when click on \"Save\" button without entering mandatory details of \"New Layer Tree\" window.")
	public void PV_LayerManagement_75(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on \"Save\" button of \"New Layer Tree\" window.");
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.text_validation_titleField_NewLayerTree_popup))
						.isDisplayed(),
				true);
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should get validation messages like:\r\n"
						+ "</br>\"The Title field is required.\"."));
	}

	@Test(priority=76,description = "To verify that user gets validation message when create layer tree which already exist in \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_76(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		Thread.sleep(1000);
		List<WebElement> alllist = value.getOptions();

		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Click on \"+New Layer Tree\" button from \"Layer Tree & Group\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_NewLayerTree_popup))
				.sendKeys(alllist.get(0).getText());
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Title Name in \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_description_NewLayerTree_popup))
				.sendKeys("Add Layer Tree test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Description in \"Description\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Save\" button of \"New Layer Tree\" window.");

		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"LayerTree already exist with the same name.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_ok)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_ok)).isDisplayed(),
				false);

		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"OK\" button of validation  message popup and popup should close."));
	}

	@Test(priority=77,description = "To verify that user is able to \"Create Layer Group\" window in \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_77(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Create Layer Group");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_enIN)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lnk_hiIN)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.textb_title_enIN_createGroupLAyer))
				.isDisplayed(), true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).isDisplayed(),
				true);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.chkb_isExpanded_createGroupLAyer)).isDisplayed(),
				true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_save)).isDisplayed(), true);

		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : </br>1. User should able to click on \"Crate Group\" option.\r\n"
						+ "</br>2. User should get \"Create Layer Group\" window with following:\r\n"
						+ "</br>2.1. \"Title\" field text-box.\r\n"
						+ "</br>2.2. Buttons: \"Cancel\", \"Save\", close\"X\".\r\n"
						+ "</br>2.3. Check-boxes: \"Is Active ?\" , Is Expanded?\".\r\n"
						+ "</br>2.4. \"en-IN\" , \"hi-IN\" links."));
	}

	@Test(priority=78,description = "To verify that user is able to \"Create Layer Group\" under Layer Tree in \"Layer Tree & Group\" page by performing \"Create Group\" functionality.")
	public void PV_LayerManagement_78(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_enIN_createGroupLAyer))
				.sendKeys("Test Group");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Title Name in \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Check-on \"Is Active ?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_isExpanded_createGroupLAyer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Check-on \"Is Expanded?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_hiIN)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on hi-IN tab.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_hiIN_createGroupLAyer))
				.sendKeys(" परीक्षण समूह");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Enter Title Name in \"Title\" text-box of hi-IN section.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Save\" button of \"Create Layer Group\" window.");
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).size() != 0,
				false);
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_groupName_layerTree)).getText(),
				"Test Group");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Save\" button of \"Create Layer Group\" window and window should close.\r\n"
						+ "</br>2. Created group added under \"Layer Tree\" at which layer group to be created."));

	}

	@Test(priority=79,description = "To verify that user is able to close \"Create Layer Group\" window  by clicking on the close(\"X\") button.")
	public void PV_LayerManagement_79(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Create Layer Group");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"X\" button of \"Create Layer Group\" window.");
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).size() != 0,
				false);
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should able to close \"Create Layer Group\" window."));

	}

	@Test(priority=80,description = "To verify that user is able to perform \"Cancel\" functionality of \"Create Layer Group\" window.")
	public void PV_LayerManagement_80(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Create Layer Group");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Cancel\" button of \"Create Layer Group\" window.");
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).size() != 0,
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Create Layer Group\" window and window should close."));

	}

	@Test(priority=81,description = "To verify that user gets validation message when click on \"Save\" button without entering mandatory details of \"Create Layer Group\" window.")
	public void PV_LayerManagement_81(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Create Layer Group");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"Save\" button without entering details in \"Create Layer Group\" window.");
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.text_validation_titleField_enIN)).isDisplayed(),
				true);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_hiIN)).click();
		Thread.sleep(1000);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.text_validation_titleField_hiIN)).isDisplayed(),
				true);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should get validation message like : \"The Title field is required.\" in both tab section."));

	}

	@Test(priority=82,description = "To verify that user gets validation message when create group with same name under Layer Tree  in \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_82(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_enIN_createGroupLAyer))
				.sendKeys("Test Group");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Title Name in \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Check-on \"Is Active ?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_isExpanded_createGroupLAyer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Check-on \"Is Expanded?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_hiIN)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on hi-IN tab.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_hiIN_createGroupLAyer))
				.sendKeys(" परीक्षण समूह");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Enter Title Name in \"Title\" text-box of hi-IN section.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Click on \"Save\" button of \"Create Layer Group\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"LayerGroup already exist with the same name.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_ok)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"OK\" button of validation  message popup and popup should close."));

	}

	@Test(priority=83,description = "To verify that user gets validation message while performing \"Cancel\" functionality after adding details in \"Create Layer Group\" window.")
	public void PV_LayerManagement_83(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_enIN_createGroupLAyer))
				.sendKeys("Test Group");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Title Name in \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Check-on \"Is Active ?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_isExpanded_createGroupLAyer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Check-on \"Is Expanded?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_hiIN)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Click on hi-IN tab.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_hiIN_createGroupLAyer))
				.sendKeys(" परीक्षण समूह");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Enter Title Name in \"Title\" text-box of hi-IN section.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> :  Click on \"Cancel\" button of \"Create Layer Group\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).size() != 0,
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.\r\n"
						+ "</br>2. \"Create Layer Group\" window should also close."));

	}

	@Test(priority=84,description = "To verify that user is able to \"Cancel\" validation message popup of unsaved changes of \"Create Layer Group\" window.")
	public void PV_LayerManagement_84(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTree));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Right click on Layer Tree under which layer group want to be create.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_createGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Create Group\" option.");
		driver.findElement(By.xpath(LayerManagement_repository.textb_title_enIN_createGroupLAyer))
				.sendKeys("Test Group");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Enter Title Name in \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Check-on \"Is Active ?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chkb_isExpanded_createGroupLAyer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Check-on \"Is Expanded?\" check-box.");

		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> :  Click on \"Cancel\" button of \"Create Layer Group\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.chkb_active_createGroupLAyer)).size() != 0,
				true);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.\r\n"
						+ " </br>2. \"Create Layer Group\" window shouldn't close."));

	}

	@Test(priority=85,description = "To verify that user is able to \"Add Layer\" under Layer Group of Layer Tree in \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_85(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-8</b> : Click on expand icon \"Layer Tree\"./Double click on \"Layer Tree\".");
		WebElement drag = driver.findElement(By.xpath(LayerManagement_repository.layer_atm));
		WebElement drop = driver.findElement(By.xpath(LayerManagement_repository.text_groupName_layerTree));
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", drag, drop);
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Drag layer from layer present at left pane and drop at Layer Group under which layer want to be add.");

		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),
				"Added successfully.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer)).getText(),
				"Atm Test");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to drag layer from left pane and drop at Layer Group.\r\n"
						+ "</br>2. User should get validation toast message like \"Added successfully.\".\r\n"
						+ "</br>3. User should able to view added layer under Layer Group."));

	}

	@Test(priority=86,description = "To verify that user gets validation message when same layer is add under Layer Group of Layer Tree in \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_86(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
		WebElement drag = driver.findElement(By.xpath(LayerManagement_repository.layer_atm));
		WebElement drop = driver.findElement(By.xpath(LayerManagement_repository.text_groupName_layerTree));
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", drag, drop);
		Thread.sleep(1500);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-9</b> : Drag same layer of same \"OGC Service\" from left pane and drop at Layer Group under which same layer is present already.");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"LayerGroupMapping already exist with the same name.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_ok)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-10</b> : Click on \"OK\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"OK\" button of validation  message popup and popup should close."));

	}

	@Test(priority=87,description = "To verify that user is able to \"Edit\" Layer present under Layer Group of Layer Tree in \"Layer Tree & Group\" page.")
	public void PV_LayerManagement_87(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");

		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_editLayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Edit Layer\" option from dialog box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Edit Layer");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click \"en-In\" or \"hi-IN\" tab.");

		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Atm Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("0.5");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4375");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6891");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9703");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-17</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1854");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-18</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win))
				.getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-19</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
						+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-20</b> : Click on \"Save\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer)).getText(),
				"Atm Test");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able click on \"Save\" button and \"Edit Layer\" window should close.\r\n"
						+ "</br>2. User should get updated information of layer in \"Layer Tree & Group\" page."));
	}

	@Test(priority=88,description = "To verify that user is able to close \"Edit Layer\" window  by clicking on the close(\"X\") button.")
	public void PV_LayerManagement_88(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");

		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_editLayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Edit Layer\" option from dialog box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Edit Layer");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on close(\"X\") button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO,
				String.format("<b>Result</b> : User should able to close \"Edit Layer\" window."));
	}

	@Test(priority=89,description = "To verify that user is able to perform \"Cancel\" functionality of \"Edit Layer\" window.")
	public void PV_LayerManagement_89(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");

		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_editLayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Edit Layer\" option from dialog box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Edit Layer");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on \"Cancel\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Layer\" window and window should close."));
	}

	@Test(priority=90,description = "To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after Editing details in \"Edit Layer\" window.")
	public void PV_LayerManagement_90(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");

		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_editLayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Edit Layer\" option from dialog box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Edit Layer");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click \"en-In\" or \"hi-IN\" tab.");

		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Atm");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4378");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6890");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9705");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-17</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1859");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-18</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win))
				.getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-19</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
						+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-20</b> : Click on \"Cancel\"/\"X\"(close) button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-21</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size() != 0, false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer)).getText(),
				"Atm Test");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.\r\n"
						+ "</br>2. \"Edit Layer\" window should also close."));

	}

	@Test(priority=91,description = "To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Layer\" window.")
	public void PV_LayerManagement_91(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");

		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_editLayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Edit Layer\" option from dialog box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Edit Layer");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click \"en-In\" or \"hi-IN\" tab.");

		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Atm");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-14</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4378");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-15</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6890");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-16</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9705");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-17</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1859");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-18</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_active_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isvisible_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win))
				.getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-19</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
						+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-20</b> : Click on \"Cancel\"/\"X\"(close) button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"You have unsaved changes.");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-21</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));

	}

	@Test(priority=92,description = "To verify that user gets validation message when edited opacity value is greater than 1 and less than 0 in \"Edit Layer\" window.")
	public void PV_LayerManagement_92(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");

		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_editLayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-11</b> : Click on \"Edit Layer\" option from dialog box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).getText(),
				"Edit Layer");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("2");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-13</b> : Click on \"Save\" button of \"Edit Layer\" window.");
		Thread.sleep(1000);
		Assert.assertEquals(
				driver.findElement(By.xpath(LayerManagement_repository.validation_opacity_editLayer)).isDisplayed(),
				true);
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should get validation message like \"The field Opacity must be between 0 and 1.\"."));

	}

	@Test(priority=93,description = "To verify that user is able to delete layer from \"Layer Tree\" by performing \"Remove Mapping\" functionality.")
	public void PV_LayerManagement_93(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");

		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_removeMapping)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Remove Mapping\" option.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"Are you sure to delete the layer mapping?");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
		Thread.sleep(1000);
		Assert.assertEquals(
				driver.findElements(By.xpath(LayerManagement_repository.text_addedPresentLayer)).size() != 0, false);

		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : </br>1. User should able to click on \"Yes\" button of validation message and message popup should close.\r\n"
						+ "</br>2. Deleted layer is removed from \"Layer Tree\"."));

	}

	@Test(priority=94,description = "To verify that user is able to \"Cancel\" validation message of delete layer.")
	public void PV_LayerManagement_94(Method method) throws InterruptedException {
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		Thread.sleep(1000);

		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Click on \"Login\" button.");

		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerTreeAndGroup)).click();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		Select value = new Select(driver.findElement(By.xpath(LayerManagement_repository.ddl_layerTree)));
		value.selectByVisibleText("Test Drag");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerTree)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
		WebElement drag = driver.findElement(By.xpath(LayerManagement_repository.layer_atm));
		Thread.sleep(1000);
		WebElement drop = driver.findElement(By.xpath(LayerManagement_repository.text_groupName_layerTree));
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				+ "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				+ "var dropEvent = createEvent('drop');\n"
				+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				+ "var dragEndEvent = createEvent('dragend');\n"
				+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				+ "simulateHTML5DragAndDrop(source,destination);", drag, drop);
		Thread.sleep(1500);

		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),
				"Added successfully.");
		driver.findElement(By.xpath(LayerManagement_repository.expand_layerGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on expand icon of \"Layer Group\".");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer)).getText(),
				"Atm Test");
		Actions ac = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer));
		ac.contextClick(elementLocator).perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Right click on Layer which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_removeMapping)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Remove Mapping\" option.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),
				"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),
				"Are you sure to delete the layer mapping?");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,
				"<b>Step-12</b> : Click on \"Cancel\" button validation message popup.");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),
				false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_addedPresentLayer)).getText(),
				"Atm Test");
		ExtentTestManager.getTest().log(Status.INFO, String.format(
				"<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and popup should close."));

	}
	
@Test(priority=95,description="To verify that user is able to get \"Edit Layer Group\" window of selected Layer Group from \"Layer Tree\".")
	
	public void PV_LayerManagement_95() throws InterruptedException 	
     {
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		
		
		driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_NewLayerTree)).sendKeys("Demo");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);	
		
		driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
		Thread.sleep(1000);		
	   ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		
		for(int i=1;i<5;i++)
			
		{
			Actions act = new Actions(driver);
			act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
			Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Create Group']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).sendKeys("TEST LAYER "+i);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/form/div/div/div/div[2]/div[1]/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"LayerGroup_Locales_hi-IN__Title\"]")).sendKeys("TEST LAYER "+i);
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(2000);
		}		
	
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
		act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree_LayerGroup))).build().perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Right click on Layer Group which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_EditGroup)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Edit Group\" option from dialog box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).sendKeys("Edited Group");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit \"Title\" from \"Title\" text-box.");	
		driver.findElement(By.xpath(LayerManagement_repository.dd_DisplayIndex_EditLayerGroup)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.dd_DisplayIndex_EditLayerGroup)).sendKeys("10");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit \"Display Index\" value in respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsActive_EditLayerGroup)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit selection of \"Is Active?\" checkbox.");
		driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsExpanded_EditLayerGroup)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Edit selection of \"Is Expanded ?\" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();	
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button of \"Edit Layer Group\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txt_EditedGroup)).isDisplayed(),true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able to click on \"Save\" button of \"Edit Layer Group\" window and window should close.<br>"
				 +"2. User should get updated information of Layer Group in \"Layer Tree & Group\" page."));
     }
	
	
	@Test(priority=96,description="To verify that user is able to close \"Edit Layer Group\" window  by clicking on the close(\"X\") button.")
	
	public void PV_LayerManagement_96() throws InterruptedException 	
     {
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
		Thread.sleep(1000);
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
		act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree_LayerGroup))).build().perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Right click on Layer Group which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_EditGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Edit Group\" option from dialog box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"X\" button of \"Edit Layer Group\" window.");	
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0, true);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0, true);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0, true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Layer Group\" window."));
			
			
}
		
	
@Test(priority=97,description="To verify that user is able to perform \"Cancel\" functionality of  \"Edit Layer Group\" window.")
	
	public void PV_LayerManagement_97() throws InterruptedException 	
     {
		
	    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
		Thread.sleep(1000);
	   ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
		act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree_LayerGroup))).build().perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Right click on Layer Group which want to be edit.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_EditGroup)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Edit Group\" option from dialog box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(2000);    	
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Cancel\" button of \"Edit Layer Group\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0, true);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0, true);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0, true);
	    ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Layer Group\" window and window should close."));
     }
	
	
	
@Test(priority=98,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after editing details in \"Edit Layer Group\" window.")

public void PV_LayerManagement_98() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(500);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	Actions act = new Actions(driver);
	act.doubleClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
	act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree_LayerGroup))).build().perform();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Right click on Layer Group which want to be edit.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_EditGroup)).click();
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Edit Group\" option from dialog box.");
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).sendKeys("TEST1");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit \"Title\" from \"Title\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_DisplayIndex_EditLayerGroup)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.dd_DisplayIndex_EditLayerGroup)).sendKeys("10");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit \"Display Index\" value in respective text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsActive_EditLayerGroup)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit selection of \"Is Active?\" checkbox.");
	driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsExpanded_EditLayerGroup)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Edit selection of \"Is Expanded ?\" check-box.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();	
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\"/\"X\"(close) button of \"Edit Layer Group\" window.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);
	
	
    //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_cancel)).size()==0, true);	
    //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_yes)).size()==0, true);
	
    //Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(),false);
	//Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_close)).isDisplayed(),false);
	//Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_save)).isDisplayed(),false);
	
	//Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0, true);
//Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0, true);
	//Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0, true);	
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.<br>"
			+ "2. \"Edit Layer Group\" window should also close."));
 }



@Test(priority=99,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Layer Group\" window.")

public void PV_LayerManagement_99() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(500);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	Actions act = new Actions(driver);
	act.doubleClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
	act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree_LayerGroup))).build().perform();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Right click on Layer Group which want to be edit.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_EditGroup)).click();
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Edit Group\" option from dialog box.");
	
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).sendKeys("TEST1");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit \"Title\" from \"Title\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_DisplayIndex_EditLayerGroup)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.dd_DisplayIndex_EditLayerGroup)).sendKeys("10");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit \"Display Index\" value in respective text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsActive_EditLayerGroup)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit selection of \"Is Active?\" checkbox.");
	driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsExpanded_EditLayerGroup)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Edit selection of \"Is Expanded ?\" check-box.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();	
	Thread.sleep(3000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\"/\"X\"(close) button of \"Edit Layer Group\" window.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txt_Title_EditLayerGroup)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.dd_DisplayIndex_EditLayerGroup)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerGroup)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsActive_EditLayerGroup)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chckbox_IsExpanded_EditLayerGroup)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_save)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(),true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
 }



@Test(priority=100,description="To verify that user is able to remove the Layer Group from Layer Tree in \"Layer Tree & Group\" page.")

public void PV_LayerManagement_100() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(500);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	Actions act = new Actions(driver);
	act.doubleClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
	List <WebElement> listofItems = driver.findElements(By.xpath(LayerManagement_repository.LayerTree_LayerGroups_xpath));
	
	int old_size=listofItems.size();
	
	act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree_LayerGroup))).build().perform();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Right click on Layer Group which want to be delete.");
	
	driver.findElement(By.xpath(LayerManagement_repository.dd_RemoveGroup)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Remove Group\" option from dialog box.");
	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the layer group?");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
	Thread.sleep(1500);		
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Yes\" button of validation message popup.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),"Successfully discarded!");
	Thread.sleep(1000);	
	List <WebElement> listofItems1 = driver.findElements(By.xpath(LayerManagement_repository.LayerTree_LayerGroups_xpath));
	int new_size=listofItems1.size();
	Assert.assertEquals(old_size-1 , new_size);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able to click on \"Yes\" button of validation message and message popup should close.<br>"
			+ "2. Deleted Layer Group is removed from \"Layer Tree\"."));
 }





@Test(priority=101,description="To verify that user is able to \"Cancel\" validation message of delete the Layer Group.")

public void PV_LayerManagement_101() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(500);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	Actions act = new Actions(driver);
	act.doubleClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree))).perform();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on expand icon \"Layer Tree\".");
	List <WebElement> listofItems = driver.findElements(By.xpath(LayerManagement_repository.LayerTree_LayerGroups_xpath));
	
	int old_size=listofItems.size();
	
	act.contextClick(driver.findElement(By.xpath(LayerManagement_repository.LayerTree_LayerGroup))).build().perform();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Right click on Layer Group which want to be delete.");
	
	driver.findElement(By.xpath(LayerManagement_repository.dd_RemoveGroup)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Remove Group\" option from dialog box.");
	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the layer group?");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
	Thread.sleep(1500);		
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Cancel\" button of validation message popup.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);	
	Thread.sleep(1000);	
	List <WebElement> listofItems1 = driver.findElements(By.xpath(LayerManagement_repository.LayerTree_LayerGroups_xpath));
	int new_size=listofItems1.size();
	Assert.assertEquals(old_size, new_size);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and popup should close."));
 }



@Test(priority=102,description="To verify that user is able to edit Layer Tree by performing \"Edit\" functionality.")

public void PV_LayerManagement_102() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_EditLayerTree)).click();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Edit\" icon from \"Layer Tree & Group\" page.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txt_EditLayerTree_Title)).getText(),"Edit Layer Tree");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lbl_Title_EditLayerTree)).getText(),"Title");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lbl_Description_EditLayerTree)).getText(),"Description");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerTree)).isDisplayed(),true);	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txtbox_Description_EditLayerTree)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_close)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_save)).isDisplayed(),true);
	
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerTree)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerTree)).sendKeys("Test100");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Title Name in \"Title\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Description_EditLayerTree)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Description_EditLayerTree)).sendKeys("Test Description");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit Description  in \"Description\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
	Thread.sleep(2000);	
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Save\" button of \"Edit Layer Tree\" window.");
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0,true);
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).click();
	Thread.sleep(1000);	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.dd_EditedLayerTree)).isDisplayed(),true);
	Thread.sleep(500);		
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able click on \"Save\" button and \"Edit Layer Tree\" window should close.<br>"
			+ "2. User should get updated information of Layer Tree in \"Layer Tree & Group\" page."));
 }



@Test(priority=103,description="To verify that user is able to close \"Edit Layer Tree\" window  by clicking on the close(\"X\") button.")

public void PV_LayerManagement_103() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_EditLayerTree)).click();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Edit\" icon from \"Layer Tree & Group\" page.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"X\" button of \"Edit Layer Tree\" window.");
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0,true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Layer Tree\" window."));
 }




@Test(priority=104,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Layer Tree\" window.")

public void PV_LayerManagement_104() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_EditLayerTree)).click();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Edit\" icon from \"Layer Tree & Group\" page.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Cancel\" button of \"Edit Layer Tree\" window.");
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0,true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Layer Tree\" window and window should close."));
 }







@Test(priority=105,description="To verify that user gets validation message when perform \"Cancel\"/\"X\"(close) functionality after editing details in \"Edit Layer Tree\" window.")

public void PV_LayerManagement_105() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_EditLayerTree)).click();	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerTree)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerTree)).sendKeys("Test100");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Title Name in \"Title\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Description_EditLayerTree)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Description_EditLayerTree)).sendKeys("Test Description");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit Description  in \"Description\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Cancel\"/\"X\"(close) button of \"Edit Layer Tree\" window.");
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Click on \"Yes\" button of validation message popup.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);
	
    //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_cancel)).size()==0, true);	
    //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_yes)).size()==0, true);
	
    //Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(),false);
	//Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_close)).isDisplayed(),false);
	//Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_save)).isDisplayed(),false);
	
	//Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0, true);
    //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0, true);
	//Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0, true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.<br>"
			+ "2. \"Edit Layer Tree\" window should also close."));
 }




@Test(priority=106,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Layer Tree\" window.")

public void PV_LayerManagement_106() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_EditLayerTree)).click();	
	Thread.sleep(1000);
	
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerTree)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_EditLayerTree)).sendKeys("Test100");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Title Name in \"Title\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Description_EditLayerTree)).clear();
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Description_EditLayerTree)).sendKeys("Test Description");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit Description  in \"Description\" text-box.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Cancel\"/\"X\"(close) button of \"Edit Layer Tree\" window.");
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Click on \"Cancel\" button of validation message popup.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup should close."));
 }




@Test(priority=107,description="To verify that user is able to \"Delete\" selected Layer Tree from the \"Layer Tree & Group\" page.")

public void PV_LayerManagement_107() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_NewLayerTree)).click();
	
	driver.findElement(By.xpath(LayerManagement_repository.txtbox_Title_NewLayerTree)).sendKeys("Test5");
	Thread.sleep(1000);
	driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test5");
	Thread.sleep(1000);
  ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_DeleteLayerTree)).click();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Delete\"  icon from \"Layer Tree & Group\" page.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the layer tree?");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Yes\" button of validation message popup.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).click();
	Thread.sleep(1000);		
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),"Successfully discarded!");
	Thread.sleep(1000);	
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able to click on \"Yes\" button of validation message and message popup should close.<br>"
			+ "2. Deleted Layer Tree is removed from \"Layer Tree & Group\" page."));
	
 }



@Test(priority=108,description="To verify that user is able to \"Cancel\" validation message of delete the Layer Tree.")

public void PV_LayerManagement_108() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test5");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_DeleteLayerTree)).click();	
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Delete\"  icon from \"Layer Tree & Group\" page.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the layer tree?");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).getText(),"Yes");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).getText(),"Cancel");
	
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Cancel\" button of validation message popup.");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).isDisplayed(),false);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and message popup should close."));
 }



@Test(priority=109,description="To verify that user is able to get a config file of selected Layer Tree by clicking on \"+GetConfigFile\" button in  \"Layer Tree & Group\" page.")

public void PV_LayerManagement_109() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_GetConfigFile)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on  \"+GetConfigFile\" button.");
	Thread.sleep(1000);	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),"Config file has successfully saved");
	Thread.sleep(1000);	
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Config file has successfully saved\"."));
 }


@Test(priority=110,description="To verify that user is able to get \"Layer Tree-Department Mapping\" window by clicking on \"Map\" icon from \"Layer Tree & Group\" page.")

public void PV_LayerManagement_110() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Map\" icon from \"Layer Tree & Group\" page.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txt_Title_Map)).getText(),"Layer Tree-Department Mapping");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lbl_LayerTree_Map)).getText(),"Layer Tree *");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.lbl_Department_Map)).getText(),"Departments *");	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree_Map)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_save)).isDisplayed(),true);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_close)).isDisplayed(),true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get \"Layer Tree-Department Mapping\" window with following:<br>"
			+ "1. Dropdowns: \"Layer Tree\" (Pre selected), \"Departments\".<br>"
			+ "2. Buttons: \"Cancel\" , \"Save\" , \"X\"(close)."));	
 }



@Test(priority=111,description="To verify that user is able to perform Layer Tree-Department Mapping functionality by clicking on \"Map\" icon from \"Layer Tree & Group\" page.")

public void PV_LayerManagement_111() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Map\" icon from \"Layer Tree & Group\" page.");
    driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).click();
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Departments\" dropdown.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_Division13_Department_Map)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Select departments from \"Departments\" dropdown.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
	Thread.sleep(2000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Save\" button.");
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0,true);
	Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0,true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : 1. User should able to click on \"Save\" button.<br>"
			+ "2. Added details should update on portal.<br>"
			+ "3. \"Layer Tree-Department Mapping\" window should close."));	
 }



@Test(priority=112,description="To verify that user is able to close \"Layer Tree-Department Mapping\" window.")

public void PV_LayerManagement_112() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Map\" icon from \"Layer Tree & Group\" page.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"X\"(close) button of \"Layer Tree-Department Mapping\" window.");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
	Thread.sleep(2000);
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).isDisplayed(), false);
	
	// Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_cancel)).size()==0, true);	
    // Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_yes)).size()==0, true);
     
   //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0, true);
     //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0, true);
 	//Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0, true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Layer Tree-Department Mapping\" window."));
	
 }


@Test(priority=113,description="To verify that user is able to perform \"Cancel\" functionality of \"Layer Tree-Department Mapping\" window.")

public void PV_LayerManagement_113() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Map\" icon from \"Layer Tree & Group\" page.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"X\"(close) button of \"Layer Tree-Department Mapping\" window.");
	driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
	Thread.sleep(2000);
	
	
	// Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_cancel)).size()==0, true);	
    // Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.validation_btn_yes)).size()==0, true);

	
   //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_cancel)).size()==0, true);
     //Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_close)).size()==0, true);
 	//Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.btn_save)).size()==0, true);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Layer Tree-Department Mapping\" window and window should close."));
 }


@Test(priority=114,description="To verify that user is able to remove particular selected department from \"Departments\" dropdown by clicking on \"X\" icon.")

public void PV_LayerManagement_114(Method method) throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Demo");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Map\" icon from \"Layer Tree & Group\" page.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).click();
	
	driver.findElement(By.xpath(LayerManagement_repository.dd_Division12_Department_Map)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select departments from \"Departments\" dropdown.");
	ll.Screenshotnew(driver, i, method.getName() + "_01");
	
	driver.findElement(By.xpath(LayerManagement_repository.btn_cross_Particular_Map)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"X\" icon of particular selected department.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to remove particular selected department."));
 }


@Test(priority=115,description="To verify that user is able to remove all selected department from \"Departments\" dropdown by clicking on \"X\" icon.")
public void PV_LayerManagement_115(Method method) throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Map\" icon from \"Layer Tree & Group\" page.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).click();
	driver.findElement(By.xpath(LayerManagement_repository.dd_Division13_Department_Map)).click();
	driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).click();
	driver.findElement(By.xpath(LayerManagement_repository.dd_Division12_Department_Map)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Select departments from \"Departments\" dropdown.");
	ll.Screenshotnew(driver, i, method.getName() + "_01");
	
	driver.findElement(By.xpath(LayerManagement_repository.btn_cross_All_Map)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"X\" icon of \"Department\" dropdown.");
	driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).click();
	Thread.sleep(1000);
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to remove all selected departments."));
 }


@Test(priority=116,description="To verify that user gets validation message when click on \"Save\" button with blank mandatory details of \"Layer Tree-Department Mapping\" window.")
public void PV_LayerManagement_116() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	driver.findElement(By.xpath(LayerManagement_repository.dd_LayerTree)).sendKeys("Test");
	Thread.sleep(1000);
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select Layer Tree from \"Layer Tree\" dropdown list.");	
	driver.findElement(By.xpath(LayerManagement_repository.btn_MapLayerTree)).click();
	Thread.sleep(1500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Map\" icon from \"Layer Tree & Group\" page.");
	driver.findElement(By.xpath(LayerManagement_repository.btn_cross_All_Map)).click();
	driver.findElement(By.xpath(LayerManagement_repository.dd_Department_Map)).click();
	driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Save\" button with blank \"Departments\" dropdown of \"Layer Tree-Department Mapping\" window.");
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_Map)).getText(),"The Departments field is required.");
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"The Departments field is required.\"."));
 }


@Test(priority=117,description="To verify that user is able to get back to \"Home\" page from \"Layer Tree & Group\" page by clicking on Home icon.")
public void PV_LayerManagement_117() throws InterruptedException 	
 {
	
    ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
	driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
	Thread.sleep(500);
	driver.findElement(By.xpath(LayerManagement_repository.menuitem_LayertreeAndGroup)).click();
	Thread.sleep(500);
	ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer Tree & Group\" menu.");	
	driver.findElement(By.xpath(LayerManagement_repository.icon_Home_LayerTreeandGroup)).click();	
	Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txt_Home_Welcome)).getText(),"Welcome to the City Policing application.");	
	ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Layer Tree & Group\" page."));
 }

	@AfterMethod
	public void Aftermethod() throws InterruptedException {
		/*
		 * Actions act=new Actions(driver);
		 * act.moveToElement(driver.findElement(By.xpath(Login_repository.profile_admin)
		 * )). build().perform(); Thread.sleep(1000);
		 * driver.findElement(By.xpath(Login_repository.lnk_logout)).click();
		 * Thread.sleep(2000);
		 */
		driver.close();
		Thread.sleep(1000);
	}

}
