<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  

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
	
		<h1>Add Donation</h1>
		<form:form method="post" action="/donations/add" modelAttribute="donation">
			<div>
				<form:label path="donationName"> Donation</form:label>
				<form:input type="text" path="donationName" />
				<form:errors path="donationName" />
			</div>
			<div>
				<form:label path="quantity"> Quantity</form:label>
				<form:input type="number" path="quantity" />
				<form:errors path="quantity" />
			</div>
			<form:hidden path="donor" value="${ userId }"/>
				<button type="submit">Add</button>
		</form:form>
		
		</div>
</body>
</html>