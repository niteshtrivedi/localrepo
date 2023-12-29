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


public class TC6 extends Base {
	@Test
	public void Test6() throws InterruptedException, IOException {
		ExtentReports ex =Report.HandleReport();
		ExtentTest extentTest =ex.startTest("TestCase6");
		Boolean result = null;
		try 
		{
		LoginPage login =new LoginPage(driver,pr);
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase6");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case6 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		login.signin("nhmt8784@gmail.com", "Test@1234");
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc.png");
		LogsCapture.takeLog("TestCase6","Login successfully for TC6" );
		Thread.sleep(10000);
		
		videoPlayPage video =new videoPlayPage(driver,pr);
		result=Assertt.assertion1(driver.findElement(By.xpath(pr.getProperty("video"))).getTagName(),"yt-formatted-string","TestCase6");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case6 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		video.playAvideo();
		
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc1.png");
		LogsCapture.takeLog("TestCase6","Video Play successfully for TC6" );
		Thread.sleep(20000);
		videoPlayPage scrollPage =new videoPlayPage(driver,pr);
		scrollPage.scrollPage();
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc2.png");
		LogsCapture.takeLog("TestCase6","Scroll the page successfully for TC6" );
		Thread.sleep(10000);
		videoPlayPage clickOnCommentImage =new videoPlayPage(driver,pr);
		result=Assertt.assertion1(driver.findElement(By.xpath(pr.getProperty("commentImage"))).getTagName(),"div","TestCase6");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case6 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		clickOnCommentImage.clickOnCommentImage();
		
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc3.png");
		LogsCapture.takeLog("TestCase6","Click on comment successfully for TC6" );
		Thread.sleep(10000);
		videoPlayPage typeAComment =new videoPlayPage(driver,pr);
		typeAComment.typeAComment();
		result=Assertt.assertion1(driver.findElement(By.id(pr.getProperty("commentbox"))).getTagName(),"div","TestCase6");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case6 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc4.png");
		LogsCapture.takeLog("TestCase6","Type a Comment successfully for TC6" );
		Thread.sleep(10000);
		videoPlayPage postAComment =new videoPlayPage(driver,pr);
		postAComment.postAComment();
		result=Assertt.assertion1(driver.findElement(By.xpath(pr.getProperty("commentButton"))).getTagName(),"ytd-button-renderer","TestCase6");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case6 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc5.png");
		LogsCapture.takeLog("TestCase6","Post a Comment successfully for TC6" );
		Thread.sleep(20000);
		LogoutPage logout =new LogoutPage(driver,pr);
		logout.logout();
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase6");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case6 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc6.png");
		LogsCapture.takeLog("TestCase6","Logout successfully for TC6" );
        
	}
		catch (Exception e) {
			ScreenshotCapture.takeScreenshot(driver, "D://screenshot//sixthtc_failed.png");
			extentTest.log(LogStatus.FAIL,"Test case6 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		extentTest.log(LogStatus.PASS,"Test case6 is Passed");
		ex.endTest(extentTest);
		ex.flush();
	}

	
}
