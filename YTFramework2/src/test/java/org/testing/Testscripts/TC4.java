package org.testing.Testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testing.Base.Base;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Pages.videoPlayPage;
import org.testing.Utilities.LogsCapture;
import org.testing.Utilities.Report;
import org.testing.Utilities.ScreenshotCapture;
import org.testing.assertion.Assertt;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC4 extends Base {
	
	@Test
	public void Test4() throws InterruptedException, IOException {
		ExtentReports ex =Report.HandleReport();
		ExtentTest extentTest =ex.startTest("TestCase4");
		Boolean result = null;
		try 
		{
		LoginPage login =new LoginPage(driver,pr);
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase4");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case4 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		login.signin("nhmt8784@gmail.com", "Test@1234");
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fourthtc.png");
		LogsCapture.takeLog("TestCase4","Login successfully for TC4" );
		Thread.sleep(4000);
		videoPlayPage video =new videoPlayPage(driver,pr);
		video.playAvideo();
		result=Assertt.assertion1(driver.findElement(By.xpath(pr.getProperty("video"))).getTagName(),"yt-formatted-string","TestCase4");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case4 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		Thread.sleep(4000);
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fourthtc1.png");
		LogsCapture.takeLog("TestCase4","Video Play successfully for TC4" );
		Thread.sleep(4000);
		videoPlayPage like =new videoPlayPage(driver,pr);
		like.likeAvideo();
		result=Assertt.assertion1(driver.findElement(By.xpath(pr.getProperty("like"))).getTagName(),"like-button-view-model","TestCase4");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case4 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fourthtc2.png");
		LogsCapture.takeLog("TestCase4","Click on Like successfully for TC4" );
		Thread.sleep(4000);
		LogoutPage logout =new LogoutPage(driver,pr);
		logout.logout();
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase4");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case4 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fourthtc3.png");
		LogsCapture.takeLog("TestCase4","Logout successfully for TC4" );

	}
	
	catch (Exception e) {
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//fourthtc_failed.png");
		extentTest.log(LogStatus.FAIL,"Test case4 is Failed");
		ex.endTest(extentTest);
	    ex.flush();
	    Assert.assertTrue(result);
	}
		extentTest.log(LogStatus.PASS,"Test case4 is Passed");
		ex.endTest(extentTest);
		ex.flush();
}
}
