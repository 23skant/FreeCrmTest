package com.att;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class CommonMethods {
	
	WebDriver driver;

	
	public CommonMethods(WebDriver webDriver) {
		this.driver = webDriver;
	
		
	}
	

	public void fCommonSync(long sTime) {
		try {
			Thread.sleep(sTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void LaunchBrowser(String browser) {
		String chromedriverpath = "C:\\Users\\shakant\\Desktop\\java\\chromedriver_win32\\chromedriver.exe";
		String firefoxdriverpath = "C:\\Users\\shakant\\Desktop\\java\\geckodriver\\geckodriver.exe";
	
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("headless")) {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			driver = new ChromeDriver(option);
			
		}
		
         else if(browser.equalsIgnoreCase("firefox")) {
        	 System.setProperty("webdriver.geko.driver", firefoxdriverpath);
     		driver = new FirefoxDriver();
			
		}
     	else if(browser.equalsIgnoreCase("incognito")) {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			ChromeOptions option = new ChromeOptions();
			option.addArguments("-incognito");
			driver = new ChromeDriver(option);
			
		}
		driver.get("https://www.att.com/shop/unified/availability.html?filter_id=1400014&destination_page=OFP&product_suite=DTV&referral_app_id=att.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}

}