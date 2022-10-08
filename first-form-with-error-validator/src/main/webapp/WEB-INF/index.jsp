<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html >
<head>
	<meta charset="ISO-8859-1">
	<title>Java Class</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-dark text-white">
	
	
	<div class="d-block p-2 bd-highlight" >
		<h1 class="container">login</h1>
		<p><c:out value="${ error }"></c:out></p>
		<form class="d-block p-2 bd-highlight" action="/login" method="POST">
			<label>Email: </label>
			<input type="text" name="email" />
			<label>Password:</label>
			<input type="password" name="password"/>
			<input type="submit" value="log in" />
		</form>
	</div>

</body>
</html>