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
<title>Java Class</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/js/app.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
</head>
<body>


	<div class="container mt-5">
	
	<h1>Main Page</h1>
	<a href="/donations">Dashboard</a>
		<table class="table table-striped table-dark">
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
						<td><a href="/donations/${ eachDonation.id }"><c:out
									value="${ eachDonation.donationName }"></c:out></a></td>
						<td><c:out value="${ eachDonation.quantity }"></c:out></td>
						<td><c:out value="${ eachDonation.donor }"></c:out></td>
						<td><a class="btn btn-success"
							href="/donations/edit/${ eachDonation.id }">Edit</a></td>
						<td>
							<form action="/donations/${ eachDonation.id }" method="post">
								<input type="hidden" name="_method" value="delete" />
								<button class="btn btn-danger" type="submit">Delete</button>
							</form>
						</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
		<h1>Add a donation</h1>
		<form:form class="form" action="/" method="post" modelAttribute="donation">
			<div>
				<form:label path="donationName">Donation</form:label>
				<form:input type="text" path="donationName" class="form-control"/>
				<form:errors class="d-block" path="donationName" />
			</div>
			<div>
				<form:label path="quantity">Quantity</form:label>
				<form:input type="number" path="quantity" class="form-control"/>
				<form:errors path="quantity" />
			</div>
			<div>
				<form:label path="donor">Donor</form:label>
				<form:input type="text" path="donor" class="form-control" />
				<form:errors path="donor" />
			</div>
			<button class="btn btn-primary" type="submit">Add</button>
		</form:form>

	</div>


</body>
</html>