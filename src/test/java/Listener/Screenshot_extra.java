package Listener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Screenshot_extra {

	public void Screenshotnew(WebDriver driver,String ClassName,String method) 
	{
										
                                        String targetLocation = null;

                                        String testClassName =ClassName;
                                        String testMethodName = method;
                                        String screenShotName = testMethodName  + ".png";
                                        String fileSeperator = System.getProperty("file.separator");
                                        String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
                                                                        + "screenshots-Pass";
                                        //log.info("Screen shots reports path - " + reportsPath);
                                        try {
                                                        File file = new File(reportsPath + fileSeperator + testClassName); // Set
                                                                                                                                                                                                                                                                                                                                        // screenshots
                                                                                                                                                                                                                                                                                                                                        // folder
                                                        if (!file.exists()) {
                                                                        if (file.mkdirs()) {
                                                                                        //log.info("Directory: " + file.getAbsolutePath() + " is created!");
                                                                        } else {
                                                                                        //log.info("Failed to create directory: " + file.getAbsolutePath());
                                                                        }

                                                        }

                                                        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                                        targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenShotName;// define
                                                                                                                                                                                                                                                                                                                                                                                                                                                        // location
                                                        File targetFile = new File(targetLocation);
                                                        //log.info("Screen shot file location - " + screenshotFile.getAbsolutePath());
                                                        //log.info("Target File location - " + targetFile.getAbsolutePath());
                                                        FileHandler.copy(screenshotFile, targetFile);

                                        } catch (FileNotFoundException e) {
                                                        //log.info("File not found exception occurred while taking screenshot " + e.getMessage());
                                        } catch (Exception e) {
                                                        //log.info("An exception occurred while taking screenshot " + e.getCause());
                                        }

                                        // attach screenshots to report
                                        try {
                                                        ExtentTestManager.getTest().pass("Screenshot",
                                                                                        MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
                                        } catch (IOException e) {
                                                        //log.info("An exception occured while taking screenshot " + e.getCause());
                                        }
                                        //ExtentTestManager.getTest().log(Status.PASS, "Test Pass");
//    System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
//    ExtentTestManager.getTest().log(Status.PASS, "Test passed");
}
}
