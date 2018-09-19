<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	<div>
		<a class="btn btn-primary btn-lg" href="/RFFapp/user/all" role="button">All Users</a>
		<a class="btn btn-primary btn-lg" href="/RFFapp/order/all" role="button">All Orders</a>
		<a class="btn btn-primary btn-lg" href="/RFFapp/truck/all" role="button">All Trucks</a>
		<a class="btn btn-primary btn-lg" href="/RFFapp/stakeholder/all" role="button">All Stakeholders</a>
		<a class="btn btn-primary btn-lg" href="/RFFapp/userRole/all" role="button">All User Roles</a>
		<a class="btn btn-primary btn-lg" href="/RFFapp/stakRole/all" role="button">All Stakeholder Roles</a>
		<a class="btn btn-primary btn-lg" href="/RFFapp/orderStatus/all" role="button">All Order Status</a>
	</div>
</body>
</html>