package com.att;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CommonMethods {
	
	private WebDriver gdriver;

	
	public CommonMethods(WebDriver driver) {
		this.gdriver = driver;
	
		
	}
	

	public void fCommonSync(long sTime) {
		try {
			Thread.sleep(sTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver LaunchBrowser(String browser) {
		String chromedriverpath = "C:\\Users\\shakant\\Desktop\\java\\chromedriver_win32\\chromedriver.exe";
		String firefoxdriverpath = "C:\\Users\\shakant\\Desktop\\java\\geckodriver\\geckodriver.exe";
	
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			gdriver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("headless")) {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			gdriver = new ChromeDriver(option);
			
		}
		
         else if(browser.equalsIgnoreCase("firefox")) {
        	 System.setProperty("webdriver.geko.driver", firefoxdriverpath);
        	 gdriver = new FirefoxDriver();
			
		}
     	else if(browser.equalsIgnoreCase("incognito")) {
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			ChromeOptions option = new ChromeOptions();
			option.addArguments("-incognito");
			gdriver = new ChromeDriver(option);
			
		}
		gdriver.get("https://www.att.com/shop/unified/availability.html?filter_id=1400014&destination_page=OFP&product_suite=DTV&referral_app_id=att.com");
		gdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		gdriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return gdriver;
		
	}
	
	public void fcommonwait(String element, int time) {
		WebElement el = gdriver.findElement(By.xpath(element));
		WebDriverWait wait = new WebDriverWait(gdriver, time);
		wait.until(ExpectedConditions.elementToBeClickable(el));
		
		
	}
	
	public boolean WaitForSpinnerToLoaded() {
		try {
			for (int i = 0; i <= 7000; i++) {
				WebElement webSpinner = gdriver.findElement(By.xpath("xpath:=//*[@class='spinner']"));
					
				if (!(webSpinner == null)) {
					if (!webSpinner.isEnabled()) {
						System.out.println("checkPageContainsText - WebElement found successful - has delayed with --> "+ (System.currentTimeMillis()) + "ms");
								
						break;
					} else {
						System.out.println("Holds because of spinner");
						i++;
					}
				} else {
					System.out.println("checkPageContainsText - WebElement found successful - has delayed with --> "
							+ (System.currentTimeMillis()) + "ms" );
							
					break;
				}
			}
		} catch (Exception e) {

		}
		return true;
	}

	
	
}