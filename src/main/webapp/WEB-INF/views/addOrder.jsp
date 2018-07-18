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
	<h1>Add Order</h1>
	<div class="form-group">
		<form:form method="post" modelAttribute="order">
			<h4>Loading Address</h4>
			Company:<form:errors path="loadComp" />
			<form:input path="loadComp" />
			Street:<form:errors path="loadStreet" />
			<form:input path="loadStreet" />
			City:<form:errors path="loadCity" />
			<form:input path="loadCity" />
			Post Code:<form:errors path="loadPost" />
			<form:input path="loadPost" />
			Country:<form:errors path="loadCountry" />
			<form:input path="loadCountry" />
			<h4>Loading Date</h4>
			<form:errors path="loadDate" />
			<form:input path="loadDate" />
			<h4>Unloading Address</h4>
			Company:<form:errors path="unloadComp" />
			<form:input path="unloadComp" />
			Street:<form:errors path="unloadStreet" />
			<form:input path="unloadStreet" />
			City:<form:errors path="unloadCity" />
			<form:input path="unloadCity" />
			Post Code:<form:errors path="unloadPost" />
			<form:input path="unloadPost" />
			Country:<form:errors path="unloadCountry" />
			<form:input path="unloadCountry" />
			<h4>Unloading Date</h4>
			<form:errors path="unloadDate" />
			<form:input path="unloadDate" />

			<input type="submit" value="Save">
		</form:form>
	</div>



</body>
</html>