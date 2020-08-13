<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<h2>User Login :</h2>

	<form action="login" method="post">
		<pre>
		<label>Email : </label><br> 
		<input type="text" name="email" /><br>

		<label>Password : </label><br> 
		<input type="password" name="password" /><br> 
			
		<input type="submit" value="Login" />
		</pre>
	</form>
<h3 style="color: red">${msg}</h3>

</body>
</html>