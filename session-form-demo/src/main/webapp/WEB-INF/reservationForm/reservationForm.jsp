<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<form action="/processReservation" method="POST">
		<div>
			<label for="">Name</label>
			<input type="text" name="name"/>
		</div>
		<div>
			<label for="">Number of people</label>
			<input type="number" name="numOfPeople"/>
		</div>
		<div>
			<label for="">Reservation Date (2022-08-17)</label>
			<input type="date" name="resDate"/>
		</div>
		<div>
			<label for="">Reservation Time (17:45)</label>
			<input type="time" name="resTime"/>
		</div>
		<button type="submit">Reserve!</button>
	</form>

</body>
</html>