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
		System.out.println("zip details entered");
		return true;
	
	}
	
     public boolean enterAddress() {
		
		WebElement el = d.findElement(By.xpath(address));
		if(el==null) {
			System.out.println("address line is not present");
			return false;
		}
		el.sendKeys("952 helix ave");
		System.out.println("address details entered");
		return true;
	
	}
     
     public boolean ckavClick() {
 		
 		WebElement el = d.findElement(By.xpath(ckav_btn));
 		if(el==null) {
 			System.out.println("CKAV button is not preset");
 			return false;
 		}
 		el.click();
 		System.out.println("Clicked on CKAV button");
 		return true;
 	
 	}
}

