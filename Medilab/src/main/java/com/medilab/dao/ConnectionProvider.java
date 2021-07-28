package com.medilab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection con;

//DB connection
	public static Connection getConnection() throws Exception {

		if (con == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medilab", "root", "mysql20apr2021");

		}

		return con;

	}

}
