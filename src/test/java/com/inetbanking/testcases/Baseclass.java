package com.inetbanking.testcases;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//COMMON RESOURCES ARE AVAILABLE IN BASE CLASS
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.PropertyConfigurator;

public class Baseclass {
	public String baseURL="https://demo.guru99.com/V1/index.php";
	public String username="mngr382063";
	public String password="ehEqysA";
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		// to instantiation the chrome browser
		driver=new ChromeDriver();
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver,String tname)throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshot as taken");
		
	}

}
