<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head><title></title>
  </head>
  <body>
        <h2>Login</h2>
        <form name="loginForm" method="POST" action="j_security_check">
            <p>User name: <input type="text" name="j_username" size="20"/></p>
            <p>Password: <input type="password" size="20" name="j_password"/></p>
            <p>  <input type="submit" value="Submit"/></p>
        </form>       
   </body>
</html> 