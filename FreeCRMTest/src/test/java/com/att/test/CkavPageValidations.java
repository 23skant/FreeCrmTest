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

    private WebDriver driver;
    CommonMethods commonfunction;
   
	
	@BeforeMethod
	public void LaunchBrowser() {
		com.att.CommonMethods commonfunction = new com.att.CommonMethods(driver);
		driver = (WebDriver) commonfunction.LaunchBrowser("chrome");
		
	}
	
	@Test(priority = 1,description = "ckav page test")
	public void CkavPageContinue() {
		
		com.att.CheckAvailPage ckavpage = new com.att.CheckAvailPage(driver);
		Assert.assertTrue(ckavpage.isCKAVpageDisplay());
		Assert.assertTrue(ckavpage.enterZip());
		Assert.assertTrue(ckavpage.enterAddress());
		Assert.assertTrue(ckavpage.ckavClick());
	
		com.att.ShopOffersPage offers = new com.att.ShopOffersPage(driver);
		Assert.assertTrue(offers.isShopPageDisplay());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
