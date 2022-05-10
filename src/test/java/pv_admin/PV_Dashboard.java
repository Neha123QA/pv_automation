package pv_admin;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
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

public class PV_Dashboard {

		WebDriver driver;
		Screenshot_extra ll=new Screenshot_extra();
		String i="PV_UserManagement_extra_ss";
		
		@BeforeClass
		public void setDriver(ITestContext context) throws InterruptedException
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
			DesiredCapabilities caps = new DesiredCapabilities();
	        
	        //For Firefox
	        FirefoxOptions options = new FirefoxOptions();
	        options.addArguments("-private");
	        caps.setCapability("moz:firefoxOptions",options);
			driver=new FirefoxDriver();
			
			
		}
		
		
		@BeforeMethod
		@Test
		public void Openurl(ITestContext context) throws InterruptedException 
		{
			 
		        
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
		
		@Test(priority=0,description="To verify that user is able to get Landing page of \"Dashboard\".")
		public void PV_Dashboard_01(Method method) throws InterruptedException 
		{
			ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
			ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
			ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
			ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
			ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
			driver.findElement(By.xpath(Dashboard_repository.menu_dashboard)).click();
			Thread.sleep(5000);
			ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Dashboard\" menu from left pane.");
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.title_header)).getText(), "Dashboard");
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.sec_map)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_totalcrimes)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_highseveritycrimes)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_moderateseveritycrimes)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_lowseveritycrimes)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.chart1_crimesinAhmCity)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.chart2_statusofcrimes)).isDisplayed(), true);
			WebElement e1=driver.findElement(By.xpath(Dashboard_repository.chart_top5highestcrimesward));
			Coordinates co1=((Locatable)e1).getCoordinates();
			co1.onPage();
			co1.inViewPort();
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.countsec_totalbeatbandobast)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.chart_top5crimes)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.chart_top5highestcrimesjurisdiction)).isDisplayed(), true);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.chart_top5highestcrimesward)).isDisplayed(), true);
			ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get Landing page of \"Dashboard\" with following :</br>"
					+ "1. Button : \"Go\".</br>"
					+ "2. Date selection text-boxes : \"Start Date\", Date\".</br>"
					+ "3. Crime records on map by default one month.</br>"
					+ "4. Links : \"Total Crimes\" , \"High Severity  Crimes\" , \"Moderate Severity Crimes\" , \"Low Severity Crimes\", \"Total Bandobast Events\".</br>"
					+ "5. Pie Charts(with legends) : \"Crimes in Ahmedabad City\", \"Status of crimes\", \"Beat & Bandobast\" , \"Top 5 Jurisdiction with highest crime\".</br>"
					+ "6. Bar Charts: \"Top 5Crimes by Crime Type\" ,\"Top 5 wards with highest crime\"."));
		}
		
		@Test(priority=1,description="To verify that user is able to get Crimes records as per selection of Date in \"Dashboard\" page.")
		public void PV_Dashboard_02() throws InterruptedException
		{
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
			driver.findElement(By.xpath(Dashboard_repository.menu_dashboard)).click();
			Thread.sleep(5000);
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Dashboard\" menu from left pane.");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).sendKeys("02-07-2022");
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).sendKeys("02-22-2022");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.btn_GO)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_totalcrimes)).getText(), "19");
		}
		
		@Test(priority=2,description="To verify that user is able to get total crimes records on map By clicking on \"Total Crimes\" link from \"Dashboard\" page.")
		public void PV_Dashboard_03() throws InterruptedException
		{
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
			driver.findElement(By.xpath(Dashboard_repository.menu_dashboard)).click();
			Thread.sleep(5000);
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Dashboard\" menu from left pane.");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).sendKeys("02-07-2022");
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).sendKeys("02-22-2022");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.btn_GO)).click();
			Thread.sleep(5000);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_totalcrimes)).getText(), "19");
			driver.findElement(By.xpath(Dashboard_repository.lnk_totalcrimes)).click();
		}
		
		@Test(priority=3,description="To verify that user is able to get High severity crime records on map By clicking on \"High Severity Crimes\" link from \"Dashboard\" page.")
		public void PV_Dashboard_04() throws InterruptedException
		{
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
			driver.findElement(By.xpath(Dashboard_repository.menu_dashboard)).click();
			Thread.sleep(5000);
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Dashboard\" menu from left pane.");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).sendKeys("02-07-2022");
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).sendKeys("02-22-2022");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.btn_GO)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(Dashboard_repository.lnk_highseveritycrimes)).click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_highseveritycrimes)).getText(), "10");
			
		}
		
		@Test(priority=4,description="To verify that user is able to get Moderate severity crime records on map By clicking on \"Moderate Severity Crimes\" link from \"Dashboard\" page.")
		public void PV_Dashboard_05() throws InterruptedException
		{
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
			driver.findElement(By.xpath(Dashboard_repository.menu_dashboard)).click();
			Thread.sleep(5000);
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Dashboard\" menu from left pane.");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).sendKeys("02-07-2022");
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).sendKeys("02-22-2022");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.btn_GO)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(Dashboard_repository.lnk_moderateseveritycrimes)).click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_moderateseveritycrimes)).getText(), "9");
			
		}
		
		@Test(priority=5,description="To verify that user is able to get Low severity crime records on map By clicking on \"Low Severity Crimes\" link from \"Dashboard\" page.")
		public void PV_Dashboard_06() throws InterruptedException
		{
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"Login\" link or button from \"Home\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Enter valid credential of \"Admin\" role in \"Login\" page.");
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Login\" button.");
			driver.findElement(By.xpath(Dashboard_repository.menu_dashboard)).click();
			Thread.sleep(5000);
			//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Dashboard\" menu from left pane.");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_startdate)).sendKeys("02-07-2022");
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).clear();
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).sendKeys("02-22-2022");
			driver.findElement(By.xpath(Dashboard_repository.txtbox_enddate)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Dashboard_repository.btn_GO)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(Dashboard_repository.lnk_lowseveritycrimes)).click();
			Thread.sleep(2000);
			Assert.assertEquals(driver.findElement(By.xpath(Dashboard_repository.lnk_lowseveritycrimes)).getText(), "0");
			
		}
		
		
		
		@AfterMethod
		public void Aftermethod() throws InterruptedException
		{ 
			//driver.close();
			Thread.sleep(1000);
		}
}

