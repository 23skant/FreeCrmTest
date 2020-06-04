package com.att.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.att.CommonMethods;


public class CkavPageValidations {

    WebDriver driver;
  
	
	@BeforeMethod
	public void LaunchBrowser() {
		com.att.CommonMethods commonfunction = new com.att.CommonMethods(driver);
		commonfunction.LaunchBrowser("incognito");
	}
	
	@Test(priority = 1,description = "ckav page test")
	public void CkavPageCOntinue() {
		
		com.att.CheckAvailPage ckavpage = new com.att.CheckAvailPage(driver);
		Assert.assertTrue(ckavpage.isCKAVpageDisplay());
		Assert.assertTrue(ckavpage.enterZip());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
