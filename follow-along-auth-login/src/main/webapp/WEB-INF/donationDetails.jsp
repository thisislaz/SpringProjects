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
	
		<h1>Donation Details</h1>
		<h3>Donation: <c:out value=" ${ donation.donationName }" /></h3>
		<h3>Donation: ${ donation.quantity }</h3>	
		<h3>Donation: ${ donation.donor.userName}</h3>
	</div>
</body>
</html>