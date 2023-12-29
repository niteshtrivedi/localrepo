package org.testing.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutPage {

	ChromeDriver driver;
	Properties pr;
	public LogoutPage(ChromeDriver driver,Properties pr) {
		this.driver=driver;
		this.pr=pr;
	}
	public void logout() throws InterruptedException {
		WebElement logout = driver.findElement(By.xpath(pr.getProperty("logout")));
		logout.click();
		Thread.sleep(8000);
		WebElement logoutlink = driver.findElement(By.xpath(pr.getProperty("logoutlink")));
		logoutlink.click();
		
	}
}
