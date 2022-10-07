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
<body>

	<h1>JSTL Demo</h1>
	<h3>Displaying variables</h3>
	<p><c:out value="${ jspName }"></c:out></p>
	<p><c:out value="${ jspAge }"></c:out></p>
	<p><c:out value="${ jspIsHungry }"></c:out></p>
	
	<h3>If-statement</h3>
	<c:if test="${ jspIsHungry }">
		<p>${ jspName } is hungry</p>
	</c:if>
	
	<h3>if-else statement</h3>
	<c:choose>							
		<c:when test="${ jspAge < 21 }"> 
			<p>He is under age!</p>		 
		</c:when>						
		<c:otherwise>					
			<p>He is over 21.</p>		
		</c:otherwise>					
	</c:choose>
	
	<h3>for each</h3>
	<ul>
		<c:forEach var="eachUser" items="${ jspUsers }">
			
			<li><c:out value="${ eachUser }"></c:out></li>
			
		</c:forEach>
	</ul>
	
	
</body>
</html>