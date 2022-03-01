package pv_admin;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
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
	Screenshot_extra ll=new Screenshot_extra();
	String i="PV_LayerManagement_extra_ss";
	
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
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		context.setAttribute("WebDriver", driver);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(1000);
		driver.get("https://qapoc.sgligis.com:10014");
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
	
	@Test(priority=0,description="To verify that user is able to perform pagination functionality in  Scan Layer page of selected \"OGC Service\".")
	public void PV_LayerManagement_38(Method method) throws InterruptedException

	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_scanlayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_rescan)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click \"Rescan\" button.");
		String s1=driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		driver.findElement(By.xpath(LayerManagement_repository.btn_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Next\" button of the paging.");
		String s2=driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s1, s2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get next page of selected \"OGC Service\" Scan Layer page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(LayerManagement_repository.btn_previous)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Click on \"Previous\" button of the paging.");
		String s3=driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s2, s3);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get previous page of selected \"OGC Service\" Scan Layer page."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_pageno_3)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Click on particular page no. in Scan Layer page of selected \"OGC Service\" .");
		String s4=driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		Assert.assertNotEquals(s3, s4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get selected page no. of records in Scan Layer page of selected \"OGC Service\" ."));
	}
	
	@Test(priority=1,description="To verify that user is able to select particular layer  from \"--Select Layer--\" dropdown list in scan layer page of selected \"OGC Service\".")
	public void PV_LayerManagement_39() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_scanlayer)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Scan Layer\" button from \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_rescan)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click \"Rescan\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_addlay_crimemapping)).click();
		Thread.sleep(1000);
		WebElement e1=driver.findElement(By.xpath(LayerManagement_repository.btn_rescan));
		Coordinates co1 = ((Locatable)e1).getCoordinates();
		co1.onPage(); co1.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_rescan)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(LayerManagement_repository.dd_sellayer)).sendKeys("bridge");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"--Select Layer--\" dropdown list.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Select particular layer from the dropdown list.");
		String s1=driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText();
		System.out.println(s1);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get selected layer in Scan Layer page of selected \"OGC Service\" ."));
	}
	
	@Test(priority=2,description="To verify that user is able to get Landing page of \"Layer Field\"  by clicking on \"Layer Field\" option from the \"Actions\" dropdown on \"Layer\" page.")
	public void PV_UserManagement_42() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_pageheader)).getText(), "Layer Field");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_actions)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_coalesceval)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.dd_entries)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_next)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.btn_previous)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get Landing page of \"Layer Field\" with following :</br>"
				+ "1. Text-box :\"SEARCH\".</br>"
				+ "2. Table with the fields like : \r\n"
				+ "\"Actions\" dropdown\r\n"
				+ "\"LayerFieldDisplayName\", \r\n"
				+ "\"TableName\",\r\n"
				+ "\"CoelaceValue\",\r\n"
				+ "\"DataType\",\r\n"
				+ "\"AllowEdit\",\r\n"
				+ "\"CreationTime\".</br>"
				+ "3. Buttons: \"<-Back\" , \"Next\" , \"Previous\" ,Page control."));
	}
	
	@Test(priority=3,description="To verify that user is able to get back to the \"Layer\" page from \"LayerField\" page by clicking on the \"<- Back\" button.")
	public void PV_LayerManagement_43() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_back_layerfield)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"<-Back\" button of \"Layer Field\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_pageheader)).getText(), "Layers");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to the \"Layer\" page from \"Layer Field\" page."));
	}
	
	@Test(priority=4,description="To verify that user is able to \"Edit\"  layer field from \"Layer Field\" page.")
	public void PV_LayerManagement_44() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).sendKeys("NA");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit \"Coalesce Value\" in \"Coalesce Value\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_infotooldispindex)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit selection of \"Info-Tool Visibility\"check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_reportdispindext)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit selection of \"Report Visibility \" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit value of \"Info-Tool Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit value of \"Report Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).sendKeys("Crime id edit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Edit \"Display Name\" in \"Display Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Save\" button \"Edit Layer Field\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(), "Crime id edit");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1.User should able to click on \"Save\" button \"Edit Layer Field\" window and \"Edit Layer Field\" window should close.</br>"
				+ "2. Edited details should update on portal."));
	}
	
	@Test(priority=5,description="To verify that user is able to close(\"X\")  \"Edit Layer Field\" window.")
	public void PV_LayerManagement_45() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on close(\"X\") button of \"Update Layer Field\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Layer Field\" window."));
	}
	
	@Test(priority=6,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Layer Field\" window.")
	public void PV_LayerManagement_46() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Cancel\" button of \"Update Layer Field\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Layer Field\" window and \"Edit Layer Field\" window should close."));
	}
	
	@Test(priority=7,description="To verify that user gets validation message when perform \"Cancel\" functionality after edit any field of \"Edit Layer Field\" window. ")
	public void PV_LayerManagement_47() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).sendKeys("NA");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit \"Coalesce Value\" in \"Coalesce Value\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_infotooldispindex)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit selection of \"Info-Tool Visibility\"check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_reportdispindext)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit selection of \"Report Visibility \" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit value of \"Info-Tool Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit value of \"Report Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).sendKeys("Crime id edit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Edit \"Display Name\" in \"Display Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\" button of \"Edit Layer Field\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Layer\" window should also close."));
	}
	
	@Test(priority=8,description="To verify that user is able to \"Cancel\" validation message for unsaved changes of \"Edit Layer Field\" window.")
	public void PV_LayerManagement_48() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Actions\"-> \"Edit\" option from dropdown of particular layer field in \"Layer Field\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_coalesceval)).sendKeys("NA");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit \"Coalesce Value\" in \"Coalesce Value\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_infotooldispindex)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit selection of \"Info-Tool Visibility\"check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_reportdispindext)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit selection of \"Report Visibility \" check-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_infotooldispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit value of \"Info-Tool Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_reportdispindex)).sendKeys("1");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit value of \"Report Display Index\" from dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_dispname)).sendKeys("Crime id edit");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> :  Edit \"Display Name\" in \"Display Name\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Click on \"Cancel\" button of \"Edit Layer Field\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).isDisplayed(),true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Layer\" window should display on screen."));
	}
	
	@Test(priority=9,description="To verify that user is able to \"Cancel\" the validation message of delete Layer Field.")
	public void PV_LayerManagement_50() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Actions\"-> \"Discard\" option from dropdown of particular layer field in \"Layer Field\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You want to delete this Layer Field?");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup of delete Layer Field should close."));
	}
	
	@Test(priority=10,description="To verify that user is able to \"Delete\"  layer field from \"Layer Field\" page.")
	public void PV_LayerManagement_49() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime id");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Actions\"-> \"Discard\" option from dropdown of particular layer field in \"Layer Field\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You want to delete this Layer Field?");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),"Successfully discarded!");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message should close.</br>"
				+ "2. Selected \"Layer Field\" should delete from \"Layer Field\" page."));
	}
	
	@Test(priority=11,description="To verify that user is able to perform \"SEARCH\" functionality of \"Layer Field\" page.")
	public void PV_LayerManagement_51() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime type");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(), "Crime type");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Layer Field\" page."));
	}
	
	@Test(priority=12,description="To verify that user is able to perform sorting functionality for \"Layer Field Display Name\" , \"Table Name\" , \"Coalesce Value\" , \"Data Type\" , \"Allow Edit\" , \"Creation Time\" columns of \"Layer Field\" page. ")
	public void PV_LayerManagement_54(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
		
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Sorting\" icon of the \"Layer Field Display Name\" column.");
		String a1=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).click();
		Thread.sleep(1000);
		String a2=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layfielddispname)).getAttribute("aria-sort");
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get records in alphabetical order of \"Layer Field Display Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Click on \"Sorting\" icon of the \"Data Type\" column.");
		String a7=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).getAttribute("aria-label");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).click();
		Thread.sleep(1000);
		String a8=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_datatype)).getAttribute("aria-label");
		Assert.assertNotEquals(a7, a8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get records in sorting order of \"Data Type\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Click on \"Sorting\" icon of the \"Allow Edit\" column.");
		String b1=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).click();
		Thread.sleep(1000);
		String b2=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_allowedit)).getAttribute("aria-sort");
		Assert.assertNotEquals(b1, b2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get records in sorting order of \"Allow Edit\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Click on \"Sorting\" icon of the \"Creation Time\" column.");
		String b3=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).click();
		Thread.sleep(1000);
		String b4=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_creatime)).getAttribute("aria-sort");
		Assert.assertNotEquals(b3, b4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_04</b> : User should get records in sorting order of \"Creation Time\" data fields."));
	}
	
	@Test(priority=13,description="To verify that user is able to edit layer information by clicking on \"Edit\" option from the \"Actions\" dropdown.")
	public void PV_LayerManagement_55() throws InterruptedException
	{
		
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Crime mapping Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("0.5");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4375");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6891");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9703");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1854");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
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
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
				+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_save)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Save\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size()!=0, false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(), "Crime mapping Test");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able click on \"Save\" button and \"Edit Layer\" window should close.</br>"
				+ "2. User should get updated information in \"Layer\" page."));
	}
	
	@Test(priority=14,description="To verify that user is able to close(\"X\") \"Edit Layer\" window.")
	public void PV_LayerManagement_56() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on close(\"X\") button of \"Edit Layer\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to close \"Edit Layer\" window."));
	}
	
	@Test(priority=15,description="To verify that user is able to perform \"Cancel\" functionality of \"Edit Layer\" window.")
	public void PV_LayerManagement_57() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_close)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Cancel\" button of \"Edit Layer\" page.");
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of \"Edit Layer Field\" window and \"Edit Layer\" window should close."));
	}
	
	@Test(priority=16,description="To verify that user gets validation message when perform \"Cancel\" functionality after edit any field of \"Edit Layer\" window. ")
	public void PV_LayerManagement_58() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Crime mapping Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("0.5");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4375");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6891");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9703");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1854");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
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
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
				+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Cancel\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		Assert.assertEquals(driver.findElements(By.xpath(LayerManagement_repository.title_window)).size()!=0, false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Layer\" window should also close."));
	}
	
	@Test(priority=17,description="To verify that user is able to \"Cancel\" validation message for unsaved changes for \"Edit Layer\" window.")
	public void PV_LayerManagement_59() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_title_lay_win)).sendKeys("Crime mapping Test");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit Title Name from \"Title\" text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("0.5");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-10</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).sendKeys("72.4375");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-11</b> : Edit value of \"Bound X1\" from \"Bound X1\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX2_lay_win)).sendKeys("72.6891");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-12</b> : Edit value of \"Bound X2\" from \"Bound X2\" textbox.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY1_lay_win)).sendKeys("22.9703");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-13</b> : Edit value of \"Bound Y1\" from \"Bound Y1\" textbox.s");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundY2_lay_win)).sendKeys("23.1854");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-14</b> : Edit value of \"Bound Y2\" from \"Bound Y2\" textbox.");
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
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.chbox_isqueryable_lay_win)).getAttribute("disabled"), "true");
		driver.findElement(By.xpath(LayerManagement_repository.chbox_isbaselay_lay_win)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-15</b> : Edit selection  of \"Is Active ? \" , \"Is Visible ?\" , \"Is Queryable? \" , \"Is Base Layer?\" checkboxes.\r\n"
				+ "(When \"Is Base Layer? Option is enable then \"Is Queryable?\" is disable vice versa.)");
		driver.findElement(By.xpath(LayerManagement_repository.btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Cancel\" button of \"Edit Layer\" window.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You have unsaved changes.");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-16</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_window)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Cancel\" button of validation message popup and validation message popup should close.</br>"
				+ "2. \"Edit Layer\" window should display on screen."));
	}
	
	@Test(priority=18,description="To verify that user gets validation message when edited opacity value is greater than 1 and less than 0.")
	public void PV_LayerManagement_60() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_edit)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Edit\" option from dropdown of particular layer in \"Layer\" page.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).clear();
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_opacity_lay_win)).sendKeys("2");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Edit/Select required opacity from respective text-box.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_boundX1_lay_win)).click();
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.val_opacity)).getText(), "The field Opacity must be between 0 and 1.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"The field Opacity must be between 0 and 1.\"."));
	}
	
	@Test(priority=19,description="To verify that user is able to perform \"SEARCH\" functionality of \"Layer\" page.")
	public void PV_LayerManagement_63() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Enter search criteria into \"SEARCH\" text-box.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.verify_first)).getText(), "Crime mapping Test");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.text_showing_entries)).getText(), "Showing 1 to 1 of 1 entries");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get the searched result in \"Layer\" page."));
	}
	
	@Test(priority=20,description="To verify that user is able to \"Cancel\" the validation message of delete the Layer.")
	public void PV_LayerManagement_62() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Delete\" option from dropdown of particular layer in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You want to delete this Layer ?");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Cancel\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message popup of delete Layer should close."));
	}
	
	@Test(priority=21,description="To verify that user is able to delete Layer from \"Layer\" page by clicking on \"Delete\" option from the \"Actions\" dropdown.")
	public void PV_LayerManagement_61() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_discard)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Delete\" option from dropdown of particular layer in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"You want to delete this Layer ?");
        Thread.sleep(1000);	
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);	
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> : Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).isDisplayed(),false);
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),"Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message popup should close.</br>"
				+ "2. User should get toast validation like \"Successfully discarded!\".</br>"
				+ "3. Deleted \"Layer\" should delete from \"Layer\" page."));
	}
	
	@Test(priority=22,description="To verify that user is able to perform sorting functionality for \"Layer Title\" , \"Layer Name\" , \"Table Name\" columns of \"Layer\" page. ")
	public void PV_LayerManagement_66(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Click on \"Sorting\" icon of the \"Layer Title\" column.");
		String a1=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).click();
		Thread.sleep(1000);
		String a2=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_laytitle)).getAttribute("aria-sort");
		Assert.assertNotEquals(a1, a2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_01</b> : User should get records in alphabetical sorting order of \"Layer Title\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Click on \"Sorting\" icon of the \"Layer Name\" column.");
		String a7=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).getAttribute("aria-label");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).click();
		Thread.sleep(1000);
		String a8=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_layname)).getAttribute("aria-label");
		Assert.assertNotEquals(a7, a8);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_02</b> : User should get records in alphabetical sorting order of \"Layer Name\" data fields."));
		ll.Screenshotnew(driver,i,method.getName()+"_02");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Click on \"Sorting\" icon of the \"Table Name\" column.");
		String b1=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).getAttribute("aria-sort");
		driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).click();
		Thread.sleep(1000);
		String b2=driver.findElement(By.xpath(LayerManagement_repository.col_lbl_tablename)).getAttribute("aria-sort");
		Assert.assertNotEquals(b1, b2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_03</b> : User should get records in alphabetical sorting order of \"Table Name\" data fields."));
	}
	
	@Test(priority=23,description="To verify that user is able to get back to \"Home\" page from \"Layer\" page by clicking on\"Home\" icon.")
	public void PV_LayerManagement_67() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_pageheader)).getText(), "Layers");
		driver.findElement(By.xpath(LayerManagement_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Click on\"Home\" icon in \"Layer\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.title_header)).getText(), "Home");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to \"Home\" page from \"Layer\" page."));
	}
	
	@Test(priority=24,description="To verify that user is able to \"Cancel\" the validation message of Delete OGC service.")
	public void PV_LayerManagement_41() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_delete_ogcservice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"X\"(Delete) button from Landing page of \"Layer\".");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the OGCService?");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> :  Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message should close."));
	}
	
	
	
	@Test(priority=25,description="To verify that user is able to \"Delete\" OGC service by clicking on  \"X\"  button from \"Layers\" page.")
	public void PV_LayerManagement_40(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.btn_delete_ogcservice)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"X\"(Delete) button from Landing page of \"Layer\".");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the OGCService?");
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> :  Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(LayerManagement_repository.toast_msg)).getText(),"Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message should close.</br>"
				+ "2. User should get toast validation like \"Successfully discarded!\".</br>"
				+ "3. Selected \"OGC Service\" should delete from \"Layer\" page."));
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
