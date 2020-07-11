<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h1>You have successfully logged-in</h1>
&nbsp;
<a href="./MyBooks">MyBooks</a>
&nbsp;
<a href="./Reserve">Reserve Book</a>
&nbsp;
<% if (request.isUserInRole("librarian")) { %>
   <a href = "./ManageBook">Manage Book</a>
   &nbsp;
<% } %>

<a href="logout.jsp" >Click to Logout </a> 