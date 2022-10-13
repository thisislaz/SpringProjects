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

	<h1>Details</h1>
	<a href="/donations">Go back</a>
	<a href="/">Dashboard</a>
	<h3>Donation: <c:out value="${ oneDonation.donationName }"></c:out></h3>
	<h3>Quantity: <c:out value="${ oneDonation.quantity }"></c:out></h3>
	<h3>Donor: <c:out value="${ oneDonation.donor }"></c:out></h3>
	<h3>Created at: <c:out value="${ oneDonation.createdAt }"></c:out></h3>

</body>
</html>