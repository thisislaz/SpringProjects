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

	<h1>Dashboard</h1>
	<a href="/donations/add">Add a donation</a>
	<a href="/">Main page</a>
	<table>
		<thead>
			<tr>
				<th>Donation</th>
				<th>Quantity</th>
				<th>Donor</th>
				<th colspan="2">Actions</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="eachDonation" items="${ donationList }">
			
				<tr>
					<td><a href="/donations/${ eachDonation.id }"><c:out value="${ eachDonation.donationName }"></c:out></a></td>
					<td><c:out value="${ eachDonation.quantity }"></c:out></td>
					<td><c:out value="${ eachDonation.donor }"></c:out></td>
					<td><a href="/donations/edit/${ eachDonation.id }">Edit</a></td>
					<td>
						<form action="/donations/${ eachDonation.id }" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<button type="submit">Delete</button>
						</form>							
					</td>
				</tr>
			
			</c:forEach>	
		
		</tbody>
	</table>

</body>
</html>