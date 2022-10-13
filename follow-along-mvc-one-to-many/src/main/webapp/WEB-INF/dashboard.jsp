<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Donation Board</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>

	<h1>Donation Dashboard</h1>
	<a href="/add/users"> Add a new user</a> |
	<a href="/add/donations"> Add a new donation</a>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Donation</th>
				<th>Quantity</th>
				<th>Donor</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="eachDonation" items="${ donationList }">
				<tr>
					<td><c:out value="${ eachDonation.id }"></c:out></td>
					<td><c:out value="${ eachDonation.donationName }"></c:out></td>
					<td><c:out value="${ eachDonation.quantity }"></c:out></td>
					<td><c:out value="${ eachDonation.donor.username }"></c:out></td>
					<td><a href="/edit/donations/${ eachDonation.id }">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1>User Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>Email</th>
				<th>Total Donations</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="eachUser" items="${ userList }">
				<tr>
					<td><c:out value="${ eachUser.id }"></c:out></td>
					<td><a href="/users/${ eachUser.id }"><c:out value="${ eachUser.username }"></c:out></a></td>
					<td><c:out value="${ eachUser.email }"></c:out></td>
					<td><c:out value="${ eachUser.donations.size()}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	
</body>
</html>


