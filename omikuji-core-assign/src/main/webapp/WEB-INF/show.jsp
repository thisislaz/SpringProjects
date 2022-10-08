<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

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
<body id="main-stuff" class="bg-dark text-white">
		<h1>Here's Your omikuji!!</h1>
		
		<div id="center-text" class="col-3">
			<p>In <c:out value="${ numberYears }"></c:out> years, you will live in <span><c:out value="${ city }"></c:out></span> with <span><c:out value="${ person }"></c:out></span> 
			as your roommate,<span><c:out value="${ hobby}"></c:out></span> for a living. The next time you see a <span><c:out value="${ thing }"></c:out></span>,
			you will have good luck. Also, <span><c:out value="${ nice }"></c:out></span>.</p>
		</div>
		<a href="/">Go Back</a>

</body>
</html>