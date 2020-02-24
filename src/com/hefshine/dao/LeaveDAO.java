package com.hefshine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hefshine.bean.Leave;
import com.hefshine.bean.User;
import com.hefshine.controller.ConnectionFactory;

public class LeaveDAO 
{

	public boolean insert(Leave leave)
	{
		ConnectionFactory con_factory=new ConnectionFactory();
		boolean result=con_factory.connect();
		Connection con=null;
		if(result==true)
		{
			con=con_factory.getConnection();
		}
		String query="insert into leaves(uid,ltype,applied_date,fromdate,todate,status,description,reason) values(?,?,?,?,?,?,?,?)";
				try
		{
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, leave.getUid());
	ps.setString(2, leave.getLtype());
	ps.setString(3, leave.getApplied_date());
	ps.setString(4, leave.getFromdate());
	ps.setString(5, leave.getTodate());
	ps.setString(6, leave.getStatus());
	ps.setString(7, leave.getDescription());
	ps.setString(8, leave.getReason());
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
public List<Leave> showAppliedLeaves()
{
	ConnectionFactory con_factory=new ConnectionFactory ();
	
	boolean result=con_factory.connect();
	Connection con=null;
	if(result==true)
	{
		con=con_factory.getConnection();
	}
	String query="select * from leaves";
	try
	{
		PreparedStatement ps=con.prepareStatement(query);
ResultSet rs=ps.executeQuery();
List<Leave> list_app_leaves=new ArrayList<Leave>();

while(rs.next())
{
	Leave leave=new Leave();
	leave.setLid(rs.getInt("lid"));
	
	leave.setUid(rs.getInt("uid"));
	
	leave.setLtype(rs.getString("ltype"));
	
	leave.setApplied_date(rs.getString("applied_date"));
	
	leave.setFromdate(rs.getString("fromdate"));
	
	leave.setTodate(rs.getString("todate"));
	
	leave.setStatus(rs.getString("status"));
	
	leave.setDescription(rs.getString("description"));
	
	leave.setReason(rs.getString("reason"));
	
	list_app_leaves.add(leave);
}
ps.close();
con.close();

return list_app_leaves;
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return null;
} 

public boolean updateAllStatus(HashMap<String, String> hm) throws SQLException
{
//	HashMap<String,String> entrymap=new HashMap<String,String>();
	ConnectionFactory con_factory=new ConnectionFactory();
	boolean result=con_factory.connect();
	Connection con=null;
	if(result==true)
	{
		con=con_factory.getConnection();
	}
	 
	PreparedStatement ps=null;
	for(Map.Entry<String,String>entrymap2:hm.entrySet())
	{
		int key=Integer.parseInt(entrymap2.getKey());
		String value=entrymap2.getValue();
		
		String query="update leaves set status=? where lid=?";
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, value);
			ps.setInt(2, key);
		    int t=ps.executeUpdate();
			System.out.println("----||||"+t);
			
			} catch (SQLException e) { e.printStackTrace(); }
   	}
	
	ps.close();
	con.close();
	return false;
}
	
public List<Leave> showEmpLeaves(int id)
{
	ConnectionFactory con_factory = new ConnectionFactory();
	boolean result = con_factory.connect();
	Connection con=null;

	if(result == true)
	{
		con=con_factory.getConnection();

	}

	String query= "select * from leaves where uid=?";

	System.out.println("query");

	PreparedStatement ptmt;
	try {
		ptmt = con.prepareStatement(query);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		List<Leave> list_app_leaves = new ArrayList<Leave>();



		while(rs.next())
		{
			Leave leave = new Leave();

			leave.setLid(rs.getInt("lid"));
			leave.setUid(rs.getInt("uid"));
			leave.setLtype(rs.getString("ltype"));
			leave.setApplied_date(rs.getString("applied_date"));
			leave.setFromdate(rs.getString("fromdate"));
			leave.setTodate(rs.getString("todate"));
			leave.setStatus(rs.getString("status"));
			leave.setDescription(rs.getString("description"));
			leave.setReason(rs.getString("reason"));

			list_app_leaves.add(leave);

		}


		ptmt.close(); 
		con.close();
		return list_app_leaves;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return null;


}

/*public List<Leave> employeedate(String fromdate,String todate)
{
	ConnectionFactory con_factory = new ConnectionFactory();
	boolean result = con_factory.connect();
	Connection con=null;

	if(result == true)
	{
		con=con_factory.getConnection();

	}

	String query= "select * from leaves where fromdate>=? and todate>=?";

	System.out.println("query");

	PreparedStatement ptmt;
	try {
		ptmt = con.prepareStatement(query);
		ptmt.setString(1, fromdate);
		ptmt.setString(1, todate);
		ResultSet rs = ptmt.executeQuery();
		List<Leave> list_app_leaves = new ArrayList<Leave>();



		while(rs.next())
		{
			Leave leave = new Leave();

			leave.setLid(rs.getInt("lid"));
			leave.setUid(rs.getInt("uid"));
			leave.setLtype(rs.getString("ltype"));
			leave.setApplied_date(rs.getString("applied_date"));
			leave.setFromdate(rs.getString("fromdate"));
			leave.setTodate(rs.getString("todate"));
			leave.setStatus(rs.getString("status"));
			leave.setDescription(rs.getString("description"));
			leave.setReason(rs.getString("reason"));

			list_app_leaves.add(leave);

		}


		ptmt.close(); 
		con.close();
		return list_app_leaves;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return null;

*/

}
