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
import org.testing.Pages.HomePage;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Utilities.LogsCapture;
import org.testing.Utilities.Report;
import org.testing.Utilities.ScreenshotCapture;
import org.testing.assertion.Assertt;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC8 extends Base {
	
	@Test
	public void Test8() throws InterruptedException, IOException {
		ExtentReports ex =Report.HandleReport();
		ExtentTest extentTest =ex.startTest("TestCase8");
		Boolean result = null;
		try 
		{
		LoginPage login =new LoginPage(driver,pr);
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase8");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case8 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		login.signin("nhmt8784@gmail.com", "Test@1234");
		
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//eightthtc.png");
		LogsCapture.takeLog("TestCase8","Login successfully for TC8" );
		Thread.sleep(4000);
		HomePage home =new HomePage(driver,pr);
		home.clickLibrary();
		result=Assertt.assertion1(driver.findElement(By.linkText(pr.getProperty("watch"))).getTagName(), "a", "TestCase8");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case8 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//eightthtc1.png");
		LogsCapture.takeLog("TestCase8","Click on library successfully for TC8" );
		Thread.sleep(4000);
		LogoutPage logout =new LogoutPage(driver,pr);
		logout.logout();
		result=Assertt.assertion1(driver.getCurrentUrl(),"https://www.youtube.com/","TestCase8");
		if(result==false)
		{
			extentTest.log(LogStatus.FAIL,"Test case8 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}
		ScreenshotCapture.takeScreenshot(driver, "D://screenshot//eightthtc2.png");
		LogsCapture.takeLog("TestCase8","Logout successfully for TC8" );
	
	}
		catch (Exception e) {
			ScreenshotCapture.takeScreenshot(driver, "D://screenshot//eightthtc_failed.png");
			extentTest.log(LogStatus.FAIL,"Test case8 is Failed");
			ex.endTest(extentTest);
		    ex.flush();
		    Assert.assertTrue(result);
		}

	}
}
