package com.sid.poc.awsAthenaConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connectAwsServices {
	
	String DRIVER_NAME="com.simba.athena.jdbc.Driver";
	String CONNECTION_URL="jdbc:awsathena://AwsRegion=";
	String REGION="";
	String ACCESS_KEY="";
	String SECRET_KEY="";
	
	public connectAwsServices(String ACCESS_KEY, String SECRET_KEY, String REGION) {
		this.ACCESS_KEY=ACCESS_KEY;
		this.SECRET_KEY=SECRET_KEY;
		this.REGION=REGION;
	}
	
	
	public Connection connectAthena(String S3Location) {
		
		Connection connection = null;
		
		Properties info = new Properties(); 
		info.put("UID", ACCESS_KEY); 
		info.put("PWD", SECRET_KEY);
		info.put("S3OutputLocation", S3Location); 
		info.put ("AwsCredentialsProviderClass","com.simba.athena.amazonaws.auth.PropertiesFileCredentialsProvider");
		info.put("Schema", "Mockaroo");
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection (CONNECTION_URL+REGION+";", info);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
