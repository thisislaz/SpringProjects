<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Java Class</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>

	<h1>User Details</h1>
	<h3>Username: <c:out value="${ user.username }"></c:out></h3>
	<h3>Email: <c:out value="${ user.email }"></c:out></h3>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Donation</th>
				<th>Quantity</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="eachDonation" items="${ user.donations }">
				<tr>
					<td><c:out value="${ eachDonation.id }"></c:out></td>
					<td><c:out value="${ eachDonation.donationName }"></c:out></td>
					<td><c:out value="${ eachDonation.quantity }"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>