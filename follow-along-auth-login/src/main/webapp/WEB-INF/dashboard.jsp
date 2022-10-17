<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/js/app.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<h1>Donation Dashboard</h1>
		<a href="/logout">Logout</a> <a href="/donations/add">Add donation</a>
		<table>
			<thead>
				<tr>
					<th>Donation</th>
					<th>Quantity</th>
					<th>Donor</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachDonation" items="${ donationList }">
					<tr>
						<td><a href="/donations/${ eachDonation.id }">${ eachDonation.donationName }</a></td>
						<td> ${ eachDonation.quantity }</td>
						<td> ${ eachDonation.donor.userName } </td>
						
						<c:if test="${userId.equals(eachDonation.donor.id)}">
						
							<td><a href="/donations/edit/${ eachDonation.id }">Edit</a></td>
							<td>
								<form method="post" action="/donations/delete/${ eachDonation.id }">
									<input type="hidden" name="_method" value="delete" />
									<button type="submit">Delete</button>
								</form>
							</td>
						
						</c:if>
					
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>