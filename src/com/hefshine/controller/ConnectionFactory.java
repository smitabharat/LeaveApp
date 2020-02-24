package com.hefshine.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	
	public static final String url ="jdbc:mysql://localhost:3306/rupali";
	public static final String username="root";
	public static final String password="root";
	Connection con;
	
	public ConnectionFactory()
	{
		con=null;
	}
	public boolean connect()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url,username,password);
			if(con!=null)
			{
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Connection getConnection()
	{
		return con;
	}
	public void closeConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
