package com.hefshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hefshine.bean.Task;
import com.hefshine.controller.ConnectionFactory;


public class TaskDao 
{
	
	
	public boolean insert(Task task)
	{
		ConnectionFactory con_factory= new ConnectionFactory();
		boolean result=con_factory.connect();
		Connection con = null;
		if(result == true)
		{
			con = con_factory.getConnection();
		}

		String query="insert into tasks(uid,applieddate,submitdate,status,task,managerid) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ptmt =con.prepareStatement(query);
			ptmt.setInt(1, task.getUid());
			ptmt.setString(2, task.getCurrentdate());
			ptmt.setString(3, task.getSubmitdate());
			ptmt.setString(4, task.getStatus());
			ptmt.setString(5, task.getTask());
			ptmt.setInt(6, task.getManagerid());
			ptmt.executeUpdate();

			ptmt.close();
			con.close();




		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;
	}

/************************************************************************************/

}
