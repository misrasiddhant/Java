package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sid.poc.awsAthenaConnection.ReadProperties;
import com.sid.poc.awsAthenaConnection.connectAwsServices;



public class TTestConnection {
	
		public static void main(String[] args) throws SQLException {
		
		String ACCESS_KEY = ReadProperties.getProperty(ReadProperties.ACCESS_KEY);
		String SECRET_KEY = ReadProperties.getProperty(ReadProperties.SECRET_KEY);
		String REGION = ReadProperties.getProperty(ReadProperties.REGION);
		String S3Location = ReadProperties.getProperty(ReadProperties.S3Location);

		
		Connection connection = new connectAwsServices(ACCESS_KEY, SECRET_KEY, REGION).connectAthena(S3Location);
		
		Statement statement = connection.createStatement();
		ResultSet queryResults = statement.executeQuery("SELECT * FROM person_info_default");
		while(queryResults.next()) {
			System.out.println(queryResults.getString(1));
		}
		
	}
}
