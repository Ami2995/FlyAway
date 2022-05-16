package com.java.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/flyaway";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "admin";
	public static Connection con = null;

	public static Connection dbconn() {
		try {
			// register the vendor driver
			Class.forName("com.mysql.jdbc.Driver");
			// establish the connection
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

}
