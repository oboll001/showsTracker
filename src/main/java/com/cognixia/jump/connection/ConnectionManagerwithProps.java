package com.cognixia.jump.connection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManagerwithProps {

    // self composition 
	private static Connection connection = null;
	
	private ConnectionManagerwithProps() {};
	
	private static void makeConnection() {
		
		Properties props = new Properties(); 
		
		try {
			props.load(new FileInputStream("src/resources/config.properties"));
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			makeConnection();
		}
		
		return connection;
	}

}

    

