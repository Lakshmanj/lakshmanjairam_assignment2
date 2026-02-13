<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

	<style>
		body {
			font-family: Arial, sans-serif;
		}
		input {
			background-color: #f0f8ff; /* Light AliceBlue */
			font-size: 14px;
			font-family: Arial, sans-serif;
			border: 1px solid #ccc;
			padding: 5px;
			width: 200px;
		}
		table {
			background-color: #ffe4e1; /* MistyRose */
			border: 2px solid #ff69b4; /* HotPink border */
			padding: 10px;
			border-radius: 10px;
		}
		input[type="submit"] {
			background-color: lightblue;
			font-weight: bold;
			cursor: pointer;
			width: 100px;
			margin-top: 10px;
		}
	</style>
</head>
<body>

<div align="center">
	<img src="https://cdn.imgbin.com/17/12/13/imgbin-logo-font-textiles-BcFYXjMu7PTVwF6FGN9wstQP6.jpg" alt="Logo" width="50" height="50" />
</div>
	<div align="left">
		<h1>Registration Page</h1>

		<!-- form action ="StudentServlet" method="post"> -->
		<form action="<%=request.getContextPath()%>/RegisterServlet"
			method="post">
			<table style="width: 20%; border-spacing: 10px">
<%--				<tr>--%>
<%--					<td>First Name</td>--%>
<%--					<td><input type="text" name="firstName" required /></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<td>Last Name</td>--%>
<%--					<td><input type="text" name="lastName" required /></td>--%>
<%--				</tr>--%>
				<tr>
					<td><b>UserName</b></td>
					<td><input
							type="text"
							name="username"
							maxlength="10"
							title="Username must not be blank and must not exceed 10 characters"
							required /></td>
				</tr>

				<tr>
					<td><b>Password</b></td>
					<td><input
							type="password"
							name="password"
							maxlength="10"
							pattern="[A-Za-z0-9$_]+"
							title="Password must not exceed 10 characters and can only contain letters, digits, and $ and _"
							required />
				</tr>

				<tr>
					<td><b>ReType Password</b></td>
					<td><input
							type="password"
							name="repassword"
							maxlength="10"
							pattern="[A-Za-z0-9$_]+"
							title="Please re-enter your password"
							required /></td>
				</tr>

				<tr>
					<td><b>Mobile Number</b></td>
					<td><input
							type="text"
							name="mobileNumber"
							pattern="[0-9]{10}"
							title="Phone number must be exactly 10 digits long"
							required />
				</tr>

				<tr>
					<td><b>Email Id</b></td>
					<td><input
							type="email"
							name="email"
							title="Please enter a valid email address"
							required /></td>
				</tr>

			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>

</body>
</html>