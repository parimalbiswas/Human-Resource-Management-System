package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil
{

	public static Connection provideConnection()
	{
		Connection connection = null;

		String url = "jdbc:mysql://localhost:3306/HRMS";

		try
		{
			connection = DriverManager.getConnection(url, "root", "India@4444");
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}

		return connection;
	}
}
