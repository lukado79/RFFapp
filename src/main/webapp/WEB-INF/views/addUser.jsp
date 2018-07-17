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
	<h1>Add new User</h1>

	<div class="form-group">
		<form:form method="post" modelAttribute="user">
			First Name:<form:errors path="firstName" />
			<form:input path="firstName" />
			Last Name:<form:errors path="lastName" />
			<form:input path="lastName" />
			Email:<form:errors path="email" />
			<form:input path="email" />
			Password:<form:input path="password"/>
			Enabled:<form:input path="enabled"/>
			Role:<form:select path="userRole.id" itemValue="id" itemLabel="roleName"
				items="${userRole}" />
			<input type="submit" value="Save">
		</form:form>
	</div>
</body>
</html>