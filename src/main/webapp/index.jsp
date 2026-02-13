<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/StudentServlet"
		method="post">
		<table>
			<tr>
				<td>UserId</td>
				<td><input type="text" name="userId" required /></td>
			</tr>
	

		</table>
		</form>

	<a href="RegistrationPage.jsp">Go to Assignment Registration Page</a>
</body>
</html>