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
	<h4>Edit Truck</h4>
	<div class="form-group">
		<form:form method="post" modelAttribute="truck">
					Truck Number:<form:errors path="plateNumber" />
			<form:input path="plateNumber" />
			<br>
			<input class="btn btn-primary" type="submit" value="Save" />

		</form:form>
	</div>

</body>
</html>