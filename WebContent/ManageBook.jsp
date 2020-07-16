<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./ManageBook" method="post"> 
        <p> id </p>
        <input type="number" name="id"/>
        <br>
        <p>book name:</p>  
        <!-- Create an element with mandatory name attribute, 
        so that data can be transfer to the servlet using getParameter() -->
        <input type="text" name="name"/> 
        <br/> 
        <p>Copies:</p>  
        <input type="number" name="copies"/> 
        <br/><br/><br/> 
        <input type="submit"/> 
    </form> 
</body>
</html>