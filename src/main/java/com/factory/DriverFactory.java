package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	
	
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<>();
	public WebDriver init_driver(String browser)
	{
		System.out.println("Driver name which we using"+browser);
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tdriver.set(new ChromeDriver());
		}
		else if(browser.equals("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tdriver.set(new FirefoxDriver());
		}
		else if(browser.equals("Safari"))
		{
			tdriver.set(new SafariDriver());
		}
		
		else
		{
			System.out.println("kindly pass valid name of browser"+browser);
		}
	
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	/*
	 * use to get the driver with threadlocal
	  */
	
	public static synchronized WebDriver getDriver()
	{		
		return tdriver.get();
		
	}
	
	
}
