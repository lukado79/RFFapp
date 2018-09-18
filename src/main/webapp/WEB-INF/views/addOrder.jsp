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
<%@ include file="../parts/header.jspf"%>
<p></p>
	<h1>Add Order</h1>
	<div class="form-group">
		<form:form method="post" modelAttribute="order">
			<h4>Loading Address</h4>
			Company:<form:errors path="loadComp" />
			<form:input path="loadComp" />
			<br>
			Street:<form:errors path="loadStreet" />
			<form:input path="loadStreet" />
			City:<form:errors path="loadCity" />
			<form:input path="loadCity" />
			<br>
			Post Code:<form:errors path="loadPost" />
			<form:input path="loadPost" />
			Country:<form:errors path="loadCountry" />
			<form:input path="loadCountry" />
			<h4>Loading Date</h4>
			<br>
			<form:errors path="loadDate" />
			<form:input path="loadDate" />
			<h4>Unloading Address</h4>
			<br>
				Company:<form:errors path="unloadComp" />
			<form:input path="unloadComp" />
			<br>
				Street:<form:errors path="unloadStreet" />
			<form:input path="unloadStreet" />
				City:<form:errors path="unloadCity" />
			<form:input path="unloadCity" />
			<br>
				Post Code:<form:errors path="unloadPost" />
			<form:input path="unloadPost" />
				Country:<form:errors path="unloadCountry" />
			<form:input path="unloadCountry" />
			<h4>Unloading Date</h4>
			<br>
			<form:errors path="unloadDate" />
			<form:input path="unloadDate" /><br>
				Client Price:<form:errors path="clientPrice" />
			<form:input path="clientPrice" />
			<br>
				Carier Price:<form:errors path="carierPrice" />
			<form:input path="carierPrice" />
			<br>
							Remarks:<form:errors path="remarks" />
			<form:input path="remarks" />
			<br>
			
				Client:<form:select path="client.id" itemValue="id" itemLabel="name"
				items="${client}" />
			<br>
				Carier:<form:select path="carier.id" itemValue="id" itemLabel="name"
				items="${carrier}" />
			<br>
				Truck:<form:select path="truck.id" itemValue="id"
				itemLabel="plateNumber" items="${truck}" />
			<br>
				Order Status:<form:select path="status.id" itemValue="id"
				itemLabel="status" items="${orderStatus}" />
			<br>
				User:<form:select path="user.id" itemValue="id" itemLabel="lastName"
				items="${user}" /><br>




			<input class="btn btn-primary" type="submit" value="Save">
		</form:form>
	</div>



</body>
</html>