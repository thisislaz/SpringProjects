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

	<h1>Create a new user</h1>
	<form:form action="/add/users" method="post" modelAttribute="user">
		<div>
			<form:label path="username"> Username</form:label>
			<form:input type="text" path="username"/>
			<form:errors path="username"/>
		</div>
		<div>
			<form:label path="email"> Email</form:label>
			<form:input type="text" path="email"/>
			<form:errors path="email"/>
		</div>
		<button type="submit">Add a new user</button>
	</form:form>
</body>
</html>