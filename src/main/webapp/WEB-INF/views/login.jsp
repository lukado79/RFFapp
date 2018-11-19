<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/bootstrap.min.css">
</head>
<body>

	<div class="alert alert-dismissible alert-primary">
		<h3>
			<a href="/RFFapp/home" class="alert-link">Back to home</a>
		</h3>
	</div>

	<div class="form-group">
		<form:form method="post" modelAttribute="user">
		
			Enter email:
			<form:input path="email" placeholder="Enter Email" />
			Password:
			<form:input type="password" path="password"
				placeholder="Enter Password" />

			<input type="submit" value="Login">
		</form:form>
	</div>
</body>
</html>