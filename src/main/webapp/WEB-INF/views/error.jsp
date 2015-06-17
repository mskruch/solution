<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<body>
	<h2><s:message code="error"/></h2>
	<div><s:message code="error.message"/>: ${errorId}</div>
</body>
</html>
