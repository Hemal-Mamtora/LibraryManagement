<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<form action="./Register" method="post">
		<p>
			<label>Name</label><br>
			<input type="text" name="name" id="name">
		</p>
		<p>
			<label>Username</label><br>
			<input type="text" name="username" id ="username">
		</p>
		<p>
			<label>Password</label><br>
			<input type="password" name="password1" id="password1">
		</p>
		<p>
			<label>Confirm Password</label><br>
			<input type="password" name="password2" id="password2">
		</p>
		<p>
			<label>
				<input type="checkbox" name="isLibrarian" value="true">
				Is Libarian
			</label>
		</p>
		<p>
    		<button type="submit">Sign up</button>
    		<button type="reset">Reset form</button>
  		</p>
	</form>
</body>
</html>