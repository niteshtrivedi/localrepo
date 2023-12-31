package org.testing.Testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testing.Base.Base;
import org.testing.Pages.HomePage;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Utilities.LogsCapture;
import org.testing.Utilities.Report;
import org.testing.Utilities.ScreenshotCapture;
import org.testing.assertion.Assertt;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC1 extends Base {
	
	@Test
	public void Test1() throws InterruptedException, IOException {
		ExtentReports ex =Report.HandleReport();
		ExtentTest extentTest =ex.startTest("TestCase1");
		Boolean result = null;
		try 
		
		{
		
		LoginPage login =new LoginPage(driver,pr);
		//Assert.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/");
		result=Assertt.assertion1(driver.getCurrentUrl(), "https://www.youtube.com/", "TestCase1");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case1 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		login.signin("nhmt8784@gmail.com", "Test@1234");
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//firsttc.png");
		LogsCapture.takeLog("TestCase1","Login successfully for TC1" );
		Thread.sleep(4000);
		HomePage home =new HomePage(driver,pr);
		home.clicktrending();
		result=Assertt.assertion1(driver.findElement(By.linkText(pr.getProperty("trending"))).getText(), "Trending","TestCase1");
		if(result)
		{
			extentTest.log(LogStatus.FAIL,"Test case1 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//firsttc_1.png");
		LogsCapture.takeLog("TestCase1","Click on Trending successfully for TC1" );
		Thread.sleep(4000);
		LogoutPage logout =new LogoutPage(driver,pr);
		logout.logout();
		result=Assertt.assertion1(driver.getCurrentUrl(), "https://www.youtube.com/", "TestCase1");
		if(result)
		{
			extentTest.log(LogStatus.FAIL,"Test case1 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//firsttc_2.png");
		LogsCapture.takeLog("TestCase1","Logout successfully for TC1" );
	}
	
		catch (Exception e) {
			ScreenshotCapture.takeScreenshot(driver, "D://screenshot//firsttc_failed.png");
			extentTest.log(LogStatus.FAIL,"Test case1 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
	   extentTest.log(LogStatus.PASS,"Test case1 is Passed");
	   ex.endTest(extentTest);
	   ex.flush();
	}
}