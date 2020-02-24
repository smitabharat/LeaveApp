<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="TaskServlet" method="post">
<div >
<label> User Id : </label>
<input type="text" name="userid"><br><br>
<label> Submit Date : </label>
<input type="date" name="submitdate"><br><br>
<label> Task : </label>
<input type="text" name="task"><br><br>
<input type="submit" value="Submit"> 
</div>
</form>
</body>
</html>