package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
	private static final String DRIVER_PATH="com.mysql.cj.jdbc.Driver";
	private static final String DataBase_URL="jdbc:mysql://localhost:3306/jdbcdb";
	private static final String DataBase_USERNAME="root";
	private static final String DataBase_PASSWORD="Aditya@2002";
	

	public DatabaseUtil()
	{
		try
		{
			
			Class.forName(DRIVER_PATH);
		}
		catch (Exception  e) 
		{
			System.out.println("something went wrong");
			
		}
	}
	public Connection getConnection() throws SQLException
	{
		
		 return DriverManager.getConnection(DataBase_URL,DataBase_USERNAME,DataBase_PASSWORD );
		
		
	}

}
