package org.testing.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class videoPlayPage {

	ChromeDriver driver;
	Properties pr;
	public videoPlayPage(ChromeDriver driver,Properties pr) {
		this.driver=driver;
		this.pr=pr;
}
	public void playAvideo() throws InterruptedException {
		WebElement video = driver.findElement(By.xpath(pr.getProperty("video")));
		System.out.println(video.getText());
		System.out.println(video.getAttribute("class"));
		
		video.click();
		Thread.sleep(10000);
		if (video.isSelected()) {
			System.out.println("Video is getting played");
		}else {
			System.out.println("Video is not getting played");
		}
		String actual = driver.findElement(By.xpath(pr.getProperty("video"))).getTagName();
	}
	public void likeAvideo() throws InterruptedException{
		Thread.sleep(10000);
		WebElement like = driver.findElement(By.xpath(pr.getProperty("like")));
		like.click();
		String actual = driver.findElement(By.xpath(pr.getProperty("like"))).getTagName();
	}
	public void subscribeChannel() throws InterruptedException{
		Thread.sleep(10000);
		WebElement subscribe = driver.findElement(By.xpath(pr.getProperty("subscribe")));
		subscribe.click();
		String actual = driver.findElement(By.xpath(pr.getProperty("subscribe"))).getText();
	}
	public void scrollPage() throws InterruptedException{
		Thread.sleep(10000);
		JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(20000);
	}
	
	public void clickOnCommentImage() throws InterruptedException{
		Thread.sleep(10000);
		WebElement commentImage=driver.findElement(By.xpath(pr.getProperty("commentImage")));
		commentImage.click();
		String actual = driver.findElement(By.xpath(pr.getProperty("commentImage"))).getTagName();
	}
	
	public void typeAComment() throws InterruptedException{
		Thread.sleep(10000);
		WebElement commentbox=driver.findElement(By.id(pr.getProperty("commentbox")));
	    commentbox.sendKeys("Nice Video");
	    String actual = driver.findElement(By.id(pr.getProperty("commentbox"))).getTagName();
	}
	
	public void postAComment() throws InterruptedException{
        Thread.sleep(10000);
		WebElement commentButton = driver.findElement(By.xpath(pr.getProperty("commentButton")));
		commentButton.click();
		String actual = driver.findElement(By.xpath(pr.getProperty("commentButton"))).getTagName();
	}
	
	
	
	
}