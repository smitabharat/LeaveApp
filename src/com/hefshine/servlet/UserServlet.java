package com.hefshine.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hefshine.bean.User;
import com.hefshine.dao.UserDAO;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserServlet() {
        super();
            }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session=request.getSession();
		User user1=(User)session.getAttribute("loggeduser");
		if(!user1.getRole().equalsIgnoreCase("Manager"))
			response.sendRedirect("login.html");
		User user=new User();	
	user.setUname(request.getParameter("uname"));
	user.setPassword(request.getParameter("password"));
	user.setRole(request.getParameter("role"));
	user.setStatus(request.getParameter("status"));
	
	
	PrintWriter pw=response.getWriter();
	UserDAO userDAO=new UserDAO();
	userDAO.insert(user);
	pw.write(user.toString());
	pw.write("<h1>"+user.getUname()+"is added successfully...\"</h1>");
	
	
			 
		
	}

}
