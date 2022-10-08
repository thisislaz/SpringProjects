<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

	<h1>Reservation Details</h1>
	<h4>Name: <c:out value="${ name }"></c:out></h4>
	<h4>Reservation Date: <fmt:formatDate type="date" pattern="MMMM dd yyyy" value="${resDate}"/></h4>
	<h4>Reservation Time: <fmt:formatDate type="time" value="${resTime}"/></h4>
	
</body>
</html>