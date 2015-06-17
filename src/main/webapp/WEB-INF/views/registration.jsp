<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<body>
	<h2>
		<s:message code="registration"></s:message>
	</h2>

	<sf:form modelAttribute="registrationForm" method="POST" role="form">

		<div>
			<sf:label path="username">
				<s:message code="name" />:</sf:label>
			<sf:input path="username" />
			<sf:errors path="username" />
		</div>
		<div>
			<sf:label path="password">
				<s:message code="password" />:</sf:label>
			<sf:password path="password" />
			<sf:errors path="password" />
		</div>

		<sf:button>
			<s:message code="submit" />
		</sf:button>

	</sf:form>
</body>
</html>
