package com.Actitime.GenericLibrary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass 
{
	public static WebDriver driver;
	@BeforeSuite
	public void databaseConnected()
	{
		Reporter.log("database is connected",true);
	}
	
	@AfterSuite
	public void databaseDisconnected()
	{
		Reporter.log("database is disconnected",true);
	}
	
	@BeforeTest
		public void launchBrowser()
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(option);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
					
		}
	
	@AfterTest
	
	public void closeBrowser()
	{
 
	driver.close();
	Reporter.log("browser closed Successfully",true);
	}

	
	@BeforeMethod
	public void login()
	{
		driver.get("https://demo.actitime.com");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		
		Reporter.log("Login Successfully",true);
	}
	
	@Test
	
	@AfterMethod
	public void logout() { 
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out Successfully ",true);
	}
	}



