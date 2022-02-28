package pv_admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Listener.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PV_Registration {

WebDriver driver;

    
	@BeforeMethod

	public void setDriver(ITestContext context) throws InterruptedException
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\GeckoDriver\\geckodriver.exe");
		//driver=new FirefoxDriver();

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		context.setAttribute("WebDriver", driver);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://qapoc.sgligis.com:10014/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	
	@Test(priority=0,description="To verify that user is able to \"Register\" in Police Vertical web portal.")
	public void PV_Registration_1() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_username)).sendKeys("Test_995");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_emailid)).sendKeys("test995@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_password)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_confirmpass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_DOB)).sendKeys("09/07/1997");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_gender)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_state)).sendKeys("Gujarat");
		//driver.findElement(By.xpath(Registration_repository.op_gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.dd_district)).sendKeys("Ahmedabad");
		//driver.findElement(By.xpath(Registration_repository.op_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(Registration_repository.btn_personaldetail_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Click on \"Next\" button.");
		driver.findElement(By.xpath(Registration_repository.dd_idtype)).sendKeys("Identity");
		//driver.findElement(By.xpath(Registration_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select ID type from \"TypeID\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Documents\\Project\\Home.png");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Click on \"Browse\" button of \"ID Proof\" attachment field and Upload file from device.");
		driver.findElement(By.xpath(Registration_repository.btn_idproof_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-21</b> : Click on \"Next\" button of 2nd screen of \"Registration\" page.");
		driver.findElement(By.xpath(Registration_repository.btn_register)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-22</b> : Click on \"Register\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.val_registration_success)).getText(), "Registration Successful...!");
		driver.findElement(By.xpath(Registration_repository.btn_gotohomepage)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-23</b> : Click on \"Go to Home Page->\" button of register success validation message popup.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.user_profile)).getText(), "Test_995");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should logged into registered user's Home Page of Police Vertical web portal."));
		
	}
	
	@Test(priority=1,description="To verify that user is able to redirect \"Login\" page from any screen of Registration page.")
	public void PV_Registration_2() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.txtbox_firstname)).isDisplayed(), true);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Registration_repository.lnk_Login)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on \"Login\" link from footer of \"Registration\" page.");
		Assert.assertEquals(driver.findElement(By.xpath(Login_repository.txtbox_Username)).isDisplayed(), true);
		Thread.sleep(500);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : </br>1. User is able to click on \"Login\" link.</br>2. User should redirect back to \"Login\" page from any screen of Registration page."));
	}
	
	@Test(priority=2,description="To verify that user is able to perform \"Back\" functionality of \"Registration\" page.")
	public void PV_Registration_3() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_username)).sendKeys("Test_999");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_emailid)).sendKeys("test999@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_password)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_confirmpass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_DOB)).sendKeys("09/07/1997");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_gender)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_state)).sendKeys("Gujarat");
		//driver.findElement(By.xpath(Registration_repository.op_gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.dd_district)).sendKeys("Ahmedabad");
		//driver.findElement(By.xpath(Registration_repository.op_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(Registration_repository.btn_personaldetail_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Click on \"Next\" button.");
		driver.findElement(By.xpath(Registration_repository.btn_idproof_back)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Click on \"Back\" button.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.txtbox_firstname)).isDisplayed(), true);
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get back to the previous screen of \"Registration\" page."));
	}
	
	@Test(priority=3,description="To verify that user gets validation message when perform \"Next\" functionality without entering mandatory field details.")
	public void PV_Registration_4() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.btn_personaldetail_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Click on \"Next\" button without entering mandatory details.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_username)).getText(), "The Username field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_email)).getText(), "The Email Address field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_firstname)).getText(), "The First Name field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_lastname)).getText(), "The Last Name field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_pass)).getText(), "The Password field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_confipass)).getText(), "The Confirm Password field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_DOB)).getText(), "The Date Of Birth field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_add1)).getText(), "The Address Line 1 field is required.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_PINcode)).getText(), "The PIN Code field is required.");
		WebElement e1 = driver.findElement(By.xpath(Registration_repository.validation_phonenum));
		Coordinates co1 = ((Locatable)e1).getCoordinates();
		co1.onPage(); co1.inViewPort();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_phonenum)).getText(), "The Phone Number field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like: </br>\"The Username field is required.\",</br>\"The Email Address field is required.\",</br>\"The First Name field is required.\",</br>\"The Last Name field is required.\",</br>\"The Password field is required.\",</br>\"The Confirm Password field is required.\",</br>\"The Date Of Birth field is required.\",</br>\"The Address Line 1 field is required.\",</br>\"The PIN Code field is required.\",</br>\"The Phone Number field is required.\" below their respective fields."));
	}
	
	@Test(priority=4,description="To verify that user gets validation message when perform \"Next\" functionality without upload attachment in \"ID Proof\" field.")
	public void PV_Registration_5() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_username)).sendKeys("Test_999");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_emailid)).sendKeys("test999@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_password)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_confirmpass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_DOB)).sendKeys("09/07/1997");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_gender)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_state)).sendKeys("Gujarat");
		//driver.findElement(By.xpath(Registration_repository.op_gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.dd_district)).sendKeys("Ahmedabad");
		//driver.findElement(By.xpath(Registration_repository.op_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(Registration_repository.btn_personaldetail_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Click on \"Next\" button.");
		driver.findElement(By.xpath(Registration_repository.btn_idproof_next)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Click on \"Next\" button without upload attachment in \"ID Proof\" field.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_fileupload)).getText(), "The ID Proof field is required.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like : \"The Id Proof field is required.\"."));
	}
	
	@Test(priority=5,description="To verify that user gets validation message for entering invalid \"Username\".")
	public void PV_Registration_6() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_username)).sendKeys("Test 123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> :  Enter invalid username in \"Username\" text-box of \"Register\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_emailid)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_username)).getText(), "Invalid User Name");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid User Name\"."));
	}
	
	@Test(priority=6,description="To verify that user gets validation message for entering invalid \"Email Address\".")
	public void PV_Registration_7() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_emailid)).sendKeys("..test999@gmail.com");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter invalid Email address in \"Email Address\" text-box of \"Register\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_firstname)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_email)).getText(), "Invalid Email Address");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid Email Address\"."));
	}
	
	@Test(priority=7,description="To verify that user gets validation message for mismatch in entered \"Password\" and \"Confirm Password\" fields .")
	public void PV_Registration_8() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_password)).sendKeys("Abc@123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter \"Password\" in \"Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_confirmpass)).sendKeys("Asd@123");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter confirm password in \"Confirm Password\" text-box differ than entered \"Password\".");
		driver.findElement(By.xpath(Registration_repository.dd_gender)).sendKeys("Male");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_confipass)).getText(), "'Confirm Password' and 'Password' do not match.");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"'Confirm Password' and 'Password' do not match.\"."));
	}
	
	@Test(priority=8,description="To verify that user gets validation message for entering invalid \"PIN Code\".")
	public void PV_Registration_9() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_PINcode)).sendKeys("11111");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter invalid PIN Code in \"PIN Code\" text-box of \"Register\" page.");
		driver.findElement(By.xpath(Registration_repository.dd_gender)).sendKeys("Male");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_PINcode)).getText(), "Invalid PIN Code");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Not a valid PIN Code\"."));
	}
	
	@Test(priority=9,description="To verify that user gets validation message for entering invalid \"Phone Number\".")
	public void PV_Registration_10() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		Thread.sleep(3000);
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_phonenum)).sendKeys("1999999999");
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter invalid Phone Number in \"Phone Number\" text-box of \"Register\" page.");
		driver.findElement(By.xpath(Registration_repository.dd_gender)).sendKeys("Male");
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.validation_phonenum)).getText(), "Invalid Mobile Number");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Not a valid Phone Number\"."));
	}
	
	@Test(priority=10,description="To verify that user gets validation message when upload file in \"ID proof\" attachment is more than 2 mb.")
	public void PV_Registration_11() throws InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-1</b> : Open Browser.");
		ExtentTestManager.getTest().log(Status.INFO,"<b>Step-2</b> : Enter the URL of Police Vertical web portal in address-bar of browser and press Enter key.");
		driver.findElement(By.xpath(Login_repository.btn_Login)).click();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1</b> : Click on  \"Login\" link or button from \"Home\" page.");
		driver.findElement(By.xpath(Login_repository.lnk_Register)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2</b> : Click on \"Register\" link from \"Login\" page.");
		driver.findElement(By.xpath(Registration_repository.txtbox_username)).sendKeys("Test_999");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3</b> : Enter \"Username\" in \"Username\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_emailid)).sendKeys("test999@gmail.com");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-4</b> : Enter \"Email Address\" in \"Email Address\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_firstname)).sendKeys("Sneha");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-5</b> : Enter First Name in \"First Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_middlename)).sendKeys("Dineshbhai");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-6</b> : Enter Middle Name in \"Middle Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_lastname)).sendKeys("Vaja");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-7</b> : Enter Last Name in \"Last Name\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_password)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-8</b> : Enter Password in \"Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_confirmpass)).sendKeys("Abc@123");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-9</b> : Enter Confirm Password in \"Confirm Password\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_DOB)).sendKeys("09/07/1997");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-10</b> : Select Date of Birth from \"Date of Birth\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_gender)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-11</b> : Select \"Gender\" from respective dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add1)).sendKeys("123,Vinakunj Society");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-12</b> : Enter Address in \"Address Line 1 \" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_add2)).sendKeys("Ambavadi");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-13</b> : Enter Address in \"Address Line 2\" text-box.");
		driver.findElement(By.xpath(Registration_repository.txtbox_PINcode)).sendKeys("101010");
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-14</b> : Enter \"PIN Code\" in \"PIN Code\" text-box.");
		driver.findElement(By.xpath(Registration_repository.dd_state)).sendKeys("Gujarat");
		//driver.findElement(By.xpath(Registration_repository.op_gujarat)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-15</b> : Select State from \"State\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.dd_district)).sendKeys("Ahmedabad");
		//driver.findElement(By.xpath(Registration_repository.op_ahmedabad)).click();
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-16</b> : Select District/City from \"District/City\" dropdown.");
		driver.findElement(By.xpath(Registration_repository.txtbox_phonenum)).sendKeys("9999999991");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-17</b> : Enter Phone Number in \"Phone Number\" text-box.");
		driver.findElement(By.xpath(Registration_repository.btn_personaldetail_next)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-18</b> : Click on \"Next\" button.");
		driver.findElement(By.xpath(Registration_repository.dd_idtype)).sendKeys("Identity");
		//driver.findElement(By.xpath(Registration_repository.op_idtype_identity)).click();
		Thread.sleep(1000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-19</b> : Select \"ID Proof Type\" from dropdown.");
		driver.findElement(By.xpath(Registration_repository.btn_browse)).sendKeys("C:\\Users\\neha.p\\Videos\\Captures\\test_video.mp4");
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "<b>Step-20</b> : Click on \"Browse\" button and upload file which size is more than 2 mb.");
		Assert.assertEquals(driver.findElement(By.xpath(Registration_repository.val_invalid_fileupload)).getText(), "Invalid File Type");
		ExtentTestManager.getTest().log(Status.INFO, String.format("<b>Result</b> : User should get validation message like \"Invalid File Type\"."));
	}
	

	/*
	@AfterMethod
	public void AfterMethod() throws InterruptedException
	{
		
		driver.close();
		Thread.sleep(1000);	
	}
	*/
	
}
