<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<h2>${messages['success']}</h2>
	<div>${messages['registered']}: <c:out value="${username}"/></div>
</body>
</html>
