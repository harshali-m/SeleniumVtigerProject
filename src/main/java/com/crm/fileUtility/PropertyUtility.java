package com.crm.fileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
//	public static  String InputData(String key) throws IOException {
//		
//		Properties prop = new Properties();
//		
//		FileInputStream fis = new FileInputStream("C:\\selenium\\com.crm.Vtiger\\src\\test\\resources\\ConfigureFile\\PropertiesFile.properties");
//		
//		prop.load(fis);
//		
//		String data = prop.getProperty(key);
//		return data;
//	}

	public static String InputData(String key) throws IOException {
        Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ConfigureFile\\PropertyFile.properties");
		
		prop.load(fis);
		
		String data = prop.getProperty(key);
		return data;}

}
