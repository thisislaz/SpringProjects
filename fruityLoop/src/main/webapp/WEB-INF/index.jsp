<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Java Class</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		
		<h1>Fruit Store</h1>
		<table class="table table-striped table-dark table-bordered">
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="eachFruit" items="${ fruits }">
					<tr>
						<td><c:out value="${ eachFruit.name}"></c:out></td>
						<td><c:out value="${ eachFruit.price }"></c:out></td>
					</tr>				
				</c:forEach>
				
			</tbody>
		</table>
		
	</div>

</body>
</html>