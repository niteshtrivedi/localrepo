package org.testing.Testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC3 extends Base {
	
	@Test
	public void Test3() throws InterruptedException, IOException {
		ExtentReports ex =Report.HandleReport();
		ExtentTest extentTest =ex.startTest("TestCase3");
		Boolean result = null;
		try 
		{
		LoginPage login =new LoginPage(driver,pr);
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase3");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case3 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		login.signin("nhmt8784@gmail.com", "Test@1234");
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//thirdtc.png");
		LogsCapture.takeLog("TestCase3","Login successfully for TC3" );
		Thread.sleep(4000);
		HomePage home =new HomePage(driver,pr);
		home.clickSubscription();
		result=Assertt.assertion1(driver.findElement(By.linkText(pr.getProperty("subscriptions"))).getText(), "Subscriptions", "TestCase3");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case2 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//thirdtc1.png");
		LogsCapture.takeLog("TestCase3","Click on Subscription successfully for TC3" );
		Thread.sleep(4000);
		LogoutPage logout =new LogoutPage(driver,pr);
		logout.logout();
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase3");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case3 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//thirdtc2.png");
		LogsCapture.takeLog("TestCase3","Logout successfully for TC3" );
	}
	
		catch (Exception e) {
			ScreenshotCapture.takeScreenshot(driver, "D://screenshot//thirdtc_failed.png");
			extentTest.log(LogStatus.FAIL,"Test case3 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		extentTest.log(LogStatus.PASS,"Test case3 is Passed");
		ex.endTest(extentTest);
		ex.flush();
	}
}
