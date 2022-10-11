<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

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

	<h1>New Book</h1>
	<form:form action="/books" method="POST" modelAttribute="book">
		<div >
			<form:label class="d-block" path="title">Title</form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input type="text" path="title" />
		</div>
		<div>
			<form:label class="d-block" path="description">Description</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description" id="" cols="30" rows="5"></form:textarea>
		</div>
		<div>
			<form:label class="d-block" path="language">Language</form:label>
			<form:errors path="language" class="text-danger"/>
			<form:input type="text" path="language" />
		</div>
		<div>
			<form:label class="d-block" path="numberOfPages">Number of pages</form:label>
			<form:errors path="numberOfPages" class="text-danger"/>
			<form:input type="text" path="numberOfPages" />
		</div>
		<input class="btn btn-success" type="submit" value="Submit"/>
	</form:form>
</body>
</html>