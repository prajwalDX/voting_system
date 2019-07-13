<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="source.css">
<title>VOTING</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<center>
<div align="center">
<div class="head"><h2>WELCOME TO ONLINE VOTING PORTAL</h2></div>
<div class="head"><h2>LOGIN</h2></div>
<div class="login">
<div class="warning">
<% 
if(null!=request.getAttribute("valid"))
    {
	String	err = (String)request.getAttribute("valid");
	out.println(err);
    }
 %></div>
 <br />
<form  method="post" action="Login" >
<center>
USERNAME:    <input type="text" name="username" placeholder="username" />
<br />
<br />
PASSWORD:    <input type="password" name="password" placeholder="password" />
<br />
<br />
<input type="submit" value="LOGIN" />
</form>
<br />
<br />
<form action="register.jsp">
<input type="submit" value="REGISTER" name="register" />
</form>
</center>
</div>
</body>
</html>