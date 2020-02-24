package com.hefshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hefshine.bean.User;
import com.hefshine.controller.ConnectionFactory;

public class UserDAO 
{
public boolean insert(User user)
{
	ConnectionFactory con_factory=new ConnectionFactory();
	boolean result=con_factory.connect();
	Connection con=null;
	if(result==true)
	{
		con=con_factory.getConnection();
	}
	String query="insert into user3(uname,password,role,status) values(?,?,?,?)";
			try
	{
PreparedStatement ps=con.prepareStatement(query);
ps.setString(1,user.getUname());
ps.setString(2,user.getPassword());
ps.setString(3,user.getRole());
ps.setString(4,user.getStatus());
ps.executeUpdate();
ps.close();
con.close();

	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return false;
	
}

public boolean update(User user)
{
	return false;
	
}
public boolean delete(int uid)
{
	return false;
	
}

List<User>viewAll()
{
	return null;
	
}

public User select(String username,String password)
{
	ConnectionFactory con_factory = new ConnectionFactory();
boolean result = con_factory.connect();
Connection con = null;
if (result == true) {
	con = con_factory.getConnection();
}
System.out.println("++ ++ ++");
String query = "select *from user3 where uname=? AND password=?";
try {
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		
		User user=new User();
		while(rs.next())
		{
		user.setUid(rs.getInt("uid"));
		user.setUname(rs.getString("uname"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setStatus(rs.getString("status"));
		ps.close();
		con.close();
	
		return user;
	

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 return null;
}

}

	