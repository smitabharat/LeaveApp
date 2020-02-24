package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.bean.Leave;
import com.hefshine.bean.User;
import com.hefshine.dao.LeaveDAO;


public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Leave leave=new Leave();
		
		leave.setFromdate(request.getParameter("fromdate"));
		leave.setTodate(request.getParameter("todate"));
		leave.setLtype(request.getParameter("ltype"));
		leave.setReason(request.getParameter("reason"));
		leave.setApplied_date(LocalDate.now().toString());
		leave.setStatus("New");
		
		HttpSession session=request.getSession();
		User loggduser=(User)session.getAttribute("loggeduser");
		leave.setUid(loggduser.getUid());
		
		
		leave.setDescription(" ");
		
		PrintWriter pw=response.getWriter();
		pw.write(leave.toString());
	
		LeaveDAO leavedao=new LeaveDAO();
		leavedao.insert(leave);
	}

}
