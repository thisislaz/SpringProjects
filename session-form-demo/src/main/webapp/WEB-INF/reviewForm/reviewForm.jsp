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

	<h1>Review Form</h1>
	<form action="/process" method="post">
	<input type="hidden" name="reviewer" value="Alex Miller" />
		<div>
			<label>Product</label>
			<input type="text" name="product" />
		</div>
		<div>
			<label > Comments</label>
			<textarea name="comments"></textarea>
		</div>
		<div>
			<label > Rating</label>
			<input type="number" name="rating" />
			<p><c:out value="${error }"></c:out></p>
		</div>
		<button type="submit">Submit your review</button>
	</form>
</body>
</html>