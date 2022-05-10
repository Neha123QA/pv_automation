package pv_admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PV_LandingPage_UI {
WebDriver driver;
	
	
	
	@BeforeClass
	 
	public void setDriver(ITestContext context) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		
		  driver=new FirefoxDriver();
		  context.setAttribute("WebDriver", driver);
		  Thread.sleep(2000);
		  driver.manage().window().maximize();
	}
	
	@BeforeMethod
	
	public void Openurl() throws InterruptedException 
	{
		driver.get(Login_repository.url);
		  Thread.sleep(2000);
		  driver.manage().window().maximize();
		  Thread.sleep(5000);
	}
	
	@Test
	public void Test_01() throws InterruptedException
	{
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.logo)).isDisplayed());
		Assert.assertEquals("Skip to main content", driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getText());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lnk_red_color)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lnk_white_color)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lnk_yellow_color)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lnk_green_color)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lnk_decrease_fontsize)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lnk_default_fontsize)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lnk_increase_fontsize)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.lang_dd)).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.btn_Login)).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals("Home", driver.findElement(By.xpath(Landingpage_repository.lnk_Home)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Services", driver.findElement(By.xpath(Landingpage_repository.lnk_Services)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Contact Us", driver.findElement(By.xpath(Landingpage_repository.lnk_Contactus)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Capture Crime", driver.findElement(By.xpath(Landingpage_repository.lnk_CaptureCrime)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Go to Map", driver.findElement(By.xpath(Landingpage_repository.btn_GotoMap)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Live Chat", driver.findElement(By.xpath(Landingpage_repository.btn_LiveChat)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("SIGN UP", driver.findElement(By.xpath(Landingpage_repository.btn_Signup)).getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.text_Skiptomaincontent)).click();
		Thread.sleep(1000);
		Assert.assertEquals("Crime Mapping", driver.findElement(By.xpath(Landingpage_repository.txt_title_CrimeMapping)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Police Patrolling", driver.findElement(By.xpath(Landingpage_repository.txt_policepatrolling)).getText());
		Thread.sleep(1000);
		JavascriptExecutor j = (JavascriptExecutor) driver;
	    Long x = (Long) j.executeScript("return window.pageYOffset;");
	    System.out.println("Scroll position before launch: " + x);
		((JavascriptExecutor) driver).executeScript("scroll(0,2000)");
		Thread.sleep(1000);
		
		Assert.assertEquals("Police Bandobast", driver.findElement(By.xpath(Landingpage_repository.txt_policebandobast)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Surveillance Systems", driver.findElement(By.xpath(Landingpage_repository.txt_surveillancesystems)).getText());
		Thread.sleep(1000);
	    Long y = (Long) j.executeScript("return window.pageYOffset;");
		((JavascriptExecutor) driver).executeScript("scroll(0,3000)");
		Thread.sleep(1000);
		Assert.assertEquals("Crime Analysis", driver.findElement(By.xpath(Landingpage_repository.txt_crimeanalysis)).getText());
		Thread.sleep(1000);
		Assert.assertEquals("Citizen SOS Services", driver.findElement(By.xpath(Landingpage_repository.txt_citizensos)).getText());
		Thread.sleep(1000);
		Long z = (Long) j.executeScript("return window.pageYOffset;");
		((JavascriptExecutor) driver).executeScript("scroll(0,4000)");
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.reportcrime_sec)).isDisplayed());
		Thread.sleep(2000);
		Long w = (Long) j.executeScript("return window.pageYOffset;");
		((JavascriptExecutor) driver).executeScript("scroll(0,4500)");
		Thread.sleep(1000);
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.newsevent_section)).isDisplayed());
		Thread.sleep(2000);
		Long v = (Long) j.executeScript("return window.pageYOffset;");
		((JavascriptExecutor) driver).executeScript("scroll(0,6500)");
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.txt_gallery)).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.newsletter_section)).isDisplayed());
		Thread.sleep(2000);
		Long u = (Long) j.executeScript("return window.pageYOffset;");
		((JavascriptExecutor) driver).executeScript("scroll(0,7000)");
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.footer_sec)).isDisplayed());
		Thread.sleep(1000);
		
	}
	

	
@AfterMethod
	
	public void schreenshot(ITestResult result) throws IOException {
			
			if(ITestResult.FAILURE==result.getStatus()){
				try{
					Date currentdate=new Date();
					File ScreenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					// Copy files to specific location 
					// result.getName() will return name of test case so that screenshot name will be same as test case name
					FileUtils.copyFile(ScreenshotFile, new File(".//Screenshot//Fail-"+result.getName()+".png"));
					System.out.println("Successfully captured a screenshot");
				}catch (Exception e){
					System.out.println("Exception while taking screenshot "+e.getMessage());
				} 
		}
			else if(ITestResult.SUCCESS==result.getStatus())
			{
				try
				{
				Date currentdate=new Date();
				File ScrrenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(ScrrenshotFile, new File(".//Screenshot\\Pass-" + result.getName() + ".png"));
				}
				catch (Exception e){
					System.out.println("Exception while taking screenshot "+e.getMessage());
				}
			}
		}
		
		
		@AfterClass
		public void Afterclass() throws InterruptedException
		{
			driver.quit();
			Thread.sleep(1000);
		}

}
