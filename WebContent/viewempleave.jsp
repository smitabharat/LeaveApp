<%@page import="com.hefshine.bean.Leave"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hefshine.dao.LeaveDAO"%>
<%@page import="com.hefshine.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
div
{
  margin-top: 5%;
  font-style: italic;
  font-size: x-large;
}
table {
	background-color: activeborder;
	height: 10mm;
	width: 300mm
}


</style>


<body>

<div id="i1">
<hr>
<a href="emp-nav-bar.jsp"> Home </a>&nbsp; &nbsp; | &nbsp;&nbsp;
<a href="applyleave.html"> Apply Leave </a>&nbsp; &nbsp; | &nbsp;&nbsp;
<a > View Applied leave</a>&nbsp; &nbsp; | &nbsp;&nbsp;
<a href="logout.jsp"> Log-out </a>&nbsp; &nbsp; | &nbsp;&nbsp;
<hr>
</div>

<form >
<%
User user = new User();
user =(User)session.getAttribute("loggeduser");
 int id=user.getUid();
 LeaveDAO leaveDao = new LeaveDAO();
 
	ArrayList<Leave> leaves = (ArrayList<Leave>) leaveDao.showEmpLeaves(id);

	out.write("<br><br><br>");
	out.write("<table name=\"list\" border=\"1\" align=\"center\">");
	out.write("<tr style='color: lime;'>");
	out.write("<td align=\"center\">Leave Id</td>");
	out.write("<td align=\"center\">Leave Type</td>");
	out.write("<td align=\"center\">Applied Date</td>");
	out.write("<td align=\"center\">From Date</td>");
	out.write("<td align=\"center\">To Date</td>");
	out.write("<td align=\"center\">Leave Status</td>");
	out.write("<td align=\"center\">Reason</td>");
	//out.write("<td align=\"center\">Action</td>");
	out.write("</tr>");

	for (Leave leave : leaves) {
		out.write("<tbody>");
		out.write("<tr>");
		out.write("<td align=\"left\">" + leave.getLid() + "</td>");
		out.write("<td align=\"left\">" + leave.getLtype() + "</td>");
		out.write("<td align=\"left\">" + leave.getApplied_date() + "</td>");
		out.write("<td align=\"left\">" + leave.getFromdate() + "</td>");
		out.write("<td align=\"left\">" + leave.getTodate() + "</td>");
		out.write("<td align=\"left\">" + leave.getStatus() + "</td>");
		out.write("<td align=\"left\">" + leave.getReason() + "</td>");

		/*int leaveid = leave.getLid();
		out.write("<td align=\"left\">");
		out.write("<select name=" + leaveid + ">");
		out.write("<option value='approve'>Approve</option>");
		out.write("<option value='reject'>Reject</option>");
		out.write("<option value='pending'>Pending</option>");
		out.write("</select>");
		*/
		 out.write("</td>");

		out.write("</tr>");
		out.write("</tbody>");
	}
	out.write("</table>");
	out.write("<br>");
	
%>
</form>
</body>
</html>