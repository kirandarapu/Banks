package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			//to instantiate the pro object
			pro=new Properties();
			pro.load(fis);
		} catch(Exception e)
		{
			System.out.println("exception is :"+ e.getMessage());
		}
	}

}
