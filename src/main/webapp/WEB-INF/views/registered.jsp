<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<body>
	<h2><s:message code="success"/></h2>
	<div><s:message code="registered"/></div>
	
	<s:url value="/registration" var="url"></s:url>
	<a href="${url}"><s:message code="registration"/> </a>
</body>
</html>
