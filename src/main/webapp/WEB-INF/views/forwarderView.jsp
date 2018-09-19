<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/bootstrap.min.css">
</head>
<body>
	<%@ include file="../parts/header.jspf"%>
	<br>
	<br>
	<div>
		<h4>My Orders List</h4>

		<table class="table table-hover">
			<tr class="table-info">
				<td>Order ID</td>
				<td>Loading Company</td>
				<td>Loading Street</td>
				<td>Loading Post Code</td>
				<td>Loading City</td>
				<td>Loading Country</td>
				<td>Loading Date</td>
				<td>Unloading Company</td>
				<td>Unloading Street</td>
				<td>Unloading Post Code</td>
				<td>Unloading City</td>
				<td>Unloading Country</td>
				<td>Unloading Date</td>
				<td>Carrier</td>
				<td>Truck</td>
				<td>Remarks</td>
				<td>Client</td>
				<td>Client Price</td>
				<td>Carrier Price</td>
				<td>User</td>
				<td>Created</td>
				<td>Order Status</td>
			</tr>
			<c:forEach items="${orders}" var="ord">
				<tr class="table-light">
					<td>${ord.id}</td>
					<td>${ord.loadComp}</td>
					<td>${ord.loadStreet}</td>
					<td>${ord.loadPost}</td>
					<td>${ord.loadCity}</td>
					<td>${ord.loadCountry}</td>
					<td>${ord.loadDate}</td>
					<td>${ord.unloadComp}</td>
					<td>${ord.unloadStreet}</td>
					<td>${ord.unloadPost}</td>
					<td>${ord.unloadCity}</td>
					<td>${ord.unloadCountry}</td>
					<td>${ord.unloadDate}</td>
					<td>${ord.carier.name}</td>
					<td>${ord.truck.plateNumber}</td>
					<td>${ord.remarks}</td>
					<td>${ord.client.name}</td>
					<td>${ord.clientPrice}</td>
					<td>${ord.carierPrice}</td>
					<td>${ord.user.email}</td>
					<td>${ord.created}</td>
					<td>${ord.status.status}</td>
					<td><a href="<c:url   value="/order/edit/${ord.id}"/>">Edit</a>
					</td>

				</tr>
			</c:forEach>

		</table>
		<a class="btn btn-primary btn-lg" href="/RFFapp/order/all"
			role="button">All Orders</a> <a class="btn btn-primary btn-lg"
			href="/RFFapp/truck/all" role="button">All Trucks</a> <a
			class="btn btn-primary btn-lg" href="/RFFapp/stakeholder/all"
			role="button">All Stakeholders</a>

	</div>

</body>
</html>