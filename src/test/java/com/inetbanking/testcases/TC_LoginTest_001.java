package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbankins.pageobjects.LoginPage;

public class TC_LoginTest_001 extends Baseclass
{
	@Test
	public void logintest() throws IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
				lp.setUserNam(username);
				logger.info("enter username");
		        lp.setPassword(password);
		        logger.info("enter password");
		        lp.clickSubmit();
		        logger.info("click login button");
		 //to verify the Title        
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))  
		{
			Assert.assertTrue(true);
			logger.info("testcase is passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("testcase is failed");
		}
	}

}
