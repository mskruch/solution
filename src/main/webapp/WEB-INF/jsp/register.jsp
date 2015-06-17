<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<h2>Registration form</h2>
	<form action="/" method="post">
		<label for="username">Name:</label>
		<input id="username" name="username" value="<c:out value="${username}"/>"/>

		<label for="password">Password:</label>
		<input id="password" type="password" name="password" />
		
		<input type="submit" value="Submit">
	</form>
</body>
</html>
