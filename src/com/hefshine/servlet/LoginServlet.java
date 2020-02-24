package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.bean.User;
import com.hefshine.dao.UserDAO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String un=request.getParameter("uname");
		String pass=request.getParameter("password");
        System.out.println(un);
        System.out.println(pass);
		UserDAO ud=new UserDAO();
		User loggeduser=null;
		loggeduser=	ud.select(un, pass);
	
		PrintWriter pw=response.getWriter();
        HttpSession session=request.getSession();
        session.setAttribute("loggeduser", loggeduser);
		if(loggeduser==null)
		{
			response.sendRedirect("login.html");
		}
        
		RequestDispatcher rd;
		String roleChoice=loggeduser.getRole();
		
		switch(roleChoice)
		{
		case "employee": 
			rd=request.getRequestDispatcher("emp-nav-bar.jsp");
			rd.include(request, response);
			break;
		case "Manager" :  
			rd=request.getRequestDispatcher("mgr-nav-bar.jsp");
			rd.include(request, response);
			break;
		
		case "manager" :  
			rd=request.getRequestDispatcher("mgr-nav-bar.jsp");
			rd.include(request, response);
			break;
			
		case "Director" :  
			rd=request.getRequestDispatcher("");
			rd.include(request, response);
			break;
		}
			}

}

	