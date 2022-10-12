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

	<div>
		<h1 class="d-inline-block" >Expense Details</h1>
		<a  href="/expenses">Go back</a>
	</div>	
	<div>
		<h3>Expense Name: <c:out value="${ expense.expenseName }"></c:out></h3>
		<h3>Expense Description: <c:out value="${ expense.description }"></c:out></h3>
		<h3>Vendor: <c:out value="${ expense.vendor }"></c:out></h3>
		<h3>Amount spent: <c:out value="$ ${ expense.amount }"></c:out></h3>
	</div>

</body>
</html>