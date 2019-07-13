<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="source.css">
<title>VOTING</title>

</head>
<body>
<center>
<div align="center">

<div class="head"><h2>WELCOME TO ONLINE VOTING PORTAL</h2></div>
<div class="head"><h3>


<%   
String value = (String) session.getAttribute("unames"); 
%>

USER: <%= value %>

</h3>
</div>
<div class="warning">
<p>
!select the candidate to vote.
you can only vote once.!
</p>
</div>
<div class="login">
<div class="warning">
<% 
if(null!=request.getAttribute("statusmsg"))
    {
	String	err = (String)request.getAttribute("statusmsg");
	out.println(err);
    }
 %>
 </div>
<div style="font-size:35px; margin-top:-70px">
<form method="post" action="Vote" >
<table>
<tr><td>
Mark:
</td><td>
<input type="radio" value="mark" name="radio1" id="radio1" /><br />
</td></tr>
<tr><td>
Jeff:
</td><td>
<input type="radio" value="jeff" name="radio1" id="radio1" /><br />
</td></tr>
<tr><td>
Tim:
</td><td>
<input type="radio" value="tim" name="radio1" id="radio1" /><br />
</td></tr>
<tr><td>
Bill:
</td><td>
<input type="radio" value="bill" name="radio1" id="radio1" /><br />
</td></tr>
<br />
<br />
</table>
<input type="submit" value="SUBMIT" " />
<input type="hidden" name="usname" value="<%= value %>">
</form>

<form action='index.jsp'>
<input type="submit" value="LOGOUT" name="logout"  />
</form>

<form method="post" action='Results'>
<input type="submit" value="RESULTS" name="results"  />
</form>
</div>

</center>
</body>
</html>