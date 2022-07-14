package com.cognixia.jump.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/shows";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Redocean64!";

	public static Connection getConnection() {

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected to " + URL);

		} catch (SQLException e) {
			System.out.println("Could not connect, see message: " + e.getMessage());
		}

		return conn;

	}

	public static void main(String[] args) {

		Connection conn = ConnectionManager.getConnection();

		try {

			conn.close();
			System.out.println("Connection closed.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
