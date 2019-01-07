package com.sid.poc.awsAthenaConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	static String PropertyFile="aws.properties";
	
	public static String ACCESS_KEY="ACCESS_KEY";
	public static String SECRET_KEY="SECRET_KEY";
	public static String REGION="REGION";
	public static String S3Location="S3Location";
	
	public static String getProperty(String PropertyName){		
		Properties prop = new Properties();
		FileInputStream propFile = null;
		try {
			propFile = new FileInputStream(PropertyFile);
			prop.load(propFile);
			return prop.getProperty(PropertyName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(propFile!=null) {
				try {
					propFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
