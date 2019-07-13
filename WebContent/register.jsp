<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VOTING</title>
<link rel="stylesheet" href="source.css">
</head>
<body>
<center>
<div align="center">
<div class="head"><h2>REGISTER</h2></div>
<div class="login">
<div class="warning">
<% 
if(null!=request.getAttribute("errmsg"))
    {
	String	err = (String)request.getAttribute("errmsg");
	out.println(err);
    }
 %></div>
 <br />
<form method="GET" action="Register">
<center>
USERNAME:    <input type="text" name="username" placeholder="username" />
<br />
<br />
PASSWORD:    <input type="password" name="password" placeholder="password" />
<br />
<br />
<input type="submit" value="SUBMIT" /></center>
</form>
<br />
<form action='index.jsp'>
<input type="submit" value="LOGIN" name="login" />
</form>


</center>
</div>
</body>
</html>