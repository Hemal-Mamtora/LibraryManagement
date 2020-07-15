<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>You have successfully logged-in</h1>
&nbsp;
<a href="./MyBooks">MyBooks</a>
&nbsp;
<a href="./Reserve">Reserve Book</a>
&nbsp;
<%
library.Person user = (library.Person)session.getAttribute("LoggedInUser");
//System.out.println(user.getUsername()+user.isLibrarian());
if(user != null && user.isLibrarian()){
%>
   <a href = "./ManageBook">Manage Book</a>
   &nbsp;
<% } %>

<a href="./Logout" >Click to Logout </a> 
</body>
</html>