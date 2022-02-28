package pv_admin;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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

import com.aventstack.extentreports.Status;

import Listener.ExtentTestManager;
import Listener.Screenshot_extra;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.AWTException;	
import java.awt.Robot;
import java.awt.event.InputEvent;	
import java.awt.event.KeyEvent;

public class PV_LandingPage {
	WebDriver driver;
	Screenshot_extra ll=new Screenshot_extra();
	String i="PV_UserManagement_extra_ss";


	@BeforeClass
	public void setDriver() throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();
			
	}

	@BeforeMethod
	public void Openurl(ITestContext context) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		context.setAttribute("WebDriver", driver);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Landingpage_repository.url_landingpage);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}


	@Test(priority=1,description="To verify  that user is able to redirect to the Home Page of Police Vertical web portal by clicking on \"logo\" of \"Police Vertical\" web portal.")
	public void PV_HomePage_02() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Scroll the Home Page to bottom of the Home Page.");
		driver.findElement(By.xpath(Landingpage_repository.logo)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on logo of \" Police Vertical\" from \"Home\" page.");
		String url=driver.getCurrentUrl();
		Assert.assertEquals(url, "https://qapoc.sgligis.com:10013/");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> :  User should able to redirect to the \"Home\" Page by clicking on logo of \" Police Vertical\" web portal."));

	}



	@Test(priority=2,description="To verify that user is able to perform \"Home\" functionality from Home Page of Police Vertical web portal.")
	public void PV_HomePage_04() throws InterruptedException 
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		Long x = (Long) j.executeScript("return window.pageYOffset;");
		//System.out.println("Scroll position before launch: " + x);
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Scroll the Home Page to bottom of the Home Page.");
		driver.findElement(By.xpath(Landingpage_repository.lnk_Home)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Click on \"Home\" link from header section of \"Home\" page.");
		Long y = (Long) j.executeScript("return window.pageYOffset;");
		//System.out.println("Scroll position before launch: " + y);
		Assert.assertEquals(x, y);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should able to get back to default view of home page by clicking on \"Home\" link."));
	}

	@Test(priority=3,description="To verify that user is able to perform  \"Skip to main content\" functionality from \"Home\" page of Police Vertical web portal.")
	public void PV_HomePage_05() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		String t1=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getText();
		Assert.assertEquals(t1, "Skip To Main Content");
		String t2=driver.findElement(By.xpath(Landingpage_repository.header)).getAttribute("class");
		System.out.println(t2);
		JavascriptExecutor j = (JavascriptExecutor) driver;
		Long x = (Long) j.executeScript("return window.pageYOffset;");
		driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).click();
		ExtentTestManager.getTest().log(Status.INFO,"</b>Step-3</b> : Click on \"Skip to main content\" link from header section of \"Home\" page.");
		Thread.sleep(1000);
		String t3=driver.findElement(By.xpath(Landingpage_repository.header)).getAttribute("class");
		System.out.println(t3);
		Assert.assertNotEquals(t2, t3);
		Long y = (Long) j.executeScript("return window.pageYOffset;");
		Assert.assertNotEquals(x, y);
		ExtentTestManager.getTest().log(Status.INFO,"Get main content in Police Vertical web portal.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should redirect to main content of the Home page."));
	}

	@Test(priority=4,description="To verify that user is able to change text-colour of \"Home\" page of Police vertical web portal by clicking on colour(Red, White, Green, Blue) button.")
	public void PV_HomePage_06(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		String c1=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("color");
		Thread.sleep(1000);
		System.out.println(c1);

		driver.findElement(By.xpath(Landingpage_repository.lnk_red_color)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on Red colour button  from header section of \"Home\" page.");
		String c2=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("color");
		Thread.sleep(1000);
		WebElement e1 = driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent));
		e1.click();

		WebElement e2 = driver.findElement(By.xpath(Landingpage_repository.txt_policebandobast));
		Coordinates co2 = ((Locatable)e2).getCoordinates();
		co2.onPage(); co2.inViewPort();
		Thread.sleep(1000);
		WebElement e3 = driver.findElement(By.xpath(Landingpage_repository.txt_crimeanalysis));
		Coordinates co3 = ((Locatable)e3).getCoordinates();
		co3.onPage(); co3.inViewPort();
		Thread.sleep(1000);
		WebElement e4 = driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection));
		Coordinates co4 = ((Locatable)e4).getCoordinates();
		co4.onPage(); co4.inViewPort();
		Thread.sleep(1000);
		WebElement e5 = driver.findElement(By.xpath(Landingpage_repository.newsletter_section));
		Coordinates co5 = ((Locatable)e5).getCoordinates();
		co5.onPage(); co5.inViewPort();
		Thread.sleep(1000);
		WebElement e6 = driver.findElement(By.xpath(Landingpage_repository.footer_allrights));
		Coordinates co6 = ((Locatable)e6).getCoordinates();
		co6.onPage(); co6.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.lnk_Home)).click();
		System.out.println(c2);
		Assert.assertNotEquals(c1, c2);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_1</b> : User should get Home page text in Red colour except images."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		/*
		driver.findElement(By.xpath(Landingpage_repository.lnk_yellow_color)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on Yellow colour button  from header section of \"Home\" page.");
		String c3=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("color");
		Thread.sleep(1000);

		WebElement el1 = driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent));
		el1.click();

		WebElement b1 = driver.findElement(By.xpath(Landingpage_repository.txt_policebandobast));
		Coordinates a2 = ((Locatable)b1).getCoordinates();
		a2.onPage(); a2.inViewPort();
		Thread.sleep(1000);  
		WebElement b2 = driver.findElement(By.xpath(Landingpage_repository.txt_crimeanalysis));
		Coordinates a3 = ((Locatable)b2).getCoordinates();
		a3.onPage(); a3.inViewPort();
		Thread.sleep(1000);
		WebElement b3 = driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection));
		Coordinates a4 = ((Locatable)b3).getCoordinates();
		a4.onPage(); a4.inViewPort();
		Thread.sleep(1000);
		WebElement b4 = driver.findElement(By.xpath(Landingpage_repository.newsletter_section));
		Coordinates a5 = ((Locatable)b4).getCoordinates();
		a5.onPage(); a5.inViewPort();
		Thread.sleep(1000);
		WebElement b5 = driver.findElement(By.xpath(Landingpage_repository.footer_allrights));
		Coordinates a6 = ((Locatable)b5).getCoordinates();
		a6.onPage(); a6.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.lnk_Home)).click();
		Thread.sleep(1000);
		Assert.assertNotEquals(c1, c3);
				ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_2</b> : User should get Home page text in Yellow colour except images."));
				ll.Screenshotnew(driver,i,method.getName()+"_02");
		*/
		driver.findElement(By.xpath(Landingpage_repository.lnk_green_color)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on Green colour button  from header section of \"Home\" page.");
		String c4=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("color");
		Thread.sleep(1000);

		WebElement d1 = driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent));
		d1.click();

		WebElement d2 = driver.findElement(By.xpath(Landingpage_repository.txt_policebandobast));
		Coordinates f2 = ((Locatable)d2).getCoordinates();
		f2.onPage(); f2.inViewPort();
		Thread.sleep(1000); 
		WebElement d3 = driver.findElement(By.xpath(Landingpage_repository.txt_crimeanalysis));
		Coordinates f3 = ((Locatable)d3).getCoordinates();
		f3.onPage(); f3.inViewPort();
		Thread.sleep(1000);
		WebElement d4 = driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection));
		Coordinates f4 = ((Locatable)d4).getCoordinates();
		f4.onPage(); f4.inViewPort();
		Thread.sleep(1000);
		WebElement d5 = driver.findElement(By.xpath(Landingpage_repository.newsletter_section));
		Coordinates f5 = ((Locatable)d5).getCoordinates();
		f5.onPage(); f5.inViewPort();
		Thread.sleep(1000);
		WebElement d6 = driver.findElement(By.xpath(Landingpage_repository.footer_allrights));
		Coordinates f6 = ((Locatable)d6).getCoordinates();
		f6.onPage(); f6.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.lnk_Home)).click();
		Thread.sleep(1000);
		Assert.assertNotEquals(c1, c4);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result_3</b> : User should get Home page text in Green colour except images."));
		ll.Screenshotnew(driver,i,method.getName()+"_03");
		driver.findElement(By.xpath(Landingpage_repository.lnk_white_color)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on default(White) colour link.");
		String c5=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("color");
		Thread.sleep(1000);
		Assert.assertNotEquals(c5, c4);
	}

	@Test(priority=5,description="To verify that user is able to decrease/increase font size  by clicking on \"A-\"/\"A+\" button.")
	public void PV_HomePage_07(Method method) 
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		String f1=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("font-size");
		System.out.println(f1);
		driver.findElement(By.xpath(Landingpage_repository.lnk_decrease_fontsize)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on \"A-\" button  from header section of \"Home\" page.");
		String f2=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("font-size");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result_1</b> : User should get Home page text with decreased font size.");
		Assert.assertNotEquals(f1, f2);
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Landingpage_repository.lnk_increase_fontsize)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"A+\" button  from header section of \"Home\" page.");
		String f3=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("font-size");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result_2</b> : User should get Home page text with increased font size.");
		Assert.assertNotEquals(f1, f3);
		
	}
	
	@Test(priority=6,description="To verify that user is able to reset font size by clicking on \"A\" button.")
	public void PV_HomePage_08()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		String f1=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("font-size");
		driver.findElement(By.xpath(Landingpage_repository.lnk_increase_fontsize)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on \"A+\" button  from header section of \"Home\" page.");
		String f3=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("font-size");
		Assert.assertNotEquals(f1, f3);
		driver.findElement(By.xpath(Landingpage_repository.lnk_default_fontsize)).click();
		String f4=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getCssValue("class style");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"A\" button  from header section of \"Home\" page.");
		System.out.println(f4);
		Assert.assertNotEquals(f1, f4);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should get Home page text with default font size.");
	}

	@Test(priority=7,description="To verify that user is able to change language from \"English\" to \"Hindi\"/\"Hindi\" to \"English\". ")
	public void PV_HomePage_09(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		String t1=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getText();
		Assert.assertEquals(t1, "Skip to main content");
		driver.findElement(By.xpath(Landingpage_repository.lang_dd)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on  \"English\" button from HomePage.");
		driver.findElement(By.xpath(Landingpage_repository.lang_op)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Hindi\" option.");
		Thread.sleep(1000);
		String ln1=driver.findElement(By.xpath(Landingpage_repository.lan_lnk)).getText();
		Assert.assertEquals(ln1, "Hindi");
		String t2=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(t2, "मुख्य विषयवस्तु में जाएं");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result_1</b> : User should get Home page content except images in \"Hindi\" language.");
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		/*
		WebElement e1 = driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent));
		e1.click();
		Thread.sleep(1000);
		WebElement e4 = driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection));
		Coordinates co4 = ((Locatable)e4).getCoordinates();
		co4.onPage(); co4.inViewPort();
		Thread.sleep(1000);
		WebElement e5 = driver.findElement(By.xpath(Landingpage_repository.newsletter_section));
		Coordinates co5 = ((Locatable)e5).getCoordinates();
		co5.onPage(); co5.inViewPort();
		Thread.sleep(1000);
		WebElement e6 = driver.findElement(By.xpath(Landingpage_repository.footer_allrights));
		Coordinates co6 = ((Locatable)e6).getCoordinates();
		co6.onPage(); co6.inViewPort();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.lnk_Home)).click();
		*/
		driver.findElement(By.xpath(Landingpage_repository.lang_dd)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on  \"Hindi\" button from HomePage.");
		driver.findElement(By.xpath(Landingpage_repository.lang_op)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"English\" option.");
		Thread.sleep(1000);
		String ln2=driver.findElement(By.xpath(Landingpage_repository.lan_lnk)).getText();
		Assert.assertEquals(ln2, "English");
		String t3=driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).getText();
		Thread.sleep(1000);
		Assert.assertEquals(t3, "Skip to main content");
		ExtentTestManager.getTest().log(Status.INFO,"English(Localization) verified.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result_2</b> : User should get Home page content except images in \"English\" language.");
	}
	
	@Test(priority=8,description="To verify that user is able to navigate \"Citizen's Charter\" page by clicking on \"Citizen's Charter\" link from header section of \"Home\" page. ")
	public void PV_HomePage_10() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Landingpage_repository.lnk_citizencharter)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on \"Citizen's Charter\" link from header section of \"Home\" page.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Citizen Charter");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Citizen Charter");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should navigate to \"Citizen's Charter\" page.");
	}

	@Test(priority=9,description="To verify that user is able to get \"Contact Us\" page by clicking on \"Contact Us\" link  from header section of \"Home\" page.")
	public void PV_HomePage_11() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Landingpage_repository.lnk_Contactus)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on \"Contact Us\" link from header section of \"Home\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_2)).getText(), "Contact us");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should navigate to \"Contacht Us\" page.");
	}
	
	@Test(priority=10,description="To verify that user is able to get \"Feedback\" form page by clicking on \"Feedback\" link  from header section of \"Home\" page.")
	public void PV_HomePage_12() throws InterruptedException
	{
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Landingpage_repository.lnk_feedback)).click();
		Thread.sleep(1000);
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on \"Contact Us\" link from header section of \"Home\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_2)).getText(), "Feedback");
		//ExtentTestManager.getTest().log(Status.INFO,"<b>Result</b> : User should navigate to \"Contacht Us\" page.");

	}

	@Test(priority=11,description="To verify that user is able to perform \"Login\" functionality from \"Home\" page of Police Vertical web portal.")
	public void PV_HomePage_15() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Landingpage_repository.btn_Login)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.txtbox_Username)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.txtbox_Password)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.btn_Login)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.lnk_ForgotPassword)).isDisplayed(), true);
	}

	@Test(description="To verify that user is able to get \"Origin\"  page by clicking on \"Origin\" link from \"About Us\" dropdown from \"Home\" page.")
	public void PV_HomePage_20() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_origin));
		act.moveToElement(e2);
		act.click().build().perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Origin\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Origin");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Origin");
		WebElement e3=driver.findElement(By.xpath(Landingpage_repository.footer_allrights));
		Coordinates co1=((Locatable)e3).getCoordinates();
		co1.onPage();
		co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_CCTNS)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_centralfingerprintbureau)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_statisticalbranch)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_trainingbranch)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_datacentreandtechbranch)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Origin\" page with details and following links :</br>"
				+ "\"Home\" , \"Resolution\" , \"CCTNS\" , \"Central Finger Print Bureau\" , \"Statistical Branch\" , \"Training Branch\" , \"Data Centre and Technical Branch\". "));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Origin\" page.")
	public void PV_HomePage_21() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_origin));
		act.moveToElement(e2);
		act.click().build().perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Origin\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Origin");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Origin");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Origin\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Origin\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Activities\"  page by clicking on \"Activities\" link from \"About Us\" dropdown from \"Home\" page.")
	public void PV_HomePage_22() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_activities));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Activities\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Activities");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Activities");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Activities\" page."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Activities\" page.")
	public void PV_HomePage_23() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_activities));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Activities\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Activities");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Activities");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Origin\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Activities\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Organization\"  page by clicking on \"Organization\" link from \"About Us\" dropdown from \"Home\" page.")
	public void PV_HomePage_24()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_organization));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Organization\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Organization");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Organization-Chart");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Organization\" page with Organization-Chart details."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Organization\" page.")
	public void PV_HomePage_25() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_organization));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Organization\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Organization");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Organization-Chart");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Organization\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Organization\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Director Message\"  page by clicking on \"Director Message\" link from \"About Us\" dropdown from \"Home\" page.")
	public void PV_HomePage_26()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_dictormsg));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Director Message\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Director Message");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Director's Desk");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Director Message\" page with detailed informatin."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Director Message\" page.")
	public void PV_HomePage_27() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_aboutus));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"About Us\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_dictormsg));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Director Message\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Director Message");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Director's Desk");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Director Message\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Director Message\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Crime and Criminal Tracking\"  page by clicking on \"Crime and Criminal Tracking\" link from \"Divisions\" dropdown from \"Home\" page.")
	public void PV_HomePage_28()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_CCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime & Criminal Tracking\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime and Criminal Tracking");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Crime and Criminal Tracking");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_aboutCCTNS)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_CCTNSimpleFramework)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_vision_and_objofCCTNS)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_stakeholderofproj)).isDisplayed(), true);
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_benefitsofCCTNS)).isDisplayed(), true);
		
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Crime & Criminal Tracking\" page with following :</br>"
				+ "Links : \"Home\" , \"About CCTNS\" , \"CCNTS Implementation Framework\" , \"Vision and Objectives of CCTNS\" , \"Stakeholders of Project\" , \"Benefits of CCTNS\". "));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Crime & Criminal Tracking\" page.")
	public void PV_HomePage_29() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_CCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime & Criminal Tracking\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime and Criminal Tracking");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Crime & Criminal Tracking\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Crime & Criminal Tracking\" page."));
	}
	
	@Test(description="To verify that user is able to expand/collapse detail portion of \"About CCTNS\" by clicking on \"About CCTNS\" link from \"Crime and Criminal Tracking\" page.")
	public void PV_HomePage_30(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_CCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime & Criminal Tracking\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime and Criminal Tracking");
		driver.findElement(By.xpath(Landingpage_repository.lnk_aboutCCTNS)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"About CCTNS\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_aboutCCTNS)).getAttribute("aria-expanded"), "true");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_1</b> : User should get detail portion of \"About CCTNS\" in expanded mode."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Landingpage_repository.lnk_aboutCCTNS)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"About CCTNS\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_aboutCCTNS)).getAttribute("aria-expanded"), "false");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_2</b> : User should get detail portion of \"About CCTNS\" in collapsed mode."));
	}
	
	@Test(description="To verify that user is able to expand/collapse detail portion of \"CCTNS Implementation Framework\" by clicking on \"CCTNS Implementation Framework\" link from \"Crime and Criminal Tracking\" page.")
	public void PV_HomePage_31(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_CCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime & Criminal Tracking\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime and Criminal Tracking");
		driver.findElement(By.xpath(Landingpage_repository.lnk_CCTNSimpleFramework)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"CCTNS Implementation Framework\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_CCTNSimpleFramework)).getAttribute("aria-expanded"), "true");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_1</b> : User should get detail portion of \"CCTNS Implementation Framework\" in expanded mode."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Landingpage_repository.lnk_CCTNSimpleFramework)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"CCTNS Implementation Framework\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_CCTNSimpleFramework)).getAttribute("aria-expanded"), "false");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_2</b> : User should get detail portion of \"CCTNS Implementation Framework\" in collapsed mode."));
	}
	
	@Test(description="To verify that user is able to expand/collapse detail portion of \"Vision and Objectives of CCTNS\" by clicking on \"Vision and Objectives of CCTNS\" link from \"Crime and Criminal Tracking\" page.")
	public void PV_HomePage_32(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_CCT));
		act.moveToElement(e2);
		act.click().build().perform();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime & Criminal Tracking\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime and Criminal Tracking");
		driver.findElement(By.xpath(Landingpage_repository.lnk_vision_and_objofCCTNS)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Vision and Objectives of CCTNS\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_vision_and_objofCCTNS)).getAttribute("aria-expanded"), "true");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_1</b> : User should get detail portion of \"Vision and Objectives of CCTNS\" in expanded mode."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Landingpage_repository.lnk_vision_and_objofCCTNS)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Vision and Objectives of CCTNS\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_vision_and_objofCCTNS)).getAttribute("aria-expanded"), "false");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_2</b> : User should get detail portion of \"Vision and Objectives of CCTNS\" in collapsed mode."));
	}
	
	@Test(description="To verify that user is able to expand/collapse detail portion of \"Stakeholders of Project\" by clicking on \"Stakeholders of Project\" link from \"Crime and Criminal Tracking\" page.")
	public void PV_HomePage_33(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_CCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime & Criminal Tracking\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime and Criminal Tracking");
		driver.findElement(By.xpath(Landingpage_repository.lnk_stakeholderofproj)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Stakeholders of Project\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_stakeholderofproj)).getAttribute("aria-expanded"), "true");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_1</b> : User should get detail portion of \"Stakeholders of Project\" in expanded mode."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Landingpage_repository.lnk_stakeholderofproj)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Stakeholders of Project\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_stakeholderofproj)).getAttribute("aria-expanded"), "false");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_2</b> : User should get detail portion of \"Stakeholders of Project\" in collapsed mode."));
	}
	
	@Test(description="To verify that user is able to expand/collapse detail portion of \"Benefits of CCTNS\" by clicking on \"Benefits of CCTNS\" link from \"Crime and Criminal Tracking\" page.")
	public void PV_HomePage_34(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_CCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime & Criminal Tracking\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime and Criminal Tracking");
		driver.findElement(By.xpath(Landingpage_repository.lnk_benefitsofCCTNS)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Benefits of CCTNS\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_benefitsofCCTNS)).getAttribute("aria-expanded"), "true");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_1</b> : User should get detail portion of \"Benefits of CCTNS\" in expanded mode."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Landingpage_repository.lnk_benefitsofCCTNS)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-6</b> : Click on \"Benefits of CCTNS\" link.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.lnk_benefitsofCCTNS)).getAttribute("aria-expanded"), "false");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_2</b> : User should get detail portion of \"Benefits of CCTNS\" in collapsed mode."));
	}
	
	@Test(description="To verify that user is able to get \"Data Centre & Technical Branch\"  page by clicking on \"Data Centre & Technical Branch\" link from \"Divisions\" dropdown from \"Home\" page.")
	public void PV_HomePage_35()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_DCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Data Centre & Technical Branch(DCT)\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "DCT Branch");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Data Centre And Technical Branch");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Data Centre & Technical Branch\" page."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Data Centre & Technical Branch\" page.")
	public void PV_HomePage_36() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_divisions));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Divisions\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_DCT));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Data Centre & Technical Branch(DCT)\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "DCT Branch");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Data Centre And Technical Branch");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Data Centre & Technical Branch\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Data Centre & Technical Branch\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Crime In India\"  page by clicking on \"Crime In India\" link from \"Publications\" dropdown from \"Home\" page.")
	public void PV_HomePage_37()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_publications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Publications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_crimeinIndia));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime In India\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime In India");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Crime In India");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Crime In India\" page with detailed information."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Crime In India\" page.")
	public void PV_HomePage_38() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_publications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Publications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_crimeinIndia));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Crime In India\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Crime In India");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Crime In India");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Crime In India\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Crime In India\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Prison Statistics India\"  page by clicking on \"Prison Statistics India\" link from \"Publications\" dropdown from \"Home\" page.")
	public void PV_HomePage_39()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_publications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Publications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_prisonstatistics));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Prison Statistics India\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Prison Statistics India");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Prison Statistics India");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Prison Statistics India\" page with detailed information."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Prison Statistics India\" page.")
	public void PV_HomePage_40() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_publications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Publications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_prisonstatistics));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Prison Statistics India\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Prison Statistics India");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Prison Statistics India");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Prison Statistics India\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Prison Statistics India\" page."));
	}
	
	@Test(description="To verify that user is able to get reports of missing women and children by clicking on \"Report on Missing Woman & Children\" link from \"Publications\" dropdown from \"Home\" page.")
	public void PV_HomePage_41(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_publications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Publications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_reportonmissing_women_and_chil));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Report on Missing Woman & Children\" link from dropdown list.");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Prison Statistics India\" page with detailed information."));
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child=I1.next();


			if(!parent.equals(child))
			{
				driver.switchTo().window(child);

				String actualTitle = driver.switchTo().window(child).getTitle();
				System.out.println(actualTitle);
				Thread.sleep(2000);
				//
			}
		}
	}
	
	@Test(description="To verify that user is able to redirect the Citizen Charter|National Crime Record Bureau web portal by clicking on \"Cyber Crime Reporting Portal\" link from \"Citizen Services\" dropdown from \"Home\" page.")
	public void PV_HomePage_42(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_citizen_services));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Citizen Services\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_cybercrimereportingportal));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Cyber Crime Reporting Portal\" link from dropdown list.");
		Alert alert=driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "This link will take you to an external web site.");
		alert.accept();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : </br>1. User should able to click on \"OK\" button of validation message popup and message popup should close.</br>"
				+ "2. User should rediret to the  \"Citizen Charter|National Crime Record Bureau\" web portal in new tab of browser."));
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child=I1.next();


			if(!parent.equals(child))
			{
				driver.switchTo().window(child);

				String actualTitle = driver.switchTo().window(child).getTitle();
				System.out.println(actualTitle);
				Assert.assertEquals(actualTitle, "Cyber Crime Portal");
				Thread.sleep(2000);
				//
			}
		}
		
	}
	
	@Test(description="To verify that user is able to get \"Generate Vehicle NOC\"  page by clicking on \"Generate Vehicle NOC\" link from \"Citizen Services\" dropdown from \"Home\" page.")
	public void PV_HomePage_43()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_citizen_services));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Citizen Services\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_generatevehicleNOC));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Generate Vehicle NOC\" link from dropdown list.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Generate Vehicle NOC");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Generate Vehicle NOC");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Generate Vehicle NOC\" page."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Generate Vehicle NOC\" page.")
	public void PV_HomePage_44() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_citizen_services));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Citizen Services\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_generatevehicleNOC));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Generate Vehicle NOC\" link from dropdown list.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Generate Vehicle NOC");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Generate Vehicle NOC");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Generate Vehicle NOC\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Generate Vehicle NOC\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Citizen Charter\"  page by clicking on \"Citizen Charter\" link from \"Citizen Services\" dropdown from \"Home\" page.")
	public void PV_HomePage_45()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_citizen_services));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Citizen Services\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_citizencharter));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Citizen Charter\" link from dropdown list.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Citizen Charter");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Citizen Charter");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Citizen Charter\" page"));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Citizen Charter\" page.")
	public void PV_HomePage_46() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_citizen_services));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Citizen Services\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_citizencharter));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Citizen Charter\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Citizen Charter");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Citizen Charter");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Citizen Charter\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Citizen Charter\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Short Film on CCTNS\"  page by clicking on \"Short Film on CCTNS\" link from \"Citizen Services\" dropdown from \"Home\" page.")
	public void PV_HomePage_47()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_citizen_services));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Citizen Services\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_shortfileonCCTNS));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Short Film on CCTNS\" link from dropdown list.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Short Film on CCTNS");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Short Film on CCTNS");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Short Film on CCTNS\" page."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Short Film on CCTNS\" page.")
	public void PV_HomePage_48() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_citizen_services));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Citizen Services\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_shortfileonCCTNS));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Short Film on CCTNS\" link from dropdown list.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Short Film on CCTNS");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Short Film on CCTNS");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Short Film on CCTNS\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Short Film on CCTNS\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Vacancies\"  page by clicking on \"Vacancies\" link from \"Citizen Services\" dropdown from \"Home\" page.")
	public void PV_HomePage_49()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_notifications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Notifications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_vacancies));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Vacancies\" link from dropdown list.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Vacancies");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Vacancy");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Vacancies\" page."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Vacancies\" page.")
	public void PV_HomePage_50() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_notifications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Notifications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_vacancies));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Vacancies\" link from dropdown list.");
		
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Vacancies");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Vacancy");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Vacancies\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Vacancies\" page."));
	}
	
	@Test(description="To verify that user is able to get \"Advisories\"  page by clicking on \"Advisories\" link from \"Citizen Services\" dropdown from \"Home\" page.")
	public void PV_HomePage_51()
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_notifications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Notifications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_advisories));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Advisories\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Advisories");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Advisories");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"Advisories\" page."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Advisories\" page.")
	public void PV_HomePage_52() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		Actions act = new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(Landingpage_repository.lnk_notifications));
		act.moveToElement(e1);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Move mouse pointer to \"Notifications\" functionality.");
		WebElement e2=driver.findElement(By.xpath(Landingpage_repository.lnk_advisories));
		act.moveToElement(e2);
		act.click().build().perform();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Advisories\" link from dropdown list.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_3)).getText(), "Advisories");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "Advisories");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on \"Home\" link from \"Advisories\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"Advisories\" page."));
	}
	
	@Test(description="To verify that user is able to navigate to the \"RTI\" page by clicking on \"RTI\" link from \"Home\" page of police vertical web portal.")
	public void PV_HomePage_53() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Landingpage_repository.lnk_RTI)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on \"RTI\" link from \"Home\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_2)).getText(), "RTI");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "RTI Act 2005");
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should navigate to \"RTI\" page."));
	}
	
	@Test(description="To verify that user is able to redirect back to \"Home\" page by clicking on \"Home\" link from \"Advisories\" page.")
	public void PV_HomePage_54() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Landingpage_repository.lnk_RTI)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Click on \"RTI\" link from \"Home\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.navpath_2)).getText(), "RTI");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.header_contentpage)).getText(), "RTI Act 2005");
		driver.findElement(By.xpath(Landingpage_repository.lnk_home_contentpage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on \"Home\" link from \"RTI\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.maincontent_homepage)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should redirect back to \"Home\" page of Police Vertical web portal from \"RTI\" page."));
	}
	
	@Test(priority=7,description="To verify that user is able to scroll images using  Next(\">\") and Previous(\"<\") button in \"News & Events\" section.")
	public void PV_HomePage_57(Method method) throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		WebElement element = driver.findElement(By.xpath(Landingpage_repository.slidedots_newsection));
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.onPage(); coordinate.inViewPort();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Scroll down \"Home\" page till \"News & Events\" section.");
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.newsevent_section)).isDisplayed());
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.next_arrow_newssection)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on Next sliding(\">\") button button.");
		Thread.sleep(1000);
		String s1=driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection)).getAttribute("style");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_1</b> : User should able to scroll next News or Event image."));
		ll.Screenshotnew(driver,i,method.getName()+"_01");
		driver.findElement(By.xpath(Landingpage_repository.pre_arrow_newssection)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-5</b> : Click on Previous sliding(\"<\") button.");
		Thread.sleep(1000);
		String s2=driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection)).getAttribute("style");
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result_2</b> : User should able to scroll previous News or Event image."));
		
	}
	

	@Test(priority=8,description="To verify that user is able to slide images of \"News & Events\" section by clicking on page control.")
	public void PV_HomePage_58() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		WebElement element = driver.findElement(By.xpath(Landingpage_repository.slidedots_newsection));
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.onPage(); coordinate.inViewPort();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-3</b> : Scroll down \"Home\" page till \"News & Events\" section.");
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.newsevent_section)).isDisplayed());
		Thread.sleep(1000);
		Assert.assertEquals("0", driver.findElement(By.xpath(Landingpage_repository.slide_control0)).getAttribute("tabindex"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.slide_control2)).click();
		String s1=driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection)).getAttribute("style");
		Thread.sleep(1000);
		Assert.assertEquals("-1", driver.findElement(By.xpath(Landingpage_repository.slide_control0)).getAttribute("tabindex"));
		Thread.sleep(1000);

		driver.findElement(By.xpath(Landingpage_repository.slide_control5)).click();
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-4</b> : Click on page control icon.");
		String s2=driver.findElement(By.xpath(Landingpage_repository.slidetrack_newssection)).getAttribute("style");
		Thread.sleep(1000);
		Assert.assertNotEquals(s1, s2);
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,String.format("<b>Result</b> : User should able to slide image of \"News & Events\" section by clicking of page control icon."));
	}

	@Test(priority=9)
	public void Test_20() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath(Landingpage_repository.btn_clear));
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.onPage(); coordinate.inViewPort();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"Scroll to File a report section.");
		driver.findElement(By.xpath(Landingpage_repository.dd_sel_crimetype)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on crimetype dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.dd_op_crimetype3)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Crime Type 3 option from dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.dd_sel_crimesubtype)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on crimesubtype dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.dd_op_crimesubtype3)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Crime Sub Type 3 option from dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.btn_clear)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Clear button.");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"Clear functionality of Report Crime verified.");
	}

	@Test(priority=10)
	public void Test_22() throws InterruptedException
	{
		WebElement element = driver.findElement(By.xpath(Landingpage_repository.btn_clear));
		Coordinates coordinate = ((Locatable)element).getCoordinates();
		coordinate.onPage(); coordinate.inViewPort();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"Scroll to File a report section.");
		driver.findElement(By.xpath(Landingpage_repository.sec_raisecomplaint)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Raise Complaint button.");
		Thread.sleep(2000);

		driver.findElement(By.xpath(Landingpage_repository.dd_sel_crimetype_raise)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on crimetype dropdown.");
		Thread.sleep(3000);

		driver.findElement(By.xpath(Landingpage_repository.dd_op_crimetype3_raise)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Crime Type 3 option from dropdown.");
		Thread.sleep(1000);

		driver.findElement(By.xpath(Landingpage_repository.dd_sel_crimesubtype_raise)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on crimesubtype dropdown.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.dd_op_crimesubtype3_raise)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Crime Sub Type 3 option from dropdown.");
		Thread.sleep(1000);
		WebElement e1 = driver.findElement(By.xpath(Landingpage_repository.btn_raisecom));
		Coordinates c1 = ((Locatable)e1).getCoordinates();
		c1.onPage(); c1.inViewPort();
		driver.findElement(By.xpath(Landingpage_repository.btn_clear_raisesec)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Clear button.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.sec_reportcrime)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"Clear functionality of Raise Comaplaint verified.");
	}

	@Test(priority=11)
	public void Test_13() throws InterruptedException
	{
		driver.findElement(By.xpath(Landingpage_repository.btn_Login)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.txtbox_Username)).sendKeys("Admin");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Username enter event.");
		driver.findElement(By.xpath(Login_repository.txtbox_Password)).sendKeys("1q2w3E*");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "Password enter event.");
		driver.findElement(By.xpath(Login_repository.btn_Login1)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Login button.");
		Thread.sleep(8000);
		Assert.assertEquals("admin", driver.findElement(By.xpath(Landingpage_repository.txt_admin)).getText());
		ExtentTestManager.getTest().log(Status.INFO,"Login successfully verified.");
	}

	@Test(priority=12)
	public void PV_HomePage_16() throws InterruptedException
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		Assert.assertEquals("My account", driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).getText());
		ExtentTestManager.getTest().log(Status.INFO,"Verify My Account option.");
		Assert.assertEquals("Security logs", driver.findElement(By.xpath(Landingpage_repository.dd_admin_op2)).getText());
		ExtentTestManager.getTest().log(Status.INFO,"Verify Security logs option.");
		Assert.assertEquals("Log out", driver.findElement(By.xpath(Landingpage_repository.dd_admin_op3)).getText());
		ExtentTestManager.getTest().log(Status.INFO,"Verify Log out option.");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on My account option from dropdown.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"Navigate to My Accout page.");
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child=I1.next();


			if(!parent.equals(child))
			{
				driver.switchTo().window(child);

				String actualTitle = driver.switchTo().window(child).getTitle();
				Assert.assertEquals(actualTitle,"SGLPV");
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		Assert.assertEquals(driver.getTitle(), "Police Vertical");
	}


	@Test(priority=13)
	public void PV_HomePage_17() throws InterruptedException
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op2)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Security logs option from dropdown.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"Navigate to Security Logs page.");
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);

				String actualTitle = driver.switchTo().window(child_window).getTitle();
				Thread.sleep(1000);
				Assert.assertEquals(actualTitle,"SGLPV"); 
				Thread.sleep(2000);
				Assert.assertEquals(driver.getCurrentUrl(),"http://192.168.1.204:10014/Account/SecurityLogs");
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		Assert.assertEquals(driver.getTitle(), "Police Vertical");
	}

	@Test(priority=14)
	public void Test_03() throws InterruptedException, AWTException
	{

		driver.findElement(By.xpath(Landingpage_repository.txt_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		Thread.sleep(2000);
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on My account option from dropdown.");
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"Navigate to admin portal page.");
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();



			if(!parent.equals(child_window)) {

				driver.switchTo().window(child_window);

				String actualTitle = driver.switchTo().window(child_window).getTitle();
				Thread.sleep(1000);
				Assert.assertEquals(actualTitle,"SGLPV"); 
				Thread.sleep(3000);
				driver.findElement(By.xpath(admin_page_repository.opt_CMS)).click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.INFO,"CMS menu click event.");
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
				String t1=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Thread.sleep(1000);
				Assert.assertEquals(t1,"Pages");
				ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_logo)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Edit button click event.");
				Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).isDisplayed());
				String t2=driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).getText();
				Thread.sleep(1000);
				Assert.assertEquals("Content", t2);
				ExtentTestManager.getTest().log(Status.INFO,"Get content page.");
				String t3=driver.findElement(By.xpath(Landingpage_repository.txt_logo_CMS)).getText();
				Thread.sleep(2000);
				System.out.println(t3);
				Thread.sleep(2000);

				Thread.sleep(1000);
				String t4=driver.findElement(By.xpath(Landingpage_repository.txt_logo_CMS)).getText();
				Thread.sleep(2000);
				System.out.println(t4);
				Robot robot = new Robot(); 
				robot.mouseMove(820,800);
				Thread.sleep(2000); 
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Type test by robot class (keyboard event).");
				driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Submit button click event.");
				driver.switchTo().window(parent);
				ExtentTestManager.getTest().log(Status.INFO,"Switch to citizen portal.");
				driver.navigate().refresh();
				Thread.sleep(2000); 
				String text=driver.findElement(By.xpath(Landingpage_repository.logo_text)).getText();
				Thread.sleep(2000); 
				Assert.assertEquals(text, "Police Vertical test");
				driver.switchTo().window(child_window);
				Thread.sleep(3000);
				ExtentTestManager.getTest().log(Status.INFO,"Logo verify.");
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
				String t5=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Thread.sleep(1000);
				Assert.assertEquals(t5,"Pages");
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_logo)).click();
				driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
				Thread.sleep(1000);
				robot.mouseMove(820,800);
				Thread.sleep(2000); 
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); 
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_DELETE);
				robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE);
				robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE);
				robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE);
				robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE);
				robot.keyRelease(KeyEvent.VK_DELETE);
				//driver.findElement(By.xpath(xpath_Landingpage.txt_logo_CMS)).clear();
				//Thread.sleep(2000);
				Thread.sleep(2000);

				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
				Thread.sleep(1000);
				driver.close();
				driver.switchTo().window(parent);
				driver.navigate().refresh();
				String text1=driver.findElement(By.xpath(Landingpage_repository.logo_text)).getText();
				Thread.sleep(2000); 
				Assert.assertEquals(text1, "Police Vertical");


			}
		}
	}


	@Test(priority=15)
	public void Test_23() throws InterruptedException, AWTException 
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on My account option from dropdown.");
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();



			if(!parent.equals(child_window)) {

				driver.switchTo().window(child_window);

				String actualTitle = driver.switchTo().window(child_window).getTitle();
				Thread.sleep(1000);
				Assert.assertEquals(actualTitle,"SGLPV"); 
				Thread.sleep(3000);
				driver.findElement(By.xpath(Landingpage_repository.dd_CMS)).click();
				ExtentTestManager.getTest().log(Status.INFO,"CMS menu click event.");
				Thread.sleep(2000);
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
				String t1=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Thread.sleep(1000);
				Assert.assertEquals(t1,"Pages");
				ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
				driver.findElement(By.xpath(Landingpage_repository.numbering_CMS_3)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_CrimeMapping)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Edit button click event.");
				Thread.sleep(1000);
				Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).isDisplayed());
				String t2=driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).getText();
				Thread.sleep(1000);
				Assert.assertEquals("Content", t2);
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Get content page.");
				String t3=driver.findElement(By.xpath(Landingpage_repository.text_CrimeMapping)).getText();
				WebElement el=driver.findElement(By.xpath(Landingpage_repository.text_CrimeMapping));
				System.out.println(t3);

				Robot robot = new Robot(); 
				robot.mouseMove(575,700); Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_SPACE); 
				robot.keyPress(KeyEvent.VK_SHIFT);robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T); robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E); robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S); robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);robot.keyRelease(KeyEvent.VK_SHIFT); Thread.sleep(1000);
				
				ExtentTestManager.getTest().log(Status.INFO,"Type TEST by robot class (keyboard event). in title");
				
				robot.mouseMove(480,720);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T); 
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E); 
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S); 
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);
				robot.keyPress(KeyEvent.VK_I);
				robot.keyPress(KeyEvent.VK_I);
				robot.keyRelease(KeyEvent.VK_N); 
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_G); 
				robot.keyPress(KeyEvent.VK_G);
				robot.keyPress(KeyEvent.VK_SPACE);
				Thread.sleep(2000);

				ExtentTestManager.getTest().log(Status.INFO,"Type testing by robot class (keyboard event) in para.");

				driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Submit button click event.");
				driver.switchTo().window(parent);
				ExtentTestManager.getTest().log(Status.INFO,"Switch to citizen portal.");
				driver.navigate().refresh(); Thread.sleep(2000);
				driver.findElement(By.xpath(Landingpage_repository.lnk_Skiptomaincontent)).click()
				; Thread.sleep(1000); 
				String text=driver.findElement(By.xpath(Landingpage_repository.txt_title_CrimeMapping)).getText(); 
				Thread.sleep(2000); 
				Assert.assertEquals(text,"Crime Mapping TEST");
				ExtentTestManager.getTest().log(Status.INFO,"Title verify.");
				String text2=driver.findElement(By.xpath(Landingpage_repository.txt_para_CrimeMapping)).getText(); 
				Thread.sleep(2000); 
				Assert.assertEquals(text2,"testing Adopt latest GIS technology for gaining better insights. Study and visualize crime and incidence patterns using Advanced Mapping Engine.");
				ExtentTestManager.getTest().log(Status.INFO,"Paragraph verify.");
				driver.switchTo().window(child_window);
				Thread.sleep(3000);
				ExtentTestManager.getTest().log(Status.INFO,"Back to admin portal.");
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click(); String
				t5=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Thread.sleep(1000); Assert.assertEquals(t5,"Pages");
				driver.findElement(By.xpath(Landingpage_repository.numbering_CMS_3)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_CrimeMapping)).
				click(); driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
				Thread.sleep(1000); robot.mouseMove(575,700); Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				ExtentTestManager.getTest().log(Status.INFO,"Delete TEST from title.");
				robot.mouseMove(480,720);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				robot.keyPress(KeyEvent.VK_DELETE); robot.keyRelease(KeyEvent.VK_DELETE);
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Delete testing from para.");
				driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Click on Submit button.");
				Thread.sleep(1000); 
				driver.close();
				Thread.sleep(1000);
				driver.switchTo().window(parent);
				ExtentTestManager.getTest().log(Status.INFO,"Switch to Citizen portal.");
				driver.navigate().refresh(); String
				text1=driver.findElement(By.xpath(Landingpage_repository.txt_title_CrimeMapping)).
				getText(); Thread.sleep(2000); Assert.assertEquals(text1, "Crime Mapping");
				ExtentTestManager.getTest().log(Status.INFO,"Verify title text of content.");
				String text3=driver.findElement(By.xpath(Landingpage_repository.txt_para_CrimeMapping)).getText(); 
				Thread.sleep(2000); 
				Assert.assertEquals(text3, "Adopt latest GIS technology for gaining better insights. Study and visualize crime and incidence patterns using Advanced Mapping Engine.");
				ExtentTestManager.getTest().log(Status.INFO,"Verify para text of content block.");
			}
		}
	}

	@Test(priority=16)
	public void Test_31() throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on My account option from dropdown.");
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();



			if(!parent.equals(child_window)) {

				driver.switchTo().window(child_window);

				String actualTitle = driver.switchTo().window(child_window).getTitle();
				Thread.sleep(1000);
				Assert.assertEquals(actualTitle,"SGLPV"); 
				Thread.sleep(3000);
				driver.findElement(By.xpath(Landingpage_repository.dd_CMS)).click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.INFO,"CMS menu click event.");
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
				String t1=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Thread.sleep(1000);
				Assert.assertEquals(t1,"Pages");
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_gallery)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Edit button click event.");
				Thread.sleep(1000);
				Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).isDisplayed());
				String t2=driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).getText();
				Thread.sleep(1000);
				Assert.assertEquals("Content", t2);
				Thread.sleep(1000);

				Robot robot = new Robot(); 
				robot.mouseMove(460,880);Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_SHIFT);
				Thread.sleep(2000);
				robot.mouseMove(495,920); Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(2000);
				robot.keyRelease(KeyEvent.VK_SHIFT); 
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_C); 
				robot.keyRelease(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_CONTROL); 
				robot.mouseMove(495,920);
				Thread.sleep(1000); 
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_ENTER); 
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V); 
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL); 
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.INFO,"Add image link by robot class (keyboard event). in title");
				WebElement e2 = driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)); Coordinates
				co2 = ((Locatable)e2).getCoordinates(); co2.onPage(); co2.inViewPort();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Click on Submit button.");
				Thread.sleep(1000); driver.switchTo().window(parent);
				ExtentTestManager.getTest().log(Status.INFO,"Switch to citizen portal.");
				driver.navigate().refresh(); Thread.sleep(2000); 
				WebElement e1 = driver.findElement(By.xpath(Landingpage_repository.newsletter_section)); Coordinates
				co1 = ((Locatable)e1).getCoordinates(); co1.onPage(); co1.inViewPort();
				Thread.sleep(1000);
				Assert.assertEquals(true,driver.findElement(By.xpath(Landingpage_repository.img_newadded)).isDisplayed());	  
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.INFO,"Verify new added image");
				driver.switchTo().window(child_window); 
				Thread.sleep(3000);
				ExtentTestManager.getTest().log(Status.INFO,"Switch to Admin portal.");

				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_gallery)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Edit button click event.");
				robot.mouseMove(460,940);Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_SHIFT); Thread.sleep(2000);
				robot.mouseMove(495,980); Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); Thread.sleep(2000);
				robot.keyRelease(KeyEvent.VK_SHIFT); 
				robot.keyPress(KeyEvent.VK_DELETE); Thread.sleep(4000);
				ExtentTestManager.getTest().log(Status.INFO,"Delete added image link.");
				driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
				Thread.sleep(1000); 
				ExtentTestManager.getTest().log(Status.INFO,"Click on Submit button.");
				driver.close(); Thread.sleep(1000);
				driver.switchTo().window(parent);
				ExtentTestManager.getTest().log(Status.INFO,"Switch to citizen portal.");
				driver.navigate().refresh(); 
				WebElement e3=driver.findElement(By.xpath(Landingpage_repository.newsletter_section));
				Coordinates co3 = ((Locatable)e3).getCoordinates(); co3.onPage();
				co3.inViewPort(); Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Verify added image removed.");

			}
		}
	}


	@Test(priority=17)
	public void Test_32() throws InterruptedException, AWTException
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on My account option from dropdown.");
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();



			if(!parent.equals(child_window)) {

				driver.switchTo().window(child_window);

				String actualTitle = driver.switchTo().window(child_window).getTitle();
				Thread.sleep(1000);
				Assert.assertEquals(actualTitle,"SGLPV"); 
				Thread.sleep(3000);
				driver.findElement(By.xpath(Landingpage_repository.dd_CMS)).click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.INFO,"CMS menu click event.");
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
				String t1=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Thread.sleep(1000);
				Assert.assertEquals(t1,"Pages");
				ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_footer)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Edit button click event.");
				Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).isDisplayed());
				String t2=driver.findElement(By.xpath(Landingpage_repository.content_page_CMS)).getText();
				Thread.sleep(1000);
				Assert.assertEquals("Content", t2);
				Thread.sleep(1000);
				String t3=driver.findElement(By.xpath(Landingpage_repository.text_CrimeMapping)).getText();
				WebElement el=driver.findElement(By.xpath(Landingpage_repository.text_CrimeMapping));
				System.out.println(t3);

				Robot robot = new Robot(); 
				robot.mouseMove(460,780);Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_SHIFT);
				Thread.sleep(2000);
				robot.mouseMove(810,780); Thread.sleep(2000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				Thread.sleep(2000);

				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.mouseMove(810,780); 
				Thread.sleep(1000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);
				robot.mouseMove(745,800); 
				Thread.sleep(1000);
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
				robot.keyPress(KeyEvent.VK_1);
				ExtentTestManager.getTest().log(Status.INFO,"Add footer link by robot class (keyboard event). in title.");
				WebElement e2 = driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)); Coordinates
				co2 = ((Locatable)e2).getCoordinates(); co2.onPage(); co2.inViewPort();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on Submit button.");
				driver.switchTo().window(parent);
				ExtentTestManager.getTest().log(Status.INFO,"Switch to citizen portal.");
				driver.navigate().refresh(); Thread.sleep(2000);
				WebElement e1 =
						driver.findElement(By.xpath(Landingpage_repository.footer_allrights)); Coordinates
						co1 = ((Locatable)e1).getCoordinates(); co1.onPage(); co1.inViewPort();
						Thread.sleep(1000);

						Assert.assertEquals("Achivements1",driver.findElement(By.xpath(Landingpage_repository.txt_newfooter_lnk)).getText()); 
						Thread.sleep(2000); 
						ExtentTestManager.getTest().log(Status.INFO,"Verify added link in footer.");
						driver.switchTo().window(child_window);
						Thread.sleep(3000);
						ExtentTestManager.getTest().log(Status.INFO,"Switch to admin portal.");

						driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
						Thread.sleep(1000);
						ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
						driver.findElement(By.xpath(Landingpage_repository.btn_Actions_footer)).click();
						ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
						driver.findElement(By.xpath(Landingpage_repository.btn_edit)).click();
						Thread.sleep(1000);
						ExtentTestManager.getTest().log(Status.INFO,"Edit button click event.");
						robot.mouseMove(460,800);Thread.sleep(2000);
						robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						robot.keyPress(KeyEvent.VK_SHIFT);
						Thread.sleep(2000);
						robot.mouseMove(810,800); Thread.sleep(2000);
						robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						Thread.sleep(2000); 
						robot.keyRelease(KeyEvent.VK_SHIFT);
						robot.keyPress(KeyEvent.VK_DELETE);
						Thread.sleep(4000);
						ExtentTestManager.getTest().log(Status.INFO,"Delete added footer link.");
						driver.findElement(By.xpath(Landingpage_repository.btn_submit_CMS)).click();
						Thread.sleep(1000);
						ExtentTestManager.getTest().log(Status.INFO,"Click on submit button.");
						driver.close();
						Thread.sleep(1000);
						driver.switchTo().window(parent);
						ExtentTestManager.getTest().log(Status.INFO,"Switch to citizen portal.");
						driver.navigate().refresh(); 
						WebElement e3 =driver.findElement(By.xpath(Landingpage_repository.footer_allrights)); 
						Coordinates co3 = ((Locatable)e3).getCoordinates(); co3.onPage(); co3.inViewPort();
						Thread.sleep(1000);
			}
		}
	}


	@Test(priority=18)
	public void Test_33_34() throws InterruptedException 
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO,"Click on My account option from dropdown.");
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();



			if(!parent.equals(child_window)) {

				driver.switchTo().window(child_window);

				String actualTitle = driver.switchTo().window(child_window).getTitle();
				Thread.sleep(1000);
				Assert.assertEquals(actualTitle,"SGLPV"); 
				Thread.sleep(3000);
				driver.findElement(By.xpath(Landingpage_repository.dd_CMS)).click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.INFO,"CMS menu click event.");
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();

				String t1=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Assert.assertEquals(t1,"Pages");
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_NewPage)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on New Page button.");
				driver.findElement(By.xpath(Landingpage_repository.txtbox_title_CMSpage)).sendKeys("Test");
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Enter title in respective text-box.");
				WebElement e1 = driver.findElement(By.xpath(Landingpage_repository.btn_submit_createpage)); Coordinates
				co1 = ((Locatable)e1).getCoordinates(); co1.onPage(); co1.inViewPort();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_submit_createpage)).click();
				Thread.sleep(3000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on Submit button.");
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_Test)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_delete)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Delete button click event.");
				Assert.assertEquals("Are you sure?",driver.findElement(By.xpath(Landingpage_repository.validation_1stline)).getText() );
				Thread.sleep(1000);
				Assert.assertEquals("Are you sure to delete this page?",driver.findElement(By.xpath(Landingpage_repository.validation_2ndline)).getText() );
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Verify validation text.");
				driver.findElement(By.xpath(Landingpage_repository.validation_btn_cancel)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Cancel button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_Actions_Test)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Actions button click event.");
				driver.findElement(By.xpath(Landingpage_repository.btn_delete)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Delete button click event.");
				driver.findElement(By.xpath(Landingpage_repository.validation_btn_yes)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Yes button click event.");
				ExtentTestManager.getTest().log(Status.INFO,"Verify record is deleted.");
				driver.close();
				Thread.sleep(1000);
				driver.switchTo().window(parent);
			}
		}
	}

	@Test(priority=19)
	public void Test_35__39() throws InterruptedException
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op1)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on My account option from dropdown.");
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();



			if(!parent.equals(child_window)) {

				driver.switchTo().window(child_window);

				String actualTitle = driver.switchTo().window(child_window).getTitle();
				Thread.sleep(1000);
				Assert.assertEquals(actualTitle,"SGLPV"); 
				Thread.sleep(3000);
				driver.findElement(By.xpath(Landingpage_repository.dd_CMS)).click();
				Thread.sleep(2000);
				ExtentTestManager.getTest().log(Status.INFO,"CMS menu click event.");
				driver.findElement(By.xpath(Landingpage_repository.dd_op_Pages)).click();
				ExtentTestManager.getTest().log(Status.INFO,"Pages option click event.");
				//next/previous paging
				String t1=driver.findElement(By.xpath(Landingpage_repository.page_header)).getText();
				Assert.assertEquals(t1,"Pages");
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_next)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Next button click event.");
				String e1=driver.findElement(By.xpath(Landingpage_repository.txt_entries)).getText();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.btn_previous)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Previous button click event.");
				String e2=driver.findElement(By.xpath(Landingpage_repository.txt_entries)).getText();
				Thread.sleep(1000);
				Assert.assertNotEquals(e1, e2);
				Thread.sleep(1000);
				//Paging by particular page no.
				driver.findElement(By.xpath(Landingpage_repository.numbering_CMS_3)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Page control num 3 click event.");
				String e3=driver.findElement(By.xpath(Landingpage_repository.txt_entries)).getText();
				Thread.sleep(1000);
				driver.findElement(By.xpath(Landingpage_repository.numbering_CMS_1)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Page control num 1 click event.");
				String e4=driver.findElement(By.xpath(Landingpage_repository.txt_entries)).getText();
				Thread.sleep(1000);
				Assert.assertNotEquals(e3, e4);
				Thread.sleep(1000);

				//Show entries
				driver.findElement(By.xpath(Landingpage_repository.dd_enteries)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on dropdown of select entries.");
				driver.findElement(By.xpath(Landingpage_repository.entries_25)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on 25 from select entries dropdown.");
				Assert.assertEquals("Showing 1 to 25 of 30 entries", driver.findElement(By.xpath(Landingpage_repository.txt_entries)).getText() );
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Verify selected entries.");
				driver.findElement(By.xpath(Landingpage_repository.dd_enteries)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on dropdown of select entries.");
				driver.findElement(By.xpath(Landingpage_repository.entries_10)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on 10 from select entries dropdown.");
				Assert.assertEquals("Showing 1 to 10 of 30 entries", driver.findElement(By.xpath(Landingpage_repository.txt_entries)).getText());
				Thread.sleep(3000);
				ExtentTestManager.getTest().log(Status.INFO,"Verify selected entries.");
				
				WebElement el1 =driver.findElement(By.xpath(Landingpage_repository.btn_search)); 
				Coordinates co3 = ((Locatable)el1).getCoordinates(); co3.onPage(); co3.inViewPort();
				Thread.sleep(1000);
				//Search

				driver.findElement(By.xpath(Landingpage_repository.txtbox_search)).sendKeys("Brand Logo");
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Enter search criteria in Search text-box.");
				driver.findElement(By.xpath(Landingpage_repository.btn_search)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on Search icon.");
				Assert.assertEquals("Brand Logo", driver.findElement(By.xpath(Landingpage_repository.txt_1st_title)).getText() );
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Verify searched result.");
				driver.findElement(By.xpath(Landingpage_repository.txtbox_search)).clear();
				ExtentTestManager.getTest().log(Status.INFO,"Clear Search text-box.");
				driver.findElement(By.xpath(Landingpage_repository.btn_search)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on Search icon.");
				Assert.assertNotEquals("Brand Logo", driver.findElement(By.xpath(Landingpage_repository.txt_1st_title)).getText());
				Thread.sleep(1000);

				//Sorting
				driver.findElement(By.xpath(Landingpage_repository.sorting_title)).click();
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Click on title sorting icon.");
				Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.txt_1st_title)).getText(),"Analyze Crime On Map" );
				Thread.sleep(1000);
				ExtentTestManager.getTest().log(Status.INFO,"Sorting event verify.");
				driver.findElement(By.xpath(Landingpage_repository.sorting_title)).click();
				Thread.sleep(1000);
				Assert.assertEquals(driver.findElement(By.xpath(Landingpage_repository.txt_1st_title)).getText() ,"Toolbar" );
				Thread.sleep(1000);
			}
		}
	}


	@Test(priority=20)
	public void PV_HomePage_18() throws InterruptedException
	{
		driver.findElement(By.xpath(Landingpage_repository.dd_admin)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on login status dropdown.");
		driver.findElement(By.xpath(Landingpage_repository.dd_admin_op3)).click();
		ExtentTestManager.getTest().log(Status.INFO,"Click on Log out option from dropdown.");
		Thread.sleep(5000);
		Assert.assertEquals(true, driver.findElement(By.xpath(Landingpage_repository.btn_Login)).isDisplayed());
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO,"Logout succesfully verified.");
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


	@AfterMethod
	public void Aftermethod() throws InterruptedException
	{	 
		driver.quit();
		Thread.sleep(1000);
	}

}
