package com.att;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckAvailPage {
	
	
	private WebDriver d;
	private String zip = "//*[@id='zipcode']";
	private String address = "//*[@id='streetaddress']";
	private String ckav_btn = "//*[@title='Continue to packages']";
	
	
	
	public CheckAvailPage(WebDriver driver) {
		this.d = driver;
	}
	
	public boolean isCKAVpageDisplay() {
		System.out.println("hi");
		boolean bl = d.findElement(By.xpath(ckav_btn)).isDisplayed();
		if(bl==false) {
			System.out.println("CKAV page not displayed");
			return false;
		}
		System.out.println("CKAV page  displayed");
		return true;
		
	}

	
	public boolean enterZip() {
		
		WebElement el = d.findElement(By.xpath(zip));
		if(el==null) {
			System.out.println("zip is not present");
			return false;
		}
		el.sendKeys("91911");
		return true;
	
	}
}

