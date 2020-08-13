<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
	<h2>User Registration :</h2>

	<form action="registerUser" method="post">
		<pre>
		<label>First Name : </label><br>
		<input type="text" name="firstName" /><br>
		
		<label>Last Name : </label><br>
		<input type="text" name="lastName" /><br>
		
		<label>Email : </label><br>
		<input type="text" name="email" /><br>
		
		<label>Password : </label><br>
		<input type="password" name="password" /><br>
		
		<input type="submit" value="Register" />
		
		</pre>
	</form>
	<br>
	<a href="login">Login</a>
</body>
</html>