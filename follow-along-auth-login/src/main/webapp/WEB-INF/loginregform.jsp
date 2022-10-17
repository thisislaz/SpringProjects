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

		<h1>Register</h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<div class="form-group">
				<form:label path="userName"> User Name:</form:label>
				<form:input type="text" path="userName" class="form-control" />
				<form:errors path="userName" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="email"> Email: </form:label>
				<form:input type="text" path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="password"> Password:</form:label>
				<form:input type="password" path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="confirm">Confirm Password:</form:label>
				<form:input type="password" path="confirm" class="form-control" />
				<form:errors path="confirm" class="text-danger" />
			</div>
			<input type="submit" value="Register" class="btn btn-primary" />
		</form:form>

		<h1>Login</h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div class="form-group">
				<label for="email">Email</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<form:input type="password" path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<input type="submit" value="Login" class="btn btn-primary" />
		</form:form>

	</div>
</body>
</html>