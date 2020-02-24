package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hefshine.dao.LeaveDAO;

public class ProcessLeavesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		RequestDispatcher requestd=request.getRequestDispatcher("mgr-nav-bar.jsp");	
  		requestd.forward(request, response);
  		
  		Enumeration<String> enume=request.getParameterNames();
  		
  		HashMap<String,String> hashmap3=new HashMap<String,String>();
  		
  		while(enume.hasMoreElements())
  		{
  			String temp=enume.nextElement();
  			PrintWriter pw=response.getWriter();
  			pw.write(temp);
  			pw.write(":: "+request.getParameter(temp));
  			
  			String val=request.getParameter(temp);
  			hashmap3.put(temp, val);
  		}
  		
  		LeaveDAO ld=new LeaveDAO();
  		try {
  			ld.updateAllStatus(hashmap3);
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		
  		}

  	}


