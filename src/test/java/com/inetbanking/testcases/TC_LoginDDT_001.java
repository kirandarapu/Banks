package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.utilities.XLUtils;
import com.inetbankins.pageobjects.LoginPage;

public class TC_LoginDDT_001 extends Baseclass {
	@Test(dataProvider="LoginData1")
	
	public void loginDDT(String uname,String pwd) {
		LoginPage lp=new LoginPage(driver);
		lp.setUserNam(uname);
		lp.setPassword(pwd);
		lp.clickSubmit();
		 
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("login passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert().accept();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	
	
	
	@DataProvider(name="LoginData1")
	String[][] getData() throws IOException{
		String path=System.getProperty(("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testdata\\LoginData1.xlsx");
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		//to create two dimensional array
		String loginData[][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				 loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);// i==1,j==0
				 
			}
		}
		return loginData;
		
	}

}
