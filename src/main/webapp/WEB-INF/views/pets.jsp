<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<body>
	<h2>
		<s:message code="pets"></s:message>
	</h2>

	<sf:form modelAttribute="petsForm" method="POST" role="form">

		<div>
			<sf:label path="username">
				<s:message code="name" />:</sf:label>
			<sf:input path="username" />
			<sf:errors path="username" />
		</div>
		<div>
			<sf:label path="petName">
				<s:message code="petName" />:</sf:label>
			<sf:input path="petName" />
			<sf:errors path="petName" />
		</div>

		<sf:button>
			<s:message code="submit" />
		</sf:button>

	</sf:form>
</body>
</html>
