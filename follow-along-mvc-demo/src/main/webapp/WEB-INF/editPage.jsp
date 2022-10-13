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

	<h1>Edit a donation</h1>
	<a href="/donations">Go back</a>
	<a href="/">Dashboard</a>
	
		<form:form action="/donations/edit/${ donation.id }" method="post" modelAttribute="donation">
			<!-- no need to add form input for hidden method because it is not in the model -->
			<input type="hidden" name="_method" value="put" />
			<div>
				<form:label path="donationName">Donation</form:label>
				<form:input type="text" path="donationName" />
				<form:errors class="d-block" path="donationName"/>
			</div>	
			<div>
				<form:label path="quantity">Quantity</form:label>
				<form:input type="number" path="quantity" />
				<form:errors path="quantity"/>
			</div>	
			<div>
				<form:label path="donor">Donor</form:label>
				<form:input type="text" path="donor" />
				<form:errors path="donor"/>
			</div>
			<button type="submit">Add</button>	
		</form:form>

</body>
</html>