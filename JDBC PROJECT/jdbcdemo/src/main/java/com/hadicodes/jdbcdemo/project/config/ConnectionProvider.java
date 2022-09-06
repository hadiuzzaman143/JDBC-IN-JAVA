package com.hadicodes.jdbcdemo.project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider 
{
    public static Connection makeConnection_Oracle() throws SQLException 
	{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##scott", "tiger");
	}

	public static Connection makeConnection_Mysql() throws SQLException 
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
	} 
}
