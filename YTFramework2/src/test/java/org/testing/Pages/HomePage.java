package org.testing.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

    public class HomePage {
	ChromeDriver driver;
	Properties pr;
	public HomePage(ChromeDriver driver,Properties pr) {
		this.driver=driver;
		this.pr=pr;
	}
	public void clicktrending() throws InterruptedException {
		Thread.sleep(2000);
		WebElement tranding = driver.findElement(By.linkText(pr.getProperty("trending")));
		tranding.click();
		String actual = driver.findElement(By.linkText(pr.getProperty("trending"))).getText();
		
	}
	public void clickHistory() throws InterruptedException {
		Thread.sleep(2000);
		WebElement history = driver.findElement(By.linkText(pr.getProperty("history")));
		history.click();
		String actual = driver.findElement(By.linkText(pr.getProperty("history"))).getText();
	}
	public void clickSubscription() throws InterruptedException {
		Thread.sleep(2000);
		WebElement subscriptions = driver.findElement(By.linkText(pr.getProperty("subscriptions")));
		subscriptions.click();
		String actual = driver.findElement(By.linkText(pr.getProperty("subscriptions"))).getText();
	}
	public void clickWatchLater() throws InterruptedException {
		Thread.sleep(2000);
		WebElement watch = driver.findElement(By.linkText(pr.getProperty("watch")));;
		watch.click();
		String actual = driver.findElement(By.linkText(pr.getProperty("watch"))).getText();
	}
	public void clickLibrary() throws InterruptedException {
		Thread.sleep(2000);
		WebElement library = driver.findElement(By.xpath(pr.getProperty("library")));
		library.click();
		String actual = driver.findElement(By.linkText(pr.getProperty("watch"))).getTagName();
	}
}
