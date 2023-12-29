package org.testing.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	ChromeDriver driver;
	Properties pr;
	public LoginPage(ChromeDriver driver,Properties pr) {
		this.driver=driver;
		this.pr=pr;
	}
	public void signin(String userName,String password) throws InterruptedException {
		
		
		WebElement signin = driver.findElement(By.linkText(pr.getProperty("signin")));
		signin.click();
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath(pr.getProperty("email")));
		email.sendKeys("nhmt8784@gmail.com");
		Thread.sleep(2000);
		WebElement next = driver.findElement(By.xpath(pr.getProperty("next")));
		next.click();
		Thread.sleep(4000);
		WebElement pass = driver.findElement(By.xpath(pr.getProperty("password")));
		pass.sendKeys("Test@1234");
		Thread.sleep(4000);
		WebElement next1 = driver.findElement(By.xpath(pr.getProperty("next1")));
		next1.click();
	}
}
