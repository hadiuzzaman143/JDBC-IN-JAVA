package com.studentcodes.student;

import java.sql.*;
public class CP {
	static Connection con;
	public static Connection createc() 
    {
		
		try {
			
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//create the Connection
			String user = "root"; //user of mysql
			String password =""; //password of mysql
			String url = "jdbc:mysql://localhost:3307/student";
			con = DriverManager.getConnection(url,user,password);
			
			
		}catch(Exception e) 
        {
			e.printStackTrace();
		}
		return con;
		
	}
}