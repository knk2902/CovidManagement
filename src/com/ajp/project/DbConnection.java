package com.ajp.project;

import java.sql.*;

public class DbConnection{
	public static Connection Connectiontodatabase() throws Exception{
		
	
		String url="jdbc:mysql://localhost:3306/covid";
		String user="root";
		String password = "1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection(url,user,password);
		
		
		return connect;
		
	}
}