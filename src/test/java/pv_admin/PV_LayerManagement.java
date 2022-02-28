package pv_admin;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
	
	@Test(description="To verify that user is able to perform pagination functionality in  Scan Layer page of selected \"OGC Service\".")
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
	
	@Test(description="To verify that user is able to select particular layer  from \"--Select Layer--\" dropdown list in scan layer page of selected \"OGC Service\".")
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
	
	@Test
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
	
	@Test
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
	
	@Test
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
	}
	
	@Test
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
	
	@Test
	public void PV_LayerManagement_46() throws InterruptedException
	{
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
		driver.findElement(By.xpath(LayerManagement_repository.opt_LayerManagement)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.menuitem_layers)).click();
		Thread.sleep(1000);
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on  \"Layer Management\"-->\"Layer\" menu.");
		driver.findElement(By.xpath(LayerManagement_repository.dd_sel_ogcservice)).sendKeys("Test_OGC");
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-7</b> : Select \"OGC Service\" from \"OGC Service\" dropdown.");
		driver.findElement(By.xpath(LayerManagement_repository.txtbox_search)).sendKeys("Crime mapping");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LayerManagement_repository.btn_actions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(LayerManagement_repository.lnk_layerfield)).click();
		Thread.sleep(1000);
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-8</b> : Click on \"Actions\"-->\"Layer Field\" option from dropdown of particular layer in \"Layer\" page.");
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
	
	@Test
	public void PV_LayerManagement_47()
	{
		
	}
	
	@Test(description="To verify that user is able to \"Cancel\" the validation message of Delete OGC service.")
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
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the OGCService?");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_cancel)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> :  Click on \"Cancel\" button of validation message popup.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to click on \"Cancel\" button of validation message popup and validation message should close."));
	}
	
	
	
	@Test(description="To verify that user is able to \"Delete\" OGC service by clicking on  \"X\"  button from \"Layers\" page.")
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
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_1stline)).getText(),"Are you sure?");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.validation_2ndline)).getText(),"Are you sure to delete the OGCService?");
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(LayerManagement_repository.validation_btn_yes)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-9</b> :  Click on \"Yes\" button of validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(UserManagement_repository.toast_msg)).getText(),"Successfully discarded!");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User should able to click on \"Yes'\" button of validation message popup and validation message should close.</br>"
				+ "2. User should get toast validation like \"Successfully discarded!\".</br>"
				+ "3. Selected \"OGC Service\" should delete from \"Layer\" page."));
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
