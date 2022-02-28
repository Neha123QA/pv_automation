package pv_admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class temp
{
	@Test
	public void test(ITestContext context) throws InterruptedException {
	WebDriver driver;
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  context.setAttribute("WebDriver", driver);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://sc1dehradun.sgligis.com//");
	  driver.findElement(By.xpath( "//a[text()=\"Sign In\"]")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@data-val-required=\"Please Enter Valid Username\"]")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@data-val-required=\"Please Enter valid Password\"]")).sendKeys("Abc@1234");
	  driver.findElement(By.xpath("//button[text()=\"Sign in \"]")).click();
	  Thread.sleep(5000);
  //  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-1:</b> Click on Expand icon of the \"User Management\" from the Main Panel.");
	  //driver.findElement(By.xpath("//div/span[text()=\"User Management\"]")).click();
	  
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-2:</b> Select \"Add Groups\".");
	  driver.findElement(By.xpath("//div/span[text()=\"Add Group\"]" )).click();
	  Thread.sleep(2000);
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Step-3:</b> Drag particular layer from the layer list and drop into the particular group.");
	  WebElement LocatorFrom=driver.findElement(By.xpath("//span[@id='abd_connectivity_drain']"));		
      WebElement LocatorTo=driver.findElement(By.xpath("//th[@id='group_Testing']/ul[@data-empty-message=\"Drop your layer here . . .\"]"));	
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",LocatorFrom, LocatorTo);
      Thread.sleep(4500);
      
	//  ExtentTestManager.getTest().log(Status.INFO, "<b>Result:</b> Drag particular layer from the layer list and drop into the particular group.");
  Assert.assertEquals(true, driver.findElement(By.xpath("//p[text()=\"Layer is Added Into Group Successfully.\"]")).isDisplayed()); 
}}