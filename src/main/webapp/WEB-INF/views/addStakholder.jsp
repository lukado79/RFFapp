<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/bootstrap.min.css">
</head>
<body>
	<h1>Add Stakeholder</h1>
	<div class="form-group">
		<form:form method="post" modelAttribute="stakeholder">
			Name:<form:errors path="name" />
			<form:input path="name" />
			Street:<form:errors path="street" />
			<form:input path="street" />
			City:<form:errors path="city" />
			<form:input path="city" />
			Post Code:<form:errors path="post" />
			<form:input path="post" />
			Country:<form:errors path="country" />
			<form:input path="country" />
			Email:<form:errors path="email" />
			<form:input path="email" />
			Role:<form:errors path="stakeRole.id"/>
			<form:select path="stakeRole.id" itemValue="id"
				itemLabel="roleName" items="${stakRole}" />
			<input type="submit" value="Save">
		</form:form>
	</div>

</body>
</html>