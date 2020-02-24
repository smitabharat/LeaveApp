package com.hefshine.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.bean.Task;
import com.hefshine.bean.User;
import com.hefshine.dao.TaskDao;

public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("taskServlet");
		
		HttpSession session= request.getSession();
		User loggeduser = (User)session.getAttribute("loggeduser");
		Task task = new Task();
		
		System.out.println("taskServlet");
		int uid = Integer.parseInt(request.getParameter("userid"));
		task.setUid(uid);
		task.setManagerid(loggeduser.getUid());
		task.setCurrentdate((LocalDate.now().toString()));
		task.setSubmitdate(request.getParameter("submitdate"));
		task.setStatus("New");
		task.setTask(request.getParameter("task"));
	
		TaskDao dao = new TaskDao();
		dao.insert(task);
		System.out.println(task.toString());
		
		
	}

}
