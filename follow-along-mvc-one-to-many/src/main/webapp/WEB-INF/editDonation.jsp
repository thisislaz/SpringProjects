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

	<h1>Create a new donation</h1>
	<form:form action="/edit/donations/${ donation.id }" method="post"
		modelAttribute="donation">
		<input type="hidden" name="_method" value="put"/>
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
		<form:hidden path="donor" />
		
		
		
		<button type="submit">Add a new donation</button>
	</form:form>

</body>
</html>