package org.testing.Testscripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.Base.Base;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Pages.videoPlayPage;
import org.testing.Utilities.LogsCapture;
import org.testing.Utilities.Report;
import org.testing.Utilities.ScreenshotCapture;
import org.testing.assertion.Assertt;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC5 extends Base{
	
	@Test
	public void Test5() throws InterruptedException, IOException {
		ExtentReports ex =Report.HandleReport();
		ExtentTest extentTest =ex.startTest("TestCase5");
		Boolean result = null;
		try 
		{
		LoginPage login =new LoginPage(driver,pr);
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase5");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case5 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		login.signin("nhmt8784@gmail.com", "Test@1234");
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fifthtc.png");
		LogsCapture.takeLog("TestCase5","Login successfully for TC5" );
		Thread.sleep(4000);
		videoPlayPage video =new videoPlayPage(driver,pr);
		result=Assertt.assertion1(driver.findElement(By.xpath(pr.getProperty("video"))).getTagName(),"yt-formatted-string","TestCase5");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case5 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		video.playAvideo();
		
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fifthtc1.png");
		LogsCapture.takeLog("TestCase5","Video Play successfully for TC5" );
		Thread.sleep(4000);
		videoPlayPage subscribe =new videoPlayPage(driver,pr);
		result=Assertt.assertion1(driver.findElement(By.xpath(pr.getProperty("subscribe"))).getTagName(),"div","TestCase5");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case5 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		subscribe.subscribeChannel();
		
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fifthtc2.png");
		LogsCapture.takeLog("TestCase5","Click on subcription successfully for TC5" );
		Thread.sleep(4000);
		LogoutPage logout =new LogoutPage(driver,pr);
		logout.logout();
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase5");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case5 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fifthtc3.png");
		LogsCapture.takeLog("TestCase5","Logout successfully for TC5" );
	}
		catch (Exception e) {
			ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fifthtc_failed.png");
			extentTest.log(LogStatus.FAIL,"Test case5 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		extentTest.log(LogStatus.PASS,"Test case5 is Passed");
		ex.endTest(extentTest);
		ex.flush();
	}

}

