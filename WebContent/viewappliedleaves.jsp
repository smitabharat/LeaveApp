<%@page import="com.hefshine.bean.User"%>
<%@page import="com.hefshine.bean.Leave"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hefshine.dao.LeaveDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
body
{
background-color: purple;
font-weight: bold;

left: 30px
 
}
table
{
background-color:orange;
width:280px;
height:180px;
}
table
</style>

<form action="ProcessLeavesServlet" method="post">
<% 
User user1=null;
 user1=(User)session.getAttribute("loggeduser");
 
if(!user1.getRole().equalsIgnoreCase("Manager"))
	response.sendRedirect("login.html");
LeaveDAO leaveDao=new LeaveDAO();

ArrayList<Leave> leaves= (ArrayList<Leave>) leaveDao.showAppliedLeaves();

out.write("<table name=\"list\"border=\"1\" align=\"center\">");
out.write("<tr>");

out.write("<td align=\"center\">Leave Type</td>");

out.write("<td align=\"center\">Applied Date</td>");

out.write("<td align=\"center\">From Date</td>");

out.write("<td align=\"center\">To Date</td>");

out.write("<td align=\"center\">Leave Status</td>");

out.write("<td align=\"center\">Reason</td>");

out.write("<td align=\"center\">Action</td>");


out.write("</tr>");

out.write("");

for(Leave leave : leaves)
{
	out.write("<tr>");
	out.write("<td align=\"left\">"+leave.getLtype()+"</td>");
	out.write("<td align=\"left\">"+leave.getApplied_date()+"</td>");
	out.write("<td align=\"left\">"+leave.getFromdate()+"</td>");
	out.write("<td align=\"left\">"+leave.getTodate()+"</td>");
	out.write("<td align=\"left\">"+leave.getStatus()+"</td>");
	out.write("<td align=\"left\">"+leave.getReason()+"</td>");
	int leaveid=leave.getLid();
	out.write("<td><select name="+leaveid+">");
	
	out.write("<option value=\"Approve\">Approve</option>");
	out.write(leaveid);
	out.write("<option value=\"Reject\">Reject</option>");
	
	out.write("<option value=\"Pending\">Pending</option>");
	
	out.write("</tr>");
   out.write("<br>");
}out.write("</table>");
out.write("<input type=\"submit\" value=\"submit\">");
 
%>
</form>
</body>
</html>