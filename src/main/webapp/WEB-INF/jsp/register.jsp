<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<h2>${messages['registration']}</h2>
	<form action="/" method="post">
		<label for="username">${messages['name']}:</label>
		<input id="username" name="username" value="<c:out value="${username}"/>"/>

		<label for="password">${messages['password']}:</label>
		<input id="password" type="password" name="password" />
		
		<input type="submit" value="${messages['submit']}">
	</form>
</body>
</html>
