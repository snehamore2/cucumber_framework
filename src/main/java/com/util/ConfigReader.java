package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	public Properties init_prop() 
	{
		//this method used to load the properties from config.properties file.
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
			
			prop.load(ip);
			System.out.println("*******************************"+ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
		}
		return prop;
		
	}
	
}
